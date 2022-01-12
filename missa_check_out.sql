-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2022-01-12 12:47:12
-- 伺服器版本： 10.4.14-MariaDB
-- PHP 版本： 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `missa`
--

-- --------------------------------------------------------

--
-- 資料表結構 `check_out`
--

CREATE TABLE `check_out` (
  `id` int(10) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 NOT NULL,
  `dorm` varchar(30) CHARACTER SET utf8 NOT NULL,
  `room` varchar(10) CHARACTER SET utf8 NOT NULL,
  `bed` varchar(10) CHARACTER SET utf8 NOT NULL,
  `created` date NOT NULL,
  `passORnot` varchar(10) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `check_out`
--
ALTER TABLE `check_out`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `check_out`
--
ALTER TABLE `check_out`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
