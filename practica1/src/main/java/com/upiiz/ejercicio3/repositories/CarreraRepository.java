package com.upiiz.ejercicio3.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.upiiz.ejercicio3.models.CarreraModel;

@Repository
public interface CarreraRepository {
    // Regresar todas las mascotas
    public List<CarreraModel> getCarreras();

    // Regrese una mascota Por Id
    public CarreraModel getCarreraById(int id);

    // Regresar carrera por usuario
    public List<CarreraModel> getCarrerasByUsuario(int usuarioId);
    // Agregar mascota
    public void saveCarrera(CarreraModel carrera);

    // Eliminar una mascota
    public void deleteCarreraById(int id);

    // Actualizar una mascota
    public void updateCarreraById(CarreraModel carrera);

}