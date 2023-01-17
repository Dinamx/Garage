package model;

import manipDb.ObjetBDD;

public class Specialite extends ObjetBDD {
    String description ;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialite(String description) {
        setDescription(description);
    }

    public Specialite() {
    }
}
