/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import guiPlusMinus.AleatorioEjemplosInferfaz;
import guiPlusMinus.AleatorioEjerciciosInterfaz;
import guiPlusMinus.AleatorioPracticaInterfaz;
import guiPlusMinus.RestaEjemplosInterfaz;
import guiPlusMinus.RestaEjerciciosInterfaz;
import guiPlusMinus.RestaGif;
import guiPlusMinus.RestaPracticaInterfaz;
import guiPlusMinus.SumaEjemplosInterfaz;
import guiPlusMinus.SumaEjerciciosInterfaz;
import guiPlusMinus.SumaGif;
import guiPlusMinus.SumaPracticaInterfaz;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosNegocio.Plusminus;
import persistencia.Persistencia;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
/**
 *
 * @author David Hermosillo
 */
public class ControlPlusMinus {
    
    //Variable que crea el objeto plus minus
    private final objetosNegocio.Plusminus objetoPlusMinus;
    
    //Variable que llama a la persistencia;
    private final Persistencia persistencia = Persistencia.getSingletonInstance();
    
    //Variable del objeto control plus minus
    private static ControlPlusMinus controlPlusMinus;
    
    //Control general
    ControlGeneral controlGeneral = ControlGeneral.getSingletonInstance();
    
    //Variable contador que sirve para cambiar las instrucciones
    int contador = 0;
    
    //Variables auxiliares
    boolean relacionUno = false, relacionDos = false, relacionTres = false;
    
    //Pantalla
    JFrame pantalla;
    
    /**
     * Constuctor que crea un objeto de tipo control con el objeto de plus minus
     */
    private ControlPlusMinus() {
        objetoPlusMinus = new Plusminus();
    }
    
    /**
     * Método singleton de la clase plusminus
     * @return 
     */
    public static ControlPlusMinus getSingletonInstance() {
        if (controlPlusMinus == null) {
            controlPlusMinus = new ControlPlusMinus();
        } else {
            
        }
        return controlPlusMinus;
    }
    
    
    /**
     * Método que se encarga de llamar a la persistencia para proceder a agregar el objeto
     */
    private void agregarPlusMinusC(){
        if(persistencia.agregarPlusMinusBD(this.objetoPlusMinus)) {
            JOptionPane.showMessageDialog(null, "Se guardó con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar");
        }
    }
    
    /**
     * Este método permite verificar los resultados de suma ingresados en la
     * interfaz y los clasifica en incorrectas, correctas o no respondidas
     *
     * @param aleatorios
     * @param resultados
     * @param n
     */
    public void resultadoSuma(String[] aleatorios, String[] resultados, int n) {
        int respuestasCorrectasSumas = 0;
        int respuestasIncorrectasSumas = 0;
        int noRespuestasSumas = 0;

        Integer arregloResultados[] = new Integer[n];
        Integer arregloAleatorios[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            arregloAleatorios[i] = Integer.parseInt(aleatorios[i]);
            if (resultados[i] == null) {
                arregloResultados[i] = null;
            } else {
                arregloResultados[i] = Integer.parseInt(resultados[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arregloResultados[i] == null) {
                noRespuestasSumas++;
            } else if (arregloAleatorios[i] + 3 == arregloResultados[i]) {
                respuestasCorrectasSumas++;
            } else {
                respuestasIncorrectasSumas++;
            }
        }
        
        objetoPlusMinus.setRespuestasCorrectasSuma(respuestasCorrectasSumas);
        objetoPlusMinus.setRespuestasIncorrectasSuma(respuestasIncorrectasSumas);
        objetoPlusMinus.setRespuestasSuma(30 - noRespuestasSumas);
        objetoPlusMinus.setNoRespondidasSumar(noRespuestasSumas);
    }
    
    /**
     * Este método permite establecer el tiempo total que tomó responder
     * los ejercicios de suma
     * @param tiempo 
     */
    public void tiempoSuma (double tiempo) {
        objetoPlusMinus.setTiempoSuma(tiempo);
    }
    
    /**
     * Este método permite verificar los resultados de resta ingresados en la
     * interfaz y los clasifica en correctas, incorrectas y no respondidas
     *
     * @param aleatorios
     * @param resultados
     * @param n
     */
    public void resultadoResta(String[] aleatorios, String[] resultados, int n) {
        int respuestasCorrectasRestas = 0;
        int respuestasIncorrectasRestas = 0;
        int noRespuestasRestas = 0;

        Integer arregloResultados[] = new Integer[n];
        Integer arregloAleatorios[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            arregloAleatorios[i] = Integer.parseInt(aleatorios[i]);
            if (resultados[i] == null) {
                arregloResultados[i] = null;
            } else {
                arregloResultados[i] = Integer.parseInt(resultados[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arregloResultados[i] == null) {
                noRespuestasRestas++;
            } else if (arregloAleatorios[i] - 3 == arregloResultados[i]) {
                respuestasCorrectasRestas++;
            } else {
                respuestasIncorrectasRestas++;
            }
        }
        
        objetoPlusMinus.setRespuestasCorrectasResta(respuestasCorrectasRestas);
        objetoPlusMinus.setRespuestasIncorrectasResta(respuestasIncorrectasRestas);
        objetoPlusMinus.setRespuestasResta(n - noRespuestasRestas);
        objetoPlusMinus.setNoRespondidasRestar(noRespuestasRestas);
    }

    /**
     * Este método permite establecer el tiempo total que tomó responder
     * los ejercicios de resta
     * @param tiempo 
     */
    public void tiempoResta(double tiempo) {
        objetoPlusMinus.setTiempoResta(tiempo);
    }
    
    /**
     * Este método permite verificar los resultados de suma y resta ingresados
     * en la interfaz y los clasifica en correctas, incorrectas y no respondidas
     *
     * @param aleatorios
     * @param resultados
     * @param n
     */
    public void resultadoAlternado(String[] aleatorios, String[] resultados, int n) {
        int respuestasCorrectasAlternado = 0;
        int respuestasIncorrectasAlternado = 0;
        int noRespuestasAlternado = 0;

        Integer arregloResultados[] = new Integer[n];
        Integer arregloAleatorios[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            arregloAleatorios[i] = Integer.parseInt(aleatorios[i]);
            if (resultados[i] == null) {
                arregloResultados[i] = null;
            } else {
                arregloResultados[i] = Integer.parseInt(resultados[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (arregloResultados[i] == null) {
                    noRespuestasAlternado++;
                } else if (arregloAleatorios[i] + 3 == arregloResultados[i]) {
                    respuestasCorrectasAlternado++;
                } else {
                    respuestasIncorrectasAlternado++;
                }
            } else {
                if (arregloResultados[i] == null) {
                    noRespuestasAlternado++;
                } else if (arregloAleatorios[i] - 3 == arregloResultados[i]) {
                    respuestasCorrectasAlternado++;
                } else {
                    respuestasIncorrectasAlternado++;
                }
            }
        }
        
        objetoPlusMinus.setRespuestasCorrectasAlternado(respuestasCorrectasAlternado);
        objetoPlusMinus.setRespuestasIncorrectasAlternado(respuestasIncorrectasAlternado);
        objetoPlusMinus.setRespuestasAlternado(n - noRespuestasAlternado);
        objetoPlusMinus.setNoRespondidasAlternado(noRespuestasAlternado);
    }

    /**
     * Este método permite establecer el tiempo total que tomó responder
     * los ejercicios alternados
     * @param tiempo 
     */
    public void tiempoAlternado(double tiempo) {
        objetoPlusMinus.setTiempoAlternado(tiempo);
    }
    
    /**
     * Método que permite hacer el calculo de todas las variables
     * @param folio
     */
    public void obtenerResultados(int folio) {
        
        System.out.println(objetoPlusMinus.toString());
        
        //Tiempo total de los 3 bloques
        this.objetoPlusMinus.setTiempoTotal(this.objetoPlusMinus.getTiempoSuma() + this.objetoPlusMinus.getTiempoResta()
                + this.objetoPlusMinus.getTiempoAlternado());

        //Costo del shifting con el tiempo total
        this.objetoPlusMinus.setShiftingTotal(this.objetoPlusMinus.getTiempoAlternado()
                - ((this.objetoPlusMinus.getTiempoResta() + this.objetoPlusMinus.getTiempoSuma()) / 2));

        //Respuestas totales en los bloques
        this.objetoPlusMinus.setRespuestasTotales(this.objetoPlusMinus.getRespuestasSuma() + this.objetoPlusMinus.getRespuestasResta()
                + this.objetoPlusMinus.getRespuestasAlternado());

        //Respuestas correctas totales
        this.objetoPlusMinus.setRespuestasCorrectasTotales(this.objetoPlusMinus.getRespuestasCorrectasSuma()
                + this.objetoPlusMinus.getRespuestasCorrectasResta()
                + this.objetoPlusMinus.getRespuestasCorrectasAlternado());

        //Tiemporeacción promedio en el bloque de solo sumas
        this.objetoPlusMinus.setReaccionPromedioSuma(this.objetoPlusMinus.getTiempoSuma()
                / this.objetoPlusMinus.getRespuestasSuma());

        //Tiempo de reaccion promedio en el bloque de solo restas
        this.objetoPlusMinus.setReaccionPromedioResta(this.objetoPlusMinus.getTiempoResta()
                / this.objetoPlusMinus.getRespuestasResta());

        //Tiempo de reaccion promedio en el bloque de solo alternado
        this.objetoPlusMinus.setReaccionPromedioAlternado(this.objetoPlusMinus.getTiempoAlternado()
                / this.objetoPlusMinus.getRespuestasAlternado());

        //Tiempo de reacción promedio de los 3 bloques
        this.objetoPlusMinus.setReaccionPromedioTotal(this.objetoPlusMinus.getTiempoTotal()
                / this.objetoPlusMinus.getRespuestasTotales());

        //Costo del shifiting con el tiempo de reaccion promedio de todas las respuestas
        this.objetoPlusMinus.setShiftingReaccionPromedio(this.objetoPlusMinus.getReaccionPromedioAlternado()
                - ((this.objetoPlusMinus.getReaccionPromedioSuma() + this.objetoPlusMinus.getReaccionPromedioResta()) / 2));

        //Respuestas incorrectas totales
        this.objetoPlusMinus.setRespuestasIncorrectasTotales(this.objetoPlusMinus.getRespuestasIncorrectasSuma()
                + this.objetoPlusMinus.getRespuestasIncorrectasResta()
                + this.objetoPlusMinus.getRespuestasIncorrectasAlternado());

        //Porcentaje de respuestas correctas en el bloque de suma
        this.objetoPlusMinus.setPorcentajeCorrectasSumar(((double)this.objetoPlusMinus.getRespuestasCorrectasSuma() * 100) / 30);

        //Porcentaje de respuestas correctas en el bloque de resta
        this.objetoPlusMinus.setPorcentajeCorrectasRestar((double)(this.objetoPlusMinus.getRespuestasCorrectasResta() * 100) / 30);

        //Porcentaje de respuestas correctas en el bloque de alternado
        this.objetoPlusMinus.setPorcentajeCorrectasAlternado(((double)this.objetoPlusMinus.getRespuestasCorrectasAlternado() * 100) / 30);

        //Porcentaje de respuestas correctas en los 3 bloques
        this.objetoPlusMinus.setPorcentajeCorrectasTotal(((double)this.objetoPlusMinus.getRespuestasCorrectasTotales() * 100) / 90);

        //Shifting respuestas correctas totales
        this.objetoPlusMinus.setShiftingRespuestasCorrectasTotales(this.objetoPlusMinus.getPorcentajeCorrectasAlternado()
                - ((this.objetoPlusMinus.getPorcentajeCorrectasSumar() + this.objetoPlusMinus.getPorcentajeCorrectasRestar()) / 2));

        
        if (!(this.objetoPlusMinus.getNoRespondidasSumar()== 0)) {
            this.objetoPlusMinus.setPorcentajeRelacionSumar(((double)this.objetoPlusMinus.getRespuestasCorrectasSuma() * 100) / this.objetoPlusMinus.getRespuestasSuma());
            relacionUno = true;
        }

        if (!(this.objetoPlusMinus.getNoRespondidasRestar()== 0)) {
            this.objetoPlusMinus.setPorcentajeRelacionRestar(((double)this.objetoPlusMinus.getRespuestasCorrectasResta() * 100) / this.objetoPlusMinus.getRespuestasResta());
            relacionDos = true;
        }

        if (!(this.objetoPlusMinus.getNoRespondidasAlternado() == 0)) {
            this.objetoPlusMinus.setPorcentajeRelacionAlternado(((double)this.objetoPlusMinus.getRespuestasCorrectasAlternado() * 100) / this.objetoPlusMinus.getRespuestasAlternado());
            relacionTres = true;
        }

        if (relacionUno && relacionDos && relacionTres) {
            this.objetoPlusMinus.setPorcentajeRelacionTotal(((double)this.objetoPlusMinus.getRespuestasCorrectasTotales() * 100) / this.objetoPlusMinus.getRespuestasTotales());
        }

        if (relacionUno && relacionDos && relacionTres) {
            this.objetoPlusMinus.setShiftingRelacionIndividual(this.objetoPlusMinus.getPorcentajeRelacionAlternado()
                    - ((this.objetoPlusMinus.getPorcentajeRelacionSumar() + this.objetoPlusMinus.getPorcentajeRelacionRestar()) / 2));
        }

        this.objetoPlusMinus.setNoRespondidasTotales(this.objetoPlusMinus.getNoRespondidasSumar()
                + this.objetoPlusMinus.getNoRespondidasRestar()
                + this.objetoPlusMinus.getNoRespondidasAlternado());

        this.objetoPlusMinus.setIdPlusMinus(folio);
        this.agregarPlusMinusC();
    }
    
    /**
     * Método que regresa un número random en string
     * @return 
     */
    public String numeroRandom() {
        
        int randomNum = ThreadLocalRandom.current().nextInt(10, 99 + 1);

        return String.valueOf(randomNum);
    }
    
    /**
     * Método que permite verificar si el textfield está vacio
     * @param texto
     * @return 
     */
    public String verificaciónTextField(String texto) {
        if (texto.isEmpty()) {
            return null;
        } else {
            return texto;
        }
    }
    
    public Object instruccionesPantalla(JFrame frame, JLabel label) {
        switch (contador) {
            case 0:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En esta actividad se te mostrarán varias listas de números\n"
                        + "de 2 dígitos, cada una con un cuadro a lado. \n\n"
                        + "En ese cuadro escribirás el resultado de sumar 3 o restar 3,\n"
                        + " de acuerdo a como se te vaya indicando.");
            case 1:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Comenzarás con la lista de números a la que le sumarás 3 a cada número.\n"
                        + " Antes de comenzar pon atención en el siguiente \n"
                        + "recordatorio sobre como sumar.\n");
            case 2:
                frame.setVisible(false);
                SumaGif gifSuma = new SumaGif();
                gifSuma.setVisible(true);
               this.setPantalla(gifSuma);
            case 3:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, podrás ver un ejemplo sobre cómo responderás la actividad.\n\n"
                        + "Recuerda que sumarás 3 a cada número\n "
                        + "y el resultado lo colocarás en su cuadro correspondiente.");
            case 4:
                frame.setVisible(false);
                SumaEjemplosInterfaz sumaEjemplos = new SumaEjemplosInterfaz();
                sumaEjemplos.setVisible(true);
               this.setPantalla(sumaEjemplos);
            case 5:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En seguida, se te mostrarán una serie de números para practicar.\n"
                        + "Trata de responder lo más rápido que puedas.");
            case 6:
                frame.setVisible(false);
                SumaPracticaInterfaz sumaPracticas = new SumaPracticaInterfaz();
                sumaPracticas.setVisible(true);
               this.setPantalla(sumaPracticas);
            case 7:
                this.setContador(this.getContador() + 1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste todos los ejercicios de práctica");
            case 8:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. \n\n"
                        + "Se dejará de mostrar el signo “más”(+) \n"
                        + "y las respuestas correctas e incorrectas.\n\n"
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
            case 9:
                frame.setVisible(false);
                SumaEjerciciosInterfaz sumaEjercicios = new SumaEjerciciosInterfaz();
                sumaEjercicios.setVisible(true);
               this.setPantalla(sumaEjercicios);
            case 10:
                this.setContador(this.getContador()+1);
                return (" RESTAS ");
            case 11:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, se te presentará la segunda parte de la actividad. \n"
                        + "En la cual, restarás 3 a cada número. \n"
                        + "Antes de comenzar, se te mostrará un recordatorio sobre como restar.");
            case 12:
                frame.setVisible(false);
                RestaGif gifResta = new RestaGif();
                gifResta.setVisible(true);
               this.setPantalla(gifResta);
                
            case 13:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Antes de iniciar, podrás ver un ejemplo sobre cómo responder la \n"
                        + "actividad. Recuerda que restarás 3 a cada número \n"
                        + "y el resultado lo colocarás en su cuadro correspondiente.");
            case 14:
                frame.setVisible(false);
                RestaEjemplosInterfaz restaEjemplos = new RestaEjemplosInterfaz();
                restaEjemplos.setVisible(true);
               this.setPantalla(restaEjemplos);
                
            case 15:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora, se te mostrará una serie de números para practicar.\n"
                        + "Trata de responder lo más rápido que puedas. ");
            case 16:
                frame.setVisible(false);
                RestaPracticaInterfaz restaPractica = new RestaPracticaInterfaz();
                restaPractica.setVisible(true);
               this.setPantalla(restaPractica);
                
            case 17:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste todos los ejercicios de práctica. ");
            case 18:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad.\n\n "
                        + "Así que, se dejará de mostrar el signo “menos”(-) \n"
                        + "y las respuestas correctas e incorrecta. \n"
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
            case 19:
                frame.setVisible(false);
                RestaEjerciciosInterfaz restaEjercicios = new RestaEjerciciosInterfaz();
                restaEjercicios.setVisible(true);
               this.setPantalla(restaEjercicios);
                
            case 20:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("A continuación, se te mostrará otra lista, en la cual alternarás\n"
                        + "la suma y resta de 3. Tal y como se muestra en el siguiente ejemplo.");
            case 21:
                frame.setVisible(false);
                AleatorioEjemplosInferfaz aleatorioEjemplos = new AleatorioEjemplosInferfaz();
                aleatorioEjemplos.setVisible(true);
               this.setPantalla(aleatorioEjemplos);
            case 22:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("En seguida, se te presentarán una serie de números para practicar. \n"
                        + "Trata de responder lo más rápido que puedas. ");
            case 23:
                frame.setVisible(false);
                AleatorioPracticaInterfaz aleatorioPracticas = new AleatorioPracticaInterfaz();
                aleatorioPracticas.setVisible(true);
               this.setPantalla(aleatorioPracticas);
                
            case 24:
                this.setContador(this.getContador()+1);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("¡Muy bien! Terminaste todos los ejercicios de práctica. ");
            case 25:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclado_espacio.png")));
                return ("Ahora va a comenzar la actividad. Así que, se dejarán de \n"
                        + "mostrar los signos “más”(+) y “menos”(-),  \n"
                        + "al igual que las respuestas correctas e incorrectas.\n "
                        + "Haz tu mejor esfuerzo y trata de responder lo más rápido posible.");
            case 26:
                frame.setVisible(false);
                AleatorioEjerciciosInterfaz aleatorioEjercicios = new AleatorioEjerciciosInterfaz();
                aleatorioEjercicios.setVisible(true);
               this.setPantalla(aleatorioEjercicios);
            case 27:
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chango.png")));
                return ("¡Excelente trabajo! Lo hiciste muy bien. Has terminado con esta actividad.");
            case 28:
                controlGeneral.ejecutarEjercicios(this.getPantalla());
            default:
                return null;
        }

    }

    public JFrame getPantalla() {
        return pantalla;
    }

    public void setPantalla(JFrame pantalla) {
        this.pantalla = pantalla;
    }
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
