/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import objetosNegocio.Globallocal;

/**
 *
 * @author David Hermosillo
 */
public class ControlGlobalLocal {
    
    //Variable del objeto control number letter
    private static ControlGlobalLocal controlGlobalLocal;
    
    //Variable referencia del objeto global local
    private Globallocal objetoLocalGlobal;
    
    //Hilos
    private Thread hiloFamiliarizacion, hiloPracticasGrandes, hiloActividadGrandes,
                                        hiloPracticasPequeñas, hiloActividadPequeñas,
                                        hiloPracticasMixto, hiloActividadMixto;
    
    //Contadores
    private int circulo, equis, triangulo, cuadrado, seriesRepetidas, seriesShifting, contadorHiloFamiliarizacion, 
                contadorHiloPracticaGrande, contadorHiloActividadGrande, 
                contadorHiloPracticaPequeñas, contadorHiloActividadPequeñas,
                contadorHiloMixtoPractica, contadorHiloMixtoActividad, auxiliarMixto;
            
    //Etiquetas
    private JLabel etiquetaImagen, etiquetaRespuesta, etiquetaNombre;
    
    //Repeticiones
    private int repeticiones;
    
    //Lista de ordenes
    private final String[] formaUno = {"N","N","A","A","N","A","N","N","A","A","N","N","N"},
                           formaDos = {"A","A","N","N","A","N","A","A","N","N","A","A","A"},
                           formaTres = {"N","A","A","A","N","A","N","N","A","A","N","N","N"},
                           formaCuatro = {"N","N","A","A","N","A","N","N","A","A","N","N","N",
                                              "N","A","A","N","A","N","N","A","A","N","N","N",
                                              "N","A","A","N","A","N","N","A","A","N","N","N",
                                              "N","A","A","N","A","N","N","A","A","N","N","N"},
                           formaCinco = {"A","A","N","N","A","N","A","A","N","N","A","A","A",
                                             "A","N","N","A","N","A","A","N","N","A","A","A",
                                             "A","N","N","A","N","A","A","N","N","A","A","A",
                                             "A","N","N","A","N","A","A","N","N","A","A","A"},
                           formaSeis = {"N","A","A","A","N","A","N","N","A","A","N","N","N", 
                                            "A","A","A","N","A","N","N","A","A","N","N","N",
                                            "A","A","A","N","A","N","N","A","A","N","N","N",
                                            "A","A","A","N","A","N","N","A","A","N","N","N"};
    
    

    //Variables de salida
    int respuestasCorrectasNegras, respuestasCorrectasAzules, respuestasCorrectasMixtos,
        respuestasIncorrectasNegras, respuestasIncorrectasAzules, respuestasIncorrectasMixtos,
        respuestasOmitidasNegras, respuestasOmitidasAzules, respuestasOmitidasMixtos;
    
    //Variables auxiliares de salida
    long tiempoValidoNegras, tiempoValidoAzules, tiempoValidoMixtos, tiempoShiftingAlternado, tiempoRepeticionesAlternado,
         tiempoCorrectasNegras, tiempoCorrectasAzules, tiempoCorrectasMixtos,
         tiempoShiftingAlternadoCorrectas, tiempoRepeticionesAlternadoCorrectas;
    
    //variables auxiliares
    long tiempoInicioAuxiliarA, tiempoInicioAuxiliarB;
    boolean correcta;

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
     * Método que establece las imágenes en el swing de la práctica de las figuras grandes.
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
        tiempoInicioAuxiliarA = inicio;
        
        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
        long transcurrido = System.currentTimeMillis() - inicio;
        
        if(transcurrido >= 10000) {
             respuestasOmitidasNegras++;
        }
        
        if(transcurrido >= 200) {
            tiempoValidoNegras += transcurrido;
        }
    }
    
    /**
     * Método que establece las imágenes en el swing de la práctica de las figuras grandes.
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
        tiempoInicioAuxiliarA = inicio;
        
        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
        long transcurrido = System.currentTimeMillis() - inicio;
        
        if(transcurrido >= 10000) {
             respuestasOmitidasAzules++;
        }
        
        if(transcurrido >= 200) {
            tiempoValidoAzules += transcurrido;
        }
    }
    
    /**
     * Método que establece las imagenes en el swing de los ejercicios mixtos
     */
    private synchronized void practicaActividadMixtoA(int tipo) {
        String primerValor = "a", segundoValor = "b", auxiliarValor = "c";
        int contadorGeneral = 0, contadorAuxiliar = 0;
        
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
                System.out.println("Repetidas: " + seriesRepetidas);
                System.out.println("Shifting: " + seriesShifting);
            } 
            
            contadorGeneral++;
        }

//        long transcurrido = System.currentTimeMillis() - tiempoInicio;
//
//        if (transcurrido > 200) {
//            tiempoRepeticionesAlternado += transcurrido;
//        }
 
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
        tiempoInicioAuxiliarA = inicio;
        
        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
        long transcurrido = System.currentTimeMillis() - inicio;

        if(transcurrido >= 10000) {
             respuestasOmitidasMixtos++;
        }
        
        if(transcurrido >= 200) {
            tiempoValidoMixtos += transcurrido;
        }
    }
    
    /**
     * Método que captura las respuestas de los usuarios
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
                    long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliarA;
                    
                    if(transcurrido > 200) {
                        tiempoCorrectasNegras += transcurrido;
                        respuestasCorrectasNegras++;
                    }
                } else if (tipo.equalsIgnoreCase("p")) {
                    long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliarA;
                    
                    if(transcurrido > 200) {
                        tiempoCorrectasAzules += transcurrido;
                        respuestasCorrectasAzules++;
                    }
                    
                } else if (tipo.equalsIgnoreCase("m")) {
                    long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliarA;
                    
                    if(transcurrido > 200) {
                        tiempoCorrectasMixtos += transcurrido;
                        respuestasCorrectasMixtos++;
                    }
                    
                } else {
                    //Nothing happens
                }
            }
            notifyAll();
        } else {
            this.etiquetaRespuesta.setText("Incorrecto");
            if (actividad) {
                if (actividad) {
                    if (tipo.equalsIgnoreCase("g")) {
                        respuestasIncorrectasNegras++;
                    } else if (tipo.equalsIgnoreCase("p")) {
                        respuestasIncorrectasAzules++;
                    } else if (tipo.equalsIgnoreCase("m")) {
                        respuestasIncorrectasMixtos++;
                    } else {
                        //Nothing happens
                    }
                }
            }
            notifyAll();
        }
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
     * Hilo que cambia los valores de la swing en la práctica de las figuras grandes
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
     * Hilo que cambia los valores de la swing en la actividad de las figuras grandes
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
     * Hilo que cambia los valores de la swing en la práctica de las figuras pequeñas
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
     * Hilo que cambia los valores de la swing en la actividad de las figuras grandes
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
        }
    };
    
    public void calculosGlobalLocal() {
        //I - Tn
        this.objetoLocalGlobal.setTiempoNegras((double) this.tiempoValidoNegras);
        
        //II - Tz
        this.objetoLocalGlobal.setTiempoAzules((double) this.tiempoValidoAzules);
        
        //III - Ta
        this.objetoLocalGlobal.setTiempoAlternado((double) this.tiempoValidoMixtos);
        
        //IV - Tt
        this.objetoLocalGlobal.setTiempoTotal((double)(tiempoValidoNegras + tiempoValidoAzules + tiempoValidoMixtos));
        
        //V - CGt
        this.objetoLocalGlobal.setShiftingGlobalTotal((double)(tiempoValidoMixtos - 
                                                              ((tiempoValidoNegras + tiempoValidoAzules)/2)));
        
        //VI - CLt
        this.objetoLocalGlobal.setShiftingLocalTotal((double)(tiempoShiftingAlternado - tiempoRepeticionesAlternado));
        
        //VII - CGc
        this.objetoLocalGlobal.setShiftingGlobalTotalCorrectas((double)(tiempoCorrectasMixtos - 
                                                              ((tiempoCorrectasNegras + tiempoCorrectasAzules)/2)));
        
        //TCa = tiempoCorrectoMixtos
        //TCn = tiempoCorrectasNegras
        //TCz = tiempoCorrectasAzules
        
        //VIII - CLc
        //Está pendiente
        
        //IX - RCn
        this.objetoLocalGlobal.setCorrectasNegras(respuestasCorrectasNegras);
        
        //X - RCz
        this.objetoLocalGlobal.setCorrectasAzules(respuestasCorrectasAzules);
        
        //XI - RCa
        this.objetoLocalGlobal.setCorrectasAlternado(respuestasCorrectasMixtos);
        
        //XII - RCt
        this.objetoLocalGlobal.setCorrectasTotales(respuestasCorrectasNegras + respuestasCorrectasAzules + respuestasCorrectasMixtos);
        
        //TPn
        double tiempoReaccionPromedioNegras = tiempoCorrectasNegras / respuestasCorrectasNegras;
                
        //TPz
        double tiempoReaccionPromedioAzules = tiempoCorrectasAzules / respuestasCorrectasAzules;
                
        //TPa        
        double tiempoReaccionPromedioMixto = tiempoCorrectasMixtos / respuestasCorrectasMixtos;
        
        //XIII - CGp
        this.objetoLocalGlobal.setShiftingGlobalReaccionCorrectas((double)(tiempoReaccionPromedioMixto - 
                                                     ((tiempoReaccionPromedioNegras + tiempoReaccionPromedioAzules)/2)));
        
        
        
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