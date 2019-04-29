-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 29 avr. 2019 à 11:08
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

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
(53),
(53);

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
(49, '2019-04-17', 'ref-6', 'com-02', 'dep-info'),
(35, '2019-04-09', 'ref-1', 'com-02', 'dep-info'),
(37, '2019-04-10', 'ref-2', 'com-02', 'dep-info'),
(39, '2019-04-16', 'ref-3', 'com-02', 'dep-info'),
(47, '2019-04-17', 'ref-4', 'com-02', 'dep-info');

-- --------------------------------------------------------

--
-- Structure de la table `livraison_item`
--

CREATE TABLE `livraison_item` (
  `id` bigint(20) NOT NULL,
  `code_magasin` varchar(255) DEFAULT NULL,
  `qte` decimal(19,2) DEFAULT NULL,
  `refence_produit` varchar(255) DEFAULT NULL,
  `reference_commande_expression` varchar(255) DEFAULT NULL,
  `reference_reception` varchar(255) DEFAULT NULL,
  `strategy` varchar(255) DEFAULT NULL,
  `livraison` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livraison_item`
--

INSERT INTO `livraison_item` (`id`, `code_magasin`, `qte`, `refence_produit`, `reference_commande_expression`, `reference_reception`, `strategy`, `livraison`) VALUES
(50, 'mag-1', '1.00', 'pr-2', '13', '', 'fifo', 49),
(36, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 35),
(38, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 37),
(40, 'mag-1', '1.00', 'pr-2', '12', 'rec-2019-3', '', 39),
(48, 'mag-1', '1.00', 'pr-2', '12', '', 'fifo', 47);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
