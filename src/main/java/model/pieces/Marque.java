package model.pieces;

import manipDb.Connexion;
import manipDb.ObjetBDD;

import java.sql.Connection;

public class Marque extends ObjetBDD {
    int id;
    String marque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marque(String marque) {
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Marque(int id, String marque) {
        this.id = id;
        this.marque = marque;
    }

    public Marque() {
    }

    public static void main(String[] args) throws Exception {
        Connection connection=new Connexion().getConnexion();
        Object [] marque=new Marque().findAll(connection,"");
        Marque nm=(Marque) marque[0];
        System.out.println(nm.getId());
    }
}
