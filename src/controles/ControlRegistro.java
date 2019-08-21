/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import guiMenu.MenuAdministrador;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosNegocios.Paciente;

/**
 *
 * @author David Hermosillo
 */
public class ControlRegistro {
    
    private Paciente objetoPaciente;
    private static ControlRegistro controlRegistro;
    
    //was added here cause it makes a infinite loop 
    private static final String ARCHIVO = "./principal.csv";
    private List<String[]> records;
    
    /**
     * Constructor de la clase control registro
     */
    private ControlRegistro() {
        objetoPaciente = new Paciente();
    }

    /**
     * Método singleton de la clase control registro
     * @return 
     */
    public static ControlRegistro getSingletonInstance() {
        if (controlRegistro == null) {
            controlRegistro = new ControlRegistro();
        } else {
            
        }
        return controlRegistro;
    }

    public ControlRegistro(Paciente objetoPaciente) {
        this.objetoPaciente = objetoPaciente;
    }
    
    public void agregarPaciente(String folio, String edad, boolean consumidor, String celular, boolean leerEscribir, String ocupacion, 
                                String tiempoOcupacion, String tiempoDesempleado, String estadoCivil, JFrame menu){
        
        if(buscarExcel(folio) != -1) {
            JOptionPane.showMessageDialog(null, "El folio ya se encuentra en el archivo");
            return;
        }
        
        try {
            int folioFinal = Integer.parseInt(folio);
            objetoPaciente.setFolioPaciente(folioFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El folio debe de contener solo números");
            return;
        }
        
        try {
            int edadFinal = Integer.parseInt(edad);
            objetoPaciente.setEdadPaciente(edadFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad debe de contener solo números");
            return;
        }
        
        //Será auxiliar a la hora de escribir en el excel
        String consumidorFinal;
        
        if (consumidor) {
            consumidorFinal = "Si";
            Short numero = new Short("0");
            objetoPaciente.setConsumidorPaciente(numero);
        } else {
            consumidorFinal = "No";
            Short numero = new Short("1");
            objetoPaciente.setConsumidorPaciente(numero);
        }
        
        try {
            int celularFinal = Integer.parseInt(celular);
            objetoPaciente.setCelularPaciente(celularFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de celular debe de contener solo números");
            return;
        }
        
        //Será auxiliar a la hora de escribir en el excel
        String leerEscribirFinal;
        
        if(leerEscribir) {
            leerEscribirFinal = "Si";
            Short numero = new Short("0");
            objetoPaciente.setLeerEscribirPaciente(numero);
        } else {
            leerEscribirFinal = "No";
            Short numero = new Short("1");
            objetoPaciente.setLeerEscribirPaciente(numero);
        }
        
        /* Será auxiliar a la hora de escribir en el excel
        String escribirFinal;
        
        if(escribir) {
            escribirFinal = "Si";
        } else {
            escribirFinal = "No";
        }
        */
        
        try {
            int ocupacionFinal = Integer.parseInt(ocupacion);
            objetoPaciente.setOcupacionPaciente(ocupacionFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El código de la ocupación debe de contener solo números");
            return;
        }
        
        try {
            int tiempoOcupacionFinal = Integer.parseInt(tiempoOcupacion);
            objetoPaciente.setTiempoOcupacionPaciente(tiempoOcupacionFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El tiempo de la ocupación debe de contener solo números");
            return;
        }
        
        try {
            int tiempoDesempleoFinal = Integer.parseInt(tiempoDesempleado);
            objetoPaciente.setTiempoDesempleoPaciente(tiempoDesempleoFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El tiempo de desempleo debe de contener solo números");
            return;
        }
        
        try {
            int estadoCivilFinal = Integer.parseInt(estadoCivil);
            objetoPaciente.setEstadoCivilPaciente(estadoCivilFinal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El código de estado civil debe de contener solo números");
            return;
        }
        
        //System.out.println(this.objetoPaciente.toString());
        
        JOptionPane.showMessageDialog(null, "Proceso realizado correctamente");
        this.setObjetoPaciente(objetoPaciente);
        menu.setVisible(false);
        MenuAdministrador principal = new MenuAdministrador();
        principal.setVisible(true);
    }
    
    public void eliminarPaciente() {
        if (controlRegistro.getObjetoPaciente().getFolioPaciente() != null) {
            controlRegistro.getObjetoPaciente().setFolioPaciente(null);
            controlRegistro.getObjetoPaciente().setEdadPaciente(null);
            controlRegistro.getObjetoPaciente().setConsumidorPaciente(null);
            controlRegistro.getObjetoPaciente().setCelularPaciente(null);
            controlRegistro.getObjetoPaciente().setLeerEscribirPaciente(null);
            controlRegistro.getObjetoPaciente().setOcupacionPaciente(null);
            controlRegistro.getObjetoPaciente().setTiempoOcupacionPaciente(null);
            controlRegistro.getObjetoPaciente().setTiempoDesempleoPaciente(null);
            controlRegistro.getObjetoPaciente().setEstadoCivilPaciente(null);
            
            JOptionPane.showMessageDialog(null, "Proceso finalizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos del paciente que eliminar");
        }
    }
    
    public int buscarExcel(String folio) {
        int contador = 0;
        int error;
        
        try (
            Reader reader = Files.newBufferedReader(Paths.get(ARCHIVO));
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
        ) {
            // Reading Records One by One in a String array
            records = csvReader.readAll();
            
            for (String[] record : records) {
                if (record[0].equals(folio)) {
                    return contador++;
                }
                contador++;
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        error = -1;
        return error;
    }

    public Paciente getObjetoPaciente() {
        return objetoPaciente;
    }

    public void setObjetoPaciente(Paciente objetoPaciente) {
        this.objetoPaciente = objetoPaciente;
    }
    
}
