
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Koneksi instance = new Koneksi();
    private static Connection conn;

    public static Koneksi getInstance(){
        return instance;
    } 

    public static Connection getConnection(){
        return conn;
    }
    
    private Koneksi(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "jdbc:mysql://localhost/db_perpus";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(db, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
