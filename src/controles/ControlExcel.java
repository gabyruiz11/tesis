/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David Hermosillo
 */
public class ControlExcel {
    
    private static final String ARCHIVO = "./principal.csv";
    private ControlRegistro controlRegistro;
    private ControlPlusMinus controlPlusMinus;
    private ControlNumberLetter controlNumberLetter;
    private ControlGlobalLocal controlGlobalLocal;
    
    private static ControlExcel controlExcel;
    
    private List<String[]> records;
    private int contador;
    private String mensaje = "Las siguientes actividades no fueron realizadas: \n";
    
    //Constructor de la clase control excel
    private ControlExcel() {
       controlRegistro = ControlRegistro.getSingletonInstance();
       controlPlusMinus = ControlPlusMinus.getSingletonInstance();
       controlNumberLetter = ControlNumberLetter.getSingletonInstance();
       controlGlobalLocal = ControlGlobalLocal.getSingletonInstance();
    }
    
    public static ControlExcel getSingletonInstance() {
        if (controlExcel == null) {
            controlExcel = new ControlExcel();
        } else {
            
        }
        return controlExcel;
    }
    
    public void verificacionExcel() {
        if (controlRegistro.getObjetoPaciente().getFolioPaciente() == null) {
            JOptionPane.showMessageDialog(null, "No se pueden descargar los archivos si no hay datos del paciente");
            return;
        } else {
            if (controlPlusMinus.getObjetoPlusMinus().getIdPlusMinus() == null
                    || controlNumberLetter.getObjetoNumberLetter().getIdNumberLetter() == null
                    || controlGlobalLocal.getObjetoLocalGlobal().getIdGlobalLocal() == null) {

                JOptionPane.showMessageDialog(null, "No se realizaron todas las pruebas, pero se descargaran los datos");
                this.resultadosExcel();
            } else {
                JOptionPane.showMessageDialog(null, "Todos los datos descargados correctamente");
                this.resultadosExcel();
            }
        }
    }
    
    private void resultadosExcel() {
        try (
                FileWriter fileWriter = new FileWriter(ARCHIVO, true);
                CSVWriter csvWriter = new CSVWriter(fileWriter,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);) {

            csvWriter.writeNext(new String[]{String.valueOf(controlRegistro.getObjetoPaciente().getFolioPaciente()), 
                                             String.valueOf(controlRegistro.getObjetoPaciente().getEdadPaciente()), 
                                             String.valueOf(controlRegistro.getObjetoPaciente().getConsumidorPaciente()), 
                                             String.valueOf(controlRegistro.getObjetoPaciente().getCelularPaciente()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getLeerEscribirPaciente()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getOcupacionPaciente()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getTiempoOcupacionPaciente()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getTiempoDesempleoPaciente()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getEstadoCivilPaciente()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getFolioPaciente()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getTiempoSuma()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getTiempoResta()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getTiempoAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getTiempoTotal()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getShiftingTotal()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasSuma()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasResta()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasTotales()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasCorrectasSuma()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasCorrectasResta()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasCorrectasAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasCorrectasTotales()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getReaccionPromedioSuma()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getReaccionPromedioResta()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getReaccionPromedioAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getReaccionPromedioTotal()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getShiftingReaccionPromedio()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasIncorrectasSuma()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasIncorrectasResta()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasIncorrectasAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getRespuestasIncorrectasTotales()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeCorrectasSumar()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeCorrectasRestar()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeCorrectasAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeCorrectasTotal()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getShiftingRespuestasCorrectasTotales()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeRelacionSumar()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeRelacionRestar()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeRelacionAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getPorcentajeRelacionTotal()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getShiftingRelacionIndividual()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getNoRespondidasSumar()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getNoRespondidasRestar()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getNoRespondidasAlternado()),
                                             String.valueOf(controlPlusMinus.getObjetoPlusMinus().getNoRespondidasTotales()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getFolioPaciente()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoTotal()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalTotal()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalTotal()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalTotalCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalTotalCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasTotales()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalReaccionCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalReaccionCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalPorcentajeCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalPorcentajeCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasTotales()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasTotales()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoTotalLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoTotalNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoTotalAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoTotalTarea()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalTiempoTotal()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalTiempoTotal()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoReaccionCorrectasLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoReaccionCorrectasNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoReaccionCorrectasAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getTiempoReaccionCorrectasTotales()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalTiempoTotalCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalTiempoTotalCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasTotalesLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasTotalesNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasTotalesAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getCorrectasTotalesTarea()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalTiempoReaccionCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalTiempoReaccionCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingGlobalPorcentajeTotalCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getShiftingLocalPorcentajeTotalCorrectas()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasTotalesLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasTotalesNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasTotalesAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getIncorrectasTotalesTarea()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasTotalesLetras()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasTotalesNumeros()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasTotalesAlternado()),
                                             String.valueOf(controlNumberLetter.getObjetoNumberLetter().getOmisionesNulasTotalesTarea()),
                                             String.valueOf(controlRegistro.getObjetoPaciente().getFolioPaciente()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoTotal()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalTotal()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalTotal()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalTotalCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalTotalCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasTotales()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalReaccionCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalReaccionCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalPorcentajeCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalPorcentajeCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasTotales()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasTotales()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoTotalNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoTotalAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoTotalAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoTotalTarea()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalTiempoTotal()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalTiempoTotal()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoReaccionCorrectasNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoReaccionCorrectasAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoReaccionCorrectasAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getTiempoReaccionCorrectasTotales()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalTiempoTotalCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalTiempoTotalCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasTotalesNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasTotalesAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasTotalesAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getCorrectasTotalesTarea()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalTiempoReaccionCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalTiempoReaccionCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingGlobalPorcentajeTotalCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getShiftingLocalPorcentajeTotalCorrectas()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasTotalesNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasTotalesAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasTotalesAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getIncorrectasTotalesTarea()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasTotalesNegras()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasTotalesAzules()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasTotalesAlternado()),
                                             String.valueOf(controlGlobalLocal.getObjetoLocalGlobal().getOmisionesNulasTotalesTarea())});
            
            JOptionPane.showMessageDialog(null, "Los datos fueron guardados");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los datos");
        }
    }
    
    public int buscarExcel(String folio) {
        contador = 0;
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
    
    public void actividadesRealizadas(String folio){
        if(buscarExcel(folio) == -1) {
            JOptionPane.showMessageDialog(null, "Ese folio no existe registrado en el archivo");
        } else {
            
            if(records.get(contador)[9].isEmpty()) {
                mensaje += "Plus minus \n";
            }
            
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
}
