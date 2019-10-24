/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta Delv-Indra
 */
public class AdminDataObat extends javax.swing.JFrame {

    /**
     * Creates new form AdminDataObat
     */
    public AdminDataObat() {
        initComponents();
    }
    
     public void setObat(DefaultTableModel t){
        daftarObat.setModel(t);
    }
     
     public String getCari(){
         return cariTeks.getText();
     }
     
     public void cari(ActionListener a){
          cariButton.addActionListener(a);
     }
     
     public void tambah(ActionListener a){
          tambah.addActionListener(a);
     }
     
     public void ubahObat(ActionListener t){
        ubah.addActionListener(t);
    }
     
     public void setUser(String a){
         username.setText(a);
     }
     
     public JTable getTabel(){
        return daftarObat;
    }
     
     public void tableListener(MouseListener m){
        daftarObat.addMouseListener(m);
    }
     
     public JButton ubah(){
         return ubah;
     }
     
      public void berandaListener(ActionListener a){
        beranda.addActionListener(a);
    }
    
    public void pasienListener (ActionListener a){
        pasien.addActionListener(a);
    }
    
    public JButton obatB(){
        return obat;
    }
    
    public void obatListener (ActionListener a){
        obat.addActionListener(a);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        daftarObat = new javax.swing.JTable();
        cariTeks = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cariButton = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        beranda = new javax.swing.JButton();
        obat = new javax.swing.JButton();
        pasien = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        daftarObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(daftarObat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 510, 290));

        cariTeks.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(cariTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 240, 30));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel1.setText("Cari Obat:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 30));

        cariButton.setBackground(new java.awt.Color(255, 255, 204));
        cariButton.setFont(new java.awt.Font("Humnst777 BT", 1, 11)); // NOI18N
        cariButton.setForeground(new java.awt.Color(89, 133, 39));
        cariButton.setText("Cari");
        getContentPane().add(cariButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 70, 30));

        ubah.setBackground(new java.awt.Color(102, 204, 0));
        ubah.setFont(new java.awt.Font("Humnst777 BT", 1, 12)); // NOI18N
        ubah.setForeground(new java.awt.Color(255, 255, 153));
        ubah.setText("Ubah Stok");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 130, 40));

        tambah.setBackground(new java.awt.Color(102, 204, 0));
        tambah.setFont(new java.awt.Font("Humnst777 BT", 1, 12)); // NOI18N
        tambah.setForeground(new java.awt.Color(255, 255, 153));
        tambah.setText("Tambah Obat");
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 130, 40));

        username.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 190, 30));

        beranda.setBackground(new java.awt.Color(89, 133, 39));
        beranda.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        beranda.setForeground(new java.awt.Color(255, 255, 204));
        beranda.setText("Beranda");
        getContentPane().add(beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, 40));

        obat.setBackground(new java.awt.Color(89, 133, 39));
        obat.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        obat.setForeground(new java.awt.Color(255, 255, 204));
        obat.setText("Data Obat");
        getContentPane().add(obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 140, 40));

        pasien.setBackground(new java.awt.Color(89, 133, 39));
        pasien.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        pasien.setForeground(new java.awt.Color(255, 255, 204));
        pasien.setText("Data Pasien");
        getContentPane().add(pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/admin.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDataObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beranda;
    private javax.swing.JButton cariButton;
    private javax.swing.JTextField cariTeks;
    private javax.swing.JTable daftarObat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton obat;
    private javax.swing.JButton pasien;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
