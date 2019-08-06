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
import objetosNegocios.Globallocal;
import objetosNegocios.Numberletter;
import objetosNegocios.Plusminus;

/**
 *
 * @author David Hermosillo
 */
public class ControlGeneral {

    private ArrayList<Integer> listaEjercicios = new ArrayList<>();
    private static ControlGeneral controlGeneral;
    private JFrame pantalla;
    private int idGlobal; 
    private ControlRegistro registro;
    
    private Plusminus objetoPlusMinus;
    private Numberletter objetoNumberLetter;
    private Globallocal objetoGlobalLocal;
    
    
    //Constructor de la clase control general
    private ControlGeneral() {
       registro = ControlRegistro.getSingletonInstance();
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
        
        if(registro.getObjetoPaciente().getFolioPaciente() == null) {
            JOptionPane.showMessageDialog(null, "No se pueden realizar pruebas si no hay datos del paciente");
            return;
        }
        
        this.setIdGlobal(registro.getObjetoPaciente().getFolioPaciente());
        
        /*
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
        */

        if (listaEjercicios.contains(ejercicio)) {
            if (listaEjercicios.size() == 3) {
                
                /*
                int opcion = this.guardarExcel();
                
                switch(opcion) {
                    case -1:
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el archivo");
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Se guardó el archivo correctamente");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Se decidió no guardar el archivo");
                        break;
                }
                */
                
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
                    //System.out.println("Plus minus");
                    break;
                case 2:
                    controlGeneral.getPantalla().setVisible(false);
                    InstruccionesNumberLetter numberLetter = InstruccionesNumberLetter.getSingletonInstance();
                    numberLetter.setVisible(true);
                    //System.out.println("Number letter");
                    break;
                case 3:
                    controlGeneral.getPantalla().setVisible(false);
                    InstruccionesGlobalLocal globalLocal = InstruccionesGlobalLocal.getSingletonInstance();
                    globalLocal.setVisible(true);
                    //System.out.println("Globa local");
                    break;
            }
        }
    }

    /*
    public int guardarExcel() {
        
        boolean primerTexto = true;
        String folio = null;
        int opcionUno = JOptionPane.showConfirmDialog(null, "¿Desear guardar los resultados");
        
        if (opcionUno == 0) {
            while (primerTexto) {
                folio = JOptionPane.showInputDialog("Inserte un número de fólio");
                
                if(folio == null){
                    return false;                                                                   
                }
                
                if (!folio.isEmpty() && !folio.matches("^\\s*$")) {
                    primerTexto = false;
                }
            }
        } else {
            return false;
        }
        
        JFileChooser guardar = new JFileChooser();
        int opcion = guardar.showSaveDialog(guardar);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File archivo = guardar.getSelectedFile();

        if (opcion == JFileChooser.CANCEL_OPTION) {
            return 1;
        } else if (opcion == JFileChooser.ERROR_OPTION) {
            return -1;
        } else {
            try (PrintWriter writer = new PrintWriter(archivo + ".csv")) {

                StringBuilder sb = new StringBuilder();

                sb.append("PLUS MINUS");
                sb.append('\n');
                sb.append("TS");
                sb.append(',');
                sb.append("TR");
                sb.append(',');
                sb.append("TA");
                sb.append(',');
                sb.append("TT");
                sb.append(',');
                sb.append("CT");
                sb.append(',');
                sb.append("RS");
                sb.append(',');
                sb.append("RR");
                sb.append(',');
                sb.append("RA");
                sb.append(',');
                sb.append("RT");
                sb.append(',');
                sb.append("RCS");
                sb.append(',');
                sb.append("RCR");
                sb.append(',');
                sb.append("RCA");
                sb.append(',');
                sb.append("RCT");
                sb.append(',');
                sb.append("TRS");
                sb.append(',');
                sb.append("TRR");
                sb.append(',');
                sb.append("TRA");
                sb.append(',');
                sb.append("TRT");
                sb.append(',');
                sb.append("CTR");
                sb.append(',');
                sb.append("RIS");
                sb.append(',');
                sb.append("RIR");
                sb.append(',');
                sb.append("RIA");
                sb.append(',');
                sb.append("RIT");
                sb.append(',');
                sb.append("PCS");
                sb.append(',');
                sb.append("PCR");
                sb.append(',');
                sb.append("PCA");
                sb.append(',');
                sb.append("PCT");
                sb.append(',');
                sb.append("CPC");
                sb.append(',');
                sb.append("PDS");
                sb.append(',');
                sb.append("PDR");
                sb.append(',');
                sb.append("PDA");
                sb.append(',');
                sb.append("PDT");
                sb.append(',');
                sb.append("CPD");
                sb.append(',');
                sb.append("NRS");
                sb.append(',');
                sb.append("NRR");
                sb.append(',');
                sb.append("NRA");
                sb.append(',');
                sb.append("NRT");
                sb.append('\n');

                sb.append(String.valueOf(this.getObjetoPlusMinus().getTiempoSuma()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getTiempoResta()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getTiempoAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getShiftingTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasSuma()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasResta()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasCorrectasSuma()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasCorrectasResta()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasCorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasCorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getReaccionPromedioSuma()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getReaccionPromedioResta()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getReaccionPromedioAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getReaccionPromedioTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getShiftingReaccionPromedio()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasIncorrectasSuma()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasIncorrectasResta()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasIncorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getRespuestasIncorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeCorrectasSumar()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeCorrectasRestar()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeCorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeCorrectasTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getShiftingRespuestasCorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeRelacionSumar()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeRelacionRestar()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeRelacionAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getPorcentajeRelacionTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getShiftingRelacionIndividual()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getNoRespondidasSumar()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getNoRespondidasRestar()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getNoRespondidasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoPlusMinus().getNoRespondidasTotales()));
                sb.append('\n');
                sb.append('\n');

                sb.append("NUMBER LETTER");
                sb.append('\n');
                sb.append("TL");
                sb.append(',');
                sb.append("TN");
                sb.append(',');
                sb.append("TA");
                sb.append(',');
                sb.append("TT");
                sb.append(',');
                sb.append("SGT");
                sb.append(',');
                sb.append("SLT");
                sb.append(',');
                sb.append("SGTC");
                sb.append(',');
                sb.append("SLTC");
                sb.append(',');
                sb.append("CL");
                sb.append(',');
                sb.append("CN");
                sb.append(',');
                sb.append("CA");
                sb.append(',');
                sb.append("CT");
                sb.append(',');
                sb.append("SGRC");
                sb.append(',');
                sb.append("SLRC");
                sb.append(',');
                sb.append("SGPC");
                sb.append(',');
                sb.append("SLPC");
                sb.append(',');
                sb.append("IL");
                sb.append(',');
                sb.append("IN");
                sb.append(',');
                sb.append("IA");
                sb.append(',');
                sb.append("IT");
                sb.append(',');
                sb.append("ONL");
                sb.append(',');
                sb.append("ONN");
                sb.append(',');
                sb.append("ONA");
                sb.append(',');
                sb.append("ONT");
                sb.append(',');
                sb.append("TTL");
                sb.append(',');
                sb.append("TTN");
                sb.append(',');
                sb.append("TTA");
                sb.append(',');
                sb.append("TTT");
                sb.append(',');
                sb.append("SGTT");
                sb.append(',');
                sb.append("SLTT");
                sb.append(',');
                sb.append("TRCL");
                sb.append(',');
                sb.append("TRCN");
                sb.append(',');
                sb.append("TRCA");
                sb.append(',');
                sb.append("TRCT");
                sb.append(',');
                sb.append("SGTTC");
                sb.append(',');
                sb.append("SLTTC");
                sb.append(',');
                sb.append("CTL");
                sb.append(',');
                sb.append("CTN");
                sb.append(',');
                sb.append("CTA");
                sb.append(',');
                sb.append("CTT");
                sb.append(',');
                sb.append("SGTRC");
                sb.append(',');
                sb.append("SLTRC");
                sb.append(',');
                sb.append("SGPTC");
                sb.append(',');
                sb.append("SLPTC");
                sb.append(',');
                sb.append("ITL");
                sb.append(',');
                sb.append("ITN");
                sb.append(',');
                sb.append("ITA");
                sb.append(',');
                sb.append("ITT");
                sb.append(',');
                sb.append("ONTL");
                sb.append(',');
                sb.append("ONTN");
                sb.append(',');
                sb.append("ONTA");
                sb.append(',');
                sb.append("ONTT");
                sb.append('\n');

                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalPorcentajeCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalPorcentajeCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoTotalLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoTotalNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoTotalAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoTotalTarea()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoReaccionCorrectasLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoReaccionCorrectasNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoReaccionCorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getTiempoReaccionCorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalTiempoTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalTiempoTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasTotalesLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasTotalesNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasTotalesAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getCorrectasTotalesTarea()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalTiempoReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalTiempoReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingGlobalPorcentajeTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getShiftingLocalPorcentajeTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasTotalesLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasTotalesNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasTotalesAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getIncorrectasTotalesTarea()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasTotalesLetras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasTotalesNumeros()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasTotalesAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoNumberLetter().getOmisionesNulasTotalesTarea()));
                sb.append('\n');
                sb.append('\n');

                sb.append("GLOBAL LOCAL");
                sb.append('\n');
                sb.append("TN");
                sb.append(',');
                sb.append("TA");
                sb.append(',');
                sb.append("TA");
                sb.append(',');
                sb.append("TT");
                sb.append(',');
                sb.append("SGT");
                sb.append(',');
                sb.append("SLT");
                sb.append(',');
                sb.append("SGTC");
                sb.append(',');
                sb.append("SLTC");
                sb.append(',');
                sb.append("CN");
                sb.append(',');
                sb.append("CA");
                sb.append(',');
                sb.append("CA");
                sb.append(',');
                sb.append("CT");
                sb.append(',');
                sb.append("SGRC");
                sb.append(',');
                sb.append("SLRC");
                sb.append(',');
                sb.append("SGPC");
                sb.append(',');
                sb.append("SLPC");
                sb.append(',');
                sb.append("IN");
                sb.append(',');
                sb.append("IA");
                sb.append(',');
                sb.append("IA");
                sb.append(',');
                sb.append("IT");
                sb.append(',');
                sb.append("ONN");
                sb.append(',');
                sb.append("ONA");
                sb.append(',');
                sb.append("ONA");
                sb.append(',');
                sb.append("ONT");
                sb.append(',');
                sb.append("TTN");
                sb.append(',');
                sb.append("TTA");
                sb.append(',');
                sb.append("TTA");
                sb.append(',');
                sb.append("TTT");
                sb.append(',');
                sb.append("SGTT");
                sb.append(',');
                sb.append("SLTT");
                sb.append(',');
                sb.append("TRCN");
                sb.append(',');
                sb.append("TRCA");
                sb.append(',');
                sb.append("TRCA");
                sb.append(',');
                sb.append("TRCT");
                sb.append(',');
                sb.append("SGTTC");
                sb.append(',');
                sb.append("SLTTC");
                sb.append(',');
                sb.append("CTN");
                sb.append(',');
                sb.append("CTA");
                sb.append(',');
                sb.append("CTA");
                sb.append(',');
                sb.append("CTT");
                sb.append(',');
                sb.append("SGTRC");
                sb.append(',');
                sb.append("SLTRC");
                sb.append(',');
                sb.append("SGPTC");
                sb.append(',');
                sb.append("SLPTC");
                sb.append(',');
                sb.append("ITN");
                sb.append(',');
                sb.append("ITA");
                sb.append(',');
                sb.append("ITA");
                sb.append(',');
                sb.append("ITT");
                sb.append(',');
                sb.append("ONTN");
                sb.append(',');
                sb.append("ONTA");
                sb.append(',');
                sb.append("ONTA");
                sb.append(',');
                sb.append("ONTT");
                sb.append('\n');

                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalPorcentajeCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalPorcentajeCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoTotalNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoTotalAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoTotalAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoTotalTarea()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalTiempoTotal()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoReaccionCorrectasNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoReaccionCorrectasAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoReaccionCorrectasAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getTiempoReaccionCorrectasTotales()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalTiempoTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalTiempoTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasTotalesNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasTotalesAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasTotalesAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getCorrectasTotalesTarea()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalTiempoReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalTiempoReaccionCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingGlobalPorcentajeTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getShiftingLocalPorcentajeTotalCorrectas()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasTotalesNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasTotalesAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasTotalesAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getIncorrectasTotalesTarea()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasTotalesNegras()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasTotalesAzules()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasTotalesAlternado()));
                sb.append(',');
                sb.append(String.valueOf(this.getObjetoGlobalLocal().getOmisionesNulasTotalesTarea()));
                sb.append('\n');

                writer.write(sb.toString());
                writer.close();
                return 0;

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
    }
    */

    public Plusminus getObjetoPlusMinus() {
        return objetoPlusMinus;
    }

    public void setObjetoPlusMinus(Plusminus objetoPlusMinus) {
        this.objetoPlusMinus = objetoPlusMinus;
    }

    public Numberletter getObjetoNumberLetter() {
        return objetoNumberLetter;
    }

    public void setObjetoNumberLetter(Numberletter objetoNumberLetter) {
        this.objetoNumberLetter = objetoNumberLetter;
    }

    public Globallocal getObjetoGlobalLocal() {
        return objetoGlobalLocal;
    }

    public void setObjetoGlobalLocal(Globallocal objetoGlobalLocal) {
        this.objetoGlobalLocal = objetoGlobalLocal;
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
