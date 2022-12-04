
package model;

public class Pinjaman {
    private int id_pinjaman;
    private String username;
    private String tgl_pinjam;
    private String tgl_kembali;
    private String status;

    public Pinjaman(int id_pinjaman, String username, String tgl_pinjam, String tgl_kembali) {
        this.id_pinjaman = id_pinjaman;
        this.username = username;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
    }

    public int getId_pinjaman() {
        return id_pinjaman;
    }

    public void setId_pinjaman(int id_pinjaman) {
        this.id_pinjaman = id_pinjaman;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(String tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    } 
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
