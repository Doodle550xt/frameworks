package com.upiiz.holamundo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Controlar en que url se despliegan las páginas  [GET]


    // http://localhost:8080/ -  Página principal
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // http://localhost:8080/contacto -  Página de contacto
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    // http://localhost:8080/nosotros -  Página de nosotros
    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    // http://localhost:8080/galeria -  Página de galería
    @GetMapping("/galeria")
    public String galeria() {
        return "galleria";
    }
}
