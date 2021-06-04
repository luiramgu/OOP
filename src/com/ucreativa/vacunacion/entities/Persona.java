package com.ucreativa.vacunacion.entities;

public class Persona {
    private String nombre;
    private String cedula;
    private int edad;
    private boolean riesgo;

    public Persona (){

    }
    public Persona(String nombre, String cedula, int edad, boolean riesgo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.riesgo = riesgo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isRiesgo() {
        return riesgo;
    }

    public void setRiesgo(boolean riesgo) {
        this.riesgo = riesgo;
    }
}
