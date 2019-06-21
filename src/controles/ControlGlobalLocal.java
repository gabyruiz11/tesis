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
    
    //Control general
    ControlGeneral controlGeneral = ControlGeneral.getSingletonInstance();

    //Variable referencia del objeto global local
    private Globallocal objetoLocalGlobal;

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
    private int respuestasCorrectasNegras, respuestasCorrectasAzules, respuestasCorrectasMixtos,
            respuestasIncorrectasNegras, respuestasIncorrectasAzules, respuestasIncorrectasMixtos,
            respuestasOmitidasNegras, respuestasOmitidasAzules, respuestasOmitidasMixtos, correctasRepeticion,
            correctasShifting, incorrectasRepeticion, incorrectasShifting;

    //Variables auxiliares de salida
    private long tiempoValidoNegras, tiempoValidoAzules, tiempoValidoMixtos, tiempoShifting, tiempoRepeticion,
                 sumatoriaTiempoReaccionNegras, sumatoriaTiempoReaccionAzules, sumatoriaTiempoReaccionAlternado,
                 tiempoShiftingCorrecto, tiempoRepeticionCorrecto;
    
    private long acumuladoNegro, acumuladoAzules, acumuladoMixtos;

    private final Color verde = Color.decode("#1A8803");
    
    private String valorUnoGlobal = "a", valorDosGlobal = "b", auxiliarGlobal = "c";
    private int contador = 0;
    

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
    
    ArrayList<Long> listaTiemposRepeticiones = new ArrayList();
    ArrayList<Long> listaTiemposShifting = new ArrayList();
    
    ArrayList<Long> listaTiemposCorrectosRepeticiones = new ArrayList();
    ArrayList<Long> listaTiemposCorrectosShifting = new ArrayList();

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
    private synchronized void practicaActividadFigurasGrandes(boolean tipo) {
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

        if (tipo == true) {
            long inicio = System.currentTimeMillis();
            auxiliarTiempoInicio = inicio;

            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }

            long transcurrido = System.currentTimeMillis() - inicio;

            if (transcurrido > 200 && transcurrido < 10000) {
                tiempoValidoNegras += transcurrido;
                listaTiemposNegras.add(transcurrido);
            } else {
                respuestasOmitidasNegras++;
                listaTiemposOmitidosNegras.add(transcurrido);
            }
        } else {
            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        }
        
    }

    /**
     * Método que establece las imágenes en el swing de la práctica de las
     * figuras grandes.
     *
     */
    private synchronized void practicaActividadFigurasPequeñas(boolean tipo) {
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
        
        if (tipo == true) {
            long inicio = System.currentTimeMillis();
            auxiliarTiempoInicio = inicio;

            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }

            long transcurrido = System.currentTimeMillis() - inicio;

            if (transcurrido > 200 && transcurrido < 10000) {
                tiempoValidoAzules += transcurrido;
                listaTiemposAzules.add(transcurrido);
            } else {
                respuestasOmitidasAzules++;
                listaTiemposOmitidosAzules.add(transcurrido);
            }
        } else {
            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        }
        
    }

    /**
     * Método que establece las imagenes en el swing de los ejercicios mixtos
     */
    private synchronized void practicaActividadMixtoA(int tipo, boolean ejercicio) {
        String primerValor = "a", segundoValor, auxiliarValor = "c";
        int contadorGeneral = 0, contadorAuxiliar = 0;
        boolean evento = true;
        long tiempoInicio = 0, transcurrido = 0;
        

        for (String auxiliar : ordenMixto(tipo)) {
            if (auxiliar.equals("N")) {
                int figura = ThreadLocalRandom.current().nextInt(1, 12 + 1);
                this.practicaActividadMixtoB(figura, ejercicio);

                switch (contadorAuxiliar) {
                    case 0:
                        
                        if(evento == true) {
                            //1
                            tiempoInicio = System.currentTimeMillis();
                            
                            evento = false;
                        } else {
                            //3
                            transcurrido = System.currentTimeMillis() - tiempoInicio;
                            tiempoInicio = System.currentTimeMillis();
                            evento = true;
                        }
                        
                        primerValor = "N";
                        contadorAuxiliar++;
                        break;
                    case 1:
                        
                        if(evento == false) {
                            //2
                            transcurrido = System.currentTimeMillis() - tiempoInicio;
                            tiempoInicio = System.currentTimeMillis();
                        } else {
                            transcurrido = System.currentTimeMillis() - tiempoInicio;
                        }
                                
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
                this.practicaActividadMixtoB(figura, ejercicio);

                switch (contadorAuxiliar) {
                    case 0:
                        
                        if(evento == true) {
                            //1
                            tiempoInicio = System.currentTimeMillis();
                            evento = false;
                        } else {
                            //3
                            transcurrido = System.currentTimeMillis() - tiempoInicio;
                            tiempoInicio = System.currentTimeMillis();
                            evento = true;
                        }
                        
                        primerValor = "A";
                        contadorAuxiliar++;
                        break;
                    case 1:
                        
                        if(evento == false) {
                            //2
                            transcurrido = System.currentTimeMillis() - tiempoInicio;
                            tiempoInicio = System.currentTimeMillis();
                        } else {
                            transcurrido = System.currentTimeMillis() - tiempoInicio;
                        }
                        
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

            if (ejercicio == true) {
                if (!(contadorGeneral == 0)) {
                    if (auxiliarValor.equals(primerValor)) {
                        seriesRepetidas++;
                        
                        if(transcurrido > 200) {
                            tiempoRepeticion += transcurrido;
                            listaTiemposRepeticiones.add(transcurrido);
                        }
                        
                    } else {
                        seriesShifting++;
                        
                        if(transcurrido > 200) {
                            tiempoShifting += transcurrido;
                            listaTiemposShifting.add(transcurrido);
                        }
                        
                    }
                }
            }
            
            contadorGeneral++;
        }

    }

    private synchronized void practicaActividadMixtoB(int figura, boolean tipo) {
        switch (figura) {
            case 1:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulocua.png")));
                this.etiquetaNombre.setText("Circulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 2:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloequ.png")));
                this.etiquetaNombre.setText("Circulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 3:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulotri.png")));
                this.etiquetaNombre.setText("Circulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 4:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equiscir.png")));
                this.etiquetaNombre.setText("Equis");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 5:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equiscua.png")));
                this.etiquetaNombre.setText("Equis");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 6:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equistri.png")));
                this.etiquetaNombre.setText("Equis");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 7:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulocir.png")));
                this.etiquetaNombre.setText("Triangulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 8:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triangulocua.png")));
                this.etiquetaNombre.setText("Triangulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 9:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloequ.png")));
                this.etiquetaNombre.setText("Triangulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 10:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradocir.png")));
                this.etiquetaNombre.setText("Cuadrado");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 11:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoequ.png")));
                this.etiquetaNombre.setText("Cuadrado");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 12:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradotri.png")));
                this.etiquetaNombre.setText("Cuadrado");
                
                if(contador == 0) {
                    valorUnoGlobal = "N";
                    contador++;
                } else {
                    valorDosGlobal = "N";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 13:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 14:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 15:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulcir.png")));
                this.etiquetaNombre.setText("Circulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 16:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 17:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 18:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulequ.png")));
                this.etiquetaNombre.setText("Equis");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 19:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 20:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuadradoazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 21:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazultri.png")));
                this.etiquetaNombre.setText("Triangulo");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 22:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 23:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/equisazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
            case 24:
                this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trianguloazulcua.png")));
                this.etiquetaNombre.setText("Cuadrado");
                
                if(contador == 0) {
                    valorUnoGlobal = "A";
                    contador++;
                } else {
                    valorDosGlobal = "A";
                    auxiliarGlobal = valorDosGlobal;
                    contador = 0;
                }
                
                break;
        }
        
        if (tipo == true) {
            long inicio = System.currentTimeMillis();
            auxiliarTiempoInicio = inicio;

            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }

            long transcurrido = System.currentTimeMillis() - inicio;

            if (transcurrido > 200 && transcurrido < 10000) {
                tiempoValidoMixtos += transcurrido;
                listaTiemposMixtos.add(transcurrido);
            } else {
                respuestasOmitidasMixtos++;
                listaTiemposOmitidosMixtos.add(transcurrido);
            }
        } else {
            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
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
                        
                        if(auxiliarGlobal.equals(valorUnoGlobal)) {
                            tiempoRepeticionCorrecto += auxiliarTiempoTranscurrido;
                            correctasRepeticion++;
                            listaTiemposCorrectosRepeticiones.add(auxiliarTiempoTranscurrido);
                        } else {
                            tiempoShiftingCorrecto += auxiliarTiempoTranscurrido;
                            correctasShifting++;
                            listaTiemposCorrectosShifting.add(auxiliarTiempoTranscurrido);
                        }
                        
                    }
                } else {
                    //Nothing happens
                }
            }
            
            this.etiquetaRespuesta.setForeground(verde);
            notifyAll();
            
        } else {
            this.etiquetaRespuesta.setText("Incorrecto");
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
                            
                            if (auxiliarGlobal.equals(valorUnoGlobal)) {
                                //tiempoRepeticionCorrecto += auxiliarTiempoTranscurrido;
                                incorrectasRepeticion++;
                            } else {
                                //tiempoShiftingCorrecto += auxiliarTiempoTranscurrido;
                                incorrectasShifting++;
                            }
                            
                        }
                    } else {
                        //Nothing happens
                    }
                }
            
            this.etiquetaRespuesta.setForeground(Color.red);
            notifyAll();
            
        }

    }

    /**
     * Método que hace los cálculos de las variables de análisis
     */
    public void calculosGlobalLocal() {
        //I - Tn - REVISADA - Tiempo total en el bloque de figuras negras
        this.objetoLocalGlobal.setTiempoNegras((double) this.tiempoValidoNegras);
        
        //II - Tz- REVISADA - Tiempo total en el bloque de figuras negras
        this.objetoLocalGlobal.setTiempoAzules((double) this.tiempoValidoAzules);
        
        //III - Ta - REVISADA - Tiempo total en el bloque de figuras alternadas
        this.objetoLocalGlobal.setTiempoAlternado((double) this.tiempoValidoMixtos);
        
        //IV - Tt - REVISADA - Tiempo total en la tarea
        this.objetoLocalGlobal.setTiempoTotal((double)(tiempoValidoNegras + tiempoValidoAzules + tiempoValidoMixtos));
        
        //V - CGt - REVISADA - Costo del shifting global con el tiempo total
        this.objetoLocalGlobal.setShiftingGlobalTotal((double)(tiempoValidoMixtos - 
                                                              ((tiempoValidoNegras + tiempoValidoAzules)/2)));
        
        //VI - CLt - REVISADA - Costo del shifting local con el tiempo total
        this.objetoLocalGlobal.setShiftingLocalTotal((double)(tiempoShifting - tiempoRepeticion));
        
        //Variables auxiliares:
        
            //TCn
            long TCn = sumatoriaTiempoReaccionNegras;
        
            //TCz
            long TCz = sumatoriaTiempoReaccionAzules;
        
            //TCa
            long TCa = sumatoriaTiempoReaccionAlternado;
        
        //VII - CGc - REVISADA - Costo del shifing global con el tiempo total de las respuestas correctas
        this.objetoLocalGlobal.setShiftingGlobalTotalCorrectas((double)(TCa - ((TCn + TCz)/2)));
        
        //VIII - CLc - REVISADA - Costo del shifting local con el tiempo total de las respuestas correctas
        this.objetoLocalGlobal.setShiftingLocalTotalCorrectas((double)(tiempoShiftingCorrecto - tiempoRepeticionCorrecto));
        
        //IX - RCn - REVISADA - Respuestas correctas en el bloque de solo figuras negras
        this.objetoLocalGlobal.setCorrectasNegras(respuestasCorrectasNegras);
        
        //X - RCz - REVISADA - Respuestas correctas en el bloque de solo figuras azules
        this.objetoLocalGlobal.setCorrectasAzules(respuestasCorrectasAzules);
        
        //XI - RCa - REVISADA - Respuestas correctas en el bloque de solo figuras alternadas
        this.objetoLocalGlobal.setCorrectasAlternado(respuestasCorrectasMixtos);
        
        //XII - RCt - REVISADA - Respuestas correctas totales en toda la actividad
        this.objetoLocalGlobal.setCorrectasTotales(respuestasCorrectasNegras + respuestasCorrectasAzules + respuestasCorrectasMixtos);
        
        //Variables auxiliares:
        
            //TPn = TCn/RCn
            double TPn = TCn / respuestasCorrectasNegras;
            
            //TPn = TCz/RCz
            double TPz = TCz / respuestasCorrectasAzules;
            
            //TPa = TCa/RCa
            double TPa = TCa / respuestasCorrectasMixtos;
        
        //XIII - CGp - REVISADA - Costo del shifting global con el tiempo de reacción promedio de las respuestas correctas
        this.objetoLocalGlobal.setShiftingGlobalReaccionCorrectas((double)(TPa - ((TPn + TPz)/2)));
        
        //Variables auxiliares
        
            //TPi
            double TPs = tiempoShiftingCorrecto / correctasShifting;
            
            double TPp = tiempoRepeticionCorrecto / correctasRepeticion;
        
        //XIV - CLp - REVISADA - Costo del shifting local con el tiempo de reacción promedio de las respuestas correctas
        this.objetoLocalGlobal.setShiftingLocalReaccionCorrectas(TPs - TPp);
        
        //Variables auxiliares:
        
            //Rn
            int Rn = respuestasCorrectasNegras + respuestasIncorrectasNegras;
            
            //Rz
            int Rz = respuestasCorrectasAzules + respuestasIncorrectasAzules;
            
            //Ra
            int Ra = respuestasCorrectasMixtos + respuestasIncorrectasMixtos;
            
            //Pn = [(RCn)(100)]/Rn
            double Pn = ((respuestasCorrectasNegras * 100) / Rn);
            
            //Pz = [(RCz)(100)]/Rz
            double Pz = ((respuestasCorrectasAzules * 100) / Rz);
            
            //Pa = [(RCa)(100)]/Ra
            double Pa = ((respuestasCorrectasMixtos * 100) / Ra);
            
        //XV - CGp - REVISADA - Costo del shifting global con porcentaje de respuestas correctas
        this.objetoLocalGlobal.setShiftingGlobalPorcentajeCorrectas((double)(Pa - ((Pn + Pz)/2)));
        
        //Variables auxiliares
        
            //RTp
            int RTr = correctasRepeticion + incorrectasRepeticion; 
            
            //RTi
            int RTs = correctasShifting + incorrectasShifting;
            
            //PCp
            double PCr = (correctasRepeticion * 100) / RTr;
            
            //PCi
            double PCs = (correctasShifting * 100) / RTs;
        
        //XVI - CLp - REVISADA - Costo del shifting local con porcentaje de respuestas correctas
        this.objetoLocalGlobal.setShiftingLocalPorcentajeCorrectas(PCs - PCr);
         
        //XVII - In - REVISADA - Respuestas incorrectas de solo el bloque de figuras negras
        this.objetoLocalGlobal.setIncorrectasNegras(respuestasIncorrectasNegras);
         
        //XVIII - Iz - REVISADA - Respuestas incorrectas de solo el bloque de figuras azules
        this.objetoLocalGlobal.setIncorrectasAzules(respuestasIncorrectasAzules);
         
        //XIX - Ia - REVISADA - Respuestas incorrectas de solo el bloque de figuras mixtas
        this.objetoLocalGlobal.setIncorrectasAlternado(respuestasIncorrectasMixtos);
        
        //XX - It - REVISADA - Respuestas incorrectas totales en toda la actividad
        this.objetoLocalGlobal.setIncorrectasTotales(respuestasIncorrectasNegras + respuestasIncorrectasAzules + respuestasIncorrectasMixtos);
        
        //XXI - ONn - REVISADA - Omisiones y respuestas nulas en el bloque de solo figuras negras
        this.objetoLocalGlobal.setOmisionesNulasNegras(respuestasOmitidasNegras);
        
        //XXII - ONz - REVISADA - Omisiones y respuestas nulas en el bloque de solo figuras azules
        this.objetoLocalGlobal.setOmisionesNulasAzules(respuestasOmitidasAzules);
        
        //XXIII - ONa - REVISADA - Omisiones y respuestas nulas en el bloque de solo figuras alternadas
        this.objetoLocalGlobal.setOmisionesNulasAlternado(respuestasOmitidasMixtos);
        
        //XXIV - ONt - REVISADA - Omisiones y respuestas nulas en toda la actividad
        this.objetoLocalGlobal.setOmisionesNulasTotales(respuestasOmitidasNegras + respuestasOmitidasAzules + respuestasOmitidasMixtos);
        
        //Variables auxiliares:
        
            //---------------------------------------------------------
            //MTTn = Tn/Rn - 1 PASO
            double MTTn = tiempoValidoNegras / Rn;
            
            //DETn - 2 PASO
            listaTiemposNegras.forEach((auxiliar) -> {
                
                double calculoUno = auxiliar - MTTn;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoNegro += calculoDos;
                
            });
            
            //4 PASO
            acumuladoNegro = acumuladoNegro / Rn;
            
            //5 PASO
            double DETn = Math.sqrt(acumuladoNegro);
            //---------------------------------------------------------
            
            double PSTn = MTTn + (DETn * 2.5);
            double PITn = MTTn - (DETn * 2.5);
        
            //---------------------------------------------------------
            //MTTn = Tn/Rn - 1 PASO
            double MTTz = tiempoValidoAzules / Rz;
            
            //DETn - 2 PASO
            listaTiemposAzules.forEach((auxiliar) -> {
                
                double calculoUno = auxiliar - MTTz;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoAzules += calculoDos;
                
            });
            
            //4 PASO
            acumuladoAzules = acumuladoAzules / Rz;
            
            //5 PASO
            double DETz = Math.sqrt(acumuladoAzules);
            //---------------------------------------------------------
        
            double PSTz = MTTz + (DETz * 2.5);
            double PITz = MTTz - (DETz * 2.5);
            
            //---------------------------------------------------------
            //MTTn = Tn/Rn - 1 PASO
            double MTTa = tiempoValidoMixtos / Ra;
            
            //DETn - 2 PASO
            listaTiemposMixtos.forEach((auxiliar) -> {
                
                double calculoUno = auxiliar - MTTa;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoMixtos += calculoDos;
                
            });
            
            //4 PASO
            acumuladoMixtos = acumuladoMixtos / Ra;
            
            //5 PASO
            double DETa = Math.sqrt(acumuladoMixtos);
            //---------------------------------------------------------
        
            double PSTa = MTTa + (DETa * 2.5);
            double PITa = MTTa - (DETa * 2.5);
            
        //XXV - TXn - REVISADA - Tiempo total en el bloque de figuras negras
        double acumuladoNegrasAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposNegras) {
            if(auxiliar >= PITn && auxiliar <= PSTn) {
                acumuladoNegrasAuxiliar += auxiliar;
            }
        }
        
       this.objetoLocalGlobal.setTiempoTotalNegras(acumuladoNegrasAuxiliar);
       
       //XXVI - TXz - REVISADA - Tiempo total en el bloque de figuras azules
       double acumuladoAzulesAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposAzules) {
            if(auxiliar >= PITz && auxiliar <= PSTz) {
                acumuladoAzulesAuxiliar += auxiliar;
            }
        }
        
       this.objetoLocalGlobal.setTiempoTotalAzules(acumuladoAzulesAuxiliar);
       
       //XXVII - TXa - REVISADA - Tiempo total en el bloque de alternado
       double acumuladoMixtosAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposMixtos) {
            if(auxiliar >= PITa && auxiliar <= PSTa) {
                acumuladoMixtosAuxiliar += auxiliar;
            }
        }
        
       this.objetoLocalGlobal.setTiempoTotalAlternado(acumuladoMixtosAuxiliar);
       
       //XXVIII - TXt - REVISADA - Tiempo total en la tarea
       this.objetoLocalGlobal.setTiempoTotalTarea(acumuladoNegrasAuxiliar + acumuladoAzulesAuxiliar + acumuladoMixtosAuxiliar);
       
       //XXIX - CGXt - REVISADA - Costo del shifting global con el tiempo total
       this.objetoLocalGlobal.setShiftingGlobalTiempoTotal((double)(acumuladoMixtosAuxiliar - ((acumuladoNegrasAuxiliar + acumuladoAzulesAuxiliar)/2)));
       
       //XXX - CLXt - REVISADA - Costo del shifting local con el tiempo total
       double acumuladoShiftingAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposShifting) {
            if(auxiliar >= PITa && auxiliar <= PSTa) {
                acumuladoShiftingAuxiliar += auxiliar;
            }
        }
        
        double acumuladoRepeticionAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposRepeticiones) {
            if(auxiliar >= PITa && auxiliar <= PSTa) {
                acumuladoRepeticionAuxiliar += auxiliar;
            }
        }
        
        this.objetoLocalGlobal.setShiftingLocalTiempoTotal(acumuladoShiftingAuxiliar - acumuladoRepeticionAuxiliar);
        
       
       //Variables auxiliares:
            double acumuladoTotalNegro = 0;
            
            //---------------------------------------------------------
            //1 PASO
            double MCTn = TCn / respuestasCorrectasNegras;
            
            //DETn - 2 PASO
            
            for (Long auxiliarTotalNegra : listaTiemposCorrectosNegras) {
                
                double calculoUno = auxiliarTotalNegra - MCTn;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoTotalNegro += calculoDos;
            }
            
            //4 PASO
            acumuladoTotalNegro = acumuladoTotalNegro / respuestasCorrectasNegras;
            
            //5 PASO
            double DECn = Math.sqrt(acumuladoTotalNegro);
            //---------------------------------------------------------
            
            double PSCn = MCTn + (DECn * 2.5);
            double PICn = MCTn - (DECn * 2.5);
            
        //Variables auxiliares:
            double acumuladoTotalAzules = 0;
            
            //---------------------------------------------------------
            //1 PASO
            double MCTz = TCz / respuestasCorrectasAzules;
            
            //DETn - 2 PASO
            
            for (Long auxiliarTotalAzules : listaTiemposCorrectosAzules) {
                
                double calculoUno = auxiliarTotalAzules - MCTz;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoTotalAzules += calculoDos;
            }
            
            //4 PASO
            acumuladoTotalAzules = acumuladoTotalAzules / respuestasCorrectasAzules;
            
            //5 PASO
            double DECz = Math.sqrt(acumuladoTotalAzules);
            //---------------------------------------------------------
            
            double PSCz = MCTz + (DECz * 2.5);
            double PICz = MCTz - (DECz * 2.5);
            
        //Variables auxiliares:
            double acumuladoTotalMixto = 0;
            
            //---------------------------------------------------------
            //1 PASO
            double MCTa = TCa / respuestasCorrectasMixtos;
            
            //DETn - 2 PASO
            
            for (Long auxiliarTotalMixto : listaTiemposCorrectosMixtos) {
                
                double calculoUno = auxiliarTotalMixto - MCTa;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoTotalMixto += calculoDos;
            }
            
            //4 PASO
            acumuladoTotalMixto = acumuladoTotalMixto / respuestasCorrectasMixtos;
            
            //5 PASO
            double DECa = Math.sqrt(acumuladoTotalMixto);
            //---------------------------------------------------------
            
            double PSCa = MCTn + (DECa * 2.5);
            double PICa = MCTn - (DECa * 2.5);

        //XXXI - TCan - REVISADA - Tiempo de reacción de las respuestas correctas en el bloque de solo figuras negras:
        double acumuladoCorrectasNegrasAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposCorrectosNegras) {
            if(auxiliar >= PICn && auxiliar <= PSCn) {
                acumuladoCorrectasNegrasAuxiliar += auxiliar;
            }
        }
        
        this.objetoLocalGlobal.setTiempoReaccionCorrectasNegras(acumuladoCorrectasNegrasAuxiliar);
        
        //XXXII - TCan - REVISADA - Tiempo de reacción de las respuestas correctas en el bloque de solo figuras azules:
        double acumuladoCorrectasAzulesAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposCorrectosAzules) {
            if(auxiliar >= PICz && auxiliar <= PSCz) {
                acumuladoCorrectasAzulesAuxiliar += auxiliar;
            }
        }
        
        this.objetoLocalGlobal.setTiempoReaccionCorrectasAzules(acumuladoCorrectasAzulesAuxiliar);
        
        //XXXIII - TCaz - REVISADA - Tiempo de reacción de las respuestas correctas en el bloque de solo figuras mixtas:
        double acumuladoCorrectasMixtoAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposCorrectosMixtos) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                acumuladoCorrectasMixtoAuxiliar += auxiliar;
            }
        }
        
        this.objetoLocalGlobal.setTiempoReaccionCorrectasAlternado(acumuladoCorrectasMixtoAuxiliar);
        
        //XXXIV - TCat - Revisada
        this.objetoLocalGlobal.setTiempoReaccionCorrectasTotales(acumuladoCorrectasNegrasAuxiliar + 
                                                                 acumuladoCorrectasAzulesAuxiliar +
                                                                 acumuladoCorrectasMixtoAuxiliar);
        
        //XXXV - CGac - REVISADA - Costo del shifting global con el tiempo total de las respuestas correctas
        this.objetoLocalGlobal.setShiftingGlobalTiempoTotalCorrectas((double)(acumuladoCorrectasMixtoAuxiliar - 
                                             ((acumuladoCorrectasNegrasAuxiliar + acumuladoCorrectasAzulesAuxiliar)/2)));
       
        //XXXVI - CLac - REVISADA - Costo del shifting local con el tiempo total de las respuestas correctas
        double acumuladoShiftingCorrectasAuxiliar = 0;
        int contadorCorrectasShifting = 0;
        
        for (Long auxiliar : listaTiemposCorrectosShifting) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                acumuladoShiftingCorrectasAuxiliar += auxiliar;
                contadorCorrectasShifting++;
            }
        }
        
        double acumuladoRepeticionCorrectasAuxiliar = 0;
        int contadorCorrectasRepeticion = 0;
        
        for (Long auxiliar : listaTiemposCorrectosRepeticiones) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                acumuladoRepeticionCorrectasAuxiliar += auxiliar;
                contadorCorrectasRepeticion++;
            }
        }
        
        this.objetoLocalGlobal.setShiftingLocalTiempoTotalCorrectas(acumuladoShiftingCorrectasAuxiliar - 
                                                                    acumuladoRepeticionCorrectasAuxiliar);
        
       
        //XXXVII - RCan - REVISADA - Respuestas correctas en el bloque de solo figuras negras
        int contadorCorrectasNegras = 0;
       
        for (Long auxiliar : listaTiemposCorrectosNegras) {
            if (auxiliar >= PICn && auxiliar <= PSCn) {
                contadorCorrectasNegras++;
            }
        }
        
        this.objetoLocalGlobal.setCorrectasTotalesNegras(contadorCorrectasNegras);
        
        //XXXVIII - RCaz - REVISADA - Respuestas correctas en el bloque de solo figuras azules
        int contadorCorrectasAzules = 0;
       
        for (Long auxiliar : listaTiemposCorrectosAzules) {
            if(auxiliar >= PICz && auxiliar <= PSCz) {
                contadorCorrectasAzules++;
            }
        }
        
        this.objetoLocalGlobal.setCorrectasTotalesAzules(contadorCorrectasAzules);
        
        //XXXIX - RCaa - REVISADA - Respuestas correctas en el bloque de solo figuras mixtas
        int contadorCorrectasMixtos = 0;
       
        for (Long auxiliar : listaTiemposCorrectosMixtos) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                contadorCorrectasMixtos++;
            }
        }
        
        this.objetoLocalGlobal.setCorrectasTotalesAlternado(contadorCorrectasMixtos);
        
        //XL - RCat - REVISADA - Respuestas correctas en toda la tarea
        this.objetoLocalGlobal.setCorrectasTotalesTarea(contadorCorrectasNegras + 
                                                        contadorCorrectasAzules + 
                                                        contadorCorrectasMixtos);
        
        //Variables auxiliares
        
            //TPΔZ
            double TPan = acumuladoCorrectasNegrasAuxiliar / contadorCorrectasNegras;
            
            //TPΔZ
            double TPaz = acumuladoCorrectasAzulesAuxiliar / contadorCorrectasAzules;
            
            //TPΔZ
            double TPaa = acumuladoCorrectasMixtoAuxiliar / contadorCorrectasMixtos;
            
        //XLI - CGap - REVISADA - Costo del shifting global con el tiempo de reacción promedio de las respuestas correctas
        this.objetoLocalGlobal.setShiftingGlobalTiempoReaccionCorrectas((double)(TPaa - ((TPan + TPaz)/2)));
        
        //XLII - CLap - REVISADA - Costo del shifting local con el tiempo de reacción promedio de las respuestas correctas
        
            //TPΔs
            double TPas = acumuladoShiftingCorrectasAuxiliar / contadorCorrectasShifting;
            
            //TPΔr
            double TPar = acumuladoRepeticionCorrectasAuxiliar / contadorCorrectasRepeticion;
            
        this.objetoLocalGlobal.setShiftingLocalTiempoReaccionCorrectas(TPas - TPar);
        
        //Variables auxiliares
        
            //Ran
            int contadorRespuetasTotalesNegras = 0;
            
            for (Long auxiliar : listaTiemposNegras) {
                if (auxiliar >= PITn && auxiliar <= PSTn) {
                    contadorRespuetasTotalesNegras++;
                }
            }
            
            //Pan
            double Pan = (contadorCorrectasNegras * 100)/contadorRespuetasTotalesNegras;
            
            //----------------------------------------------------------------------------
            
            //Raz
            int contadorRespuetasTotalesAzules = 0;
            
            for (Long auxiliar : listaTiemposAzules) {
                if (auxiliar >= PITz && auxiliar <= PSTz) {
                    contadorRespuetasTotalesAzules++;
                }
            }
            
            //Paz
            double Paz = (contadorCorrectasAzules * 100)/contadorRespuetasTotalesAzules;
            
            //----------------------------------------------------------------------------
            
            //Raa
            int contadorRespuetasTotalesMixtos = 0;
            
            for (Long auxiliar : listaTiemposMixtos) {
                if (auxiliar >= PITa && auxiliar <= PSTa) {
                    contadorRespuetasTotalesMixtos++;
                }
            }
            
            //Paa
            double Paa = (contadorCorrectasMixtos * 100)/contadorRespuetasTotalesMixtos;
            
        //XLIII - REVISADA - Costo del shifting global con porcentaje de respuestas correctas
        this.objetoLocalGlobal.setShiftingGlobalPorcentajeTotalCorrectas((double)(Paa - ((Pan + Paz)/2)));
        
        //Variables auxiliares
        
            //Ras
            int contadorRespuetasTotalesShifting = 0;
            
            for (Long auxiliar : listaTiemposShifting) {
                if (auxiliar >= PITa && auxiliar <= PSTa) {
                    contadorRespuetasTotalesShifting++;
                }
            }
            
            //Pai
            double Pas = (contadorCorrectasShifting * 100) / contadorRespuetasTotalesShifting;
            
            //----------------------------------------------------------------------------
            
            //Rar
            int contadorRespuetasTotalesRepeticion = 0;
            
            for (Long auxiliar : listaTiemposRepeticiones) {
                if (auxiliar >= PITa && auxiliar <= PSTa) {
                    contadorRespuetasTotalesRepeticion++;
                }
            }
            
            //Pap
            double Par = (contadorCorrectasRepeticion * 100) / contadorRespuetasTotalesRepeticion;
        
        //XLIV - REVISADA - Costo del shifting local con porcentaje de respuestas correctas
        this.objetoLocalGlobal.setShiftingLocalPorcentajeTotalCorrectas(Pas - Par);
        
        //XLV - RIan - REVISADA - Respuestas incorrectas en el bloque de solo figuras negras
        int contadorIncorrectasNegras = 0;
       
        for (Long auxiliar : listaTiemposIncorrectosNegras) {
            if (auxiliar >= PITn && auxiliar <= PSTn) {
                contadorIncorrectasNegras++;
            }
        }
        
        this.objetoLocalGlobal.setIncorrectasTotalesNegras(contadorIncorrectasNegras);
        
        //XLVI - RIaz - REVISADA - Respuestas incorrectas en el bloque de solo figuras azules
        int contadorIncorrectasAzules = 0;
       
        for (Long auxiliar : listaTiemposIncorrectosAzules) {
            if (auxiliar >= PITz && auxiliar <= PSTz) {
                contadorIncorrectasAzules++;
            }
        }
        
        this.objetoLocalGlobal.setIncorrectasTotalesAzules(contadorIncorrectasAzules);
        
        //XLVII - RIaa - REVISADA - Respuestas incorrectas en el bloque de solo figuras mixtas
        int contadorIncorrectasMixtos = 0;
       
        for (Long auxiliar : listaTiemposIncorrectosMixtos) {
            if (auxiliar >= PITa && auxiliar <= PSTa) {
                contadorIncorrectasMixtos++;
            }
        }
        
        this.objetoLocalGlobal.setIncorrectasTotalesAlternado(contadorIncorrectasMixtos);
        
        //XLVIII - RIat - REVISADA - Respuestas incorrectas en toda la tarea
        this.objetoLocalGlobal.setIncorrectasTotalesTarea(contadorIncorrectasNegras + 
                                                          contadorIncorrectasAzules +
                                                          contadorIncorrectasMixtos); 
        
        //XLIX - ONan - REVISADA - Respuestas omitidas en el bloque de solo figuras negras
        int contadorOmitidasNegras = 0;
       
        for (Long auxiliar : listaTiemposOmitidosNegras) {
            if (auxiliar >= PITn && auxiliar <= PSTn) {
                contadorOmitidasNegras++;
            }
        }
        
        this.objetoLocalGlobal.setOmisionesNulasTotalesNegras(contadorOmitidasNegras);
        
        //L - ONaz - REVISADA - Respuestas omitidas en el bloque de solo figuras azules
        int contadorOmitidasAzules = 0;
       
        for (Long auxiliar : listaTiemposOmitidosAzules) {
            if (auxiliar >= PITz && auxiliar <= PSTz) {
                contadorOmitidasAzules++;
            }
        }
        
        this.objetoLocalGlobal.setOmisionesNulasTotalesAzules(contadorOmitidasAzules);
        
        //LI - ONaa - REVISADA - Respuestas omitidas en el bloque de solo figuras azules
        int contadorOmitidasMixtos = 0;
       
        for (Long auxiliar : listaTiemposOmitidosMixtos) {
            if (auxiliar >= PITa && auxiliar <= PSTa) {
                contadorOmitidasMixtos++;
            }
        }
        
        this.objetoLocalGlobal.setOmisionesNulasTotalesAlternado(contadorOmitidasMixtos);
        
        //LII - ONaa - REVISADA - Respuestas omitidas en toda la tarea
        this.objetoLocalGlobal.setOmisionesNulasTotalesTarea(contadorOmitidasNegras + 
                                                             contadorOmitidasAzules +
                                                             contadorOmitidasMixtos); 
    }

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
            
            //Se vacian las variables porque se usan las mismas en varios ejercicios;
            circulo = 0;
            equis = 0;
            triangulo = 0;
            cuadrado = 0;
            
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
                practicaActividadFigurasGrandes(false);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloPracticaGrande++;
            }
            
            //Se vacian las variables porque se usan las mismas en varios ejercicios;
            circulo = 0;
            equis = 0;
            triangulo = 0;
            cuadrado = 0;
            
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

                practicaActividadFigurasGrandes(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloActividadGrande++;
            }
            
            //Se vacian las variables porque se usan las mismas en varios ejercicios;
            circulo = 0;
            equis = 0;
            triangulo = 0;
            cuadrado = 0;
            
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
                practicaActividadFigurasPequeñas(false);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloPracticaPequeñas++;
            }
            
            circulo = 0;
            equis = 0;
            triangulo = 0;
            cuadrado = 0;
            
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
                practicaActividadFigurasPequeñas(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloActividadPequeñas++;
            }
            
            circulo = 0;
            equis = 0;
            triangulo = 0;
            cuadrado = 0;
            
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
                
                practicaActividadMixtoA(0, false);
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
                practicaActividadMixtoA(1, true);
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
            setPantalla(instrucciones);
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
                //this.setContadoraux(this.getContadoraux() + 1);
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

            case 30:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chango.png")));
                return "¡Excelente trabajo! Lo hiciste muy bien."
                        + "Has terminado con esta actividad."
                        + "\n\nFIN DE ACTIVIDAD";
            
            case 31:
                getPantalla().setVisible(false);
                controlGeneral.ejecutarEjercicios(this.getPantalla());
            default:
                return null;
                
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

    public JFrame getPantalla() {
        return pantalla;
    }

    public void setPantalla(JFrame pantalla) {
        this.pantalla = pantalla;
    }
    
    public int getContadoraux() {
        return contadoraux;
    }

    public void setContadoraux(int contadoraux) {
        this.contadoraux = contadoraux;
    }

}
