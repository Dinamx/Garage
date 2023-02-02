package model.facture;

import manipDb.ObjetBDD;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Facture extends ObjetBDD {
    int idClient;
    Date date_facture;
    String libelle;

    public Facture(int idClient, String libelle) {
        setIdClient(idClient);
        setDate_facture();
        setLibelle(libelle);
    }

    public Facture() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public void setDate_facture() {
        LocalDate local= LocalDate.now();

        this.date_facture = Date.valueOf(local);
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
