/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Dheta
 */
public class AdminTambahDataPeriksa extends javax.swing.JFrame {

    /**
     * Creates new form AdminTambahDataPeriksa
     */
    public AdminTambahDataPeriksa() {
        initComponents();
    }
    
    public void setID(String a){
        id.setText(a);
    }
    
    public void setNamaAdmin(String a){
        namaAdmin.setText(a);
    }
    
    public void setNama(String a){
        nama.setText(a);
    }
    
    public void setTanggalLahir(String a){
        tgllahir.setText(a);
    }
    
    public void setJenisKelamin(String a){
        jk.setText(a);
    }
    
    public String getTensi(){
        return tensi.getText();
    }
    
    public String getSuhu(){
        return suhu.getText();
    }
    
    public String getNadi(){
        return nadi.getText();
    }
    
    public String getKeluhan(){
        return keluhan.getText();
    }
    
    public String getRR(){
        return rr.getText();
    }
    
    public void masukAntrian(ActionListener a){
        masukAntrian.addActionListener(a);
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

        jLabel1 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        tgllahir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jk = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keluhan = new javax.swing.JTextArea();
        tensi = new javax.swing.JTextField();
        masukAntrian = new javax.swing.JButton();
        suhu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nadi = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        beranda = new javax.swing.JButton();
        obat = new javax.swing.JButton();
        pasien = new javax.swing.JButton();
        namaAdmin = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel1.setText("Nama              :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 30));

        nama.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 200, 30));

        tgllahir.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(tgllahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, 30));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel2.setText("Usia saat ini    :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 30));

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel3.setText("Jenis Kelamin  :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 30));

        jk.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(jk, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 100, 30));

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel4.setText("Nadi                   :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel10.setText("Anamnesa      :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        keluhan.setColumns(20);
        keluhan.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        keluhan.setRows(5);
        jScrollPane1.setViewportView(keluhan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, -1));

        tensi.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(tensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 170, 30));

        masukAntrian.setBackground(new java.awt.Color(255, 255, 204));
        masukAntrian.setFont(new java.awt.Font("Gisha", 1, 12)); // NOI18N
        masukAntrian.setForeground(new java.awt.Color(89, 133, 39));
        masukAntrian.setText("Masukkan ke daftar antrian");
        getContentPane().add(masukAntrian, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, 40));

        suhu.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        suhu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suhuActionPerformed(evt);
            }
        });
        getContentPane().add(suhu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 170, 30));

        jLabel5.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel5.setText("Tekanan Darah :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, 30));

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel6.setText("C");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 30, 30));

        rr.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        rr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rrActionPerformed(evt);
            }
        });
        getContentPane().add(rr, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 170, 30));

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel7.setText("Suhu                  :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        nadi.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        getContentPane().add(nadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 170, 30));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, 20));

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
        getContentPane().add(namaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 70, 20));

        jLabel9.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel9.setText("RR                     :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, 30));

        jLabel11.setFont(new java.awt.Font("Myanmar Text", 0, 14)); // NOI18N
        jLabel11.setText("mmHg");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 50, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/admin.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suhuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suhuActionPerformed

    private void rrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rrActionPerformed

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
            java.util.logging.Logger.getLogger(AdminTambahDataPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminTambahDataPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminTambahDataPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminTambahDataPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminTambahDataPeriksa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beranda;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jk;
    private javax.swing.JTextArea keluhan;
    private javax.swing.JButton masukAntrian;
    private javax.swing.JTextField nadi;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel namaAdmin;
    private javax.swing.JButton obat;
    private javax.swing.JButton pasien;
    private javax.swing.JTextField rr;
    private javax.swing.JTextField suhu;
    private javax.swing.JTextField tensi;
    private javax.swing.JLabel tgllahir;
    // End of variables declaration//GEN-END:variables
}
