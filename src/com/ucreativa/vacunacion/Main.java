package com.ucreativa.vacunacion;


import com.ucreativa.vacunacion.entities.BitacoraVacunacion;
import com.ucreativa.vacunacion.repositories.GUI.PersonaDataCapture;
import com.ucreativa.vacunacion.repositories.inMemoryRepository;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // write your code here
        List<BitacoraVacunacion> db = new ArrayList<>();
        inMemoryRepository repo = new inMemoryRepository();
        PersonaDataCapture form = new PersonaDataCapture(db);
        form.setVisible(true);

    }
}

