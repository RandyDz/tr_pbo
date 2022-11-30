
package model;

public class Buku {
    private String id_buku;
    private String judul_buku;
    private String kategori;
    private int jumlah_buku;

    public Buku(String id_buku, String judul_buku, String kategori, int jumlah_buku) {
        this.id_buku = id_buku;
        this.judul_buku = judul_buku;
        this.kategori = kategori;
        this.jumlah_buku = jumlah_buku;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getJumlah_buku() {
        return jumlah_buku;
    }

    public void setJumlah_buku(int jumlah_buku) {
        this.jumlah_buku = jumlah_buku;
    }
    
    
}
