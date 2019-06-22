/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import guiNumberLetter.ActividadLetras;
import guiNumberLetter.ActividadNumeros;
import guiNumberLetter.FamiliarizacionLetras;
import guiNumberLetter.FamiliarizacionNumeros;
import guiNumberLetter.InstruccionNL;
import guiNumberLetter.InstruccionNL2;
import guiNumberLetter.InstruccionesNumberLetter;
import guiNumberLetter.MixtoActividad;
import guiNumberLetter.MixtoPractica;
import guiNumberLetter.PracticaLetras;
import guiNumberLetter.PracticaNumeros;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import objetosNegocios.Numberletter;
import persistencia.Persistencia;

/**
 *
 * @author David Hermosillo
 */
public class ControlNumberLetter {

    //Variable que crea el objeto number letter
    private final objetosNegocios.Numberletter objetoNumberLetter;

    //Variable que llama a la persistencia;
    private final Persistencia persistencia = Persistencia.getSingletonInstance();

    //Variable del objeto control number letter
    private static ControlNumberLetter controlNumberLetter;
    
    //Control general
    ControlGeneral controlGeneral = ControlGeneral.getSingletonInstance();

    //Variables auxiliares
    private List<Integer> numerosImagenes = new ArrayList();
    private List<String> letras = new ArrayList();
    private List<String> vocales = new ArrayList();
    private List<String> consonantes = new ArrayList();

    private int contadorHiloPracticaNumeros = 0, contadorHiloFamiliarizacionNumeros = 0, contadorImagenes = 0, contadorHiloActividadNumeros = 0,
            contadorHiloPracticaLetras = 0, contadorHiloFamiliarizacionLetras = 0, contadorHiloActividadLetras = 0, contadoraux,
            contadorHiloPracticaMixto = 0, contadorHiloActividadMixto = 0;

    private JLabel etiquetaA, etiquetaB, etiquetaC, etiquetaD, etiquetaE, etiquetaF, etiquetaG, etiquetaH,
            etiquetaString, etiquetaRespuesta, etiquetaImagen;
    private Thread hiloPracticaNumeros, hiloFamiliarizacionNumeros, hiloActividadNumeros,
            hiloPracticaLetras, hiloFamiliarizacionLetras, hiloActividadLetras,
            hiloPracticasMixto, hiloActividadMixto;

    private int pares = 0, impares = 0, repeticiones = 0,
                vocal = 0, consonante = 0, relojSwing = 0;

    private final Color verde = Color.decode("#1A8803");
    private JFrame pantalla = null;
    
    //Variables de salida
    private int correctasLetras, correctasNumeros, correctasMixtos,
                incorrectasLetras, incorrectasNumeros, incorrectasMixtos,
                omitidasLetras, omitidasNumeros, omitidasMixtos,
                correctasImpares, correctasPares,
                incorrectasImpares, incorrectasPares;
    
    private long acumuladoTiempoLetra, acumuladoTiempoNumero, acumuladoTiempoMixtos, 
                 acumuladoTiempoImpares, acumuladoTiempoPares,
            
                 acumuladoTiempoCorrectoLetra, acumuladoTiempoCorrectaNumero, acumuladoTiempoCorrectoMixtos,
                 acumuladoTiempoCorrectoImpares, acumuladoTiempoCorrectoPares;
    
    //Variables auxiliares
    long tiempoInicioAuxiliar;
    
    ArrayList<Long> listaTiemposLetras = new ArrayList();
    ArrayList<Long> listaTiemposNumeros = new ArrayList();
    ArrayList<Long> listaTiemposMixtos = new ArrayList();
    
    ArrayList<Long> listaTiemposCorrectosLetras = new ArrayList();
    ArrayList<Long> listaTiemposCorrectosNumeros = new ArrayList();
    ArrayList<Long> listaTiemposCorrectosMixtos = new ArrayList();
    
    ArrayList<Long> listaTiemposIncorrectosLetras = new ArrayList();
    ArrayList<Long> listaTiemposIncorrectosNumeros = new ArrayList();
    ArrayList<Long> listaTiemposIncorrectosMixtos = new ArrayList();
    
    ArrayList<Long> listaTiemposOmitidosLetras = new ArrayList();
    ArrayList<Long> listaTiemposOmitidosNumeros = new ArrayList();
    ArrayList<Long> listaTiemposOmitidosMixtos = new ArrayList();
    
    ArrayList<Long> listaTiemposPares = new ArrayList();
    ArrayList<Long> listaTiemposImpares = new ArrayList();
    
    ArrayList<Long> listaTiemposCorrectosPares = new ArrayList();
    ArrayList<Long> listaTiemposCorrectosImpares = new ArrayList();

    /**
     * Constuctor que crea un objeto de tipo control con el objeto de plus minus
     */
    private ControlNumberLetter() {
        objetoNumberLetter = new Numberletter();
    }

    /**
     * Método singleton de la clase numberletter
     *
     * @return
     */
    public static ControlNumberLetter getSingletonInstance() {
        if (controlNumberLetter == null) {
            controlNumberLetter = new ControlNumberLetter();
        } else {
        }
        return controlNumberLetter;
    }

    /**
     * Método que se encarga de llamar a la persistencia para proceder a agregar
     * el objeto
     */
    private void agregarNumberLetterC() {
        if (persistencia.agregarNumberLetterBD(objetoNumberLetter)) {
            JOptionPane.showMessageDialog(null, "Se guardó con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar");
        }
    }

    /**
     * Método que establece las imágenes en el swing de la familiarización de
     * los números.
     *
     */
    public synchronized void numerosFamiliarizacion() {
        int numeroAleatorio = numeroAleatorios();

        if (numerosImagenes.contains(numeroAleatorio)) {
            if (contadorImagenes == 8) {
                //No hacer nada
            } else {
                this.numerosFamiliarizacion();
            }
        } else {
            contadorImagenes++;
            switch (numeroAleatorio) {
                case 2:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png")));
                    this.etiquetaString.setText("2");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 3:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
                    this.etiquetaString.setText("3");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 4:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png")));
                    this.etiquetaString.setText("4");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 5:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png")));
                    this.etiquetaString.setText("5");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 6:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png")));
                    this.etiquetaString.setText("6");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 7:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7.png")));
                    this.etiquetaString.setText("7");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 8:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8.png")));
                    this.etiquetaString.setText("8");
                    numerosImagenes.add(numeroAleatorio);
                    break;
                case 9:
                    this.etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9.png")));
                    this.etiquetaString.setText("9");
                    numerosImagenes.add(numeroAleatorio);
                    break;
            }

            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        }
    }

    /**
     * Método que establece las imágenes en el swing de la familiarización de
     * las letras.
     *
     */
    public synchronized void letrasFamiliarizacion() {
        String letraAleatoria = letraAleatorias();

        if (letras.contains(letraAleatoria)) {
            if (letras.size() == 8) {
                //Aquí debería de abrise la otra pestaña
            } else {
                this.letrasFamiliarizacion();
            }
        } else {
            switch (letraAleatoria) {
                case "A":
                    this.etiquetaString.setText("A");
                    letras.add(letraAleatoria);
                    break;
                case "E":
                    this.etiquetaString.setText("E");
                    letras.add(letraAleatoria);
                    break;
                case "G":
                    this.etiquetaString.setText("G");
                    letras.add(letraAleatoria);
                    break;
                case "I":
                    this.etiquetaString.setText("I");
                    letras.add(letraAleatoria);
                    break;
                case "K":
                    this.etiquetaString.setText("K");
                    letras.add(letraAleatoria);
                    break;
                case "M":
                    this.etiquetaString.setText("M");
                    letras.add(letraAleatoria);
                    break;
                case "R":
                    this.etiquetaString.setText("R");
                    letras.add(letraAleatoria);
                    break;
                case "U":
                    this.etiquetaString.setText("U");
                    letras.add(letraAleatoria);
                    break;
            }

            try {
                wait(10000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        }
    }

    /**
     * Método que cambia los números en el swing de la práctica
     */
    public synchronized void numerosSwingPractica() {
        int numero = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        String letraAleatoria = letraAleatorias();
        int numeroAleatorio = parImpar();

        if (!(contadorHiloPracticaNumeros % 2 == 0)) {
            if (numero == 0) {
                etiquetaA.setText(String.valueOf(numeroAleatorio));
                etiquetaB.setText(letraAleatoria);
                etiquetaC.setText("");
                etiquetaD.setText("");
            } else {
                etiquetaA.setText(letraAleatoria);
                etiquetaB.setText(String.valueOf(numeroAleatorio));
                etiquetaC.setText("");
                etiquetaD.setText("");
            }
        } else {
            if (numero == 0) {
                etiquetaC.setText(String.valueOf(numeroAleatorio));
                etiquetaD.setText(letraAleatoria);
                etiquetaA.setText("");
                etiquetaB.setText("");
            } else {
                etiquetaC.setText(letraAleatoria);
                etiquetaD.setText(String.valueOf(numeroAleatorio));
                etiquetaA.setText("");
                etiquetaB.setText("");
            }
        }

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }

    /**
     * Método que cambia las letras en el swing de la práctica
     */
    public synchronized void letrasSwingPractica() {
        int numero = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        String letraAleatoria = vocalConsonante();

        int numeroAleatorio = numeroAleatorios();

        if (!(contadorHiloPracticaLetras % 2 == 0)) {
            if (numero == 0) {
                etiquetaA.setText(String.valueOf(numeroAleatorio));
                etiquetaB.setText(letraAleatoria);
                etiquetaC.setText("");
                etiquetaD.setText("");
            } else {
                etiquetaA.setText(letraAleatoria);
                etiquetaB.setText(String.valueOf(numeroAleatorio));
                etiquetaC.setText("");
                etiquetaD.setText("");
            }
        } else {
            if (numero == 0) {
                etiquetaC.setText(String.valueOf(numeroAleatorio));
                etiquetaD.setText(letraAleatoria);
                etiquetaA.setText("");
                etiquetaB.setText("");
            } else {
                etiquetaC.setText(letraAleatoria);
                etiquetaD.setText(String.valueOf(numeroAleatorio));
                etiquetaA.setText("");
                etiquetaB.setText("");
            }
        }

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }

    /**
     * Método que cambia los números en el swing de la práctica de mixtos
     */
    public synchronized void mixtoSwingPractica() {
        int aleatorio = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        int numero;
        String letra;

        switch (relojSwing) {
            case 0:
                numero = this.parImpar();
                letra = this.letraAleatorias();

                if (aleatorio == 0) {
                    this.getEtiquetaA().setText(String.valueOf(numero));
                    this.getEtiquetaB().setText(letra);
                } else {
                    this.getEtiquetaA().setText(letra);
                    this.getEtiquetaB().setText(String.valueOf(numero));
                }

                this.getEtiquetaC().setText("");
                this.getEtiquetaD().setText("");
                this.getEtiquetaE().setText("");
                this.getEtiquetaF().setText("");
                this.getEtiquetaG().setText("");
                this.getEtiquetaH().setText("");

                relojSwing++;
                break;
            case 1:
                numero = this.parImpar();
                letra = this.letraAleatorias();

                if (aleatorio == 0) {
                    this.getEtiquetaC().setText(String.valueOf(numero));
                    this.getEtiquetaD().setText(letra);
                } else {
                    this.getEtiquetaC().setText(letra);
                    this.getEtiquetaD().setText(String.valueOf(numero));
                }

                this.getEtiquetaA().setText("");
                this.getEtiquetaB().setText("");
                this.getEtiquetaE().setText("");
                this.getEtiquetaF().setText("");
                this.getEtiquetaG().setText("");
                this.getEtiquetaH().setText("");

                relojSwing++;
                break;
            case 2:
                numero = numeroAleatorios();
                letra = vocalConsonante();

                if (aleatorio == 0) {
                    this.getEtiquetaE().setText(String.valueOf(numero));
                    this.getEtiquetaF().setText(letra);
                } else {
                    this.getEtiquetaE().setText(letra);
                    this.getEtiquetaF().setText(String.valueOf(numero));
                }

                this.getEtiquetaA().setText("");
                this.getEtiquetaB().setText("");
                this.getEtiquetaC().setText("");
                this.getEtiquetaD().setText("");
                this.getEtiquetaG().setText("");
                this.getEtiquetaH().setText("");

                relojSwing++;
                break;
            case 3:
                numero = numeroAleatorios();
                letra = vocalConsonante();

                if (aleatorio == 0) {
                    this.getEtiquetaG().setText(String.valueOf(numero));
                    this.getEtiquetaH().setText(letra);
                } else {
                    this.getEtiquetaG().setText(letra);
                    this.getEtiquetaH().setText(String.valueOf(numero));
                }

                this.getEtiquetaA().setText("");
                this.getEtiquetaB().setText("");
                this.getEtiquetaC().setText("");
                this.getEtiquetaD().setText("");
                this.getEtiquetaE().setText("");
                this.getEtiquetaF().setText("");

                relojSwing = 0;
                break;
        }
        
        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
    }

    /**
     * Método que cambia los números en el swing de la actividad
     */
    public synchronized void numerosSwingActividad() {
        int numero = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        String letraAleatoria = letraAleatorias();
        int numeroAleatorio = parImpar();

        if (!(contadorHiloActividadNumeros % 2 == 0)) {
            if (numero == 0) {
                etiquetaA.setText(String.valueOf(numeroAleatorio));
                etiquetaB.setText(letraAleatoria);
                etiquetaC.setText("");
                etiquetaD.setText("");
            } else {
                etiquetaA.setText(letraAleatoria);
                etiquetaB.setText(String.valueOf(numeroAleatorio));
                etiquetaC.setText("");
                etiquetaD.setText("");
            }
        } else {
            if (numero == 0) {
                etiquetaC.setText(String.valueOf(numeroAleatorio));
                etiquetaD.setText(letraAleatoria);
                etiquetaA.setText("");
                etiquetaB.setText("");
            } else {
                etiquetaC.setText(letraAleatoria);
                etiquetaD.setText(String.valueOf(numeroAleatorio));
                etiquetaA.setText("");
                etiquetaB.setText("");
            }
        }

        long inicio = System.currentTimeMillis();
        tiempoInicioAuxiliar = inicio;

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
        long transcurrido = System.currentTimeMillis() - inicio;
        
        if(transcurrido > 200 && transcurrido < 10000) {
            acumuladoTiempoNumero += transcurrido;
            listaTiemposNumeros.add(transcurrido);
        } else {
            omitidasNumeros++;
            listaTiemposOmitidosNumeros.add(transcurrido);
        }
    }

    /**
     * Método que cambia los números en el swing de la práctica
     */
    public synchronized void letrasSwingActividad() {
        int numero = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        String letraAleatoria = vocalConsonante();

        int numeroAleatorio = numeroAleatorios();

        if (!(contadorHiloActividadLetras % 2 == 0)) {
            if (numero == 0) {
                etiquetaA.setText(String.valueOf(numeroAleatorio));
                etiquetaB.setText(letraAleatoria);
                etiquetaC.setText("");
                etiquetaD.setText("");
            } else {
                etiquetaA.setText(letraAleatoria);
                etiquetaB.setText(String.valueOf(numeroAleatorio));
                etiquetaC.setText("");
                etiquetaD.setText("");
            }
        } else {
            if (numero == 0) {
                etiquetaC.setText(String.valueOf(numeroAleatorio));
                etiquetaD.setText(letraAleatoria);
                etiquetaA.setText("");
                etiquetaB.setText("");
            } else {
                etiquetaC.setText(letraAleatoria);
                etiquetaD.setText(String.valueOf(numeroAleatorio));
                etiquetaA.setText("");
                etiquetaB.setText("");
            }
        }
        
        long inicio = System.currentTimeMillis();
        tiempoInicioAuxiliar = inicio;

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
        long transcurrido = System.currentTimeMillis() - inicio;
        
        if(transcurrido > 200 && transcurrido < 10000) {
            acumuladoTiempoLetra += transcurrido;
            listaTiemposLetras.add(transcurrido);
        } else {
            omitidasLetras++;
            listaTiemposOmitidosLetras.add(transcurrido);
        }
        
    }
    
    /**
     * Método que cambia los números en el swing de la actividad de mixtos
     */
    public synchronized void mixtoSwingActividad() {
        int aleatorio = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        int numero;
        String letra;

        switch (relojSwing) {
            case 0:
                numero = this.parImpar();
                letra = this.letraAleatorias();

                if (aleatorio == 0) {
                    this.getEtiquetaA().setText(String.valueOf(numero));
                    this.getEtiquetaB().setText(letra);
                } else {
                    this.getEtiquetaA().setText(letra);
                    this.getEtiquetaB().setText(String.valueOf(numero));
                }

                this.getEtiquetaC().setText("");
                this.getEtiquetaD().setText("");
                this.getEtiquetaE().setText("");
                this.getEtiquetaF().setText("");
                this.getEtiquetaG().setText("");
                this.getEtiquetaH().setText("");

                relojSwing++;
                break;
            case 1:
                numero = this.parImpar();
                letra = this.letraAleatorias();

                if (aleatorio == 0) {
                    this.getEtiquetaC().setText(String.valueOf(numero));
                    this.getEtiquetaD().setText(letra);
                } else {
                    this.getEtiquetaC().setText(letra);
                    this.getEtiquetaD().setText(String.valueOf(numero));
                }

                this.getEtiquetaA().setText("");
                this.getEtiquetaB().setText("");
                this.getEtiquetaE().setText("");
                this.getEtiquetaF().setText("");
                this.getEtiquetaG().setText("");
                this.getEtiquetaH().setText("");

                relojSwing++;
                break;
            case 2:
                numero = numeroAleatorios();
                letra = vocalConsonante();

                if (aleatorio == 0) {
                    this.getEtiquetaE().setText(String.valueOf(numero));
                    this.getEtiquetaF().setText(letra);
                } else {
                    this.getEtiquetaE().setText(letra);
                    this.getEtiquetaF().setText(String.valueOf(numero));
                }

                this.getEtiquetaA().setText("");
                this.getEtiquetaB().setText("");
                this.getEtiquetaC().setText("");
                this.getEtiquetaD().setText("");
                this.getEtiquetaG().setText("");
                this.getEtiquetaH().setText("");

                relojSwing++;
                break;
            case 3:
                numero = numeroAleatorios();
                letra = vocalConsonante();

                if (aleatorio == 0) {
                    this.getEtiquetaG().setText(String.valueOf(numero));
                    this.getEtiquetaH().setText(letra);
                } else {
                    this.getEtiquetaG().setText(letra);
                    this.getEtiquetaH().setText(String.valueOf(numero));
                }

                this.getEtiquetaA().setText("");
                this.getEtiquetaB().setText("");
                this.getEtiquetaC().setText("");
                this.getEtiquetaD().setText("");
                this.getEtiquetaE().setText("");
                this.getEtiquetaF().setText("");

                relojSwing = 0;
                break;
        }

        long inicio = System.currentTimeMillis();
        tiempoInicioAuxiliar = inicio;
        
        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        
        long transcurrido = System.currentTimeMillis() - inicio;
        System.out.println(transcurrido);
        
        if(transcurrido > 200 && transcurrido < 10000) {
            acumuladoTiempoMixtos += transcurrido;
            listaTiemposMixtos.add(transcurrido);
        } else {
            omitidasMixtos++;
            listaTiemposOmitidosMixtos.add(transcurrido);
        }
        
    }

    /**
     * Método que evalua los resultados de los swing en los números
     *
     * @param respuesta
     * @param numero
     * @param etiquetaRespuesta
     * @param tipo
     */
    public synchronized void respuestaNumeros(String respuesta, int numero, JLabel etiquetaRespuesta, boolean tipo) {
        String auxiliar;

        if (numero % 2 == 0) {
            auxiliar = "par";
        } else {
            auxiliar = "impar";
        }

        if (auxiliar.equals(respuesta)) {
            etiquetaRespuesta.setText("Correcto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    acumuladoTiempoCorrectaNumero += transcurrido;
                    correctasNumeros++;
                    listaTiemposCorrectosNumeros.add(transcurrido);
                }
            }
            
            notifyAll();
        } else {
            etiquetaRespuesta.setText("Incorrecto");
            
            if(tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;
                
                if (transcurrido > 200 && transcurrido < 10000) {
                    incorrectasNumeros++;
                    listaTiemposIncorrectosNumeros.add(transcurrido);
                }
            }
            
            notifyAll();
        }
    }

    /**
     * Método que evalua los resultados de los swing en las letras
     *
     * @param respuesta
     * @param etiquetaString
     * @param etiquetaRespuesta
     */
    public synchronized void respuestaLetras(String respuesta, JLabel etiquetaString, JLabel etiquetaRespuesta, boolean tipo) {
        String auxiliar = "";

        String[] listaVocales = {"A", "E", "I", "U"};
        String[] listaConsonantes = {"G", "K", "M", "R"};

        for (String auxiliarVocal : listaVocales) {
            if (auxiliarVocal.equals(etiquetaString.getText())) {
                auxiliar = "Vocal";
                break;
            }
        }

        for (String auxiliarConsonante : listaConsonantes) {
            if (auxiliarConsonante.equals(etiquetaString.getText())) {
                auxiliar = "Consonante";
                break;
            }
        }

        if (respuesta.equals(auxiliar)) {
            etiquetaRespuesta.setText("Correcto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    acumuladoTiempoCorrectoLetra += transcurrido;
                    correctasLetras++;
                    listaTiemposCorrectosLetras.add(transcurrido);
                }
            }
            
            notifyAll();
        } else {
            etiquetaRespuesta.setText("Incorrecto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    incorrectasLetras++;
                    listaTiemposIncorrectosLetras.add(transcurrido);
                }
            }
            
            notifyAll();
        }
    }
    
    /**
     * Método que evalua los resultados de los swing en los números del ejercicio mixto
     *
     * @param respuesta
     * @param numero
     * @param etiquetaRespuesta
     * @param tipo
     */
    public synchronized void respuestaNumerosMixtos(String respuesta, int numero, JLabel etiquetaRespuesta, boolean tipo) {
        String auxiliar;

        if (numero % 2 == 0) {
            auxiliar = "par";
        } else {
            auxiliar = "impar";
        }

        if (auxiliar.equals(respuesta)) {
            etiquetaRespuesta.setText("Correcto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    acumuladoTiempoCorrectoMixtos += transcurrido;
                    correctasMixtos++;
                    listaTiemposCorrectosMixtos.add(transcurrido);
                }
            }
            
            notifyAll();
        } else {
            etiquetaRespuesta.setText("Incorrecto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    incorrectasMixtos++;
                    listaTiemposIncorrectosMixtos.add(transcurrido);
                }
            }
            
            notifyAll();
        }
    }
    
    /**
     * Método que evalua los resultados de los swing en las letras
     *
     * @param respuesta
     * @param etiquetaString
     * @param etiquetaRespuesta
     */
    public synchronized void respuestaLetrasMixtos(String respuesta, JLabel etiquetaString, JLabel etiquetaRespuesta, boolean tipo) {
        String auxiliar = "";

        String[] listaVocales = {"A", "E", "I", "U"};
        String[] listaConsonantes = {"G", "K", "M", "R"};

        for (String auxiliarVocal : listaVocales) {
            if (auxiliarVocal.equals(etiquetaString.getText())) {
                auxiliar = "Vocal";
                break;
            }
        }

        for (String auxiliarConsonante : listaConsonantes) {
            if (auxiliarConsonante.equals(etiquetaString.getText())) {
                auxiliar = "Consonante";
                break;
            }
        }

        if (respuesta.equals(auxiliar)) {
            etiquetaRespuesta.setText("Correcto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    acumuladoTiempoCorrectoMixtos += transcurrido;
                    correctasMixtos++;
                    listaTiemposCorrectosMixtos.add(transcurrido);
                }
            }
            
            notifyAll();
        } else {
            etiquetaRespuesta.setText("Incorrecto");
            
            if (tipo == true) {
                long transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                if (transcurrido > 200 && transcurrido < 10000) {
                    incorrectasMixtos++;
                    listaTiemposIncorrectosMixtos.add(transcurrido);
                }
            }
            
            notifyAll();
        }
    }

    /**
     * Evalua las respuestas del swing en los ejercicios mixtos
     *
     * @param opcion
     */
    public synchronized void respuestaMixtos(int opcion, boolean tipo) {
        ArrayList<JLabel> listaAuxiliar;
        long transcurrido;
        boolean eventoUno = false, eventoDos = false;
        
        switch (opcion) {
            case 1:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaA());
                listaAuxiliar.add(this.getEtiquetaB());
                listaAuxiliar.add(this.getEtiquetaC());
                listaAuxiliar.add(this.getEtiquetaD());

                if (verificarNumerosMixto(listaAuxiliar) == -1) {
                    etiquetaRespuesta.setText("Incorrecto");
                    this.etiquetaRespuesta.setForeground(Color.red);
                    
                    if(tipo == true) {
                        incorrectasMixtos++;
                        incorrectasImpares++;
                    }

                    notifyAll();
                    break;
                } else {
                    this.respuestaNumerosMixtos("par", recorrerListaNumeros(listaAuxiliar), this.getEtiquetaRespuesta(), tipo);
                    if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                        this.etiquetaRespuesta.setForeground(verde);
                        
                        if (tipo == true) {
                            eventoUno = true;
                        }
                        
                    } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                        this.etiquetaRespuesta.setForeground(Color.red);
                        
                    }
                }
                
                if (tipo == true) {
                    transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                    if (transcurrido > 200 && transcurrido < 10000) {
                        acumuladoTiempoImpares += transcurrido;
                        listaTiemposImpares.add(transcurrido);

                        if (eventoUno == true) {
                            acumuladoTiempoCorrectoImpares += transcurrido;
                            listaTiemposCorrectosImpares.add(transcurrido);
                            
                            correctasImpares++;
                        } else {
                            incorrectasImpares++;  
                        }
                    }
                }
                
                break;
            case 2:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaA());
                listaAuxiliar.add(this.getEtiquetaB());
                listaAuxiliar.add(this.getEtiquetaC());
                listaAuxiliar.add(this.getEtiquetaD());

                if (verificarNumerosMixto(listaAuxiliar) == -1) {
                    etiquetaRespuesta.setText("Incorrecto");
                    this.etiquetaRespuesta.setForeground(Color.red);
                    
                    if(tipo == true) {
                        incorrectasMixtos++;
                        incorrectasPares++;
                    }
                    
                    notifyAll();
                    break;
                } else {
                    this.respuestaNumerosMixtos("impar", recorrerListaNumeros(listaAuxiliar), this.getEtiquetaRespuesta(), tipo);
                    if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                        this.etiquetaRespuesta.setForeground(verde);
                        
                        if (tipo == true) {
                            eventoUno = true;
                        }
                        
                    } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                        this.etiquetaRespuesta.setForeground(Color.red);
                    }
                }
                
                if (tipo == true) {
                    transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                    if (transcurrido > 200 && transcurrido < 10000) {
                        acumuladoTiempoPares += transcurrido;
                        listaTiemposPares.add(transcurrido);

                        if (eventoUno == true) {
                            acumuladoTiempoCorrectoPares += transcurrido;
                            listaTiemposCorrectosPares.add(transcurrido);
                            
                            correctasPares++;
                        } else {
                            incorrectasPares++;
                        }
                    }
                }
                
                break;
            case 3:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaE());
                listaAuxiliar.add(this.getEtiquetaF());
                listaAuxiliar.add(this.getEtiquetaG());
                listaAuxiliar.add(this.getEtiquetaH());

                try {
                    this.respuestaLetrasMixtos("Consonante", this.recorrerListaLetras(listaAuxiliar), this.getEtiquetaRespuesta(), tipo);
                    if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                        this.etiquetaRespuesta.setForeground(verde);
                        
                        if(tipo == true) {
                            eventoUno = true;
                        }
                        
                    } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                        this.etiquetaRespuesta.setForeground(Color.red);
                    }
                } catch (Exception ex) {
                    etiquetaRespuesta.setText("Incorrecto");
                    this.etiquetaRespuesta.setForeground(Color.red);
                    
                    if(tipo == true) {
                        incorrectasMixtos++;
                        incorrectasImpares++;
                    }
                    
                    notifyAll();
                }
                
                if (tipo == true) {
                    transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                    if (transcurrido > 200 && transcurrido < 10000) {
                        acumuladoTiempoImpares += transcurrido;
                        listaTiemposImpares.add(transcurrido);

                        if (eventoUno == true) {
                            acumuladoTiempoCorrectoImpares += transcurrido;
                            listaTiemposCorrectosImpares.add(transcurrido);
                            
                            correctasImpares++;
                        } else {
                            incorrectasImpares++;
                        }
                    }
                }

                break;
            case 4:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaE());
                listaAuxiliar.add(this.getEtiquetaF());
                listaAuxiliar.add(this.getEtiquetaG());
                listaAuxiliar.add(this.getEtiquetaH());

                try {
                    this.respuestaLetrasMixtos("Vocal", this.recorrerListaLetras(listaAuxiliar), this.getEtiquetaRespuesta(), tipo);
                    if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                        this.etiquetaRespuesta.setForeground(verde);
                        
                        if(tipo == true) {
                            eventoUno = true;
                        }
                        
                    } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                        this.etiquetaRespuesta.setForeground(Color.red);
                    }
                } catch (Exception ex) {
                    etiquetaRespuesta.setText("Incorrecto");
                    this.etiquetaRespuesta.setForeground(Color.red);
                    
                    if(tipo == true) {
                        incorrectasMixtos++;
                        incorrectasPares++;
                    }
                    
                    notifyAll();
                }
                
                if (tipo == true) {
                    transcurrido = System.currentTimeMillis() - tiempoInicioAuxiliar;

                    if (transcurrido > 200 && transcurrido < 10000) {
                        acumuladoTiempoPares += transcurrido;
                        listaTiemposPares.add(transcurrido);

                        if (eventoUno == true) {
                            acumuladoTiempoCorrectoPares += transcurrido;
                            listaTiemposCorrectosPares.add(transcurrido);
                            
                            correctasPares++;
                        } else {
                            incorrectasPares++;
                        }
                    }
                }
                
                break;
        }
    }

    /**
     * Método que genera números aleatorios
     *
     * @return
     */
    public int numeroAleatorios() {
        return ThreadLocalRandom.current().nextInt(2, 9 + 1);
    }

    /**
     * Método que genera letras aleatorios
     *
     * @return
     */
    public String letraAleatorias() {
        String auxiliarLetras[] = {"A", "E", "G", "I", "K", "M", "R", "U"};
        int numero = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        return auxiliarLetras[numero];
    }

    private int parImpar() {
        int auxiliar = ThreadLocalRandom.current().nextInt(2, 9 + 1);

        if (auxiliar % 2 == 0) {
            if (pares < repeticiones) {
                pares++;
            } else {
                return parImpar();
            }
        } else {
            if (impares < repeticiones) {
                impares++;
            } else {
                return parImpar();
            }
        }
        
        return auxiliar;
    }

    private String vocalConsonante() {
        String auxiliar = letraAleatorias();

        if (vocales.contains(auxiliar)) {
            if (vocal < repeticiones) {
                vocal++;
            } else {
                return vocalConsonante();
            }
        } else {
            if (consonante < repeticiones) {
                consonante++;
            } else {
                return vocalConsonante();
            }
        }
        return auxiliar;
    }

    public void agregarVocalesConsonantes() {
        vocales.add("A");
        vocales.add("E");
        vocales.add("I");
        vocales.add("U");
        consonantes.add("G");
        consonantes.add("K");
        consonantes.add("M");
        consonantes.add("R");
    }

    /**
     * Metodo que evalua las etiquetas en el swing y regresa el valor de la
     * etiqueta que contenga el número
     *
     * @param listaEtiquetas
     * @return
     */
    public int recorrerListaNumeros(ArrayList<JLabel> listaEtiquetas) {
        int auxiliarNumero = 0;
        for (int i = 0; i < listaEtiquetas.size(); i++) {
            JLabel auxiliarLabel = listaEtiquetas.get(i);
            String auxiliarString = auxiliarLabel.getText();
            try {
                auxiliarNumero = Integer.valueOf(auxiliarString);
            } catch (NumberFormatException ex) {

            }
        }
        return auxiliarNumero;
    }

    /**
     * Metodo que evalua las etiquetas en el swing y regresa el valor de la
     * etiqueta que contenga la letra
     *
     * @param listaEtiquetas
     * @return
     */
    public JLabel recorrerListaLetras(ArrayList<JLabel> listaEtiquetas) {
        for (int i = 0; i < listaEtiquetas.size(); i++) {
            JLabel auxiliarLabel = listaEtiquetas.get(i);
            String auxiliarString = auxiliarLabel.getText();
            if (!auxiliarString.isEmpty()) {
                char letra = auxiliarString.charAt(0);

                if (Character.isLetter(letra)) {
                    return auxiliarLabel;
                }
            }
        }
        return null;
    }

    /**
     * Método que verifica si las etiquetas están vacias
     *
     * @param listaEtiquetas
     * @return
     */
    public int verificarNumerosMixto(ArrayList<JLabel> listaEtiquetas) {
        int contador = 0;

        for (int i = 0; i < listaEtiquetas.size(); i++) {
            JLabel auxiliarLabel = listaEtiquetas.get(i);
            String auxiliarString = auxiliarLabel.getText();
            if (auxiliarString.isEmpty()) {
                contador++;
            }

            if (contador == 4) {
                return -1;
            }
        }

        return 1;
    }
    
    public void calculosNumberLetter() {
        
        //I - Tl - REVISADA - Tiempo total en el bloque de letras sin distinción de errores y aciertos
        this.objetoNumberLetter.setTiempoLetras((double)acumuladoTiempoLetra);
        
        //II - Tn - REVISADA - Tiempo total en el bloque de números sin distinción de errores y aciertos
        this.objetoNumberLetter.setTiempoNumeros((double) acumuladoTiempoNumero);
        
        //III - Ta - REVISADA - Tiempo total en el bloque de mixtos sin distinción de errores y aciertos
        this.objetoNumberLetter.setTiempoAlternado((double) acumuladoTiempoMixtos);
        
        //IV - Tt - REVISADA - Tiempo total en toda la tarea sin distinción de errores y aciertos
        this.objetoNumberLetter.setTiempoTotal((double)(acumuladoTiempoLetra + acumuladoTiempoNumero + acumuladoTiempoMixtos));
        
        //V - CGt - REVISADA - Costo del shifting global con el tiempo total
        this.objetoNumberLetter.setShiftingGlobalTotal((double)(acumuladoTiempoMixtos - 
                                                              ((acumuladoTiempoLetra + acumuladoTiempoNumero)/2)));
        
        //Variables auxiliares
            //Ti - Tiempo impares
            long Ti = acumuladoTiempoImpares;
            
            //Tp - Tiempo pares
            long Tp = acumuladoTiempoPares;
            
        //VI - CLt - REVISADA - Costo del shifting local con el tiempo total
        this.objetoNumberLetter.setShiftingLocalTotal((double)(Ti - Tp));
        
        //Variables auxiliares
            //TCl
            long TCl = acumuladoTiempoCorrectoLetra;
            
            //TCn
            long TCn = acumuladoTiempoCorrectaNumero;
            
            //TCa
            long TCa = acumuladoTiempoCorrectoMixtos;
            
        //VII - CGc - REVISADA - Costo del shifting global con el tiempo total de las respuestas correctas
        this.objetoNumberLetter.setShiftingGlobalTotalCorrectas((double)(TCa - ((TCl + TCn)/2)));
        
        //VIII - CLc - REVISADA - Costo del shifting local con el tiempo total de las respuestas correctas
        this.objetoNumberLetter.setShiftingLocalTotalCorrectas((double)(acumuladoTiempoCorrectoImpares - acumuladoTiempoCorrectoPares));
        
        //IX - RCl - REVISADA - Respuestas correctas en el bloque de solo letras
        this.objetoNumberLetter.setCorrectasLetras(correctasLetras);
        
        //X - RCn - REVISADA - Respuestas correctas en el bloque de solo numeros
        this.objetoNumberLetter.setCorrectasNumeros(correctasNumeros);
        
        //XI - RCa - REVISADA - Respuestas correctas en el bloque mixto
        this.objetoNumberLetter.setCorrectasAlternado(correctasMixtos);
        
        //XII - RCt - REVISADA - Respuestas correctas en la actividad
        this.objetoNumberLetter.setCorrectasTotales(correctasLetras + correctasNumeros + correctasMixtos);
        
        //Variables auxiliares
        
            //TPl
            double TPl = TCl / correctasLetras;
            
            //TPn
            double TPn = TCn / correctasNumeros;
            
            //TPa
            double TPa = TCa / correctasMixtos;
            
        //XIII - CGp - REVISADA - Costo del shifting global con el tiempo de reacción promedio de las respuestas correctas
        this.objetoNumberLetter.setShiftingGlobalReaccionCorrectas((TPa - ((TPl + TPn)/2)));
        
        //Variables auxiliares
        
            //TPi
            double TPi = acumuladoTiempoCorrectoImpares / correctasImpares;
            
            double TPp = acumuladoTiempoCorrectoPares / correctasPares;
            
        //XIV - CLp - REVISADA - Costo del shifting global con el tiempo de reacción promedio de las respuestas correctas
        this.objetoNumberLetter.setShiftingLocalReaccionCorrectas(TPi - TPp);
        
        //Variables auxiliares
            
            //Rl
            int Rl = correctasLetras + incorrectasLetras;
            
            //Rn
            int Rn = correctasNumeros + incorrectasNumeros;
            
            //Ra
            int Ra = correctasMixtos + incorrectasMixtos;
            
            //Pl
            double Pl = (correctasLetras * 100) / Rl;
            
            //Pn
            double Pn = (correctasNumeros * 100) / Rn;
            
            //Pa
            double Pa = (correctasMixtos * 100) / Ra;
            
        //XV - CGp2 - REVISADA - Costo del shifting global con porcentaje de respuestas correctas
        this.objetoNumberLetter.setShiftingGlobalPorcentajeCorrectas((Pa - ((Pl + Pn)/2)));
        
        //Variables auxiliares
        
            //RTp
            int RTp = correctasPares + incorrectasPares; 
            
            //RTi
            int RTi = correctasImpares + incorrectasImpares;
            
            //PCp
            double PCp = (correctasPares * 100) / RTp;
            
            //PCi
            double PCi = (correctasImpares * 100) / RTi;
            
        //XVI - CGp2 - REVISADA - Costo del shifting local con porcentaje de respuestas correctas
        this.objetoNumberLetter.setShiftingLocalPorcentajeCorrectas(PCi - PCp);
        
        //XVII - Il - REVISADA - Respuestas incorrectas del bloque de solo letras
        this.objetoNumberLetter.setIncorrectasLetras(incorrectasLetras);
        
        //XVIII - Il - REVISADA - Respuestas incorrectas del bloque de solo numeros
        this.objetoNumberLetter.setIncorrectasNumeros(incorrectasNumeros);
        
        //XIX - Il - REVISADA - Respuestas incorrectas del bloque de solo mixtos
        this.objetoNumberLetter.setIncorrectasAlternado(incorrectasMixtos);
        
        //XX - Il - REVISADA - Respuestas incorrectas de la tarea
        this.objetoNumberLetter.setIncorrectasTotales(incorrectasLetras + incorrectasNumeros + incorrectasMixtos);
        
        //XXI - ONl - REVISADA - Omisiones y respuestas nulas en el bloque de solo letras
        this.objetoNumberLetter.setOmisionesNulasLetras(omitidasLetras);
        
        //XXII - ONn - REVISADA - Omisiones y respuestas nulas en el bloque de solo numeros
        this.objetoNumberLetter.setOmisionesNulasNumeros(omitidasNumeros);    
        
        //XXIII - ONa - REVISADA - Omisiones y respuestas nulas en el bloque alternado
        this.objetoNumberLetter.setOmisionesNulasAlternado(omitidasMixtos); 
        
        //XXIV - ONt - REVISADA - Omisiones y respuestas nulas en la tarea
        this.objetoNumberLetter.setOmisionesNulasTotales(omitidasLetras + omitidasNumeros + omitidasMixtos);
        
        //Variables auxiliares
            
            //1 PASO
            double MTTl = acumuladoTiempoLetra / Rl;
            long acumuladoLetras = 0;
            
            //2 PASO
            for (Long auxiliar : listaTiemposLetras) {
                
                double calculoUno = auxiliar - MTTl;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoLetras += calculoDos;
            }
            
            //4 PASO
            acumuladoLetras = acumuladoLetras / Rl;
            
            //5 PASO
            double DETl = Math.sqrt(acumuladoLetras);
            
            //PSTl
            double PSTl = MTTl + (DETl * 2.5);
            double PITl = MTTl - (DETl * 2.5);
            
            //-----------------------------------------------
            
            //1 PASO
            double MTTn = acumuladoTiempoNumero / Rn;
            long acumuladoNumero = 0;
            
            //2 PASO
            for (Long auxiliar : listaTiemposNumeros) {
                
                double calculoUno = auxiliar - MTTn;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASOn
                acumuladoNumero += calculoDos;
            }
            
            //4 PASO
            acumuladoNumero = acumuladoNumero / Rn;
            
            //5 PASO
            double DETn = Math.sqrt(acumuladoNumero);
            
            //PSTl
            double PSTn = MTTn + (DETn * 2.5);
            double PITn = MTTn - (DETn * 2.5);
            
            //-----------------------------------------------
            
            //1 PASO
            double MTTa = acumuladoTiempoMixtos / Ra;
            long acumuladoMixto = 0;
            
            //2 PASO
            for (Long auxiliar : listaTiemposMixtos) {
                
                double calculoUno = auxiliar - MTTa;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASOn
                acumuladoMixto += calculoDos;
            }
            
            //4 PASO
            acumuladoMixto = acumuladoMixto / Ra;
            
            //5 PASO
            double DETa = Math.sqrt(acumuladoMixto);
            
            //PSTl
            double PSTa = MTTa + (DETa * 2.5);
            double PITa = MTTa - (DETa * 2.5);
            
        //XXV - Txl - REVISADA - Tiempo total en el bloque de las letras
        double acumuladoLetrasAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposLetras) {
            if(auxiliar >= PITl && auxiliar <= PSTl) {
                acumuladoLetrasAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setTiempoTotalLetras(acumuladoLetrasAuxiliar);
        
        //XXVI - Txn - REVISADA - Tiempo total en el bloque de los números
        double acumuladoNumerosAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposNumeros) {
            if(auxiliar >= PITn && auxiliar <= PSTn) {
                acumuladoNumerosAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setTiempoTotalNumeros(acumuladoNumerosAuxiliar);
        
        //XXVII - Txa - REVISADA - Tiempo total en el bloque mixto
        double acumuladoMixtoAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposMixtos) {
            if(auxiliar >= PITa && auxiliar <= PSTa) {
                acumuladoMixtoAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setTiempoTotalAlternado(acumuladoMixtoAuxiliar);
        
        //XXVIII - TXt - REVISADA - Tiempo total en la tarea
        this.objetoNumberLetter.setTiempoTotalTarea(acumuladoLetrasAuxiliar + acumuladoNumerosAuxiliar + acumuladoMixtoAuxiliar);
        
        //XXIX - CGxt - REVISADA - Costo del shifting global con el tiempo total
        this.objetoNumberLetter.setShiftingGlobalTiempoTotal((double)(acumuladoMixtoAuxiliar - ((acumuladoLetrasAuxiliar + acumuladoNumerosAuxiliar)/2)));
        
        //XXX - CLxt - REVISADA - Costo del shifting local con el tiempo total
        double acumuladoImparesAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposImpares) {
            if(auxiliar >= PITa && auxiliar <= PSTa) {
                acumuladoImparesAuxiliar += auxiliar;
            }
        }
        
        double acumuladoParesAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposPares) {
            if(auxiliar >= PITa && auxiliar <= PSTa) {
                acumuladoParesAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setShiftingLocalTiempoTotal(acumuladoImparesAuxiliar - acumuladoParesAuxiliar);
        
        //Variables auxiliares
            
            //1 PASO
            double MCTl = TCl / correctasLetras;
            long acumuladoCorrectoLetras = 0;
            
            //2 PASO
            for (Long auxiliar : listaTiemposCorrectosLetras) {
                
                double calculoUno = auxiliar - MCTl;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoCorrectoLetras += calculoDos;
            }
            
            //4 PASO
            acumuladoCorrectoLetras = acumuladoCorrectoLetras / correctasLetras;
            
            //5 PASO
            double DECl = Math.sqrt(acumuladoCorrectoLetras);
            
            //PSTl
            double PSCl = MCTl + (DECl * 2.5);
            double PICl = MCTl - (DECl * 2.5);
            
            //-----------------------------------------------
            
            //1 PASO
            double MCTn = TCn / correctasNumeros;
            long acumuladoCorrectoNumeros = 0;
            
            //2 PASO
            for (Long auxiliar : listaTiemposCorrectosNumeros) {
                
                double calculoUno = auxiliar - MCTn;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoCorrectoNumeros += calculoDos;
            }
            
            //4 PASO
            acumuladoCorrectoNumeros = acumuladoCorrectoNumeros / correctasNumeros;
            
            //5 PASO
            double DECn = Math.sqrt(acumuladoCorrectoNumeros);
            
            //PSTl
            double PSCn = MCTn + (DECn * 2.5);
            double PICn = MCTn - (DECn * 2.5);
            
            //-----------------------------------------------
            
            //1 PASO
            double MCTa = TCa / correctasMixtos;
            long acumuladoCorrectoMixtos = 0;
            
            //2 PASO
            for (Long auxiliar : listaTiemposCorrectosMixtos) {
                
                double calculoUno = auxiliar - MCTa;
                double calculoDos = Math.pow(calculoUno, 2);
                
                //3 PASO
                acumuladoCorrectoMixtos += calculoDos;
            }
            
            //4 PASO
            acumuladoCorrectoMixtos = acumuladoCorrectoMixtos / correctasMixtos;
            
            //5 PASO
            double DECa = Math.sqrt(acumuladoCorrectoMixtos);
            
            //PSTl
            double PSCa = MCTa + (DECa * 2.5);
            double PICa = MCTa - (DECa * 2.5);
            
        //XXXI - TCxl - REVISADA - Tiempo de reacción de las respuestas correctas en el bloque de solo letras
        double acumuladoLetrasCorrectasAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposCorrectosLetras) {
            if(auxiliar >= PICl && auxiliar <= PSCl) {
                acumuladoLetrasCorrectasAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setTiempoReaccionCorrectasLetras(acumuladoLetrasCorrectasAuxiliar);
        
        //XXXII - TCxn - REVISADA - Tiempo de reacción de las respuestas correctas en el bloque de solo numeros
        double acumuladoNumerosCorrectasAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposCorrectosNumeros) {
            if(auxiliar >= PICn && auxiliar <= PSCn) {
                acumuladoNumerosCorrectasAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setTiempoReaccionCorrectasNumeros(acumuladoNumerosCorrectasAuxiliar);
        
        //XXXIII - TCxa - REVISADA - Tiempo de reacción de las respuestas correctas en el bloque alternado
        double acumuladoMixtoCorrectasAuxiliar = 0;
        
        for (Long auxiliar : listaTiemposCorrectosMixtos) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                acumuladoMixtoCorrectasAuxiliar += auxiliar;
            }
        }
        
        this.objetoNumberLetter.setTiempoReaccionCorrectasAlternado(acumuladoMixtoCorrectasAuxiliar);
        
        //XXXIV - TCxt - REVISADA - Tiempo total en la tarea
        this.objetoNumberLetter.setTiempoReaccionCorrectasTotales(acumuladoLetrasCorrectasAuxiliar + acumuladoNumerosCorrectasAuxiliar + acumuladoMixtoCorrectasAuxiliar);
        
        //XXXV - CGxt - REVISADA - Costo del shifting global con el tiempo total de las respuestas correctas
        this.objetoNumberLetter.setShiftingGlobalTiempoTotalCorrectas((double)(acumuladoMixtoCorrectasAuxiliar - ((acumuladoLetrasCorrectasAuxiliar + acumuladoNumerosCorrectasAuxiliar)/2)));
        
        //XXXVI - CLxt - REVISADA - Costo del shifting local con el tiempo total de las respuestas correctas
        double acumuladoImparesCorrectasAuxiliar = 0;
        int contadorCorrectasImpares = 0;
        
        for (Long auxiliar : listaTiemposCorrectosImpares) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                acumuladoImparesCorrectasAuxiliar += auxiliar;
                contadorCorrectasImpares++;
            }
        }
        
        double acumuladoParesCorrectasAuxiliar = 0;
        int contadorCorrectasPares = 0;
        
        for (Long auxiliar : listaTiemposCorrectosPares) {
            if(auxiliar >= PICa && auxiliar <= PSCa) {
                acumuladoParesCorrectasAuxiliar += auxiliar;
                contadorCorrectasPares++;
            }
        }
        
        this.objetoNumberLetter.setShiftingLocalTiempoTotalCorrectas(acumuladoImparesCorrectasAuxiliar - acumuladoParesCorrectasAuxiliar);
        
        //XXXVII - RCxl - REVISADA - Respuestas correctas en el bloque de solo letras
        int contadorCorrectasLetras = 0;
        
        for (Long auxiliar : listaTiemposCorrectosLetras) {
            if(auxiliar >= PICl && auxiliar <= PSCl) {
                contadorCorrectasLetras++;
            }
        }
        
        this.objetoNumberLetter.setCorrectasTotalesLetras(contadorCorrectasLetras);
        
        //XXXVIII - RCxn - REVISADA - Respuestas correctas en el bloque de solo números
        int contadorCorrectasNumeros = 0;
        
        for (Long auxiliar : listaTiemposCorrectosNumeros) {
            if(auxiliar >= PICl && auxiliar <= PSCl) {
                contadorCorrectasNumeros++;
            }
        }
        
        this.objetoNumberLetter.setCorrectasTotalesNumeros(contadorCorrectasNumeros);
        
        //XXXIX - RCxa - REVISADA - Respuestas correctas en el bloque alternado
        int contadorCorrectasMixto = 0;
        
        for (Long auxiliar : listaTiemposCorrectosMixtos) {
            if(auxiliar >= PICl && auxiliar <= PSCl) {
                contadorCorrectasMixto++;
            }
        }
        
        this.objetoNumberLetter.setCorrectasTotalesAlternado(contadorCorrectasMixto);
        
        //XL - RCat - REVISADA - Respuestas correctas en toda la tarea
        this.objetoNumberLetter.setCorrectasTotalesTarea(contadorCorrectasLetras + 
                                                        contadorCorrectasNumeros + 
                                                        contadorCorrectasMixto);
        
        //Variables auxiliares
        
            //TPΔZ
            double TPal = acumuladoLetrasCorrectasAuxiliar / contadorCorrectasLetras;
            
            //TPΔZ
            double TPan = acumuladoNumerosCorrectasAuxiliar / contadorCorrectasNumeros;
            
            //TPΔZ
            double TPaa = acumuladoMixtoCorrectasAuxiliar / contadorCorrectasMixto;
            
        //XLI - CGxp - REVISADA - Costo del shifting global con el tiempo de reacción promedio de las respuestas correctas
        this.objetoNumberLetter.setShiftingGlobalTiempoReaccionCorrectas((double)(TPaa - ((TPal + TPan)/2)));
        
        //XLII - CLxp - REVISADA - Costo del shifting global con el tiempo de reacción promedio de las respuestas correctas
        
            //TPΔZ
            double TPai = acumuladoImparesCorrectasAuxiliar / contadorCorrectasImpares;
            
            //TPΔZ
            double TPap = acumuladoParesCorrectasAuxiliar / contadorCorrectasPares;
            
        this.objetoNumberLetter.setShiftingLocalTiempoReaccionCorrectas(TPai - TPap);
        
        //Variables auxiliares
        
            //Ral
            int contadorRespuetasTotalesLetras = 0;
            
            for (Long auxiliar : listaTiemposLetras) {
                if (auxiliar >= PITl && auxiliar <= PSTl) {
                    contadorRespuetasTotalesLetras++;
                }
            }
            
            //Pal
            double Pal = (contadorCorrectasLetras * 100) / contadorRespuetasTotalesLetras;
            
            //----------------------------------------------------------------------------
            
            //Ran
            int contadorRespuetasTotalesNumeros = 0;
            
            for (Long auxiliar : listaTiemposNumeros) {
                if (auxiliar >= PITn && auxiliar <= PSTn) {
                    contadorRespuetasTotalesNumeros++;
                }
            }
            
            //Pan
            double Pan = (contadorCorrectasNumeros * 100) / contadorRespuetasTotalesNumeros;
            
            //----------------------------------------------------------------------------
            
            //Raa
            int contadorRespuetasTotalesMixtos = 0;
            
            for (Long auxiliar : listaTiemposMixtos) {
                if (auxiliar >= PITa && auxiliar <= PSTa) {
                    contadorRespuetasTotalesMixtos++;
                }
            }
            
            //Paa
            double Paa = (contadorCorrectasMixto * 100) / contadorRespuetasTotalesMixtos;
        
        //XLIII - REVISADA - Costo del shifting global con porcentaje de respuestas correctas
        this.objetoNumberLetter.setShiftingGlobalPorcentajeTotalCorrectas((double)(Paa - ((Pal + Pan)/2)));
        
        //Variables auxiliares
        
            //Rai
            int contadorRespuetasTotalesImpares = 0;
            
            for (Long auxiliar : listaTiemposImpares) {
                if (auxiliar >= PITa && auxiliar <= PSTa) {
                    contadorRespuetasTotalesImpares++;
                }
            }
            
            //Pai
            double Pai = (contadorCorrectasImpares * 100) / contadorRespuetasTotalesImpares;
            
            //----------------------------------------------------------------------------
            
            //Rap
            int contadorRespuetasTotalesPares = 0;
            
            for (Long auxiliar : listaTiemposPares) {
                if (auxiliar >= PITa && auxiliar <= PSTa) {
                    contadorRespuetasTotalesPares++;
                }
            }
            
            //Pap
            double Pap = (contadorCorrectasPares * 100) / contadorRespuetasTotalesPares;
            
        //XLIV - REVISADA - Costo del shifting local con porcentaje de respuestas correctas
        this.objetoNumberLetter.setShiftingLocalPorcentajeTotalCorrectas(Pai - Pap);
        
        //XLV - RIxl - REVISADA - Respuestas incorrectas en el bloque de solo letras
        int contadorIncorrectasLetras = 0;
       
        for (Long auxiliar : listaTiemposIncorrectosLetras) {
            if (auxiliar >= PITl && auxiliar <= PSTl) {
                contadorIncorrectasLetras++;
            }
        }
        
        this.objetoNumberLetter.setIncorrectasTotalesLetras(contadorIncorrectasLetras);
        
        //XLVI - RIxn - REVISADA - Respuestas incorrectas en el bloque de solo numeros
        int contadorIncorrectasNumeros = 0;
       
        for (Long auxiliar : listaTiemposIncorrectosNumeros) {
            if (auxiliar >= PITn && auxiliar <= PSTn) {
                contadorIncorrectasNumeros++;
            }
        }
        
        this.objetoNumberLetter.setIncorrectasTotalesNumeros(contadorIncorrectasNumeros);
        
        //XLVII - RIxa - REVISADA - Respuestas incorrectas en el bloque de solo alternado
        int contadorIncorrectasMixtos = 0;
       
        for (Long auxiliar : listaTiemposIncorrectosMixtos) {
            if (auxiliar >= PITa && auxiliar <= PSTa) {
                contadorIncorrectasMixtos++;
            }
        }
        
        this.objetoNumberLetter.setIncorrectasTotalesAlternado(contadorIncorrectasMixtos);
        
        //XLVIII - RIat - REVISADA - Respuestas incorrectas en toda la tarea
        this.objetoNumberLetter.setIncorrectasTotalesTarea(contadorIncorrectasLetras + 
                                                          contadorIncorrectasNumeros +
                                                          contadorIncorrectasMixtos); 
        
        //XLIX - ONxl - REVISADA - Respuestas omitidas en el bloque de solo figuras negras
        int contadorOmitidasLetras = 0;
       
        for (Long auxiliar : listaTiemposOmitidosLetras) {
            if (auxiliar >= PITl && auxiliar <= PSTl) {
                contadorOmitidasLetras++;
            }
        }
        
        this.objetoNumberLetter.setOmisionesNulasTotalesLetras(contadorOmitidasLetras);
        
        //L - ONxn - REVISADA - Respuestas omitidas en el bloque de solo figuras azules
        int contadorOmitidasNumeros = 0;
       
        for (Long auxiliar : listaTiemposOmitidosNumeros) {
            if (auxiliar >= PITn && auxiliar <= PSTn) {
                contadorOmitidasNumeros++;
            }
        }
        
        this.objetoNumberLetter.setOmisionesNulasTotalesNumeros(contadorOmitidasNumeros);
        
        //LI - ONxa - REVISADA - Respuestas omitidas en el bloque de solo figuras azules
        int contadorOmitidasMixtos = 0;
       
        for (Long auxiliar : listaTiemposOmitidosMixtos) {
            if (auxiliar >= PITa && auxiliar <= PSTa) {
                contadorOmitidasMixtos++;
            }
        }
        
        this.objetoNumberLetter.setOmisionesNulasTotalesAlternado(contadorOmitidasMixtos);
        
        //LII - ONxt - REVISADA - Respuestas omitidas en toda la tarea
        this.objetoNumberLetter.setOmisionesNulasTotalesTarea(contadorOmitidasLetras + 
                                                              contadorOmitidasNumeros +
                                                              contadorOmitidasMixtos); 
        
        this.objetoNumberLetter.setIdNumberLetter(controlGeneral.getIdGlobal());
        this.objetoNumberLetter.setSet1Collection(null);
        
        /*
        if(persistencia.agregarNumberLetterBD(objetoNumberLetter)){
            JOptionPane.showMessageDialog(null, "Guardado correctamente en la base de datos");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al tratar de guardar este objeto");
        }*/
  
        System.out.println(objetoNumberLetter.toString());
    }

    /**
     * Método que ejecuta el hilo para cambiar la swing de la familiarización de
     * los números
     */
    public void familiarizacionNumeros() {
        hiloFamiliarizacionNumeros = new Thread(runnableFamiliarizacionSwingNumeros);
        hiloFamiliarizacionNumeros.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la familiarización de los
     * numeros
     */
    Runnable runnableFamiliarizacionSwingNumeros = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloFamiliarizacionNumeros < 8) {
                numerosFamiliarizacion();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                etiquetaRespuesta.setText("");
                etiquetaString.setText("");
                contadorHiloFamiliarizacionNumeros++;
            }
            
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la familiarización de
     * las letras
     */
    public void familiarizacionLetras() {
        hiloFamiliarizacionLetras = new Thread(runnableFamiliarizacionSwingLetras);
        hiloFamiliarizacionLetras.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la familiarización de las
     * letras
     */
    Runnable runnableFamiliarizacionSwingLetras = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloFamiliarizacionLetras < 8) {
                letrasFamiliarizacion();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                etiquetaRespuesta.setText("");
                contadorHiloFamiliarizacionLetras++;
            }
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la práctica de los
     * números
     */
    public void practicaNumeros() {
        hiloPracticaNumeros = new Thread(runnablePracticaSwingNumeros);
        hiloPracticaNumeros.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la práctica de los números
     */
    Runnable runnablePracticaSwingNumeros = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloPracticaNumeros < 10) {
                numerosSwingPractica();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                contadorHiloPracticaNumeros++;
            }
            pares = 0;
            impares = 0;
            
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la práctica de las
     * letras
     */
    public void practicaLetras() {
        hiloPracticaLetras = new Thread(runnablePracticaSwingLetras);
        hiloPracticaLetras.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la práctica de las letras
     */
    Runnable runnablePracticaSwingLetras = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloPracticaLetras < 10) {
                letrasSwingPractica();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                contadorHiloPracticaLetras++;
            }
            vocal = 0;
            consonante = 0;
            
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la práctica de las
     * letras
     */
    public void practicaMixto() {
        hiloPracticasMixto = new Thread(runnablePracticaSwingMixto);
        hiloPracticasMixto.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la práctica de las letras
     */
    Runnable runnablePracticaSwingMixto = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloPracticaMixto < 20) {
                mixtoSwingPractica();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                contadorHiloPracticaMixto++;
            }
            
            vocal = 0;
            consonante = 0;
            pares = 0;
            impares = 0;
            
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
            
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la actividad de los
     * números
     */
    public void actividadNumeros() {
        hiloActividadNumeros = new Thread(runnableActividadSwingNumeros);
        hiloActividadNumeros.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la actividad de los números
     */
    Runnable runnableActividadSwingNumeros = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloActividadNumeros < 32) {
                
                numerosSwingActividad();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                contadorHiloActividadNumeros++;
            }
            pares = 0;
            impares = 0;
            
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la actividad de las
     * letras
     */
    public void actividadLetras() {
        hiloActividadLetras = new Thread(runnableActividadSwingLetras);
        hiloActividadLetras.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la actividad de los números
     */
    Runnable runnableActividadSwingLetras = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloActividadLetras < 32) {
                letrasSwingActividad();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                contadorHiloActividadLetras++;
            }
            vocal = 0;
            consonante = 0;
            pares = 0;
            impares = 0;
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
        }
    };

    /**
     * Método que ejecuta el hilo para cambiar la swing de la actividad de las
     * letras
     */
    public void actividadMixto() {
        hiloActividadMixto = new Thread(runnableActividadSwingMixto);
        hiloActividadMixto.start();
    }

    /**
     * Hilo que cambia los valores de la swing en la actividad de los números
     */
    Runnable runnableActividadSwingMixto = new Runnable() {
        @Override
        public void run() {
            while (contadorHiloActividadMixto < 128) {
                mixtoSwingActividad();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                contadorHiloActividadMixto++;
            }
            
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
            controlGeneral.setPantalla(instrucciones);
        }
    };

    /**
     * Instrucciones de pantalla
     *
     * @param frame
     * @return
     */
    public Object instruccionesPantalla(JFrame frame, JLabel label) {
        switch (contadoraux) {
            case 0:
                return("NUMBER LETTER");
            case 1:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de iniciar con esta actividad, realizarás \n"
                        + "un ejercicio para que te familiarices con los\n"
                        + "números pares e impares.");
            case 2:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, indicarás si el número que \n"
                        + "aparece en el centro de la pantalla pertenece \n"
                        + "a la categoría “PAR”, presionando la \n"
                        + "tecla “P”. O si pertenece a la categoría \n"
                        + "“IMPAR”, presionando la tecla “I”.");
            case 3:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_par-impar.png")));
                return ("Por favor, coloca tus dedos índice y medio \n"
                        + "de la mano derecha en las teclas “P” (pares)\n"
                        + "y “I” (impares). ");
            case 4:
                frame.setVisible(false);
                FamiliarizacionNumeros imagenNumeros = new FamiliarizacionNumeros();
                imagenNumeros.setVisible(true);
                this.setPantalla(imagenNumeros);
            case 5:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_par-impar.png")));
                return ("Recuerda solo presionar: \n"
                        + "\n"
                        + "Tecla «P»: Número par \n"
                        + "\n"
                        + "Tecla «I»: Número impar \n"
                        + "\n"
                        + "Añadir teclado");
            case 6:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("La actividad está por comenzar.\n\n"
                        + "Ésta consistirá en que se te mostrarán un número \n"
                        + "y una letra juntos en la parte superior de la \n"
                        + "pantalla, ya sea a la derecha o a la izquierda.");
            case 7:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Lo que harás es indicar si el número es par o impar, \n"
                        + "justo como lo hiciste en el ejercicio anterior.");
            case 8:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, podrás ver un ejemplo sobre\n"
                        + "cómo se presentarán el número y letra, \n"
                        + "así como la manera de responder.");
            case 9:
                frame.setVisible(false);
                InstruccionNL instruccionesPantallas = new InstruccionNL();
                instruccionesPantallas.setVisible(true);
                this.setPantalla(instruccionesPantallas);

            case 10:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_par-impar.png")));
                return ("Ahora, se te mostrará una serie de parejas \n"
                        + "de número y letra para practicar. \n \n"
                        + "Trata de responder lo más rápido que puedas. \n\n"
                        + "Recuerda presionar la tecla “P” para los pares\n"
                        + "y la tecla “I” para los impares.");
            case 11:
                frame.setVisible(false);
                PracticaNumeros practicanumeros = new PracticaNumeros();
                practicanumeros.setVisible(true);
                this.setPantalla(practicanumeros);
            case 12:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica.");
            case 13:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora comenzará la actividad.  \n \n"
                        + "Así que, se dejará de indicar cuando la respuesta sea \n"
                        + "correcta e incorrecta. \n\n"
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
           
            case 14:
                frame.setVisible(false);
                ActividadNumeros actividadNumeros = new ActividadNumeros();
                actividadNumeros.setVisible(true);
                this.setPantalla(actividadNumeros);
            case 15:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de continuar con la siguiente parte de \n"
                        + "la actividad, realizarás un ejercicio para que \n"
                        + "te familiarices con las letras vocales y \n"
                        + "consonantes.");
            case 16:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, indicarás si la letra que\n"
                        + "aparece en el centro de la pantalla pertenece\n"
                        + "a la categoría “CONSONANTE”, presionando la tecla “C”.\n"
                        + " O si pertenece a la categoría “VOCAL”, presionando la tecla “V”.\n");
            case 17:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return ("Coloca por favor tus dedos índice y medio de\n"
                        + "la mano izquierda en las teclas “C”\n"
                        + "(consonante) y “V” (vocal).");
            case 18:
                frame.setVisible(false);
                FamiliarizacionLetras frameLetras = new FamiliarizacionLetras();
                frameLetras.setVisible(true);
                this.setPantalla(frameLetras);
            case 19:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return ("Recuerda solo presionar:\n\n"
                        + "Tecla «C»: Letra consonante\n"
                        + "\n"
                        + "Tecla «V»: Letra vocal");
            case 20:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En seguida realizarás la siguiente parte de la actividad.\n\n"
                        + "En ésta, el par número-letra\n"
                        + "aparecerá en la parte inferior de la pantalla,\n"
                        + "ya sea a la derecha o a la izquierda.");
            case 21:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Lo que harás es indicar si la letra es\n"
                        + "consonante o vocal, justo como lo hiciste en\n"
                        + "el ejercicio anterior.");
            case 22:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, podrás ver un ejemplo sobre\n"
                        + "cómo se presentarán el número-letra, así\n"
                        + "como la manera de responder.");
            case 23:
                frame.setVisible(false);
                InstruccionNL2 instruccionesPantallas2 = new InstruccionNL2();
                instruccionesPantallas2.setVisible(true);
                this.setPantalla(instruccionesPantallas2);
            case 24:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora, se te mostrará una serie de parejas \n"
                        + "de número y letra para practicar. \n \n"
                        + "Trata de responder lo más rápido que puedas.");
            case 25:
                frame.setVisible(false);
                PracticaLetras practicaletras = new PracticaLetras();
                practicaletras.setVisible(true);   
                this.setPantalla(practicaletras);
            case 26:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica.");
            case 27:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad.\n\n "
                        + "Así que, se dejará de indicar cuando la respuesta sea\n"
                        + "correcta e incorrecta.\n\n "
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
            case 28:
                frame.setVisible(false);
                ActividadLetras actividadeLetras = new ActividadLetras();
                actividadeLetras.setVisible(true);
                this.setPantalla(actividadeLetras);
            case 29:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora, el par número-letra se presentará en\n"
                        + "cada uno de los cuatro cuadrantes de la\n"
                        + "pantalla en el sentido de las manecillas del\n"
                        + "reloj (arriba-derecha, arriba-izquierda,\n"
                        + "abajo-izquierda y abajo-derecha).");
            case 30:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return ("Cuando el par número-letra esté en alguno\n"
                        + "de los dos cuadrantes de ARRIBA, indicarás\n"
                        + "si el número es PAR o IMPAR. Cuando se\n"
                        + "encuentre en alguno de los dos cuadrantes\n"
                        + "de ABAJO, indicarás si la letra es\n"
                        + "CONSONANTE o VOCAL.");
            case 31:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, se te mostrará una serie de\n"
                        + "parejas de número-letra para practicar. Trata\n"
                        + "de responder lo más rápido que puedas.");
            case 32:
                frame.setVisible(false);
                MixtoPractica mixtoPractica = new MixtoPractica();
                mixtoPractica.setVisible(true);
                this.setPantalla(mixtoPractica);
            case 33:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return("Recuerda solo presionar:\n"
                        + "\n"
                        + "Tecla «P»: Número par\n"
                        + "\n"
                        + "Tecla «I»: Número impar\n"
                        + "\n"
                        + "Tecla «C»: Letra consonante\n"
                        + "\n"
                        + "Tecla «V»: Letra vocal");
                
            case 34:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica.");
            case 35:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. Así que,\n"
                        + "se dejará de indicar cuando la respuesta sea\n"
                        + "correcta e incorrecta. Haz tu mejor esfuerzo\n"
                        + "y trata de responder lo más rápido posible.");
            case 36:
                frame.setVisible(false);
                MixtoActividad mixtoActividad = new MixtoActividad();
                mixtoActividad.setVisible(true);
                this.setPantalla(mixtoActividad);
            case 37:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chango.png")));
                return "¡Excelente trabajo! Lo hiciste muy bien. Has \n"
                        + "terminado con esta actividad."
                        + "\n\nFIN DE ACTIVIDAD";
            case 38:
                this.calculosNumberLetter();
                controlGeneral.ejecutarEjercicios(controlGeneral.getPantalla());
            default:
                return "FELICIDADES HAS ACABADO CON LAS ACTIVIDADES";
        }
    }

    public JFrame getPantalla() {
        return pantalla;
    }

    public void setPantalla(JFrame pantalla) {
        this.pantalla = pantalla;
    }

    public JLabel getEtiquetaA() {
        return etiquetaA;
    }

    public void setEtiquetaA(JLabel etiquetaA) {
        this.etiquetaA = etiquetaA;
    }

    public JLabel getEtiquetaB() {
        return etiquetaB;
    }

    public void setEtiquetaB(JLabel etiquetaB) {
        this.etiquetaB = etiquetaB;
    }

    public JLabel getEtiquetaC() {
        return etiquetaC;
    }

    public void setEtiquetaC(JLabel etiquetaC) {
        this.etiquetaC = etiquetaC;
    }

    public JLabel getEtiquetaD() {
        return etiquetaD;
    }

    public void setEtiquetaD(JLabel etiquetaD) {
        this.etiquetaD = etiquetaD;
    }

    public JLabel getEtiquetaE() {
        return etiquetaE;
    }

    public void setEtiquetaE(JLabel etiquetaE) {
        this.etiquetaE = etiquetaE;
    }

    public JLabel getEtiquetaF() {
        return etiquetaF;
    }

    public void setEtiquetaF(JLabel etiquetaF) {
        this.etiquetaF = etiquetaF;
    }

    public JLabel getEtiquetaG() {
        return etiquetaG;
    }

    public void setEtiquetaG(JLabel etiquetaG) {
        this.etiquetaG = etiquetaG;
    }

    public JLabel getEtiquetaH() {
        return etiquetaH;
    }

    public void setEtiquetaH(JLabel etiquetaH) {
        this.etiquetaH = etiquetaH;
    }

    public JLabel getEtiquetaString() {
        return etiquetaString;
    }

    public void setEtiquetaString(JLabel etiquetaString) {
        this.etiquetaString = etiquetaString;
    }

    public JLabel getEtiquetaRespuesta() {
        return etiquetaRespuesta;
    }

    public void setEtiquetaRespuesta(JLabel etiquetaRespuesta) {
        this.etiquetaRespuesta = etiquetaRespuesta;
    }

    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    public void setEtiquetaImagen(JLabel etiquetaImagen) {
        this.etiquetaImagen = etiquetaImagen;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getContadoraux() {
        return contadoraux;
    }

    public void setContadoraux(int contadoraux) {
        this.contadoraux = contadoraux;
    }

}