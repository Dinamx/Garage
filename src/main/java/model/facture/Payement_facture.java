package model.facture;

import manipDb.ObjetBDD;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

public class Payement_facture extends ObjetBDD {
    int id_facture;
    Date datepayement;
    double montant ;

    public Date getDatepayement() {
        return datepayement;
    }

    public void setDatepayement(Date datepayement) {
        this.datepayement = datepayement;
    }
    public void setDatepayement()
    {
        LocalDate local= LocalDate.now();

        Date dates = Date.valueOf(local);
        setDatepayement(dates);
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Payement_facture(int id_facture, double montant) {
        this.id_facture = id_facture;
        this.montant = montant;
        setDatepayement();
    }

    public Payement_facture() {
    }
}
