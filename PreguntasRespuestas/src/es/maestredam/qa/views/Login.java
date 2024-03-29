/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.maestredam.qa.views;

import es.maestredam.qa.model.GestorInfo;
import es.maestredam.qa.model.Usuario;
import es.maestredam.util.LinkedList;

/**
 *
 * @author Luismi
 */
public class Login extends javax.swing.JDialog {

    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsLogin = new javax.swing.JLabel();
        lblPaLogin = new javax.swing.JLabel();
        txtLoginUs = new javax.swing.JTextField();
        btnConfLogin = new javax.swing.JButton();
        lblIniciar = new javax.swing.JLabel();
        txtLoginPass = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblUsLogin.setText("Usuario");

        lblPaLogin.setText("Contraseña");

        btnConfLogin.setText("Confirmar");
        btnConfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfLoginActionPerformed(evt);
            }
        });

        lblIniciar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblIniciar.setText("INICIAR SESIÓN");

        lblError.setVisible(false);
        lblError.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        lblError.setText("El usuario no existe, pruebe a volver a esciribirlo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblIniciar)
                            .addGap(81, 81, 81))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblUsLogin)
                                .addComponent(lblPaLogin))
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLoginUs)
                                .addComponent(txtLoginPass, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addGap(56, 56, 56)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConfLogin)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblIniciar)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsLogin)
                    .addComponent(txtLoginUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaLogin)
                    .addComponent(txtLoginPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnConfLogin)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private Usuario user;
    
    private void btnConfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfLoginActionPerformed
        Usuario comparador = new Usuario(txtLoginUs.getText(),txtLoginPass.getText());
        GestorInfo gestor = new GestorInfo("usuarios.dam");
        LinkedList<Usuario> lista = gestor.cargarArchivo();
        boolean seguir = true;
        boolean encontrado = false;
        for (int i = 0; i < lista.size() && seguir; i++) {
            user=lista.get(i);
            if(user.getNombre().equals(comparador.getNombre()) && user.getClave().equals(comparador.getClave())){
                seguir = false;
                encontrado = true;
            }
        }
        
        if(encontrado == false){
            lblError.setVisible(true);
            txtLoginUs.setText("");
            txtLoginPass.setText("");
        }else{
            this.dispose();
        }
    }//GEN-LAST:event_btnConfLoginActionPerformed
    
    public Usuario getUser(){
        return user;
    }
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfLogin;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblIniciar;
    private javax.swing.JLabel lblPaLogin;
    private javax.swing.JLabel lblUsLogin;
    private javax.swing.JPasswordField txtLoginPass;
    private javax.swing.JTextField txtLoginUs;
    // End of variables declaration//GEN-END:variables
}
