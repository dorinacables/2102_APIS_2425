package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elmer Reyes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DBConnector {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/autoparts_inventorysystem";
    private static final String username = "root";  
    private static final String password = ""; 

    
    public Connection getConnection() {
        Connection conn = null;
        try {          
            Class.forName(driver);          
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        return conn;
    }

    public boolean checkLogin(String username, String password, String userType) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        boolean isValid = false;
        
        String query = "SELECT * FROM users WHERE username = ? AND password = ? AND usertype = ? LIMIT 1";
        
        try {      
        conn = getConnection();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, userType);
        resultSet = pstmt.executeQuery();
               
        if (resultSet.next()) {
            isValid = true;  
        }
    } catch (Exception ex) {
        System.err.println("Error executing login query: " + ex.getMessage());
    } finally {
        // Close resources
        try {
            if (resultSet != null) resultSet.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            System.err.println("Error closing resources: " + ex.getMessage());
        }
    }

    return isValid;
}
}

    
    
