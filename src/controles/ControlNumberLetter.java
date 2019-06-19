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
import objetosNegocio.Numberletter;
import persistencia.Persistencia;

/**
 *
 * @author David Hermosillo
 */
public class ControlNumberLetter {

    //Variable que crea el objeto number letter
    private final objetosNegocio.Numberletter objetoNumberLetter;

    //Variable que llama a la persistencia;
    private final Persistencia persistencia = Persistencia.getSingletonInstance();

    //Variable del objeto control number letter
    private static ControlNumberLetter controlNumberLetter;

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

    private Color verde = Color.decode("#1A8803");
    private JFrame pantalla = null;

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

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
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

        try {
            wait(10000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }

    /**
     * Método que evalua los resultados de los swing en los números
     *
     * @param respuesta
     * @param numero
     * @param etiquetaRespuesta
     */
    public synchronized void respuestaNumeros(String respuesta, int numero, JLabel etiquetaRespuesta) {
        String auxiliar;

        if (numero % 2 == 0) {
            auxiliar = "par";
        } else {
            auxiliar = "impar";
        }

        if (auxiliar.equals(respuesta)) {
            etiquetaRespuesta.setText("Correcto");
            notifyAll();
        } else {
            etiquetaRespuesta.setText("Incorrecto");
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
    public synchronized void respuestaLetras(String respuesta, JLabel etiquetaString, JLabel etiquetaRespuesta) {
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
            notifyAll();
        } else {
            etiquetaRespuesta.setText("Incorrecto");
            notifyAll();
        }
    }

    /**
     * Evalua las respuestas del swing en los ejercicios mixtos
     *
     * @param opcion
     */
    public synchronized void respuestaMixtos(int opcion) {
        ArrayList<JLabel> listaAuxiliar;

        switch (opcion) {
            case 1:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaA());
                listaAuxiliar.add(this.getEtiquetaB());
                listaAuxiliar.add(this.getEtiquetaC());
                listaAuxiliar.add(this.getEtiquetaD());

                if (verificarNumerosMixto(listaAuxiliar) == -1) {
                    etiquetaRespuesta.setText("Incorrecto");
                    notifyAll();
                    break;
                }

                this.respuestaNumeros("par", recorrerListaNumeros(listaAuxiliar), this.getEtiquetaRespuesta());
                if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                    this.etiquetaRespuesta.setForeground(verde);
                } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                    this.etiquetaRespuesta.setForeground(Color.red);
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
                    notifyAll();
                    break;
                }

                this.respuestaNumeros("impar", recorrerListaNumeros(listaAuxiliar), this.getEtiquetaRespuesta());
                if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                    this.etiquetaRespuesta.setForeground(verde);
                } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                    this.etiquetaRespuesta.setForeground(Color.red);
                }
                break;
            case 3:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaE());
                listaAuxiliar.add(this.getEtiquetaF());
                listaAuxiliar.add(this.getEtiquetaG());
                listaAuxiliar.add(this.getEtiquetaH());

                try {
                    this.respuestaLetras("Consonante", this.recorrerListaLetras(listaAuxiliar), this.getEtiquetaRespuesta());
                    if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                        this.etiquetaRespuesta.setForeground(verde);
                    } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                        this.etiquetaRespuesta.setForeground(Color.red);
                    }
                } catch (Exception ex) {
                    etiquetaRespuesta.setText("Incorrecto");
                    notifyAll();
                }

                break;
            case 4:
                listaAuxiliar = new ArrayList();
                listaAuxiliar.add(this.getEtiquetaE());
                listaAuxiliar.add(this.getEtiquetaF());
                listaAuxiliar.add(this.getEtiquetaG());
                listaAuxiliar.add(this.getEtiquetaH());

                try {
                    this.respuestaLetras("Vocal", this.recorrerListaLetras(listaAuxiliar), this.getEtiquetaRespuesta());
                    if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                        this.etiquetaRespuesta.setForeground(verde);
                    } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                        this.etiquetaRespuesta.setForeground(Color.red);
                    }
                } catch (Exception ex) {
                    etiquetaRespuesta.setText("Incorrecto");
                    notifyAll();
                }

                break;
        }
        
                System.out.println(pares);
                System.out.println(impares);
                System.out.println(vocal);
                System.out.println(consonante);
                System.out.println("------------------");
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
        int auxiliar = (int) (Math.random() * 8 + 2);

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
            while (contadorHiloActividadMixto < 256) {
                mixtoSwingPractica();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                contadorHiloActividadMixto++;
            }
            getPantalla().setVisible(false);
            InstruccionesNumberLetter instrucciones = InstruccionesNumberLetter.getSingletonInstance();
            instrucciones.setVisible(true);
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
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de iniciar con esta actividad, realizarás \n"
                        + "un ejercicio para que te familiarices con los\n"
                        + "números pares e impares.");
            case 1:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, indicarás si el número que \n"
                        + "aparece en el centro de la pantalla pertenece \n"
                        + "a la categoría “PAR”, presionando la \n"
                        + "tecla “P”. O si pertenece a la categoría \n"
                        + "“IMPAR”, presionando la tecla “I”.");
            case 2:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_par-impar.png")));
                return ("Por favor, coloca tus dedos índice y medio \n"
                        + "de la mano derecha en las teclas “P” (pares)\n"
                        + "y “I” (impares). ");
            case 3:
                frame.setVisible(false);
                FamiliarizacionNumeros imagenNumeros = new FamiliarizacionNumeros();
                imagenNumeros.setVisible(true);
                this.setPantalla(imagenNumeros);
            case 4:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_par-impar.png")));
                return ("Recuerda solo presionar: \n"
                        + "\n"
                        + "Tecla «P»: Número par \n"
                        + "\n"
                        + "Tecla «I»: Número impar \n"
                        + "\n"
                        + "Añadir teclado");
            case 5:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("La actividad está por comenzar.\n\n"
                        + "Ésta consistirá en que se te mostrarán un número \n"
                        + "y una letra juntos en la parte superior de la \n"
                        + "pantalla, ya sea a la derecha o a la izquierda.");
            case 6:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Lo que harás es indicar si el número es par o impar, \n"
                        + "justo como lo hiciste en el ejercicio anterior.");
            case 7:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, podrás ver un ejemplo sobre\n"
                        + "cómo se presentarán el número y letra, \n"
                        + "así como la manera de responder.");
            case 8:
                frame.setVisible(false);
                InstruccionNL instruccionesPantallas = new InstruccionNL();
                instruccionesPantallas.setVisible(true);
                this.setPantalla(instruccionesPantallas);

            case 9:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_par-impar.png")));
                return ("Ahora, se te mostrará una serie de parejas \n"
                        + "de número y letra para practicar. \n \n"
                        + "Trata de responder lo más rápido que puedas. \n\n"
                        + "Recuerda presionar la tecla “P” para los pares\n"
                        + "y la tecla “I” para los impares.");
            case 10:
                frame.setVisible(false);
                PracticaNumeros practicanumeros = new PracticaNumeros();
                practicanumeros.setVisible(true);
                this.setPantalla(practicanumeros);
            case 11:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica.");
            case 12:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora comenzará la actividad.  \n \n"
                        + "Así que, se dejará de indicar cuando la respuesta sea \n"
                        + "correcta e incorrecta. \n\n"
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
           
            case 13:
                frame.setVisible(false);
                ActividadNumeros actividadNumeros = new ActividadNumeros();
                actividadNumeros.setVisible(true);
                this.setPantalla(actividadNumeros);
            case 14:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de continuar con la siguiente parte de \n"
                        + "la actividad, realizarás un ejercicio para que \n"
                        + "te familiarices con las letras vocales y \n"
                        + "consonantes.");
            case 15:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, indicarás si la letra que\n"
                        + "aparece en el centro de la pantalla pertenece\n"
                        + "a la categoría “CONSONANTE”, presionando la tecla “C”.\n"
                        + " O si pertenece a la categoría “VOCAL”, presionando la tecla “V”.\n");
            case 16:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return ("Coloca por favor tus dedos índice y medio de\n"
                        + "la mano izquierda en las teclas “C”\n"
                        + "(consonante) y “V” (vocal).");
            case 17:
                frame.setVisible(false);
                FamiliarizacionLetras frameLetras = new FamiliarizacionLetras();
                frameLetras.setVisible(true);
                this.setPantalla(frameLetras);
            case 18:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return ("Recuerda solo presionar:\n\n"
                        + "Tecla «C»: Letra consonante\n"
                        + "\n"
                        + "Tecla «V»: Letra vocal");
            case 19:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En seguida realizarás la siguiente parte de la actividad.\n\n"
                        + "En ésta, el par número-letra\n"
                        + "aparecerá en la parte inferior de la pantalla,\n"
                        + "ya sea a la derecha o a la izquierda.");
            case 20:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Lo que harás es indicar si la letra es\n"
                        + "consonante o vocal, justo como lo hiciste en\n"
                        + "el ejercicio anterior.");
            case 21:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, podrás ver un ejemplo sobre\n"
                        + "cómo se presentarán el número-letra, así\n"
                        + "como la manera de responder.");
            case 22:
                frame.setVisible(false);
                InstruccionNL2 instruccionesPantallas2 = new InstruccionNL2();
                instruccionesPantallas2.setVisible(true);
                this.setPantalla(instruccionesPantallas2);
            case 23:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora, se te mostrará una serie de parejas \n"
                        + "de número y letra para practicar. \n \n"
                        + "Trata de responder lo más rápido que puedas.");
            case 24:
                frame.setVisible(false);
                PracticaLetras practicaletras = new PracticaLetras();
                practicaletras.setVisible(true);   
                this.setPantalla(practicaletras);
            case 25:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica.");
            case 26:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad.\n\n "
                        + "Así que, se dejará de indicar cuando la respuesta sea\n"
                        + "correcta e incorrecta.\n\n "
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
            case 27:
                frame.setVisible(false);
                ActividadLetras actividadeLetras = new ActividadLetras();
                actividadeLetras.setVisible(true);
                this.setPantalla(actividadeLetras);
            case 28:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora, el par número-letra se presentará en\n"
                        + "cada uno de los cuatro cuadrantes de la\n"
                        + "pantalla en el sentido de las manecillas del\n"
                        + "reloj (arriba-derecha, arriba-izquierda,\n"
                        + "abajo-izquierda y abajo-derecha).");
            case 29:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_consonante-vocal.png")));
                return ("Cuando el par número-letra esté en alguno\n"
                        + "de los dos cuadrantes de ARRIBA, indicarás\n"
                        + "si el número es PAR o IMPAR. Cuando se\n"
                        + "encuentre en alguno de los dos cuadrantes\n"
                        + "de ABAJO, indicarás si la letra es\n"
                        + "CONSONANTE o VOCAL.");
            case 30:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, se te mostrará una serie de\n"
                        + "parejas de número-letra para practicar. Trata\n"
                        + "de responder lo más rápido que puedas.");
            case 31:
                frame.setVisible(false);
                MixtoPractica mixtoPractica = new MixtoPractica();
                mixtoPractica.setVisible(true);
                this.setPantalla(mixtoPractica);
            case 32:
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
                
            case 33:
                this.setContadoraux(this.getContadoraux() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste los ejercicios de práctica.");
            case 34:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. Así que,\n"
                        + "se dejará de indicar cuando la respuesta sea\n"
                        + "correcta e incorrecta. Haz tu mejor esfuerzo\n"
                        + "y trata de responder lo más rápido posible.");
            case 35:
                frame.setVisible(false);
                MixtoActividad mixtoActividad = new MixtoActividad();
                mixtoActividad.setVisible(true);
                this.setPantalla(mixtoActividad);
            default:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chango.png")));
                return "¡Excelente trabajo! Lo hiciste muy bien. Has \n"
                        + "terminado con esta actividad."
                        + "\n\nFIN DE ACTIVIDAD";
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
