-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 16 mars 2018 à 22:50
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `b7_21575186_main_database`
--

-- --------------------------------------------------------

--
-- Structure de la table `table_petit_magasin`
--

DROP TABLE IF EXISTS `table_petit_magasin`;
CREATE TABLE IF NOT EXISTS `table_petit_magasin` (
  `ID_rayon` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_rayon` varchar(200) NOT NULL,
  `estCarre` tinyint(1) NOT NULL DEFAULT '0',
  `X0` int(11) DEFAULT NULL COMMENT 'Abscisse du 1er point si non carré, sinon point en haut à gauche',
  `Y0` int(11) DEFAULT NULL COMMENT 'Ordonnée du 1ème point si non carré, sinon point en haut à droite',
  `X1` int(11) DEFAULT NULL COMMENT '	Abscisse du 2ème point si non carré, sinon point en haut à droite',
  `Y1` int(11) DEFAULT NULL COMMENT '	Ordonnée du 2ème point si non carré, sinon point en haut à gauche	',
  `X2` int(11) DEFAULT NULL,
  `Y2` int(11) DEFAULT NULL,
  `X3` int(11) DEFAULT NULL,
  `Y3` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_rayon`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `table_petit_magasin`
--

INSERT INTO `table_petit_magasin` (`ID_rayon`, `Nom_rayon`, `estCarre`, `X0`, `Y0`, `X1`, `Y1`, `X2`, `Y2`, `X3`, `Y3`) VALUES
(1, 'Pâte et sauce', 0, 1, 2, 1, 4, NULL, NULL, NULL, NULL),
(2, 'Boucherie', 0, 2, 0, 6, 0, NULL, NULL, NULL, NULL),
(4, 'Conserve', 0, 1, 6, 1, 7, NULL, NULL, NULL, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
