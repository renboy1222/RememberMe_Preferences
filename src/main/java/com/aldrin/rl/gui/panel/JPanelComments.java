/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.aldrin.rl.gui.panel;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JPanelComments extends javax.swing.JPanel {

    /**
     * Creates new form JPanelComments
     */
    public JPanelComments() {
        initComponents();
        jButton1.putClientProperty("JButton.buttonType", "roundRect");
        jButton2.putClientProperty("JButton.buttonType", "roundRect");
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
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(940, 40));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel2.setText("Channel comments and mentions");
        jPanel4.add(jLabel2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(jList1);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel8.setPreferredSize(new java.awt.Dimension(947, 50));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton1.setText("Published");
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 36));
        jPanel8.add(jButton1);

        jLabel1.setPreferredSize(new java.awt.Dimension(30, 0));
        jPanel8.add(jLabel1);

        jButton2.setText("Held for reviews");
        jButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 36));
        jPanel8.add(jButton2);

        jPanel2.add(jPanel8, java.awt.BorderLayout.NORTH);

        jTabbedPane1.addTab("Comments", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mentions", jPanel3);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}