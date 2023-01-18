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


