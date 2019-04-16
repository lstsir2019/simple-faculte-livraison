-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 27 mars 2019 à 19:43
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
CREATE DATABASE IF NOT EXISTS `simple_faculte_livraison` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `simple_faculte_livraison`;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7),
(7);

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE `livraison` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `reference_commande` varchar(255) DEFAULT NULL,
  `reference_entite` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livraison`
--

INSERT INTO `livraison` (`id`, `date`, `reference`, `reference_commande`, `reference_entite`) VALUES
(1, '2019-03-13', 'ref-1', 'ref', 'math'),
(2, NULL, 'kf', 'fd4', 'ref-1'),
(5, '2019-03-13', 'sdfdsf', ',kjk', 'ref-1');

-- --------------------------------------------------------

--
-- Structure de la table `livraison_item`
--

CREATE TABLE `livraison_item` (
  `id` bigint(20) NOT NULL,
  `code_magasin` varchar(255) DEFAULT NULL,
  `qte` decimal(19,2) DEFAULT NULL,
  `refence_produit` varchar(255) DEFAULT NULL,
  `reference_expression_commande` varchar(255) DEFAULT NULL,
  `livraison` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livraison_item`
--

INSERT INTO `livraison_item` (`id`, `code_magasin`, `qte`, `refence_produit`, `reference_expression_commande`, `livraison`) VALUES
(1, 'mag1', '5.00', 'ref-1', 'ref-2', 1),
(3, 'mag2', '2.00', 'ref-1', NULL, 2),
(4, 'mag2', '2.00', 'ref-2', NULL, 2),
(6, 'mag1', '52.00', 'ref-1', NULL, 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `livraison_item`
--
ALTER TABLE `livraison_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5fcwkbwshrffwos4uroxsrj1j` (`livraison`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
