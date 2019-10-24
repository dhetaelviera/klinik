/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta
 */
public class user {

    private Connection konek;

    public user() {
        konek = new koneksi().getKoneksi();
    }

    public String getUsername(String username) {
        String query = "select username from user where username=?";
        String id = "kosong";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                System.out.println(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return id;
    }

    public String getNamaSession(String username) {
        String query = "select nama from user where username=?";
        String id = "kosong";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                System.out.println(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return id;
    }
    
     public String getNama(String username) {
        String query = "SELECT nama from user where username=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, username);
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
     public String cek(String username) {
        String query = "SELECT username from user where username=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("username");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }
     
       public int cek2(String username) {
        String query = "SELECT count(*) as jumlah from user where username=?";
        int pasien=0;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getInt("jumlah");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }

    public int login(String username, String password) {
        String query = "select*from user where username=? and password=?";
        System.out.println(query);
        int tingkatan = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                tingkatan = rs.getInt("level");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return tingkatan;

    }

    public DefaultTableModel bacaTabelUser() {
        String query = "SELECT nama, username from user";
        String namaKolom[] = {"Nama", "Username", };
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[2];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);

                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public boolean tambahUser(String nama, String username, String password) {
        String query = "insert into `user`(`nama`,`username`,`password`,`level`) values (?,?,?,2)";
        try {

            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, nama);
            st.setString(2, username);
            st.setString(3, password);

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
    
    public boolean ubahdata(String password, String username,String nama) {
        String query = "UPDATE user SET password=?, username=? WHERE nama=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, password);
            st.setString(2, username);
            st.setString(3, nama);
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
    
    public boolean hapususer(String username) {
        String query = "DELETE from user where username=?";
        try {

            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, username);

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
    
       
        public String getPass(String username) {
        String query = "SELECT password from user where username=?";
        String pasien = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            rs.next();
            pasien = rs.getString("password");
            System.out.println(pasien);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pasien;
    }
        
      

}
