package com.ucreativa.vacunacion;

public class Familiar extends Persona{

    private String arentesco;

    public Familiar(String nombre, String cedula, int edad, boolean riesgo, String arentesco) {
        super(nombre, cedula, edad, riesgo);
        this.arentesco = arentesco;
    }

    public String getArentesco() {
        return arentesco;
    }

    public void setArentesco(String arentesco) {
        this.arentesco = arentesco;
    }
}
