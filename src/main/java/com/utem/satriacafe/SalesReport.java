/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utem.satriacafe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Zikri Mzk
 */
public class SalesReport extends javax.swing.JFrame {

    /**
     * Creates new form SalesReport
     */
    DefaultTableModel model;
    public SalesReport() {
        initComponents();
        try {
            displayReport();
            CountTotalRevenue();
            CountTotalTrans() ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void displayReport() throws ClassNotFoundException
     {
        int c;
          try{
            database satriadb = new database();
            String SQL= "SELECT * FROM TRANSACTION ORDER BY  DATE ASC";
            
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            c=rsm.getColumnCount();
            DefaultTableModel trans = (DefaultTableModel) transTable.getModel();
            trans.setRowCount(0);
          
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i = 1;i<=c; i++)
                {
                    v.add(rs.getInt("TRANSNO"));
                    v.add(rs.getString("DATE"));
                    v.add(rs.getDouble("TOTAL"));
                    
                }
                trans.addRow(v);
            }

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
             LblTotal.setText(String.valueOf(f.format(count)));
            
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
     
     public void searching(String str) throws ClassNotFoundException{
         model =  (DefaultTableModel) transTable.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<> (model);
         transTable.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         database satriadb = new database();
         DecimalFormat f = new DecimalFormat("0.00");
         Transaction report = new Transaction();
         try{
            String SQL= "SELECT COUNT(*) FROM TRANSACTION WHERE DATE LIKE '"+str+"%'";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            String SQL1= "SELECT SUM(TOTAL) FROM TRANSACTION WHERE DATE LIKE '"+str+"%'";
            PreparedStatement ps1 = satriadb.openConnection().prepareStatement(SQL1);
            ResultSet rs1 = ps1.executeQuery();
             
             rs.next();
             int count = rs.getInt(1);
             totalTransLbl.setText(String.valueOf(count));
             rs1.next();
             double sum = rs1.getDouble(1);
             LblTotal.setText(String.valueOf(f.format(sum)));
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
         
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalTransLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        exitM = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        homeM = new javax.swing.JMenuItem();
        logoutM1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        manageUser = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        manageMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1100, 700));
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1100, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-order-history-50.png"))); // NOI18N
        jLabel11.setText("TRANSACTION HISTORY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(22, 22, 22))
        );

        transTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        transTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill No", "Date", "Total(RM)"
            }
        ));
        transTable.setGridColor(new java.awt.Color(0, 0, 0));
        transTable.setRowHeight(25);
        transTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        transTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText(" Total Record   : ");

        LblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblTotal.setText(" <> ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText(" Revenue (RM) : ");

        totalTransLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalTransLbl.setText(" <> ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTotal)
                    .addComponent(totalTransLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalTransLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LblTotal))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-more-30.png"))); // NOI18N
        jLabel9.setText("Search");

        search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

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

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-admin-settings-male-30.png"))); // NOI18N
        jMenu5.setText("Admin");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        homeM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        homeM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        homeM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-home-screen-30.png"))); // NOI18N
        homeM.setText("Home");
        homeM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMActionPerformed(evt);
            }
        });
        jMenu5.add(homeM);

        logoutM1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-login-rounded-40.png"))); // NOI18N
        logoutM1.setText("LOGOUT");
        logoutM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutM1ActionPerformed(evt);
            }
        });
        jMenu5.add(logoutM1);

        jMenuBar1.add(jMenu5);

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

    private void transTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transTableMouseClicked

       
    }//GEN-LAST:event_transTableMouseClicked

    private void exitMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMActionPerformed

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

    private void homeMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMActionPerformed
        dispose();
        AhomePanel Apage = new AhomePanel();
        Apage.show();
    }//GEN-LAST:event_homeMActionPerformed

    private void logoutM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutM1ActionPerformed
        // TODO add your handling code here:
        int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to logout ", " Logout? ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if(jawapan == JOptionPane.YES_OPTION){
            Login home = new Login();
            home.show();
            dispose();

        }
    }//GEN-LAST:event_logoutM1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        String searchs = search.getText();
        try {
            searching(searchs);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblTotal;
    private javax.swing.JMenuItem exitM;
    private javax.swing.JMenuItem homeM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem logoutM1;
    private javax.swing.JMenuItem manageMenu;
    private javax.swing.JMenuItem manageUser;
    private javax.swing.JTextField search;
    private javax.swing.JLabel totalTransLbl;
    private javax.swing.JTable transTable;
    // End of variables declaration//GEN-END:variables
}
