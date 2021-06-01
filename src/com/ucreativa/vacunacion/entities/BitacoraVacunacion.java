package com.ucreativa.vacunacion.entities;

import java.util.Date;

public class BitacoraVacunacion {
    private Persona persona;
    private Date fecha;
    private String marca;

    public BitacoraVacunacion(Persona persona, Date fecha, String marca) {
        this.persona = persona;
        this.fecha = fecha;
        this.marca = marca;
    }

    public Persona getPersona() {
        return persona;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getMarca() {
        return marca;
    }
}
