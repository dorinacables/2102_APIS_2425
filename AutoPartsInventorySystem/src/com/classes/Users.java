package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDateTime;

/**
 *
 * 
 */
public class Users {
    private int UserID;
    private String fullname, location, phone, username, password, userType;
      private LocalDateTime inTime, outTime;  
    
    public Users(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }
    
      public Users(String username, String fullname, String userType) {
        this.username = username;
        this.userType = userType;
        this.fullname = fullname;
    }
    
     public Users(String username, String password, String fullname, String location, String userType, String phone) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.location = location;
        this.userType = userType;
        this.phone = phone;
    }  
     public Users(String username, String fullname, String userType, LocalDateTime inTime, LocalDateTime outTime) {
        this.username = username;
        this.fullname = fullname;
        this.userType = userType;
        this.inTime = inTime;
        this.outTime = outTime;
        
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
    
       public void setInTime(LocalDateTime inTime) {   
        this.inTime = inTime;
    }

    public void setOutTime(LocalDateTime outTime) {  
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
    
    public LocalDateTime getInTime() {  
        return inTime;
    }

    public LocalDateTime getOutTime() {  
        return outTime;

    }
    }

