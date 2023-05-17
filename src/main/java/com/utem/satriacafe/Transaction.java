/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Zikri Mzk
 */
public class Transaction{
    
    private Date date;
    private int receiptNo;
    private double trans;

    public Transaction() {
    }

    public String getDate() {
        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
       String date=dates.format(new Date());
       return date;
    }
     public String getDay() {
        SimpleDateFormat dates = new SimpleDateFormat("dd");
       String date=dates.format(new Date());
       return date;
    }


    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public double getTrans() {
        return trans;
    }

    public void setTrans(double trans) {
        this.trans = trans;
    }
    
    
}
