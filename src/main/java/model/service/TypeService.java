package model.service;

import manipDb.ObjetBDD;

public class TypeService extends ObjetBDD {
    int id;
    String service;
    double prix;
    int margeBeneficiaire;


    public TypeService(int id, String service, double prix,int margeBeneficiaire) {
        this.id = id;
        this.service = service;
        this.prix = prix;
        setMargeBeneficiaire(margeBeneficiaire);

    }

    public TypeService() {
    }

    public int getMargeBeneficiaire() {
        return margeBeneficiaire;
    }

    public void setMargeBeneficiaire(int margeBeneficiaire) {
        this.margeBeneficiaire = margeBeneficiaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
