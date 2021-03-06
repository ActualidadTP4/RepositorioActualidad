/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Excepciones.UsuarioException;
import Modelos.Servidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fer
 */
public class InicioSesion extends javax.swing.JPanel {

    /**
     * Creates new form InicioSesion
     */
    Servidor unServidor;
    Principal unPrincipal;
    public InicioSesion(Servidor server, Principal unp) {
        this.unServidor=(Servidor)server;
        this.unPrincipal=(Principal) unp;
        initComponents();
        this.lblErrorContraseña.setVisible(false);
        this.lblErrorUser.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        checkRecordarme = new javax.swing.JCheckBox();
        btnIniciarSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblOlvidado = new javax.swing.JLabel();
        lblErrorUser = new javax.swing.JLabel();
        lblErrorContraseña = new javax.swing.JLabel();

        checkRecordarme.setBackground(new java.awt.Color(255, 255, 255));
        checkRecordarme.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        checkRecordarme.setText("¿Recordarme?");

        btnIniciarSesion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblUsuario.setText("Usuario");

        lblContraseña.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblContraseña.setText("Contraseña");

        lblOlvidado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblOlvidado.setText("¿Has olvidado tu contraseña?");

        lblErrorUser.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblErrorUser.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorUser.setText("Ingrese nombre de usuario!");

        lblErrorContraseña.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblErrorContraseña.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorContraseña.setText("Ingrese contraseña!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorContraseña)
                    .addComponent(lblOlvidado)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIniciarSesion)
                            .addComponent(checkRecordarme, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorUser)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblErrorUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblErrorContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkRecordarme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOlvidado)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
            this.lblErrorContraseña.setVisible(false);
            this.lblErrorUser.setVisible(false);       
            String nombre, contraseña;
            nombre= this.txtUsuario.getText();
            contraseña=this.txtContraseña.getText();

            if(nombre.length()>0 && contraseña.length()>0){
                try {
                    this.unPrincipal.iniciarSesion(this.unServidor.iniciarSesion(nombre, contraseña));
                    Preguntas pnlPreguntas= new Preguntas(this.unPrincipal, this.unPrincipal.getUser() ,this.unServidor);
                    this.unPrincipal.devolverScroll().setViewportView(pnlPreguntas);
                } catch (UsuarioException ex) {
                    JOptionPane.showMessageDialog(this,ex);
                    this.txtContraseña.setText("");
                    this.txtUsuario.setText("");
                }
            

            }else if(nombre.length()==0){
                this.lblErrorUser.setVisible(true);
            }else if(contraseña.length()==0){
                this.lblErrorContraseña.setVisible(true);
            }
            
    }//GEN-LAST:event_btnIniciarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JCheckBox checkRecordarme;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblErrorContraseña;
    private javax.swing.JLabel lblErrorUser;
    private javax.swing.JLabel lblOlvidado;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
