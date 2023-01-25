package views;

import manipDb.ObjetBDD;

public class SpecEmp extends ObjetBDD {
    int idspecialite;
    int idemploye;
    String specialite;
    double salaire;

    public int getIdspecialite() {
        return idspecialite;
    }

    public void setIdspecialite(int idspecialite) {
        this.idspecialite = idspecialite;
    }

    public int getIdemploye() {
        return idemploye;
    }

    public void setIdemploye(int idemploye) {
        this.idemploye = idemploye;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public SpecEmp(int idspecialite, int idemploye, String specialite, double salaire) {
        this.idspecialite = idspecialite;
        this.idemploye = idemploye;
        this.specialite = specialite;
        this.salaire = salaire;
    }

    public SpecEmp() {
    }
}
