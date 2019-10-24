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
import model.pasien;
import model.user;
import controller.cUser;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.obat;
import view.AdminDaftarPasien;
import view.AdminLihatRMD;
import view.AdminHome;
import view.AdminTambahDataPeriksa;
import view.AdminTambahPasien;
import view.AdminDataObat;
import view.AdminUbahPasien;
import view.DokterDaftarPasien;
import view.DokterDataObat;
import view.DokterHome;
import view.DokterIsiResep;
import view.DokterPeriksa;
import view.DokterPeriksa2;
import view.DokterPeriksaFinal;
import view.DokterTambahPasien;
import view.adtambahperiksa;
import view.DokterLihatRMD;
import view.DokterUbahObat;
import view.DokterUbahPasien;

/**
 *
 * @author Dheta
 */
public class cPasien {

    String username;

    private cUser cUser;
    private cObat cObat;
    private user user;
    private pasien pasien;
    private obat obat;
    private AdminHome admin;
    private DokterHome dokter;
    private AdminDaftarPasien pasienAdmin;
    private AdminLihatRMD rmdAdmin;
    private AdminTambahDataPeriksa dataperiksaAdmin;
    private AdminTambahPasien tambahpasien;
    private adtambahperiksa atamper;
    private AdminDataObat dataobatadmin;
    private AdminUbahPasien ubahpasienadmin;
    private DokterPeriksa dokterperiksa;
    private DokterPeriksa2 dokterperiksa2;
    private DokterDaftarPasien dokterdaftarpasien;
    private DokterIsiResep dokterresep;
    private DokterTambahPasien doktertambahpasien;
    private DokterPeriksaFinal dokterfinal;
    private DokterLihatRMD dokterrmd;
    private DokterUbahPasien dokterubah;

    int idPasien, ayam, idRMD, harga, idResep;

    public cPasien() {

    }

    //========================DOKTER============================================
    //dokter mulai periksa dan update rmd pasien (pemeriksaan tambahan, khusus, diagnosa, dsb.)
    public cPasien(int e, String l, int d) {
        user = new user();
        pasien = new pasien();
        obat = new obat();
        dokterperiksa = new DokterPeriksa();
        username = l;
        idRMD = d;
        dokterperiksa.setVisible(true);
        dokterperiksa.setResizable(false);
        dokterperiksa.setLocationRelativeTo(null);
        dokterperiksa.setNama(username);
        dokterperiksa.setPekerjaan(pasien.getKerjaRMD(idRMD));
        dokterperiksa.setAlamat(pasien.getAlamatRMD(idRMD));
        dokterperiksa.setUsia(pasien.getUsiaRMD(idRMD));
        dokterperiksa.setNamaPasien(pasien.getNamaRMD(idRMD));
        dokterperiksa.setAnamnesa(pasien.getAnamnesa(idRMD));
        dokterperiksa.setNadi(pasien.getNadi(idRMD));
        dokterperiksa.setTensi(pasien.getTensi(idRMD));
        dokterperiksa.setSuhu(pasien.getSuhu(idRMD));
        dokterperiksa.setRR(pasien.getRR(idRMD));
        dokterperiksa.keluarya(new keluardariperiksa1());
        dokterperiksa.simpanData(new simpanRMDDokter());//nyimpen data periksa pasien
        dokterperiksa.karyawanListener(new periksakekaryawan());
        dokterperiksa.obatB().setEnabled(false);
        dokterperiksa.berandaB().setEnabled(false);
        dokterperiksa.pasienB().setEnabled(false);
    }

    //dokter lihat daftar pasien yg terdaftar
    public cPasien(String g, int l, int y) {
        user = new user();
        pasien = new pasien();
        dokterdaftarpasien = new DokterDaftarPasien();
        username = g;
        dokterdaftarpasien.setVisible(true);
        dokterdaftarpasien.setResizable(false);
        dokterdaftarpasien.setLocationRelativeTo(null);
        dokterdaftarpasien.setNama(username);
        dokterdaftarpasien.pasien().setEnabled(false);
        dokterdaftarpasien.setTabelPasien(pasien.bacaTabelPasien());
        dokterdaftarpasien.berandaListener(new berandadaripasiendok());
        dokterdaftarpasien.obatListener(new obatdaripasiendok());
        dokterdaftarpasien.tambahListener(new tambahPasienDokter());
        dokterdaftarpasien.cariButtonListener(new cariPasienDokter());
        dokterdaftarpasien.detailListener(new lihatRMDPasienDokter());
        dokterdaftarpasien.detail().setEnabled(false);
        dokterdaftarpasien.tableListener(new setSelectedPasienDokter());
        dokterdaftarpasien.refreshB().setEnabled(false);
        dokterdaftarpasien.refreshtabel(new dokrefreshcari());
        dokterdaftarpasien.keluardok(new keluardaripasiendok());
        dokterdaftarpasien.karyawanListener(new daftarpasienkekar());
    }

    //lihat rmd pasien
    public cPasien(String p, DokterLihatRMD dokterrmd, int o) {
        user = new user();
        pasien = new pasien();
        username = p;
        idPasien = o;
        this.dokterrmd = new DokterLihatRMD();
        this.dokterrmd.setVisible(true);
        this.dokterrmd.setResizable(false);
        this.dokterrmd.setLocationRelativeTo(null);
        this.dokterrmd.pasienB().setEnabled(false);
        this.dokterrmd.setNama(username);
        this.dokterrmd.pasienB().setEnabled(false);
        this.dokterrmd.obatB().setEnabled(false);
        this.dokterrmd.setTabelRMD(pasien.bacaRMDPasien(idPasien));
        this.dokterrmd.setIDPasien(Integer.toString(idPasien));
        this.dokterrmd.setNamaPasien(pasien.getNama(idPasien));
        this.dokterrmd.setJenisKelamin(pasien.getJenisKelamin(idPasien));
        this.dokterrmd.setAlamat(pasien.getAlamat(idPasien));
        this.dokterrmd.setTglLahir(pasien.getTglLahir(idPasien));
        this.dokterrmd.setUsia(pasien.getUsia(idPasien));
        this.dokterrmd.setTelpon(pasien.getNoTelp(idPasien));
        this.dokterrmd.setPekerjaan(pasien.getPekerjaan(idPasien));
        this.dokterrmd.karyawanListener(new rmdkekar());
        this.dokterrmd.kembaliListener(new dokterkembaliKePasien());
        this.dokterrmd.keluaroi(new keluardarirmddok());
        if (pasien.getKeterangan(idPasien).equals("nggapleki")) {
            this.dokterrmd.tag().setBackground(Color.red);
        } else if (pasien.getKeterangan(idPasien).equals("rodok nggapleki")) {
            this.dokterrmd.tag().setBackground(Color.yellow);
        } else if (pasien.getKeterangan(idPasien).equals("aman")) {
            this.dokterrmd.tag().setBackground(Color.green);
        }

        ayam = idPasien;
        System.out.println(ayam + "WEEEEEEE");

        this.dokterrmd.ubahListener(new dokterkeubah());
        this.dokterrmd.tambahListener(new tambahperiksadok());
    }

    //ubah data pasien
    public cPasien(String l, int z, DokterUbahPasien dokterubah) {
        user = new user();
        pasien = new pasien();
        username = l;
        idPasien = z;
        System.out.println("ID PASIENNYA ADLAHA " + idPasien);
        this.dokterubah = new DokterUbahPasien();
        this.dokterubah.setVisible(true);
        this.dokterubah.setResizable(false);
        this.dokterubah.setLocationRelativeTo(null);
        this.dokterubah.pasienB().setEnabled(false);
        this.dokterubah.setNama(username);
        this.dokterubah.pasienB().setEnabled(false);
        this.dokterubah.obatB().setEnabled(false);
        this.dokterubah.karyawanListener(new ubahpakekar());
        this.dokterubah.setIDPasien(Integer.toString(idPasien));
        this.dokterubah.setNamaPasien(pasien.getNama(idPasien));
        this.dokterubah.setJK(pasien.getJenisKelamin(idPasien));
        this.dokterubah.setAlamat(pasien.getAlamat(idPasien));
        this.dokterubah.setTglLhir(pasien.getTglLahir(idPasien));
        this.dokterubah.setPekerjaan(pasien.getPekerjaan(idPasien));
        this.dokterubah.setTelpon(pasien.getNoTelp(idPasien));
        this.dokterubah.nyimpenData(new dokterubahdata());
        this.dokterubah.berandaListener(new ubahkeberanda());
        this.dokterubah.keluarListener(new ubahkeluar());
    }

    //dokter tambah pasien baru
    public cPasien(String l, String o, int u) {
        user = new user();
        pasien = new pasien();
        doktertambahpasien = new DokterTambahPasien();
        username = l;
        doktertambahpasien.setVisible(true);
        doktertambahpasien.setLocationRelativeTo(null);
        doktertambahpasien.setResizable(false);
        doktertambahpasien.setNamaAdmin(username);
        doktertambahpasien.tambahData(new tambahpasiendok());
        doktertambahpasien.keluaroi(new keluardaritambahdok());
        doktertambahpasien.obatB().setEnabled(false);
        doktertambahpasien.karyawanListener(new tambahpakekar());
        doktertambahpasien.pasienB().setEnabled(false);
        doktertambahpasien.mbalek(new kembalidaritambahdok());
        doktertambahpasien.berandaListener(new berandadaritambahdok());
        doktertambahpasien.karyawanB().setEnabled(false);
    }

    //ini dokter periksa dari hasil inputan pasien sendiri, jadi periksa semuanya sendiri
    public cPasien(int q, String z) {
        user = new user();
        pasien = new pasien();
        obat = new obat();
        username = z;
        int pas = q;
        // int last = pasien.getLastRMD();
        idRMD = q;
        System.out.println("INI ID TERAKHIR " + idRMD);
        dokterperiksa2 = new DokterPeriksa2();
        dokterperiksa2.setVisible(true);
        dokterperiksa2.setLocationRelativeTo(null);
        dokterperiksa2.setResizable(false);
        dokterperiksa2.setNama(username);
        dokterperiksa2.simpanData(new simpanperiksadokter());
        dokterperiksa2.setNamaPasien(pasien.getNamaRMD(idRMD));
        dokterperiksa2.setUsia(pasien.getUsiaRMD(idRMD));
        dokterperiksa2.karyawanya(new periksa2kekar());
        dokterperiksa2.setAlamat(pasien.getAlamatRMD(idRMD));
        dokterperiksa2.setKerja(pasien.getKerjaRMD(idRMD));
        dokterperiksa2.berandaya(new periksa2keber());
        dokterperiksa2.pasienya(new periksa2kepas());
        dokterperiksa2.obatya(new periksa2keobat());
    }

    //dokter masukin resep obat
    public cPasien(String a, int c, double d, int l) {
        user = new user();
        pasien = new pasien();
        obat = new obat();
        username = a;
        dokterresep = new DokterIsiResep();
        dokterresep.setVisible(true);
        dokterresep.setResizable(false);
        dokterresep.setLocationRelativeTo(null);
        dokterresep.setUser(username);
        dokterresep.setIDRMD(pasien.getNamaRMD(c));
        idRMD = c;
        System.out.println("INI ID RESEPNYA====== " + l);
        idResep = l;
        dokterresep.tambahkeresep(new tambahObatKeResep());
        dokterresep.selesairesep(new selesaiBuatResep());
        dokterresep.karyawanListener(new resepkekar());
        dokterresep.pasienListener(new resepkepasien());
        dokterresep.berandaListener(new resepkeberanda());
        dokterresep.obatListener(new resepkeobat());
        dokterresep.keluarListener(new resepkeluar());

    }

    private static String getTanggal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    //final periksa dokter
    public cPasien(int a, double o, int k, String j) {
        user = new user();
        pasien = new pasien();
        obat = new obat();
        idRMD = k;
        idResep = a;
        username = j;
        System.out.println("INI ID RMDNYA ======= " + k);
        dokterfinal = new DokterPeriksaFinal();
        dokterfinal.setVisible(true);
        dokterfinal.setResizable(false);
        dokterfinal.setLocationRelativeTo(null);
        //dokterfinal.setNama(pasien.getNamaRMD(idRMD));
        dokterfinal.setUsername(username);
        dokterfinal.setAlamat(pasien.getAlamatRMD(idRMD));
        dokterfinal.setNama(pasien.getNamaRMD(idRMD));
        dokterfinal.setUmur(pasien.getUsiaRMD(idRMD));
        dokterfinal.setTanggal(cPasien.getTanggal());
        dokterfinal.setAnamnesa(pasien.getAnamnesa(idRMD));
        dokterfinal.setSuhu(pasien.getSuhu(idRMD));
        dokterfinal.setTensi(pasien.getTensi(idRMD));
        dokterfinal.setRR(pasien.getRR(idRMD));
        dokterfinal.setNadi(pasien.getNadi(idRMD));
        dokterfinal.setDiagnosa(pasien.getDiagnosa(idRMD));
        dokterfinal.setKhusus(pasien.getKhusus(idRMD));
        dokterfinal.setTambahan(pasien.getTambahan(idRMD));
        dokterfinal.setIDRMD(String.valueOf(idRMD));
        dokterfinal.setTabelResep(obat.lihatResep(idResep));
        dokterfinal.selesaiperiksa(new selesaidokter());
        dokterfinal.keluarok(new keluardarifinal());
        dokterfinal.karyawanListener(new finalkekar());
        dokterfinal.berandaB().setEnabled(false);
        dokterfinal.obatB().setEnabled(false);
        dokterfinal.pasienB().setEnabled(false);
    }

    private class tambahperiksadok implements ActionListener {

        public tambahperiksadok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterrmd.dispose();
            boolean ap = pasien.tambahRMDDokter1(idPasien);
            new cPasien(pasien.getLastRMD(), username);

        }
    }

    private class periksa2keber implements ActionListener {

        public periksa2keber() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterperiksa2, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa2.dispose();
                new cUser(username, dokter);
            }
        }
    }

    private class periksa2kepas implements ActionListener {

        public periksa2kepas() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterperiksa2, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa2.dispose();
                new cPasien(username, 1, 1);
            }
        }
    }

    private class periksa2keobat implements ActionListener {

        public periksa2keobat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterperiksa2, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa2.dispose();
                new cObat(username, 1);
            }
        }
    }

    private class periksakekaryawan implements ActionListener {

        public periksakekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterperiksa, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa.dispose();
                new cUser(1, username);
            }
        }
    }

    private class ubahpakekar implements ActionListener {

        public ubahpakekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterubah, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterubah.dispose();
                new cUser(1, username);
            }
        }
    }

    private class rmdkekar implements ActionListener {

        public rmdkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterrmd.dispose();
            new cUser(1, username);
        }
    }

    private class tambahpakekar implements ActionListener {

        public tambahpakekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(doktertambahpasien, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                doktertambahpasien.dispose();
                new cUser(8, username);
            }
        }
    }

    private class periksa2kekar implements ActionListener {

        public periksa2kekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterperiksa2, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa2.dispose();
                new cUser(1, username);
            }
        }
    }

    private class resepkekar implements ActionListener {

        public resepkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterresep, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterresep.dispose();
                new cUser(1, username);
            }
        }
    }

    private class daftarpasienkekar implements ActionListener {

        public daftarpasienkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterdaftarpasien.dispose();
            new cUser(1, username);
        }
    }

    private class finalkekar implements ActionListener {

        public finalkekar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterfinal, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterfinal.dispose();
                new cUser(1, username);
            }
        }
    }

    private class ubahkeberanda implements ActionListener {

        public ubahkeberanda() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterubah, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterubah.dispose();
                new cUser(username, dokter);
            }
        }
    }

    private class resepkepasien implements ActionListener {

        public resepkepasien() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterresep, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterresep.dispose();
                new cPasien(username, 1, 1);
            }
        }
    }

    private class resepkeberanda implements ActionListener {

        public resepkeberanda() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterresep, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterresep.dispose();
                new cUser(username, dokter);
            }
        }
    }

    private class resepkeobat implements ActionListener {

        public resepkeobat() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterresep, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterresep.dispose();
                new cObat(username, 1);
            }
        }
    }

    private class resepkeluar implements ActionListener {

        public resepkeluar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterresep, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterresep.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class ubahkeluar implements ActionListener {

        public ubahkeluar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterubah, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterubah.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    //logout dari pasien
    private class keluardaripasiendok implements ActionListener {

        public keluardaripasiendok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(dokterdaftarpasien, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterdaftarpasien.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    //logout dari pasien
    private class keluardaridokter implements ActionListener {

        public keluardaridokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterdaftarpasien, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterdaftarpasien.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    //logout dari rmd
    private class keluardarirmddok implements ActionListener {

        public keluardarirmddok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterrmd, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterrmd.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class berandadaritambahdok implements ActionListener {

        public berandadaritambahdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(doktertambahpasien, "Data yang Anda masukkan belum tersimpan. Tetap kembali? ", " Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                doktertambahpasien.dispose();
                new cUser(username, dokter);
            }
        }
    }

    //logout dari periksa1
    private class kembalidaritambahdok implements ActionListener {

        public kembalidaritambahdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showConfirmDialog(doktertambahpasien, "Data yang Anda ketik belum tersimpan. Tetap kembali? ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (apa == JOptionPane.YES_OPTION) {
                doktertambahpasien.dispose();
                new cPasien(username, 2, 1);
            }
        }
    }

    //logout dari periksa1
    private class keluardariperiksa1 implements ActionListener {

        public keluardariperiksa1() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterperiksa, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    //logout dari periksa2
    private class keluardariperiksa2 implements ActionListener {

        public keluardariperiksa2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterperiksa2, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterperiksa2.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    //logout dari final
    private class keluardarifinal implements ActionListener {

        public keluardarifinal() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(dokterfinal, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                dokterfinal.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class keluardaritambahdok implements ActionListener {

        public keluardaritambahdok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int apa = JOptionPane.showOptionDialog(doktertambahpasien, "Apakah Anda ingn keluar?", "Logout", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                doktertambahpasien.dispose();
                username = "";
                new cUser(1);
            }
        }
    }

    private class obatdaripasiendok implements ActionListener {

        public obatdaripasiendok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterdaftarpasien.dispose();
            new cObat(username, 8);
        }
    }

    private class berandadaripasiendok implements ActionListener {

        public berandadaripasiendok() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterdaftarpasien.dispose();
            new cUser(username, dokter);
        }
    }

    private class dokrefreshcari implements ActionListener {

        public dokrefreshcari() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterdaftarpasien.setTabelPasien(pasien.bacaTabelPasien());
            dokterdaftarpasien.setCari("");
        }
    }

    private class dokterkeubah implements ActionListener {

        public dokterkeubah() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterrmd.dispose();
            new cPasien(username, idPasien, dokterubah);
        }
    }

    private class dokterubahdata implements ActionListener {

        public dokterubahdata() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = dokterubah.getNama();
            String alamat = dokterubah.getAlamat();
            String notelp = dokterubah.getTelepon();
            String keterangan = dokterubah.getKeterangan();
            String pekerjaan = dokterubah.getPekerjaan();
            boolean k = pasien.ubahdatapasien(idPasien, nama, alamat, notelp, pekerjaan, keterangan);
            if (k) {
                JOptionPane.showMessageDialog(dokterubah, "Data pasien berhasil diperbarui");
                dokterubah.dispose();
                new cPasien(username, dokterrmd, idPasien);
            } else {
                JOptionPane.showMessageDialog(dokterubah, "Maap ada yg salah");
            }

        }

    }

    private class simpanperiksadokter implements ActionListener {

        public simpanperiksadokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("======= INI ID RMDNYA LHO " + idRMD);
            String anamnesa = dokterperiksa2.getAnamnesa();
            System.out.println("anamnya ini===== " + anamnesa);
            String diagnosa = dokterperiksa2.getDiagnosa();
            String khusus = dokterperiksa2.getKhusus();
            String tambahan = dokterperiksa2.getTambahan();
            String tensi = dokterperiksa2.getTensi();
            String nadi = dokterperiksa2.getNadi();
            String rr = dokterperiksa2.getRR();
            String suhu = dokterperiksa2.getSuhu();

            if (anamnesa.equalsIgnoreCase("") || diagnosa.equalsIgnoreCase("") || tensi.equalsIgnoreCase("")
                    || suhu.equalsIgnoreCase("") || rr.equalsIgnoreCase("") || nadi.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(tambahpasien, "Data harus diisi dengan lengkap");
            } else {
                boolean input = pasien.ubahRiwayatDokter(idRMD, anamnesa, tensi, rr, suhu, nadi, khusus, tambahan, diagnosa);
                if (input) {
                    int pilihan = JOptionPane.showConfirmDialog(dokterperiksa2, "Data periksa berhasil disimpan. Apakah pasien memerlukan resep obat? ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (pilihan == JOptionPane.NO_OPTION) {
                        String tarif = JOptionPane.showInputDialog("Masukkan tarif periksa pasien");
                        if (tarif.isEmpty()) {
                            System.out.println("kosong");
                        } else {
                            harga = Integer.valueOf(tarif);
                            boolean a = pasien.masukkanTarif(idRMD, harga);
                            if (a) {
                                JOptionPane.showMessageDialog(dokterperiksa2, "Pasien " + pasien.getNamaRMD(idRMD) + " telah selesai diperiksa.");
                                dokterperiksa2.dispose();
                                DokterHome dokter = new DokterHome();
                                new cUser(username, dokter);
                            } else {
                                System.out.println("Ada yg salah");
                            }
                        }
                    } else if (pilihan == JOptionPane.YES_OPTION) {
                        boolean b = obat.buatResep(idRMD);
                        if (b) {
                            idResep = Integer.valueOf(obat.getIDResep(idRMD));
                            dokterperiksa2.dispose();
                            new cPasien(username, idRMD, 0.2, idResep);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(dokterperiksa2, "Mohon maaf ada yg salah");
                }
            }
        }
    }

    private class tambahpasiendok implements ActionListener {

        public tambahpasiendok() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = doktertambahpasien.getNama();
            String alamat = doktertambahpasien.getAlamat();
            String notelepon = doktertambahpasien.getTelepon();
            String pekerjaan = doktertambahpasien.getPekerjaan();
            String jeniskelamin = doktertambahpasien.getJenisKelamin();
            Date tanggalLahir = doktertambahpasien.getTanggalLahir();
            String keterangan = doktertambahpasien.getKeterangan();

            if (nama.equalsIgnoreCase("") || alamat.equalsIgnoreCase("") || notelepon.equalsIgnoreCase("") || pekerjaan.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(doktertambahpasien, "Data harus diisi dengan lengkap");
            } else {
                boolean input = pasien.tambahPasien(nama, tanggalLahir, alamat, jeniskelamin, pekerjaan, notelepon, keterangan);
                //booelan tambahrmd=pasien.
                if (input) {
                    int pas = pasien.getID(nama);
                    System.out.println("=============== ");
                    System.out.println("ID NYA LAST ==!!!  " + pas);
                    boolean tambahrmd = pasien.tambahRMDDokter1(pas);
                    doktertambahpasien.dispose();
                    new cPasien(pasien.getLastRMD(), username);
                    JOptionPane.showMessageDialog(dokterperiksa2, "Masukkan data periksa pasien");
                } else {
                    JOptionPane.showMessageDialog(dokterperiksa2, "Mohon maaf ada yg salah");
                }
            }
        }
    }

    private class selesaidokter implements ActionListener {

        public selesaidokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String tarif = dokterfinal.getTarif();
            if (tarif.equals("")) {
                JOptionPane.showMessageDialog(dokterfinal, "Tarif minimal diisi 0");
            } else {
                System.out.println("INI TARIFNYA=== " + tarif);
                int pilihan = JOptionPane.showConfirmDialog(dokterresep, "Apakah pasien sudah selesai diperiksa? ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (pilihan == JOptionPane.YES_OPTION) {
                    boolean udah = pasien.masukkanTarif(idRMD, Integer.valueOf(tarif));
                    JOptionPane.showMessageDialog(dokterfinal, "Pasien sudah selesai diperiksa ya");
                    dokterfinal.dispose();
                    DokterHome dokter = new DokterHome();
                    new cUser(username, dokter);
                }
            }
        }
    }

    private class dokterkembaliKePasien implements ActionListener {

        public dokterkembaliKePasien() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterrmd.dispose();
            new cPasien(username, 3, 2);
        }
    }

    private class selesaiBuatResep implements ActionListener {

        public selesaiBuatResep() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int pilihan = JOptionPane.showConfirmDialog(dokterresep, "Apakah resep sudah selesai dibuat? ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                dokterresep.dispose();
                new cPasien(Integer.valueOf(idResep), 0.1, idRMD, username);
                System.out.println("IDRESEP= " + idResep);
                System.out.println("IDRMD= " + idRMD);
            }
        }
    }

    private class tambahObatKeResep implements ActionListener {

        public tambahObatKeResep() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("DISINI ID RESEPNYA ADALAH = " + idResep);
            int idobat = Integer.valueOf(dokterresep.getObat());
            String signa = dokterresep.getSigna();
            int stokskrg = Integer.valueOf(obat.getStok(idobat));
            int jumlah = Integer.valueOf(dokterresep.getJumlah());
            if (jumlah > stokskrg) {
                JOptionPane.showMessageDialog(dokterresep, "Stok tidak cukup");
            } else {
                String keterangan = dokterresep.getKeterangan();
                boolean f = obat.detailResep(idResep, idobat, jumlah, signa, keterangan);
                if (f) {
                    int stokbaru = stokskrg - jumlah;
                    boolean update = obat.ubahStokObat(idobat, stokbaru);
                    JOptionPane.showMessageDialog(dokterresep, "Obat sudah berhasil dimasukkan");
                    dokterresep.setTabel(obat.lihatResep(idResep));
                    dokterresep.setSigna("");
                    dokterresep.setJumlah(0);
                    dokterresep.setKet("");
                    System.out.println("DATA OBAT MASUK OK");
                } else {
                    System.out.println("ada yg kurang EEEEE");
                }
            }

        }
    }

    private class simpanRMDDokter implements ActionListener {

        public simpanRMDDokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("======= INI ID RMDNYA LHO " + idRMD);
            String anamnesa = dokterperiksa.getAnamnesa();
            System.out.println("anamnya ini===== " + anamnesa);
            String diagnosa = dokterperiksa.getDiagnosa();
            String khusus = dokterperiksa.getKhusus();
            String tambahan = dokterperiksa.getTambahan();
            String tensi = dokterperiksa.getTensi();
            String nadi = dokterperiksa.getNadi();
            String rr = dokterperiksa.getRR();
            String suhu = dokterperiksa.getSuhu();

            if (anamnesa.equalsIgnoreCase("") || diagnosa.equalsIgnoreCase("") || tensi.equalsIgnoreCase("")
                    || suhu.equalsIgnoreCase("") || rr.equalsIgnoreCase("") || nadi.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(tambahpasien, "Data harus diisi dengan lengkap");
            } else {
                boolean input = pasien.ubahRiwayatDokter(idRMD, anamnesa, tensi, rr, suhu, nadi, khusus, tambahan, diagnosa);
                if (input) {
                    int pilihan = JOptionPane.showConfirmDialog(dokterperiksa, "Data periksa berhasil disimpan. Apakah pasien memerlukan resep obat? ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (pilihan == JOptionPane.NO_OPTION) {
                        String tarif = JOptionPane.showInputDialog("Masukkan tarif periksa pasien");
                        if (tarif.isEmpty()) {
                            System.out.println("kosong");
                        } else {
                            harga = Integer.valueOf(tarif);
                            boolean a = pasien.masukkanTarif(idRMD, harga);
                            if (a) {
                                JOptionPane.showMessageDialog(dokterperiksa, "Pasien " + pasien.getNamaRMD(idRMD) + " telah selesai diperiksa.");
                                dokterperiksa.dispose();
                                DokterHome dokter = new DokterHome();
                                new cUser(username, dokter);
                            } else {
                                System.out.println("Ada yg salah");
                            }
                        }
                    } else if (pilihan == JOptionPane.YES_OPTION) {
                        boolean b = obat.buatResep(idRMD);
                        if (b) {
                            idResep = Integer.valueOf(obat.getIDResep(idRMD));
                            dokterperiksa.dispose();
                            new cPasien(username, idRMD, 0.2, idResep);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(dokterperiksa, "Mohon maaf ada yg salah");
                }
            }

        }
    }

    private class tambahPeriksaDokter implements ActionListener {

        public tambahPeriksaDokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterrmd.dispose();
            boolean tambahrmd = pasien.tambahRMDDokter1(ayam);
            System.out.println("ini idnya= " + ayam);
            new cPasien(ayam, username);
        }
    }

    //method untuk menambah data pasien baru
    private class tambahPasienDokter implements ActionListener {

        public tambahPasienDokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //DokterHome dokter=new DokterHome();
            dokterdaftarpasien.dispose();
            new cPasien(username, username, 9);
        }
    }

    //method memilih data aktif yg ada di tabel
    private class setSelectedPasienDokter implements MouseListener {

        public setSelectedPasienDokter() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            dokterdaftarpasien.detail().setEnabled(true);
            int baris = dokterdaftarpasien.getTabel().getSelectedRow();
            String ayam = dokterdaftarpasien.getTabel().getValueAt(baris, 0).toString();
            idPasien = Integer.valueOf(ayam);

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

    //pindah ke menu melihat rmd (riwayat periksa) pasien
    private class lihatRMDPasienDokter implements ActionListener {

        public lihatRMDPasienDokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dokterdaftarpasien.dispose();
            DokterLihatRMD dokterrmd = new DokterLihatRMD();
            new cPasien(username, dokterrmd, idPasien);
        }
    }

    //fitur cari pasien berdasarkan nama pasien
    private class cariPasienDokter implements ActionListener {

        public cariPasienDokter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = dokterdaftarpasien.getCariPasien();
            dokterdaftarpasien.setTabelPasien(pasien.bacaTabelPasienCari(nama));
            dokterdaftarpasien.refreshB().setEnabled(true);
        }
    }

    //========================ADMIN============================================
    //lihat Daftar Pasien yg sudah tercatat
    public cPasien(String a) {
        user = new user();
        pasien = new pasien();
        pasienAdmin = new AdminDaftarPasien();
        username = a;
        pasienAdmin.setVisible(true);
        pasienAdmin.setResizable(false);
        pasienAdmin.setLocationRelativeTo(null);
        pasienAdmin.setNama(username);
        pasienAdmin.pasienB().setEnabled(false);
        pasienAdmin.setTabelPasien(pasien.bacaTabelPasien());
        pasienAdmin.tambahListener(new tambahPasienAdmin());
        pasienAdmin.cariButtonListener(new cariPasienAdmin());
        pasienAdmin.detailListener(new lihatRMDPasienAdmin());
        pasienAdmin.obatListener(new obatListener1());
        pasienAdmin.detail().setEnabled(false);
        pasienAdmin.tableListener(new setSelectedPasienAdmin());
        pasienAdmin.berandaListener(new pasienKeBeranda());
    }

    //lihat rekammedis pasien yang dipilih dari tombol Lihat Rekammedis Pasien
    public cPasien(String a, int idPasien) {
        user = new user();
        pasien = new pasien();
        username = a;
        rmdAdmin = new AdminLihatRMD();
        rmdAdmin.setVisible(true);
        rmdAdmin.setResizable(false);
        rmdAdmin.setLocationRelativeTo(null);
        rmdAdmin.pasienB().setEnabled(false);
        rmdAdmin.setNama(username);
        rmdAdmin.pasienB().setEnabled(false);
        rmdAdmin.obatB().setEnabled(false);
        rmdAdmin.setTabelRMD(pasien.bacaRMDPasien(idPasien));
        rmdAdmin.setIDPasien(Integer.toString(idPasien));
        rmdAdmin.setNamaPasien(pasien.getNama(idPasien));
        rmdAdmin.setJenisKelamin(pasien.getJenisKelamin(idPasien));
        rmdAdmin.setAlamat(pasien.getAlamat(idPasien));
        rmdAdmin.setTglLahir(pasien.getTglLahir(idPasien));
        rmdAdmin.setUsia(pasien.getUsia(idPasien));
        rmdAdmin.tambahPeriksaListener(new tambahPeriksaAdmin());
        ayam = idPasien;
        /* rmdAdmin.kembaliListener(new kembaliKePasien());
         if (pasien.getKeterangan(idPasien).equals("gapapa")) {
         rmdAdmin.tag().setBackground(Color.red);
         } else {
         rmdAdmin.tag().setBackground(Color.blue);
         }

         System.out.println(ayam + "WEEEEEEE");*/

        //       rmdAdmin.ubahListener(new ubahPasiendariAdmin());
    }

    //ubah data pasien
   /* public cPasien(String l, int z, AdminUbahPasien ubahpasien) {
     user = new user();
     pasien = new pasien();
     username = l;
     idPasien = z;
     System.out.println("ID PASIENNYA ADLAHA " + idPasien);
     ubahpasienadmin = new AdminUbahPasien();
     ubahpasienadmin.setVisible(true);
     ubahpasienadmin.setResizable(false);
     ubahpasienadmin.setLocationRelativeTo(null);
     ubahpasienadmin.pasienB().setEnabled(false);
     ubahpasienadmin.setNama(username);
     ubahpasienadmin.pasienB().setEnabled(false);
     ubahpasienadmin.obatB().setEnabled(false);
     ubahpasienadmin.setIDPasien(Integer.toString(idPasien));
     ubahpasienadmin.setNamaPasien(pasien.getNama(idPasien));
     ubahpasienadmin.setJK(pasien.getJenisKelamin(idPasien));
     ubahpasienadmin.setAlamat(pasien.getAlamat(idPasien));
     ubahpasienadmin.setTglLhir(pasien.getTglLahir(idPasien));
     if (!ubahpasienadmin.getKeterangan().equals("parah")) {
     ubahpasienadmin.tag().setBackground(Color.red);
     } else if (!ubahpasienadmin.getKeterangan().equals("gapapa")) {
     ubahpasienadmin.tag().setBackground(Color.blue);
     }
     }*/
    //tambah periksa pasien dan masukin data ke tabel antrian
    public cPasien(String a, int o, String b) {
        System.out.println(idPasien);
        user = new user();
        pasien = new pasien();
        username = a;
        ayam = o;
        atamper = new adtambahperiksa();
        atamper.setVisible(true);
        atamper.setResizable(false);
        atamper.setLocationRelativeTo(null);
        atamper.setNamaAdmin(username);
        atamper.setNama(pasien.getNama(ayam));
        atamper.setJenisKelamin(pasien.getJenisKelamin(ayam));
        atamper.setTanggalLahir(pasien.getUsia(ayam));
        atamper.masukAntrian(new masukAntrianListener(ayam));
        atamper.berandaListener(new periksakeberadmin());
        atamper.pasienListener(new periksakepasadmin());
        atamper.obatListener(new periksakebatadmin());
    }

    //tambah data pasien
    public cPasien(String a, String b) {
        user = new user();
        pasien = new pasien();
        username = a;
        tambahpasien = new AdminTambahPasien();
        tambahpasien.setVisible(true);
        tambahpasien.setResizable(false);
        tambahpasien.setLocationRelativeTo(null);
        tambahpasien.setNamaAdmin(username);
        tambahpasien.pasienB().setEnabled(false);
        tambahpasien.tambahData(new tambahDataPasienListener());
        //  tambahpasien.addPasien(new tambahDataPasienListener2());
    }

    //dari data RMD pasien ke ubah data pasien
//    private class ubahPasiendariAdmin implements ActionListener {
//
//        public ubahPasiendariAdmin() {
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            AdminUbahPasien ubahpasien = new AdminUbahPasien();
//            rmdAdmin.dispose();
//            System.out.println("INI AYAM " + ayam);
//
//            new cPasien(username, ayam, ubahpasien);
//        }
//    }
//dari lihat RMD kembali ke meu daftar pasien
    private class kembaliKePasien implements ActionListener {

        public kembaliKePasien() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            rmdAdmin.dispose();
            new cPasien(username);
        }
    }

    private class periksakeberadmin implements ActionListener {

        public periksakeberadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(atamper, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                atamper.dispose();
                new cUser(username, admin);
            }
        }
    }

    private class periksakepasadmin implements ActionListener {

        public periksakepasadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(atamper, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                atamper.dispose();
                new cPasien(username);
            }
        }
    }

    private class periksakebatadmin implements ActionListener {

        public periksakebatadmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int apa = JOptionPane.showOptionDialog(atamper, "Data yg Anda masukkan tidak akan tersimpan.Tetap kembali?", "Konfirmasi", JOptionPane.YES_NO_OPTION, 0, null, null, null);
            if (apa == JOptionPane.YES_OPTION) {
                atamper.dispose();
                new cObat(username);
            }
        }
    }

    //dari menu daftar pasien ke menu obat
    private class obatListener1 implements ActionListener {

        public obatListener1() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            pasienAdmin.dispose();
            new cObat(username);
        }
    }

    //dari menu daftarpasien ke beranda admin
    private class pasienKeBeranda implements ActionListener {

        public pasienKeBeranda() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pasienAdmin.dispose();
            new controller.cUser(username, admin);
        }
    }

    //method tambah data pasien baru
    private class tambahDataPasienListener implements ActionListener {

        public tambahDataPasienListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = tambahpasien.getNama();
            String alamat = tambahpasien.getAlamat();
            String notelepon = tambahpasien.getTelepon();
            String pekerjaan = tambahpasien.getPekerjaan();
            String jeniskelamin = tambahpasien.getJenisKelamin();
            Date tanggalLahir = tambahpasien.getTanggalLahir();
            String keterangan = "";

            if (nama.equalsIgnoreCase("") || alamat.equalsIgnoreCase("") || notelepon.equalsIgnoreCase("") || pekerjaan.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(tambahpasien, "Data harus diisi dengan lengkap");
            } else {
                boolean input = pasien.tambahPasien(nama, tanggalLahir, alamat, jeniskelamin, pekerjaan, notelepon, keterangan);
                if (input) {
                    tambahpasien.dispose();
                    new cPasien(username, pasien.getID(nama), "idnya pasien= " + pasien.getID(nama));
                    JOptionPane.showMessageDialog(dataperiksaAdmin, "Pasien berhasil masuk antrian");
                } else {
                    JOptionPane.showMessageDialog(dataperiksaAdmin, "Mohon maaf ada yg salah");
                }
            }

        }
    }

    //method tambah data pasien baru
    private class tambahDataPasienListener2 implements ActionListener {

        public tambahDataPasienListener2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = tambahpasien.getNama();
            String alamat = tambahpasien.getAlamat();
            String notelepon = tambahpasien.getTelepon();
            String pekerjaan = tambahpasien.getPekerjaan();
            String jeniskelamin = tambahpasien.getJenisKelamin();
            Date tanggalLahir = tambahpasien.getTanggalLahir();

            if (nama.equalsIgnoreCase("") || alamat.equalsIgnoreCase("") || notelepon.equalsIgnoreCase("") || pekerjaan.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(tambahpasien, "Data harus diisi dengan lengkap");
            } else {
                boolean input = pasien.tambahPasien(nama, tanggalLahir, alamat, jeniskelamin, pekerjaan, notelepon, "");
                if (input) {
                    tambahpasien.dispose();
                    new cPasien(username, pasien.getID(nama), "idnya pasien= " + pasien.getID(nama));
                    JOptionPane.showMessageDialog(dataperiksaAdmin, "Pasien berhasil masuk antrian");
                } else {
                    JOptionPane.showMessageDialog(dataperiksaAdmin, "Mohon maaf ada yg salah");
                }
            }

        }
    }

    //method masukin data periksa pasien ke tabel antrian
    private class masukAntrianListener implements ActionListener {

        int ahai;

        public masukAntrianListener(int id) {
            ahai = id;
            System.out.println("INI AHAY=" + ahai);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("INI DATA AYAM= " + ahai);
            String anamnesa = atamper.getKeluhan();
            String nadi = atamper.getNadi();
            String suhu = atamper.getSuhu();
            String rr = atamper.getRR();
            String tensi = atamper.getTensi();

            if (anamnesa.equalsIgnoreCase("") || nadi.equalsIgnoreCase("") || suhu.equalsIgnoreCase("") || rr.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(atamper, "Pemeriksaan harus dilakukan secara lengkap");
            } else {
                boolean input = pasien.tambahRMDAdmin(ahai, anamnesa, tensi, rr, suhu, nadi);
                if (input) {
                    cUser = new cUser();
                    admin = new AdminHome();
                    atamper.dispose();
                    new cUser(username, admin);
                    JOptionPane.showMessageDialog(admin, "Pasien berhasil masuk antrian");
                } else {
                    JOptionPane.showMessageDialog(atamper, "Mohon maaf ada yg salah");
                }
            }
        }
    }

    private class tambahPeriksaAdmin implements ActionListener {

        public tambahPeriksaAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            rmdAdmin.dispose();
            System.out.println("ini idnya= " + ayam);
            new cPasien(username, ayam, "b");
        }
    }

    //method untuk menambah data pasien baru
    private class tambahPasienAdmin implements ActionListener {

        public tambahPasienAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pasienAdmin.dispose();
            new cPasien(username, username);
        }
    }

    //method memilih data aktif yg ada di tabel
    private class setSelectedPasienAdmin implements MouseListener {

        public setSelectedPasienAdmin() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            pasienAdmin.detail().setEnabled(true);
            int baris = pasienAdmin.getTabel().getSelectedRow();
            String ayam = pasienAdmin.getTabel().getValueAt(baris, 0).toString();
            idPasien = Integer.valueOf(ayam);

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

    //pindah ke menu melihat rmd (riwayat periksa) pasien
    private class lihatRMDPasienAdmin implements ActionListener {

        public lihatRMDPasienAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pasienAdmin.dispose();
            new cPasien(username, idPasien);

        }
    }

    //fitur cari pasien berdasarkan nama pasien
    private class cariPasienAdmin implements ActionListener {

        public cariPasienAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = pasienAdmin.getCariPasien();
            pasienAdmin.setTabelPasien(pasien.bacaTabelPasienCari(nama));
        }
    }

}
