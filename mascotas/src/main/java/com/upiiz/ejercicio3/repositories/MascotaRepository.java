package com.upiiz.ejercicio3.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upiiz.ejercicio3.models.MascotaModel;

@Repository
public interface MascotaRepository {
    // Regresar todas las mascotas
    public List<MascotaModel> getMascotas();

    // Regrese una mascota Por Id
    public MascotaModel getMascotaById(int id);

    // Agregar mascota
    public void saveMascota(MascotaModel mascota);

    // Eliminar una mascota
    public void deleteMascotaById(int id);

    // Actualizar una mascota
    public void updateMascotaById(MascotaModel mascota);

}