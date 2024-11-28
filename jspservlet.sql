-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 28, 2024 lúc 02:38 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `jspservlet`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `indexer`
--

CREATE TABLE `indexer` (
  `index_id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `valueMin` float NOT NULL,
  `valueMax` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `indexer`
--

INSERT INTO `indexer` (`index_id`, `name`, `valueMin`, `valueMax`) VALUES
(1, 'speed', 10, 100),
(2, 'strength', 0, 10),
(3, 'accurate', 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `player`
--

CREATE TABLE `player` (
  `player_id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `full_name` varchar(128) NOT NULL,
  `age` varchar(10) NOT NULL,
  `index_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `player`
--

INSERT INTO `player` (`player_id`, `name`, `full_name`, `age`, `index_id`) VALUES
(1, 'linh', 'nguyen linh', '18', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `player_index`
--

CREATE TABLE `player_index` (
  `id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `index_id` int(11) NOT NULL,
  `value` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `player_index`
--

INSERT INTO `player_index` (`id`, `player_id`, `index_id`, `value`) VALUES
(1, 1, 3, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `indexer`
--
ALTER TABLE `indexer`
  ADD PRIMARY KEY (`index_id`);

--
-- Chỉ mục cho bảng `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`player_id`),
  ADD KEY `index_id` (`index_id`);

--
-- Chỉ mục cho bảng `player_index`
--
ALTER TABLE `player_index`
  ADD PRIMARY KEY (`id`),
  ADD KEY `player_id` (`player_id`),
  ADD KEY `index_id` (`index_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `indexer`
--
ALTER TABLE `indexer`
  MODIFY `index_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `player`
--
ALTER TABLE `player`
  MODIFY `player_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `player_index`
--
ALTER TABLE `player_index`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`index_id`) REFERENCES `indexer` (`index_id`);

--
-- Các ràng buộc cho bảng `player_index`
--
ALTER TABLE `player_index`
  ADD CONSTRAINT `player_index_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`),
  ADD CONSTRAINT `player_index_ibfk_2` FOREIGN KEY (`index_id`) REFERENCES `indexer` (`index_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
