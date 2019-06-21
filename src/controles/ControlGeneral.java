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

/**
 *
 * @author David Hermosillo
 */
public class ControlGeneral {

    private ArrayList<Integer> listaEjercicios = new ArrayList<>();
    private static ControlGeneral controlGeneral;
    
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
    
    public void ejecutarEjercicios(JFrame pantallaActual) {
        int ejercicio = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        
        if(listaEjercicios.contains(ejercicio)){
            if(listaEjercicios.size() == 3) {
                System.out.println("Ya se acabaron los ejercicios, we");
            } else {
                ejecutarEjercicios(pantallaActual);
            }
        } else {
            listaEjercicios.add(ejercicio);
        }
        
        switch (ejercicio) {
            case 1:
                pantallaActual.setVisible(false);
                Instrucciones plusMinus = Instrucciones.getSingletonInstance();
                plusMinus.setVisible(true);
                break;
            case 2:
                pantallaActual.setVisible(false);
                InstruccionesNumberLetter numberLetter = InstruccionesNumberLetter.getSingletonInstance();
                numberLetter.setVisible(true);
                
                break;
            case 3:
                pantallaActual.setVisible(false);
                InstruccionesGlobalLocal globalLocal = InstruccionesGlobalLocal.getSingletonInstance();
                globalLocal.setVisible(true);
                break;
        }
    }
    
}
