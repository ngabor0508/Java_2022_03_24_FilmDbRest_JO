-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Már 06. 22:04
-- Kiszolgáló verziója: 10.4.22-MariaDB
-- PHP verzió: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `filmdb_java`
--
CREATE DATABASE IF NOT EXISTS `filmdb_java` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci;
USE `filmdb_java`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `filmek`
--

CREATE TABLE `filmek` (
  `id` int(11) NOT NULL,
  `cim` varchar(150) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `kategoria` varchar(150) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `hossz` int(3) NOT NULL,
  `ertekeles` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `filmek`
--

INSERT INTO `filmek` (`id`, `cim`, `kategoria`, `hossz`, `ertekeles`) VALUES
(1, 'A remény rabjai', 'dráma', 144, 9),
(2, 'A keresztapa', 'krimi, dráma', 175, 9),
(3, 'A keresztapa II', 'krimi, dráma', 202, 9),
(4, 'A sötét lovag', 'akció, krimi, dráma', 152, 9),
(5, 'Tizenkét dühös ember', 'krimi, dráma', 96, 9),
(6, 'Casablanca', 'dráma, romantikus, háborús', 102, 8);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `filmek`
--
ALTER TABLE `filmek`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `filmek`
--
ALTER TABLE `filmek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
