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
import java.sql.SQLException;  // Make sure this is imported


public class DBConnector {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/autoparts_inventorysystem";
    private static final String username = "root";  
    private static final String password = ""; 
    
    private Connection conn;
    
    
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
            return conn;
        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }

    public boolean checkLogin(String username, String password, String userType) {
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        boolean isValid = false;
        
        String query = "SELECT * FROM users WHERE username = ? AND password = ? AND userType = ? LIMIT 1";
        
        try (Connection conn = getConnection()) {  // Use static getConnection() here
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
            // Close resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
            }
        }

        return isValid;
    }

    public Users getUserDetails(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Users user = new Users(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getString("location"),
                    rs.getString("userType"),
                    rs.getString("phone")
                );
                user.setUserID(rs.getInt("UserID"));
                user.setInTime(rs.getString("inTime"));
                user.setOutTime(rs.getString("outTime"));
                rs.close();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
    
     
       