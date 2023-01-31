package model.service;

import manipDb.ObjetBDD;

import java.sql.Date;
import java.time.LocalDate;

public class ServiceEffectue extends ObjetBDD {
    String libelle;
    int idvehicule;
    Date date_service;
    int duree;
    int idDemande_devis;

    public ServiceEffectue(String libelle, int idvehicule, int duree, int idDemandeVehicule) {
        this.libelle = libelle;
        this.idvehicule = idvehicule;
        this.duree = duree;
        this.idDemande_devis = idDemandeVehicule;
        setDate_service();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public Date getDate_service() {
        return date_service;
    }

    public void setDate_service(Date date_service) {
        this.date_service = date_service;
    }

    public void setDate_service()
    {
        LocalDate l=LocalDate.now();
        this.date_service = Date.valueOf(l);
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getIdDemande_devis() {
        return idDemande_devis;
    }

    public void setIdDemande_devis(int idDemandeVehicule) {
        this.idDemande_devis = idDemandeVehicule;
    }
}
