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
 * 
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
    String queryCheckProduct = "SELECT * FROM products WHERE product_code=?";
    prepStatement = conn.prepareStatement(queryCheckProduct);
    prepStatement.setString(1, products.getProductCode());
    resultSet = prepStatement.executeQuery();

    if (resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Product with this code already exists.");
    } else {
        // Get supplier name from ComboBox
        String selectedSupplierName = products.getSupplierName();  
        
        // Check if the supplier exists in the 'suppliers' table by supplier name
        String queryCheckSupplier = "SELECT supplierid FROM suppliers WHERE suppliername = ?";
        prepStatement = conn.prepareStatement(queryCheckSupplier);
        prepStatement.setString(1, selectedSupplierName); 
        resultSet = prepStatement.executeQuery();

        if (!resultSet.next()) {
            JOptionPane.showMessageDialog(null, "Supplier does not exist.");
        } else {
            // Retrieve the supplier_id
            int supplierID = resultSet.getInt("supplierid");

            // Insert the product with the existing supplier_id
            String queryInsertProduct = "INSERT INTO products (product_code, product_name, quantity, price, brand, supplier_id) VALUES(?, ?, ?, ?, ?, ?)";
            prepStatement = conn.prepareStatement(queryInsertProduct);
            prepStatement.setString(1, products.getProductCode());
            prepStatement.setString(2, products.getProductName());
            prepStatement.setInt(3, products.getQuantity());
            prepStatement.setDouble(4, products.getPrice());
            prepStatement.setString(5, products.getBrand());
            prepStatement.setInt(6, supplierID); 

            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product added successfully.");
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error adding product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }
    
    public void editProductDAO(Products products) {
           try {
        // Check if the product exists in the 'products' table
        String queryCheckProduct = "SELECT * FROM products WHERE product_code=?";
        prepStatement = conn.prepareStatement(queryCheckProduct);
        prepStatement.setString(1, products.getProductCode());
        resultSet = prepStatement.executeQuery();

        if (resultSet.next()) {
            // Get the old supplier_id from the product record
            int oldSupplierID = resultSet.getInt("supplier_id");
            int newSupplierID = products.getSupplierID();  // Get the new supplier_id from the product object

            if (oldSupplierID != newSupplierID) {
                // Check if the new supplier exists in the 'suppliers' table by ID
                String queryCheckSupplier = "SELECT * FROM suppliers WHERE supplierid = ?";
                prepStatement = conn.prepareStatement(queryCheckSupplier);
                prepStatement.setInt(1, newSupplierID); // Use new supplier ID
                resultSet = prepStatement.executeQuery();

                if (!resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Supplier with ID " + newSupplierID + " does not exist.");
                } else {
                    // Update the supplier_id in the products table 
                    String queryUpdateProduct = "UPDATE products SET supplier_id = ? WHERE product_code = ?";
                    prepStatement = conn.prepareStatement(queryUpdateProduct);
                    prepStatement.setInt(1, newSupplierID); // Update supplier_id
                    prepStatement.setString(2, products.getProductCode());
                    prepStatement.executeUpdate();
                }
            }

            // Update the product details (name, quantity, price, brand, etc.)
            String queryUpdateProductDetails = "UPDATE products SET product_name = ?, quantity = ?, price = ?, brand = ? WHERE product_code = ?";
            prepStatement = conn.prepareStatement(queryUpdateProductDetails);
            prepStatement.setString(1, products.getProductName());
            prepStatement.setInt(2, products.getQuantity());
            prepStatement.setDouble(3, products.getPrice());
            prepStatement.setString(4, products.getBrand());
            prepStatement.setString(5, products.getProductCode());

            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product updated successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Product not found.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        // Query to join products and suppliers to get supplier name along with product details
        String query = "SELECT p.product_id, p.product_code, p.product_name, p.quantity, p.price, p.brand, s.suppliername " +
                       "FROM products p " +
                       "JOIN suppliers s ON p.supplier_id = s.supplierid";
        resultSet = statement.executeQuery(query);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return resultSet;
}
   
    // Method to get a specific product by product code
    public ResultSet getProductDAO(String productCode) {
            String query = "SELECT p.product_id, p.product_code, p.product_name, p.quantity, p.price, p.brand, s.suppliername " +
                   "FROM products p " +
                   "JOIN suppliers s ON p.supplier_id = s.supplierid " +
                   "WHERE p.product_code = ?";
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
        // Query to join products and suppliers to get the supplier name
        String query = "SELECT p.product_id, p.product_code, p.product_name, p.quantity, p.price, p.brand, s.suppliername " +
                       "FROM products p " +
                       "JOIN suppliers s ON p.supplier_id = s.supplierid";
        resultSet = statement.executeQuery(query);

        // Build the table model with the updated data
        tableModel.setRowCount(0); 
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            row.add(resultSet.getInt("product_id"));
            row.add(resultSet.getString("product_code"));
            row.add(resultSet.getString("product_name"));
            row.add(resultSet.getInt("quantity"));
            row.add(resultSet.getDouble("price"));
            row.add(resultSet.getString("brand"));
            row.add(resultSet.getString("suppliername")); 
            tableModel.addRow(row); 
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

    // Add columns including quantity and supplier name
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