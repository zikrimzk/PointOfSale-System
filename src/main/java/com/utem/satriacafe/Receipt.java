/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

import java.io.Serializable;
import java.text.*;
import java.util.*;
import java.util.Date;


public class Receipt implements Serializable{
    
    private Date date;
    private int code;
    private String name;
    private double price;
    private int quantity;
          

    public Receipt() {
        
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
       String date=dates.format(new Date());
       return date;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
    
}
