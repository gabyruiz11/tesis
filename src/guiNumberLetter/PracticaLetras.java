/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiNumberLetter;

import controles.ControlNumberLetter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author David Hermosillo
 */
public class PracticaLetras extends javax.swing.JFrame {

    ControlNumberLetter control = ControlNumberLetter.getSingletonInstance();
    ArrayList<JLabel> etiquetas = new ArrayList<>();

    GridBagConstraints gbcRespuesta = new GridBagConstraints();
    GridBagConstraints gbcIzquierda = new GridBagConstraints();
    GridBagConstraints gbcDerecha = new GridBagConstraints();
    GridBagConstraints gbcPanel = new GridBagConstraints();

    /**
     * Creates new form PracticaNumeros
     */
    public PracticaLetras() {
        
//        //se cambia el tamaño del panel y el frame para que este a la resolucion de la pantalla
//        initComponents();
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension d = tk.getScreenSize();
//        this.setExtendedState(MAXIMIZED_BOTH);
//        etiquetaRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
//        gbcRespuesta.fill = GridBagConstraints.BOTH;
//        this.setSize((int) d.getWidth(), (int) d.getHeight());
//        panelPrincipal.setSize((int) d.getWidth(), (int) d.getHeight());
//        this.add(panelPrincipal, BorderLayout.CENTER);
//        //se centra el texPanel en el panel
//        panelPrincipal.setLayout(new GridBagLayout());
//        gbcRespuesta.anchor = GridBagConstraints.PAGE_START;
//        valorAIzquierdo.setHorizontalAlignment(SwingConstants.RIGHT);
//        valorBIzquierdo.setHorizontalAlignment(SwingConstants.RIGHT);
//        gbcRespuesta.gridx = 0;
//        gbcRespuesta.weighty = 0;
//        gbcRespuesta.gridwidth = 3;
//        gbcRespuesta.gridy = 0;
//        gbcRespuesta.weightx = 1;
////        gbcIzquierda.gridx = 1;
////        gbcIzquierda.gridy = 0;
////        gbcIzquierda.weightx = 1;
////        gbcIzquierda.weighty = 0;
//        gbcIzquierda.fill = GridBagConstraints.HORIZONTAL;
////        gbcRespuesta.gridx = 1;
////        gbcRespuesta.gridwidth = 2;
////        gbcRespuesta.gridy = 2;
//        gbcIzquierda.gridx = 0;
//        gbcIzquierda.gridwidth = 1;
//        gbcIzquierda.gridy = 2;
//        gbcPanel.fill = GridBagConstraints.BOTH;
//        gbcPanel.ipady = 250;      //make this component tall
//        gbcPanel.weightx = 0.0;
//        gbcPanel.gridwidth = 3;
//        gbcPanel.gridx = 0;
//        gbcPanel.gridy = 1;
//        gbcDerecha.fill = GridBagConstraints.HORIZONTAL;
//        gbcDerecha.gridx = 2;
//        gbcDerecha.gridwidth = 1;
//        gbcDerecha.gridy = 2;
//        panelPrincipal.add(panelIzquierdo, gbcIzquierda);
//        panelPrincipal.add(panelDerecho, gbcDerecha);
//        panelPrincipal.add(etiquetaRespuesta, gbcRespuesta);
//        panelPrincipal.add(jPanel1, gbcPanel);
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        this.setExtendedState(MAXIMIZED_BOTH);
        etiquetaRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
        gbcRespuesta.fill = GridBagConstraints.BOTH;
        this.setSize((int) d.getWidth(), (int) d.getHeight());
        panelPrincipal.setSize((int) d.getWidth(), (int) d.getHeight());
        this.add(panelPrincipal, BorderLayout.CENTER);
        //se centra el texPanel en el panel
        panelPrincipal.setLayout(new GridBagLayout());
        gbcRespuesta.anchor = GridBagConstraints.PAGE_START;
        valorAIzquierdo.setHorizontalAlignment(SwingConstants.RIGHT);
        valorBIzquierdo.setHorizontalAlignment(SwingConstants.RIGHT);
        gbcRespuesta.gridx = 0;
        gbcRespuesta.weighty = 0;
        gbcRespuesta.gridwidth = 2;
        gbcRespuesta.gridy = 0;
        gbcRespuesta.weightx = 1;
//        gbcIzquierda.gridx = 1;
//        gbcIzquierda.gridy = 0;
//        gbcIzquierda.weightx = 1;
//        gbcIzquierda.weighty = 0;
        gbcIzquierda.fill = GridBagConstraints.HORIZONTAL;
//        gbcRespuesta.gridx = 1;
//        gbcRespuesta.gridwidth = 2;
//        gbcRespuesta.gridy = 2;
        gbcIzquierda.gridx = 0;
        gbcIzquierda.gridwidth = 2;
        gbcIzquierda.gridy = 2;
        gbcIzquierda.weightx = 0;
        gbcIzquierda.weighty = 0;

        gbcPanel.fill = GridBagConstraints.BOTH;
        gbcPanel.ipady = 250;      //make this component tall
        gbcPanel.weightx = 0.0;
        gbcPanel.gridwidth = 3;
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;
        gbcDerecha.fill = GridBagConstraints.HORIZONTAL;

        gbcDerecha.weightx = 0;
        gbcDerecha.weighty = 0;
        gbcDerecha.gridx = 2;
        gbcDerecha.gridwidth = 1;
        gbcDerecha.gridy = 2;
        panelPrincipal.add(panelIzquierdo, gbcIzquierda);
        panelPrincipal.add(panelDerecho, gbcDerecha);
        //panelPrincipal.add(jLabel1, gbcRespuesta);
        panelPrincipal.add(jPanel1, gbcPanel);
        
        etiquetas.add(valorADerecho);
        etiquetas.add(valorBDerecho);
        etiquetas.add(valorAIzquierdo);
        etiquetas.add(valorBIzquierdo);
        control.setRepeticiones(5);
        
        panelPrincipal.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelDerecho = new javax.swing.JPanel();
        valorADerecho = new javax.swing.JLabel();
        valorBDerecho = new javax.swing.JLabel();
        panelIzquierdo = new javax.swing.JPanel();
        valorAIzquierdo = new javax.swing.JLabel();
        valorBIzquierdo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        etiquetaRespuesta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelPrincipalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                panelPrincipalKeyTyped(evt);
            }
        });

        panelDerecho.setBackground(new java.awt.Color(255, 255, 255));
        panelDerecho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        valorADerecho.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        valorBDerecho.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        javax.swing.GroupLayout panelDerechoLayout = new javax.swing.GroupLayout(panelDerecho);
        panelDerecho.setLayout(panelDerechoLayout);
        panelDerechoLayout.setHorizontalGroup(
            panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoLayout.createSequentialGroup()
                .addGap(0, 233, Short.MAX_VALUE)
                .addComponent(valorADerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorBDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDerechoLayout.setVerticalGroup(
            panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorBDerecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorADerecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelIzquierdo.setBackground(new java.awt.Color(255, 255, 255));
        panelIzquierdo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        valorAIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        valorBIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        javax.swing.GroupLayout panelIzquierdoLayout = new javax.swing.GroupLayout(panelIzquierdo);
        panelIzquierdo.setLayout(panelIzquierdoLayout);
        panelIzquierdoLayout.setHorizontalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoLayout.createSequentialGroup()
                .addComponent(valorAIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorBIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 246, Short.MAX_VALUE))
        );
        panelIzquierdoLayout.setVerticalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzquierdoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(valorBIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorAIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etiquetaRespuesta.setFont(new java.awt.Font("Tahoma", 0, 38)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(etiquetaRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(panelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelPrincipalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelPrincipalKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_panelPrincipalKeyTyped

    private void panelPrincipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelPrincipalKeyPressed
        // TODO add your handling code here:
        Color verde = Color.decode("#1A8803");
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_C:
                control.respuestaLetras("Consonante", control.recorrerListaLetras(etiquetas), etiquetaRespuesta);
                if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                    this.etiquetaRespuesta.setForeground(verde);
                } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                    this.etiquetaRespuesta.setForeground(Color.red);
                }
                break;
            case KeyEvent.VK_V:
                control.respuestaLetras("Vocal", control.recorrerListaLetras(etiquetas), etiquetaRespuesta);
                if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                    this.etiquetaRespuesta.setForeground(verde);
                } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                    this.etiquetaRespuesta.setForeground(Color.red);
                }
                break;
            case KeyEvent.VK_SPACE:
                control.setEtiquetaA(valorAIzquierdo);
                control.setEtiquetaB(valorBIzquierdo);
                control.setEtiquetaC(valorADerecho);
                control.setEtiquetaD(valorBDerecho);
                control.agregarVocalesConsonantes();
                control.setRepeticiones(5);
                control.practicaLetras();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_panelPrincipalKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PracticaLetras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PracticaLetras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PracticaLetras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PracticaLetras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PracticaLetras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaRespuesta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel valorADerecho;
    private javax.swing.JLabel valorAIzquierdo;
    private javax.swing.JLabel valorBDerecho;
    private javax.swing.JLabel valorBIzquierdo;
    // End of variables declaration//GEN-END:variables
}
