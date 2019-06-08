/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import objetosAuxiliares.ImagenGlobalLocal;

/**
 *
 * @author David Hermosillo
 */
public class ControlGlobalLocal {
    
    //Variable del objeto control number letter
    private static ControlGlobalLocal controlGlobalLocal;
    
    //Hilos
    private Thread hiloFamiliarizacion, hiloPracticasGrandes, hiloActividadGrandes,
                                        hiloPracticasPequeñas, hiloActividadPequeñas,
                                        hiloPracticasMixto, hiloActividadMixto;
    
    //Contadores
    private int circulo, equis, triangulo, cuadrado, contadorHiloFamiliarizacion, 
            contadorHiloPracticaGrande, contadorHiloActividadGrande, 
            contadorHiloPracticaPequeñas, contadorHiloActividadPequeñas,
            contadorHiloMixtoPractica, contadorHiloMixtoActividad;
            
    
    //Labels
    private JLabel etiquetaImagen, etiquetaRespuesta, etiquetaNombre;
    
    //
    private int repeticiones, seriesRepetidas, seriesShifting;

    //Constructor de la clase global local
    private ControlGlobalLocal() {
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
     * Método que genera números aleatorios para los mixtos
     * @return 
     */
    private int numeroAleatoriosMixto() {
        return ThreadLocalRandom.current().nextInt(1, 2 + 1);
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
        
        System.out.println("------------------------");
        System.out.println("Circulos: " + circulo);
        System.out.println("Equis: " + equis);
        System.out.println("Triangulos: " + triangulo);
        System.out.println("Cuadrado: " + cuadrado);
        
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
        
        System.out.println("------------------------");
        System.out.println("Circulos: " + circulo);
        System.out.println("Equis: " + equis);
        System.out.println("Triangulos: " + triangulo);
        System.out.println("Cuadrado: " + cuadrado);
        
        return auxiliar;
    }
    
    /**
     * Método que cuenta el número de figuras de cada tipo en la familiarizacion
     * @return 
     */
    private int contadorSeriesMixtos() {
        int auxiliar = numeroAleatoriosMixto();
        
        if (auxiliar == 1) {
            if (seriesRepetidas < this.getRepeticiones()) {
                seriesRepetidas++;
            } else {
                return contadorSeriesMixtos();
            }
        } else {
            if (seriesShifting < this.getRepeticiones()) {
                seriesShifting++;
            } else {
                return contadorSeriesMixtos();
            }
        } 
        
        System.out.println("------------------------");
        System.out.println("Repetidas: " + seriesRepetidas);
        System.out.println("Shifting: " + seriesShifting);
        
        return auxiliar;
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

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }
    
    /**
     * Método que establece las imagenes en el swing de los ejercicios mixtos
     */
    private synchronized void practicaActividadMixtoA() {
        int ejercicio = contadorSeriesMixtos();

        if (ejercicio == 1) {

            int orden = ThreadLocalRandom.current().nextInt(1, 2 + 1);

            if (orden == 1) {
                int contador = 0;

                while (contador < 2) {
                    int figura = ThreadLocalRandom.current().nextInt(1, 12 + 1);
                    contador++;
                    this.practicaActividadMixtoB(figura);
                    
                    try {
                        wait(500);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error");
                    }
                    getEtiquetaRespuesta().setText("");
                }
            } else {
                int contador = 0;

                while (contador < 2) {
                    int figura = ThreadLocalRandom.current().nextInt(13, 24 + 1);
                    contador++;
                    this.practicaActividadMixtoB(figura);
                    
                    try {
                        wait(500);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error");
                    }
                    getEtiquetaRespuesta().setText("");
                }
            }
        } else {

            int orden = ThreadLocalRandom.current().nextInt(1, 2 + 1);

            if (orden == 1) {
                int contador = 0;

                while (contador < 2) {
                    if (contador == 0) {
                        int figura = ThreadLocalRandom.current().nextInt(1, 12 + 1);
                        contador++;
                        this.practicaActividadMixtoB(figura);
                    } else if (contador == 1) {
                        int figura = ThreadLocalRandom.current().nextInt(13, 24 + 1);
                        contador++;
                        this.practicaActividadMixtoB(figura);
                    }
                    
                    try {
                        wait(500);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error");
                    }
                    getEtiquetaRespuesta().setText("");
                }
            } else {
                int contador = 0;

                while (contador < 2) {
                    if (contador == 0) {
                        int figura = ThreadLocalRandom.current().nextInt(13, 24 + 1);
                        contador++;
                        this.practicaActividadMixtoB(figura);
                    } else if (contador == 1) {
                        int figura = ThreadLocalRandom.current().nextInt(1, 12 + 1);
                        contador++;
                        this.practicaActividadMixtoB(figura);
                    }
                    
                    try {
                        wait(500);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error");
                    }
                    getEtiquetaRespuesta().setText("");
                }
            }
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
        
        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
    }
    
    /**
     * Método que captura las respuestas de los usuarios
     * @param respuesta
     * @param etiquetaNombre 
     * @param actividad 
     */
    public synchronized void respuestas(String respuesta, JLabel etiquetaNombre, boolean actividad) {
        if (respuesta.equals(etiquetaNombre.getText())) {
            this.etiquetaRespuesta.setText("Correcto");
            
            if(actividad){
                //Aquí capturarás las respuestas, pero solo en la actividad
            }
            
            notifyAll();
        } else {
            this.etiquetaRespuesta.setText("Incorrecto");
            
            if(actividad) {
                //Aquí capturarás las respuestas, pero solo en la actividad
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
                //numerosSwingPractica();
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
            while (contadorHiloMixtoPractica < 12) {
                //numerosSwingPractica();
                practicaActividadMixtoA();
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
            while (contadorHiloMixtoPractica < 48) {
                //numerosSwingPractica();
                practicaActividadMixtoA();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                getEtiquetaRespuesta().setText("");
                contadorHiloMixtoPractica++;
            }
        }
    };

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
    
}