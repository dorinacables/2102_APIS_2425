package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.classes.UsersDAO;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class Users_Page extends javax.swing.JFrame {
    /**
     * Creates new form Users_Page
     */
    public Users_Page() {
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("UserID");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("User Type");
        model.addColumn("Location");
        model.addColumn("Phone");
        model.addColumn("Full Name");
        tblUsers.setModel(model);
        loadUsersToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblFullNameU = new javax.swing.JLabel();
        txtFullNameU = new javax.swing.JTextField();
        lblLocationU = new javax.swing.JLabel();
        txtLocationU = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtContactNumberU = new javax.swing.JTextField();
        lblUsernameU = new javax.swing.JLabel();
        txtUsernameU = new javax.swing.JTextField();
        lblPasswordU = new javax.swing.JLabel();
        txtPasswordU = new javax.swing.JTextField();
        cmbbxUsertype = new javax.swing.JComboBox<>();
        btnAddU = new javax.swing.JButton();
        btnDeleteU = new javax.swing.JButton();
        btnEditU = new javax.swing.JButton();
        btnClearU = new javax.swing.JButton();
        btnCloseU = new javax.swing.JButton();
        lblUsersTitle = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        lblSearchU = new javax.swing.JLabel();
        txtSearchU = new javax.swing.JTextField();
        btnGoU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Username", "Password", "User Type", "Location", "Contact Number", "Full Name"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblFullNameU.setText("Full Name:");

        lblLocationU.setText("Location:");

        jLabel1.setText("Contact Number:");

        lblUsernameU.setText("Username:");

        lblPasswordU.setText("Password:");

        cmbbxUsertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Employee" }));

        btnAddU.setText("Add");
        btnAddU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUActionPerformed(evt);
            }
        });

        btnDeleteU.setText("Delete");
        btnDeleteU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUActionPerformed(evt);
            }
        });

        btnEditU.setText("Edit");
        btnEditU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUActionPerformed(evt);
            }
        });

        btnClearU.setText("Clear");
        btnClearU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearUActionPerformed(evt);
            }
        });

        btnCloseU.setText("Close");
        btnCloseU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(cmbbxUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddU)
                                .addGap(33, 33, 33)
                                .addComponent(btnDeleteU)
                                .addGap(48, 48, 48)
                                .addComponent(btnEditU)
                                .addGap(48, 48, 48)
                                .addComponent(btnClearU))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFullNameU, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFullNameU)
                                .addComponent(lblLocationU, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLocationU)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContactNumberU)
                                .addComponent(lblUsernameU, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUsernameU)
                                .addComponent(lblPasswordU, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPasswordU, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCloseU)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblFullNameU)
                .addGap(18, 18, 18)
                .addComponent(txtFullNameU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblLocationU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLocationU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContactNumberU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblUsernameU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsernameU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblPasswordU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cmbbxUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddU)
                            .addComponent(btnDeleteU)
                            .addComponent(btnEditU))
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearU)
                        .addGap(42, 42, 42)
                        .addComponent(btnCloseU)
                        .addGap(28, 28, 28))))
        );

        lblUsersTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsersTitle.setText("Users");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblSearchU.setText("Search:");

        btnGoU.setText("Go");
        btnGoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblUsersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearchU, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchU, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoU, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnRefresh)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsersTitle)
                    .addComponent(btnRefresh)
                    .addComponent(lblSearchU)
                    .addComponent(txtSearchU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoU))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    String userType;
    private void btnAddUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUActionPerformed
        // TODO add your handling code here:
    String username = txtUsernameU.getText();
    String password = txtPasswordU.getText();
    String userType = cmbbxUsertype.getSelectedItem().toString(); 
    String location = txtLocationU.getText();
    String phone = txtContactNumberU.getText();
    String fullname = txtFullNameU.getText();

    // Validate input 
    if (username.isEmpty() || password.isEmpty() || userType.isEmpty() || location.isEmpty() || phone.isEmpty() || fullname.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!");
        return; // Exit the method if any field is empty
    }

    // SQL query to insert data into the 'users' table
    String query = "INSERT INTO users (username, password, userType, location, phone, fullname) VALUES (?, ?, ?, ?, ?, ?)";

    // Try with resources (auto-close connections)
    try (Connection conn = new DBConnector().getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        // Set parameters for the prepared statement
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, userType);
        pstmt.setString(4, location);
        pstmt.setString(5, phone);
        pstmt.setString(6, fullname);

        // Execute the insert statement
        pstmt.executeUpdate();

        // Show success message
        JOptionPane.showMessageDialog(null, "User added successfully!");

        // Clear the form after submission 
        txtUsernameU.setText("");
        txtPasswordU.setText("");
        cmbbxUsertype.setSelectedIndex(0); // Reset combo box to default
        txtLocationU.setText("");
        txtContactNumberU.setText("");
        txtFullNameU.setText("");
    } catch (SQLException e) {
        // Handle database errors
        System.err.println("Error inserting user: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error adding user. Please try again.");
    }

    }//GEN-LAST:event_btnAddUActionPerformed

    private void btnDeleteUActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
          int selectedRow = tblUsers.getSelectedRow(); // Get the selected row index
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch the username from the selected row 
    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    String username = model.getValueAt(selectedRow, 0).toString();

    // Confirmation dialog
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete the user '" + username + "'?", 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Proceed with deletion if "Yes" is selected
        UsersDAO usersDAO = new UsersDAO();
        boolean isDeleted = usersDAO.deleteUserDAO(username);

        if (isDeleted) {
            // Remove the row from the GUI table
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "User '" + username + "' deleted successfully.");
        } else {
            // Error message if deletion fails
            JOptionPane.showMessageDialog(this, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // If "No" is selected, show a cancellation message or do nothing
        JOptionPane.showMessageDialog(this, "Deletion cancelled.");
    }
}
                     
    private void btnEditUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblUsers.getSelectedRow();
    
    if (selectedRow != -1) {
        int userID = (int) tblUsers.getValueAt(selectedRow, 0);
        String username = txtUsernameU.getText();
        String password = txtPasswordU.getText();
        String userType = (String) cmbbxUsertype.getSelectedItem();  
        String location = txtLocationU.getText();
        String phone = txtContactNumberU.getText();
        String fullname = txtFullNameU.getText();

        String updateQuery = "UPDATE users SET username = ?, password = ?, userType = ?, location = ?, phone = ?, fullname = ? WHERE userID = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pst = conn.prepareStatement(updateQuery)) {

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, userType);
            pst.setString(4, location);
            pst.setString(5, phone);
            pst.setString(6, fullname);
            pst.setInt(7, userID);

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully!");
                loadUsersToTable(); // Refresh the table after update
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "No user selected for editing.");
    }

    }//GEN-LAST:event_btnEditUActionPerformed

    private void btnClearUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearUActionPerformed
        // TODO add your handling code here:
        txtFullNameU.setText("");
        txtLocationU.setText("");
        txtContactNumberU.setText("");
        txtUsernameU.setText("");
        txtPasswordU.setText("");
        txtSearchU.setText("");
    }//GEN-LAST:event_btnClearUActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
         loadUsersToTable(); 
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnGoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoUActionPerformed
        // TODO add your handling code here:
          String searchQuery = txtSearchU.getText().trim();

    // Check if the search field is empty
    if (!searchQuery.isEmpty()) {
        // Perform search
        searchUsers(searchQuery);
    } else {
        JOptionPane.showMessageDialog(null, "Please enter a search term.");
        }
    }
    private void searchUsers(String searchQuery) {
    DefaultTableModel tableModel = (DefaultTableModel) tblUsers.getModel();
    // Clear the existing data in the table
    tableModel.setRowCount(0);

    
    String searchSQL = "SELECT userID, username, password, userType, location, phone, fullname " +
                       "FROM users " +
                       "WHERE username LIKE ? OR userType LIKE ? OR location LIKE ? OR phone LIKE ? OR fullname LIKE ? OR password LIKE ?";

    try (Connection conn = DBConnector.getConnection();
         PreparedStatement pst = conn.prepareStatement(searchSQL)) {
        
        String searchPattern = "%" + searchQuery + "%";  // "%" for partial matches

        // Set search parameters
        pst.setString(1, searchPattern);
        pst.setString(2, searchPattern);
        pst.setString(3, searchPattern);
        pst.setString(4, searchPattern);
        pst.setString(5, searchPattern);
        pst.setString(6, searchPattern); 

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            // Retrieve data from the result set
            int userId = rs.getInt("userID");
            String username = rs.getString("username");
            String password = rs.getString("password"); 
            String usertype = rs.getString("usertype");
            String location = rs.getString("location");
            String phone = rs.getString("phone");
            String fullname = rs.getString("fullname");

            // Add the result to the table in the correct column order
            tableModel.addRow(new Object[]{userId, username, password, usertype, location, phone, fullname});
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error while searching for users: " + e.getMessage());
    }
        
    }//GEN-LAST:event_btnGoUActionPerformed

    private void btnCloseUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseUActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseUActionPerformed
    String username;
    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
          int selectedRow = tblUsers.getSelectedRow();
    
    if (selectedRow != -1) {
        // Get values from the selected row
        int userID = (int) tblUsers.getValueAt(selectedRow, 0);
        String username = (String) tblUsers.getValueAt(selectedRow, 1);
        String password = (String) tblUsers.getValueAt(selectedRow, 2);
        String userType = (String) tblUsers.getValueAt(selectedRow, 3);
        String location = (String) tblUsers.getValueAt(selectedRow, 4);
        String phone = (String) tblUsers.getValueAt(selectedRow, 5);
        String fullname = (String) tblUsers.getValueAt(selectedRow, 6);

        
        txtUsernameU.setText(username);
        txtPasswordU.setText(password);
        txtLocationU.setText(location);
        txtContactNumberU.setText(phone);
        txtFullNameU.setText(fullname);
        
        // Set the selected userType in the ComboBox
        cmbbxUsertype.setSelectedItem(userType);  
    }
}  
     private void loadUsersToTable() {
     DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    model.setRowCount(0); // Clear the table
    
    String selectQuery = "SELECT * FROM users";
    try (Connection conn = DBConnector.getConnection();
         PreparedStatement pst = conn.prepareStatement(selectQuery);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Object[] row = new Object[7];
            row[0] = rs.getInt("userID");
            row[1] = rs.getString("username");
            row[2] = rs.getString("password");
            row[3] = rs.getString("userType");
            row[4] = rs.getString("location");
            row[5] = rs.getString("phone");
            row[6] = rs.getString("fullname");

            model.addRow(row);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    /**
     * @param args the command line arguments
     */
   
        public static void main(String[] args) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users_Page().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddU;
    private javax.swing.JButton btnClearU;
    private javax.swing.JButton btnCloseU;
    private javax.swing.JButton btnDeleteU;
    private javax.swing.JButton btnEditU;
    private javax.swing.JButton btnGoU;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbbxUsertype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFullNameU;
    private javax.swing.JLabel lblLocationU;
    private javax.swing.JLabel lblPasswordU;
    private javax.swing.JLabel lblSearchU;
    private javax.swing.JLabel lblUsernameU;
    private javax.swing.JLabel lblUsersTitle;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtContactNumberU;
    private javax.swing.JTextField txtFullNameU;
    private javax.swing.JTextField txtLocationU;
    private javax.swing.JTextField txtPasswordU;
    private javax.swing.JTextField txtSearchU;
    private javax.swing.JTextField txtUsernameU;
    // End of variables declaration//GEN-END:variables

}