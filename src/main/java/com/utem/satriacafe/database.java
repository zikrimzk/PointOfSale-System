/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utem.satriacafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Zikri Mzk
 */
public class database {
    private Connection con;
    
    public Connection openConnection() throws ClassNotFoundException{
        if(con==null){
            String url = "jdbc:mysql://localhost/";
            String dbName= "satria";
            String driver = "com.mysql.cj.jdbc.Driver";
            String usr = "root";
            String pass = "";
            
            try{
                Class.forName(driver);
                con = (Connection)DriverManager.getConnection(url+dbName, usr, pass);
               // JOptionPane.showMessageDialog(null,"Connection Successfull");
            }
            catch(SQLException err){
                JOptionPane.showMessageDialog(null,err.getMessage());
            }
        }
        return con;
    }
    
    public Connection closeConnection()throws SQLException{
        con.close();
        JOptionPane.showMessageDialog(null,"Connection Closed");
        return con;
        
    }
    
}
