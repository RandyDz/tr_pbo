//CRUD Login
package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.Koneksi;
import model.Users;

/**
 *
 * @author DIMAS
 */
public class UsersController {

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
