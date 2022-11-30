
package model;

import java.util.Date;

public class Pinjaman {
    private int id_pinjaman;
    private String username;
    private Date tgl_pinjam;

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

    public Date getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(Date tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public Date getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }
    private Date tgl_kembali;

    public Pinjaman(String username, Date tgl_pinjam, Date tgl_kembali) {
        this.username = username;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
    }
    
}
