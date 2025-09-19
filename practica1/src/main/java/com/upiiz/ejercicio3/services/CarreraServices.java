package com.upiiz.ejercicio3.services;

import java.util.ArrayList;
import java.util.List;

import com.upiiz.ejercicio3.models.CarreraModel;
import com.upiiz.ejercicio3.repositories.CarreraRepository;

public class CarreraServices implements CarreraRepository {

    private List<CarreraModel> carreras;
    private int lastId = 0;

    public CarreraServices() {
        carreras = new ArrayList<CarreraModel>(); 
        carreras.add(new CarreraModel(lastId, "SistemasComputacionales", 2, 0));
        lastId++;
        carreras.add(new CarreraModel(lastId, "IngenieriaMecanica", 3, 0));
        lastId++;
        carreras.add(new CarreraModel(lastId, "IngenieriaIndustrial", 4, 2));
        lastId++;
        carreras.add(new CarreraModel(lastId, "IngenieriaCivil", 5, 2));
        lastId++;
        carreras.add(new CarreraModel(lastId, "IngenieriaQuimica", 6, 1));  
        lastId = 5;
    }

    @Override
    public List<CarreraModel> getCarreras() {
        return carreras;
    }

    @Override
    public CarreraModel getCarreraById(int id) {
        return carreras.stream()
                .filter(carrera -> carrera.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveCarrera(CarreraModel carrera) {
        lastId += 1;
        carrera.setId(lastId);
        carreras.add(carrera);
    }

    @Override
    public void deleteCarreraById(int id) {
        carreras.removeIf(carrera -> carrera.getId() == id);
    }

    @Override
    public void updateCarreraById(CarreraModel carrera) {
        CarreraModel carreraExistente = getCarreraById(carrera.getId());
        if (carreraExistente != null) {
            carreraExistente.setNombre(carrera.getNombre());
            carreraExistente.setDuracion(carrera.getDuracion());
        }
    }
    @Override
    public List<CarreraModel> getCarrerasByUsuario(int usuarioId) {
        List<CarreraModel> resultado = new ArrayList<>();
        for (CarreraModel carrera : carreras) {
            if (carrera.getUsuarioId() == usuarioId) {
                resultado.add(carrera);
            }
        }
        return resultado;
    }
}
