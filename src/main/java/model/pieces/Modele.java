package model.pieces;

import manipDb.ObjetBDD;

public class Modele extends ObjetBDD {
    int id;
    String modele;
    int idmarque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public Modele(int id, String modele, int idmarque) {
        this.id = id;
        this.modele = modele;
        this.idmarque = idmarque;
    }

    public Modele() {
    }
}
