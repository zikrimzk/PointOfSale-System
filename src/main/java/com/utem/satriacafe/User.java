/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

import java.io.Serializable;

/**
 *
 * @author Zikri Mzk
 */
public class User implements Serializable{
    private int id;
    private String name;
    private int age;
    private String phoneNo;
    private String username;
    private String pass;

    public User() {
    }

    public String getUsrName() {
        return name;
    }

    public void setUsrName(String name) {
        this.name = name;
    }

    public int getUsrAge() {
        return age;
    }

    public void setUsrAge(int age) {
        this.age = age;
    }

    public String getUsrPhoneNo() {
        return phoneNo;
    }

    public void setUsrPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsrUsername() {
        return username;
    }

    public void setUsrUsername(String username) {
        this.username = username;
    }

    public String getUsrPass() {
        return pass;
    }

    public void setUsrPass(String pass) {
        this.pass = pass;
    }

    public int getUsrId() {
        return id;
    }

    public void setUsrId(int id) {
        this.id = id;
    }
  
    
    
            
    
}
