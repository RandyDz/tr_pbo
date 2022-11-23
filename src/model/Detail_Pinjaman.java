/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DIMAS
 */
public class Detail_Pinjaman {
    private int id_pinjaman;
    private int id_buku;
    private int jumlah_pinjam;

    public Detail_Pinjaman(int id_pinjaman, int id_buku, int jumlah_pinjam) {
        this.id_pinjaman = id_pinjaman;
        this.id_buku = id_buku;
        this.jumlah_pinjam = jumlah_pinjam;
    }

    public int getId_pinjaman() {
        return id_pinjaman;
    }

    public void setId_pinjaman(int id_pinjaman) {
        this.id_pinjaman = id_pinjaman;
    }

    public int getId_buku() {
        return id_buku;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public int getJumlah_pinjam() {
        return jumlah_pinjam;
    }

    public void setJumlah_pinjam(int jumlah_pinjam) {
        this.jumlah_pinjam = jumlah_pinjam;
    }
    
    
}
