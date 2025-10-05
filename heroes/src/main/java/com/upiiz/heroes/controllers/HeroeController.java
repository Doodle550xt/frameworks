package com.upiiz.heroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.heroes.entities.Heroe;
import com.upiiz.heroes.services.HeroeService;

@RestController

public class HeroeController {

    // Inyección de dependencias
    @Autowired
    private HeroeService heroeService;

    // Bean = heroeServices
    public HeroeController(HeroeService heroeService) {
        this.heroeService = heroeService;
    }

    // http://localhost:8080 -> puerto = 8080
    // http://localhost:8080/marvel/socios/v1/heroes
    // Obtener todos
    @GetMapping("/marvel/socios/v1/heroes")
    public ResponseEntity<List<Heroe>> getHeroes() {
        return ResponseEntity.ok(heroeService.getAllHeroes());
    }

    // obtener por id
    @GetMapping("/marvel/socios/v1/heroes/{id}")
    public ResponseEntity<Heroe> getHeroeById(@PathVariable Long id) {
        return ResponseEntity.ok(heroeService.getHeroById(id));
    }

    // Crear
    @PostMapping("/marvel/socios/v1/heroes")
    public ResponseEntity<Heroe> createHeroe(@RequestBody Heroe heroe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(heroeService.addHeroe(heroe));
        // ResponseEntity.ok(heroeService.addHeroe(heroe));
    }

    // Actualizar
    @PutMapping("/marvel/socios/v1/heroes/{id}")
    public ResponseEntity<Heroe> updateHeroe(@PathVariable Long id, @RequestBody Heroe heroe) {
        heroe.setId(id);
        return ResponseEntity.ok(heroeService.updatHeroe(heroe));
    }

    // Eliminar

    @DeleteMapping("/marvel/socios/v1/heroes/{id}")
    public ResponseEntity<Heroe> deleteHeroe(@PathVariable Long id) {
        heroeService.deleteHeroe(id);
        return ResponseEntity.noContent().build();
    }

}
