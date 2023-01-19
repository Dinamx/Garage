-- But ; benefice = vente - depense

-- vues
create view employedetail as select employe.id as id_employe,
                                 employe.nom as nom,
                                    employe.prenom as prenom,
                                    employe.datenaissance as datenaissance,
                                    n.description as niveauetude,
                                    g.genre as genre,
                                    sal.montant as salairemontant,
                                    sal.montant/(30*8) as salaireHoraire
                             from employe
                                      join niveauetude n on employe.idniveauetude = n.id
                                      join salaire sal on employe.id = sal.idemploye
                                      join genre g on employe.idgenre = g.id

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
create view achatVente as select descriptionpiece, piecesachetes , modele, quantite nombrevendue , achat.montant from ventepiece join (select p.id idpiece,p.piece descriptionpiece, sum(nombre) piecesachetes, modele, montant from achatpiece
      join piece p on achatpiece.idpiece = p.id
      join modele m on m.id = p.idmodele
       group by idpiece, p.piece, modele,montant, p.id) achat on achat.idpiece=ventepiece.idpiece
