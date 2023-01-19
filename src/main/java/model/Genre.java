package model;

import manipDb.ObjetBDD;

public class Genre extends ObjetBDD {
    int id;
    String descriptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Genre(String descriptions) {
        setDescriptions(descriptions);
    }

    public Genre() {
    }
}
