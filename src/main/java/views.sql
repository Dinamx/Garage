-- But ; benefice = vente - depense

-- vues
create view employedetail as select employe.id as id_employe,
                                 employe.nom as nom,
                                    employe.prenom as prenom,
                                    employe.datenaissance as datenaissance,
                                    employe.numerotelephone as numerotelephone,
                                    n.description as niveauetude,
                                    g.genre as genre,
                                     coalesce(getsalaire(employe.id) ,0) as salairemontant,
                                    coalesce(getsalaire(employe.id)/(30*8),0) as salaireHoraire
                             from employe
                                      join niveauetude n on employe.idniveauetude = n.id
                                      left outer join salaire sal on employe.id = sal.idemploye
                                      join genre g on employe.idgenre = g.id;
/*select employe.id as id_employe,
                                 employe.nom as nom,
                                    employe.prenom as prenom,
                                    employe.datenaissance as datenaissance,
                                    employe.numerotelephone as numerotelephone,
                                    n.description as niveauetude,
                                    g.genre as genre,
                                    sal.montant as salairemontant ,
                                    sal.montant/(30*8) as salaireHoraire
                             from employe
                                      join niveauetude n on employe.idniveauetude = n.id
                                      left outer join salaire sal on employe.id = sal.idemploye
                                      join genre g on employe.idgenre = g.id;*/

select employe.id , coalesce(montant,0) from employe  left outer join salaire s on employe.id = coalesce(s.idemploye,employe.id);

create function selledProduct(idProduit int) returns double precision
    language plpgsql
as
$$
    DECLARE quantites double precision default 0;
        begin
        select sum(quantite) into quantites from ventepiece where idpiece=idProduit;
        if quantites is null
            then quantites=0;
            end if;
        return quantites;
    end;
    $$;

select selledProduct(1);

-- requette pour avoir la liste des achats du client
select p.id idpiece,p.piece descriptionpiece, sum(nombre) nombrePiece, modele from achatpiece
    join piece p on achatpiece.idpiece = p.id
         join modele m on m.id = p.idmodele
               group by idpiece, p.piece, modele, p.id;

--

-- test view
create view achatvente as select descriptionPiece,piecesAchetes,nombreVendue,achat.idPieces idPiece , modele from (select coalesce(sum(quantite),0) nombreVendue, p.id idPieces from piece p left join  ventepiece on p.id = ventepiece.idpiece
group by p.id) as vente join
(select coalesce(sum(a.nombre),0) piecesAchetes , p.id idPieces , p.piece descriptionPiece, idmodele from piece p left join achatpiece a on p.id = a.idpiece
group by p.id) as achat on vente.idPieces=achat.idPieces join modele on idmodele=modele.id;

-- creer une vue qui rassemble employe details- et service effectuer
create view devis as select idemploye, nom nom_employes, duree duree_service,
                            salaireHoraire, iddemande_devis, typeservice idService,
                            serviceeffectue.id idserviceEffectue  from serviceeffectue
            join serviceemploye s on serviceeffectue.id = s.idserviceeffectue
            join employedetail ed on s.idemploye=ed.id_employe
            join demandedevis d on d.id = serviceeffectue.iddemande_devis;
;

-- maka total ana benefuice services
 select somme+(somme*marge) total , somme*marge benefices , service from (select sum(duree_service*salaireHoraire)somme, margebeneficiaire/100 marge, typeservice.service from devis join typeservice on idService=typeservice.id group by typeservice.service, margebeneficiaire ) as t;
 select coalesce(somme+(somme*marge),0) total , coalesce(somme*marge ,0)benefices , service from (select sum(duree_service*salaireHoraire)somme, margebeneficiaire/100 marge, typeservice.service from devis left outer join typeservice on idService=typeservice.id group by typeservice.service, margebeneficiaire ) as t;

create view benefices as select somme+(somme*marge) valeurBrut , somme*marge benefices ,marge , service, idservices from(select coalesce(sum(duree_service*salaireHoraire),0) somme, coalesce(margebeneficiaire/100,0) marge, typeservice.service, typeservice.id idservices
from typeservice  left outer join devis on idService=typeservice.id group by typeservice.service, margebeneficiaire, idservices ) as t;

select * from benefices;

-- Vue salaire minimum par Specialite ()

-- vue salaire maximum par specialite ()
create function getsalaire (idEmployee int ) returns double precision

language plpgsql
as
    $$
    declare salaires double precision;
        begin
        select max(salaire) into salaires from specialiteemploye
            join specialite s on specialiteemploye.idspecialite = s.id
                            where specialiteemploye.idemploye=idEmployee;
        if(salaires is null) then salaires=0;
        end if;
        return salaires;
    end;
    $$;
-- vues specialites employes
create view specEmp as select idspecialite, nom ,idemploye, specialite, salaire from specialiteemploye join specialite s on s.id = specialiteemploye.idspecialite join employe e on specialiteemploye.idemploye = e.id
-- drop view specEmp;


-- view details pieces

create view detailPiece as select piece.id idpiece, piece, unite, modele, marque from piece join unite u on piece.idunite = u.id join modele m on piece.idmodele = m.id join marque m2 on m2.id = m.idmarque

-- vues specialites et besoins en employes
create view service as select typeservice.id id, service, prix, margebeneficiaire, idspecialites, specialite, nombre from typeservice join service_besionemp sb on typeservice.id = sb.idtypeservices join specialite s on sb.idspecialites = s.id

-- liste des employes ayant une specialites
-- create view select * from specialiteemploye join employe e on specialiteemploye.idemploye = e.id where idspecialite=1


-- view produit + marge + prixConseillé
CREATE OR REPLACE FUNCTION getMargeBeneficiaire(valeur double precision)
    RETURNS double precision
AS
$$
BEGIN
    return case when valeur > 0 and valeur <1000 THEN 50
                when valeur > 1001 and valeur< 2000 THEN 20
                when valeur > 1001 and valeur < 2000 THEN 10
                when valeur > 2001 and valeur < 30000 THEN 10
                else 0
        end;
end;
$$ LANGUAGE PLPGSQL;

select getMargeBeneficiaire(999);


select * from achatpiece ;
-- String nom;
-- double prixAchat;
-- double prixConseille;
-- double benefice;
-- double marge;


create or replace view produit as
select p.piece as nom , (montant/nombre) as prixachat ,((montant/nombre) + ((montant/nombre)* (getMargeBeneficiaire((montant/nombre))/100) )) as prixconseille, ((((montant/nombre) + ((montant/nombre)* (getMargeBeneficiaire((montant/nombre))/100) )))-((montant/nombre)))as benefice ,getMargeBeneficiaire((montant/nombre)) as marge   from achatpiece join piece p on p.id = achatpiece.idpiece;


select p.piece as nom  , (montant/nombre) as prixachat ,((montant/nombre) + ((montant/nombre)* (getMargeBeneficiaire((montant/nombre))/100) )) as prixconseille, ((((montant/nombre) + ((montant/nombre)* (getMargeBeneficiaire((montant/nombre))/100) )))-((montant/nombre)))as benefice ,getMargeBeneficiaire((montant/nombre)) as marge   from achatpiece join piece p on p.id = achatpiece.idpiece;
