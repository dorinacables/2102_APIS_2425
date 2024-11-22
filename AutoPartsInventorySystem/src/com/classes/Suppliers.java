/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classes;

/**
 *
 * 
 */
public class Suppliers {
    private int supplierid;
    private String suppliername, location, phone, email;
    
      public Suppliers(int supplierid, String suppliername, String location, String phone, String email) {       
        this.supplierid = supplierid;
        this.suppliername = suppliername;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public int getSupplierID() {
        return supplierid;
    }

    public void setSupplierID(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getSupplierName() {
        return suppliername;
    }

    public void setSupplierName(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
    

