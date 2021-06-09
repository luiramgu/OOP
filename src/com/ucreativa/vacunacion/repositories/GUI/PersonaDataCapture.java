package com.ucreativa.vacunacion.repositories.GUI;

import com.ucreativa.vacunacion.entities.Amigo;
import com.ucreativa.vacunacion.entities.BitacoraVacunacion;
import com.ucreativa.vacunacion.entities.Familiar;
import com.ucreativa.vacunacion.entities.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class PersonaDataCapture extends JFrame {
    private boolean factorRiesgo;
    private JPanel panel1;
    private JTextField txtNombre;
    private JSpinner sEdad;
    private JTextField txtCedula;
    private JRadioButton rSi;
    private JRadioButton rNo;
    private JRadioButton rFamiliar;
    private JRadioButton rAmigo;
    private JTextField txtParentesco;
    private JTextField txtFB;
    private JSpinner sDia;
    private JSpinner sMes;
    private JSpinner sAno;
    private JComboBox cbMarca;
    private JButton btnAgregar;
    private ButtonGroup bgFactorRiesgo;
    private ButtonGroup bgRelacion;

    public PersonaDataCapture(List<BitacoraVacunacion> list){
        add(panel1);
        setSize(300,470);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpinnerModel sm = new SpinnerNumberModel(18, 18, 120, 1);
        sEdad.setModel(sm);
        bgFactorRiesgo = new ButtonGroup();
        bgFactorRiesgo.add(rSi);
        bgFactorRiesgo.add(rNo);
        bgRelacion = new ButtonGroup();
        bgRelacion.add(rAmigo);
        bgRelacion.add(rFamiliar);

        SpinnerModel smD = new SpinnerNumberModel(1, 1, 31, 1);
        SpinnerModel smM = new SpinnerNumberModel(1, 1, 12, 1);
        SpinnerModel smA = new SpinnerNumberModel(2021, 2021, 2023, 1);
        sAno.setModel(smA);
        sMes.setModel(smM);
        sDia.setModel(smD);

        String[] cb = {"AstraZeneca","Pfizer","J&J"};
        for (String i : cb){
            cbMarca.addItem(i);
        }


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!verificaDatos())
                JOptionPane.showMessageDialog(null,"Faltan Campos Por Llenar");
                else {
                    int edad=0,mes=0,dia=0, ano = 0;

                    try {
                        sEdad.commitEdit();
                    } catch (ParseException parseException) {
                        edad = (Integer) sEdad.getValue();
                    }
                    try {
                        sMes.commitEdit();
                    } catch (ParseException parseException) {
                        mes = (Integer) sMes.getValue();
                    }
                    try {
                        sDia.commitEdit();
                    } catch (ParseException parseException) {
                        dia = (Integer) sDia.getValue();
                    }
                    try {
                        sAno.commitEdit();
                    } catch (ParseException parseException) {
                        ano = (Integer) sAno.getValue();
                    }
                    String fecha =  dia + "/" + mes + "/" + ano;

                    if (rAmigo.isSelected()){
                        Persona aux = new Amigo(txtNombre.getText(),txtCedula.getText(),
                                edad,factorRiesgo,"Amigo",txtFB.getText());
                        BitacoraVacunacion x = new BitacoraVacunacion(aux,fecha,
                                cbMarca.getSelectedItem().toString());
                        list.add(x);


                    }else{
                        Persona aux = new Familiar(txtNombre.getText(),txtCedula.getText(),
                                edad,factorRiesgo,txtParentesco.getText());
                        BitacoraVacunacion x = new BitacoraVacunacion(aux,fecha,
                                cbMarca.getSelectedItem().toString());
                        list.add(x);

                    }

                    if ( JOptionPane.showConfirmDialog(null,
                            "Desea Agregar Otro Registro?") == 0){
                        clear();
                    }else{
                        PersonaDataCapture.super.dispose();
                        for (BitacoraVacunacion i : list){
                            System.out.println(i.toString());
                        }
                    }
                }
            }
        });


        rSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rSi.isSelected()){
                    factorRiesgo = true;
                }
            }
        });
        rNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rNo.isSelected()){
                    factorRiesgo = false;
                }
            }
        });
        rFamiliar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rFamiliar.isSelected()){
                    txtParentesco.setEnabled(true);
                    txtParentesco.setText("");
                    txtFB.setEnabled(false);
                    txtFB.setText("");
                }
            }
        });
        rAmigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rAmigo.isSelected()){
                    txtParentesco.setEnabled(false);
                    txtParentesco.setText("");
                    txtFB.setEnabled(true);
                    txtFB.setText("");
                }
            }

        });
    }
    private boolean verificaDatos (){
        boolean bandera = true;
        //evalua primero la informacion de parentesco y familiar

        if (!rFamiliar.isSelected() & !rAmigo.isSelected()){
            bandera=false;
        }

        if (rAmigo.isSelected() & txtFB.getText().equals("")){
            bandera= false;
        }
        if (rFamiliar.isSelected() & txtParentesco.getText().equals("")){
            bandera = false;
        }

        if (txtNombre.getText().equals("") | txtCedula.getText().equals("")){
            bandera = false;
        }

        if (!rNo.isSelected() & !rSi.isSelected()){
            bandera = false;
        }
        return bandera;
    }

    private void clear (){
        txtNombre.setText("");
        txtCedula.setText("");
        txtParentesco.setText("");
        txtFB.setText("");
        rFamiliar.setSelected(false);
        rSi.setSelected(false);
        rNo.setSelected(false);
        rFamiliar.setSelected(false);

        SpinnerModel smD = new SpinnerNumberModel(1, 1, 31, 1);
        SpinnerModel smM = new SpinnerNumberModel(1, 1, 12, 1);
        SpinnerModel smA = new SpinnerNumberModel(2021, 2021, 2023, 1);
        sAno.setModel(smA);
        sMes.setModel(smM);
        sDia.setModel(smD);


        cbMarca.setSelectedIndex(0);
        SpinnerModel sm = new SpinnerNumberModel(18, 18, 120, 1);
        sEdad.setModel(sm);
    }

}

