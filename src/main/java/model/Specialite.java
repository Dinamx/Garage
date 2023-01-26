package model;

import manipDb.ObjetBDD;

public class Specialite extends ObjetBDD {
    int id;
    String specialite ;

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String description) {
        this.specialite = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialite(String specialite, int id) {
        setSpecialite(specialite);
        setId(id);
    }

    public Specialite() {
    }
}
