-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2021 at 07:11 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `voting`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `NAME` varchar(30) NOT NULL,
  `PHONE_NO` varchar(15) NOT NULL,
  `EMAIL_ID` varchar(30) NOT NULL,
  `id` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `SALT` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`NAME`, `PHONE_NO`, `EMAIL_ID`, `id`, `password`, `SALT`) VALUES
('ruchi', '9521188481', 'rruchi0684@gmail.com', 9, 'ac627ab1ccbdb62ec96e702f07f6425b', '9');

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE `candidate` (
  `NAME` varchar(30) NOT NULL,
  `EMAIL_ID` varchar(30) NOT NULL,
  `PHONE_NO` varchar(15) NOT NULL,
  `GENDER` varchar(30) NOT NULL,
  `INVALID` int(11) NOT NULL DEFAULT 3,
  `ID` int(11) NOT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `SALT` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`NAME`, `EMAIL_ID`, `PHONE_NO`, `GENDER`, `INVALID`, `ID`, `PASSWORD`, `SALT`) VALUES
('Mr. A', '2018mtcse01@curaj.ac.in', '9521188481', 'male', 3, 13, 'af295b7db7290bd7ba7dc710f6c86897', 'üÎïâ¼_èwÅYHE£\\½[\\?ã-Ê\0PZ8'),
('Miss C', 'missc@gmail.com', '9521188400', 'female', 3, 16, 'e8125846cb34de5232dfb00010377d65', 'ú?Š??q??t?#†?m&N}“^°?>??j?É?ö'),
('Mr. Z', 'Zmr@gmail.com', '9218877456', 'male', 3, 17, '3e31b54fc695237ed668ee5998d2e442', 'Ú•Ä??Z?\Z?‹=?ß??†I?p?¶@?m†…ÚÖ?(Š');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `RESULTFLAG` int(11) NOT NULL,
  `WINNERID` int(11) NOT NULL,
  `ID` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `voter`
--

CREATE TABLE `voter` (
  `NAME` varchar(30) NOT NULL,
  `PHONE_NO` varchar(30) NOT NULL,
  `GENDER` varchar(10) NOT NULL,
  `EMIAL_ID` varchar(50) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `SALT` varchar(20) NOT NULL,
  `ID` int(10) NOT NULL,
  `MAILSTRING` varchar(30) DEFAULT NULL,
  `INVALID` int(11) DEFAULT 3,
  `ACTIVATION` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voter`
--

INSERT INTO `voter` (`NAME`, `PHONE_NO`, `GENDER`, `EMIAL_ID`, `PASSWORD`, `SALT`, `ID`, `MAILSTRING`, `INVALID`, `ACTIVATION`) VALUES
('ruchi', '9521188481', 'female', '2018MTCSE7@curaj.ac.in', '8c88480cc6be9bebac1cc55d172f512b', 'ìšúÂ»88^¶', 7, 'EX2Vlw', 1, 1),
('ABC', '9521188488', 'male', '2018MTCSE007@curaj.ac.in', 'f76cc5df69e35919dde32d8bf5524fe6', 'Œ0ƒÕTÌ”¢', 8, '8IB5s0', 3, 1),
('Ruchi', '9521188400', 'female', 'ruchi084@gmail.com', '5d07eb7d29c837569ee2ff9c6efb83b3', 'c??&?žú??', 11, 'FxmEOb', 3, 1),
('Ruchi', '9521188480', 'female', 'rruchi0684@gmail.com', 'bf94b4e2181e88170dafc9104b278d89', '??_~_\"??X', 12, '8kpXRb', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `voting`
--

CREATE TABLE `voting` (
  `VOTING_ID` int(11) NOT NULL,
  `VOTER_ID` varchar(30) NOT NULL,
  `CANDIDATE_ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`PHONE_NO`,`EMAIL_ID`);

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`ID`,`EMAIL_ID`,`PHONE_NO`);

--
-- Indexes for table `voter`
--
ALTER TABLE `voter`
  ADD PRIMARY KEY (`ID`,`PHONE_NO`,`EMIAL_ID`);

--
-- Indexes for table `voting`
--
ALTER TABLE `voting`
  ADD PRIMARY KEY (`VOTING_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidate`
--
ALTER TABLE `candidate`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `voter`
--
ALTER TABLE `voter`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `voting`
--
ALTER TABLE `voting`
  MODIFY `VOTING_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
