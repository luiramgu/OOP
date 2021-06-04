package com.ucreativa.vacunacion;


import com.ucreativa.vacunacion.entities.Amigo;
import com.ucreativa.vacunacion.entities.BitacoraVacunacion;
import com.ucreativa.vacunacion.entities.Familiar;
import com.ucreativa.vacunacion.entities.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        // write your code here
        List<BitacoraVacunacion> lBitacoraV = new ArrayList<>();
        String cedula, nombre, edad, facebook, parentesco, relacion;
        boolean isRiesgo;
        int aux, isAmigo, riesgo;
        String[] relacionop = {"Amigo", "Familiar"};
        nombre = JOptionPane.showInputDialog("Nombre: ");
        cedula = JOptionPane.showInputDialog("Cedula: ");
        edad = JOptionPane.showInputDialog("Edad: ");
        riesgo = JOptionPane.showConfirmDialog(null, "Tiene Factor de Riesgo");
        if (riesgo == 0) {
            isRiesgo = true;
        } else {
            isRiesgo = false;
        }
        int bandera = 0;

        while (bandera == 0) {
            aux = JOptionPane.showOptionDialog(null, "Cual es su Relacion con la Persona: ",
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, relacionop, relacionop[0]);

            if (aux == 0) {
                relacion = "Amigo";
                facebook = JOptionPane.showInputDialog("Cual es el Facebook de su amigo:");
                Persona persona = new Amigo(nombre, cedula, Integer.parseInt(edad), isRiesgo, relacion, facebook);

            } else {
                relacion = "Familiar";
                parentesco = JOptionPane.showInputDialog("Cual es el parentezco familiar");
                Persona persona = new Familiar(nombre, cedula, Integer.parseInt(edad), isRiesgo, parentesco);
            }
            String marca, fecha;
            marca = JOptionPane.showInputDialog("Cual es la marca de la vacuna:");
            fecha = JOptionPane.showInputDialog(" Cual es la fecha de vacunacion formato (dd/mm/yyyy)");
            bandera = JOptionPane.showConfirmDialog(null, "Desea Agregar mas Datos a la Bitacora? ");
               System.out.println(bandera);
            Persona persona = new Persona(nombre, cedula, Integer.parseInt(edad), isRiesgo);
            lBitacoraV.add(new BitacoraVacunacion(persona, fecha, marca));
        }


        for (BitacoraVacunacion item : lBitacoraV) {
            System.out.println(item.getPersona().getNombre() + " " + item.getFecha() + " " + item.getMarca());
        }
    }
}

