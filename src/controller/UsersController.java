//CRUD Login
package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import koneksi.Koneksi;
import model.Users;

public class UsersController {
    public String cekUsername(String username){
        String hasil = "yes";
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM users WHERE username = '"+ username +"';";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                if(username.equals(rs.getString("username"))){
                    hasil = "no";
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hasil;
    }
      
    public int insertUser(Users user) {
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String query = "INSERT INTO users (username, password, nama_user) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getNama() + "');";
            return st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
