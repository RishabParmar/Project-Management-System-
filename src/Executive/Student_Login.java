/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executive;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parma
 */
public class Student_Login extends javax.swing.JFrame {

    /**
     * Creates new form Student_Login
     */
    public Student_Login() {
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

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        passwordst = new javax.swing.JPasswordField();
        usernamest = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(520, 30, 80, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(170, 228, 330, 2);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(270, 260, 130, 40);

        passwordst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        passwordst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordstActionPerformed(evt);
            }
        });
        jPanel2.add(passwordst);
        passwordst.setBounds(330, 170, 150, 30);

        usernamest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(usernamest);
        usernamest.setBounds(330, 100, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Password  :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(190, 170, 130, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Username :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(190, 90, 130, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Executive/HD-Wallpapers1_FOSmVKg.jpeg"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 650, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordstActionPerformed

    public static String uni, name, cs, cn, user, pass, uncheck;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        user = usernamest.getText();
        pass = passwordst.getText();

        if(user.length()==0 && pass.length()==0) 
        {
            JOptionPane.showMessageDialog(null, "The Username and Password field's are empty.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
        else if (user.length() == 0) {

            JOptionPane.showMessageDialog(null, "The Username field is empty.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        } else if (pass.length() == 0) {

            JOptionPane.showMessageDialog(null, "The Password field is empty.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error in JDBC");
            }

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?verifyServerCertificate=false&useSSL=true", "root", "rishab");
                PreparedStatement p = con.prepareStatement("select * from student where username=? and password=?");
                p.setString(1, user);
                p.setString(2, pass);
                ResultSet rs = p.executeQuery();
                if (rs.next()) {
                    usernamest.setText(" ");
                    passwordst.setText("");
                    uncheck = rs.getString(1);
                    uni = rs.getString(3);
                    name = rs.getString(4);
                    cs = rs.getString(5);
                    cn = rs.getString(6);

                    if (user.equals(uncheck)) {
                        setVisible(false);
                        Student_Page sp = new Student_Page();
                        sp.setVisible(true);
                        sp.chat();
                        sp.remarks();
                    } else {
                        
                        errormess();

                    }

                } else {
                    errormess();

                }

            } catch (SQLException ex) {
                System.err.println("Error in the Credentials");

            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    public void errormess() {
        JOptionPane.showMessageDialog(null, "The Username or Password entered is INCORRECT.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        usernamest.setText("");
        passwordst.setText("");
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        Pms p = new Pms();
        p.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        
         user = usernamest.getText();
        pass = passwordst.getText();

        if(user.length()==0 && pass.length()==0) 
        {
            JOptionPane.showMessageDialog(null, "The Username and Password field's are empty.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
        else if (user.length() == 0) {

            JOptionPane.showMessageDialog(null, "The Username field is empty.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        } else if (pass.length() == 0) {

            JOptionPane.showMessageDialog(null, "The Password field is empty.\n", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error in JDBC");
            }

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?verifyServerCertificate=false&useSSL=true", "root", "rishab");
                PreparedStatement p = con.prepareStatement("select * from student where username=? and password=?");
                p.setString(1, user);
                p.setString(2, pass);
                ResultSet rs = p.executeQuery();
                if (rs.next()) {
                    usernamest.setText(" ");
                    passwordst.setText("");
                    uncheck = rs.getString(1);
                    uni = rs.getString(3);
                    name = rs.getString(4);
                    cs = rs.getString(5);
                    cn = rs.getString(6);

                    if (user.equals(uncheck)) {
                        setVisible(false);
                        Student_Page sp = new Student_Page();
                        sp.setVisible(true);
                        sp.chat();
                        sp.remarks();
                    } else {
                        
                        errormess();

                    }

                } else {
                    errormess();

                }

            } catch (SQLException ex) {
                System.err.println("Error in the Credentials");

            }
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton1KeyTyped

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
            java.util.logging.Logger.getLogger(Student_Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passwordst;
    private javax.swing.JTextField usernamest;
    // End of variables declaration//GEN-END:variables
}
