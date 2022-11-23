
package model;

public class Users {
    private int id_user;
    private String username;
    private String password;
    private String nama;

    public Users(String nama, String username, String password) {
        this.username = username;
        this.password = password;
        this.nama = nama;
    }
    
    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }   
}
