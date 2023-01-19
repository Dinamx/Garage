package model;

import manipDb.ObjetBDD;

public class TypeService extends ObjetBDD {
    int id;
    String service;
    double prix;
    int duree_supposee;

    public TypeService(int id, String service, double prix, int duree_supposee) {
        this.id = id;
        this.service = service;
        this.prix = prix;
        this.duree_supposee = duree_supposee;
    }

    public TypeService() {
    }

}
