package views;

import manipDb.ObjetBDD;

public class DetailFacturePromus extends ObjetBDD {
    String service;
    double prixUnitaire;
    int nombre;
    double promotion;
    int id_facture;
    double prixTotal;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public DetailFacturePromus(String service, double prixUnitaire, int nombre, double promotion, int id_facture, double prixTotal) {
        this.service = service;
        this.prixUnitaire = prixUnitaire;
        this.nombre = nombre;
        this.promotion = promotion;
        this.id_facture = id_facture;
        this.prixTotal = prixTotal;
    }

    public DetailFacturePromus() {
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }


}
