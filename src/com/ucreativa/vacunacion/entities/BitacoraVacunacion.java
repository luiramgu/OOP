package com.ucreativa.vacunacion.entities;

public class BitacoraVacunacion {
    private Persona persona;
    private String fecha;
    private String marca;

    public BitacoraVacunacion(Persona persona, String fecha, String marca) {
        this.persona = persona;
        this.fecha = fecha;
        this.marca = marca;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return persona.getNombre() + " " + getFecha() + " " + getMarca();
    }
}
