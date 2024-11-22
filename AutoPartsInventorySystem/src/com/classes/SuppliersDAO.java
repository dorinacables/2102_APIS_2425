/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * 
 */
public class SuppliersDAO {
    private Connection conn = null;
    private PreparedStatement prepStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    public SuppliersDAO() {
        try {
            conn = new DBConnector().getConnection();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Method to add a new supplier
    public void addSupplierDAO(Suppliers supplier) {
        try {
        // Check if the supplier already exists in the 'suppliers' table
        String queryCheck = "SELECT * FROM suppliers WHERE supplierid=?";
        prepStatement = conn.prepareStatement(queryCheck);
        prepStatement.setInt(1, supplier.getSupplierID());  
        resultSet = prepStatement.executeQuery();

        if (resultSet.next()) {
            JOptionPane.showMessageDialog(null, "Supplier with this ID already exists.");
        } else {
            // Insert into 'suppliers' table
            String queryInsert = "INSERT INTO suppliers (supplierid, suppliername, location, phone, email) VALUES(?, ?, ?, ?, ?)";
            prepStatement = conn.prepareStatement(queryInsert);
            prepStatement.setInt(1, supplier.getSupplierID());  
            prepStatement.setString(2, supplier.getSupplierName());
            prepStatement.setString(3, supplier.getLocation());
            prepStatement.setString(4, supplier.getPhone());
            prepStatement.setString(5, supplier.getEmail());

            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Supplier added successfully.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding supplier: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    // Method to edit an existing supplier
   public boolean editSupplierDAO(Suppliers supplier) {
    String queryUpdateSupplier = "UPDATE suppliers SET suppliername = ?, location = ?, phone = ?, email = ? WHERE supplier_id = ?";

    // Establish a database connection and prepare the statement
    try (Connection conn = new DBConnector().getConnection();
         PreparedStatement pstmtSupplier = conn.prepareStatement(queryUpdateSupplier)) {

        // Set auto-commit to false for transaction handling
        conn.setAutoCommit(false);

        // Update the supplier details in the 'suppliers' table
        pstmtSupplier.setString(1, supplier.getSupplierName());
        pstmtSupplier.setString(2, supplier.getLocation());
        pstmtSupplier.setString(3, supplier.getPhone());
        pstmtSupplier.setString(4, supplier.getEmail());
        pstmtSupplier.setInt(5, supplier.getSupplierID());  

        int supplierRowsAffected = pstmtSupplier.executeUpdate();

        // If the update was successful, commit the transaction
        if (supplierRowsAffected > 0) {
            conn.commit();
            return true;  // Return true if the update succeeded
        } else {
            // If the update failed, roll back the transaction
            conn.rollback();
            return false;
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;  // Return false if an error occurred
    }
}
    // Method to delete an existing supplier
    public boolean deleteSupplierDAO(int supplierid) {
          boolean isDeleted = false;
    String query = "DELETE FROM suppliers WHERE supplier_id = ?";  

    try (Connection conn = new DBConnector().getConnection();
         PreparedStatement prepStatement = conn.prepareStatement(query)) {
        
        prepStatement.setInt(1, supplierid);  // Set the int parameter for supplierId
        int rowsAffected = prepStatement.executeUpdate();
        isDeleted = rowsAffected > 0;  // Returns true if deletion is successful
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting supplier: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return isDeleted;
}

    // Method to retrieve supplier data to display in a table
    public ResultSet getQueryResult() {
         ResultSet resultSet = null;  

    try (Connection conn = new DBConnector().getConnection();
         Statement statement = conn.createStatement()) {
        
        String query = "SELECT supplier_id, suppliername, location, phone, email FROM suppliers";
        resultSet = statement.executeQuery(query);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving suppliers: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return resultSet;
}
    // Method to refresh JTable data
    public void refreshTable(DefaultTableModel tableModel) {
        try {
        String query = "SELECT supplier_id, suppliername, location, phone, email FROM suppliers";
        resultSet = statement.executeQuery(query);

        tableModel.setRowCount(0); // Clear existing rows
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            row.add(resultSet.getInt("supplier_id"));  
            row.add(resultSet.getString("suppliername"));
            row.add(resultSet.getString("location"));
            row.add(resultSet.getString("phone"));
            row.add(resultSet.getString("email"));
            tableModel.addRow(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error refreshing table: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // Method to build a table model for JTable
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<>();
        int colCount = metaData.getColumnCount();

        for (int col = 1; col <= colCount; col++) {
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<>();
            for (int col = 1; col <= colCount; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
   

