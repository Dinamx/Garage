package model.service;

import manipDb.ObjetBDD;

public class ServiceEmploye extends ObjetBDD {
    int idServiceEffectue;
    int idEmploye;

    public ServiceEmploye(int idServiceEffectue, int idEmploye) {
        this.idServiceEffectue = idServiceEffectue;
        this.idEmploye = idEmploye;
    }

    public ServiceEmploye() {
    }

    public int getIdServiceEffectue() {
        return idServiceEffectue;
    }

    public void setIdServiceEffectue(int idServiceEffectue) {
        this.idServiceEffectue = idServiceEffectue;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }
}
