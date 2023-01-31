package model.specialite;

import manipDb.ObjetBDD;

public class SpecialiteEmploye extends ObjetBDD {
    int idSpecialite;
    int idemploye;

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public int getIdemploye() {
        return idemploye;
    }

    public void setIdemploye(int idemploye) {
        this.idemploye = idemploye;
    }

    public SpecialiteEmploye(int idSpecialite, int idemploye) {
        this.idSpecialite = idSpecialite;
        this.idemploye = idemploye;
    }

    public SpecialiteEmploye() {
    }
}
