package com.upiiz.ejercicio3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.upiiz.ejercicio3.models.CarreraModel;
import com.upiiz.ejercicio3.models.UsuarioModel;
import com.upiiz.ejercicio3.services.CarreraServices;
import com.upiiz.ejercicio3.services.UsuarioServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    // Servicios para usuarios y carreras
    private final UsuarioServices usuarioServices = new UsuarioServices();
    private final CarreraServices carreraServices = new CarreraServices();

    // =======================================
    // Rutas para agregar carreras
    // =======================================

    @GetMapping("/agregar-carrera")
    public String agregarCarrera(Model model, HttpSession session) {
        // Validar sesión activa
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null) {
            System.out.println("Usuario en sesión: " + usuario.getCorreo() + " ID: " + usuario.getId());
            model.addAttribute("usuario", usuario);
            model.addAttribute("carrera", new CarreraModel());
            return "carreras/carreras-agregar"; // Formulario para agregar carrera
        }
        return "redirect:/"; // Redirigir a login si no hay sesión
    }

    @PostMapping("/agregar-carrera")
    public String agregarCarreraPost(@ModelAttribute CarreraModel carrera, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null) {
            // Opcional: puedes asegurar que el usuarioId se asigna desde la sesión
            carrera.setUsuarioId(usuario.getId());

            System.err.println("Carrera: " + carrera.getNombre() + ", Duración: " + carrera.getDuracion()
                    + ", usuarioId: " + carrera.getUsuarioId());
            carreraServices.saveCarrera(carrera);
            return "redirect:/"; // Redirigir al listado principal
        }
        return "redirect:/?error=true"; // Error por sesión inválida
    }

    // =======================================
    // Rutas para editar carreras
    // =======================================

    @GetMapping("/editar-carrera/{id}")
    public String editarCarrera(@PathVariable int id, Model model, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null) {
            CarreraModel carrera = carreraServices.getCarreraById(id);
            if (carrera == null || carrera.getUsuarioId() != usuario.getId()) {
                return "redirect:/?error=true"; // Carrera no encontrada o no pertenece al usuario
            }
            System.out.println("Usuario en sesión: " + usuario.getCorreo());
            model.addAttribute("usuario", usuario);
            model.addAttribute("carrera", carrera);
            return "carreras/carreras-editar"; // Formulario de edición
        }
        return "redirect:/"; // Redirigir a login
    }

    @PostMapping("/editar-carrera")
    public String editarCarreraPost(@ModelAttribute CarreraModel carrera, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null && carrera.getUsuarioId() == usuario.getId()) {
            System.err.println("Carrera editada: " + carrera.getNombre() + ", Duración: " + carrera.getDuracion()
                    + ", usuarioId: " + carrera.getUsuarioId());
            carreraServices.updateCarreraById(carrera);
            return "redirect:/";
        }
        return "redirect:/?error=true"; // Error de permisos o sesión inválida
    }

    // =======================================
    // Rutas para eliminar carreras
    // =======================================

    @GetMapping("/eliminar-carrera/{id}")
    public String eliminarCarrera(@PathVariable int id, Model model, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null) {
            CarreraModel carrera = carreraServices.getCarreraById(id);
            if (carrera == null || carrera.getUsuarioId() != usuario.getId()) {
                return "redirect:/?error=true";
            }
            System.out.println("Usuario en sesión: " + usuario.getCorreo());
            model.addAttribute("usuario", usuario);
            model.addAttribute("carrera", carrera);
            return "carreras/carreras-eliminar"; // Confirmación para eliminar
        }
        return "redirect:/";
    }

    @PostMapping("/eliminar-carrera")
    public String eliminarCarreraPost(@ModelAttribute CarreraModel carrera, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null && carrera.getUsuarioId() == usuario.getId()) {
            System.err.println("Eliminando carrera: " + carrera.getNombre() + ", usuarioId: " + carrera.getUsuarioId());
            carreraServices.deleteCarreraById(carrera.getId());
            return "redirect:/";
        }
        return "redirect:/?error=true";
    }

    // =======================================
    // Ruta principal - listado de carreras
    // =======================================

    @GetMapping
    public String mainRoute(Model model, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        if (usuario != null) {
            System.out.println("Usuario en sesión: " + usuario.getCorreo() + " ID: " + usuario.getId());
            model.addAttribute("usuario", usuario);
            model.addAttribute("carrerasCount", carreraServices.getCarreras().size());
            model.addAttribute("carreras", carreraServices.getCarrerasByUsuario(usuario.getId()));
            return "carreras/carreras-listado"; // Vista de listado de carreras
        }
        // No hay sesión, mostrar login
        model.addAttribute("usuario", new UsuarioModel());
        return "login/login";
    }

    // =======================================
    // Login y logout
    // =======================================

    @PostMapping("/login")
    public String login(@ModelAttribute UsuarioModel usuario, HttpSession session) {
        System.out.println("Intento de login: " + usuario.getCorreo());
        UsuarioModel user = usuarioServices.validateUser(usuario.getCorreo(), usuario.getPassword());
        if (user != null) {
            session.setAttribute("usuario", user);
            return "redirect:/";
        }
        return "redirect:/?error=true"; // Login fallido
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Destruye la sesión
        return "redirect:/";
    }

    // =======================================
    // Registro de usuarios
    // =======================================

    @GetMapping("/register")
    public String registerRoute(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "login/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsuarioModel usuario) {
        System.out.println("Registro usuario: " + usuario.getCorreo());
        usuarioServices.registerUser(usuario);
        return "redirect:/";
    }
}
