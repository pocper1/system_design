-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2022 at 02:51 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `missa`
--

-- --------------------------------------------------------

--
-- Table structure for table `check_in`
--

CREATE TABLE `check_in` (
  `id` int(10) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dorm_no` varchar(255) DEFAULT NULL,
  `room_no` varchar(10) DEFAULT NULL,
  `bed_no` varchar(10) DEFAULT NULL,
  `check_in_stat` varchar(20) DEFAULT NULL,
  `is_damaged` tinyint(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `check_in`
--

INSERT INTO `check_in` (`id`, `user_id`, `email`, `name`, `dorm_no`, `room_no`, `bed_no`, `check_in_stat`, `is_damaged`, `create_time`, `modify_time`) VALUES
(1, '108403001', 'neishen@gmail.com', 'name1', 'B9B', '101', '1', NULL, 0, '2021-12-30 12:14:51', '2021-12-30 12:14:51'),
(2, '108403002', '', 'name2', 'B9B', '101', '2', 'ready to check in', 0, '2021-12-29 04:16:04', '2021-12-29 04:16:04'),
(5, '108403003\r\n', '', 'name3', 'DORM LAIN', '101', '1', 'checked in', 0, '2022-01-03 02:06:15', '2022-01-03 02:06:15'),
(6, '108403006\r\n', '', 'name6', 'B9A', '101', '1', 'ready to check in', 0, '2022-01-03 02:07:59', '2022-01-03 02:07:59'),
(7, '108403007\r\n', '', 'name7', 'B9B', '101', '3', 'ready to check in', 0, '2022-01-03 02:11:29', '2022-01-03 02:11:29'),
(8, '108403008\r\n', '', 'name8', 'B9B', '101', '4', 'checked in', 0, '2022-01-03 02:12:41', '2022-01-03 02:12:41');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `check_in`
--
ALTER TABLE `check_in`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `check_in`
--
ALTER TABLE `check_in`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
