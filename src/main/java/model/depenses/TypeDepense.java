package model.depenses;

import manipDb.ObjetBDD;

public class TypeDepense extends ObjetBDD {
    int id;
    String type;

    public TypeDepense(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public TypeDepense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
