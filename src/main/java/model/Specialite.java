package model;

import manipDb.ObjetBDD;

public class Specialite extends ObjetBDD {
    String specialite ;

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String description) {
        this.specialite = description;
    }

    public Specialite(String specialite) {
        setSpecialite(specialite);
    }

    public Specialite() {
    }
}
