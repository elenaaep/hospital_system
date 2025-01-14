-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: ian. 09, 2025 la 10:52 PM
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
  `executant_analize` varchar(255) NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `analize_medicale`
--

INSERT INTO `analize_medicale` (`id_analize`, `id_pacient`, `id_doc`, `tip_analiza`, `data_efectuare`, `rezultate`, `valori_normale`, `executant_analize`, `observatii`) VALUES
(100001, 1, 123456, 'Hemoglobina', '2024-07-01', '12 g/dL', '12-16 g/dL', 'Dr. Ion Popescu', 'Analiza hemoglobinei în limite normale'),
(100002, 1, 123456, 'Leucocite', '2024-07-01', '8000/mm3', '4000-11000/mm3', 'Dr. Ion Popescu', 'Leucocite în limite normale'),
(100003, 3, 234567, 'Proteine urinare', '2024-07-02', 'Negative', 'Negative', 'Dr. Maria Ionescu', 'Absența proteinelor în urină'),
(100004, 3, 234567, 'Glucoză urinară', '2024-07-02', 'Negativă', 'Negativă', 'Dr. Maria Ionescu', 'Glucoză absentă în urină'),
(100005, 3, 234567, 'Leucocite urinare', '2024-07-02', '5-7/μL', '0-4/μL', 'Dr. Maria Ionescu', 'Număr normal de leucocite în urină'),
(100006, 5, 456789, 'Ficat - ecografie', '2024-07-03', 'Dimensiuni normale', '12-15 cm', 'Dr. Ana Pop', 'Ficat cu dimensiuni normale'),
(100007, 5, 456789, 'Vezică biliară - ecografie', '2024-07-03', 'Fără calculi', 'Fără calculi', 'Dr. Ana Pop', 'Absența calculilor în vezică'),
(100008, 5, 456789, 'Rinichi - ecografie', '2024-07-03', 'Aspect normal', 'Dimensiune normală', 'Dr. Ana Pop', 'Aspect normal al rinichilor'),
(100009, 7, 678901, 'RMN cerebral', '2024-07-04', 'Imagini normale', 'Fără semne patologice', 'Dr. Alexandru Constantin', 'Rezultate normale la RMN cerebral'),
(100010, 9, 890123, 'EKG de efort', '2024-07-05', 'Ritm normal', 'Normal', 'Dr. Adrian Georgescu', 'EKG normal la efort');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `asistent`
--

CREATE TABLE `asistent` (
  `id_asistent` int(6) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `cnp` varchar(13) NOT NULL,
  `data_nasterii` date NOT NULL,
  `gen` varchar(255) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tip_asistent` varchar(255) NOT NULL,
  `etaj` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `asistent`
--

INSERT INTO `asistent` (`id_asistent`, `nume`, `prenume`, `cnp`, `data_nasterii`, `gen`, `tel`, `email`, `tip_asistent`, `etaj`) VALUES
(1023, 'Radu', 'George', '1870614123456', '1987-06-14', 'Masculin', 723456798, 'george.radu@gmail.com', 'Psihiatrie', 5),
(1234, 'Mihailescu', 'Ioana', '2810515156789', '1981-05-15', 'Feminin', 723456789, 'ioana.mihailescu@gmail.com', 'Generalist', 3),
(2345, 'Marinescu', 'Dan', '1740820123456', '1974-08-20', 'Masculin', 723456790, 'dan.marinescu@gmail.com', 'Pediatrie', 1),
(3456, 'Popa', 'Elena', '2900210123456', '1990-02-10', 'Feminin', 723456791, 'elena.popa@gmail.com', 'Chirurgie', 5),
(4567, 'Dumitrescu', 'Vlad', '1721130123456', '1972-11-30', 'Masculin', 723456792, 'vlad.dumitrescu@gmail.com', 'Neurologie', 3),
(5678, 'Stoica', 'Maria', '2850725123456', '1985-07-25', 'Feminin', 723456793, 'maria.stoica@gmail.com', 'Cardiologie', 3),
(6789, 'Ionescu', 'Cristian', '1830418123456', '1983-04-18', 'Masculin', 723456794, 'cristian.ionescu@gmail.com', 'Ginecologie', 4),
(7890, 'Petrescu', 'Ana', '2900105123456', '1990-01-05', 'Feminin', 723456795, 'ana.petrescu@gmail.com', 'Dermatologie', 2),
(8901, 'Nicolescu', 'Andrei', '1810912123456', '1981-09-12', 'Masculin', 723456796, 'andrei.nicolescu@gmail.com', 'Oftalmologie', 4),
(9012, 'Vasilescu', 'Adriana', '2780328123456', '1978-03-28', 'Feminin', 723456797, 'adriana.vasilescu@gmail.com', 'Endocrinologie', 3);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `doctor`
--

CREATE TABLE `doctor` (
  `id_doc` int(6) NOT NULL,
  `titlu` varchar(255) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `prenume` varchar(255) NOT NULL,
  `CNP` varchar(13) NOT NULL,
  `data_nasterii` date NOT NULL,
  `gen` varchar(255) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `departament` varchar(255) NOT NULL,
  `specializare` varchar(255) NOT NULL,
  `etaj` int(6) NOT NULL,
  `competente` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `doctor`
--

INSERT INTO `doctor` (`id_doc`, `titlu`, `nume`, `prenume`, `CNP`, `data_nasterii`, `gen`, `tel`, `email`, `departament`, `specializare`, `etaj`, `competente`) VALUES
(123045, 'Dr. Prof.', 'Florescu', 'Gabriel', '1870614123456', '1987-06-14', 'Masculin', 723456798, 'gabriel.florescu@gmail.com', 'Psihiatrie', 'Psihiatru', 5, 'Psihoterapie, Tulburări de personalitate'),
(123456, 'Dr. Prof.', 'Popescu', 'Ana', '2800515156789', '1980-05-15', 'Feminin', 723456789, 'ana.popescu@gmail.com', 'Cardiologie', 'Cardiolog', 3, 'Ecocardiografie, Cardiologie intervențională'),
(234567, 'Dr. Prof.', 'Ionescu', 'Mihai', '1750820123456', '1975-08-20', 'Masculin', 723456790, 'mihai.ionescu@gmail.com', 'Chirurgie generală', 'Chirurg general', 5, 'Chirurgie laparoscopică, Chirurgie de urgentă'),
(345678, 'Dr.', 'Pop', 'Ioana', '2880210123456', '1988-02-10', 'Feminin', 723456791, 'ioana.pop@gmail.com', 'Ortopedie', 'Ortoped', 2, 'Chirurgie artroscopică, Traumatologie'),
(456789, 'Dr. Conf.', 'Andrei', 'Vasile', '1721130123456', '1972-11-30', 'Masculin', 723456792, 'vasile.andrei@gmail.com', 'Pediatrie', 'Pediatrie generală', 1, 'Pediatrie preventivă, Neonatologie'),
(567890, 'Dr.', 'Radu', 'Elena', '2850725123456', '1985-07-25', 'Feminin', 723456793, 'elena.radu@gmail.com', 'Ginecologie', 'Ginecolog', 4, 'Obstetrică, Ecografie ginecologică'),
(678901, 'Dr. Prof.', 'Constantin', 'Alexandru', '1830418123456', '1983-04-18', 'Masculin', 723456794, 'alexandru.constantin@gmail.com', 'Neurologie', 'Neurolog', 3, 'Neuroimunologie, Neuropsihiatrie'),
(789012, 'Dr.', 'Dumitru', 'Maria', '2900105123456', '1990-01-05', 'Feminin', 723456795, 'maria.dumitru@gmail.com', 'Dermatologie', 'Dermatolog', 2, 'Dermatologie pediatrică, Dermatochirurgie'),
(890123, 'Dr.', 'Georgescu', 'Adrian', '1810912123456', '1981-09-12', 'Masculin', 723456796, 'adrian.georgescu@gmail.com', 'Oftalmologie', 'Oftalmolog', 4, 'Chirurgie refractivă, Glaucom'),
(901234, 'Dr. Conf.', 'Stanciu', 'Ana-Maria', '2780328123456', '1978-03-28', 'Feminin', 723456797, 'ana-maria.stanciu@gmail.com', 'Endocrinologie', 'Endocrinolog', 3, 'Diabet zaharat, Boli metabolice');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `garda`
--

CREATE TABLE `garda` (
  `id_garda` int(6) NOT NULL,
  `id_doc` int(6) DEFAULT NULL,
  `id_asistent` int(6) DEFAULT NULL,
  `pers_tip` varchar(255) NOT NULL,
  `data_inceput` date NOT NULL,
  `data_sfarsit` date NOT NULL,
  `nr_pacienti_ingrijiti` int(6) NOT NULL,
  `consumabile_folosite` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `garda`
--

INSERT INTO `garda` (`id_garda`, `id_doc`, `id_asistent`, `pers_tip`, `data_inceput`, `data_sfarsit`, `nr_pacienti_ingrijiti`, `consumabile_folosite`) VALUES
(100001, 123456, NULL, 'Doctor', '2024-07-01', '2024-07-01', 10, '10 Mănuși, 10 Măști, 6 Seringi'),
(100002, 234567, NULL, 'Doctor', '2024-07-02', '2024-07-02', 12, '12 Mănuși, 12 Măști, 3 Bandaje'),
(100003, 345678, NULL, 'Doctor', '2024-07-03', '2024-07-03', 15, '15 Mănuși, 15 Măști, 2 Atele'),
(100004, 456789, NULL, 'Doctor', '2024-07-04', '2024-07-04', 8, '8 Mănuși, 8 Măști, 1 Dezinfectant'),
(100005, 567890, NULL, 'Doctor', '2024-07-05', '2024-07-05', 9, '9 Mănuși, 9 Măști, 6 Seringi'),
(100006, 678901, NULL, 'Doctor', '2024-07-06', '2024-07-06', 11, '11 Mănuși,11 Măști, 3 Atele'),
(100007, 789012, NULL, 'Doctor', '2024-07-07', '2024-07-07', 13, '13 Mănuși, 13 Măști, 5 Bandaje'),
(100008, 890123, NULL, 'Doctor', '2024-07-08', '2024-07-08', 7, '7 Mănuși, 7 Măști, 1 Dezinfectant'),
(100009, 901234, NULL, 'Doctor', '2024-07-09', '2024-07-09', 14, '14 Mănuși, 14 Măști, 10 Seringi'),
(100010, 123045, NULL, 'Doctor', '2024-07-10', '2024-07-10', 10, '10 Mănuși, 10 Măști, 2 Atele'),
(100011, NULL, 1234, 'Asistent', '2024-07-01', '2024-07-01', 10, '10 Mănuși, 10 Măști, 3 Serengi'),
(100012, NULL, 2345, 'Asistent', '2024-07-02', '2024-07-02', 12, '12 Mănuși, 12 Măști, 5 Bandaje'),
(100013, NULL, 3456, 'Asistent', '2024-07-03', '2024-07-03', 15, '15 Mănuși, 15 Măști, 7 Perfuzii'),
(100014, NULL, 4567, 'Asistent', '2024-07-04', '2024-07-04', 8, '8 Mănuși, 8 Măști, 3 Perfuzii'),
(100015, NULL, 5678, 'Asistent', '2024-07-05', '2024-07-05', 9, '9 Mănuși, 9 Măști, 5 Seringi'),
(100016, NULL, 6789, 'Asistent', '2024-07-06', '2024-07-06', 11, '11 Mănuși, 11 Măști, 2 Ghips'),
(100017, NULL, 7890, 'Asistent', '2024-07-07', '2024-07-07', 13, '13 Mănuși, 13 Măști, 8 Pansamente'),
(100018, NULL, 8901, 'Asistent', '2024-07-08', '2024-07-08', 7, '7 Mănuși, 7 Măști, 6 Antiseptice'),
(100019, NULL, 9012, 'Asistent', '2024-07-09', '2024-07-09', 14, '14 Mănuși, 14 Măști, 9 Seringi'),
(100020, NULL, 1023, 'Asistent', '2024-07-10', '2024-07-10', 10, '10 Mănuși, 10 Măști, 2 Masti de oxigen');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `internari`
--

CREATE TABLE `internari` (
  `id_internare` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `data` date NOT NULL,
  `motiv` varchar(255) NOT NULL,
  `greutate` varchar(255) NOT NULL,
  `puls` varchar(255) NOT NULL,
  `tensiune` varchar(255) NOT NULL,
  `bolnav_cronic` tinyint(1) NOT NULL,
  `alergii` varchar(255) NOT NULL,
  `diagnostic` varchar(255) NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `internari`
--

INSERT INTO `internari` (`id_internare`, `id_pacient`, `data`, `motiv`, `greutate`, `puls`, `tensiune`, `bolnav_cronic`, `alergii`, `diagnostic`, `observatii`) VALUES
(100001, 1, '2024-07-01', 'Accident rutier', '70 kg', '75 bpm', '120/80 mmHg', 0, 'N/A', 'Contuzie minoră', 'Monitorizare 24 ore'),
(100002, 2, '2024-07-02', 'Apendicită acută', '65 kg', '80 bpm', '110/70 mmHg', 0, 'Penicilină', 'Apendicectomie', 'Intervenție chirurgicală de urgență'),
(100003, 3, '2024-07-03', 'Diabet decompensat', '85 kg', '90 bpm', '130/85 mmHg', 1, 'N/A', 'Diabet tip 2', 'Reglare tratament și dietă'),
(100004, 4, '2024-07-04', 'Insuficiență renală', '75 kg', '70 bpm', '140/90 mmHg', 1, 'N/A', 'Insuficiență renală cronică', 'Dializă de urgență'),
(100005, 5, '2024-07-05', 'Fractură femurală', '80 kg', '72 bpm', '115/75 mmHg', 0, 'N/A', 'Fractură deschisă', 'Intervenție ortopedică'),
(100006, 6, '2024-07-06', 'Criză astmatică', '60 kg', '85 bpm', '125/80 mmHg', 1, 'Polen', 'Astm bronșic', 'Tratament bronhodilatator'),
(100007, 7, '2024-07-07', 'Infarct miocardic', '90 kg', '100 bpm', '150/95 mmHg', 1, 'Aspirină', 'Infarct miocardic acut', 'Angioplastie coronariană'),
(100008, 8, '2024-07-08', 'Pneumonie', '70 kg', '78 bpm', '118/78 mmHg', 0, 'N/A', 'Pneumonie bacteriană', 'Antibioterapie și oxigenoterapie'),
(100009, 9, '2024-07-09', 'Hernie inghinală', '85 kg', '65 bpm', '110/70 mmHg', 0, 'N/A', 'Hernie inghinală', 'Intervenție chirurgicală planificată'),
(100010, 10, '2024-07-10', 'Pancreatită acută', '95 kg', '88 bpm', '135/85 mmHg', 0, 'N/A', 'Pancreatită acută', 'Tratament antiinflamator și regim alimentar strict');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `istoric_pacienti`
--

CREATE TABLE `istoric_pacienti` (
  `id_ist` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `id_programare` int(6) DEFAULT NULL,
  `id_internare` int(6) DEFAULT NULL,
  `id_doc` int(6) DEFAULT NULL,
  `id_analize` int(6) DEFAULT NULL,
  `id_tratament` int(6) DEFAULT NULL,
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
  `cnp` varchar(13) NOT NULL,
  `data_nasterii` date NOT NULL,
  `gen` varchar(255) NOT NULL,
  `varsta` int(4) NOT NULL,
  `adresa` varchar(500) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `grupa_sange` varchar(255) NOT NULL,
  `rh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `pacienti`
--

INSERT INTO `pacienti` (`id_pacient`, `nume`, `prenume`, `cnp`, `data_nasterii`, `gen`, `varsta`, `adresa`, `tel`, `email`, `grupa_sange`, `rh`) VALUES
(1, 'Popa', 'Ana-Maria', '2880615223456', '1988-06-15', 'Feminin', 36, 'Strada Crizantemelor, nr. 3, Galați', 766666666, 'andreea.mihai@gmail.com', 'A', 'Pozitiv'),
(2, 'Vasilescu', 'Mihai', '1780717234567', '1978-07-17', 'Masculin', 45, 'Bulevardul Brăilei, nr. 10, Galați', 722222222, 'mihai.vasilescu@gmail.com', 'B', 'Negativ'),
(3, 'Iordache', 'Elena', '2930218234568', '1993-02-18', 'Feminin', 31, 'Aleea Buciumului, nr. 5, Galați', 733333333, 'elena.iordache@gmail.com', 'AB', 'Pozitiv'),
(4, 'Stoica', 'Alexandru', '1810419243569', '1981-04-19', 'Masculin', 43, 'Strada 1 Decembrie, nr. 15, Galați', 744444444, 'alexandru.stoica@gmail.com', 'O', 'Negativ'),
(5, 'Radu', 'Mihaela', '2820803254670', '1982-08-03', 'Feminin', 42, 'Bulevardul Dunării, nr. 30, Galați', 755555555, 'mihaela.radu@gmail.com', 'AB', 'Pozitiv'),
(6, 'Mihai', 'Andreea', '2900327123456', '1990-03-27', 'Feminin', 34, 'Strada Unirii, nr. 25, Galați', 766666666, 'andreea.mihai@gmail.com', 'A', 'Pozitiv'),
(7, 'Dobre', 'George', '1850218123456', '1985-02-18', 'Masculin', 39, 'Bulevardul Independenței, nr. 12, Galați', 777777777, 'george.dobre@gmail.com', 'B', 'Negativ'),
(8, 'Stanciu', 'Maria', '2810422123456', '1981-04-22', 'Feminin', 43, 'Strada Crângului, nr. 8, Galați', 788888888, 'maria.stanciu@gmail.com', 'AB', 'Pozitiv'),
(9, 'Ion', 'Victor', '2750623123456', '1975-06-23', 'Masculin', 49, 'Aleea Azurului, nr. 17, Galați', 799999999, 'victor.ion@gmail.com', 'O', 'Negativ'),
(10, 'Constantinescu', 'Anca', '2880801123456', '1988-08-01', 'Feminin', 36, 'Bulevardul Dunării, nr. 40, Galați', 701112222, 'anca.constantinescu@gmail.com', 'AB', 'Pozitiv'),
(11, 'Florescu', 'Radu', '2820915123456', '1982-09-15', 'Masculin', 41, 'Strada Vântului, nr. 3, Galați', 702223333, 'radu.florescu@gmail.com', 'A', 'Pozitiv'),
(12, 'Dumitrache', 'Mihaela', '2771018123456', '1977-10-18', 'Feminin', 46, 'Bulevardul Basarabiei, nr. 55, Galați', 703334444, 'mihaela.dumitrache@gmail.com', 'B', 'Negativ'),
(13, 'Balan', 'Ionuț', '2941102123456', '1994-11-02', 'Masculin', 30, 'Strada Plopilor, nr. 7, Galați', 704445555, 'ionut.balan@gmail.com', 'AB', 'Pozitiv'),
(14, 'Popovici', 'Ana', '2861223123456', '1986-12-23', 'Feminin', 37, 'Aleea Rozelor, nr. 9, Galați', 705556666, 'ana.popovici@gmail.com', 'O', 'Negativ'),
(15, 'Cristea', 'Gabriel', '2890305123456', '1989-03-05', 'Masculin', 35, 'Strada Libertății, nr. 15, Galați', 706667777, 'gabriel.cristea@gmail.com', 'A', 'Pozitiv');

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

--
-- Eliminarea datelor din tabel `programari`
--

INSERT INTO `programari` (`id_programare`, `id_pacient`, `id_doc`, `data_programare`, `ora`, `motiv`) VALUES
(101, 1, 123456, '2024-07-01', '08:30:00', 'Consult general'),
(102, 2, 234567, '2024-07-02', '09:15:00', 'Investigații cardiologice'),
(103, 3, 345678, '2024-07-03', '10:00:00', 'Tratament ortopedic'),
(104, 4, 456789, '2024-07-04', '11:00:00', 'Consultație pediatrică'),
(105, 5, 567890, '2024-07-05', '12:00:00', 'Tratament ginecologic'),
(106, 6, 678901, '2024-07-06', '13:00:00', 'Consult neurologic'),
(107, 7, 789012, '2024-07-07', '14:00:00', 'Investigații dermatologice'),
(108, 8, 890123, '2024-07-08', '15:00:00', 'Consultație oftalmologică'),
(109, 9, 901234, '2024-07-09', '16:00:00', 'Tratament endocrinologic'),
(110, 10, 123045, '2024-07-10', '17:00:00', 'Consultație psihiatrică');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `tratamente`
--

CREATE TABLE `tratamente` (
  `id_tratament` int(6) NOT NULL,
  `id_pacient` int(6) NOT NULL,
  `denumire_tratament` varchar(255) NOT NULL,
  `doza` varchar(255) NOT NULL,
  `data_inceput` date NOT NULL,
  `ora` time NOT NULL,
  `data_sfarsit` date NOT NULL,
  `observatii` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `tratamente`
--

INSERT INTO `tratamente` (`id_tratament`, `id_pacient`, `denumire_tratament`, `doza`, `data_inceput`, `ora`, `data_sfarsit`, `observatii`) VALUES
(10001, 1, 'Paracetamol', '500 mg', '2024-07-01', '08:00:00', '2024-07-05', 'La fiecare 6 ore'),
(10002, 2, 'Amoxicilin', '250 mg', '2024-07-02', '09:30:00', '2024-07-06', 'Dimineața și seara'),
(10003, 3, 'Ibuprofen', '400 mg', '2024-07-03', '10:00:00', '2024-07-07', 'O dată pe zi'),
(10004, 4, 'Omeprazol', '20 mg', '2024-07-04', '12:00:00', '2024-07-08', 'Dimineața înainte de masă'),
(10005, 5, 'Metformin', '1000 mg', '2024-07-05', '08:30:00', '2024-07-09', 'Dimineața și seara'),
(10006, 6, 'Atorvastatin', '40 mg', '2024-07-06', '07:45:00', '2024-07-10', 'O dată pe zi la cină'),
(10007, 7, 'Losartan', '50 mg', '2024-07-07', '11:00:00', '2024-07-11', 'La fiecare 12 ore'),
(10008, 8, 'Warfarin', '5 mg', '2024-07-08', '18:00:00', '2024-07-12', 'O dată pe zi seara'),
(10009, 9, 'Digoxin', '0.25 mg', '2024-07-09', '14:30:00', '2024-07-13', 'Dimineața înainte de micul dejun'),
(10010, 10, 'Morfina', '10 mg', '2024-07-10', '10:45:00', '2024-07-14', 'La nevoie pentru durere');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL,
  `utip` varchar(255) NOT NULL,
  `id_doc` int(6) DEFAULT NULL,
  `id_pacient` int(6) DEFAULT NULL,
  `id_asistent` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `parola`, `utip`, `id_doc`, `id_pacient`, `id_asistent`) VALUES
('admin', 'admin', '$2a$12$C7oH8VQjGNq1kt6fO1zIbeo8FIrWMcdb7AFAsjRdzr98fEpFWAlYK', 'Admin', NULL, NULL, NULL),
('ang123045', 'Florescu Gabriel', '$2a$12$XIi5WQuTl4IuwLty02KB1ujA.BHR4txW8p6qEPpLzHxezWzGgEDiu', 'Doctor', 123045, NULL, NULL),
('ang8901', 'Nicolaescu Andrei', '$2a$12$gndQQXbsxXTH1EXNP3KwoOGNhUVx7PnAa9Hc9cIUqZF4cRJBrGoZy', 'Asistent', NULL, NULL, 8901),
('pac6', 'Mihai Andreea', '$2a$12$XfJmJHyfE2GAza5tacLfuug0UAQZdLsD3LrQVQ2MgUnw3xUFIyhLq', 'Pacient', NULL, 6, NULL),
('test123', 'test', '$2a$12$XWTTElxqyzvD9WEql4NeDumK9/wtPXhvRnCThwpuo/N2lA7n2x7yC', 'Doctor', NULL, NULL, NULL);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `analize_medicale`
--
ALTER TABLE `analize_medicale`
  ADD PRIMARY KEY (`id_analize`),
  ADD KEY `id_pacient` (`id_pacient`),
  ADD KEY `id_doc2` (`id_doc`);

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
  ADD PRIMARY KEY (`id_garda`),
  ADD KEY `fk_garda_id_doc` (`id_doc`),
  ADD KEY `fk_garda_id_asistent` (`id_asistent`);

--
-- Indexuri pentru tabele `internari`
--
ALTER TABLE `internari`
  ADD PRIMARY KEY (`id_internare`),
  ADD KEY `id_pacienti` (`id_pacient`);

--
-- Indexuri pentru tabele `istoric_pacienti`
--
ALTER TABLE `istoric_pacienti`
  ADD PRIMARY KEY (`id_ist`),
  ADD KEY `id_pacient3` (`id_pacient`),
  ADD KEY `id_doc3` (`id_doc`),
  ADD KEY `id_analize` (`id_analize`),
  ADD KEY `id_internare` (`id_internare`),
  ADD KEY `id_med` (`id_tratament`),
  ADD KEY `id_programare` (`id_programare`);

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
  ADD PRIMARY KEY (`id_programare`),
  ADD KEY `id_pacient2` (`id_pacient`),
  ADD KEY `id_doc1` (`id_doc`);

--
-- Indexuri pentru tabele `tratamente`
--
ALTER TABLE `tratamente`
  ADD PRIMARY KEY (`id_tratament`),
  ADD KEY `id_pacient1` (`id_pacient`);

--
-- Indexuri pentru tabele `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_doc` (`id_doc`),
  ADD KEY `id_asistent` (`id_asistent`),
  ADD KEY `id_pacient6` (`id_pacient`);

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `analize_medicale`
--
ALTER TABLE `analize_medicale`
  ADD CONSTRAINT `id_doc2` FOREIGN KEY (`id_doc`) REFERENCES `doctor` (`id_doc`),
  ADD CONSTRAINT `id_pacient` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`);

--
-- Constrângeri pentru tabele `garda`
--
ALTER TABLE `garda`
  ADD CONSTRAINT `fk_garda_id_asistent` FOREIGN KEY (`id_asistent`) REFERENCES `asistent` (`id_asistent`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_garda_id_doc` FOREIGN KEY (`id_doc`) REFERENCES `doctor` (`id_doc`) ON DELETE SET NULL;

--
-- Constrângeri pentru tabele `internari`
--
ALTER TABLE `internari`
  ADD CONSTRAINT `id_pacienti` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`);

--
-- Constrângeri pentru tabele `istoric_pacienti`
--
ALTER TABLE `istoric_pacienti`
  ADD CONSTRAINT `id_analize` FOREIGN KEY (`id_analize`) REFERENCES `analize_medicale` (`id_analize`),
  ADD CONSTRAINT `id_doc3` FOREIGN KEY (`id_doc`) REFERENCES `doctor` (`id_doc`),
  ADD CONSTRAINT `id_internare` FOREIGN KEY (`id_internare`) REFERENCES `internari` (`id_internare`),
  ADD CONSTRAINT `id_med` FOREIGN KEY (`id_tratament`) REFERENCES `tratamente` (`id_tratament`),
  ADD CONSTRAINT `id_pacient3` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`),
  ADD CONSTRAINT `id_programare` FOREIGN KEY (`id_programare`) REFERENCES `programari` (`id_programare`);

--
-- Constrângeri pentru tabele `programari`
--
ALTER TABLE `programari`
  ADD CONSTRAINT `id_doc1` FOREIGN KEY (`id_doc`) REFERENCES `doctor` (`id_doc`),
  ADD CONSTRAINT `id_pacient2` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`);

--
-- Constrângeri pentru tabele `tratamente`
--
ALTER TABLE `tratamente`
  ADD CONSTRAINT `id_pacient1` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`);

--
-- Constrângeri pentru tabele `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `id_asistent` FOREIGN KEY (`id_asistent`) REFERENCES `asistent` (`id_asistent`),
  ADD CONSTRAINT `id_doc` FOREIGN KEY (`id_doc`) REFERENCES `doctor` (`id_doc`),
  ADD CONSTRAINT `id_pacient6` FOREIGN KEY (`id_pacient`) REFERENCES `pacienti` (`id_pacient`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
