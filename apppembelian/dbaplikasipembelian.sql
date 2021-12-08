CREATE DATABASE dbaplikasipembelian;
use dbaplikasipembelian;

CREATE TABLE barang (
  kode_barang varchar(20) PRIMARY KEY,
  nama_barang varchar(200) DEFAULT NULL,
  harga double NOT NULL,
  satuan varchar(20) DEFAULT NULL,
  stok double NOT NULL
);