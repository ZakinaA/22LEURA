-- phpMyAdmin SQL Dump
-- version 5.0.4deb2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mer. 10 mai 2023 à 07:03
-- Version du serveur :  10.5.12-MariaDB-0+deb11u1
-- Version de PHP : 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `LEURA`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `Libelle` varchar(50) NOT NULL
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

CREATE TABLE `dispositif` (
  `idDispositif` int(11) NOT NULL,
  `annee` varchar(50) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `donnerconcert` (
  `idGroupe` int(11) NOT NULL,
  `idLieu` int(11) NOT NULL,
  `dateConcert` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `festival` (
  `idFestival` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `lieu` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `genremusical` (
  `idGenre` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `groupe` (
  `idGroupe` int(15) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `dateCreation` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `melSiteWeb` varchar(50) DEFAULT NULL,
  `lieuRepetition` varchar(50) DEFAULT NULL,
  `estSelectionne` varchar(50) DEFAULT NULL,
  `idGenre` int(11) DEFAULT NULL,
  `idDispositif` int(11) DEFAULT NULL,
  `idMembre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`idGroupe`, `nom`, `dateCreation`, `telephone`, `melSiteWeb`, `lieuRepetition`, `estSelectionne`, `idGenre`, `idDispositif`, `idMembre`) VALUES
(1, 'SLAMME', '2019-02-14', '0686987596', 'groupe.slam@gmail.com', 'Lycée Jean Rostand', 'Oui', 1, 1, 1),
(2, 'Leura', '2010-06-23', '0665138496', 'leura.contact@gmail.com', 'Egout', 'Oui', 4, 4, 1),
(3, 'PouletPIKANTE', '2016-11-12', '0258454684', 'poulet@gmail.com', 'KFC', 'Oui', 2, 1, 2),
(4, 'SISR', '2021-02-25', '0768234795', 'sisrjeanrostand@gmail.com', 'Lycée Jean Rostand', 'Oui', 5, 3, 6),
(51, 'BILLYPAPA', '2022-01-16', '0689785488', 'sifdgÃ¨uhj@gmail.com', 'Le 13 arrondissement', NULL, 1, NULL, NULL),
(52, 'test', '01/01/2000', '1111111111', 'test@test.com', 'test', NULL, 4, 3, 6),
(53, 'AAAAA', '2010/12/12', '0000111122', 'a@aaaaaa', 'aaaaa', NULL, 1, 1, 1),
(54, 'sinje', '01/01/2000', '0123456789', 'sinje@sinje.com', 'jungle', NULL, 4, 3, 5),
(55, 'abc123', '01/01/2000', '9876543210', 'abc123@oui.com', 'oui', NULL, 2, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `instrument`
--

CREATE TABLE `instrument` (
  `idInstrument` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `jouer` (
  `idGroupe` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `idInstrument` int(11) NOT NULL
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

CREATE TABLE `lieuconcert` (
  `idLieu` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `codePostal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `membre` (
  `idMembre` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `idInstrumentPref` int(11) DEFAULT NULL,
  `statut` int(11) DEFAULT NULL,
  `idUtilisateur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `participerfestival` (
  `festival` int(11) NOT NULL,
  `groupe` int(15) NOT NULL
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

CREATE TABLE `statut` (
  `idStatut` int(11) NOT NULL,
  `libellestatut` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `titre` (
  `idGroupe` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `intitule` varchar(50) DEFAULT NULL,
  `duree` time DEFAULT NULL,
  `lienURL` varchar(100) DEFAULT NULL
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

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `rue` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `cp` varchar(10) NOT NULL,
  `categorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `username`, `password`, `mail`, `tel`, `rue`, `ville`, `cp`, `categorie`) VALUES
(1, 'tlelievre', 'mptheo', 'theorrible@gmail.com', '0658419635', '41 rue des potiers', 'Caen', '14000', 1),
(2, 'nathandu14', 'mpnathanlefou', 'nathanpa@gmail.com', '0689895874', '32 rue des boulay', 'Caen', '14000', 1),
(3, 'hangthomas', 'mpthomas', 'totogro@gmail.com', '0658471425', '1 avenue jeanjean', 'Bretteville l\'orgueilleuse', '14740', 1),
(4, 'ardeldjae', 'mparde', 'samarchbi1@gmail.com', '0632211445', '6 rue du rat', 'Argences', '14370', 1),
(5, 'thomasguilbert', 'lefloorballccool', 'saladethomasoignon@gmail.com', '0688887744', '89 rue écuyère', 'Verson', '14790', 3),
(6, 'sethseth', 'mp77', '7seth7@gmail.com', '0645812324', '77 rue des set', 'Caen', '14000', 2),
(27, 'billy', 'billY!14210', 'valorant@gmail.com', '0000000000', 'aaaa', 'aaaa', '14000', 2),
(28, 'NathanTMoche', 'NathanaCaen!', 'nathantpd', '0665137677', '38 rue des ptit poney', 'Gaycity', '14000', 2),
(29, 'NathanTMocheV2', 'NathanaCaen!', 'nathantpd', '0665137677', '38 rue des ptit poney', 'Gaycity', '14000', 2),
(30, 'NathanTMocheV3', 'NathanaCaen!', 'nathantpd', '0665137677', '38 rue des ptit poney', 'Gaycity', '14000', 2),
(31, 'tlelievre222', '12355j1hehh!he!he!', 'valorant@gmail.com', '0000000000', 'aaaa', 'Gaycity', '14000', 2),
(32, 'afgeageggea', 'gzaggagzgzgzggzgz', 'gzgzgzgzgzgzgzgz', '0000000000', 'aaa', 'Gaycity', '14000', 2),
(33, 'afgeageggeaaaaaa', 'gzaggagzgzgzggzgz', 'gzgzgzgzgzgzgzgz', '0000000000', 'aaa', 'Gaycity', '14000', 2),
(34, 'billyamine', 'biezbozgenpgzp^gz', 'nathantpd', '0000000000', '38 rue des ptit poney', 'aaaa', '14000', 2),
(35, 'billyamine', 'biezbozgenpgzp^gz', 'nathantpd', '0000000000', '38 rue des ptit poney', 'aaaa', '14000', 2),
(36, 'billy', 'faffafafafafafafafa', 'fafafafafafa', '0000000000', 'aaaa', 'Gaycity', '14000', 2),
(37, 'Thomas_CF', 'Thomas_CF', 'valorant@gmail.com', '0000000000', '38 rue des ptit poney', 'Gaycity', '14000', 2),
(38, 'Thomas_CF2', 'Thomas_CF2', 'valorant@gmail.com', '0000000000', '38 rue des ptit poney', 'Gaycity', '14000', 2),
(39, 'test', '12345678', 'test@test.com', '0000000000', 'ruetest', 'test', '11111', 2),
(40, 'Thomas_FC', 'Thomas_FC', 'thomas', '0665137677', 'aaaaa', 'aaaaa', '14000', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `dispositif`
--
ALTER TABLE `dispositif`
  ADD PRIMARY KEY (`idDispositif`);

--
-- Index pour la table `donnerconcert`
--
ALTER TABLE `donnerconcert`
  ADD PRIMARY KEY (`idGroupe`,`idLieu`),
  ADD KEY `FK_donneConcert_lieu` (`idLieu`);

--
-- Index pour la table `festival`
--
ALTER TABLE `festival`
  ADD PRIMARY KEY (`idFestival`);

--
-- Index pour la table `genremusical`
--
ALTER TABLE `genremusical`
  ADD PRIMARY KEY (`idGenre`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`idGroupe`),
  ADD KEY `FK_groupe_genre` (`idGenre`),
  ADD KEY `FK_groupe_dispositif` (`idDispositif`),
  ADD KEY `FK_groupe_membre` (`idMembre`);

--
-- Index pour la table `instrument`
--
ALTER TABLE `instrument`
  ADD PRIMARY KEY (`idInstrument`);

--
-- Index pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD PRIMARY KEY (`idGroupe`,`idMembre`,`idInstrument`),
  ADD KEY `FK_jouer_membre` (`idMembre`),
  ADD KEY `FK_jouer_instrument` (`idInstrument`);

--
-- Index pour la table `lieuconcert`
--
ALTER TABLE `lieuconcert`
  ADD PRIMARY KEY (`idLieu`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`idMembre`),
  ADD KEY `FK_membre_statut` (`statut`),
  ADD KEY `FK_membre_instrumentPref` (`idInstrumentPref`),
  ADD KEY `FK_membre_utilisateur` (`idUtilisateur`);

--
-- Index pour la table `participerfestival`
--
ALTER TABLE `participerfestival`
  ADD PRIMARY KEY (`festival`,`groupe`),
  ADD KEY `FK_participerFestival_festival` (`festival`),
  ADD KEY `FK_participerFestival_groupe` (`groupe`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`idStatut`);

--
-- Index pour la table `titre`
--
ALTER TABLE `titre`
  ADD PRIMARY KEY (`idGroupe`,`numero`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD KEY `FK_utilisateur_categorie` (`categorie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `dispositif`
--
ALTER TABLE `dispositif`
  MODIFY `idDispositif` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `donnerconcert`
--
ALTER TABLE `donnerconcert`
  MODIFY `idGroupe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `festival`
--
ALTER TABLE `festival`
  MODIFY `idFestival` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `genremusical`
--
ALTER TABLE `genremusical`
  MODIFY `idGenre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `idGroupe` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT pour la table `instrument`
--
ALTER TABLE `instrument`
  MODIFY `idInstrument` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `lieuconcert`
--
ALTER TABLE `lieuconcert`
  MODIFY `idLieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `membre`
--
ALTER TABLE `membre`
  MODIFY `idMembre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `statut`
--
ALTER TABLE `statut`
  MODIFY `idStatut` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

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
