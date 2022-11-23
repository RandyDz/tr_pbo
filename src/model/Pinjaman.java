
package model;

import java.util.Date;

public class Pinjaman {
    private int id_pinjaman;
    private int id_user;
    private Date tgl_pinjam;
    private Date tgl_kembali;

    public Pinjaman(int id_pinjaman, int id_user, Date tgl_pinjam, Date tgl_kembali) {
        this.id_pinjaman = id_pinjaman;
        this.id_user = id_user;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
    }

    public int getId_pinjaman() {
        return id_pinjaman;
    }

    public void setId_pinjaman(int id_pinjaman) {
        this.id_pinjaman = id_pinjaman;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
    
    
}
