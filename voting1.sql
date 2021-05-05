-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2019 at 04:25 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.31

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
('AA', '2018mtcse007@curaj.ac.in', '9521188481', 'male', 3, 13, 'af295b7db7290bd7ba7dc710f6c86897', 'üÎïâ¼_èwÅYHE£\\½[\\?ã-Ê\0PZ8'),
('BB', 'rruchi068@gmail.com', '9521188484', 'female', 3, 14, '2a526fe5f23d0588254ec133ad1c327f', 'Íù—·‰b9FH\0ÈSu\'TF°×9ñšª“äèýa¹Í'),
('CC', 'rruchi0684@gmail.com', '9521188485', 'male', 3, 15, '5e574e6ffbb9009427b015ed9734a850', 'HO‡Úf<kä\nÀ}V_SÃH\r®¬Îã`•Ð˜É]ÊvÓ');

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
('ruchi', '9521188489', 'female', 'rruchi0684@gmail.com', '911d089cf74d280df4d5950ca76fe8c8', '|?äm„g˜ž˜', 9, '59nmWf', 3, 1);

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `voter`
--
ALTER TABLE `voter`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `voting`
--
ALTER TABLE `voting`
  MODIFY `VOTING_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
