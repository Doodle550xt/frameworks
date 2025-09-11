package com.upiiz.ejercicio3.services;

import java.util.ArrayList;
import java.util.List;

import com.upiiz.ejercicio3.models.MascotaModel;
import com.upiiz.ejercicio3.repositories.MascotaRepository;

// TERMINAR USANDO PROGRAMACIÓN FUNCIONAL

// Implements - Implementar - Usar los métodos de otra clase

public class MascotaServices implements MascotaRepository {

    // Requerimos

    // 1.- Acceso a una base de datos
    // 2.- Acceso a un listado en memoria [*]
    private List<MascotaModel> mascotas;

    private int lastId = 0;


    public MascotaServices() {
        // Evitar Null Pointer Exception
        mascotas = new ArrayList<MascotaModel>();
        mascotas.add(new MascotaModel(1, "Firulais", 20, "Labrador"));
        mascotas.add(new MascotaModel(2, "Michifu", 5, "Siames"));
        mascotas.add(new MascotaModel(3, "Rex", 15, "Pastor Aleman"));
        mascotas.add(new MascotaModel(4, "Luna", 8, "Husky"));
        mascotas.add(new MascotaModel(5, "Nina", 3, "Chihuahua"));
        lastId = 5;
    }
    

    @Override
    public List<MascotaModel> getMascotas() {
        return mascotas;
    }

    @Override
    public MascotaModel getMascotaById(int id) {
        return mascotas.stream()
                .filter(mascota -> mascota.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveMascota(MascotaModel mascota) {
        lastId += 1;
        mascota.setId(lastId); // Asignar un ID único
        mascotas.add(mascota);
    }

    @Override
    public void deleteMascotaById(int id) {
        mascotas.removeIf(mascota -> mascota.getId() == id);
    }

    @Override
    public void updateMascotaById(MascotaModel mascota) {
        MascotaModel mascotaExistente = getMascotaById(mascota.getId());
        if (mascotaExistente != null) {
            // Es por referencia
            System.out.println(mascotaExistente.getNombre());
            mascotaExistente.setNombre(mascota.getNombre());
            mascotaExistente.setEdad(mascota.getEdad());
            mascotaExistente.setObservaciones(mascota.getObservaciones());
        }
    }
}