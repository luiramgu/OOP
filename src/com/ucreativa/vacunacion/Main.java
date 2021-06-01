package com.ucreativa.vacunacion;


import com.ucreativa.vacunacion.entities.BitacoraVacunacion;
import com.ucreativa.vacunacion.entities.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Persona mama = new Persona("Ana","2-267-0607",72,true);
        Persona papa = new Persona("Rodolfo","4-476-789",88,false);
        Persona hermana = new Persona("Zianne","1-111-111",42,true);

        List<BitacoraVacunacion> listaBitacora = new ArrayList<>();
        Date fecha = new Date();
        fecha.setTime(fecha.getTime());
        listaBitacora.add(new BitacoraVacunacion(mama,fecha,"Pfizer"));
        listaBitacora.add(new BitacoraVacunacion(papa,fecha,"Jhonson"));
        listaBitacora.add(new BitacoraVacunacion(hermana,fecha,"AstraZeneca"));

    }
}
