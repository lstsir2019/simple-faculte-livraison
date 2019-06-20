-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 20 juin 2019 à 15:39
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `simple_faculte_livraison`
--

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(95),
(95);

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`id`, `date`, `reference`, `reference_commande`, `reference_entite`) VALUES
(92, '2019-06-13', 'com-03', 'com-02', 'dep-info'),
(84, '2019-06-06', 'ref-30', 'com-02', 'dep-info'),
(90, '2019-06-10', 'ref-22', 'com-01', 'dep-bio'),
(57, '2019-05-10', 'ref-10', 'com-02', 'dep-info'),
(86, '2019-06-10', 'ref-14', 'com-01', 'dep-bio'),
(53, '2019-04-08', 'ref-8', 'com-02', 'dep-info'),
(49, '2019-04-17', 'ref-6', 'com-02', 'dep-info'),
(35, '2019-04-09', 'ref-1', 'com-02', 'dep-info'),
(37, '2019-04-10', 'ref-2', 'com-02', 'dep-info'),
(39, '2019-04-16', 'ref-3', 'com-02', 'dep-info'),
(47, '2019-04-17', 'ref-4', 'com-02', 'dep-info');

--
-- Déchargement des données de la table `livraison_item`
--

INSERT INTO `livraison_item` (`id`, `code_magasin`, `qte`, `refence_produit`, `reference_commande_expression`, `reference_reception`, `strategy`, `livraison`) VALUES
(50, 'mag-1', '1.00', 'pr-2', '13', '', 'fifo', 49),
(36, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 35),
(38, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 37),
(40, 'mag-1', '1.00', 'pr-2', '12', 'rec-2019-3', '', 39),
(48, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 47),
(54, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 53),
(58, 'mag-2', '1.00', 'pr-1', '12', '', 'fifo', 57),
(59, 'mag-1', '1.00', 'pr-2', '13', '', 'lifo', 57),
(85, 'mag-2', '2.00', 'pr-1', '12', '', 'fifo', 84),
(87, 'mag-1', '1.00', 'pr-2', '1', 'rec-2019-2', '', 86),
(91, 'mag-3', '4.00', 'pr-3', '2', 'rec-2019-2', '', 90),
(93, 'mag-1', '6.00', 'pr-2', '13', '', 'fifo', 92),
(94, 'mag-2', '2.00', 'pr-1', '12', '', 'fifo', 92);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
