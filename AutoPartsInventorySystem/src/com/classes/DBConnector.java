package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;


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
    String fullname = "";  // To store the user's fullname

    // Query to check username, password, and userType from users table
    String query = "SELECT * FROM users WHERE username = ? AND password = ? AND userType = ? LIMIT 1";

    try (Connection conn = getConnection()) {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, userType);
        resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            isValid = true;

            // Fetch the user's fullname from the resultSet
            fullname = resultSet.getString("fullname");

            // Record the login time **only after successful login**
            recordLoginTime(username, fullname, userType);  
        }
    } catch (Exception ex) {
        System.err.println("Error executing login query: " + ex.getMessage());
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (pstmt != null) pstmt.close();
        } catch (Exception ex) {
            System.err.println("Error closing resources: " + ex.getMessage());
        }
    }

    return isValid;
}

// Method to record login time and close any previous active session
    public void recordLoginTime(String username, String fullname, String userType) {
    // SQL queries
    String checkQuery = "SELECT * FROM userlogs WHERE username = ? AND outTime IS NULL";  // Check if there's an active session
    String updateQuery = "UPDATE userlogs SET outTime = NOW() WHERE username = ? AND outTime IS NULL"; // Close previous session

    try (Connection conn = getConnection()) {
        // Check if there's an open session (user is already logged in)
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, username);
            ResultSet resultSet = checkStmt.executeQuery();

            if (resultSet.next()) {
                // If there is an open session, update the outTime of that session to the current time
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, username);
                    updateStmt.executeUpdate();  // Set outTime for previous session
                    System.out.println("Closed previous active session for username: " + username);
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Method to record the logout time into userlogs
public void recordLogoutTime(String username) {
    String updateQuery = "UPDATE userlogs SET outTime = CURRENT_TIMESTAMP WHERE username = ? AND outTime IS NULL"; // Update logout time

    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
        pstmt.setString(1, username);

        // Execute the update
        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Logout time recorded successfully for username: " + username);
        } else {
            System.out.println("No matching active session found for username: " + username);
        }
    } catch (Exception ex) {
        System.err.println("Error updating logout time: " + ex.getMessage());
    }
}
  
    public String getFullname(String username) {
    String fullname = null;
    String query = "SELECT fullname FROM users WHERE username = ?";

    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            fullname = rs.getString("fullname");
        }
    } catch (Exception ex) {
        System.err.println("Error fetching fullname: " + ex.getMessage());
    }
    return fullname;
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
            
            // Convert inTime and outTime from String to LocalDateTime
            String inTimeStr = rs.getString("inTime");
            String outTimeStr = rs.getString("outTime");
            
            if (inTimeStr != null) {
                
                user.setInTime(LocalDateTime.parse(inTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            
            if (outTimeStr != null) {
                user.setOutTime(LocalDateTime.parse(outTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            
            return user;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
  }
    
}
       