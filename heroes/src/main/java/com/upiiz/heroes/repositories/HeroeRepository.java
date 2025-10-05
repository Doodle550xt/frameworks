package com.upiiz.heroes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upiiz.heroes.entities.Heroe;

@Repository
public interface  HeroeRepository extends CrudRepository <Heroe, Long> {
    // Podemos agregár más métodos
    // Por defecto vienen:
    // Agregar
    // Listar
    // Actualizar
    // Buscar por id
    // Podemos agregár más métodos
}
