-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: iul. 09, 2024 la 12:42 PM
-- Versiune server: 10.4.28-MariaDB
-- Versiune PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `hospital_system`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `analize_medicale`
--

CREATE TABLE `analize_medicale` (
  `id_analize` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `id_doc` int(6) NOT NULL,
  `tip_analiza` varchar(255) NOT NULL,
  `data_efectuare` date NOT NULL,
  `rezultate` varchar(255) NOT NULL,
  `valori_normale` varchar(255) NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `asistent`
--

CREATE TABLE `asistent` (
  `id_asistent` int(6) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `cnp` int(13) NOT NULL,
  `data_nasterii` date NOT NULL,
  `gen` varchar(30) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tip_asistent` varchar(255) NOT NULL,
  `etaj` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `doctor`
--

CREATE TABLE `doctor` (
  `id_doc` int(6) NOT NULL,
  `titlu` varchar(255) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `CNP` int(13) NOT NULL,
  `data_nasterii` date NOT NULL,
  `gen` varchar(30) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `departament` varchar(255) NOT NULL,
  `specializare` varchar(255) NOT NULL,
  `etaj` int(6) NOT NULL,
  `competente` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `garda`
--

CREATE TABLE `garda` (
  `id_garda` int(6) NOT NULL,
  `id_doc` int(6) NOT NULL,
  `id_asistent` int(6) NOT NULL,
  `pers_tip` varchar(255) NOT NULL,
  `data_inceput` date NOT NULL,
  `data_sfarsit` date NOT NULL,
  `nr_pacienti_ingrijiti` int(6) NOT NULL,
  `consumabile_folosite` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `internari`
--

CREATE TABLE `internari` (
  `id_internare` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `data` date NOT NULL,
  `motiv` varchar(255) NOT NULL,
  `greutate` varchar(30) NOT NULL,
  `puls` varchar(30) NOT NULL,
  `tensiune` varchar(30) NOT NULL,
  `bolnav_cronic` tinyint(1) NOT NULL,
  `alergii` varchar(255) NOT NULL,
  `diagnostic` varchar(255) NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `istoric_pacienti`
--

CREATE TABLE `istoric_pacienti` (
  `id_ist` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `id_programare` int(6) NOT NULL,
  `id_internare` int(6) NOT NULL,
  `id_doc` int(6) NOT NULL,
  `id_analize` int(6) NOT NULL,
  `id_med` int(6) NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `medicamente`
--

CREATE TABLE `medicamente` (
  `id_medicament` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `nume_medicament` varchar(255) NOT NULL,
  `doza` varchar(30) NOT NULL,
  `data_inceput` date NOT NULL,
  `ora` time NOT NULL,
  `data_sfarsit` date NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `pacienti`
--

CREATE TABLE `pacienti` (
  `id_pacient` int(6) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `cnp` int(13) NOT NULL,
  `data_nasterii` date NOT NULL,
  `gen` varchar(30) NOT NULL,
  `varsta` int(4) NOT NULL,
  `adresa` varchar(500) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `grupa_sange` varchar(30) NOT NULL,
  `rh` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `programari`
--

CREATE TABLE `programari` (
  `id_programare` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `id_doc` int(6) NOT NULL,
  `data_programare` date NOT NULL,
  `ora` time NOT NULL,
  `motiv` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(6) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL,
  `utip` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `analize_medicale`
--
ALTER TABLE `analize_medicale`
  ADD PRIMARY KEY (`id_analize`);

--
-- Indexuri pentru tabele `asistent`
--
ALTER TABLE `asistent`
  ADD PRIMARY KEY (`id_asistent`),
  ADD UNIQUE KEY `cnp` (`cnp`);

--
-- Indexuri pentru tabele `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id_doc`),
  ADD UNIQUE KEY `CNP` (`CNP`);

--
-- Indexuri pentru tabele `garda`
--
ALTER TABLE `garda`
  ADD PRIMARY KEY (`id_garda`);

--
-- Indexuri pentru tabele `internari`
--
ALTER TABLE `internari`
  ADD PRIMARY KEY (`id_internare`);

--
-- Indexuri pentru tabele `istoric_pacienti`
--
ALTER TABLE `istoric_pacienti`
  ADD PRIMARY KEY (`id_ist`);

--
-- Indexuri pentru tabele `pacienti`
--
ALTER TABLE `pacienti`
  ADD PRIMARY KEY (`id_pacient`),
  ADD UNIQUE KEY `cnp` (`cnp`);

--
-- Indexuri pentru tabele `programari`
--
ALTER TABLE `programari`
  ADD PRIMARY KEY (`id_programare`);

--
-- Indexuri pentru tabele `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
