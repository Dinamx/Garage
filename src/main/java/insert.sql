-- specialites


-- services
INSERT INTO typeservice (service, prix,margebeneficiaire)
VALUES ('Changement d''huile', 30,10),
       ('Rotation et équilibrage des pneus', 30,15),
       ('Réparation et remplacement des freins', 120,10),
       ('Remplacement de la batterie', 30,20),
       ('réparation du moteur', 120,5),
       ('Diagnostic  du moteur', 120,10),
       ('remplacement de la transmission', 240,10),
       ('Réparation de la transmission', 240,20),
       ('Réparations de la suspension et de la direction', 120,25),
       ('Réparations de la direction', 120,10),
       ('remplacement du système d''échappement', 120,10),
       ('Réparation du système d''échappement', 120,5),
       ('Réparations de la climatisation ', 120,5),
       ('Réparations  du chauffage', 120,7),
       ('Entretien régulier ', 30,7),
       ('inspections planifiées', 30,10);

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
INSERT INTO modele (modele, idmarque)VALUES ('', 1);
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
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Doe', 'John', '1990-01-01', 1, 1,'+261341872561');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Smith', 'Jane', '1995-03-15', 2, 2,'+261342923131');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Johnson', 'Bob', '1985-05-20', 1, 3,'+261320229106');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Williams', 'Emily', '1980-07-10', 2, 1,'+261347067949');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Martin', 'Luc', '1995-10-12', 1, 2,'+261331895561');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Lévesque', 'Marie', '1985-05-20', 2, 3,'+261322259024');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Gagnon', 'Julie', '1980-07-10', 2, 1,'+261345567864');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Bélanger', 'Guillaume', '1990-01-01', 1, 2,'+261329932176');
INSERT INTO employe (nom, prenom, datenaissance, idgenre, idniveauetude,numerotelephone) VALUES ('Gauthier', 'Sophie', '1995-03-15', 2, 3,'+261334567653');

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
