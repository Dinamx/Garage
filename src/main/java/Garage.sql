create table admin(
    id serial primary key,
    email varchar(30),
    password varchar(30)
);


insert into admin values(default , 'admin1@gmail.com','admin1');

create table genre (
    id serial primary key,
    genre varchar(30)
);

insert into genre values (default , 'homme');
insert into genre values (default , 'femme');

create table niveauEtude(
id serial primary key,
description varchar(50)  not null
);

insert into niveauEtude (description) values ('Bac ');
insert into niveauEtude (description) values ('Bac +2 ');
insert into niveauEtude (description) values ('Bac +3 ');
insert into niveauEtude (description) values ('Bac +5 ');
insert into niveauEtude (description) values ('Bac +7 ');



create table specialite(
    id serial primary key,
    specialite varchar(60),
    salaire decimal(10,2)
);


insert into specialite (specialite,salaire) values ('monteur',100000);
insert into specialite (specialite,salaire) values ('electricien',200000);
insert into specialite (specialite,salaire) values ('controleur',30000000);
insert into specialite (specialite,salaire) values ('mecanicien',10020000);
insert into specialite (specialite,salaire) values ('technicien',40000);
insert into specialite (specialite,salaire) values ('comptable',4000000);

CREATE TABLE employe (
    id serial primary key,
    nom varchar(50) ,
    prenom varchar(50) ,
    DateNaissance date  ,
    idgenre integer references genre(id) ,
    idNiveauEtude integer references niveauEtude(id),
    numerotelephone varchar(15)
);

insert into employe values(default , 'Jean', 'De Dieu','2000-12-01',1,2 );

create table specialiteemploye(
    idspecialite integer references specialite(id),
    idemploye integer references employe(id)
);

create table Salaireemploye(
    id serial primary key,
    montant double precision check(montant>0),
    date_prise date,
    idemploye integer references employe(id)
);

CREATE TABLE Client (
    id SERIAL primary key,
 nom varchar(50) NOT NULL,
 prenom varchar(50) NOT NULL,
--  Cartebancaire integer NOT NULL,
 numero varchar(20)
 );


-- Concernant les voitures
create table marque(
    id SERIAL primary key,
    marque varchar(50)
);

create table modele(
    id serial primary key,
    modele varchar(50),
    idmarque integer references marque(id)
);

-- Moto , SUV , Voiture Leger , 4*4 etc
create table typevehicule(
    id serial primary key,
    type varchar(30)
);

create table vehicule(
    id serial primary key,
    idmodele integer,
    immatriculation varchar(10),
    modele integer references modele(id),
    anneeSortie varchar(4),
    idtype integer references typevehicule(id),
     idclient integer references Client(id)
 
);


-- drop table typeservice cascade ;
create table typeservice(
    id serial primary key,
    service varchar(50),
    prix double precision check (prix>0)
);
alter table typeservice add margeBeneficiaire double precision;

create table specialiteEmploye_typeService(
    idSpecialiteEmploye integer references specialite(id),
    idTypeService integer references typeservice(id)
);



create table demandeDevis(
                             id serial primary key,
                             idclient integer references client(id),
                             typeservice integer references typeservice(id),
                             date_demande date,
                             montant double precision check (montant>0)

);

create table serviceeffectue(
    id serial primary key,
    libelle varchar(100),
    idvehicule integer,
    date_service timestamp,
    duree integer,
    iddemande_devis integer references demandeDevis(id)
);
create table serviceemploye(
    idserviceeffecute integer references serviceeffectue(id),
    idemploye integer references employe(id)
);


-- ho an'ny menaka sy ny tariny
-- unite , kg , cl 
create table unite(
    id serial primary key,
    unite varchar(50)
);
create table piece (
    id serial primary key,
    piece varchar(100),
    idunite integer references unite(id),
    idmodele integer references modele(id)
);

create table achatpiece(
    id serial primary key,
    idpiece integer references piece(id),
    nombre double precision check (nombre>0),
    date_achat date,
    montant double precision check (montant>0)
);


-- Asina client factice ho an'ny mpandalo mividy piece fotsiny

create table ventepiece(
    id serial primary key,
    idclient integer references client(id),
    idpiece integer references piece(id),
    montant double precision check (montant>0),
    quantite double precision check (quantite>0),
    date_vente date,
    isservice integer references serviceeffectue(id)
);

-- Loyer sa jirama sa inona etc
create table typedepense(
    id serial primary key,
    type varchar(50)
);
create table depense(
    id serial primary key,
    idtype integer references typedepense(id),
    montant double precision check (montant>0)
);

-- Salaire fa raha tsy angatahana hoe
create table Salaire(
    id serial primary key,
    idemploye integer references employe(id),
    montant double precision check (montant>0),
    date_payement date
);

-- misy ny stock -na pieces rehetra miaraka @ quantite actuelle
/*create table StockProduit(
    id serial primary key ,
    idPiece integer references piece,
    quantite double precision
)*/



-- But ; benefice = vente - depense

create table service_besionemp(idspecialites int references specialite(id),
        idtypeservices int references typeservice(id),
        nombre int );




