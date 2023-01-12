package model;

import manipDb.ObjetBDD;

public class Genre extends ObjetBDD {
    String descriptions;

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Genre(String descriptions) {
        this.descriptions = descriptions;
    }
}
