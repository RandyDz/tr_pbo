//CRUD Pinjaman oleh user

package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.Koneksi;

public class PinjamanController {
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
}
