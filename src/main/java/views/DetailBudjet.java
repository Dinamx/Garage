package views;

import manipDb.ObjetBDD;

public class DetailBudjet extends ObjetBDD {
    double totaldepense;
    double recette;
    double caisse;
    int month;
    int year;

    public DetailBudjet(double totaldepense, double recette, double caisse, int month, int year) {
        this.totaldepense = totaldepense;
        this.recette = recette;
        this.caisse = caisse;
        this.month = month;
        this.year = year;
    }

    public DetailBudjet() {
    }

    public double getTotaldepense() {
        return totaldepense;
    }

    public void setTotaldepense(double totaldepense) {
        this.totaldepense = totaldepense;
    }

    public double getRecette() {
        return recette;
    }

    public void setRecette(double recette) {
        this.recette = recette;
    }

    public double getCaisse() {
        return caisse;
    }

    public void setCaisse(double caisse) {
        this.caisse = caisse;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
