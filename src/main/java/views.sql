-- But ; benefice = vente - depense

-- vues
create view employedetail as select employe.id as id_employe,
                                 employe.nom as nom,
                                    employe.prenom as prenom,
                                    employe.datenaissance as datenaissance,
                                    employe.numerotelephone as numerotelephone,
                                    n.description as niveauetude,
                                    g.genre as genre,
                                     coalesce(sal.montant ,0) as salairemontant,
                                    sal.montant/(30*8) as salaireHoraire
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

/*select piece,montant,sum(nombre-selledProduct(piece.id))from
     piece piece join achatpiece on piece.id = achatpiece.idpiece
group by piece , montant
*/

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
            join serviceemploye s on serviceeffectue.id = s.idserviceeffecute
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

-- s
