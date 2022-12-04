
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.Koneksi;
import model.Detail_Pinjaman;
import model.Pinjaman;

public class PinjamanController {
    public List<Pinjaman> readAll(){
        List<Pinjaman> ls = new ArrayList<Pinjaman>();
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM pinjaman";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Pinjaman p = new Pinjaman(
                        rs.getInt("id_pinjaman"),
                        rs.getString("username"), 
                        rs.getString("tgl_pinjam"), 
                        rs.getString("tgl_kembali"),
                        rs.getString("status")
                );
                ls.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }
    
    public void SimpanPinjaman(String username, String tglPinjam, String tglKembali){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "INSERT INTO pinjaman(username, tgl_pinjam, tgl_kembali) VALUES ('"+ username +"', '"+ tglPinjam +"','"+ tglKembali +"');";
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getIdPinjaman(String username, String tglPinjam){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT id_pinjaman FROM pinjaman WHERE username = '"+ username +"' AND tgl_pinjam = '"+ tglPinjam +"';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                return rs.getInt("id_pinjaman");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int cekPinjaman(String username, String tglPinjam){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM pinjaman WHERE username = '"+ username +"' AND tgl_pinjam = '"+ tglPinjam +"';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                return 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public void updateStatusPinjaman(String idPinjaman){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "UPDATE pinjaman SET status = 'Dikembalikan' WHERE id_pinjaman = '"+idPinjaman +"';";
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Detail_Pinjaman> readDetailPinjaman(String idPinjaman){
        List<Detail_Pinjaman> ls = new ArrayList<Detail_Pinjaman>();
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM detail_pinjaman WHERE id_pinjaman = '"+ idPinjaman +"';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Detail_Pinjaman dp = new Detail_Pinjaman(
                        rs.getString("id_buku"), 
                        rs.getInt("jumlah_pinjam")
                );
                ls.add(dp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }
    
    public void simpanDetailPinjaman(int id_pinjaman, String id_buku, int jumlah){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "INSERT INTO detail_pinjaman(id_pinjaman, id_buku, jumlah_pinjam) VALUES ("+ id_pinjaman +", '"+ id_buku +"', "+ jumlah +");";
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
