-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2023 at 05:46 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `satria`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `CODE` int(11) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `CATEGORY` varchar(20) DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`CODE`, `NAME`, `PRICE`, `CATEGORY`, `STATUS`) VALUES
(936, 'Mee Goreng', 6.5, 'Ala goreng', 'Available'),
(1641, 'Aneka Sayur', 0.5, 'Nasi campur', 'Available'),
(3170, 'Teh Tarik', 2.2, 'Minuman', 'Available'),
(4189, 'Nasi kandar', 8, 'Nasi campur', 'Not Available');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `STAFFID` int(11) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `PHONENO` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`STAFFID`, `NAME`, `AGE`, `PHONENO`, `USERNAME`, `PASSWORD`) VALUES
(1, 'ADMIN', 1, '011-13097595', 'admin', 'admin100'),
(234, 'MUHAMMD ZIKRI BIN KASHIM', 12, '0909', 'zik', 'a'),
(47311, 'AMRI', 20, '(012)-345-6789', 'ST47311', 'amrihesmes'),
(55744, 'NIK FARUQ', 21, '(012)-663-9578', 'ST55744', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transNo` int(11) NOT NULL,
  `date` varchar(40) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transNo`, `date`, `total`) VALUES
(393, '15/01/2023 05:01:43', 4.24),
(8648, '19/01/2023 09:49:20', 5.72),
(13312, '18/01/2023 03:40:38', 21.2),
(13744, '17/01/2023 06:06:08', 21.84),
(13891, '19/01/2023 12:34:32', 5.72);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`CODE`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`STAFFID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
