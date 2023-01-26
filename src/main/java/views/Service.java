package views;

import manipDb.ObjetBDD;

public class Service  extends ObjetBDD {
    String service;
    double prix;
    double margebeneficiaire;
    int idSpecialites;
    String specialite;
    int nombre;

    public Service(String service, double prix, double margebeneficiaire, int idSpecialites, String specialite, int nombre) {
        this.service = service;
        this.prix = prix;
        this.margebeneficiaire = margebeneficiaire;
        this.idSpecialites = idSpecialites;
        this.specialite = specialite;
        this.nombre = nombre;
    }

    public Service() {
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
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

    public double getMargebeneficiaire() {
        return margebeneficiaire;
    }

    public void setMargebeneficiaire(double margebeneficiaire) {
        this.margebeneficiaire = margebeneficiaire;
    }

    public int getIdSpecialites() {
        return idSpecialites;
    }

    public void setIdSpecialites(int idSpecialites) {
        this.idSpecialites = idSpecialites;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
