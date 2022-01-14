-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2022-01-14 17:56:08
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
-- 傾印資料表的資料 `check_out`
--

INSERT INTO `check_out` (`id`, `name`, `dorm`, `room`, `bed`, `created`, `passORnot`) VALUES
(1, 'test1', '國際宿舍 International Dorm', '123', '1', '2022-01-14', 'Pass'),
(2, 'test2', 'B5', '205', '1', '2022-01-15', 'NotPass'),
(3, 'test3', 'G1', '101', '2', '2022-01-13', 'NotPass');

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
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
