-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Des 2022 pada 18.21
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nama` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`username`, `password`, `nama`) VALUES
('admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(20) NOT NULL,
  `judul_buku` varchar(255) DEFAULT NULL,
  `kategori` varchar(20) DEFAULT NULL,
  `jumlah_buku` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `judul_buku`, `kategori`, `jumlah_buku`) VALUES
('b001', 'Ayat-ayat Cinta', 'Fiksi', 10),
('b002', 'Dilan 1990', 'Fiksi', 20),
('b003', 'Sang Kandidat', 'Non-fiksi', 11),
('b004', 'Bumi Manusia', 'Fiksi', 16),
('b005', 'Sebuah Seni untuk Bersikap Bodo Amat', 'Non-fiksi', 16),
('b006', 'Tips Sukses Ternak Lele', 'Non-fiksi', 7),
('b007', 'Garis waktu', 'Fiksi', 23),
('b008', '5 CM', 'Fiksi', 17),
('b009', 'Dari penjara ke penjara', 'Non-fiksi', 10),
('b010', 'Dibawah Bendera Revolusi', 'Non-fiksi', 10),
('b011', 'Negeri 5 Menara', 'Fiksi', 30),
('b012', 'Naruto: The last air bender', 'Fiksi', 30),
('b013', 'Naruto: The legend of aang', 'Fiksi', 32),
('b014', 'Atomic Habits', 'Non-fiksi', 24),
('b015', 'Soekarno', 'Non-fiksi', 23);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_pinjaman`
--

CREATE TABLE `detail_pinjaman` (
  `id_pinjaman` int(11) DEFAULT NULL,
  `id_buku` varchar(20) DEFAULT NULL,
  `jumlah_pinjam` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_pinjaman`
--

INSERT INTO `detail_pinjaman` (`id_pinjaman`, `id_buku`, `jumlah_pinjam`) VALUES
(1, 'b006', 1),
(1, 'b012', 1),
(1, 'b013', 1),
(2, 'b001', 1),
(2, 'b002', 1),
(3, 'b015', 1),
(3, 'b005', 1),
(3, 'b006', 1),
(4, 'b008', 1),
(4, 'b009', 1),
(4, 'b007', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjaman`
--

CREATE TABLE `pinjaman` (
  `id_pinjaman` int(11) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `tgl_pinjam` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'Dipinjam'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pinjaman`
--

INSERT INTO `pinjaman` (`id_pinjaman`, `username`, `tgl_pinjam`, `tgl_kembali`, `status`) VALUES
(1, 'Ronaldo', '2022-12-07', '2022-12-14', 'Dipinjam'),
(2, 'Messi', '2022-12-07', '2022-12-14', 'Dipinjam'),
(3, 'Maharani', '2022-12-07', '2022-12-14', 'Dipinjam'),
(4, 'maimin', '2022-12-07', '2022-12-14', 'Dikembalikan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nama_user` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`username`, `password`, `nama_user`) VALUES
('Maharani', 'pdi', 'Puan'),
('maimin', '123', 'paimin'),
('Messi', 'angkara', 'Lionel '),
('Ronaldo', 'cr7', 'Cristiano');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indeks untuk tabel `detail_pinjaman`
--
ALTER TABLE `detail_pinjaman`
  ADD KEY `id_pinjaman` (`id_pinjaman`),
  ADD KEY `id_buku` (`id_buku`);

--
-- Indeks untuk tabel `pinjaman`
--
ALTER TABLE `pinjaman`
  ADD PRIMARY KEY (`id_pinjaman`),
  ADD KEY `username` (`username`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pinjaman`
--
ALTER TABLE `pinjaman`
  MODIFY `id_pinjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_pinjaman`
--
ALTER TABLE `detail_pinjaman`
  ADD CONSTRAINT `detail_pinjaman_ibfk_1` FOREIGN KEY (`id_pinjaman`) REFERENCES `pinjaman` (`id_pinjaman`),
  ADD CONSTRAINT `detail_pinjaman_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`);

--
-- Ketidakleluasaan untuk tabel `pinjaman`
--
ALTER TABLE `pinjaman`
  ADD CONSTRAINT `pinjaman_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
