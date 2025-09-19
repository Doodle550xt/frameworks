package com.upiiz.ejercicio3.repositories;

import org.springframework.stereotype.Repository;

import com.upiiz.ejercicio3.models.UsuarioModel;

@Repository
public interface UsuarioRepository {
    // Validar si el usuario existe en la base de datos
    public UsuarioModel validateUser(String username, String password);
    // Registrar un nuevo usuario
    public void registerUser(UsuarioModel usuario);

    
}