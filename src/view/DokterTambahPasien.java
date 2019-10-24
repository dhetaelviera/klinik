/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import model.user;

/**
 *
 * @author Dheta Delv-Indra
 */
public class DokterTambahPasien extends javax.swing.JFrame {

    /**
     * Creates new form AdminTambahPasien
     */
    
    Connection konek;
    DateFormat date;

    public DokterTambahPasien() {
        date = new SimpleDateFormat("yyyy-MM-dd");
        this.date = DateFormat.getDateInstance();
        initComponents();
    }
    
    public String getJenisKelamin(){
        String in=(String) jenisKelamin.getSelectedItem();
        return in;
    }
    
     public String getKeterangan(){
        String in=(String) keterangan.getSelectedItem();
        return in;
    }

    public Date getTanggalLahir() {
        Date tanggalLahir = (kalender.getDate());
        return tanggalLahir;
    }
    
    public String getNama(){
        return nama.getText();
    }
    
    public String getAlamat(){
        return alamat.getText();
    }
    
    public String getTelepon(){
        return notelepon.getText();
    }
    
    public String getPekerjaan(){
        return pekerjaan.getText();
    }
    
    public void tambahData(ActionListener a){
        tambah.addActionListener(a);
    }
    
     public void berandaListener(ActionListener a){
        beranda.addActionListener(a);
    }
    
    public void pasienListener (ActionListener a){
        pasien.addActionListener(a);
    }
    
    public JButton pasienB(){
        return pasien;
    }
    
    public JButton obatB(){
        return obat;
    }
    
    public JButton berandaB(){
        return beranda;
    }
    
    public JButton karyawanB(){
        return karyawan;
    }
    
    
    public void mbalek(ActionListener a){
        kembali.addActionListener(a);
    }
    
    public void obatListener (ActionListener a){
        obat.addActionListener(a);
    }
    
    public void karyawanListener (ActionListener a){
        karyawan.addActionListener(a);
    }
    
    public void keluaroi(ActionListener a){
        keluar.addActionListener(a);
    }

    public void setNamaAdmin(String a){
         namaAdmin.setText(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama = new javax.swing.JTextField();
        kalender = new org.jdesktop.swingx.JXDatePicker();
        pekerjaan = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        notelepon = new javax.swing.JTextField();
        kembali = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        keterangan = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jenisKelamin = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        beranda = new javax.swing.JButton();
        obat = new javax.swing.JButton();
        namaAdmin = new javax.swing.JLabel();
        pasien = new javax.swing.JButton();
        karyawan = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 230, 30));

        kalender.setBackground(new java.awt.Color(153, 153, 153));
        kalender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalenderActionPerformed(evt);
            }
        });
        getContentPane().add(kalender, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 200, 30));

        pekerjaan.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(pekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 230, 30));

        alamat.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 400, 30));

        notelepon.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(notelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 230, 30));

        kembali.setBackground(new java.awt.Color(255, 255, 204));
        kembali.setFont(new java.awt.Font("Gisha", 1, 12)); // NOI18N
        kembali.setForeground(new java.awt.Color(89, 133, 39));
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, 40));

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel7.setText("Keterangan     :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 110, 30));

        keterangan.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        keterangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nggapleki", "rodok nggapleki","aman"}));
        getContentPane().add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 210, 30));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel1.setText("Pekerjaan        :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 110, 30));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel2.setText("Nama               :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 110, 30));

        jenisKelamin.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jenisKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perempuan", "Laki-Laki"}));
        getContentPane().add(jenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 210, 30));

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel3.setText("Jenis Kelamin   :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 110, 30));

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal Lahir   :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 110, 30));

        jLabel5.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel5.setText("Alamat             :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 110, 30));

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel6.setText("No. telepon     :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 30));

        tambah.setBackground(new java.awt.Color(255, 255, 204));
        tambah.setFont(new java.awt.Font("Gisha", 1, 12)); // NOI18N
        tambah.setForeground(new java.awt.Color(89, 133, 39));
        tambah.setText("Tambah Data Pasien");
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, 40));

        beranda.setBackground(new java.awt.Color(89, 133, 39));
        beranda.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        beranda.setForeground(new java.awt.Color(255, 255, 204));
        beranda.setText("Beranda");
        getContentPane().add(beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, 40));

        obat.setBackground(new java.awt.Color(89, 133, 39));
        obat.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        obat.setForeground(new java.awt.Color(255, 255, 204));
        obat.setText("Data Obat");
        getContentPane().add(obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 140, 40));

        namaAdmin.setFont(new java.awt.Font("Gisha", 1, 12)); // NOI18N
        namaAdmin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(namaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 230, 20));

        pasien.setBackground(new java.awt.Color(89, 133, 39));
        pasien.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        pasien.setForeground(new java.awt.Color(255, 255, 204));
        pasien.setText("Data Pasien");
        getContentPane().add(pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 150, 40));

        karyawan.setBackground(new java.awt.Color(89, 133, 39));
        karyawan.setFont(new java.awt.Font("Geometr415 Blk BT", 0, 14)); // NOI18N
        karyawan.setForeground(new java.awt.Color(255, 255, 204));
        karyawan.setText("Data Karyawan");
        getContentPane().add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 150, 40));

        keluar.setBorder(null);
        keluar.setBorderPainted(false);
        keluar.setContentAreaFilled(false);
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 50, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/admin.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kalenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kalenderActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembaliActionPerformed

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
            java.util.logging.Logger.getLogger(DokterTambahPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DokterTambahPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DokterTambahPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DokterTambahPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DokterTambahPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton beranda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jenisKelamin;
    private org.jdesktop.swingx.JXDatePicker kalender;
    private javax.swing.JButton karyawan;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kembali;
    private javax.swing.JComboBox keterangan;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel namaAdmin;
    private javax.swing.JTextField notelepon;
    private javax.swing.JButton obat;
    private javax.swing.JButton pasien;
    private javax.swing.JTextField pekerjaan;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
