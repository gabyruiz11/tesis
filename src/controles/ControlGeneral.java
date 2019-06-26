/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import guiGlobalLocal.InstruccionesGlobalLocal;
import guiNumberLetter.InstruccionesNumberLetter;
import guiPlusMinus.Instrucciones;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David Hermosillo
 */
public class ControlGeneral {

    private ArrayList<Integer> listaEjercicios = new ArrayList<>();
    private static ControlGeneral controlGeneral;
    private JFrame pantalla;
    private int contador = 0, idGlobal; 
    
    //Constructor de la clase control general
    private ControlGeneral() {
       
    }
    
    //Método singleton de la clase control general
    public static ControlGeneral getSingletonInstance() {
        if (controlGeneral == null) {
            controlGeneral = new ControlGeneral();
        } else {
            
        }
        return controlGeneral;
    }
    
    public void ejecutarEjercicios(JFrame frame) {
        int ejercicio = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        
        if (contador == 0) {
            int auxiliar;

            String id = JOptionPane.showInputDialog("Introduce un ID para el paciente");

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se aceptan valores en blanco");
                return;
            }

            try {
                auxiliar = Integer.valueOf(id);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números");
                return;
            }

            //Aquí se establece el número de paciente
            this.setIdGlobal(auxiliar);
            System.out.println(this.getIdGlobal());
            contador++;
        }

        if (listaEjercicios.contains(ejercicio)) {
            if (listaEjercicios.size() == 3) {
                System.out.println("Ya se acabaron los ejercicios, we");
            } else {
                ejecutarEjercicios(frame);
            }
        } else {
            listaEjercicios.add(ejercicio);

            switch (ejercicio) {
                case 1:
                    controlGeneral.getPantalla().setVisible(false);
                    Instrucciones plusMinus = Instrucciones.getSingletonInstance();
                    plusMinus.setVisible(true);
                    System.out.println("Plus minus");
                    break;
                case 2:
                    controlGeneral.getPantalla().setVisible(false);
                    InstruccionesNumberLetter numberLetter = InstruccionesNumberLetter.getSingletonInstance();
                    numberLetter.setVisible(true);
                    System.out.println("Number letter");
                    break;
                case 3:
                    controlGeneral.getPantalla().setVisible(false);
                    InstruccionesGlobalLocal globalLocal = InstruccionesGlobalLocal.getSingletonInstance();
                    globalLocal.setVisible(true);
                    System.out.println("Globa local");
                    break;
            }
        }

    }

    public JFrame getPantalla() {
        return pantalla;
    }

    public void setPantalla(JFrame pantalla) {
        this.pantalla = pantalla;
    }

    public int getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(int idGlobal) {
        this.idGlobal = idGlobal;
    }

    
    
}
