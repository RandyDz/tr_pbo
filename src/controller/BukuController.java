
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.Koneksi;
import model.Buku;

public class BukuController {
    public List<Buku> readAll(){
        List<Buku> ls = new ArrayList<Buku>();
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM buku";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Buku b = new Buku(
                        rs.getString("id_buku"), 
                        rs.getString("judul_buku"), 
                        rs.getString("kategori"), 
                        rs.getInt("jumlah_buku")
                );
                ls.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }
    
    public int getStok(String id_buku){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT jumlah_buku FROM buku WHERE id_buku = '"+ id_buku +"';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                return rs.getInt("jumlah_buku");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int tambahBuku(String id, String judul, String kategori, int stok){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "INSERT INTO buku(id_buku, judul_buku, kategori, jumlah_buku) VALUES ('"+ id +"', '"+ judul +"', '"+ kategori +"', "+ stok +");";
            return st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int hapusBuku(String id){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "DELETE FROM buku WHERE id_buku = '"+ id +"';";
            return st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
        
    public int updateBuku(String id, String judul, String kategori, int stok){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "UPDATE buku SET id_buku = '"+ id +"',judul_buku = '"+ judul +"',kategori = '"+ kategori +"',jumlah_buku = "+ stok +" WHERE id_buku = '"+ id +"';";
            return st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public void dipinjam(String id_buku, int jumlah){
        int tempStok = this.getStok(id_buku);
        int jmlBaru = tempStok - jumlah;
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "UPDATE buku SET jumlah_buku= "+ jmlBaru +" WHERE id_buku = '"+id_buku +"';";
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void dikembalikan(String id_buku, int jumlah){
        int tempStok = this.getStok(id_buku);
        int jmlBaru = tempStok + jumlah;
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "UPDATE buku SET jumlah_buku= "+ jmlBaru +" WHERE id_buku = '"+id_buku +"';";
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
