package model.depenses;

import manipDb.ObjetBDD;

import java.sql.Date;
import java.time.LocalDate;

public class Depense extends ObjetBDD {
    int id;
    int idType;
    double montant;
    Date dateDepense;

    public Depense( int idType, double montant) {

        this.idType = idType;
        this.montant = montant;
        setDateDepense();    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }
    public void setDateDepense() {

        this.dateDepense = Date.valueOf(LocalDate.now());
    }
}
