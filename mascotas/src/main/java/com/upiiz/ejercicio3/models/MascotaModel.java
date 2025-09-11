package com.upiiz.ejercicio3.models;

public class MascotaModel
{
    private int id;
    private String nombre;
    private int edad;
    private String observaciones;

    public MascotaModel(int id, String nombre, int edad, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.observaciones = observaciones;
    }
    public MascotaModel() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;   
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;  
    }
    

}