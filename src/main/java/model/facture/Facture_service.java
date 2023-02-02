package model.facture;

import manipDb.ObjetBDD;

public class Facture_service extends ObjetBDD {
    int id_facture;
    int id_service;
    int nombre;
    double promotion;

    public Facture_service(int id_facture, int id_service, int nombre) {
        this.id_facture = id_facture;
        this.id_service = id_service;
        setNombre(nombre);
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Facture_service() {
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

}
