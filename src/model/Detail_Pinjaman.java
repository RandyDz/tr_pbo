
package model;

public class Detail_Pinjaman {
    private int id_pinjaman;
    private String id_buku;
    private int jumlah_pinjam;

    public Detail_Pinjaman( String id_buku, int jumlah_pinjam) {
        this.id_buku = id_buku;
        this.jumlah_pinjam = jumlah_pinjam;
    }

    public int getId_pinjaman() {
        return id_pinjaman;
    }

    public void setId_pinjaman(int id_pinjaman) {
        this.id_pinjaman = id_pinjaman;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public int getJumlah_pinjam() {
        return jumlah_pinjam;
    }

    public void setJumlah_pinjam(int jumlah_pinjam) {
        this.jumlah_pinjam = jumlah_pinjam;
    }
    
    
}
