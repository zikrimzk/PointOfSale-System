/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zikri Mzk
 */
public class AhomePanel extends javax.swing.JFrame {
 
    Timer t ;
    SimpleDateFormat st ;
    public AhomePanel() {
        initComponents();
        
        try {
            CountTotalStaff();
            CountTotalMenu();
            CountTotalRevenue();
            CountTodayRevenue();
            CountTotalTrans();
            CountTodayTrans();
            getUpdateDate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AhomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        times();
        dates();
        
    }
    
    public void CountTotalStaff() throws ClassNotFoundException
    {
        database satriadb = new database();
         try{
            String SQL= "SELECT COUNT(*) FROM STAFF WHERE NAME != 'ADMIN'";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             
             rs.next();
             int count = rs.getInt(1);
             LblStaff.setText(String.valueOf(count));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }    
    }
    
     public void CountTotalMenu() throws ClassNotFoundException
    {
        database satriadb = new database();
         try{
            String SQL= "SELECT COUNT(*) FROM MENU ";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             
             rs.next();
             int count = rs.getInt(1);
             lblMenu.setText(String.valueOf(count));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }    
    }
     
     public void CountTotalRevenue() throws ClassNotFoundException
    {
        database satriadb = new database();
        DecimalFormat f = new DecimalFormat("0.00");
         try{
            String SQL= "SELECT SUM(TOTAL) FROM TRANSACTION";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             
             rs.next();
             double count = rs.getDouble(1);
             LblTotal.setText("RM" + String.valueOf(f.format(count)));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }    
    }
     
     public void CountTodayRevenue() throws ClassNotFoundException
    {
        database satriadb = new database();
        DecimalFormat f = new DecimalFormat("0.00");
        Transaction report = new Transaction();
         try{
            String SQL= "SELECT SUM(TOTAL) FROM TRANSACTION WHERE DATE LIKE '"+report.getDay()+"%'";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             
             rs.next();
             double count = rs.getDouble(1);
             LblTotalToday.setText("RM" + String.valueOf(f.format(count)));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }    
    }
     
     public void CountTodayTrans() throws ClassNotFoundException
    {
        database satriadb = new database();
        DecimalFormat f = new DecimalFormat("0.00");
        Transaction report = new Transaction();
         try{
            String SQL= "SELECT COUNT(*) FROM TRANSACTION WHERE DATE LIKE '"+report.getDay()+"%'";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             
             rs.next();
             int count = rs.getInt(1);
             todayTransLbl.setText(String.valueOf(count));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }    
    }
     
    public void CountTotalTrans() throws ClassNotFoundException
    {
        database satriadb = new database();
        DecimalFormat f = new DecimalFormat("0.00");
        Transaction report = new Transaction();
         try{
            String SQL= "SELECT COUNT(*) FROM TRANSACTION ";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             
             rs.next();
              int count = rs.getInt(1);
             totalTransLbl.setText(String.valueOf(count));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }    
    }
    
    public void getUpdateDate() throws ClassNotFoundException
    {
        Transaction report = new Transaction();
         
        updatedDate.setText(report.getDate());
    }
    public void dates(){

    Date d  =new Date();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    String dd = sdf.format(d);
    dateTxt.setText(dd);


}
    public void times(){
        t = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Date dt  =new Date();
        st = new SimpleDateFormat("hh:mm:ss");
        
        String tt = st.format(dt);
        timee.setText(tt);
        
      }
    });
  
    t.start();
    
    

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        LblStaff = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        totalTransLbl = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel10 = new javax.swing.JLabel();
        LblTotalToday = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        LblTotal = new javax.swing.JLabel();
        todayTrans = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        todayTransLbl = new javax.swing.JLabel();
        updatedDate = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        dateTxt = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        exitM = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        logoutM = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        manageUser = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        manageMenu = new javax.swing.JMenuItem();
        reportMenu = new javax.swing.JMenu();
        transMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-home-page-40.png"))); // NOI18N
        jLabel7.setText("ADMIN");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DASHBOARD");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 153));
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL MENU");

        lblMenu.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setText("0");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-summary-40.png"))); // NOI18N
        jLabel4.setText("SUMMARY");

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 51, 153));
        kGradientPanel2.setkGradientFocus(100);
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 153, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOTAL STAFF");

        LblStaff.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        LblStaff.setForeground(new java.awt.Color(255, 255, 255));
        LblStaff.setText("0");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(LblStaff))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(LblStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel4.setkEndColor(new java.awt.Color(255, 102, 0));
        kGradientPanel4.setkGradientFocus(100);
        kGradientPanel4.setkStartColor(new java.awt.Color(255, 153, 0));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TOTAL TRANSACTION");

        totalTransLbl.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        totalTransLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalTransLbl.setText("0");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(totalTransLbl))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(totalTransLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel5.setkEndColor(new java.awt.Color(255, 102, 102));
        kGradientPanel5.setkGradientFocus(100);
        kGradientPanel5.setkStartColor(new java.awt.Color(204, 0, 0));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TODAY'S REVENUE");

        LblTotalToday.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        LblTotalToday.setForeground(new java.awt.Color(255, 255, 255));
        LblTotalToday.setText("0");

        kGradientPanel3.setkEndColor(new java.awt.Color(0, 204, 51));
        kGradientPanel3.setkGradientFocus(100);
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 255, 102));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL REVENUE");

        LblTotal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        LblTotal.setForeground(new java.awt.Color(255, 255, 255));
        LblTotal.setText("0");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(LblTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(LblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(LblTotalToday))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblTotalToday, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        todayTrans.setkEndColor(new java.awt.Color(255, 102, 0));
        todayTrans.setkGradientFocus(100);
        todayTrans.setkStartColor(new java.awt.Color(255, 153, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TODAY'S TRANSACTION");

        todayTransLbl.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        todayTransLbl.setForeground(new java.awt.Color(255, 255, 255));
        todayTransLbl.setText("0");

        javax.swing.GroupLayout todayTransLayout = new javax.swing.GroupLayout(todayTrans);
        todayTrans.setLayout(todayTransLayout);
        todayTransLayout.setHorizontalGroup(
            todayTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayTransLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(todayTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(todayTransLbl))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        todayTransLayout.setVerticalGroup(
            todayTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayTransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(todayTransLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        updatedDate.setBackground(new java.awt.Color(0, 0, 0));
        updatedDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updatedDate.setText("<date>");

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Last updated :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(todayTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatedDate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(todayTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        timee.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timee.setForeground(new java.awt.Color(255, 255, 255));
        timee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-timezone-globe-30.png"))); // NOI18N
        timee.setText("00:00:00");

        dateTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateTxt.setForeground(new java.awt.Color(255, 255, 255));
        dateTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-calendar-30.png"))); // NOI18N
        dateTxt.setText("00/00/0000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timee)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addComponent(timee)
                .addGap(18, 18, 18)
                .addComponent(dateTxt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-system-30.png"))); // NOI18N
        jMenu3.setText("System");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        exitM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exitM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-shutdown-30.png"))); // NOI18N
        exitM.setText("EXIT");
        exitM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMActionPerformed(evt);
            }
        });
        jMenu3.add(exitM);

        jMenuBar1.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-admin-settings-male-30.png"))); // NOI18N
        jMenu1.setText("Admin");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        logoutM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-login-rounded-40.png"))); // NOI18N
        logoutM.setText("LOGOUT");
        logoutM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMActionPerformed(evt);
            }
        });
        jMenu1.add(logoutM);

        jMenuBar1.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-staff-30.png"))); // NOI18N
        jMenu4.setText("Staff");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        manageUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        manageUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-30.png"))); // NOI18N
        manageUser.setText("Manage staff");
        manageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserActionPerformed(evt);
            }
        });
        jMenu4.add(manageUser);

        jMenuBar1.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-food-menu-30.png"))); // NOI18N
        jMenu2.setText("Menu");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        manageMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        manageMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-30.png"))); // NOI18N
        manageMenu.setText("Manage menu");
        manageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageMenuActionPerformed(evt);
            }
        });
        jMenu2.add(manageMenu);

        jMenuBar1.add(jMenu2);

        reportMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zikri Mzk\\OneDrive\\Documents\\NetBeansProjects\\satriaCafe\\src\\main\\resources\\icons8-profit-report-30.png")); // NOI18N
        reportMenu.setText("Report");
        reportMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        transMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        transMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        transMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-order-history-30.png"))); // NOI18N
        transMenu.setText("Transaction History");
        transMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transMenuActionPerformed(evt);
            }
        });
        reportMenu.add(transMenu);

        jMenuBar1.add(reportMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        ManageMenu menuSetting = new ManageMenu();
        menuSetting.show();
    }//GEN-LAST:event_manageMenuActionPerformed

    private void manageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserActionPerformed
        // TODO add your handling code here:
         dispose();
        ManageUser userSetting = new ManageUser();
        userSetting.show();
    }//GEN-LAST:event_manageUserActionPerformed

    private void logoutMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMActionPerformed
        // TODO add your handling code here:
         int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to logout ", " Logout? ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if(jawapan == JOptionPane.YES_OPTION){
            Login home = new Login();
            home.show();
            dispose();

        }
    }//GEN-LAST:event_logoutMActionPerformed

    private void exitMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMActionPerformed

    private void transMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transMenuActionPerformed
        // TODO add your handling code here:
        SalesReport history = new SalesReport();
        history.show();
        dispose();
    }//GEN-LAST:event_transMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AhomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AhomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AhomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AhomePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AhomePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblStaff;
    private javax.swing.JLabel LblTotal;
    private javax.swing.JLabel LblTotalToday;
    private javax.swing.JLabel dateTxt;
    private javax.swing.JMenuItem exitM;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JMenuItem logoutM;
    private javax.swing.JMenuItem manageMenu;
    private javax.swing.JMenuItem manageUser;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JLabel timee;
    private keeptoo.KGradientPanel todayTrans;
    private javax.swing.JLabel todayTransLbl;
    private javax.swing.JLabel totalTransLbl;
    private javax.swing.JMenuItem transMenu;
    private javax.swing.JLabel updatedDate;
    // End of variables declaration//GEN-END:variables
}

