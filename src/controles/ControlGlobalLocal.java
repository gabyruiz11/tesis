/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import guiGlobalLocal.ActividadGrandes;
import guiGlobalLocal.ActividadMixto;
import guiGlobalLocal.ActividadPequeñas;
import guiGlobalLocal.FamiliarizacionFiguras;
import guiGlobalLocal.InstruccionesGlobalLocal;
import guiGlobalLocal.PracticaGrandes;
import guiGlobalLocal.PracticaMixto;
import guiGlobalLocal.PracticaPequeñas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import objetosNegocio.Globallocal;

/**
 *
 * @author David Hermosillo
 */
public class ControlGlobalLocal {

    private JFrame pantalla = null;

    //Variable del objeto control number letter
    private static ControlGlobalLocal controlGlobalLocal;

    //Variable referencia del objeto global local
    private Globallocal objetoLocalGlobal;

    public JFrame getPantalla() {
        return pantalla;
    }

    public void setPantalla(JFrame pantalla) {
        this.pantalla = pantalla;
    }

    //Hilos
    private Thread hiloFamiliarizacion, hiloPracticasGrandes, hiloActividadGrandes,
            hiloPracticasPequeñas, hiloActividadPequeñas,
            hiloPracticasMixto, hiloActividadMixto;

    //Contadores
    private int circulo, equis, triangulo, cuadrado, seriesRepetidas, seriesShifting, contadorHiloFamiliarizacion,
            contadorHiloPracticaGrande, contadorHiloActividadGrande,
            contadorHiloPracticaPequeñas, contadorHiloActividadPequeñas, contadoraux,
            contadorHiloMixtoPractica, contadorHiloMixtoActividad, auxiliarMixto;

    //Etiquetas
    private JLabel etiquetaImagen, etiquetaRespuesta, etiquetaNombre;

    //Repeticiones
    private int repeticiones;

    //Lista de ordenes
    private final String[] formaUno = {"N", "N", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N"},
            formaDos = {"A", "A", "N", "N", "A", "N", "A", "A", "N", "N", "A", "A", "A"},
            formaTres = {"N", "A", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N"},
            formaCuatro = {"N", "N", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N",
                "N", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N",
                "N", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N",
                "N", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N"},
            formaCinco = {"A", "A", "N", "N", "A", "N", "A", "A", "N", "N", "A", "A", "A",
                "A", "N", "N", "A", "N", "A", "A", "N", "N", "A", "A", "A",
                "A", "N", "N", "A", "N", "A", "A", "N", "N", "A", "A", "A",
                "A", "N", "N", "A", "N", "A", "A", "N", "N", "A", "A", "A"},
            formaSeis = {"N", "A", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N",
                "A", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N",
                "A", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N",
                "A", "A", "A", "N", "A", "N", "N", "A", "A", "N", "N", "N"};

    //Variables de salida
    int respuestasCorrectasNegras, respuestasCorrectasAzules, respuestasCorrectasMixtos,
            respuestasIncorrectasNegras, respuestasIncorrectasAzules, respuestasIncorrectasMixtos,
            respuestasOmitidasNegras, respuestasOmitidasAzules, respuestasOmitidasMixtos;

    //Variables auxiliares de salida
    long tiempoValidoNegras, tiempoValidoAzules, tiempoValidoMixtos, //tiempoShiftingAlternado, tiempoRepeticionesAlternado,
            sumatoriaTiempoReaccionNegras, sumatoriaTiempoReaccionAzules, sumatoriaTiempoReaccionAlternado;
    long acumuladoNegro, acumuladoAzules, acumuladoMixtos;

    private Color verde = Color.decode("#1A8803");

    public int getContadoraux() {
        return contadoraux;
    }

    public void setContadoraux(int contadoraux) {
        this.contadoraux = contadoraux;
    }

    //Variables auxiliares de apoyo
    long auxiliarTiempoInicio, auxiliarTiempoTranscurrido;

    //Listas de valores
    ArrayList<Long> listaTiemposNegras = new ArrayList();
    ArrayList<Long> listaTiemposAzules = new ArrayList();
    ArrayList<Long> listaTiemposMixtos = new ArrayList();

    ArrayList<Long> listaTiemposCorrectosNegras = new ArrayList();
    ArrayList<Long> listaTiemposCorrectosAzules = new ArrayList();
    ArrayList<Long> listaTiemposCorrectosMixtos = new ArrayList();

    ArrayList<Long> listaTiemposIncorrectosNegras = new ArrayList();
    ArrayList<Long> listaTiemposIncorrectosAzules = new ArrayList();
    ArrayList<Long> listaTiemposIncorrectosMixtos = new ArrayList();

    ArrayList<Long> listaTiemposOmitidosNegras = new ArrayList();
    ArrayList<Long> listaTiemposOmitidosAzules = new ArrayList();
    ArrayList<Long> listaTiemposOmitidosMixtos = new ArrayList();

    //Constructor de la clase global local
    private ControlGlobalLocal() {
        objetoLocalGlobal = new Globallocal();
    }

    /**
     * Método singleton de la clase globallocal
     *
     * @return
     */
    public static ControlGlobalLocal getSingletonInstance() {
        if (controlGlobalLocal == null) {
            controlGlobalLocal = new ControlGlobalLocal();
        } else {
        }
        return controlGlobalLocal;
    }

    /**
     * Método que genera números aleatorios para la familiarizacion
     *
     * @return
     */
    private int numeroAleatoriosFamiliarizacion() {
        return ThreadLocalRandom.current().nextInt(1, 4 + 1);
    }

    /**
     * Método que genera números aleatorios para la práctica y la actividad
     *
     * @return
     */
    private int numeroAleatoriosPracticaActividad() {
        return ThreadLocalRandom.current().nextInt(1, 12 + 1);
    }

    /**
     * Método que cuenta el número de figuras de cada tipo en la familiarizacion
     *
     * @return
     */
    private int contadorFigurasFamiliarizacion() {
        int auxiliar = numeroAleatoriosFamiliarizacion();

        if (auxiliar == 1) {
            if (circulo < this.getRepeticiones()) {
                circulo++;
            } else {
                return contadorFigurasFamiliarizacion();
            }
        } else if (auxiliar == 2) {
            if (equis < this.getRepeticiones()) {
                equis++;
            } else {
                return contadorFigurasFamiliarizacion();
            }
        } else if (auxiliar == 3) {
            if (triangulo < this.getRepeticiones()) {
                triangulo++;
            } else {
                return contadorFigurasFamiliarizacion();
            }
        } else {
            if (cuadrado < this.getRepeticiones()) {
                cuadrado++;
            } else {
                return contadorFigurasFamiliarizacion();
            }
        }

        return auxiliar;
    }

    /**
     * Método que cuenta el número de figuras de cada tipo en la familiarizacion
     *
     * @return
     */
    private int contadorFigurasPracticaActividad() {
        int auxiliar = numeroAleatoriosPracticaActividad();

        
        if (auxiliar >= 1 && auxiliar <= 3) {
            if (circulo < this.getRepeticiones()) {
                circulo++;
            } else {
                return contadorFigurasPracticaActividad();
            }
        } else if (auxiliar >= 4 && auxiliar <= 6) {
            if (equis < this.getRepeticiones()) {
                equis++;
            } else {
                return contadorFigurasPracticaActividad();
            }
        } else if (auxiliar >= 7 && auxiliar <= 9) {
            if (triangulo < this.getRepeticiones()) {
                triangulo++;
            } else {
                return contadorFigurasPracticaActividad();
            }
        } else {
            if (cuadrado < this.getRepeticiones()) {
                cuadrado++;
            } else {
                return contadorFigurasPracticaActividad();
            }
        }

        return auxiliar;
    }

    /**
     * Método que establece la presentación de las figuras en el ejercicio mixto
     *
     * @return
     */
    private String[] ordenMixto(int tipo) {
        int auxiliar = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        System.out.println("Lista: " + auxiliar);
        System.out.println("------------------");

        if (tipo == 0) {
            switch (auxiliar) {
                case 0:
                    return formaUno;
                case 1:
                    return formaDos;
                default:
                    return formaTres;
            }
        } else {
            switch (auxiliar) {
                case 0:
                    return formaCuatro;
                case 1:
                    return formaCinco;
                default:
                    return formaSeis;
            }
        }
    }

    /**
     * Método que establece las imágenes en el swing de la familiarización
     *
     */
    private synchronized void familiarizacionFiguras() {
        int figura = contadorFigurasFamiliarizacion();

        switch (figura) {
            case 1:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 2:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equis.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 3:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulo.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 4:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadrado.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
        }

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }

    /**
     * Método que establece las imágenes en el swing de la práctica de las
     * figuras grandes.
     *
     */
    private synchronized void practicaActividadFigurasGrandes() {
        int figura = contadorFigurasPracticaActividad();

        switch (figura) {
            case 1:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulocua.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 2:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloequ.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 3:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulotri.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 4:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equiscir.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 5:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equiscua.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 6:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equistri.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 7:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulocir.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 8:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulocua.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 9:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloequ.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 10:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradocir.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 11:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoequ.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 12:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradotri.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
        }

        long inicio = System.currentTimeMillis();
        auxiliarTiempoInicio = inicio;

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }

        long transcurrido = System.currentTimeMillis() - inicio;

        if (transcurrido >= 10000 || transcurrido <= 200) {
            respuestasOmitidasNegras++;
            listaTiemposOmitidosNegras.add(transcurrido);
        }

        if (transcurrido > 200) {
            listaTiemposNegras.add(transcurrido);
            tiempoValidoNegras += transcurrido;
        }
    }

    /**
     * Método que establece las imágenes en el swing de la práctica de las
     * figuras grandes.
     *
     */
    private synchronized void practicaActividadFigurasPequeñas() {
        int figura = contadorFigurasPracticaActividad();

        switch (figura) {
            case 1:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 2:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 3:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 4:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 5:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 6:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 7:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 8:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 9:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 10:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 11:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 12:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
        }

        long inicio = System.currentTimeMillis();
        auxiliarTiempoInicio = inicio;

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }

        long transcurrido = System.currentTimeMillis() - inicio;

        if (transcurrido >= 10000 || transcurrido <= 200) {
            respuestasOmitidasAzules++;
            listaTiemposOmitidosAzules.add(transcurrido);
        }

        if (transcurrido > 200) {
            listaTiemposAzules.add(transcurrido);
            tiempoValidoAzules += transcurrido;
        }
    }

    /**
     * Método que establece las imagenes en el swing de los ejercicios mixtos
     */
    private synchronized void practicaActividadMixtoA(int tipo) {
        String primerValor = "a", segundoValor, auxiliarValor = "c";
        int contadorGeneral = 0, contadorAuxiliar = 0;
        boolean eventoUno = true, eventoDos = true;

        for (String auxiliar : ordenMixto(tipo)) {
            if (auxiliar.equals("N")) {
                int figura = ThreadLocalRandom.current().nextInt(1, 12 + 1);
                this.practicaActividadMixtoB(figura);

                switch (contadorAuxiliar) {
                    case 0:
                        primerValor = "N";
                        contadorAuxiliar++;
                        break;
                    case 1:
                        segundoValor = "N";
                        auxiliarValor = segundoValor;
                        contadorAuxiliar = 0;
                        break;
                }

                try {
                    wait(500);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }

                getEtiquetaRespuesta().setText("");
            } else {
                int figura = ThreadLocalRandom.current().nextInt(13, 24 + 1);
                this.practicaActividadMixtoB(figura);

                switch (contadorAuxiliar) {
                    case 0:
                        primerValor = "A";
                        contadorAuxiliar++;
                        break;

                    case 1:
                        segundoValor = "A";
                        auxiliarValor = segundoValor;
                        contadorAuxiliar = 0;
                        break;
                }

                try {
                    wait(500);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }

                getEtiquetaRespuesta().setText("");
            }

            if (!(contadorGeneral == 0)) {
                if (auxiliarValor.equals(primerValor)) {
                    seriesRepetidas++;
                } else {
                    seriesShifting++;
                }
            }

            contadorGeneral++;
        }

    }

    private synchronized void practicaActividadMixtoB(int figura) {
        switch (figura) {
            case 1:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulocua.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 2:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloequ.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 3:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulotri.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 4:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equiscir.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 5:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equiscua.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 6:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equistri.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 7:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulocir.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 8:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulocua.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 9:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloequ.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 10:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradocir.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 11:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoequ.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 12:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradotri.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 13:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 14:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 15:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                break;
            case 16:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 17:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 18:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                break;
            case 19:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 20:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 21:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                break;
            case 22:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 23:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
            case 24:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                break;
        }

        long inicio = System.currentTimeMillis();
        auxiliarTiempoInicio = inicio;

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }

        long transcurrido = System.currentTimeMillis() - inicio;

        if (transcurrido >= 10000 || transcurrido <= 200) {
            respuestasOmitidasMixtos++;
            listaTiemposOmitidosMixtos.add(transcurrido);
        }

        if (transcurrido > 200) {
            listaTiemposMixtos.add(transcurrido);
            tiempoValidoMixtos += transcurrido;
        }
    }

    /**
     * Método que captura las respuestas de los usuarios
     *
     * @param respuesta
     * @param etiquetaNombre
     * @param actividad
     * @param tipo
     */
    public synchronized void respuestas(String respuesta, JLabel etiquetaNombre, boolean actividad, String tipo) {
        if (respuesta.equals(etiquetaNombre.getText())) {
            this.etiquetaRespuesta.setText("Correcto");
            if (actividad) {
                if (tipo.equalsIgnoreCase("g")) {
                    auxiliarTiempoTranscurrido = System.currentTimeMillis() - auxiliarTiempoInicio;

                    if (auxiliarTiempoTranscurrido > 200) {
                        listaTiemposCorrectosNegras.add(auxiliarTiempoTranscurrido);
                        sumatoriaTiempoReaccionNegras += auxiliarTiempoTranscurrido;
                        respuestasCorrectasNegras++;
                    }
                } else if (tipo.equalsIgnoreCase("p")) {
                    auxiliarTiempoTranscurrido = System.currentTimeMillis() - auxiliarTiempoInicio;

                    if (auxiliarTiempoTranscurrido > 200) {
                        listaTiemposCorrectosAzules.add(auxiliarTiempoTranscurrido);
                        sumatoriaTiempoReaccionAzules += auxiliarTiempoTranscurrido;
                        respuestasCorrectasAzules++;
                    }
                } else if (tipo.equalsIgnoreCase("m")) {
                    auxiliarTiempoTranscurrido = System.currentTimeMillis() - auxiliarTiempoInicio;

                    if (auxiliarTiempoTranscurrido > 200) {
                        listaTiemposCorrectosMixtos.add(auxiliarTiempoTranscurrido);
                        sumatoriaTiempoReaccionAlternado += auxiliarTiempoTranscurrido;
                        respuestasCorrectasMixtos++;
                    }
                } else {
                    //Nothing happens
                }
            }
            notifyAll();
            if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                this.etiquetaRespuesta.setForeground(verde);
            } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                this.etiquetaRespuesta.setForeground(Color.red);
            }
        } else {
            this.etiquetaRespuesta.setText("Incorrecto");
            if (actividad) {
                if (actividad) {
                    if (tipo.equalsIgnoreCase("g")) {
                        auxiliarTiempoTranscurrido = System.currentTimeMillis() - auxiliarTiempoInicio;

                        if (auxiliarTiempoTranscurrido > 200) {
                            listaTiemposIncorrectosNegras.add(auxiliarTiempoTranscurrido);
                            respuestasIncorrectasNegras++;
                        }
                    } else if (tipo.equalsIgnoreCase("p")) {
                        auxiliarTiempoTranscurrido = System.currentTimeMillis() - auxiliarTiempoInicio;

                        if (auxiliarTiempoTranscurrido > 200) {
                            listaTiemposIncorrectosAzules.add(auxiliarTiempoTranscurrido);
                            respuestasIncorrectasAzules++;
                        }
                    } else if (tipo.equalsIgnoreCase("m")) {
                        auxiliarTiempoTranscurrido = System.currentTimeMillis() - auxiliarTiempoInicio;

                        if (auxiliarTiempoTranscurrido > 200) {
                            listaTiemposIncorrectosMixtos.add(auxiliarTiempoTranscurrido);
                            respuestasIncorrectasMixtos++;
                        }
                    } else {
                        //Nothing happens
                    }
                }
            }
            notifyAll();
            if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                this.etiquetaRespuesta.setForeground(verde);
            } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                this.etiquetaRespuesta.setForeground(Color.red);
            }
        }

    }

    /**
     * Método que hace los cálculos de las variables de análisis
     */
   

    /**
     * Método que ejecuta el hilo de la familiarización
     */
    public void iniciarFamiliarizacion() {
        hiloFamiliarizacion = new Thread(runnableFamiliarizacion);
        hiloFamiliarizacion.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la familiarizacion
     */
    Runnable runnableFamiliarizacion = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloFamiliarizacion < 20) {
                //numerosSwingPractica();
                familiarizacionFiguras();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloFamiliarizacion++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo de la práctica de las figuras grandes
     */
    public void iniciarPracticasGrandes() {
        hiloPracticasGrandes = new Thread(runnablePracticasGrandes);
        hiloPracticasGrandes.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la práctica de las figuras
     * grandes
     */
    Runnable runnablePracticasGrandes = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloPracticaGrande < 12) {
                //numerosSwingPractica();
                practicaActividadFigurasGrandes();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloPracticaGrande++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo de la actividad de las figuras grandes
     */
    public void iniciarActividadGrandes() {
        hiloActividadGrandes = new Thread(runnableActividadGrandes);
        hiloActividadGrandes.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la actividad de las figuras
     * grandes
     */
    Runnable runnableActividadGrandes = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloActividadGrande < 32) {

                practicaActividadFigurasGrandes();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloActividadGrande++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo de la práctica de las figuras pequeñas
     */
    public void iniciarPracticasPequeñas() {
        hiloPracticasPequeñas = new Thread(runnablePracticasPequeñas);
        hiloPracticasPequeñas.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la práctica de las figuras
     * pequeñas
     */
    Runnable runnablePracticasPequeñas = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloPracticaPequeñas < 12) {
                practicaActividadFigurasPequeñas();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloPracticaPequeñas++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo de la actividad de las figuras grandes
     */
    public void iniciarActividadPequeñas() {
        hiloActividadPequeñas = new Thread(runnableActividadPequeñas);
        hiloActividadPequeñas.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la actividad de las figuras
     * grandes
     */
    Runnable runnableActividadPequeñas = new Runnable() {
        @Override
        public void run() {

            while (contadorHiloActividadPequeñas < 32) {
                //numerosSwingPractica();
                practicaActividadFigurasPequeñas();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloActividadPequeñas++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    public void iniciarPracticaMixtos() {
        hiloPracticasMixto = new Thread(runnablePracticasMixtas);
        hiloPracticasMixto.start();
    }

    Runnable runnablePracticasMixtas = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloMixtoPractica < 1) {
                //numerosSwingPractica();
                practicaActividadMixtoA(0);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloMixtoPractica++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    public void iniciarActividadMixtos() {
        hiloActividadMixto = new Thread(runnableActividadMixtas);
        hiloActividadMixto.start();
    }

    Runnable runnableActividadMixtas = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloMixtoActividad < 1) {
                //numerosSwingPractica();
                practicaActividadMixtoA(1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloMixtoActividad++;
            }
            getPantalla().setVisible(false);
            InstruccionesGlobalLocal instrucciones = InstruccionesGlobalLocal.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    
    public Object instruccionesPantalla(JFrame frame, JLabel label) {
        switch (contadoraux) {
            case 0:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En esta actividad se te mostrarán diferentes figuras en pantalla.\n"
                        + "Antes de iniciar! \n"
                        + "Para que te familiarices con las teclas que utilizarás,\n"
                        + "realizarás unos ejercicios de práctica. ");
            case 1:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación \n\n"
                        + "Se te presentarán \n - Círculos\n - Equis\n - Triángulos \n - Cuadrados\n"
                        + "Uno a la vez, en el centro de la pantalla. ");

            case 2:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado-1_2.png")));
                return ("Cuando aparezca \n Un CÍRCULO presionarás la tecla “1”. \n"
                        + "Cuando sea una “X” presionarás la tecla “2”. \n"
                        + "Así que, por favor coloca tus dedos medio e índice de la mano izquierda.");
            case 3:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado-3_4.png")));
                return ("Si aparece \n Un TRIÁNGULO, presionarás la tecla “3”. \n"
                        + "Y si se trata de un CUADRADO la tecla “4”. \n"
                        + "Así que, por favor coloca tus dedos medio e índice de \n"
                        + "la mano derecha en las teclas “3” y “4”. ");
            case 4:
                frame.setVisible(false);
                FamiliarizacionFiguras imagenFiguras = new FamiliarizacionFiguras();
                imagenFiguras.setVisible(true);
                this.setPantalla(imagenFiguras);

            case 5:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_Local-global.png")));
                return ("Recuerda solo presionar:\n\n"
                        + "Tecla «1»: Círculo\n"
                        + "Tecla «2»: Equis\n"
                        + "Tecla «3»: Triángulo \n"
                        + "Tecla «4»: Cuadrado ");
            case 6:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación\n Se te presentarán figuras cuyas líneas estarán\n"
                        + "conformadas por figuras más pequeñas.\n"
                        + "Algunas serán de color negro y otras de color azul.");
            case 7:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Comenzarás con las figuras de color NEGRO. \n\n"
                        + "Así que, lo que harás es presionar la tecla que \n"
                        + "indique la forma de la figura GRANDE. ");
            case 8:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de iniciar\n"
                        + "Podrás ver un ejemplo sobre cómo se presentarán las figuras.\n"
                        + "Así como la manera de responder.");
            case 9:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado17.png")));
                return ("En este caso, presionarías la tecla “1”, \n"
                        + "ya que la figura GRANDE es un CÍRCULO. ");
            case 10:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación"
                        + "\nSe te mostrarán una serie de figuras para practicar.\n"
                        + "Trata de responder lo más rápido que puedas. ");
            case 11:
                frame.setVisible(false);
                PracticaGrandes practicaGrandes = new PracticaGrandes();
                practicaGrandes.setVisible(true);
                this.setPantalla(practicaGrandes);
            case 12:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica. ");
            case 13:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. \n\n"
                        + "Así que, se dejará de indicar cuando la respuesta sea "
                        + "correcta e incorrecta. Haz tu mejor esfuerzo y trata \n"
                        + "de responder lo más rápido posible. ");
            case 14:
                frame.setVisible(false);
                ActividadGrandes actividadGrandes = new ActividadGrandes();
                actividadGrandes.setVisible(true);
                this.setPantalla(actividadGrandes);

            case 15:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En seguida, realizarás la siguiente parte de la actividad. ");
            case 16:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, se te presentarán figuras como las anteriores. \n"
                        + "Sin embargo, ahora serán de color AZUL. Por lo tanto, \n"
                        + "indicarás la forma de las figuras PEQUEÑAS.");
            case 17:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de iniciar, podrás ver un ejemplo sobre cómo se \n"
                        + "presentarán las figuras, así como la manera de responder.");
            case 18:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado51.png")));
                return ("En este caso presionarías la tecla “4”, ya que la figura pequeña es un triángulo.");

            case 19:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora, se te mostrarán una serie de figuras para practicar.\n"
                        + "Recuerda indicar la forma de la figura PEQUEÑA. \n"
                        + "Trata de responder lo más rápido que puedas. ");
            case 20:
                frame.setVisible(false);
                PracticaPequeñas practicaPequeñas = new PracticaPequeñas();
                practicaPequeñas.setVisible(true);
                this.setPantalla(practicaPequeñas);

            case 21:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste todos los ejercicios de práctica. ");
            case 22:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. Así que, se dejará de indicar\n"
                        + "cuando la respuesta sea correcta e incorrecta. \n"
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
            case 23:
                frame.setVisible(false);
                ActividadPequeñas actividadPequeñas = new ActividadPequeñas();
                actividadPequeñas.setVisible(true);
                this.setPantalla(actividadPequeñas);

            case 24:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, verás tanto figuras negras como azules.\n"
                        + "Recuerda que indicarás la forma de la figura GRANDE \n"
                        + "cuando sea NEGRA; y la forma de la PEQUEÑA cuando sea AZUL.");
            case 25:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En seguida, se te mostraran una serie de figuras para practicar.\n"
                        + "Trata de responder lo más rápido que puedas. \n"
                        + "Recuerda colocar tus dedos índice y medio de cada \n"
                        + "mano en la tecla que corresponde.");
            case 26:
                frame.setVisible(false);
                PracticaMixto practicaMixto = new PracticaMixto();
                practicaMixto.setVisible(true);
                this.setPantalla(practicaMixto);

            case 27:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste todos los ejercicios de práctica. ");
            case 28:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. \n"
                        + "Así que, se dejará de indicar cuando la respuesta\n"
                        + "sea correcta e incorrecta.Haz tu mejor esfuerzo y trata\n"
                        + "de responder lo más rápido posible. ");
            case 29:
                frame.setVisible(false);
                ActividadMixto actividadMixto = new ActividadMixto();
                actividadMixto.setVisible(true);
                this.setPantalla(actividadMixto);

            default:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chango.png")));
                return "¡Excelente trabajo! Lo hiciste muy bien."
                        + "Has terminado con esta actividad."
                        + "\n\nFIN DE ACTIVIDAD";
        }
    }

    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    public void setEtiquetaImagen(JLabel etiquetaImagen) {
        this.etiquetaImagen = etiquetaImagen;
    }

    public JLabel getEtiquetaRespuesta() {
        return etiquetaRespuesta;
    }

    public void setEtiquetaRespuesta(JLabel etiquetaRespuesta) {
        this.etiquetaRespuesta = etiquetaRespuesta;
    }

    public JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    public void setEtiquetaNombre(JLabel etiquetaNombre) {
        this.etiquetaNombre = etiquetaNombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Globallocal getObjetoLocalGlobal() {
        return objetoLocalGlobal;
    }

    public void setObjetoLocalGlobal(Globallocal objetoLocalGlobal) {
        this.objetoLocalGlobal = objetoLocalGlobal;
    }

    public int getAuxiliarMixto() {
        return auxiliarMixto;
    }

    public void setAuxiliarMixto(int auxiliarMixto) {
        this.auxiliarMixto = auxiliarMixto;
    }

}
