/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.user;
import controller.cPasien;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.pasien;
import view.AdminDataObat;
import view.AdminHome;
import view.AdminDataObat;
import view.DokterDataKaryawan;
import view.login;
import view.DokterHome;
import view.DokterPeriksa;
import view.DokterUbahKaryawan;
import view.DokterTambahKaryawan;

/**
 *
 * @author Dheta
 */
public class cUser {

    private login login;
    private AdminHome admin;
    private AdminDataObat dataobatadmin;
    private user user;
    private pasien pasien;
    private cPasien cPasien;
    private DokterHome dokter;
    private DokterPeriksa dokterperiksa;
    private DokterDataKaryawan datakaryawan;
    private DokterUbahKaryawan ubahkaryawan;
    private DokterTambahKaryawan tambahkaryawan;
    int idPeriksa;
    String username, unamekaryawan;

    public cUser() {

    }
//
//    public cUser(int a) {
//        user = new user();
//        login = new login();
//        login.setVisible(true);
//        login.setResizable(false);
//        login.setLocationRelativeTo(null);
//      //  login.loginListener(new loginListener());
//       // loginListener2(evt,login.getUsername(),login.getPassword());
//         
//
//    }
//    
    //login
    public cUser(int a) {
        user = new user();
        login = new login();
        login.setVisible(true);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
      //  login.loginListener(new loginListener());
        //loginListener2(evt,login.getUsername(),login.getPassword());
         
        System.out.println("xxx");
    }
    
     

    private static String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private class loginListener implements ActionListener {

        public loginListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = login.getUsername();
            String password = login.getPassword();
            if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(login, "Username atau Password tidak boleh kosong");
            } else {
                int level = user.login(username, password);
                if (level == 0) {
                    JOptionPane.showMessageDialog(login, "Username atau password salah");
                } else if (level == 1) {

                    System.out.println(username);
                    //String a=user.getNama(username);
                    new cUser(user.getNama(username), dokter);
                    System.out.println("COBA INI JUGA YAA = " + user.getNama(username));

                    login.dispose();
                    JOptionPane.showMessageDialog(dokter, "Selamat datang, " + user.getNamaSession(username));
                } else if (level == 2) {
                    login.dispose();
                    new cUser(user.getNamaSession(username), admin);
                    JOptionPane.showMessageDialog(admin, "Selamat datang, " + user.getNamaSession(username));
                }
            }
        }
    }

    public void loginListener2(java.awt.event.KeyEvent evt, String a, String b) {
        user = new user();
        login = new login();
        username=a;

        if (username.equalsIgnoreCase("") || b.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(login, "Username atau Password tidak boleh kosong");
        } else {

            int level = user.login(username, b);
            if (level == 0) {
                JOptionPane.showMessageDialog(login, "Username atau password salah");
            } else if (level == 1) {
                System.out.println("exit");
                 login.disable();
                System.out.println("YEEE BERHASIL ENTER");
                System.out.println(username);
                new cUser(user.getNama(username), dokter);
                System.out.println("COBA INI JUGA YAA = " + user.getNama(username));
                JOptionPane.showMessageDialog(dokter, "Selamat datang, " + user.getNamaSession(username));
               
              
            } else if (level == 2) {
                login.dispose();
                new cUser(user.getNamaSession(username), admin);
                JOptionPane.showMessageDialog(admin, "Selamat datang, " + user.getNamaSession(username));
                login.dispose();
            }

        }
    }

    //=======================================================================================================================//
    //----------------------------------------------ADMIN--------------------------------------//
    //beranda admin
    public cUser(String a, AdminHome admin) {
        user = new user();
        pasien = new pasien();
        this.admin = new AdminHome();
        this.admin.setVisible(true);
        this.admin.setResizable(false);
        this.admin.setLocationRelativeTo(null);
        username = a;

        this.admin.setNama(username);
        this.admin.berandaB().setEnabled(false);
        this.admin.setAntrian(pasien.daftarAntrian());
        this.admin.tambahAntrian(new pasienListener());
        this.admin.pasienListener(new pasienListener());
        this.admin.obatListener(new obatAdminListener());
        this.admin.logout(new keluaradmin());

    }

    private class keluaradmin implements ActionListener {

        public keluaradmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokter, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                admin.dispose();
                username = "";
                //new cUser(1,java.awt.event.KeyEvent evt);
            }
        }
    }

    private class obatAdminListener implements ActionListener {

        public obatAdminListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            admin.dispose();
            AdminDataObat dataobatadmin = new AdminDataObat();
            new cObat(username);
        }
    }

    private class pasienListener implements ActionListener {

        public pasienListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cPasien(username);
            admin.dispose();
        }
    }
    //lihat data pasien admin

    //---------------------------------------------------DOKTER----------------------------------------//
    //beranda dokter
    public cUser(String a, DokterHome dokter) {
        user = new user();
        pasien = new pasien();
    
        this.dokter = new DokterHome();
        this.dokter.setVisible(true);
        this.dokter.setResizable(false);
        this.dokter.setLocationRelativeTo(null);
        username = a;
        System.out.println("INI NAMA DOKTERNYA= " + a);
        this.dokter.berandaB().setEnabled(false);
        this.dokter.setNama(username);
        this.dokter.setAntrian(pasien.daftarAntrian());
        this.dokter.setTanggal(cUser.getTanggal());
        System.out.println("INI JUMLAH HARI INI  " + pasien.countpasien());
        this.dokter.setJumlah(pasien.countpasien());
        this.dokter.periksa().setEnabled(false);
        this.dokter.tableListener(new selectedPeriksa());
        this.dokter.periksaPasien(new PasienPeriksa());
        this.dokter.dataPasien(new dataPasien());
        this.dokter.tambahantriListener(new dataPasien());
        this.dokter.dataObat(new obatdokter());
        this.dokter.logout(new keluardokter());
        this.dokter.refreshtabel(new refreshdok());
        this.dokter.dataKaryawan(new karyawan());

    }

    public cUser(int id, String a) {
        user = new user();
        datakaryawan = new DokterDataKaryawan();
        datakaryawan.setVisible(true);
        datakaryawan.setLocationRelativeTo(null);
        datakaryawan.setResizable(false);
        username = a;
        datakaryawan.setUser(username);
        datakaryawan.setKaryawan(user.bacaTabelUser());
        datakaryawan.ubahB().setEnabled(false);
        datakaryawan.hapusB().setEnabled(false);
        datakaryawan.tableListener(new setselecteduser());
        datakaryawan.ubahkaryawan(new keubahdata());
        datakaryawan.tambah(new tambah());
        datakaryawan.hapus(new hapusdata());
        datakaryawan.pasienListener(new karkepasien());
        datakaryawan.berandaListener(new karkeberanda());
        datakaryawan.obatListener(new karkeobat());
        datakaryawan.out(new karkeluar());

    }

    public cUser(String a, String b) {
        user = new user();
        ubahkaryawan = new DokterUbahKaryawan();
        ubahkaryawan.setVisible(true);
        ubahkaryawan.setLocationRelativeTo(null);
        ubahkaryawan.setResizable(false);
        username = a;
        unamekaryawan = b;
        ubahkaryawan.setNamaAdmin(username);
        ubahkaryawan.setNama(user.getNamaSession(unamekaryawan));
        ubahkaryawan.setUsername(unamekaryawan);
        ubahkaryawan.setPass(user.getPass(unamekaryawan));
        ubahkaryawan.mbalekListener(new kembalikedata());
        ubahkaryawan.simpan(new update());
        ubahkaryawan.pasienListener(new ubahkepas());
        ubahkaryawan.berandaListener(new ubahkeber());
        ubahkaryawan.obatListener(new ubahkeobat());
        ubahkaryawan.keluaroi(new ubahkeluar());
    }

    public cUser(String w, int o) {
        user = new user();
        username = w;
        tambahkaryawan = new DokterTambahKaryawan();
        tambahkaryawan.setLocationRelativeTo(null);
        tambahkaryawan.setResizable(false);
        tambahkaryawan.setVisible(true);
        tambahkaryawan.simpan(new tambahdata());
        tambahkaryawan.mbalekListener(new kembalikekar());
        tambahkaryawan.setNamaAdmin(username);
        tambahkaryawan.berandaListener(new tambahkeber());
        tambahkaryawan.pasienListener(new tambahkepas());
        tambahkaryawan.obatListener(new tambahkeobat());
        tambahkaryawan.keluaroi(new tambahkeluar());

    }

    private class karkeberanda implements ActionListener {

        public karkeberanda() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            datakaryawan.dispose();
            new cUser(username, dokter);
        }
    }

    private class tambahkeber implements ActionListener {

        public tambahkeber() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(tambahkaryawan, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                tambahkaryawan.dispose();
                new cUser(username, dokter);
            }
        }
    }

    private class ubahkeber implements ActionListener {

        public ubahkeber() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(ubahkaryawan, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                ubahkaryawan.dispose();
                new cUser(username, dokter);
            }
        }
    }

    private class karkepasien implements ActionListener {

        public karkepasien() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            datakaryawan.dispose();
            new cPasien(username, 1, 1);
        }
    }

    private class ubahkepas implements ActionListener {

        public ubahkepas() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(ubahkaryawan, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                ubahkaryawan.dispose();
                new cPasien(username, 1, 1);
            }
        }
    }

    private class tambahkepas implements ActionListener {

        public tambahkepas() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(tambahkaryawan, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                tambahkaryawan.dispose();
                new cPasien(username, 1, 1);
            }
        }
    }

    private class karkeobat implements ActionListener {

        public karkeobat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            datakaryawan.dispose();
            new cObat(username, 1);
        }
    }

    private class ubahkeobat implements ActionListener {

        public ubahkeobat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(ubahkaryawan, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                ubahkaryawan.dispose();
                new cObat(username, 1);
            }
        }
    }

    private class tambahkeobat implements ActionListener {

        public tambahkeobat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(tambahkaryawan, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                tambahkaryawan.dispose();
                new cObat(username, 1);
            }
        }
    }

    private class tambahkeluar implements ActionListener {

        public tambahkeluar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(tambahkaryawan, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                tambahkaryawan.dispose();
                username = "";
             //   new cUser(1);
            }
        }
    }

    private class ubahkeluar implements ActionListener {

        public ubahkeluar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(ubahkaryawan, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                ubahkaryawan.dispose();
                username = "";
               // new cUser(1);
            }
        }
    }

    private class karkeluar implements ActionListener {

        public karkeluar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(datakaryawan, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                datakaryawan.dispose();
                username = "";
            //    new cUser(1);
            }
        }
    }

    private class tambah implements ActionListener {

        public tambah() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            datakaryawan.dispose();
            new cUser(username, 9);
        }
    }

    private class keubahdata implements ActionListener {

        public keubahdata() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            datakaryawan.dispose();
            new cUser(username, unamekaryawan);
        }
    }

    private class update implements ActionListener {

        public update() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String usernamebaru = ubahkaryawan.getUsername();
            String pass = ubahkaryawan.getPass();
            String nama = ubahkaryawan.getNamanya();
            int cek = user.cek2(usernamebaru);
            if (cek == 1) {
                JOptionPane.showMessageDialog(ubahkaryawan, "Username sudah ada, buat username lain.");
            } else if (cek == 0) {
                boolean a = user.ubahdata(pass, usernamebaru, nama);
                JOptionPane.showMessageDialog(ubahkaryawan, "Data berhasil diperbarui");
                ubahkaryawan.dispose();
                new cUser(0, username);
            }
        }
    }

    private class tambahdata implements ActionListener {

        public tambahdata() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String usernamebaru = tambahkaryawan.getUsername();
            String pass = tambahkaryawan.getPass();
            String nama = tambahkaryawan.getNamanya();
            int cek = user.cek2(usernamebaru);
            if (cek == 1) {
                JOptionPane.showMessageDialog(tambahkaryawan, "Username sudah ada, buat username lain.");
            } else if (cek == 0) {
                boolean a = user.tambahUser(pass, usernamebaru, nama);
                JOptionPane.showMessageDialog(tambahkaryawan, "Data berhasil dimasukkan");
                tambahkaryawan.dispose();
                new cUser(0, username);
            }
        }
    }

    private class hapusdata implements ActionListener {

        public hapusdata() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String usernamebaru = unamekaryawan;
            System.out.println(usernamebaru + "adalah usernamenyaaaaaaa");
            int apa = JOptionPane.showOptionDialog(datakaryawan, "Apakah Anda yakin akan menghapus data user ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                boolean as = user.hapususer(usernamebaru);
                JOptionPane.showMessageDialog(datakaryawan, "Data berhasil dihapus");
                datakaryawan.setKaryawan(user.bacaTabelUser());

            }

        }
    }

    private class kembalikedata implements ActionListener {

        public kembalikedata() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(ubahkaryawan, "Data yg Anda ubah tidak akan tersimpan. Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                ubahkaryawan.dispose();
                new cUser(9, username);
            }
        }
    }

    private class kembalikekar implements ActionListener {

        public kembalikekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(tambahkaryawan, "Data yg Anda masukkan tidak akan tersimpan. Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                tambahkaryawan.dispose();
                new cUser(9, username);
            }
        }
    }

    //method memilih data aktif yg ada di tabel
    private class setselecteduser implements MouseListener {

        public setselecteduser() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            datakaryawan.ubahB().setEnabled(true);
            datakaryawan.hapusB().setEnabled(true);
            int baris = datakaryawan.getTabel().getSelectedRow();
            String ayam = datakaryawan.getTabel().getValueAt(baris, 1).toString();
            System.out.println("INI KARYAWAN " + ayam);
            unamekaryawan = ayam;

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

    private class karyawan implements ActionListener {

        public karyawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokter.dispose();
            new cUser(1, username);
        }
    }

    private class refreshdok implements ActionListener {

        public refreshdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokter.setAntrian(pasien.daftarAntrian());
        }
    }

    private class keluardokter implements ActionListener {

        public keluardokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokter, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokter.dispose();
                username = "";
           //     new cUser(1);
            }
        }
    }

    private class obatdokter implements ActionListener {

        public obatdokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokter.dispose();
            new cObat(username, 2);
        }
    }

    private class dataPasien implements ActionListener {

        public dataPasien() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokter.dispose();
            new cPasien(username, 1, 1);
        }
    }

    private class selectedPeriksa implements MouseListener {

        public selectedPeriksa() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            dokter.periksa().setEnabled(true);
            int baris = dokter.antrian().getSelectedRow();
            String ayam = dokter.antrian().getValueAt(baris, 0).toString();
            idPeriksa = Integer.valueOf(ayam);
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

    private class PasienPeriksa implements ActionListener {

        public PasienPeriksa() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokter.dispose();
            new cPasien(2, username, idPeriksa);
            System.out.println(username);
            System.out.println("INI ID PERIKSA= " + idPeriksa);
        }
    }

}
