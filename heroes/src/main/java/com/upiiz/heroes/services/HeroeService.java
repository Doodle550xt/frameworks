package com.upiiz.heroes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.heroes.entities.Heroe;
import com.upiiz.heroes.repositories.HeroeRepository;

@Service
public class HeroeService {
    private HeroeRepository heroeRepository;

    // Constructor - Bean - Instanciado, Ensamblado y manejado por Springboot
    public HeroeService(HeroeRepository heroeRepository) {
        this.heroeRepository = heroeRepository;
    }

    public List<Heroe> getAllHeroes() {
        return (List<Heroe>) heroeRepository.findAll();
    }

    public Heroe getHeroById(long id) {
        return heroeRepository.findById(id).orElse(null);
    }

    // Se asume que no tenemos un id, por tanto se asume que lo va crear;
    public Heroe addHeroe(Heroe heroe) {
        return heroeRepository.save(heroe);
    }

    // Si tenemos un id, por tanto se asume que lo va a actualizar;
    public Heroe updatHeroe(Heroe heroe) {
        return heroeRepository.save(heroe);
    }

    public void deleteHeroe(Long id) {
        heroeRepository.deleteById(id);
    }
}
