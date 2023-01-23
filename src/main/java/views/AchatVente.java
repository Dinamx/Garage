package views;

import manipDb.ObjetBDD;

public class AchatVente extends ObjetBDD {
    int idPiece;
    String descriptionpiece;
    double piecesAchetes;
    String modele;
    double nombreVendue;


    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

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


    public AchatVente(String descriptionpiece, double piecesAchetes, String modele, double nombreVendue, int idPiece) {
        this.descriptionpiece = descriptionpiece;
        this.piecesAchetes = piecesAchetes;
        this.modele = modele;
        this.nombreVendue = nombreVendue;
        setIdPiece(idPiece);
    }

    public AchatVente() {
    }
}
