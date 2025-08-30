package com.upiiz.pacientes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class HomeController {
    
    @GetMapping("/")
    public String pacientes() {
        return "pacientes"; 
    }
    @GetMapping("/crear")
    public String crear() {
        return "crear";
    }
    @GetMapping("/editar")
    public String editar() {
        return "editar";
    }  
    @GetMapping("/eliminar")
    public String eliminar() {
        return "eliminar";
    }
}