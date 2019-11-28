DROP DATABASE IF EXISTS hotel;
CREATE SCHEMA `hotel` ;

USE hotel;

CREATE TABLE Chambres (
	idChambre INT AUTO_INCREMENT,
    nom VARCHAR(45) NOT NULL,
    nombreLit int NOT NULL,
    prix float NOT NULL,
    CONSTRAINT pk_chambres PRIMARY KEY(idChambre)
);

CREATE TABLE Clients (
	idClient INT AUTO_INCREMENT,
    nom VARCHAR(45) NOT NULL,
    prenom VARCHAR(45) NOT NULL,
    adresse VARCHAR(100) NOT NULL,
    telephone VARCHAR(10) NOT NULL,
    CONSTRAINT pk_clients PRIMARY KEY(idClient)
);

CREATE TABLE Reservations (
	idReservation INT AUTO_INCREMENT,
    client INT NOT NULL,
    le DATE NOT NULL,
    payeeLe DATE NULL,
    CONSTRAINT pk_reservations PRIMARY KEY(idReservation)
);

CREATE TABLE LignesReservation (
	reservation INT,
    ligneReservation INT,
    chambre INT NOT NULL,
    arrivee DATE NOT NULL,
    depart DATE NOT NULL,
    CONSTRAINT pk_lignesReservations PRIMARY KEY(reservation, ligneReservation)
);

ALTER TABLE Reservations
ADD CONSTRAINT fk_reservations_clients FOREIGN KEY(client) REFERENCES Clients(idClient);

ALTER TABLE LignesReservation
ADD CONSTRAINT fk_lignesReservations FOREIGN KEY(reservation) REFERENCES Reservations(idReservation);
ALTER TABLE LignesReservation
ADD CONSTRAINT fk_lignesReservations_chambres FOREIGN KEY(chambre) REFERENCES Chambres(idChambre);

INSERT INTO Chambres(nom, nombreLit, prix) VALUES("San Francisco", 1, 95.0);
INSERT INTO Chambres(nom, nombreLit, prix) VALUES("San Diego", 2, 80.0);
INSERT INTO Chambres(nom, nombreLit, prix) VALUES("Los Angeles", 4, 120.40);
INSERT INTO Chambres(nom, nombreLit, prix) VALUES("Santa Barbara", 1, 150.0);
INSERT INTO Chambres(nom, nombreLit, prix) VALUES("Napa", 2, 80.0);
INSERT INTO Chambres(nom, nombreLit, prix) VALUES("Riverside", 2, 80.0);

INSERT INTO Clients(nom, prenom, adresse, telephone) VALUES("Pierre","Martin","1 rue du parc 91300 massy", "0750422369");
INSERT INTO Clients(nom, prenom, adresse, telephone) VALUES("Marie","Durand","54 rue du lac 75001 paris", "0650238958");
INSERT INTO Clients(nom, prenom, adresse, telephone) VALUES("Elizabeth","Duchemin","26 rue des saules 75011 paris", "0641235696");

INSERT INTO `hotel`.`Reservations` (`client`, `le`, `payeeLe`) VALUES ('1', '2019-12-12', '2019-12-12');
INSERT INTO `hotel`.`Reservations` (`client`, `le`, `payeeLe`) VALUES ('2', '2019-12-20', '2019-12-12');
INSERT INTO `hotel`.`Reservations` (`client`, `le`, `payeeLe`) VALUES ('3', '2020-01-01', '2020-01-6');

INSERT INTO `hotel`.`LignesReservation` (`reservation`, `ligneReservation`, `chambre`, `arrivee`, `depart`) VALUES ('1', '1', '2', '2019-12-12', '2019-12-20');
INSERT INTO `hotel`.`LignesReservation` (`reservation`, `ligneReservation`, `chambre`, `arrivee`, `depart`) VALUES ('3', '2', '5', '2020-01-01', '2020-01-6');

SELECT * FROM Chambres JOIN LignesReservation ON chambre=idChambre;

SELECT * FROM Chambres;

SELECT * FROM LignesReservation;

/* je veux une chambre du 12/12/2019 au 24/12/2019 */
SELECT * 
FROM chambres 
WHERE idChambre NOT IN 
(
    SELECT chambre 
    FROM   LignesReservation 
    WHERE  (arrivee <= '2019-12-12' AND depart >= '2019-12-12') 
           OR (arrivee < '2019-12-20' AND depart >= '2019-12-20' ) 
           OR ('2019-12-12' <= arrivee AND '2019-12-20' >= arrivee) 
);
/* je veux une chambre spécifique:
AND idChambre = 2;
 */
 
 
INSERT INTO Client (nom, prenom, adresse, telephone) 
SELECT  *
WHERE   NOT EXISTS 
        (   SELECT  1
            FROM    client 
            WHERE   Softwarename = @SoftwareName 
            AND     SoftwareSystemType = @Softwaretype
        );
