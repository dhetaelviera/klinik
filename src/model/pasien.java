/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta
 */
public class pasien {

    Connection konek;

    public pasien() {
        konek = new koneksi().getKoneksi();
    }

    public String getNama(int idPasien) {
        String query = "SELECT nama from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("nama");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public int getLastRMD() {
        String query = "SELECT idRM from rekammedik order by idRM desc limit 1";
        int pasien = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getInt("idRM");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public int getID(String nama) {
        String query = "SELECT idPasien from pasien where nama=?";
        int pasien = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, nama);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getInt("idPasien");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getUsia(int idPasien) {
        String query = "SELECT year(curdate())-year(tanggalLahir) as usia from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("usia");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getTglLahir(int idPasien) {
        String query = "SELECT tanggalLahir from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("tanggalLahir");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getKeterangan(int idPasien) {
        String query = "SELECT keterangan from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("keterangan");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getAlamat(int idPasien) {
        String query = "SELECT alamat from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("alamat");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getNoTelp(int idPasien) {
        String query = "SELECT noTelp from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("noTelp");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getPekerjaan(int idPasien) {
        String query = "SELECT pekerjaan from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("pekerjaan");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getJenisKelamin(int idPasien) {
        String query = "SELECT jenisKelamin from pasien where idPasien=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("jenisKelamin");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getAnamnesa(int idPeriksa) {
        String query = "SELECT anamnesa from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("anamnesa");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getNadi(int idPeriksa) {
        String query = "SELECT nadi from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("nadi");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getRR(int idPeriksa) {
        String query = "SELECT rr from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("rr");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getSuhu(int idPeriksa) {
        String query = "SELECT suhu from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("suhu");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getTensi(int idPeriksa) {
        String query = "SELECT tensi from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("tensi");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getDiagnosa(int idPeriksa) {
        String query = "SELECT diagnosa from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("diagnosa");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getKhusus(int idPeriksa) {
        String query = "SELECT pemeriksaanKhusus from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("pemeriksaanKhusus");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getTambahan(int idPeriksa) {
        String query = "SELECT pemeriksaanTambahan from rekammedik where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("pemeriksaanTambahan");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getNamaRMD(int idPeriksa) {
        String query = "SELECT p.nama as nama from pasien p join rekammedik r on p.idPasien=r.idPasien where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("nama");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getAlamatRMD(int idPeriksa) {
        String query = "SELECT p.alamat as alamat from pasien p join rekammedik r on p.idPasien=r.idPasien where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idPeriksa);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("alamat");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getUsiaRMD(int idPasien) {
        String query = "SELECT year(curdate())-year(p.tanggalLahir) as usia from pasien p join rekammedik r on"
                + " p.idPasien=r.idPasien where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("usia");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String getTanggalRMD(int idPasien) {
        String query = "select substring(tanggalPeriksa,12,5) as tanggal from rekammedik "
                + "where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("tanggal");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }
    
    
    public String getTanggalRMD2(int idPasien) {
        String query = "select substring(tanggalPeriksa,12,5) as tanggal from rekammedik "
                + "where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("tanggal");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }
    
    public String getKerjaRMD(int idPasien) {
        String query = "select p.pekerjaan as pekerjaan from pasien p join rekammedik r on p.idPasien=r.idPasien where idRM=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("pekerjaan");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public String countpasien() {
        String query = "select count(*) as jumlah from rekammedik where substring(tanggalPeriksa,1,10)=curdate()";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("jumlah");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public boolean tambahPasien(String nama, Date tanggalLahir, String alamat, String jenisKelamin, String pekerjaan, String noTelp, String keterangan) {
        String query = "insert into `pasien`(`nama`,`jenisKelamin`,`tanggalLahir`,`alamat`,`pekerjaan`,`noTelp`,`keterangan`) values (?,?,?,?,?,?,?)";
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = tanggalLahir;
            System.out.println(date);
            java.sql.Date tanggalLahirsql = new java.sql.Date(date.getTime());
            System.out.println(tanggalLahirsql);

            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, nama);
            st.setString(2, jenisKelamin);
            st.setDate(3, tanggalLahirsql);
            st.setString(4, alamat);
            st.setString(5, pekerjaan);
            st.setString(6, noTelp);
            st.setString(7, keterangan);

            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean ubahdatapasien(int idPasien, String nama, String alamat, String notelpon, String pekerjaan, String keterangan) {
        String query = "UPDATE pasien SET nama=?, alamat=?,noTelp=?,pekerjaan=?, keterangan=? WHERE idPasien=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, nama);
            st.setString(2, alamat);
            st.setString(3, notelpon);
            st.setString(4, pekerjaan);
            st.setString(5, keterangan);
            st.setInt(6, idPasien);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean tambahRMDAdmin(int idPasien, String keluhan, String tensi, String rr, String suhu, String nadi) {
        String query = "insert into `rekammedik`(`idPasien`,`anamnesa`,`tensi`,`rr`,`suhu`,`nadi`) values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            st.setString(2, keluhan);
            st.setString(3, tensi);
            st.setString(4, rr);
            st.setString(5, suhu);
            st.setString(6, nadi);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean tambahRMDDokter1(int idPasien) {
        String query = "insert into `rekammedik`(`idPasien`,`statusPeriksa`) values (?,'diperiksa')";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);

            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean tambahRMDDokter(int idPasien, String keluhan, String tensi, String rr, String suhu, String nadi, String pemeriksaanKhusus, String pemeriksaanTambahan, String diagnosa) {
        String query = "insert into `rekammedik`(`idPasien`,`anamnesa`,`tensi`,`rr`,`suhu`,`nadi`,`pemeriksaanKhusus`,`pemeriksaanTambahan`,`diagnosa`) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idPasien);
            st.setString(2, keluhan);
            st.setString(3, tensi);
            st.setString(4, rr);
            st.setString(5, suhu);
            st.setString(6, nadi);
            st.setString(7, pemeriksaanKhusus);
            st.setString(8, pemeriksaanTambahan);
            st.setString(9, diagnosa);

            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean ubahRiwayatDokter(int idPasien, String keluhan, String tensi, String rr, String nadi, String suhu, String pemeriksaanKhusus, String pemeriksaanTambahan, String diagnosa) {
        String query = "UPDATE rekammedik SET anamnesa=?, tensi=?,rr=?,suhu=?, nadi=?, pemeriksaanKhusus=?, pemeriksaanTambahan=?, diagnosa=? WHERE idRM=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, keluhan);
            st.setString(2, tensi);
            st.setString(3, rr);
            st.setString(4, suhu);
            st.setString(5, nadi);
            st.setString(6, pemeriksaanKhusus);
            st.setString(7, pemeriksaanTambahan);
            st.setString(8, diagnosa);
            st.setInt(9, idPasien);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean masukkanTarif(int idPasien, int tarif) {
        String query = "UPDATE rekammedik SET tarif=?, statusPeriksa='selesai' WHERE idRM=?";
        System.out.println(query);
        System.out.println(idPasien + "   " + tarif);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, tarif);
            st.setInt(2, idPasien);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public DefaultTableModel lihatDaftarPasien() {
        String query = "select nama, jeniskelamin, alamat, tanggalLahir, notelp, pekerjaan "
                + "from pasien order by idPasien";
        String namaKolom[] = {"Nama Pasien", "Jenis Kelamin", "Alamat", "Tanggal Lahir", "No. Telepon", "Pekerjaan"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[6];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel daftarAntrian() {
        String query = "select r.idRM, substring(r.tanggalPeriksa,12,5), p.nama, p.jenisKelamin, year(curdate())-year(p.tanggalLahir)"
                + "from pasien p join rekammedik r on p.idpasien=r.idpasien where substring(r.tanggalPeriksa,1,10)=curdate() "
                + "and r.statusPeriksa='antri' order by r.tanggalPeriksa";
        String namaKolom[] = {"Kode RMD", "Waktu Daftar", "Nama Pasien", "Jenis Kelamin", "Usia"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[5];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelPasien() {
        String query = "SELECT idPasien, nama, jenisKelamin, year(curdate())-year(tanggalLahir),"
                + "alamat, substring(tanggalDaftar,1,10) "
                + "from pasien order by idPasien";
        String namaKolom[] = {"ID Pasien", "Nama Pasien", "Jenis Kelamin", "Usia", "Alamat", "Tanggal Daftar"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[6];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelPasienCari(String cari) {

        String query = "select idPasien, nama, jeniskelamin,year(curdate())-year(tanggalLahir) as usia, alamat, substring(tanggalDaftar,1,10) as tanggalDaftar "
                + "from pasien "
                + "where nama LIKE '" + cari + "%' or nama LIKE '%" + cari + "%' or nama LIKE '%" + cari + "';";

        String namaKolom[] = {"ID Pasien, Nama Pasien", "Jenis Kelamin", "Usia", "Alamat", "Tanggal Daftar"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[6];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaRMDPasien(int idPasien) {
        String query = "SELECT substring(tanggalPeriksa,1,10), anamnesa, tensi, diagnosa"
                + " from rekammedik where idPasien='" + idPasien + "';";
        String namaKolom[] = {"Tanggal Periksa", "Anamnesa", "Tensi", "Diagnosa"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
}
