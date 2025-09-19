package com.upiiz.ejercicio3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.upiiz.ejercicio3.models.MascotaModel;
import com.upiiz.ejercicio3.services.MascotaServices;

@Controller
public class MascotasController {
    MascotaServices mascotaServices = new MascotaServices();

    // Mostrar el listado

    @GetMapping("/")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaServices.getMascotas());
        return "mascotas/mascotas-listado";
    }

    // Guardar una mascota
    // Formulario para agregar una mascota
    @GetMapping("/agregar")
    public String guardarMascotaFormulario(Model model) {
        MascotaModel mascota = new MascotaModel();
        model.addAttribute("mascota", mascota);
        return "mascotas/mascotas-agregar";
    }

    // Procesar el formulario para agregar una mascota y rediccionar al listado
    @PostMapping("/agregar")
    public String guardarMascotaFormulario(@ModelAttribute MascotaModel mascota) {
        mascotaServices.saveMascota(mascota);
        return "redirect:/";
    }

    // Eliminar una mascota
    // Formulario para eliminar una mascota
    @GetMapping("/eliminar/{id}")
    public String eliminarrMascotaFormulario(@PathVariable int id, Model model) {
        MascotaModel mascota = mascotaServices.getMascotaById(id);
        if (mascota == null) {
            return "redirect:/";
        }
        model.addAttribute("mascota", mascota);
        return "mascotas/mascotas-eliminar";
    }

    // Procesar el formulario para eliminar una mascota y rediccionar al listado
    @PostMapping("/eliminar")
    public String eliminarMascota(@ModelAttribute MascotaModel mascota) {
        mascotaServices.deleteMascotaById(mascota.getId());
        return "redirect:/";
    }

    // Actualizar una mascota
    // Formulario para actualizar mascota
    @GetMapping("/editar/{id}")
    public String actualizarMascotaFormulario(@PathVariable int id, Model model) {
        MascotaModel mascota = mascotaServices.getMascotaById(id);
        if (mascota == null) {
            return "redirect:/";
        }
        model.addAttribute("mascota", mascota);
        return "mascotas/mascotas-editar";
    }

    // Actualizar y rediccionar al listado
    @PostMapping("/editar")
    public String editarMascota(@ModelAttribute MascotaModel mascota) {
        mascotaServices.updateMascotaById(mascota);
        return "redirect:/";
    }

}