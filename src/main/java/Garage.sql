create table admin(
    id serial primary key,
    email varchar(30),
    password varchar(30)
);


insert into admin values(default , 'admin1','admin1');

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



drop table specialite;
create table specialite(
    id serial primary key,
    specialite varchar(60)
);


insert into specialite (specialite) values ('monteur');
insert into specialite (specialite) values ('electricien');
insert into specialite (specialite) values ('controleur');
insert into specialite (specialite) values ('mecanicien');
insert into specialite (specialite) values ('technicien');
insert into specialite (specialite) values ('comptable');






CREATE TABLE employe (
    id serial primary key,
    nom varchar(50) ,
    prenom varchar(50) ,
    DateNaissance date  ,
    idgenre integer references genre(id) ,
    idNiveauEtude integer references niveauEtude(id)
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
 numero integer
 );


-- Concernant les voitures
create table marque(
    id SERIAL primary key,
    marque varchar(50)
);

create table modele(
    id serial primary key,
    marque varchar(50),
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


drop table typeservice cascade ;
create table typeservice(
    id serial primary key,
    service varchar(50),
    prix double precision check (prix>0),
    duree_supposee int
);

select * from typeservice;



create table specialiteEmploye_typeService(
    idSpecialiteEmploye integer references specialite(id),
    idTypeService integer references typeservice(id)
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
create table demandeDevis(
    id serial primary key,
    idclient integer references client(id),
    typeservice integer references typeservice(id),
    date_demande date,
    montant double precision check (montant>0)

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
    id integer primary key,
    idemploye integer references employe(id),
    montant double precision check (montant>0),
    date_payement date
);



-- But ; benefice = vente - depense

-- vues
create view employedetail as select employe.nom as nom,
                                    employe.prenom as prenom,
                                    employe.datenaissance as datenaissance,
                                    n.description as niveauetude,
                                    g.genre as genre,
                                    sal.montant as salairemontant,
                                    sal.montant/(30/8) as salaireHoraire
                             from employe
                                      join niveauetude n on employe.idniveauetude = n.id
                                      join salaire sal on employe.id = sal.idemploye
                                      join genre g on employe.idgenre = g.id




