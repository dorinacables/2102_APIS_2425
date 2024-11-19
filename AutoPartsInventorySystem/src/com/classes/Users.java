package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elmer Reyes
 */
public class Users {
    private int UserID;
    private String fullname, location, phone, username, password, userType;
    private String inTime, outTime;
    
    public Users(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }
    
     public Users(String username, String password, String fullname, String location, String userType, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.location = location;
        this.userType = userType;
        this.phone = phone;
     }  
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    public void setFullName(String fullname) {
        this.fullname = fullname;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public void setInTime(String inTime) {
        this.inTime = inTime;
    }
    
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
    
    
    public int getUserID() {
        return UserID;
    }

    public String getFullName() {
        return fullname;
    }

    public String getLocation() {
        return location;
    }
    
    public String getPhone() {
        return phone;
    }   

    public String getUsername() {
        return username;
    } 

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
    
    public String getInTime() {
        return inTime;
    }
    
    public String getOutTime() {
        return outTime;
    }
    
}

    

