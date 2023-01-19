-- specialites


-- services
INSERT INTO typeservice (service, prix, duree_supposee)
VALUES ('Changement d''huile', 30, 30),
       ('Rotation et équilibrage des pneus', 30, 30),
       ('Réparation et remplacement des freins', 120, 120),
       ('Remplacement de la batterie', 30, 30),
       ('réparation du moteur', 120, 120),
       ('Diagnostic  du moteur', 120, 120),
       ('remplacement de la transmission', 240, 240),
       ('Réparation de la transmission', 240, 240),
       ('Réparations de la suspension et de la direction', 120, 120),
       ('Réparations de la direction', 120, 120),
       ('remplacement du système d''échappement', 120, 120),
       ('Réparation du système d''échappement', 120, 120),
       ('Réparations de la climatisation ', 120, 120),
       ('Réparations  du chauffage', 120, 120),
       ('Entretien régulier ', 30, 30),
       ('inspections planifiées', 30, 30);

-- marque

INSERT INTO marque (marque) VALUES ('');
INSERT INTO marque (marque) VALUES ('Toyota');
INSERT INTO marque (marque) VALUES ('BMW');
INSERT INTO marque (marque) VALUES ('Honda');
INSERT INTO marque (marque) VALUES ('Mercedes');
INSERT INTO marque (marque) VALUES ('Ford');
INSERT INTO marque (marque) VALUES ('Renault');
INSERT INTO marque (marque) VALUES ('Peugeot');
INSERT INTO marque (marque) VALUES ('Citroen');

--modele
INSERT INTO modele (modele, idmarque)VALUES ('Camry', 1);
INSERT INTO modele (modele, idmarque)VALUES ('3 Series', 2);
INSERT INTO modele (modele, idmarque)VALUES ('Civic', 3);
INSERT INTO modele (modele, idmarque)VALUES ('S-Class', 4);
INSERT INTO modele (modele, idmarque)VALUES ('Mustang', 5);
INSERT INTO modele (modele, idmarque)VALUES ('Clio', 6);
INSERT INTO modele (modele, idmarque)VALUES ('308', 7);
INSERT INTO modele (modele, idmarque)VALUES ('C3', 8);

-- unite
INSERT INTO unite (unite) VALUES ('unite');
INSERT INTO unite (unite) VALUES ('kg');
INSERT INTO unite (unite) VALUES ('L');
INSERT INTO unite (unite) VALUES ('m');
INSERT INTO unite (unite) VALUES ('cm');
INSERT INTO unite (unite) VALUES ('g');
INSERT INTO unite (unite) VALUES ('ml');
INSERT INTO unite (unite) VALUES ('mm');
-- piece
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Moteur', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Boîte de vitesse', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Plaquettes de frein', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Pneus', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Alternateur', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Radiateur', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Batterie', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Suspension', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Echappement', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Système de direction', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Filtre à air', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Filtre à essence', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Courroie de distribution', 8, 1);
INSERT INTO piece (piece, idunite, idmodele) VALUES ('Thermostat', 8, 1);

-- employes
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Doe', 'John', '1990-01-01', 1, 1);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Smith', 'Jane', '1995-03-15', 2, 2);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Johnson', 'Bob', '1985-05-20', 1, 3);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Williams', 'Emily', '1980-07-10', 2, 1);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Martin', 'Luc', '1995-10-12', 1, 2);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Lévesque', 'Marie', '1985-05-20', 2, 3);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Gagnon', 'Julie', '1980-07-10', 2, 1);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Bélanger', 'Guillaume', '1990-01-01', 1, 2);
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude) VALUES ('Gauthier', 'Sophie', '1995-03-15', 2, 3);

-- type vehicule
INSERT INTO typevehicule (type) VALUES ('Voiture');
INSERT INTO typevehicule (type) VALUES ('Camion');
INSERT INTO typevehicule (type) VALUES ('Moto');
INSERT INTO typevehicule (type) VALUES ('Vélo');
INSERT INTO typevehicule (type) VALUES ('Scooter');
INSERT INTO typevehicule (type) VALUES ('Bus');
INSERT INTO typevehicule (type) VALUES ('Remorque');
INSERT INTO typevehicule (type) VALUES ('Camionnette');
INSERT INTO typevehicule (type) VALUES ('Tracteur');
INSERT INTO typevehicule (type) VALUES ('Quad');

-- client
INSERT INTO client (nom, prenom, numero) VALUES ('Rakotoarivony', 'Andria', '032 02 12345');
INSERT INTO client (nom, prenom, numero) VALUES ('Rasolondraibe', 'Ravaka', '034 06 98765');
INSERT INTO client (nom, prenom, numero) VALUES ('Ranarivelo', 'Feno', '033 08 09876');
INSERT INTO client (nom, prenom, numero) VALUES ('Rasoanaivo', 'Fanja', '032 03 54321');
