/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jitca David
 */
public class credentialforgot extends javax.swing.JFrame {

    /**
     * Creates new form credentialforgot
     */
    public credentialforgot() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanelaLogo = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelMail = new javax.swing.JLabel();
        MailField = new javax.swing.JTextField();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        ResetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(208, 225, 249));
        jPanel1.setForeground(new java.awt.Color(77, 100, 141));
        jPanel1.setLayout(null);

        jPanelaLogo.setBackground(new java.awt.Color(40, 54, 85));

        jLabelName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("ChessGame by MasterMinds");

        javax.swing.GroupLayout jPanelaLogoLayout = new javax.swing.GroupLayout(jPanelaLogo);
        jPanelaLogo.setLayout(jPanelaLogoLayout);
        jPanelaLogoLayout.setHorizontalGroup(
            jPanelaLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelaLogoLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabelName)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanelaLogoLayout.setVerticalGroup(
            jPanelaLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelaLogoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabelName)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelaLogo);
        jPanelaLogo.setBounds(0, 30, 390, 80);

        jLabelMail.setBackground(new java.awt.Color(77, 100, 141));
        jLabelMail.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(40, 54, 85));
        jLabelMail.setText("Enter your email");
        jPanel1.add(jLabelMail);
        jLabelMail.setBounds(100, 150, 190, 16);

        MailField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        MailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailFieldActionPerformed(evt);
            }
        });
        jPanel1.add(MailField);
        MailField.setBounds(100, 170, 190, 40);

        jLabelMinimize.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(40, 54, 85));
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelMinimize);
        jLabelMinimize.setBounds(340, 0, 20, 20);

        jLabelClose.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(40, 54, 85));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelClose);
        jLabelClose.setBounds(370, 0, 20, 20);

        ResetButton.setBackground(new java.awt.Color(77, 100, 141));
        ResetButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(40, 54, 85));
        ResetButton.setText("Resetare Parola");
        ResetButton.setBorder(null);
        ResetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetButtonMouseClicked(evt);
            }
        });
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ResetButton);
        ResetButton.setBounds(120, 220, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MailFieldActionPerformed

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void ResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseClicked
        String mail;
        String codedMessage = new String();
        String mesajServer = new String();
        if(MailField.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "You forgot enter your email!",
                "Name", JOptionPane.CLOSED_OPTION);
        }
        else
        {
            mail = MailField.getText();
            codedMessage=codedMessage.concat("3;;;");
            codedMessage=codedMessage.concat(mail);
            client.send(codedMessage);
            mesajServer = client.read();

            //aici ai mesajul de la server
            //daca codul e 0, atunci nu s-a reusit logarea
            //daca codul e 1, atunci s-a reusit logarea
            System.out.println(mesajServer);
            int cod=Integer.parseInt(mesajServer.substring(0,1));
            mesajServer=mesajServer.substring(2);
            switch (cod) {
                case 0:{
                    JOptionPane.showMessageDialog(null, mesajServer,"Eroare", JOptionPane.CLOSED_OPTION);
                    MailField.setText(null);
                    break;
                }
                case 1:{
                    JOptionPane.showMessageDialog(null, mesajServer,"OK", JOptionPane.CLOSED_OPTION);
                    this.dispose();
                    break;
                }
                default:
                break;
            }

        }
    }//GEN-LAST:event_ResetButtonMouseClicked

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed

    }//GEN-LAST:event_ResetButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void mainn() {
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
            java.util.logging.Logger.getLogger(credentialforgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(credentialforgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(credentialforgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(credentialforgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new credentialforgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MailField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelaLogo;
    // End of variables declaration//GEN-END:variables
}
