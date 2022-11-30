//CRUD buku oleh admin

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
    
    public void updateStok(String id_buku, int jumlah){
        int tempStok = this.getStok(id_buku);
        int jmlBaru = tempStok - jumlah;
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "UPDATE buku SET jumlah='"+ jmlBaru +"' WHERE ";
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getStok(String id_buku){
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT jumlah FROM pinjaman WHERE id_buku = '"+ id_buku +"';";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                return rs.getInt("jumlah");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
