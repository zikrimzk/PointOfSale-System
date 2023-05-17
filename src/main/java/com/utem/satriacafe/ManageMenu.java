
package com.utem.satriacafe;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

public class ManageMenu extends javax.swing.JFrame implements Function {
     private final MenuManager manager = new MenuManager();
     Menu menu;

    public ManageMenu() {
        initComponents();
         try {
             displayMenu();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
         codeMenuGenerate();
         enableBtn();
    }
    
    public void clearAll()
    {
        codeMenuT.setText("");
        codeMenuT.setEditable(true);
        nameMenuT.setText("");
        priceMenuT.setText("");
        statusBox.setSelectedIndex(0);
        catBox.setSelectedIndex(0);
        enableBtn();
        codeMenuGenerate();
        
    }
    
    private boolean EmptyCheck()
    {
        if(codeMenuT.getText().isEmpty()||nameMenuT.getText().isEmpty()||
           priceMenuT.getText().isEmpty()||statusBox.getSelectedIndex()==0||
           catBox.getSelectedIndex()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
private void codeMenuGenerate()
{
    Random rand = new Random();
    int range = 5000;
    int random = rand.nextInt(range); 
    codeMenuT.setText(String.valueOf(random));
    codeMenuT.setEditable(false);
}
public void enableBtn()
{
    addMenuB.setEnabled(true);
    editMenuB.setEnabled(false);
    deleteMenuB.setEnabled(false);
    ClearMenuB.setEnabled(true);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        priceMenuT = new javax.swing.JTextField();
        nameMenuT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        codeMenuT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addMenuB = new javax.swing.JButton();
        ClearMenuB = new javax.swing.JButton();
        deleteMenuB = new javax.swing.JButton();
        editMenuB = new javax.swing.JButton();
        catBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        statusBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        catFilterBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        exitM = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        homeM = new javax.swing.JMenuItem();
        logoutM = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        manageStaffM = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 850));
        setMinimumSize(new java.awt.Dimension(1300, 850));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1300, 850));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price(RM)");

        priceMenuT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceMenuT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        priceMenuT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceMenuTActionPerformed(evt);
            }
        });

        nameMenuT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameMenuT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        nameMenuT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameMenuTActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        codeMenuT.setBackground(new java.awt.Color(0, 0, 0));
        codeMenuT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        codeMenuT.setForeground(new java.awt.Color(255, 255, 255));
        codeMenuT.setBorder(null);
        codeMenuT.setMargin(new java.awt.Insets(15, 15, 15, 15));
        codeMenuT.setPreferredSize(new java.awt.Dimension(2, 23));
        codeMenuT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeMenuTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Menu Code");

        addMenuB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addMenuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-new-40.png"))); // NOI18N
        addMenuB.setText("ADD");
        addMenuB.setBorder(new javax.swing.border.MatteBorder(null));
        addMenuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuBActionPerformed(evt);
            }
        });

        ClearMenuB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ClearMenuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-clear-symbol-40.png"))); // NOI18N
        ClearMenuB.setText("CLEAR");
        ClearMenuB.setBorder(new javax.swing.border.MatteBorder(null));
        ClearMenuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearMenuBActionPerformed(evt);
            }
        });

        deleteMenuB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteMenuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-remove-40.png"))); // NOI18N
        deleteMenuB.setText("DELETE");
        deleteMenuB.setBorder(new javax.swing.border.MatteBorder(null));
        deleteMenuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuBActionPerformed(evt);
            }
        });

        editMenuB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editMenuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-design-40.png"))); // NOI18N
        editMenuB.setText("EDIT");
        editMenuB.setBorder(new javax.swing.border.MatteBorder(null));
        editMenuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuBActionPerformed(evt);
            }
        });

        catBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        catBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Nasi campur", "Ala goreng", "Minuman" }));
        catBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Status");

        statusBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Available", "Not Available" }));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        menuTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Category", "Price", "Status"
            }
        ));
        menuTable.setGridColor(new java.awt.Color(0, 0, 0));
        menuTable.setRowHeight(25);
        menuTable.setRowMargin(0);
        menuTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        menuTable.getTableHeader().setReorderingAllowed(false);
        menuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTable);
        if (menuTable.getColumnModel().getColumnCount() > 0) {
            menuTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            menuTable.getColumnModel().getColumn(1).setPreferredWidth(15);
            menuTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            menuTable.getColumnModel().getColumn(3).setPreferredWidth(8);
            menuTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        catFilterBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        catFilterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nasi campur", "Ala goreng", "Minuman" }));
        catFilterBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catFilterBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel8.setText("Filter");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(jLabel8)
                .addGap(35, 35, 35)
                .addComponent(catFilterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catFilterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-50.png"))); // NOI18N
        jLabel10.setText("MENU MANAGER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameMenuT, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeMenuT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(editMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(deleteMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(priceMenuT, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(ClearMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(222, 222, 222))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(codeMenuT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameMenuT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priceMenuT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearMenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-admin-settings-male-30.png"))); // NOI18N
        jMenu1.setText("Admin");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        homeM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        homeM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        homeM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-home-screen-30.png"))); // NOI18N
        homeM.setText("Home");
        homeM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMActionPerformed(evt);
            }
        });
        jMenu1.add(homeM);

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

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-staff-30.png"))); // NOI18N
        jMenu2.setText("Staff");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        manageStaffM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        manageStaffM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manageStaffM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-30.png"))); // NOI18N
        manageStaffM.setText("Manage staff");
        manageStaffM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStaffMActionPerformed(evt);
            }
        });
        jMenu2.add(manageStaffM);

        jMenuBar1.add(jMenu2);

        jMenu5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zikri Mzk\\OneDrive\\Documents\\NetBeansProjects\\satriaCafe\\src\\main\\resources\\icons8-profit-report-30.png")); // NOI18N
        jMenu5.setText("Report");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-order-history-30.png"))); // NOI18N
        jMenuItem1.setText("Transaction History");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

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

    
    private void homeMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMActionPerformed
        dispose();
        AhomePanel Apage = new AhomePanel();
        Apage.show();
    }//GEN-LAST:event_homeMActionPerformed

    private void manageStaffMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStaffMActionPerformed
        dispose();
        ManageUser userSetting = new ManageUser();
        userSetting.show();
    }//GEN-LAST:event_manageStaffMActionPerformed

    private void codeMenuTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeMenuTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeMenuTActionPerformed

    private void catFilterBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catFilterBoxActionPerformed
        int c;
        try{
            String filter = catFilterBox.getSelectedItem().toString();
            if(catFilterBox.getSelectedItem().toString()=="All")
            {
                displayMenu();
            }
            else
            {
                database satriadb = new database();
                String SQL= "SELECT * FROM MENU WHERE CATEGORY='"+filter+"'";

                PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsm = rs.getMetaData();
                c=rsm.getColumnCount();
                DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
                tc.setRowCount(0);

                while(rs.next())
                {
                    Vector v = new Vector();
                    for(int i = 1;i<=c; i++)
                    {
                        v.add(rs.getInt("CODE"));
                        v.add(rs.getString("NAME"));
                        v.add(rs.getDouble("PRICE"));
                        v.add(rs.getString("CATEGORY"));
                        v.add(rs.getString("STATUS"));

                    }
                    tc.addRow(v);
                }

            }
        }
        catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_catFilterBoxActionPerformed

    private void ClearMenuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearMenuBActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_ClearMenuBActionPerformed

    private void priceMenuTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceMenuTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceMenuTActionPerformed

    private void nameMenuTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameMenuTActionPerformed

    }//GEN-LAST:event_nameMenuTActionPerformed

    private void menuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTableMouseClicked

        DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
        int menuCode = menuTable.getSelectedRow();

        codeMenuT.setText(tc.getValueAt(menuCode, 0).toString());
        codeMenuT.setEditable(false);
        nameMenuT.setText(tc.getValueAt(menuCode, 1).toString());
        catBox.setSelectedItem(tc.getValueAt(menuCode,2).toString());
        priceMenuT.setText(tc.getValueAt(menuCode, 3).toString());
        statusBox.setSelectedItem(tc.getValueAt(menuCode,4).toString());
        addMenuB.setEnabled(false);
        editMenuB.setEnabled(true);
        deleteMenuB.setEnabled(true);
        ClearMenuB.setEnabled(true);

    }//GEN-LAST:event_menuTableMouseClicked

    private void editMenuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuBActionPerformed
        if(!EmptyCheck())
        {
            DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
            int menuCode = menuTable.getSelectedRow();
            menu = new Menu();
            menu.setMenuCode(Integer.parseInt(codeMenuT.getText().trim()));
            menu.setMenuName(nameMenuT.getText().trim());
            menu.setMenuPrice(Double.parseDouble(priceMenuT.getText().trim()));
            menu.setMenuCategory(catBox.getSelectedItem().toString());
            menu.setMenuStatus(statusBox.getSelectedItem().toString());

            try {
                manager.editMenu(Integer.parseInt(tc.getValueAt(menuCode, 0).toString()), menu);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, " Menu updated !!! ");
            try {
                displayMenu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearAll();
            enableBtn();
            codeMenuGenerate();

        }
        else{
            JOptionPane.showMessageDialog(null, " Complete all the form !!! ");
        }
    }//GEN-LAST:event_editMenuBActionPerformed

    private void addMenuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuBActionPerformed
        if(!EmptyCheck())
        {

            menu = new Menu();
            menu.setMenuCode(Integer.parseInt(codeMenuT.getText().trim()));
            menu.setMenuName(nameMenuT.getText().trim().toUpperCase());
            menu.setMenuPrice(Double.parseDouble(priceMenuT.getText().trim()));
            menu.setMenuCategory(catBox.getSelectedItem().toString());
            menu.setMenuStatus(statusBox.getSelectedItem().toString());

            try {
                manager.addMenu(menu);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, " Menu Successfully Added !!! ");
            try {
                displayMenu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearAll();

        }
        else{
            JOptionPane.showMessageDialog(null, " Complete all the form !!! ");
        }
    }//GEN-LAST:event_addMenuBActionPerformed

    private void deleteMenuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuBActionPerformed
        int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to delete the Menu ? ", " Delete Menu ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );

        if(jawapan == JOptionPane.YES_OPTION){
            DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
            int menuCode = menuTable.getSelectedRow();
            try {
                manager.deleteMenu(Integer.parseInt(tc.getValueAt(menuCode, 0).toString()));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, " Menu deleted !!! ");
            try {
                displayMenu();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearAll();

        }
    }//GEN-LAST:event_deleteMenuBActionPerformed

    private void catBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catBoxActionPerformed

    }//GEN-LAST:event_catBoxActionPerformed

    private void exitMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMActionPerformed

    private void logoutMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMActionPerformed
        // TODO add your handling code here:
        int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to logout ", " Logout? ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if(jawapan == JOptionPane.YES_OPTION){
            Login home = new Login();
            home.show();
            dispose();

        }
    }//GEN-LAST:event_logoutMActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        SalesReport history = new SalesReport();
        history.show();
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void displayMenu() throws ClassNotFoundException
     {
        int c;
          try{
            database satriadb = new database();
            String SQL= "SELECT * FROM MENU";
            DecimalFormat f = new DecimalFormat("0.00");
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            c=rsm.getColumnCount();
            DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
            tc.setRowCount(0);
          
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i = 1;i<=c; i++)
                {
                    v.add(rs.getInt("CODE"));
                    v.add(rs.getString("NAME"));
                    v.add(rs.getString("CATEGORY"));
                    v.add(f.format(rs.getDouble("PRICE")));
                    v.add(rs.getString("STATUS"));
                   
                            
                }
                tc.addRow(v);
            }

            }
        catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
     }
 
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
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearMenuB;
    private javax.swing.JButton addMenuB;
    private javax.swing.JComboBox<String> catBox;
    private javax.swing.JComboBox<String> catFilterBox;
    private javax.swing.JTextField codeMenuT;
    private javax.swing.JButton deleteMenuB;
    private javax.swing.JButton editMenuB;
    private javax.swing.JMenuItem exitM;
    private javax.swing.JMenuItem homeM;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JMenuItem logoutM;
    private javax.swing.JMenuItem manageStaffM;
    private javax.swing.JTable menuTable;
    private javax.swing.JTextField nameMenuT;
    private javax.swing.JTextField priceMenuT;
    private javax.swing.JComboBox<String> statusBox;
    // End of variables declaration//GEN-END:variables
}
