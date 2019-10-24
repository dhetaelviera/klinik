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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta Delv-Indra
 */
public class obat {

    Connection konek;

    public obat() {
        konek = new koneksi().getKoneksi();
    }

    public String getNamaObat(int idObat) {
        String query = "SELECT namaObat from obat where idObat=?";
        String obat = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idObat);
            ResultSet rs = st.executeQuery();
            rs.next();
            obat = rs.getString("namaObat");
            System.out.println(obat);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return obat;
    }
   
    public String getStok(int idObat) {
        String query = "SELECT stok from obat where idObat=?";
        String obat = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idObat);
            ResultSet rs = st.executeQuery();
            rs.next();
            obat = rs.getString("stok");
            System.out.println(obat);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return obat;
    }
    
    public int getID(String nama) {
        String query = "SELECT idObat from obat where namaObat=?";
        int obat = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, nama);
            ResultSet rs = st.executeQuery();
            rs.next();
            obat = rs.getInt("idObat");
            System.out.println(obat);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return obat;
    }
    
    public String[][] getDaftarObat() {
        String query = "select idObat, namaObat from obat";
        String jenis[][] = null;

        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            rs.last();
            jenis = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                jenis[0][i] = rs.getString("idObat");
                jenis[1][i] = rs.getString("namaObat");
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return jenis;
    }

    public DefaultTableModel lihatDaftarObat() {
        String query = "select namaObat, stok, lastUpdate from obat";
        String namaKolom[] = {"Nama Obat", "Stok", "Tanggal Penyediaan Terakhir"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[3];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public boolean tambahObat(int idObat, String namaObat, int stok) {
        String query = "insert into `obat`(`namaObat`,`stok`,`lastUpdate`) values (?,?,CURRENT_DATE)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, namaObat);
            st.setInt(2, stok);
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

    public boolean ubahStokObat(int idObat, int stok) {
        String query = "UPDATE obat SET stok=?, lastUpdate=curdate() WHERE idObat=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, stok);
            st.setInt(2, idObat);
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

    public boolean buatResep(int idRMD) {
        String query = "insert into `resepobat`(`idRMD`) values (?)";
        try {

            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idRMD);
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
    
     public String getIDResep(int idRMD) {
        String query = "SELECT idResep from resepobat where idRMD=?";
        String obat = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idRMD);
            ResultSet rs = st.executeQuery();
            rs.next();
            obat = rs.getString("idResep");
            System.out.println(obat);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return obat;
    }
    
    public boolean detailResep(int idResep, int idObat, int jumlah, String signa, String keterangan) {
        String query = "insert into `detailresep`(`idResep`,`idObat`,`jumlah`,`signa`,`keterangan`) values (?,?,?,?,?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idResep);
            st.setInt(2, idObat);
            st.setInt(3, jumlah);
            st.setString(4, signa);
            st.setString(5, keterangan);
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
    
    public DefaultTableModel lihatResep(int idResep) {
        String query = "select o.namaObat, dr.jumlah,dr.signa,dr.keterangan from obat o join detailresep dr "
                + "on o.idObat=dr.idObat where dr.idResep='" + idResep + "';";
        String namaKolom[] = {"Nama Obat", "Jumlah Obat", "Signa","Keterangan"};
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
    
     public DefaultTableModel bacaDaftarObat() {
         
        String query = "SELECT namaObat, stok,lastUpdate from obat";
        // System.out.println(query);
        String namaKolom[] = {"Nama Obat", "Stok", "Terakhir Update"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[3];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                tabel.addRow(data);
               // System.out.println(data[1]);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
     
     public DefaultTableModel bacaTabelObatCari(String cari) {
        
         String query = "select namaObat, stok,lastUpdate from obat "
                + "where namaObat LIKE '" + cari + "%' or namaObat LIKE '%" + cari + "%' or namaObat LIKE '%" + cari + "';";
         
        String namaKolom[] = {"Nama Obat", "Stok", "Terakhir Update"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[6];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
}
