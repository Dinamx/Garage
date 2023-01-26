package model;

import exeptions.MontantInvalide;
import manipDb.ObjetBDD;

import java.sql.Connection;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

public class DemandeDevis extends ObjetBDD {
    int idClient;
    int typeservice;
    Date date_demande;
    double montant;

    public DemandeDevis(int idClient, int typeservice, double montant) throws MontantInvalide {
        setIdClient(idClient);
        setTypeservice(typeservice);
        setDate_demande();
        setMontant(montant);
    }
  /*  public DemandeDevis(String idClient, String typeservice, String date_demande, String montant) {
        setIdClient(idClient);
        setTypeservice(typeservice);
        setDate_demande(date_demande);
        setMontant(montant);
    }*/

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = Integer.parseInt(idClient);
    }


    public int getTypeservice() {
        return typeservice;
    }

    public void setTypeservice(int typeservice) {
        this.typeservice = typeservice;
    }
    /*public void setTypeservice(int idService, Connection connection) throws Exception {
        TypeService service= (TypeService) new TypeService().find(connection," where id="+idService);
        setTypeservice(service.getService());
    }*/

    public Date getDate_demande() {
        return date_demande;
    }

    public void setDate_demande(Date date_demande) {
        this.date_demande = date_demande;
    }
    public void setDate_demande(String date_demande) {
        Date date=Date.valueOf(date_demande);
        setDate_demande(date);
    }
    public void setDate_demande()
    {
        LocalDate ldt=LocalDate.now();
        this.date_demande=Date.valueOf(ldt);
    }


    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) throws MontantInvalide {
        if(montant<0) throw new MontantInvalide();
        else this.montant = montant;
    }

}
