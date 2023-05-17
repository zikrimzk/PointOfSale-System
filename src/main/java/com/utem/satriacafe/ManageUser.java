
package com.utem.satriacafe;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

public class ManageUser extends javax.swing.JFrame implements Function {
    private final UserManager manager = new UserManager();
    User staff;
  
    public ManageUser() {
        initComponents();
        try {
            displayUser();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        staffIdGenerate();
        enableBtn();
    }
    
    public void clearAll()
    {
        staffIdT.setText("");
        staffIdT.setEditable(true);
        staffNameT.setText("");
        staffUsrT.setText("");
        staffAgeT.setText("");
        staffPhoneT.setText("");
        staffPassT.setText("");
        staffPassT2.setText("");
        staffIdGenerate();
        enableBtn();
        
        
    }
    
    private boolean EmptyCheck()
    {
        if(staffIdT.getText().isEmpty()||staffNameT.getText().isEmpty()||staffUsrT.getText().isEmpty()||
           staffAgeT.getText().isEmpty()||staffPhoneT.getText().isEmpty()||staffPassT.getText().isEmpty()
           || staffPassT2.getText().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void staffIdGenerate()
    {
    Random rand = new Random();
    int range = 100000;
    int random = rand.nextInt(range); 
    staffIdT.setText(String.valueOf(random));
    staffUsrT.setText("ST"+String.valueOf(random));
    staffIdT.setEditable(false);
    staffUsrT.setEditable(false);
    }
    
    public void enableBtn()
    {
        addStaffB.setEnabled(true);
        editStaffB.setEnabled(false);
        deleteStaffB.setEnabled(false);
        clearStaffB.setEnabled(true);
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        staffPassT2 = new javax.swing.JPasswordField();
        staffUsrT = new javax.swing.JTextField();
        editStaffB = new javax.swing.JButton();
        staffPhoneT = new javax.swing.JTextField();
        addStaffB = new javax.swing.JButton();
        deleteStaffB = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        clearStaffB = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        staffIdT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        staffNameT = new javax.swing.JTextField();
        staffPassT = new javax.swing.JPasswordField();
        staffAgeT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        exitM = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        homeM = new javax.swing.JMenuItem();
        logoutM = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        manageMenu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 850));
        setMinimumSize(new java.awt.Dimension(1300, 850));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1300, 850));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 850));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        userTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff Id", "Name", "Age", "Phone No", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        userTable.setGridColor(new java.awt.Color(0, 0, 0));
        userTable.setRowHeight(25);
        userTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setPreferredWidth(2);
            userTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            userTable.getColumnModel().getColumn(2).setPreferredWidth(2);
            userTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            userTable.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        staffPassT2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffPassT2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        staffUsrT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffUsrT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        staffUsrT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffUsrTActionPerformed(evt);
            }
        });

        editStaffB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editStaffB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-design-40.png"))); // NOI18N
        editStaffB.setText("EDIT");
        editStaffB.setBorder(new javax.swing.border.MatteBorder(null));
        editStaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStaffBActionPerformed(evt);
            }
        });

        staffPhoneT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffPhoneT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        staffPhoneT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffPhoneTActionPerformed(evt);
            }
        });

        addStaffB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addStaffB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-new-40.png"))); // NOI18N
        addStaffB.setText("ADD");
        addStaffB.setBorder(new javax.swing.border.MatteBorder(null));
        addStaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBActionPerformed(evt);
            }
        });

        deleteStaffB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteStaffB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-remove-40.png"))); // NOI18N
        deleteStaffB.setText("DELETE");
        deleteStaffB.setBorder(new javax.swing.border.MatteBorder(null));
        deleteStaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStaffBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Staff ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name ");

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age ");

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone No");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");

        clearStaffB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearStaffB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-clear-symbol-40.png"))); // NOI18N
        clearStaffB.setText("CLEAR");
        clearStaffB.setBorder(new javax.swing.border.MatteBorder(null));
        clearStaffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStaffBActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");

        staffIdT.setBackground(new java.awt.Color(0, 0, 0));
        staffIdT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffIdT.setForeground(new java.awt.Color(255, 255, 255));
        staffIdT.setBorder(new javax.swing.border.MatteBorder(null));
        staffIdT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffIdTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Confirm Password");

        staffNameT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffNameT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        staffNameT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffNameTActionPerformed(evt);
            }
        });

        staffPassT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffPassT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        staffAgeT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffAgeT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        staffAgeT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffAgeTActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-settings-50.png"))); // NOI18N
        jLabel11.setText("USER MANAGER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffNameT, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffIdT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(staffPassT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(staffUsrT, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(editStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(deleteStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addComponent(clearStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(129, 129, 129)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(staffPhoneT, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(staffAgeT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(staffPassT2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel11)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(staffIdT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffNameT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(staffAgeT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffUsrT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(staffPhoneT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffPassT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffPassT2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearStaffB, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void editStaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStaffBActionPerformed
        if(!EmptyCheck())
        {
         DefaultTableModel tc = (DefaultTableModel) userTable.getModel();
         int staffId = userTable.getSelectedRow();
            staff = new User();
            staff.setUsrId(Integer.parseInt(staffIdT.getText().trim()));
            staff.setUsrName(staffNameT.getText().trim());
            staff.setUsrAge(Integer.parseInt(staffAgeT.getText().trim()));
            staff.setUsrPhoneNo(staffPhoneT.getText().trim());
            staff.setUsrUsername(staffUsrT.getText().trim());
            staff.setUsrPass(staffPassT.getText().trim());
            
            try {
                manager.editUser(Integer.parseInt(tc.getValueAt(staffId, 0).toString()), staff);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
             JOptionPane.showMessageDialog(null, " Staff updated !!! ");
            try {
                displayUser();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
             clearAll();
            
        }
        else{
            JOptionPane.showMessageDialog(null, " Complete all the TextFiled !!! ");
        }
                         
    }//GEN-LAST:event_editStaffBActionPerformed

    private void addStaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBActionPerformed
        if(!EmptyCheck())
        {
            
            staff = new User();
            staff.setUsrId(Integer.parseInt(staffIdT.getText().trim()));
            staff.setUsrName(staffNameT.getText().trim().toUpperCase());
            staff.setUsrAge(Integer.parseInt(staffAgeT.getText().trim()));
            staff.setUsrPhoneNo(staffPhoneT.getText().trim().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
            staff.setUsrUsername(staffUsrT.getText().trim());
            staff.setUsrPass(staffPassT.getText().trim());
            if(staffPhoneT.getText().trim().length()<10)
            {
                JOptionPane.showMessageDialog(null, " Enter valid Phone No !");
            }
            else if(staffPassT.getText().trim().length()<8)
            {
                JOptionPane.showMessageDialog(null, " Password minimum 8 character !!");
            }
            else
            {
               

                String pass1= staffPassT.getText().trim();
                String pass2 = staffPassT2.getText().trim();
                if(pass1.equals(pass2))
                {
                    try {
                        manager.addUser(staff);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      JOptionPane.showMessageDialog(null, " Staff Added Successsfully !!! ");
                    try {
                        displayUser();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      clearAll();
                      staffIdGenerate();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, " Password entered not match ! ");
                }
            }    
        }
        else{
            JOptionPane.showMessageDialog(null, " Complete all the TextFiled !!! ");
        }
    }//GEN-LAST:event_addStaffBActionPerformed

    private void deleteStaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStaffBActionPerformed
       int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to delete the staff ? ", " Delete Staff ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        String pass =JOptionPane.showInputDialog(null, "Enter your password");
        database satriadb = new database();
        try{
            String SQL = "SELECT * FROM STAFF WHERE USERNAME = 'ADMIN'AND PASSWORD = '"+pass+"'";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            if(jawapan == JOptionPane.YES_OPTION){
             DefaultTableModel tc = (DefaultTableModel) userTable.getModel();
             int staffId = userTable.getSelectedRow();
             manager.deleteUser(Integer.parseInt(tc.getValueAt(staffId, 0).toString()));
            
            JOptionPane.showMessageDialog(null, " Staff deleted !!! ");
            displayUser();
            clearAll();
            staffIdGenerate();
        }
        }
        else{
            JOptionPane.showMessageDialog(null, " Password incorrect !");
        }
        }
        catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_deleteStaffBActionPerformed

    private void clearStaffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStaffBActionPerformed
        clearAll();
    }//GEN-LAST:event_clearStaffBActionPerformed

    private void staffIdTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffIdTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffIdTActionPerformed

    private void staffNameTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffNameTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffNameTActionPerformed

    private void staffAgeTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffAgeTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffAgeTActionPerformed

    private void staffUsrTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffUsrTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffUsrTActionPerformed

    private void staffPhoneTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffPhoneTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffPhoneTActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        
         DefaultTableModel tc = (DefaultTableModel) userTable.getModel();
         int staffId = userTable.getSelectedRow();
         
        staffIdT.setText(tc.getValueAt(staffId, 0).toString());
        staffIdT.setEditable(false);
        staffNameT.setText(tc.getValueAt(staffId, 1).toString());
        staffAgeT.setText(tc.getValueAt(staffId, 2).toString());
        staffPhoneT.setText(tc.getValueAt(staffId, 3).toString());
        staffUsrT.setText(tc.getValueAt(staffId, 4).toString());
        addStaffB.setEnabled(false);
        editStaffB.setEnabled(true);
        deleteStaffB.setEnabled(true);
        clearStaffB.setEnabled(true);
    }//GEN-LAST:event_userTableMouseClicked

    private void exitMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMActionPerformed

    private void homeMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMActionPerformed
        dispose();
        AhomePanel Apage = new AhomePanel();
        Apage.show();
    }//GEN-LAST:event_homeMActionPerformed

    private void logoutMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMActionPerformed
        // TODO add your handling code here:
        int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to logout ", " Logout? ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if(jawapan == JOptionPane.YES_OPTION){
            Login home = new Login();
            home.show();
            dispose();

        }
    }//GEN-LAST:event_logoutMActionPerformed

    private void manageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        ManageMenu menuSetting = new ManageMenu();
        menuSetting.show();
    }//GEN-LAST:event_manageMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        SalesReport history = new SalesReport();
        history.show();
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void displayUser() throws ClassNotFoundException
     {
        int c;
          try{
            database satriadb = new database();
            String SQL= "SELECT * FROM STAFF WHERE USERNAME !='admin'";
            
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            c=rsm.getColumnCount();
            DefaultTableModel tc = (DefaultTableModel) userTable.getModel();
            tc.setRowCount(0);
          
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i = 1;i<=c; i++)
                {
                    v.add(rs.getInt("STAFFID"));
                    v.add(rs.getString("NAME"));
                    v.add(rs.getInt("AGE"));
                    v.add(rs.getString("PHONENO"));
                    v.add(rs.getString("USERNAME"));
                    v.add(rs.getString("PASSWORD"));
                            
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
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStaffB;
    private javax.swing.JButton clearStaffB;
    private javax.swing.JButton deleteStaffB;
    private javax.swing.JButton editStaffB;
    private javax.swing.JMenuItem exitM;
    private javax.swing.JMenuItem homeM;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem logoutM;
    private javax.swing.JMenuItem manageMenu;
    private javax.swing.JTextField staffAgeT;
    private javax.swing.JTextField staffIdT;
    private javax.swing.JTextField staffNameT;
    private javax.swing.JPasswordField staffPassT;
    private javax.swing.JPasswordField staffPassT2;
    private javax.swing.JTextField staffPhoneT;
    private javax.swing.JTextField staffUsrT;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
