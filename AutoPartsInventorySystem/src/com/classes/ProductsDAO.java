package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

/**
/**
 *
 * @author Elmer Reyes
 */
public class ProductsDAO {
    private Connection conn = null;
    private PreparedStatement prepStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
      public ProductsDAO() {
        try {
            conn = new DBConnector().getConnection();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Method to add a new product
    public void addProductDAO(Products products) {
        Integer quantity = 0;
           try {
        // Check if the product already exists in the 'products' table
        String queryCheck = "SELECT * FROM products WHERE product_code=?";
        prepStatement = conn.prepareStatement(queryCheck);
        prepStatement.setString(1, products.getProductCode());
        resultSet = prepStatement.executeQuery();

        if (resultSet.next()) {
            JOptionPane.showMessageDialog(null, "Product with this code already exists.");
        } else {
            // Insert into 'products' table including quantity
            String queryInsert = "INSERT INTO products (product_code, product_name, quantity, price, brand, suppliername) VALUES(?, ?, ?, ?, ?, ?)";
            prepStatement = conn.prepareStatement(queryInsert);
            prepStatement.setString(1, products.getProductCode());
            prepStatement.setString(2, products.getProductName());
            prepStatement.setInt(3, products.getQuantity());  // 
            prepStatement.setDouble(4, products.getPrice());
            prepStatement.setString(5, products.getBrand());
            prepStatement.setString(6, products.getSupplierName());

            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product added successfully.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}  

    // Method to edit an existing product
    public void editProductDAO(Products products) {
          String query = "UPDATE products SET product_name = ?, quantity = ?, price = ?, brand = ?, suppliername = ? WHERE product_code = ?";

    try (Connection conn = new DBConnector().getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, products.getProductName());
        pstmt.setInt(2, products.getQuantity());
        pstmt.setDouble(3, products.getPrice());
        pstmt.setString(4, products.getBrand());
        pstmt.setString(5, products.getSupplierName());
        pstmt.setString(6, products.getProductCode());

        pstmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }  
    // Method to delete an existing product
    public boolean deleteProductDAO(String productCode) {
         boolean isDeleted = false;
        String query = "DELETE FROM products WHERE product_code = ?";

        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, productCode);
            int rowsAffected = prepStatement.executeUpdate();
            isDeleted = rowsAffected > 0; // Returns true if deletion is successful
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
        return isDeleted;
    }

    // Method to retrieve product data to display in a table
    public ResultSet getQueryResult() {
          try {
        String query = "SELECT product_id, product_code, product_name, quantity, price, brand, suppliername FROM products";
        resultSet = statement.executeQuery(query);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return resultSet;
}
   
    // Method to get a specific product by product code
    public ResultSet getProductDAO(String productCode) {
           String query = "SELECT * FROM products WHERE product_code = ?";
    try {
        Connection conn = new DBConnector().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, productCode);
        return pstmt.executeQuery();
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
}
    public void refreshTable(DefaultTableModel tableModel) {
    try {
        // Get the latest query result from the database
        String query = "SELECT * FROM products";
        resultSet = statement.executeQuery(query);

        // Build the table model with the updated data
        tableModel.setRowCount(0); // Clear the existing rows in the table
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            row.add(resultSet.getInt("product_id"));
            row.add(resultSet.getString("product_code"));
            row.add(resultSet.getString("product_name"));
            row.add(resultSet.getInt("quantity"));
            row.add(resultSet.getDouble("price"));
            row.add(resultSet.getString("brand"));
            row.add(resultSet.getString("suppliername"));
            tableModel.addRow(row); // Add each row to the table model
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error refreshing table: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
    ResultSetMetaData metaData = resultSet.getMetaData();
    Vector<String> columnNames = new Vector<>();
    int colCount = metaData.getColumnCount();

    // Add columns including quantity
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