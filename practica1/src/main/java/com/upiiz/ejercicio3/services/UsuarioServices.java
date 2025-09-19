package com.upiiz.ejercicio3.services;

import java.util.ArrayList;
import java.util.List;

import com.upiiz.ejercicio3.models.UsuarioModel;
import com.upiiz.ejercicio3.repositories.UsuarioRepository;

public class UsuarioServices implements UsuarioRepository {
    private int lastId = 0;
    private List<UsuarioModel> usuarios;

    public UsuarioServices() {
        usuarios = new ArrayList<UsuarioModel>();
        usuarios.add(new UsuarioModel(lastId, "Cristian Garcia", "crisgn01@icloud.com", "1234"));
        lastId++;
        usuarios.add(new UsuarioModel(lastId, "Admin", "admin@admin.com", "admin"));
        lastId++;

    }

    @Override
    public UsuarioModel validateUser(String username, String password) {
        UsuarioModel usuario = usuarios.stream().filter(item -> item.getCorreo().equals(username) && item.getPassword().equals(password)).findFirst().orElse(null);
        System.out.println("Usuario encontrado: " + usuario);
        return usuario; 
    }

    @Override
    public void registerUser(UsuarioModel usuario) {
        usuario.setId(++lastId);
        usuarios.add(usuario);
        // Lógica para registrar un nuevo usuario en la base de datos
    }
}