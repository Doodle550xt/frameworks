package com.upiiz.ejercicio3.models;

public class CarreraModel {
    private int idCarrera;
    private String nombre;
    private int duracion;
    private int usuarioId;
    

    public CarreraModel(int idCarrera, String nombre, int duracion, int usuarioId) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;

        this.usuarioId = usuarioId;
    }
    public CarreraModel(){
        
    }

    public int getId() {
        return idCarrera;
    }

    public void setId(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}