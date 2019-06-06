/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import controladores.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.*;

/**
 *
 * @author David Hermosillo
 */
public class Persistencia {
    
    private final EntityManagerFactory emf;
    private final PlusminusJpaController plusMinusController;
    private final NumberletterJpaController numberLetterController;
    private static Persistencia persistencia;
    
    private Persistencia() {
        emf = Persistence.createEntityManagerFactory("tesis-aplicacionPU");
        plusMinusController = new PlusminusJpaController(emf);
        numberLetterController = new NumberletterJpaController(emf);
    }
    
    public static Persistencia getSingletonInstance() {
        if (persistencia == null) {
            persistencia = new Persistencia();
        } else {
            
        }
        return persistencia;
    }

    public boolean agregarPlusMinusBD(Plusminus objetoPlusMinus) {
        try {
            plusMinusController.create(objetoPlusMinus);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public boolean agregarNumberLetterBD(Numberletter objetoNumberLetter) {
        try {
            numberLetterController.create(objetoNumberLetter);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}
