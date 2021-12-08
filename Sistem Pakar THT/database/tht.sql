-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2014 at 02:37 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tht`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE IF NOT EXISTS `history` (
  `nohistory` varchar(10) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `no_pasien` varchar(10) NOT NULL DEFAULT '',
  `keterangan` varchar(30) DEFAULT NULL,
  `kode_penyakit` varchar(30) DEFAULT NULL,
  `diagnosis` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`nohistory`,`no_pasien`),
  KEY `nohistory` (`nohistory`),
  KEY `nohistory_2` (`nohistory`,`no_pasien`),
  KEY `no_pasien` (`no_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`nohistory`, `tanggal`, `no_pasien`, `keterangan`, `kode_penyakit`, `diagnosis`) VALUES
('TH-14020', '2014-02-02', '14020', 'Cek UP', 'Q', 'Tonsilitis');

-- --------------------------------------------------------

--
-- Table structure for table `medis`
--

CREATE TABLE IF NOT EXISTS `medis` (
  `no_pasien` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `hasil` varchar(30) NOT NULL,
  `resep_dokter` varchar(30) NOT NULL,
  PRIMARY KEY (`no_pasien`),
  KEY `no_pasien` (`no_pasien`),
  KEY `no_pasien_2` (`no_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medis`
--

INSERT INTO `medis` (`no_pasien`, `username`, `tanggal`, `hasil`, `resep_dokter`) VALUES
('14020', 'Septian', '02/02/2014', 'Tonsilitis', 'T');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `no_pasien` varchar(10) NOT NULL,
  `nama_pasien` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `kota` varchar(30) NOT NULL,
  `no_telp` varchar(30) NOT NULL,
  `pekerjaan` varchar(30) NOT NULL,
  PRIMARY KEY (`no_pasien`),
  KEY `no_pasien` (`no_pasien`),
  KEY `no_pasien_2` (`no_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`no_pasien`, `nama_pasien`, `alamat`, `kota`, `no_telp`, `pekerjaan`) VALUES
('14020', 'Admin-Tian', 'Perum Griya Permai', 'Cikampek', '0897206535', 'Mahasiswa');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`no_pasien`) REFERENCES `pasien` (`no_pasien`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medis`
--
ALTER TABLE `medis`
  ADD CONSTRAINT `medis_ibfk_1` FOREIGN KEY (`no_pasien`) REFERENCES `pasien` (`no_pasien`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
