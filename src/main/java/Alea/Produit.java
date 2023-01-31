package Alea;

import manipDb.ObjetBDD;

public class Produit extends ObjetBDD {
    String nom;
    double prixAchat;
    double prixConseille;
    double benefice;
    double marge;


    public Produit(String nom, double prixAchat, double prixConseille) {
        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixConseille = prixConseille;
        this.benefice = prixConseille -  prixAchat;
    }

    public Produit() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixConseille() {
        return prixConseille;
    }

    public void setPrixConseille(double prixConseille) {
        this.prixConseille = prixConseille;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public double getMarge() {

        return marge;

    }

    public void setMarge(double marge) {
        this.marge = marge;
    }
}
