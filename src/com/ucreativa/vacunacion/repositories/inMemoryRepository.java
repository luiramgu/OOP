package com.ucreativa.vacunacion.repositories;

import com.ucreativa.vacunacion.entities.BitacoraVacunacion;
import com.ucreativa.vacunacion.entities.Persona;

import java.util.ArrayList;
import java.util.List;

public class inMemoryRepository {
    private List<BitacoraVacunacion> lBitacoraV ;

    public inMemoryRepository() {
        this.lBitacoraV = new ArrayList<>();
    }

    public void save(Persona persona, String fecha, String marca){
        this.lBitacoraV.add(new BitacoraVacunacion(persona,fecha,marca));
    }

    public List<String> getList (){
            List<String> lines = new ArrayList<>();
        for (BitacoraVacunacion item : lBitacoraV) {
            lines.add(item.getPersona().getNombre() + " " + item.getFecha() + " " + item.getMarca());
        }
        return lines;
    }
}
