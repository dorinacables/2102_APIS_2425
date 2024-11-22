package com.classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 */
public class UsersDAO {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    
    
    public UsersDAO() {      
        try {
            conn = new DBConnector().getConnection();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Methods to add new user
    public void addUserDAO(Users users, String userType) {
         try {
        // Check if the user already exists in the 'users' table
        String queryCheck = "SELECT * FROM users WHERE username=?";
        prepStatement = conn.prepareStatement(queryCheck);
        prepStatement.setString(1, users.getUsername());
        resultSet = prepStatement.executeQuery();

        if (resultSet.next()) {
            JOptionPane.showMessageDialog(null, "User already exists in the login system.");
        } else {
            // Insert into 'users' table
            String queryInsertUsers = "INSERT INTO users (username, password, usertype, location, phone, fullname) VALUES(?, ?, ?, ?, ?, ?)";
            prepStatement = conn.prepareStatement(queryInsertUsers);
            prepStatement.setString(1, users.getUsername());
            prepStatement.setString(2, users.getPassword());
            prepStatement.setString(3, userType);
            prepStatement.setString(4, users.getLocation());
            prepStatement.setString(5, users.getPhone());
            prepStatement.setString(6, users.getFullName());
            prepStatement.executeUpdate();

            // Show success message
            JOptionPane.showMessageDialog(null, "User added successfully.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    public boolean isUsernameUnique(String username) throws SQLException {
         try {
        DBConnector dbConnector = new DBConnector(); 
        Connection conn = dbConnector.getConnection(); 
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();
        conn.close();
        return count == 0; // Returns true if no duplicates found
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception here
        return false; // Return false in case of error
    }
}

    public void addFunction(Users users, String userType) {
        try {
            String username;
            String password = null;
            String oldUsername = null;
            String resQuery = "SELECT * FROM users";
            resultSet = statement.executeQuery(resQuery);

            if(!resultSet.next()){
                username = "root";
                password = "root";
            }
//            else {
//                String resQuery2 = "SELECT * FROM users ORDER BY id DESC";
//                resultSet = statement.executeQuery(resQuery2);
//
//                if(resultSet.next()){
//                    oldUsername = resultSet.getString("username");
//                    Integer uCode = Integer.parseInt(oldUsername.substring(4));
//                    uCode++;
//                    username = "user" + uCode;
//                    password = "user" + uCode;
//                }
//            }

            String query = "INSERT INTO users (username,password,userType,location,phone,fullname) " +
                    "VALUES(?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, users.getUsername());
            prepStatement.setString(2, users.getPassword());
            prepStatement.setString(3, userType);
            prepStatement.setString(4, users.getLocation());
            prepStatement.setString(5, users.getPhone());
            prepStatement.setString(6, users.getFullName());
            prepStatement.executeUpdate();

            if("Administrator".equals(userType))
                JOptionPane.showMessageDialog(null, "New administrator added.");
            else JOptionPane.showMessageDialog(null, "New employee added.");

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Method to edit existing user
    public void editUserDAO(Users users) {
         try {
        String query = "UPDATE users SET password=?, usertype=?, location=?, phone=?, fullname=? WHERE username=?";
        prepStatement = conn.prepareStatement(query);
        prepStatement.setString(1, users.getPassword());
        prepStatement.setString(2, users.getUserType());
        prepStatement.setString(3, users.getLocation());
        prepStatement.setString(4, users.getPhone());
        prepStatement.setString(5, users.getFullName());
        prepStatement.setString(6, users.getUsername());

        int rowsAffected = prepStatement.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "User updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "No changes were made.");
        }
    } catch (SQLException throwables) {
        JOptionPane.showMessageDialog(null, "Error updating user: " + throwables.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        throwables.printStackTrace();
    }
}

    // Method to delete existing user
    public boolean deleteUserDAO(String username) {
        Connection conn = null;
    PreparedStatement pstmt = null;
    boolean isDeleted = false;

    String query = "DELETE FROM users WHERE username = ?";
    
    try {
        DBConnector dbConnector = new DBConnector();
        conn = dbConnector.getConnection();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);
        
        int rowsAffected = pstmt.executeUpdate();
        isDeleted = rowsAffected > 0; // True if at least one row was deleted
    } catch (SQLException e) {
        System.err.println("Error deleting user: " + e.getMessage());
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }

    return isDeleted;
}
    
    // Method to retrieve data set to display in table
    public ResultSet getQueryResult() {
      try {
        String query = "SELECT * FROM users";
        resultSet = statement.executeQuery(query);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return resultSet;
}

    public ResultSet getUsersDAO(String username) {
           try {
        String query = "SELECT * FROM users WHERE username=?";
        prepStatement = conn.prepareStatement(query);
        prepStatement.setString(1, username);
        resultSet = prepStatement.executeQuery();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return resultSet;
}
    
    public void getFullName(Users users, String username) {
        try {
            String query = "SELECT * FROM users WHERE username='" +username+ "' LIMIT 1";
            resultSet = statement.executeQuery(query);
            String fullName = null;
            if(resultSet.next()) fullName = resultSet.getString(2);
            users.setFullName(fullName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addUserLogin(Users users) {
    try {
        String query = "INSERT INTO userlogs (fullname, username, userType, inTime, outTime) values(?,?,?,?,?)";
        
        // Prepare the statement
        prepStatement = conn.prepareStatement(query);
        
        // Set the username
        prepStatement.setString(1, users.getFullName());
        
        // Set the fullname
        prepStatement.setString(2, users.getUsername());  
        
        // Set the userType
        prepStatement.setString(3, users.getUserType());  
        
        // Convert LocalDateTime to Timestamp for inTime
        if (users.getInTime() != null) {
            Timestamp inTimeTimestamp = Timestamp.valueOf(users.getInTime());  // Convert LocalDateTime to Timestamp
            prepStatement.setTimestamp(4, inTimeTimestamp);
        } else {
            prepStatement.setNull(4, java.sql.Types.TIMESTAMP);  // Set null if inTime is not available
        }
        
        // Convert LocalDateTime to Timestamp for outTime
        if (users.getOutTime() != null) {
            Timestamp outTimeTimestamp = Timestamp.valueOf(users.getOutTime());  // Convert LocalDateTime to Timestamp
            prepStatement.setTimestamp(5, outTimeTimestamp);
        } else {
            prepStatement.setNull(5, java.sql.Types.TIMESTAMP);  // Set null if outTime is not available
        }

        // Execute the statement
        prepStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public ResultSet getPasswordDAO(String username, String password){
        try {
            String query = "SELECT password FROM users WHERE username='"
                    +username
                    + "' AND password='"
                    +password
                    +"'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    public void changePassword(String username, String password) {
        try {
        String query = "UPDATE users SET password=? WHERE username=?";
        prepStatement = conn.prepareStatement(query);
        prepStatement.setString(1, password);
        prepStatement.setString(2, username);
        prepStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Password has been changed.");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
     public boolean userExists(String username) {    
    String query = "SELECT * FROM users WHERE username = ?";
    try (Connection conn = DBConnector.getConnection(); 
         PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        
        // If a result is returned, the username exists
        return rs.next();
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}

    // Method to add a user (for your sign-up functionality)
    public boolean addUser(Users newUsers) {
          String insertQuery = "INSERT INTO users (username, password, phone, location, fullname, userType) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = DBConnector.getConnection(); 
         
        PreparedStatement pst = conn.prepareStatement(insertQuery)){
        pst.setString(1, newUsers.getUsername());
        pst.setString(2, newUsers.getPassword());
        pst.setString(3, newUsers.getUserType());
        pst.setString(4, newUsers.getLocation());
        pst.setString(5, newUsers.getPhone());
        pst.setString(6, newUsers.getFullName());

        // Check if the insert was successful
        int result = pst.executeUpdate();
        return result > 0;  // If one row is updated, return true
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}
    // Method to display data set in tabular form
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int colCount = metaData.getColumnCount();

        for (int col=1; col <= colCount; col++){
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int col=1; col<=colCount; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}
    
    

