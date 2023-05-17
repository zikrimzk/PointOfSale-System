/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

/**
 *
 * @author Zikri Mzk
 */
public class Menu {
    
    private int code;
    private String name;
    private double price;
    private String category;
    private String status;

    public Menu() {
    }

    public String getMenuName() {
        return name;
    }

    public void setMenuName(String name) {
        this.name = name;
    }

    public double getMenuPrice() {
        return price;
    }

    public void setMenuPrice(double price) {
        this.price = price;
    }

    public String getMenuCategory() {
        return category;
    }

    public void setMenuCategory(String category) {
        this.category = category;
    }

    public String getMenuStatus() {
        return status;
    }

    public void setMenuStatus(String status) {
        this.status = status;
    }

    public int getMenuCode() {
        return code;
    }

    public void setMenuCode(int code) {
        this.code = code;
    }
    
    
    
}
