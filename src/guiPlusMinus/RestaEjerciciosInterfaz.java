/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiPlusMinus;

import controles.ControlPlusMinus;
import java.awt.BorderLayout;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author David Hermosillo
 */
public class RestaEjerciciosInterfaz extends javax.swing.JFrame {

    String numerosAleatorios[] = new String[30];
    String numerosRespuestas[] = new String[30];
    double startTime;
    GridBagConstraints gbc = new GridBagConstraints();
    ControlPlusMinus control = ControlPlusMinus.getSingletonInstance();

    /**
     * Creates new form SumaEjerciciosInterfaz
     */
    public RestaEjerciciosInterfaz() {
        initComponents();
        //se cambia el tamaño del panel y el frame para que este a la resolucion de la pantalla
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize((int) d.getWidth(), (int) d.getHeight());
        jPanel1.setSize((int) d.getWidth(), (int) d.getHeight());
        this.add(jPanel1, BorderLayout.CENTER);
        //se centra el texPanel en el panel
        jPanel1.setLayout(new GridBagLayout());
        gbc.gridwidth = 2; // El área de texto ocupa dos columnas.
        gbc.gridheight = 2; // El área de texto ocupa 2 filas.
        gbc.weightx = 2;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.CENTER;
        jPanel1.add(jPanel2, gbc);
        startTime = System.currentTimeMillis();

        jLabel1.setText(control.numeroRandom());
        numerosAleatorios[0] = jLabel1.getText();

        jLabel2.setText(control.numeroRandom());
        numerosAleatorios[1] = jLabel2.getText();

        jLabel3.setText(control.numeroRandom());
        numerosAleatorios[2] = jLabel3.getText();

        jLabel4.setText(control.numeroRandom());
        numerosAleatorios[3] = jLabel4.getText();

        jLabel5.setText(control.numeroRandom());
        numerosAleatorios[4] = jLabel5.getText();

        jLabel6.setText(control.numeroRandom());
        numerosAleatorios[5] = jLabel6.getText();

        jLabel7.setText(control.numeroRandom());
        numerosAleatorios[6] = jLabel7.getText();

        jLabel8.setText(control.numeroRandom());
        numerosAleatorios[7] = jLabel8.getText();

        jLabel9.setText(control.numeroRandom());
        numerosAleatorios[8] = jLabel9.getText();

        jLabel10.setText(control.numeroRandom());
        numerosAleatorios[9] = jLabel10.getText();

        jLabel11.setText(control.numeroRandom());
        numerosAleatorios[10] = jLabel11.getText();

        jLabel12.setText(control.numeroRandom());
        numerosAleatorios[11] = jLabel12.getText();

        jLabel13.setText(control.numeroRandom());
        numerosAleatorios[12] = jLabel13.getText();

        jLabel14.setText(control.numeroRandom());
        numerosAleatorios[13] = jLabel14.getText();

        jLabel15.setText(control.numeroRandom());
        numerosAleatorios[14] = jLabel15.getText();

        jLabel31.setText(control.numeroRandom());
        numerosAleatorios[15] = jLabel31.getText();

        jLabel32.setText(control.numeroRandom());
        numerosAleatorios[16] = jLabel32.getText();

        jLabel33.setText(control.numeroRandom());
        numerosAleatorios[17] = jLabel33.getText();

        jLabel34.setText(control.numeroRandom());
        numerosAleatorios[18] = jLabel34.getText();

        jLabel35.setText(control.numeroRandom());
        numerosAleatorios[19] = jLabel35.getText();

        jLabel36.setText(control.numeroRandom());
        numerosAleatorios[20] = jLabel36.getText();

        jLabel37.setText(control.numeroRandom());
        numerosAleatorios[21] = jLabel37.getText();

        jLabel38.setText(control.numeroRandom());
        numerosAleatorios[22] = jLabel38.getText();

        jLabel39.setText(control.numeroRandom());
        numerosAleatorios[23] = jLabel39.getText();

        jLabel40.setText(control.numeroRandom());
        numerosAleatorios[24] = jLabel40.getText();

        jLabel41.setText(control.numeroRandom());
        numerosAleatorios[25] = jLabel41.getText();

        jLabel42.setText(control.numeroRandom());
        numerosAleatorios[26] = jLabel42.getText();

        jLabel43.setText(control.numeroRandom());
        numerosAleatorios[27] = jLabel43.getText();

        jLabel44.setText(control.numeroRandom());
        numerosAleatorios[28] = jLabel44.getText();

        jLabel45.setText(control.numeroRandom());
        numerosAleatorios[29] = jLabel45.getText();
        jPanel1.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        caja1 = new javax.swing.JTextField();
        caja2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        caja3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        caja4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        caja5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        caja6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        caja7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        caja8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        caja9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        caja10 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        caja11 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        caja12 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        caja13 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        caja14 = new javax.swing.JTextField();
        caja15 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        caja16 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        caja17 = new javax.swing.JTextField();
        caja18 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        caja19 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        caja20 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        caja21 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        caja22 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        caja23 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        caja24 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        caja25 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        caja26 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        caja27 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        caja28 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        caja29 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        caja30 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("=");

        caja1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja1KeyTyped(evt);
            }
        });

        caja2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja2KeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("=");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("=");

        caja3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja3KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText("=");

        caja4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja4KeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setText("=");

        caja5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja5KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText("=");

        caja6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja6KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setText("=");

        caja7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja7KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setText("=");

        caja8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja8KeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setText("=");

        caja9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja9KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("jLabel10");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setText("=");

        caja10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja10KeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setText("=");

        caja11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja11KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("jLabel11");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("jLabel12");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setText("=");

        caja12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja12KeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("=");

        caja13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja13KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("jLabel14");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("jLabel15");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setText("=");

        caja14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja14KeyTyped(evt);
            }
        });

        caja15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja15KeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel30.setText("=");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setText("jLabel31");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel46.setText("=");

        caja16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja16KeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setText("jLabel32");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel47.setText("=");

        caja17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja17KeyTyped(evt);
            }
        });

        caja18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja18KeyTyped(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel48.setText("=");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setText("jLabel33");

        caja19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja19KeyTyped(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel49.setText("=");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setText("jLabel34");

        caja20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja20KeyTyped(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel50.setText("=");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setText("jLabel35");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setText("jLabel36");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel51.setText("=");

        caja21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja21KeyTyped(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("jLabel37");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel52.setText("=");

        caja22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja22KeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setText("jLabel38");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel53.setText("=");

        caja23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caja23ActionPerformed(evt);
            }
        });
        caja23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja23KeyTyped(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setText("jLabel39");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel54.setText("=");

        caja24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja24KeyTyped(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setText("jLabel40");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel55.setText("=");

        caja25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja25KeyTyped(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setText("jLabel41");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel56.setText("=");

        caja26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja26KeyTyped(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setText("jLabel42");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel57.setText("=");

        caja27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja27KeyTyped(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setText("jLabel43");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel58.setText("=");

        caja28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja28KeyTyped(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel44.setText("jLabel44");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel59.setText("=");

        caja29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caja29ActionPerformed(evt);
            }
        });
        caja29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja29KeyTyped(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel45.setText("jLabel45");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel60.setText("=");

        caja30.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        caja30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja30KeyTyped(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addGap(25, 25, 25))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17)
                                                .addGap(26, 26, 26)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel18)
                                            .addGap(26, 26, 26)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addGap(26, 26, 26)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(caja4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(caja2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(caja1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(caja3))
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                                .addComponent(jLabel15)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(caja5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel24))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel23))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel21))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel22))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel25)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(caja10, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(caja9)
                                    .addComponent(caja7)
                                    .addComponent(caja6)
                                    .addComponent(caja8, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(caja11, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(caja12)
                    .addComponent(caja13)
                    .addComponent(caja14)
                    .addComponent(caja15)
                    .addComponent(caja16)
                    .addComponent(caja17)
                    .addComponent(caja18)
                    .addComponent(caja19)
                    .addComponent(caja20))
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel53)
                        .addGap(34, 34, 34)
                        .addComponent(caja23, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel55)
                        .addGap(34, 34, 34)
                        .addComponent(caja25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58)
                        .addGap(34, 34, 34)
                        .addComponent(caja28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56)
                        .addGap(34, 34, 34)
                        .addComponent(caja26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel59))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel60)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caja29)
                            .addComponent(caja30)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel57)
                        .addGap(34, 34, 34)
                        .addComponent(caja27))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel54)
                            .addGap(34, 34, 34)
                            .addComponent(caja24))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel51))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel52)))
                            .addGap(34, 34, 34)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(caja21, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(caja22)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(331, 331, 331))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel16)
                    .addComponent(caja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel26)
                    .addComponent(caja11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel51)
                    .addComponent(caja21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel17)
                    .addComponent(caja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel27)
                    .addComponent(caja12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel52)
                    .addComponent(caja22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel18)
                    .addComponent(caja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(caja13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel38)
                    .addComponent(jLabel53)
                    .addComponent(caja23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel54)
                            .addComponent(caja24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40)
                                .addComponent(jLabel55))
                            .addComponent(caja25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel41)
                                .addComponent(jLabel56))
                            .addComponent(caja26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(caja27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57)
                                    .addComponent(jLabel42)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel19)
                            .addComponent(caja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel29)
                            .addComponent(caja14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20)
                            .addComponent(caja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel30)
                            .addComponent(caja15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel21)
                            .addComponent(caja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel46)
                            .addComponent(caja16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel22)
                                .addComponent(caja7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32)
                                .addComponent(jLabel47)
                                .addComponent(caja17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caja18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel33)
                    .addComponent(jLabel8)
                    .addComponent(jLabel23)
                    .addComponent(caja8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel58)
                    .addComponent(caja28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caja19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel34)
                            .addComponent(jLabel9)
                            .addComponent(jLabel24)
                            .addComponent(caja9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(caja20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50)
                                .addComponent(jLabel35)
                                .addComponent(jLabel10)
                                .addComponent(jLabel25)
                                .addComponent(jLabel45)
                                .addComponent(jLabel60))
                            .addComponent(caja10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caja29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caja30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caja23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caja23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caja23ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        numerosRespuestas[0] = control.verificaciónTextField(caja1.getText());
        numerosRespuestas[1] = control.verificaciónTextField(caja2.getText());
        numerosRespuestas[2] = control.verificaciónTextField(caja3.getText());
        numerosRespuestas[3] = control.verificaciónTextField(caja4.getText());
        numerosRespuestas[4] = control.verificaciónTextField(caja5.getText());
        numerosRespuestas[5] = control.verificaciónTextField(caja6.getText());
        numerosRespuestas[6] = control.verificaciónTextField(caja7.getText());
        numerosRespuestas[7] = control.verificaciónTextField(caja8.getText());
        numerosRespuestas[8] = control.verificaciónTextField(caja9.getText());
        numerosRespuestas[9] = control.verificaciónTextField(caja10.getText());
        numerosRespuestas[10] = control.verificaciónTextField(caja11.getText());
        numerosRespuestas[11] = control.verificaciónTextField(caja12.getText());
        numerosRespuestas[12] = control.verificaciónTextField(caja13.getText());
        numerosRespuestas[13] = control.verificaciónTextField(caja14.getText());
        numerosRespuestas[14] = control.verificaciónTextField(caja15.getText());
        numerosRespuestas[15] = control.verificaciónTextField(caja16.getText());
        numerosRespuestas[16] = control.verificaciónTextField(caja17.getText());
        numerosRespuestas[17] = control.verificaciónTextField(caja18.getText());
        numerosRespuestas[18] = control.verificaciónTextField(caja19.getText());
        numerosRespuestas[19] = control.verificaciónTextField(caja20.getText());
        numerosRespuestas[20] = control.verificaciónTextField(caja21.getText());
        numerosRespuestas[21] = control.verificaciónTextField(caja22.getText());
        numerosRespuestas[22] = control.verificaciónTextField(caja23.getText());
        numerosRespuestas[23] = control.verificaciónTextField(caja24.getText());
        numerosRespuestas[24] = control.verificaciónTextField(caja25.getText());
        numerosRespuestas[25] = control.verificaciónTextField(caja26.getText());
        numerosRespuestas[26] = control.verificaciónTextField(caja27.getText());
        numerosRespuestas[27] = control.verificaciónTextField(caja28.getText());
        numerosRespuestas[28] = control.verificaciónTextField(caja29.getText());
        numerosRespuestas[29] = control.verificaciónTextField(caja30.getText());

        control.resultadoResta(numerosAleatorios, numerosRespuestas, 30);

        double estimatedTime = System.currentTimeMillis() - startTime;
        control.tiempoResta(estimatedTime);

        Instrucciones instrucciones = Instrucciones.getSingletonInstance();
        instrucciones.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
            numerosRespuestas[0] = control.verificaciónTextField(caja1.getText());
            numerosRespuestas[1] = control.verificaciónTextField(caja2.getText());
            numerosRespuestas[2] = control.verificaciónTextField(caja3.getText());
            numerosRespuestas[3] = control.verificaciónTextField(caja4.getText());
            numerosRespuestas[4] = control.verificaciónTextField(caja5.getText());
            numerosRespuestas[5] = control.verificaciónTextField(caja6.getText());
            numerosRespuestas[6] = control.verificaciónTextField(caja7.getText());
            numerosRespuestas[7] = control.verificaciónTextField(caja8.getText());
            numerosRespuestas[8] = control.verificaciónTextField(caja9.getText());
            numerosRespuestas[9] = control.verificaciónTextField(caja10.getText());
            numerosRespuestas[10] = control.verificaciónTextField(caja11.getText());
            numerosRespuestas[11] = control.verificaciónTextField(caja12.getText());
            numerosRespuestas[12] = control.verificaciónTextField(caja13.getText());
            numerosRespuestas[13] = control.verificaciónTextField(caja14.getText());
            numerosRespuestas[14] = control.verificaciónTextField(caja15.getText());
            numerosRespuestas[15] = control.verificaciónTextField(caja16.getText());
            numerosRespuestas[16] = control.verificaciónTextField(caja17.getText());
            numerosRespuestas[17] = control.verificaciónTextField(caja18.getText());
            numerosRespuestas[18] = control.verificaciónTextField(caja19.getText());
            numerosRespuestas[19] = control.verificaciónTextField(caja20.getText());
            numerosRespuestas[20] = control.verificaciónTextField(caja21.getText());
            numerosRespuestas[21] = control.verificaciónTextField(caja22.getText());
            numerosRespuestas[22] = control.verificaciónTextField(caja23.getText());
            numerosRespuestas[23] = control.verificaciónTextField(caja24.getText());
            numerosRespuestas[24] = control.verificaciónTextField(caja25.getText());
            numerosRespuestas[25] = control.verificaciónTextField(caja26.getText());
            numerosRespuestas[26] = control.verificaciónTextField(caja27.getText());
            numerosRespuestas[27] = control.verificaciónTextField(caja28.getText());
            numerosRespuestas[28] = control.verificaciónTextField(caja29.getText());
            numerosRespuestas[29] = control.verificaciónTextField(caja30.getText());

            control.resultadoResta(numerosAleatorios, numerosRespuestas, 30);

            double estimatedTime = System.currentTimeMillis() - startTime;
            control.tiempoResta(estimatedTime);

            Instrucciones instrucciones = Instrucciones.getSingletonInstance();
            instrucciones.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void caja1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja1KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }// TODO add your handling code here:
    }//GEN-LAST:event_caja1KeyTyped

    private void caja2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja2KeyTyped

    private void caja3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja3KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja3KeyTyped

    private void caja4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja4KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja4KeyTyped

    private void caja5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja5KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja5KeyTyped

    private void caja6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja6KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja6KeyTyped

    private void caja7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja7KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_caja7KeyTyped

    private void caja8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja8KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja8KeyTyped

    private void caja9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja9KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja9KeyTyped

    private void caja10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja10KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja10KeyTyped

    private void caja11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja11KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja11KeyTyped

    private void caja12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja12KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }// TODO add your handling code here:
    }//GEN-LAST:event_caja12KeyTyped

    private void caja13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja13KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja13KeyTyped

    private void caja14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja14KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_caja14KeyTyped

    private void caja15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja15KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja15KeyTyped

    private void caja16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja16KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja16KeyTyped

    private void caja17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja17KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja17KeyTyped

    private void caja18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja18KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja18KeyTyped

    private void caja19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja19KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja19KeyTyped

    private void caja20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja20KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja20KeyTyped

    private void caja21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja21KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_caja21KeyTyped

    private void caja22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja22KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja22KeyTyped

    private void caja23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja23KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_caja23KeyTyped

    private void caja24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja24KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_caja24KeyTyped

    private void caja25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja25KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja25KeyTyped

    private void caja26KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja26KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_caja26KeyTyped

    private void caja27KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja27KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }       // TODO add your handling code here:
    }//GEN-LAST:event_caja27KeyTyped

    private void caja28KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja28KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_caja28KeyTyped

    private void caja29KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja29KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }      // TODO add your handling code here:
    }//GEN-LAST:event_caja29KeyTyped

    private void caja30KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja30KeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_caja30KeyTyped

    private void caja29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caja29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caja29ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caja1;
    private javax.swing.JTextField caja10;
    private javax.swing.JTextField caja11;
    private javax.swing.JTextField caja12;
    private javax.swing.JTextField caja13;
    private javax.swing.JTextField caja14;
    private javax.swing.JTextField caja15;
    private javax.swing.JTextField caja16;
    private javax.swing.JTextField caja17;
    private javax.swing.JTextField caja18;
    private javax.swing.JTextField caja19;
    private javax.swing.JTextField caja2;
    private javax.swing.JTextField caja20;
    private javax.swing.JTextField caja21;
    private javax.swing.JTextField caja22;
    private javax.swing.JTextField caja23;
    private javax.swing.JTextField caja24;
    private javax.swing.JTextField caja25;
    private javax.swing.JTextField caja26;
    private javax.swing.JTextField caja27;
    private javax.swing.JTextField caja28;
    private javax.swing.JTextField caja29;
    private javax.swing.JTextField caja3;
    private javax.swing.JTextField caja30;
    private javax.swing.JTextField caja4;
    private javax.swing.JTextField caja5;
    private javax.swing.JTextField caja6;
    private javax.swing.JTextField caja7;
    private javax.swing.JTextField caja8;
    private javax.swing.JTextField caja9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
