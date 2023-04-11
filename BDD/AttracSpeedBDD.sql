CREATE DATABASE `attracspeed` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

CREATE TABLE `admins` (
  `name` varchar(20) NOT NULL,
  `mdp` varchar(500) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `attraction` (
  `nom_attraction` varchar(50) NOT NULL,
  `Nb_place_par_tour` int(11) DEFAULT NULL,
  `Emplacement` varchar(45) DEFAULT NULL,
  `TailleFileAttenteNormal` int(11) DEFAULT NULL,
  `TailleFileAttenteFast` int(11) DEFAULT NULL,
  `TailleFileAttenteTotal` int(11) DEFAULT NULL,
  `Disponible` tinyint(4) DEFAULT NULL,
  `Horaire_Deb` datetime DEFAULT NULL,
  `Horaire_Fin` datetime DEFAULT NULL,
  `TempsAttenteActuel` int(11) DEFAULT NULL,
  `duree_Tour` int(11) DEFAULT NULL,
  PRIMARY KEY (`nom_attraction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `horaires` (
  `Heures` datetime NOT NULL,
  PRIMARY KEY (`Heures`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `popularite` (
  `Nom_attraction` varchar(50) NOT NULL,
  `Horaire` datetime NOT NULL,
  `NbPersonneMoy` int(11) DEFAULT NULL,
  `TempsAttenteMoy` datetime DEFAULT NULL,
  `popularite` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Nom_attraction`,`Horaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
