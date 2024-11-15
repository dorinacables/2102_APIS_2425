package com.classes;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Elmer Reyes
 */
public class MenuDashboard extends javax.swing.JFrame {
    String username;
    String userSelect;
    Users users;
    String userType;   
    String fullname;
    LocalDateTime outTime;

    /**
     * Creates new form MenuDashboard
     */
    public MenuDashboard(String username, String userType, Users users) {
        initComponents();
        
        pnlNavigate.setVisible(false);
        pnlMenu.setVisible(true);
        
        
        this.username = username;
        userSelect = userType;
        this.users = users;
        if("EMPLOYEE".equalsIgnoreCase(userType))
            notForEmployee();
        currentUserSession();
                                       
    }
        
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavigate = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnCurrentStocks = new javax.swing.JButton();
        btnsSuppliers = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnUserLogs = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlWelcome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory System");

        pnlNavigate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnHome.setText("Home");

        btnProducts.setText("Products");
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnCurrentStocks.setText("Current Stocks");
        btnCurrentStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentStocksActionPerformed(evt);
            }
        });

        btnsSuppliers.setText("Suppliers");
        btnsSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsSuppliersActionPerformed(evt);
            }
        });

        btnUsers.setText("Users");
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnUserLogs.setText("User Logs");
        btnUserLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserLogsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavigateLayout = new javax.swing.GroupLayout(pnlNavigate);
        pnlNavigate.setLayout(pnlNavigateLayout);
        pnlNavigateLayout.setHorizontalGroup(
            pnlNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavigateLayout.createSequentialGroup()
                .addGroup(pnlNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNavigateLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(pnlNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUserLogs)
                            .addGroup(pnlNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUsers)
                                .addComponent(btnsSuppliers))))
                    .addGroup(pnlNavigateLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(pnlNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnProducts)
                            .addComponent(btnHome)))
                    .addGroup(pnlNavigateLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnCurrentStocks)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pnlNavigateLayout.setVerticalGroup(
            pnlNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavigateLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnHome)
                .addGap(69, 69, 69)
                .addComponent(btnProducts)
                .addGap(67, 67, 67)
                .addComponent(btnCurrentStocks)
                .addGap(73, 73, 73)
                .addComponent(btnsSuppliers)
                .addGap(74, 74, 74)
                .addComponent(btnUsers)
                .addGap(82, 82, 82)
                .addComponent(btnUserLogs)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(23, 23, 23))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        lblUsername.setText("User: ");

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(lblUsername))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnlWelcome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlWelcome.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pnlNavigate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 785, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(pnlNavigate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnlWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
         pnlNavigate.setVisible(!pnlNavigate.isVisible());
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        // TODO add your handling code here:
        new Products_Page(username).setVisible(true);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to logout? You will have to login again.","Confirmation",JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION){
            outTime = LocalDateTime.now();
            users.setOutTime(String.valueOf(outTime));
            users.setUsername(username);
            new UsersDAO().addUserLogin(users);
            dispose();
            Log_In loginPage = new Log_In();
            loginPage.setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed
    }     
    private void btnCurrentStocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrentStocksActionPerformed
        // TODO add your handling code here:
         new CurrentStocks_Page().setVisible(true);
    }//GEN-LAST:event_btnCurrentStocksActionPerformed

    private void btnsSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsSuppliersActionPerformed
        // TODO add your handling code here:
        new Suppliers_Page().setVisible(true);
    }//GEN-LAST:event_btnsSuppliersActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        // TODO add your handling code here:
        new Users_Page().setVisible(true);
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnUserLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserLogsActionPerformed
        // TODO add your handling code here:
        new UserLogs_Page().setVisible(true);
    }//GEN-LAST:event_btnUserLogsActionPerformed
    
     public void currentUserSession() {
        Users users = new Users(username, userSelect);
        new UsersDAO().getFullName(users, username);
        lblUsername.setText("User: " + users.getFullName() + " ("+userSelect+")");
    }
     public void notForEmployee(){
        pnlNavigate.remove(btnUsers);
        
        //navPanel.remove(salesButton);
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
            java.util.logging.Logger.getLogger(MenuDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_In().setVisible(true);
            }
        });
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCurrentStocks;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnUserLogs;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnsSuppliers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNavigate;
    private javax.swing.JPanel pnlWelcome;
    // End of variables declaration//GEN-END:variables

}