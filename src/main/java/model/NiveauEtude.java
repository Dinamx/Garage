package model;

import manipDb.ObjetBDD;

public class NiveauEtude extends ObjetBDD {
    String description;

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
