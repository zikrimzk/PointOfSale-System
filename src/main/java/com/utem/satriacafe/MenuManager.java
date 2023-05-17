/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zikri Mzk
 */
public class MenuManager {
    
    private database satriadb = new database();
    private Menu menu = new Menu();

    public MenuManager() {
    }
    
    
    public void addMenu(Menu menu) throws ClassNotFoundException
    {
        DecimalFormat f = new DecimalFormat("0.00");
        int code = menu.getMenuCode();
        String name = menu.getMenuName();
        double price = menu.getMenuPrice();
        String cat = menu.getMenuCategory();
        String status = menu.getMenuStatus();
        
        try{
            String SQL= "INSERT INTO MENU VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
             ps.setInt(1,code);
             ps.setString(2,name);
             ps.setDouble(3,price);
             ps.setString(4,cat);
             ps.setString(5,status);
             ps.executeUpdate();
      
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
     public void editMenu(int id, Menu menu) throws ClassNotFoundException
    {
        int code = menu.getMenuCode();
        String name = menu.getMenuName().toUpperCase();
        double price = menu.getMenuPrice();
        String cat = menu.getMenuCategory();
        String status = menu.getMenuStatus();
        
        try{
           
             String SQL="UPDATE MENU SET NAME = ?, PRICE = ?, " 
                     + "CATEGORY = ? , STATUS = ? WHERE CODE = ?";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
            
             ps.setString(1,name);
             ps.setDouble(2,price);
             ps.setString(3,cat);
             ps.setString(4,status);
             ps.setInt(5,code);
             ps.executeUpdate();
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     
      public void deleteMenu(int id) throws ClassNotFoundException
    {
        try{
             String SQL="DELETE FROM MENU WHERE CODE = ? ";
             PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
             ps.setInt(1, id);
             ps.executeUpdate();
     
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     
}
