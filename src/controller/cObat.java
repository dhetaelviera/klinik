/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.obat;
import model.user;
import view.AdminDataObat;
import view.AdminHome;
import view.DokterDataObat;
import view.DokterHome;
import view.DokterTambahObat;
import view.DokterUbahObat;
import view.admintambah;
import view.adminubah;

/**
 *
 * @author Dheta Delv-Indra
 */
public class cObat {

    private obat obat;
    private cUser cUser;
    private cPasien cPasien;
    private user user;
    private String username;
    private AdminHome admin;
    private AdminDataObat daftarobat;
    private adminubah ubahdataobat;
    private admintambah tambah;
    private int idObat;
    private DokterHome dokter;
    private DokterDataObat dokterobat;
    private DokterUbahObat dokterubahobat;
    private DokterTambahObat doktertambahobat;

    public cObat() {

    }

    //=============================DOKTER==========================================
    public cObat(String i, int o) {
        obat = new obat();
        user = new user();
        username = i;
        dokterobat = new DokterDataObat();
        dokterobat.setVisible(true);
        dokterobat.setLocationRelativeTo(null);
        dokterobat.setResizable(false);
        dokterobat.setObat(obat.bacaDaftarObat());
        dokterobat.ubah().setEnabled(false);
        dokterobat.obatB().setEnabled(false);
        dokterobat.setUser(username);
        dokterobat.tableListener(new setSelectedObatDokter());
        dokterobat.ubahObat(new ubahdatadok());
        dokterobat.tambah(new menutambahobatdokter());
        dokterobat.berandaListener(new obatkeberandadokter());
        dokterobat.pasienListener(new obatkepasiendokter());
        dokterobat.cari(new cariobatdokter());
        dokterobat.refreshO().setEnabled(false);
        dokterobat.refreshtabel(new refreshtabeldok());
        dokterobat.out(new keluardariobatdok());
        dokterobat.karyawanListener(new obatkekar());

    }

    public cObat(String a, DokterTambahObat doktertambahobat) {
        obat = new obat();
        user = new user();
        username = a;
        this.doktertambahobat = new DokterTambahObat();
        this.doktertambahobat.setVisible(true);
        this.doktertambahobat.setLocationRelativeTo(null);
        this.doktertambahobat.setResizable(false);
        this.doktertambahobat.setNamaDok(username);
        this.doktertambahobat.pasienB().setEnabled(false);
        this.doktertambahobat.berandaB().setEnabled(false);
        this.doktertambahobat.obatB().setEnabled(false);
        this.doktertambahobat.simpanListener(new tambahDataObatDokter());
        this.doktertambahobat.kembaliListener(new kembalidaritambahdokter());
        this.doktertambahobat.keluarya(new keluartambahdok());
        this.doktertambahobat.karyawanListener(new inputkekar());
    }

    public cObat(int a, String b, int c) {
        obat = new obat();
        dokterubahobat = new DokterUbahObat();
        username = b;
        idObat = a;
        System.out.println("INI ID OBATNA " + idObat);
        dokterubahobat.setVisible(true);
        dokterubahobat.setResizable(false);
        dokterubahobat.setLocationRelativeTo(null);
        dokterubahobat.berandaB().setEnabled(false);
        dokterubahobat.pasienB().setEnabled(false);
        dokterubahobat.setNamaAdmin(username);
        dokterubahobat.setNama(obat.getNamaObat(idObat));
        System.out.println(obat.getStok(idObat));
        dokterubahobat.setJumlah(Integer.valueOf(obat.getStok(idObat)));
        dokterubahobat.simpan(new simpanUbahObatdokter());
        dokterubahobat.mbalekListener(new batalubahobatdokter());
        dokterubahobat.keluaroi(new keluarubahdok());
        dokterubahobat.karyawanListener(new ubahkekar());
    }

    //==============================ADMIN============================================
    public cObat(String a) {
        obat = new obat();
        user = new user();
        daftarobat = new AdminDataObat();
        username = a;
        daftarobat.setVisible(true);
        daftarobat.setResizable(false);
        daftarobat.setLocationRelativeTo(null);
        daftarobat.setUser(username);
        daftarobat.setObat(obat.bacaDaftarObat());
        daftarobat.ubah().setEnabled(false);
        daftarobat.obatB().setEnabled(false);
        daftarobat.tableListener(new setSelectedObat());
        daftarobat.ubahObat(new ubahdata());
        daftarobat.tambah(new menutambahobat());
        daftarobat.berandaListener(new obatkeberandaadmin());
        daftarobat.pasienListener(new obatkepasienadmin());
        daftarobat.cari(new cariobatadmin());
    }

    public cObat(int a, String b) {
        obat = new obat();
        ubahdataobat = new adminubah();
        username = b;
        idObat = a;
        System.out.println("INI ID OBATNA " + idObat);
        ubahdataobat.setVisible(true);
        ubahdataobat.setResizable(false);
        ubahdataobat.setLocationRelativeTo(null);
        ubahdataobat.berandaB().setEnabled(false);
        ubahdataobat.pasienB().setEnabled(false);
        ubahdataobat.setNamaAdmin(username);
        ubahdataobat.setNama(obat.getNamaObat(idObat));
        System.out.println(obat.getStok(idObat));
        ubahdataobat.setJumlah(Integer.valueOf(obat.getStok(idObat)));
        ubahdataobat.simpanListener(new simpanUbahObat());
        ubahdataobat.backListener(new batalubahobatadmin());
    }

    public cObat(int a, String b, admintambah tambah) {
        obat = new obat();
        this.tambah = new admintambah();
        username = b;
        idObat = a;
        System.out.println("INI ID OBATNA " + idObat);
        this.tambah.setVisible(true);
        this.tambah.setResizable(false);
        this.tambah.setLocationRelativeTo(null);
        this.tambah.setNamaAdmin(username);
        this.tambah.pasienB().setEnabled(false);
        this.tambah.berandaB().setEnabled(false);
        this.tambah.obatB().setEnabled(false);
        this.tambah.simpanListener(new tambahDataObat());
        this.tambah.kembaliListener(new kembalidaritambah());
    }

    private class obatkekar implements ActionListener {

        public obatkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            dokterobat.dispose();
            new cUser(1, username);
        }
    }

    private class inputkekar implements ActionListener {

        public inputkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(doktertambahobat, "Data yg Anda masukkan tidak akan tersimpan.Lanjutkan?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                doktertambahobat.dispose();
                new cUser(1, username);
            }
        }
    }
    
    private class ubahkekar implements ActionListener {

        public ubahkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterubahobat, "Data yg Anda masukkan tidak akan tersimpan.Lanjutkan?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterubahobat.dispose();
                new cUser(1, username);
            }
        }
    }

    private class keluardariobatdok implements ActionListener {

        public keluardariobatdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterobat, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterobat.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class keluartambahdok implements ActionListener {

        public keluartambahdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(doktertambahobat, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                doktertambahobat.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class keluarubahdok implements ActionListener {

        public keluarubahdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterubahobat, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterubahobat.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class refreshtabeldok implements ActionListener {

        public refreshtabeldok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterobat.setObat(obat.bacaDaftarObat());
            dokterobat.setCari("");
            dokterobat.refreshO().setEnabled(false);
        }
    }

    private class cariobatdokter implements ActionListener {

        public cariobatdokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterobat.refreshO().setEnabled(true);
            String nama = dokterobat.getCari();
            dokterobat.setObat(obat.bacaTabelObatCari(nama));
        }
    }

    private class cariobatadmin implements ActionListener {

        public cariobatadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = daftarobat.getCari();
            daftarobat.setObat(obat.bacaTabelObatCari(nama));
        }
    }

    private class kembalidaritambah implements ActionListener {

        public kembalidaritambah() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showOptionDialog(tambah, "Data yg Anda tambahkan tidak akan tersimpan. Kembali ke daftar obat?", "Kembali", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (pilihan == JOptionPane.YES_OPTION) {
                tambah.dispose();
                new cObat(username);
            }
        }
    }

    private class kembalidaritambahdokter implements ActionListener {

        public kembalidaritambahdokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showOptionDialog(doktertambahobat, "Data yg Anda tambahkan tidak akan tersimpan. Kembali ke daftar obat?", "Kembali", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (pilihan == JOptionPane.YES_OPTION) {
                doktertambahobat.dispose();
                new cObat(username, 2);
            }
        }
    }

    private class batalubahobatadmin implements ActionListener {

        public batalubahobatadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(ubahdataobat, "Data yg Anda ubah tidak akan tersimpan. Kembali ke daftar obat?");
            if (pilihan == JOptionPane.YES_OPTION) {
                ubahdataobat.dispose();
                new cObat(username);
            }
        }
    }

    private class batalubahobatdokter implements ActionListener {

        public batalubahobatdokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(dokterubahobat, "Data yg Anda ubah tidak akan tersimpan. Kembali ke daftar obat?");
            if (pilihan == JOptionPane.YES_OPTION) {
                dokterubahobat.dispose();
                new cObat(username, 2);
            }
        }
    }

    private class obatkepasienadmin implements ActionListener {

        public obatkepasienadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            daftarobat.dispose();
            new cPasien(username);
        }
    }

    private class obatkepasiendokter implements ActionListener {

        public obatkepasiendokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterobat.dispose();
            new cPasien(username, 2, 1);
        }
    }

    private class obatkeberandaadmin implements ActionListener {

        public obatkeberandaadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            daftarobat.dispose();
            AdminHome admin = new AdminHome();
            new cUser(username, admin);
        }
    }

    private class obatkeberandadokter implements ActionListener {

        public obatkeberandadokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterobat.dispose();
            DokterHome dokter = new DokterHome();
            new cUser(username, dokter);
        }
    }

    private class tambahDataObat implements ActionListener {

        public tambahDataObat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = tambah.getNama();
            String ang = tambah.getJumlah();
            if (nama.equals("") || ang.equals("0")) {
                JOptionPane.showMessageDialog(tambah, "Isi data obat dengan benar");
            } else {
                boolean t = obat.tambahObat(idObat, nama, Integer.valueOf(ang));
                JOptionPane.showMessageDialog(tambah, "Data obat sudah diatambahkan!");
                tambah.dispose();
                new cObat(username);
            }
        }
    }

    private class tambahDataObatDokter implements ActionListener {

        public tambahDataObatDokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = doktertambahobat.getNama();
            String ang = doktertambahobat.getJumlah();
            if (nama.equals("") || ang.equals("0")) {
                JOptionPane.showMessageDialog(doktertambahobat, "Isi data obat dengan benar");
            } else {
                boolean t = obat.tambahObat(idObat, nama, Integer.valueOf(ang));
                JOptionPane.showMessageDialog(doktertambahobat, "Data obat sudah diatambahkan!");
                doktertambahobat.dispose();
                new cObat(username, 2);
            }
        }
    }

    private class menutambahobat implements ActionListener {

        public menutambahobat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            daftarobat.dispose();
            admintambah tambah = new admintambah();
            new cObat(idObat, username, tambah);
        }
    }

    private class menutambahobatdokter implements ActionListener {

        public menutambahobatdokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterobat.dispose();
            DokterTambahObat tambah = new DokterTambahObat();
            new cObat(username, tambah);
        }
    }

    private class simpanUbahObat implements ActionListener {

        public simpanUbahObat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nambah = ubahdataobat.getJumlah();
            System.out.println(nambah + " INI STOK BARUNYA");
            boolean a = obat.ubahStokObat(idObat, Integer.valueOf(nambah));
            JOptionPane.showMessageDialog(ubahdataobat, "Stok sudah diupdate!");
            ubahdataobat.dispose();
            System.out.println("ini usernamenya " + username);
            new cObat(username);

        }
    }

    private class simpanUbahObatdokter implements ActionListener {

        public simpanUbahObatdokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nambah = dokterubahobat.getJumlah();
            System.out.println(nambah + " INI STOK BARUNYA");
            boolean a = obat.ubahStokObat(idObat, Integer.valueOf(nambah));
            JOptionPane.showMessageDialog(dokterubahobat, "Stok sudah diupdate!");
            dokterubahobat.dispose();
            System.out.println("ini usernamenya " + username);
            new cObat(username, 2);

        }
    }

    private class ubahdata implements ActionListener {

        public ubahdata() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            daftarobat.dispose();
            new cObat(idObat, username);
        }
    }

    private class ubahdatadok implements ActionListener {

        public ubahdatadok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterobat.dispose();
            new cObat(idObat, username, 9);
        }
    }

    private class setSelectedObat implements MouseListener {

        public setSelectedObat() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            daftarobat.ubah().setEnabled(true);
            int baris = daftarobat.getTabel().getSelectedRow();
            String ayam = daftarobat.getTabel().getValueAt(baris, 0).toString();
            System.out.println("obatnya=== " + ayam);
            int c = obat.getID(ayam);
            System.out.println("IDNYA adalah==== " + c);
            daftarobat.ubah().setEnabled(true);
            idObat = c;

        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>
    }

    private class setSelectedObatDokter implements MouseListener {

        public setSelectedObatDokter() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            dokterobat.ubah().setEnabled(true);
            int baris = dokterobat.getTabel().getSelectedRow();
            String ayam = dokterobat.getTabel().getValueAt(baris, 0).toString();
            System.out.println("obatnya=== " + ayam);
            int c = obat.getID(ayam);
            System.out.println("IDNYA adalah==== " + c);
            dokterobat.ubah().setEnabled(true);
            idObat = c;

        }

        //<editor-fold defaultstate="collapsed" desc="comment">
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//</editor-fold>
    }
}
