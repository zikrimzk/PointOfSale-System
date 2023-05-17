
package com.utem.satriacafe;

import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class BilllingSection extends javax.swing.JFrame implements Total,Function {

    private static ArrayList<Receipt> rsList;
    String names;
    DefaultTableModel model;
    
    public BilllingSection(String name) {
        initComponents();
        try {
            displayMenu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BilllingSection.class.getName()).log(Level.SEVERE, null, ex);
        }
        notEditable();
        enableBtn();
        codeGet.setVisible(false);
        menuTable.getTableHeader().setFont(new Font("Segeo UI",Font.PLAIN,18));
        billTable.getTableHeader().setFont(new Font("Segeo UI",Font.PLAIN,18));
        sessionName.setText(" HI " + name.toUpperCase() + " !");
        sessionName.setEnabled(false);
        names=name;
    }
    BilllingSection()
    {
        initComponents();
        
    }
    public void calcTotalPerItem(Receipt rs)
    {
        DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
        int menuCode = menuTable.getSelectedRow();
        DecimalFormat f = new DecimalFormat("0.00");
        int q = Integer.parseInt(quantityBillT.getText().trim());
        rs.setQuantity(q);
        double ttl=Double.parseDouble(tc.getValueAt(menuCode, 2).toString())*q;
        rs.setPrice(Double.parseDouble(f.format(ttl)));
    }
    public void getTotal()
    {
        DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
        int menuCode = menuTable.getSelectedRow();
        DecimalFormat f = new DecimalFormat("0.00");
        double sum = 0;
        double taxRate = 6;
        double taxes = 0;

        for(int i=0; i<billTable.getRowCount();i++)
        {
            sum = sum +Double.parseDouble(billTable.getValueAt(i, 3).toString());
            taxes = taxes + (Double.parseDouble(billTable.getValueAt(i, 3).toString())*taxRate/100);
        }

        subtotal.setText(String.valueOf(f.format(sum)));
        tax.setText(String.valueOf(f.format(taxes)));
        double totalAll = Double.parseDouble(subtotal.getText()) + Double.parseDouble(tax.getText());
        totalLbl.setText(String.valueOf(f.format(totalAll)));
        
    }
    public void deleteTotal()
    {
        DefaultTableModel tc = (DefaultTableModel) billTable.getModel();
        int menuCode = billTable.getSelectedRow();
        DecimalFormat f = new DecimalFormat("0.00");
        double price = Double.parseDouble(tc.getValueAt(menuCode, 3).toString());
        double taxMenu=Double.parseDouble(tc.getValueAt(menuCode, 3).toString())*6/100;
        double totalAll = Double.parseDouble(subtotal.getText()) + Double.parseDouble(tax.getText())-(price+taxMenu);
        subtotal.setText(String.valueOf(f.format(Double.parseDouble(subtotal.getText())-price)));
        tax.setText(String.valueOf(f.format(Double.parseDouble(tax.getText())-taxMenu)));
        totalLbl.setText(String.valueOf(f.format(totalAll)));
    }
    public void clearAll()
    {
        DefaultTableModel tContent = (DefaultTableModel) billTable.getModel();
        subtotal.setText("");
        tax.setText("");
        amountT.setText("");
        balanceT.setText("");
        totalLbl.setText("0");
        bill.setText("");
        payMethod.setSelectedIndex(0);
         enableBtn();
        int i=0;
        while(i<=billTable.getRowCount())
         {
             tContent.removeRow(i);
         }
    }
   public void enableBtn()
   {
       addBillB.setEnabled(true);
       deleteBillB.setEnabled(false);
       cancelOrder.setEnabled(false);
       doneB.setEnabled(false);
       
   }
    public void notEditable()
    {
        namebillT.setEditable(false);
        subtotal.setEditable(false);
        tax.setEditable(false);
        balanceT.setEditable(false);
    }
   

    private void readFromfile()
    {
         rsList = new ArrayList<Receipt>();
         
        try
        {
            FileInputStream file = new FileInputStream("order.txt");
            ObjectInputStream read = new ObjectInputStream(file);
            
            boolean endFile=false;
            while(!endFile)
            {
                try{
                    rsList.add((Receipt) read.readObject());
                }
                catch(EOFException e)
                {
                    endFile=true;
                    
                }
                catch(Exception f)
                {
                    JOptionPane.showMessageDialog(null,f.getMessage());
                }
            }
            read.close();
            
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",0);
        }
    }
   
    private void writeToFile()
    {
        try{
            FileOutputStream file = new FileOutputStream("order.txt");
            ObjectOutputStream write = new ObjectOutputStream(file);
            for(Receipt x: rsList)
            {
                write.writeObject(x);
                
            }
            write.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",0);
            
        }
        
    }
    
    public void searching(String str){
         model =  (DefaultTableModel) menuTable.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<> (model);
         menuTable.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
     }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        namebillT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        catFilterBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        quantityBillT = new javax.swing.JTextField();
        addBillB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deleteBillB = new javax.swing.JButton();
        codeGet = new javax.swing.JTextField();
        cancelOrder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        payMethod = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        balanceT = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        amountT = new javax.swing.JTextField();
        doneB = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        staffName = new javax.swing.JMenu();
        logoutM = new javax.swing.JMenuItem();
        sessionName = new javax.swing.JMenu();

        setMinimumSize(new java.awt.Dimension(1300, 900));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1300, 820));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        menuTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuTable.setForeground(new java.awt.Color(51, 51, 51));
        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price"
            }
        ));
        menuTable.setFocusable(false);
        menuTable.setGridColor(new java.awt.Color(51, 51, 51));
        menuTable.setIntercellSpacing(new java.awt.Dimension(1, 0));
        menuTable.setRowHeight(25);
        menuTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        menuTable.setShowVerticalLines(false);
        menuTable.getTableHeader().setReorderingAllowed(false);
        menuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel3.setText("Name");

        namebillT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        namebillT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        namebillT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namebillTActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel8.setText("Filter");

        catFilterBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        catFilterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nasi campur", "Ala goreng", "Minuman" }));
        catFilterBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catFilterBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel5.setText("Quantity");

        quantityBillT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quantityBillT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        quantityBillT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityBillTActionPerformed(evt);
            }
        });

        addBillB.setBackground(new java.awt.Color(255, 255, 255));
        addBillB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addBillB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-new-40.png"))); // NOI18N
        addBillB.setText("ADD ");
        addBillB.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        addBillB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillBActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-bill-50.png"))); // NOI18N
        jLabel4.setText("BILLING SECTION");

        deleteBillB.setBackground(new java.awt.Color(255, 255, 255));
        deleteBillB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteBillB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-remove-40.png"))); // NOI18N
        deleteBillB.setText("DELETE");
        deleteBillB.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        deleteBillB.setMaximumSize(new java.awt.Dimension(210, 65));
        deleteBillB.setMinimumSize(new java.awt.Dimension(210, 65));
        deleteBillB.setPreferredSize(new java.awt.Dimension(210, 65));
        deleteBillB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBillBActionPerformed(evt);
            }
        });

        codeGet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        codeGet.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        codeGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeGetActionPerformed(evt);
            }
        });

        cancelOrder.setBackground(new java.awt.Color(255, 255, 255));
        cancelOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-close-40.png"))); // NOI18N
        cancelOrder.setText("CANCEL");
        cancelOrder.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        cancelOrder.setMaximumSize(new java.awt.Dimension(210, 65));
        cancelOrder.setMinimumSize(new java.awt.Dimension(210, 65));
        cancelOrder.setPreferredSize(new java.awt.Dimension(210, 65));
        cancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 800));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 800));
        jPanel2.setPreferredSize(new java.awt.Dimension(644, 800));

        billTable.setBackground(new java.awt.Color(0, 0, 0));
        billTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        billTable.setForeground(new java.awt.Color(255, 255, 255));
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Quantity", "Price"
            }
        ));
        billTable.setRowHeight(25);
        billTable.setRowMargin(0);
        billTable.getTableHeader().setReorderingAllowed(false);
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(billTable);
        if (billTable.getColumnModel().getColumnCount() > 0) {
            billTable.getColumnModel().getColumn(0).setPreferredWidth(3);
            billTable.getColumnModel().getColumn(2).setPreferredWidth(3);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SubTotal (RM)");

        subtotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subtotal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tax (6%) ");

        tax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tax.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL = RM");

        totalLbl.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalLbl.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Payment Method ");

        payMethod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        payMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Cash", "Credit", "Debit" }));
        payMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payMethodActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Balance (RM) ");

        balanceT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        balanceT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        balanceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceTActionPerformed(evt);
            }
        });

        bill.setEditable(false);
        bill.setColumns(20);
        bill.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        bill.setRows(5);
        bill.setBorder(null);
        jScrollPane3.setViewportView(bill);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Amount (RM) ");

        amountT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amountT.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        amountT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(subtotal)
                                    .addComponent(payMethod, javax.swing.GroupLayout.Alignment.LEADING, 0, 99, Short.MAX_VALUE)
                                    .addComponent(amountT)
                                    .addComponent(balanceT))
                                .addGap(66, 66, 66)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(totalLbl)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(amountT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalLbl))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        doneB.setBackground(new java.awt.Color(255, 255, 255));
        doneB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doneB.setForeground(new java.awt.Color(51, 51, 51));
        doneB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-get-cash-40.png"))); // NOI18N
        doneB.setText("PAY");
        doneB.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        doneB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBActionPerformed(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-more-30.png"))); // NOI18N
        jLabel9.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addComponent(catFilterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(doneB, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(addBillB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(deleteBillB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(namebillT, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quantityBillT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addComponent(codeGet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(catFilterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namebillT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeGet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(quantityBillT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBillB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBillB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneB, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        staffName.setBackground(new java.awt.Color(255, 255, 255));
        staffName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-staff-30.png"))); // NOI18N
        staffName.setText("Staff");
        staffName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        logoutM.setBackground(new java.awt.Color(255, 255, 255));
        logoutM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-logout-rounded-30.png"))); // NOI18N
        logoutM.setText("LOGOUT");
        logoutM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMActionPerformed(evt);
            }
        });
        staffName.add(logoutM);

        jMenuBar1.add(staffName);

        sessionName.setText("<user>");
        sessionName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(sessionName);

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

    private void addBillBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBillBActionPerformed
        DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
        int menuCode = menuTable.getSelectedRow();
        DecimalFormat f = new DecimalFormat("0.00");
        
            if(quantityBillT.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, " Please fill the quantity textField !");
            }
            else{
                    readFromfile();
                    Receipt rs = new Receipt();
                    rs.setCode(Integer.parseInt(codeGet.getText().trim()));
                    rs.setName(namebillT.getText().trim());
                    calcTotalPerItem(rs);
                    rsList.add(rs);
                    writeToFile();
                    namebillT.setText("");
                    quantityBillT.setText("");
                    displayCart();
                    getTotal();
                    deleteBillB.setEnabled(true);
                    cancelOrder.setEnabled(true);
                    doneB.setEnabled(true);
            }
    }//GEN-LAST:event_addBillBActionPerformed

    private void quantityBillTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityBillTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityBillTActionPerformed

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
                String SQL= "SELECT * FROM MENU WHERE CATEGORY='"+filter+"' AND STATUS = 'AVAILABLE'";

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
            Logger.getLogger(BilllingSection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_catFilterBoxActionPerformed

    private void namebillTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namebillTActionPerformed

    }//GEN-LAST:event_namebillTActionPerformed

    private void menuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTableMouseClicked
        DefaultTableModel tc = (DefaultTableModel) menuTable.getModel();
        int menuCode = menuTable.getSelectedRow();
        codeGet.setText(tc.getValueAt(menuCode, 0).toString());
        namebillT.setText(tc.getValueAt(menuCode, 1).toString());
        
    }//GEN-LAST:event_menuTableMouseClicked

    private void deleteBillBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBillBActionPerformed

        DecimalFormat f = new DecimalFormat("0.00");
        DefaultTableModel tc = (DefaultTableModel) billTable.getModel();
        int menuCode = billTable.getSelectedRow();
        int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to delete the menu ? ", " Delete menu ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if(jawapan == JOptionPane.YES_OPTION){
            int searchMenu= Integer.parseInt(tc.getValueAt(menuCode, 0).toString());
            
            int index = 0;
            for(Receipt x: rsList)
            {
                if(x.getCode()==searchMenu)
                {
                    rsList.remove(index);
                    namebillT.setText("");
                    quantityBillT.setText("");
                    writeToFile();
                    
                    break;
                }
                else{
                    index++;
                    continue;
                    
                }
            }
            deleteTotal();
            subtotal.setEditable(false);
            tax.setEditable(false);
            tc.removeRow(menuCode);
            if(billTable.getRowCount()==0)
            {
                enableBtn();
            }  
        }
    }//GEN-LAST:event_deleteBillBActionPerformed

    private void codeGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeGetActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_codeGetActionPerformed

    private void cancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderActionPerformed
         clearAll();
    }//GEN-LAST:event_cancelOrderActionPerformed

    private void logoutMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMActionPerformed
         int jawapan = JOptionPane.showConfirmDialog(null," Are you sure want to Logout ? ", " LOGOUT ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
          if(jawapan == JOptionPane.YES_OPTION){
            Login home = new Login();
            home.show();
            dispose();
        }
    }//GEN-LAST:event_logoutMActionPerformed

    public void addReport(Transaction report) throws ClassNotFoundException
    {
        database satriadb = new database();
        int no = report.getReceiptNo();
        String date = report.getDate();
        double total = report.getTrans();
        
        try{
            String SQL= "INSERT INTO TRANSACTION VALUES (?, ?, ?)";
            PreparedStatement ps = satriadb.openConnection().prepareStatement(SQL);
             
             ps.setInt(1,no);
             ps.setString(2,date);
             ps.setDouble(3,total);
             
             ps.executeUpdate();
      
            
        }
         catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    private void doneBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBActionPerformed

        DecimalFormat f = new DecimalFormat("0.00");
        if(payMethod.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, " Select payment method to proceed! ");
        }
        else if(amountT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, " Please enter valid Amount! ");
        }
        else
        {
            double totalAll = Double.parseDouble(subtotal.getText()) + Double.parseDouble(tax.getText());
            double amt = Double.parseDouble(amountT.getText());
            double blc;
            blc = amt - totalAll;

            balanceT.setText(String.valueOf(f.format(blc)));
            try {
                defaultBill();
            } catch (PrinterException ex) {
                Logger.getLogger(BilllingSection.class.getName()).log(Level.SEVERE, null, ex);
            }
            clearAll();
            
        }

    }//GEN-LAST:event_doneBActionPerformed

    private void balanceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceTActionPerformed

    private void amountTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTActionPerformed

    private void payMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payMethodActionPerformed

    private void taxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taxActionPerformed

    private void subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalActionPerformed

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
        DefaultTableModel tc = (DefaultTableModel) billTable.getModel();
        int menuCode = billTable.getSelectedRow();

        codeGet.setText(tc.getValueAt(menuCode, 0).toString());
        namebillT.setText(tc.getValueAt(menuCode, 1).toString());
        quantityBillT.setText(tc.getValueAt(menuCode,2).toString());
    }//GEN-LAST:event_billTableMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        String searchs = search.getText();
        searching(searchs);
    }//GEN-LAST:event_searchKeyReleased

    private void displayMenu() throws ClassNotFoundException
     {
        int c;
          try{
            database satriadb = new database();
            String SQL= "SELECT * FROM MENU WHERE STATUS= 'AVAILABLE'";
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
                    v.add(f.format(rs.getDouble("PRICE")));
                    v.add(rs.getString("CATEGORY"));
                    v.add(rs.getString("STATUS")); 
                }
                tc.addRow(v);
            }

            }
        catch( SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
     }
    
    private void defaultBill() throws PrinterException
    {
        Receipt rs = new Receipt();
        Transaction report = new Transaction();
        Random rand = new Random(); 
        int range = 15000;
        int random = rand.nextInt(range); 
        double amt = Double.parseDouble(amountT.getText());
        
        DecimalFormat f = new DecimalFormat("0.00");
        bill.setText(bill.getText()+"\n\n");
        bill.setText(bill.getText()+"\t\t\tSATRIA CAFE SDN BHD \n");
        bill.setText(bill.getText()+"\t\tUniversiti Teknikal Malaysia Melaka \n");
        bill.setText(bill.getText()+"\t\tHang Tuah Jaya, 76100 Durian Tunggal, \n");
        bill.setText(bill.getText()+"\t\t\tTel No : 06-2701000\n\n");
        bill.setText(bill.getText()+" Cashier    :        \t"+names+"\n");
        bill.setText(bill.getText()+" Invoice No :        \t"+random+"\n");
        bill.setText(bill.getText()+" Date       :        \t"+rs.getDate()+"\n");
        bill.setText(bill.getText()+" ___________________________________________________________\n");

        bill.setText(bill.getText()+" Item        \t\t\tQuantity\t\tPrice\n");
        bill.setText(bill.getText()+" ___________________________________________________________\n");
          DefaultTableModel bT = (DefaultTableModel) billTable.getModel();
          for(int i =0; i<billTable.getRowCount();i++)
          {
              String code = bT.getValueAt(i,0).toString();
              String item = bT.getValueAt(i,1).toString();
              String qty = bT.getValueAt(i,2).toString();
              String prices = bT.getValueAt(i,3).toString();
              bill.setText(bill.getText()+" "+item+"\n");
              bill.setText(bill.getText()+" "+code+"         " +"\t\t\t"+qty+"\t\t\t"+prices+"\n");
              
          }
        bill.setText(bill.getText()+" ___________________________________________________________\n");
        bill.setText(bill.getText()+" SubTotal        \t\t\t\t\t"+ String.valueOf(f.format(Double.parseDouble(subtotal.getText())))+"\n");
        bill.setText(bill.getText()+" SST(6%)        \t\t\t\t\t"+ String.valueOf(f.format(Double.parseDouble(tax.getText())))+"\n\n");
        bill.setText(bill.getText()+" NET TOTAL(RM)        \t\t\t\t\t"+ totalLbl.getText()+"\n");
        bill.setText(bill.getText()+" ___________________________________________________________\n");
        bill.setText(bill.getText()+" " +payMethod.getSelectedItem()+ "        "+"\t\t\t\t\t\t"+ f.format(amt)+"\n");
        bill.setText(bill.getText()+" Change AMT(RM)       \t\t\t\t\t"+ balanceT.getText()+"\n");
        bill.setText(bill.getText()+" ___________________________________________________________\n");
        bill.setText(bill.getText()+"\t           THANK YOU FOR DINING WITH US! \n");
        bill.setText(bill.getText()+"\t                PLEASE COME AGAIN \n");


        report.setReceiptNo(random);
        report.getDate();
        report.setTrans(Double.parseDouble(totalLbl.getText()));
        try {
            addReport(report);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BilllingSection.class.getName()).log(Level.SEVERE, null, ex);
        }
        bill.print();
    }
    
    private void displayCart()
    {
         DefaultTableModel tContent = (DefaultTableModel) billTable.getModel();
         DecimalFormat f = new DecimalFormat("0.00");
         Object row[]= new Object[6];
         for(Receipt x: rsList)
         {
             row[0]=x.getCode();
             row[1]=x.getName();
             row[2]=x.getQuantity();
             row[3]=f.format(x.getPrice());
         }
          tContent.addRow(row);
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
            java.util.logging.Logger.getLogger(BilllingSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BilllingSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BilllingSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BilllingSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BilllingSection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBillB;
    private javax.swing.JTextField amountT;
    private javax.swing.JTextField balanceT;
    private javax.swing.JTextArea bill;
    private javax.swing.JTable billTable;
    private javax.swing.JButton cancelOrder;
    private javax.swing.JComboBox<String> catFilterBox;
    private javax.swing.JTextField codeGet;
    private javax.swing.JButton deleteBillB;
    private javax.swing.JButton doneB;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem logoutM;
    private javax.swing.JTable menuTable;
    private javax.swing.JTextField namebillT;
    private javax.swing.JComboBox<String> payMethod;
    private javax.swing.JTextField quantityBillT;
    private javax.swing.JTextField search;
    private javax.swing.JMenu sessionName;
    private javax.swing.JMenu staffName;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTextField tax;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
