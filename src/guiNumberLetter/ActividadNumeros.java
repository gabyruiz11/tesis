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
public class ActividadNumeros extends javax.swing.JFrame {
    
    ControlNumberLetter control = ControlNumberLetter.getSingletonInstance();
    ArrayList<JLabel> etiquetas = new ArrayList<>();
    
    GridBagConstraints gbcRespuesta = new GridBagConstraints();
    GridBagConstraints gbcIzquierda = new GridBagConstraints();
    GridBagConstraints gbcDerecha = new GridBagConstraints();
    GridBagConstraints gbcPanel = new GridBagConstraints();
    /**
     * Creates new form PracticaNumeros
     */
    public ActividadNumeros() {
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
        gbcRespuesta.anchor = GridBagConstraints.CENTER;
        gbcRespuesta.fill = GridBagConstraints.BOTH;
        valorAIzquierdo.setHorizontalAlignment(SwingConstants.LEFT);
        valorBIzquierdo.setHorizontalAlignment(SwingConstants.LEFT);
        gbcRespuesta.gridx = 1;
        gbcRespuesta.gridwidth = 2;
        gbcRespuesta.gridy = 2;
        gbcIzquierda.fill = GridBagConstraints.HORIZONTAL;
        gbcIzquierda.gridx = 1;
        gbcIzquierda.gridy = 0;
        gbcIzquierda.weightx = 1;
        gbcIzquierda.weighty = 0;
        gbcPanel.fill = GridBagConstraints.BOTH;
        gbcPanel.ipady = 300;      //make this component tall
        gbcPanel.weightx = 0.0;
        gbcPanel.gridwidth = 3;
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;
        gbcDerecha.fill = GridBagConstraints.HORIZONTAL;
        gbcDerecha.weightx = 1;
        gbcDerecha.weighty = 0;
        gbcDerecha.gridx = 2;
        gbcDerecha.gridy = 0;
        panelPrincipal.add(panelIzquierdo, gbcIzquierda);
        panelPrincipal.add(panelDerecho, gbcDerecha);
        panelPrincipal.add(etiquetaRespuesta, gbcRespuesta);
        panelPrincipal.add(jPanel1, gbcPanel);
        etiquetas.add(valorADerecho);
        etiquetas.add(valorBDerecho);
        etiquetas.add(valorAIzquierdo);
        etiquetas.add(valorBIzquierdo);
        etiquetaRespuesta.setVisible(false);
        
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
        etiquetaRespuesta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

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

        valorADerecho.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        valorBDerecho.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        javax.swing.GroupLayout panelDerechoLayout = new javax.swing.GroupLayout(panelDerecho);
        panelDerecho.setLayout(panelDerechoLayout);
        panelDerechoLayout.setHorizontalGroup(
            panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(valorADerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorBDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        panelDerechoLayout.setVerticalGroup(
            panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechoLayout.createSequentialGroup()
                .addGroup(panelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorBDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorADerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        panelIzquierdo.setBackground(new java.awt.Color(255, 255, 255));

        valorAIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        valorBIzquierdo.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N

        javax.swing.GroupLayout panelIzquierdoLayout = new javax.swing.GroupLayout(panelIzquierdo);
        panelIzquierdo.setLayout(panelIzquierdoLayout);
        panelIzquierdoLayout.setHorizontalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(valorAIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorBIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        panelIzquierdoLayout.setVerticalGroup(
            panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdoLayout.createSequentialGroup()
                .addGroup(panelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorAIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        etiquetaRespuesta.setFont(new java.awt.Font("Tahoma", 0, 38)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(etiquetaRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(panelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(etiquetaRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

            case KeyEvent.VK_N:
                control.respuestaNumeros("par", control.recorrerListaNumeros(etiquetas), etiquetaRespuesta);
                if (this.etiquetaRespuesta.getText().equals("Correcto")) {
                    this.etiquetaRespuesta.setForeground(verde);
                } else if (this.etiquetaRespuesta.getText().equals("Incorrecto")) {
                    this.etiquetaRespuesta.setForeground(Color.red);
                }
                break;
            case KeyEvent.VK_M:
                control.respuestaNumeros("impar", control.recorrerListaNumeros(etiquetas), etiquetaRespuesta);
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
                control.setRepeticiones(16);
                control.actividadNumeros();
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
            java.util.logging.Logger.getLogger(ActividadNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActividadNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActividadNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActividadNumeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActividadNumeros().setVisible(true);
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
