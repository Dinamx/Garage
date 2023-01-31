package model.pieces;

import manipDb.ObjetBDD;

public class Vehicule extends ObjetBDD
{
    int idmodele;
    String immatriculation;
    int idmarque;
    String anneesortie;
    int idtype;
    int idClient;

    public Vehicule(int idmodele, String immatriculation, int idmarque, String anneesortie, int idtype, int idClient) {
        this.idmodele = idmodele;
        this.immatriculation = immatriculation;
        this.idmarque = idmarque;
        this.anneesortie = anneesortie;
        this.idtype = idtype;
        this.idClient = idClient;
    }

    public Vehicule() {
    }

    public int getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public String getAnneesortie() {
        return anneesortie;
    }

    public void setAnneesortie(String anneesortie) {
        this.anneesortie = anneesortie;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
