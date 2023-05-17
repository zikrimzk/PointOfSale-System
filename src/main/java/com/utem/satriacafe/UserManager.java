/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Zikri Mzk
 */
public class UserManager {
    private database satriadb = new database();
    private User staff = new User();
    
  

    public UserManager() {
    }
    
    public void addUser(User staff) throws ClassNotFoundException
    {
        int staffId= staff.getUsrId();
        String name=staff.getUsrName();
        int age = staff.getUsrAge();
        String phoneNo = staff.getUsrPhoneNo();
        String username=staff.getUsrUsername();
        String password = staff.getUsrPass();
        
        try{
            String SQL= "INSERT INTO STAFF VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
             ps.setInt(1,staffId);
             ps.setString(2,name);
             ps.setInt(3,age);
             ps.setString(4,phoneNo);
             ps.setString(5,username);
             ps.setString(6,password);
             
             
             ps.executeUpdate();
      
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void editUser(int id, User staff) throws ClassNotFoundException
    {
        int staffId= staff.getUsrId();
        String name=staff.getUsrName().toUpperCase();
        int age = staff.getUsrAge();
        String phoneNo = staff.getUsrPhoneNo();
        String username=staff.getUsrUsername();
        String password = staff.getUsrPass();
        
        try{
           
             String SQL="UPDATE STAFF SET NAME = ?, AGE = ?, " 
                     + "PHONENO = ? , USERNAME = ? , PASSWORD  = ? WHERE STAFFID = ?";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
             ps.setString(1,name);
             ps.setInt(2,age);
             ps.setString(3,phoneNo);
             ps.setString(4,username);
             ps.setString(5,password);
             ps.setInt(6,staffId);

             
             
             
             ps.executeUpdate();
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
     public void deleteUser(int id) throws ClassNotFoundException
    {
        try{
             String SQL="DELETE FROM STAFF WHERE STAFFID = ? ";
             PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
             ps.setInt(1, id);
             ps.executeUpdate();
     
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    
    
}
