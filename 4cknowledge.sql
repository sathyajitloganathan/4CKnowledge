-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 11, 2018 at 11:04 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `4cknowledge`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phonenumber` varchar(10) NOT NULL,
  `interests` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`name`, `username`, `password`, `type`, `dob`, `address`, `email`, `phonenumber`, `interests`) VALUES
('a', 'a', 'wk33rftqsvc9pLhGnhnZSQ==', 'U', '12', 'qwe', 'qe@gmail.com', '2323232323', ' ai'),
('aa', 'aa', 'U8FdnRix0KATh4JNVXl2rQ==', 'U', '11111111', '23 ds', 'we@g.com', '9898989898', ' ai'),
('admin', 'admin', 'aliv/jZ2ur6kYXLP+CeJFQ==', 'a', '19962410', 'rewerer', 'ddas@gasd.com', '2312312312', 'None'),
('bluetre', 'bleu', '4ZyHyu6WT22SVvHCBsrvDg==', 'U', '19762307', '23, rerw, ttrtr', 'bleu@gmail.com', '6666666666', ' ai politics'),
('gallileo', 'g', 'IBINTwHP/vhDpo7j2pU9OQ==', 'U', '19762307', '23, trer,werwe', 'gal@gmail.com', '0768989809', ' ai image-processing sci-fi politics'),
('lk_tripling', 'lk', 'Me24LBqIrMHWvoHLK8qxZw==', 'U', '196732', '23,wer,wew', 'lk@gmail.com', '9456564545', ' ai politics religious'),
('logan', 'log', 'vCqgY3gGFCkwksEXuQYySw==', 'U', '12332323', '521/1, trello, Colombo - 06', 'tranquility@gmail.com', '9879879879', ' ai image-processing sci-fi politics religious art'),
('o', 'oo', '2Z0vg6LTxbhiiscUpCAnaw==', 'U', 'o', 'o', 'o@kjh.bom', '9999999999', ' ai'),
('oi', 'oi', 'DZsqjC9RFy4XRhNpahfRAw==', 'U', '197623', '23,wer,rew', 'trer@gmail.com', '9898989898', ' ai politics religious'),
('owner', 'owner', 'lSOL+9coP/m8LFVWyHHPWg==', 'o', '19962410', 'rqqrqr', 'asdasd@gmail.com', '1234567890', 'ai'),
('Peter', 'peter', 'hvqSlgpQkvsS+xdMv/Q01w==', 'U', '19953234', '32, Barnes Place, Colombo -07', 'peterham@gmail.com', '0764329043', ' ai'),
('redandgreen', 'rg', 'EAGRQoZ/unudJt37kTUtoA==', 'U', '19672304', '23, galle road, Matara', 'red@blue.com', '0764342334', ' ai image-processing'),
('rr', 'rr', 'IZRkQA4pXa4YaXRJNJ0Z+g==', 'U', '19962410', '34, Wall Street, Amsterdam', 'peterpen@gmail.com', '6656656656', ' ai image-processing sci-fi'),
('Trojan', 'troy', 'rwDQ6e/1TLtTZFK40QruaA==', 'U', '19880304', '54, Dome Avenue, Greece', 'troy@gmail.com', '0768545445', ' ai image-processing sci-fi'),
('W', 'w', 'fWg41w73Ae4+QWfuMG8nMQ==', 'U', '123', 'qweqwe', 'w@g.com', '2222222222', ' ai'),
('yellow', 'yel', '45YjY1raN7hjJFCLxji+IQ==', 'U', '19760403', '12, erwe, adsd', 'asd@gmail.com', '0768787878', ' ai image-processing');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`name`,`username`,`password`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
