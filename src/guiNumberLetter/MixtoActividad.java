/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiNumberLetter;

import controles.ControlNumberLetter;
import java.awt.BorderLayout;
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
public class MixtoActividad extends javax.swing.JFrame {

    ControlNumberLetter control = ControlNumberLetter.getSingletonInstance();
    ArrayList<JLabel> etiquetas = new ArrayList<>();
    int contador = 0;

    GridBagConstraints gbcRespuesta = new GridBagConstraints();
    GridBagConstraints gbcIzquierda = new GridBagConstraints();
    GridBagConstraints gbcDerecha = new GridBagConstraints();
    GridBagConstraints gbcInferiorIzquierda = new GridBagConstraints();
    GridBagConstraints gbcInferiorDerecha = new GridBagConstraints();
    GridBagConstraints gbcPanel = new GridBagConstraints();

    /**
     * Creates new form PracticaNumeros
     */
    public MixtoActividad() {
        initComponents();
        //se cambia el tamaño del panel y el frame para que este a la resolucion de la pantalla
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        this.setExtendedState(MAXIMIZED_BOTH);
        etiquetaRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
        this.setSize((int) d.getWidth(), (int) d.getHeight());
        panelPrincipal.setSize((int) d.getWidth(), (int) d.getHeight());
        this.add(panelPrincipal, BorderLayout.CENTER);
        //se centra el texPanel en el panel
        panelPrincipal.setLayout(new GridBagLayout());
        /**
         * alineacion de texto en jlabel
         */
        valorAInferiorDerecho.setHorizontalAlignment(SwingConstants.RIGHT);
        valorAInferiorIzquierdo.setHorizontalAlignment(SwingConstants.RIGHT);
        valorASuperiorDerecho.setHorizontalAlignment(SwingConstants.RIGHT);
        valorASuperiorIzquierdo.setHorizontalAlignment(SwingConstants.RIGHT);
        valorBInferiorDerecho.setHorizontalAlignment(SwingConstants.LEFT);
        valorBInferiorIzquierdo.setHorizontalAlignment(SwingConstants.LEFT);
        valorBSuperiorDerecho.setHorizontalAlignment(SwingConstants.LEFT);
        valorBSuperiorIzquierdo.setHorizontalAlignment(SwingConstants.LEFT);
        
        /**
         * Grid superior izquierda
         */
        gbcIzquierda.fill = GridBagConstraints.HORIZONTAL;
        gbcIzquierda.gridwidth=1;
        gbcIzquierda.gridx = 0;
        gbcIzquierda.gridy = 0;
        gbcIzquierda.weightx = 0;
        gbcIzquierda.weighty = 0;
        /**
         * Grid superiro derecha 
         */
        gbcDerecha.fill = GridBagConstraints.HORIZONTAL;
        gbcDerecha.gridwidth=1;
        gbcDerecha.weightx = 0;
        gbcDerecha.weighty = 0;
        gbcDerecha.gridx = 2;
        gbcDerecha.gridy = 0;
        /**
         * Grid Inferior izquierdo
         */
        gbcInferiorIzquierda.fill = GridBagConstraints.HORIZONTAL;
        gbcInferiorIzquierda.gridx = 0;
        gbcInferiorIzquierda.gridwidth = 1;
        gbcInferiorIzquierda.gridy = 2;
        gbcIzquierda.weightx = 0;
        gbcIzquierda.weighty = 0;
        /**
         * Grid Inferiro derecho
         */
        gbcInferiorDerecha.fill = GridBagConstraints.HORIZONTAL;
        gbcDerecha.weightx = 0;
        gbcDerecha.weighty = 0;
        gbcInferiorDerecha.gridx = 2;
        gbcInferiorDerecha.gridwidth = 1;
        gbcInferiorDerecha.gridy = 2;
        
        /**
         * Grid de invisible 
         */
        gbcPanel.fill = GridBagConstraints.BOTH;
        gbcPanel.ipady = 250;      
        gbcPanel.weightx = 0.0;
        gbcPanel.gridwidth = 3;
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;
        //etiquetaRespuesta.setHorizontalTextPosition(SwingConstants.CENTER);
        etiquetaRespuesta.setVisible(false);
        
        panelPrincipal.add(panelSuperiorIzquierdo, gbcIzquierda);
        panelPrincipal.add(panelInferiorIzquierdo, gbcInferiorIzquierda);
        panelPrincipal.add(panelInferiorDerecho, gbcInferiorDerecha);
        panelPrincipal.add(panelSuperiorDerecho, gbcDerecha);
        panelPrincipal.add(jPanel1, gbcPanel);

        etiquetas.add(valorASuperiorIzquierdo);
        etiquetas.add(valorBSuperiorIzquierdo);

        etiquetas.add(valorASuperiorDerecho);
        etiquetas.add(valorBSuperiorDerecho);

        etiquetas.add(valorAInferiorDerecho);
        etiquetas.add(valorBInferiorDerecho);

        etiquetas.add(valorAInferiorIzquierdo);
        etiquetas.add(valorBInferiorIzquierdo);

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
        panelSuperiorDerecho = new javax.swing.JPanel();
        valorASuperiorDerecho = new javax.swing.JLabel();
        valorBSuperiorDerecho = new javax.swing.JLabel();
        panelInferiorIzquierdo = new javax.swing.JPanel();
        valorAInferiorIzquierdo = new javax.swing.JLabel();
        valorBInferiorIzquierdo = new javax.swing.JLabel();
        panelSuperiorIzquierdo = new javax.swing.JPanel();
        valorASuperiorIzquierdo = new javax.swing.JLabel();
        valorBSuperiorIzquierdo = new javax.swing.JLabel();
        panelInferiorDerecho = new javax.swing.JPanel();
        valorAInferiorDerecho = new javax.swing.JLabel();
        valorBInferiorDerecho = new javax.swing.JLabel();
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

        panelSuperiorDerecho.setBackground(new java.awt.Color(255, 255, 255));

        valorASuperiorDerecho.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        valorBSuperiorDerecho.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        javax.swing.GroupLayout panelSuperiorDerechoLayout = new javax.swing.GroupLayout(panelSuperiorDerecho);
        panelSuperiorDerecho.setLayout(panelSuperiorDerechoLayout);
        panelSuperiorDerechoLayout.setHorizontalGroup(
            panelSuperiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorDerechoLayout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(valorASuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(valorBSuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSuperiorDerechoLayout.setVerticalGroup(
            panelSuperiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorDerechoLayout.createSequentialGroup()
                .addGroup(panelSuperiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorASuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBSuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        panelInferiorIzquierdo.setBackground(new java.awt.Color(255, 255, 255));

        valorAInferiorIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        valorBInferiorIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        javax.swing.GroupLayout panelInferiorIzquierdoLayout = new javax.swing.GroupLayout(panelInferiorIzquierdo);
        panelInferiorIzquierdo.setLayout(panelInferiorIzquierdoLayout);
        panelInferiorIzquierdoLayout.setHorizontalGroup(
            panelInferiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorIzquierdoLayout.createSequentialGroup()
                .addComponent(valorAInferiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(valorBInferiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 132, Short.MAX_VALUE))
        );
        panelInferiorIzquierdoLayout.setVerticalGroup(
            panelInferiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorIzquierdoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelInferiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorAInferiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBInferiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelSuperiorIzquierdo.setBackground(new java.awt.Color(255, 255, 255));

        valorASuperiorIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        valorBSuperiorIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        javax.swing.GroupLayout panelSuperiorIzquierdoLayout = new javax.swing.GroupLayout(panelSuperiorIzquierdo);
        panelSuperiorIzquierdo.setLayout(panelSuperiorIzquierdoLayout);
        panelSuperiorIzquierdoLayout.setHorizontalGroup(
            panelSuperiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorIzquierdoLayout.createSequentialGroup()
                .addComponent(valorASuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(valorBSuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );
        panelSuperiorIzquierdoLayout.setVerticalGroup(
            panelSuperiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorIzquierdoLayout.createSequentialGroup()
                .addGroup(panelSuperiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorBSuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorASuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 66, Short.MAX_VALUE))
        );

        panelInferiorDerecho.setBackground(new java.awt.Color(255, 255, 255));

        valorAInferiorDerecho.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        valorBInferiorDerecho.setFont(new java.awt.Font("Tahoma", 1, 43)); // NOI18N

        javax.swing.GroupLayout panelInferiorDerechoLayout = new javax.swing.GroupLayout(panelInferiorDerecho);
        panelInferiorDerecho.setLayout(panelInferiorDerechoLayout);
        panelInferiorDerechoLayout.setHorizontalGroup(
            panelInferiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorDerechoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(valorAInferiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(valorBInferiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelInferiorDerechoLayout.setVerticalGroup(
            panelInferiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorDerechoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelInferiorDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(valorBInferiorDerecho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorAInferiorDerecho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        etiquetaRespuesta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        etiquetaRespuesta.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(712, Short.MAX_VALUE)
                .addComponent(etiquetaRespuesta)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaRespuesta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelInferiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelSuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelSuperiorDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInferiorDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSuperiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSuperiorDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelInferiorDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(panelInferiorIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        switch (evt.getKeyChar()) {
            case KeyEvent.VK_N:
                //control.respuestaNumeros("par", control.recorrerListaNumeros(etiquetas), etiquetaRespuesta);
                control.setEtiquetaRespuesta(etiquetaRespuesta);
                control.respuestaMixtos(1, true);
                break;
            case KeyEvent.VK_M:
                //control.respuestaNumeros("impar", control.recorrerListaNumeros(etiquetas), etiquetaRespuesta);
                control.setEtiquetaRespuesta(etiquetaRespuesta);
                control.respuestaMixtos(2, true);
                break;
            case KeyEvent.VK_C:
                //control.respuestaLetras("Consonante", control.recorrerListaLetras(etiquetas), etiquetaRespuesta);
                control.setEtiquetaRespuesta(etiquetaRespuesta);
                control.respuestaMixtos(3, true);
                break;
            case KeyEvent.VK_V:
                //control.respuestaLetras("Vocal", control.recorrerListaLetras(etiquetas), etiquetaRespuesta);
                control.setEtiquetaRespuesta(etiquetaRespuesta);
                control.respuestaMixtos(4, true);
                break;
            case KeyEvent.VK_SPACE:
                
                if (contador == 0) {
                    control.setEtiquetaA(valorASuperiorIzquierdo);
                    control.setEtiquetaB(valorBSuperiorIzquierdo);
                    control.setEtiquetaC(valorASuperiorDerecho);
                    control.setEtiquetaD(valorBSuperiorDerecho);
                    control.setEtiquetaE(valorAInferiorDerecho);
                    control.setEtiquetaF(valorBInferiorDerecho);
                    control.setEtiquetaG(valorAInferiorIzquierdo);
                    control.setEtiquetaH(valorBInferiorIzquierdo);

                    control.setEtiquetaRespuesta(etiquetaRespuesta);
                    control.agregarVocalesConsonantes();
                    control.setRepeticiones(32);
                    control.actividadMixto();
                    contador++;
                }
                
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
            java.util.logging.Logger.getLogger(MixtoActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MixtoActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MixtoActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MixtoActividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MixtoActividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaRespuesta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelInferiorDerecho;
    private javax.swing.JPanel panelInferiorIzquierdo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSuperiorDerecho;
    private javax.swing.JPanel panelSuperiorIzquierdo;
    private javax.swing.JLabel valorAInferiorDerecho;
    private javax.swing.JLabel valorAInferiorIzquierdo;
    private javax.swing.JLabel valorASuperiorDerecho;
    private javax.swing.JLabel valorASuperiorIzquierdo;
    private javax.swing.JLabel valorBInferiorDerecho;
    private javax.swing.JLabel valorBInferiorIzquierdo;
    private javax.swing.JLabel valorBSuperiorDerecho;
    private javax.swing.JLabel valorBSuperiorIzquierdo;
    // End of variables declaration//GEN-END:variables
}
