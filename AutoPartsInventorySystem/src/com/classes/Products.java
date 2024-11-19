package com.classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elmer Reyes
 */
public class Products {
    private int productID, quantity;
    private double price;
    private String productcode, productname, suppliername, brand;
    
     public Products(String productcode, String productname, String suppliername, String brand, double price, int quantity) {    
        this.productcode = productcode;
        this.productname = productname;
        this.suppliername = suppliername;
        this.brand = brand;
        this.price = price;     
        this.quantity = quantity;
        
    }
    
    

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductCode() {
        return productcode;
    }

    public void setProductCode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductName() {
        return productname;
    }

    public void setProductName(String productname) {
        this.productname = productname;
    } 
  
    public String getSupplierName() {
        return suppliername;
    }

    public void setSupplierName(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}



    

