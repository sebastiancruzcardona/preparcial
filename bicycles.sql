-- Adminer 4.8.1 MySQL 8.3.0 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `bicycles`;
CREATE TABLE `bicycles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(20) NOT NULL,
  `type` varchar(5) NOT NULL,
  `weight` float NOT NULL,
  `chainring_size` int NOT NULL,
  `color` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `bicycles` (`id`, `manufacturer`, `type`, `weight`, `chainring_size`, `color`) VALUES
(1,	'Trek',	'road',	6.8,	53,	'red'),
(2,	'Cannondale',	'road',	7.2,	54,	'black'),
(3,	'Specialized',	'mtb',	10.25,	40,	'navy blue');

-- 2024-03-02 02:16:42
