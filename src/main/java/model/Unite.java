package model;

import manipDb.ObjetBDD;

public class Unite extends ObjetBDD {
    int id;
    String unite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unite(String unite) {
        this.unite = unite;
    }

    public Unite() {
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
