-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : mer. 12 oct. 2022 à 06:55
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `normanzik`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` int(11) NOT NULL,
  `Libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `Libelle`) VALUES
(1, 'admin'),
(2, 'membre'),
(3, 'jury');

-- --------------------------------------------------------

--
-- Structure de la table `dispositif`
--

DROP TABLE IF EXISTS `dispositif`;
CREATE TABLE IF NOT EXISTS `dispositif` (
  `idDispositif` int(11) NOT NULL AUTO_INCREMENT,
  `annee` varchar(50) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idDispositif`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dispositif`
--

INSERT INTO `dispositif` (`idDispositif`, `annee`, `libelle`) VALUES
(1, '2023', 'NOR ZIK 23'),
(2, '2022', 'NOR ZIK 22'),
(3, '2021', 'NOR ZIK 21'),
(4, '2024', 'NOR ZIK 24'),
(5, '2020', 'NOR ZIK 20');

-- --------------------------------------------------------

--
-- Structure de la table `donnerconcert`
--

DROP TABLE IF EXISTS `donnerconcert`;
CREATE TABLE IF NOT EXISTS `donnerconcert` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `idLieu` int(11) NOT NULL,
  `dateConcert` date DEFAULT NULL,
  PRIMARY KEY (`idGroupe`,`idLieu`),
  KEY `FK_donneConcert_lieu` (`idLieu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `donnerconcert`
--

INSERT INTO `donnerconcert` (`idGroupe`, `idLieu`, `dateConcert`) VALUES
(2, 2, '2022-10-21'),
(4, 1, '2022-10-26');

-- --------------------------------------------------------

--
-- Structure de la table `festival`
--

DROP TABLE IF EXISTS `festival`;
CREATE TABLE IF NOT EXISTS `festival` (
  `idFestival` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `lieu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idFestival`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `festival`
--

INSERT INTO `festival` (`idFestival`, `nom`, `date`, `lieu`) VALUES
(1, 'Eurockeennes', '2022-02-01', 'Belfort'),
(2, 'Hellfest', '2021-06-05', 'Clisson'),
(3, 'Les Nuits Secrètes', '2022-04-15', 'Aulnoye-Aymeries'),
(4, 'Main Square', '2022-06-04', 'Arras'),
(5, 'Solidays', '2022-03-01', 'Paris'),
(6, 'Le Cabaret Vert', '2022-01-02', 'Charleville-Mézières'),
(7, 'Electrobeach', '2019-07-14', 'Le Barcarès'),
(8, 'Musilac', '2019-11-14', 'Aix-les-bains');

-- --------------------------------------------------------

--
-- Structure de la table `genremusical`
--

DROP TABLE IF EXISTS `genremusical`;
CREATE TABLE IF NOT EXISTS `genremusical` (
  `idGenre` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idGenre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `genremusical`
--

INSERT INTO `genremusical` (`idGenre`, `libelle`) VALUES
(1, 'Metal'),
(2, 'Rap'),
(3, 'Folk'),
(4, 'Electro'),
(5, 'Pop');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `idGroupe` int(15) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `dateCreation` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `melSiteWeb` varchar(50) DEFAULT NULL,
  `lieuRepetition` varchar(50) DEFAULT NULL,
  `estSelectionne` varchar(50) DEFAULT NULL,
  `idGenre` int(11) DEFAULT NULL,
  `idDispositif` int(11) DEFAULT NULL,
  `idMembre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGroupe`),
  KEY `FK_groupe_genre` (`idGenre`),
  KEY `FK_groupe_dispositif` (`idDispositif`),
  KEY `FK_groupe_membre` (`idMembre`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`idGroupe`, `nom`, `dateCreation`, `telephone`, `melSiteWeb`, `lieuRepetition`, `estSelectionne`, `idGenre`, `idDispositif`, `idMembre`) VALUES
(1, 'SLAM', '2019-02-14', '0686987596', 'groupe.slam@gmail.com', 'Lycée Jean Rostand', 'Oui', 1, 1, 3),
(2, 'Leura', '2010-06-23', '0665138496', 'leura.contact@gmail.com', 'Egout', 'Oui', 4, 4, 1),
(3, 'Vitality', '2016-11-12', '0231854269', 'teamvitality@gmail.com', 'Stade de France', 'Oui', 2, 3, 6),
(4, 'SISR', '2021-02-25', '0768234795', 'sisrjeanrostand@gmail.com', 'Lycée Jean Rostand', 'Oui', 5, 3, 6);

-- --------------------------------------------------------

--
-- Structure de la table `instrument`
--

DROP TABLE IF EXISTS `instrument`;
CREATE TABLE IF NOT EXISTS `instrument` (
  `idInstrument` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idInstrument`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `instrument`
--

INSERT INTO `instrument` (`idInstrument`, `libelle`) VALUES
(0, 'Guitare'),
(1, 'Basse'),
(2, 'Batterie'),
(3, 'Piano'),
(4, 'Cornemuse'),
(5, 'Chant'),
(6, 'Violon');

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

DROP TABLE IF EXISTS `jouer`;
CREATE TABLE IF NOT EXISTS `jouer` (
  `idGroupe` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `idInstrument` int(11) NOT NULL,
  PRIMARY KEY (`idGroupe`,`idMembre`,`idInstrument`),
  KEY `FK_jouer_membre` (`idMembre`),
  KEY `FK_jouer_instrument` (`idInstrument`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jouer`
--

INSERT INTO `jouer` (`idGroupe`, `idMembre`, `idInstrument`) VALUES
(1, 3, 1),
(1, 4, 5),
(1, 5, 0),
(2, 1, 3),
(3, 2, 5),
(3, 6, 3);

-- --------------------------------------------------------

--
-- Structure de la table `lieuconcert`
--

DROP TABLE IF EXISTS `lieuconcert`;
CREATE TABLE IF NOT EXISTS `lieuconcert` (
  `idLieu` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `codePostal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLieu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lieuconcert`
--

INSERT INTO `lieuconcert` (`idLieu`, `nom`, `ville`, `codePostal`) VALUES
(1, 'Zénith de Caen', 'Caen', 14000),
(2, 'Stade de France', 'Saint-Denis', 93200);

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `idMembre` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `idInstrumentPref` int(11) DEFAULT NULL,
  `statut` int(11) DEFAULT NULL,
  `idUtilisateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMembre`),
  KEY `FK_membre_statut` (`statut`),
  KEY `FK_membre_instrumentPref` (`idInstrumentPref`),
  KEY `FK_membre_utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`idMembre`, `nom`, `prenom`, `idInstrumentPref`, `statut`, `idUtilisateur`) VALUES
(1, 'Lelièvre', 'Théo', 3, 1, 1),
(2, 'Cahaigne', 'Nathan', 0, 2, 2),
(3, 'Hang', 'Thomas', 1, 1, 3),
(4, 'Djae', 'Arde', 5, 1, 4),
(5, 'Guilbert', 'Thomas', 6, 1, 5),
(6, 'Mukengeshayi', 'Seth', 2, 2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `participerfestival`
--

DROP TABLE IF EXISTS `participerfestival`;
CREATE TABLE IF NOT EXISTS `participerfestival` (
  `festival` int(11) NOT NULL,
  `groupe` int(15) NOT NULL,
  PRIMARY KEY (`festival`,`groupe`),
  KEY `FK_participerFestival_festival` (`festival`),
  KEY `FK_participerFestival_groupe` (`groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participerfestival`
--

INSERT INTO `participerfestival` (`festival`, `groupe`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

DROP TABLE IF EXISTS `statut`;
CREATE TABLE IF NOT EXISTS `statut` (
  `idStatut` int(11) NOT NULL AUTO_INCREMENT,
  `libellestatut` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idStatut`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`idStatut`, `libellestatut`) VALUES
(1, 'Salarie'),
(2, 'Intermittent'),
(3, 'Autre');

-- --------------------------------------------------------

--
-- Structure de la table `titre`
--

DROP TABLE IF EXISTS `titre`;
CREATE TABLE IF NOT EXISTS `titre` (
  `idGroupe` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `intitule` varchar(50) DEFAULT NULL,
  `duree` time DEFAULT NULL,
  `lienURL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idGroupe`,`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `titre`
--

INSERT INTO `titre` (`idGroupe`, `numero`, `intitule`, `duree`, `lienURL`) VALUES
(1, 1, 'Le java c est cool', '00:03:25', NULL),
(1, 5, 'Chez les SISR c est la jungle', '00:02:19', NULL),
(2, 4, 'Les origines des rats', '00:04:02', NULL),
(2, 15, 'Dans la Caveeee', '00:03:14', NULL),
(3, 10, 'Valorant ', '00:02:25', NULL),
(4, 17, 'Manger les câbles', '00:01:54', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `categorie` int(11) NOT NULL,
  PRIMARY KEY (`idUtilisateur`),
  KEY `FK_utilisateur_categorie` (`categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `username`, `password`, `categorie`) VALUES
(1, 'tlelievre', 'mptheolebogoss', 1),
(2, 'nathandu14', 'mpnathanlefou', 1),
(3, 'hangthomas', 'mpthomas', 1),
(4, 'ardeldjae', 'mparde', 1),
(5, 'thomasguilbert', 'lefloorballccool', 3),
(6, 'sethseth', 'mp77', 2);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `donnerconcert`
--
ALTER TABLE `donnerconcert`
  ADD CONSTRAINT `FK_donneConcert_groupe` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`idGroupe`),
  ADD CONSTRAINT `FK_donneConcert_lieu` FOREIGN KEY (`idLieu`) REFERENCES `lieuconcert` (`idLieu`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `FK_groupe_dispositif` FOREIGN KEY (`idDispositif`) REFERENCES `dispositif` (`idDispositif`),
  ADD CONSTRAINT `FK_groupe_genre` FOREIGN KEY (`idGenre`) REFERENCES `genremusical` (`idGenre`),
  ADD CONSTRAINT `FK_groupe_membre` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`idMembre`);

--
-- Contraintes pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD CONSTRAINT `FK_jouer_groupe` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`idGroupe`),
  ADD CONSTRAINT `FK_jouer_instrument` FOREIGN KEY (`idInstrument`) REFERENCES `instrument` (`idInstrument`),
  ADD CONSTRAINT `FK_jouer_membre` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`idMembre`);

--
-- Contraintes pour la table `membre`
--
ALTER TABLE `membre`
  ADD CONSTRAINT `FK_membre_instrumentPref` FOREIGN KEY (`idInstrumentPref`) REFERENCES `instrument` (`idInstrument`),
  ADD CONSTRAINT `FK_membre_statut` FOREIGN KEY (`statut`) REFERENCES `statut` (`idStatut`),
  ADD CONSTRAINT `FK_membre_utilisateur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_utilisateur_categorie` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`idCategorie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
