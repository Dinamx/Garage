package model;

import manipDb.ObjetBDD;

public class NiveauEtude extends ObjetBDD {
    int id;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NiveauEtude(String description) {
        setDescription(description);
    }

    public NiveauEtude() {
    }
}
