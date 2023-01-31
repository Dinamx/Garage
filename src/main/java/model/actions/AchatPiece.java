package model.actions;

import manipDb.ObjetBDD;

import java.sql.Date;
import java.time.LocalDate;

public class AchatPiece extends ObjetBDD {

    int idPiece;
    double nombre;
    Date date_achat;
    double montant;

    public AchatPiece(int idPiece, double nombre, double montant) {
        this.idPiece = idPiece;
        this.nombre = nombre;
        this.montant = montant;
        setDate_achat();
    }


    public AchatPiece() {
    }

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat() {
        this.date_achat = Date.valueOf(LocalDate.now());
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}