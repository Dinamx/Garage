package views;

import manipDb.ObjetBDD;

public class AchatVente extends ObjetBDD {
    String descriptionpiece;
    double piecesAchetes;
    String modele;
    double nombreVendue;
    double montant;

    public String getDescriptionpiece() {
        return descriptionpiece;
    }

    public void setDescriptionpiece(String descriptionpiece) {
        this.descriptionpiece = descriptionpiece;
    }

    public double getPiecesAchetes() {
        return piecesAchetes;
    }

    public void setPiecesAchetes(double piecesAchetes) {
        this.piecesAchetes = piecesAchetes;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getNombreVendue() {
        return nombreVendue;
    }

    public void setNombreVendue(double nombreVendue) {
        this.nombreVendue = nombreVendue;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public AchatVente(String descriptionpiece, double piecesAchetes, String modele, double nombreVendue, double montant) {
        this.descriptionpiece = descriptionpiece;
        this.piecesAchetes = piecesAchetes;
        this.modele = modele;
        this.nombreVendue = nombreVendue;
        this.montant = montant;
    }

    public AchatVente() {
    }
}
