package views;

import manipDb.ObjetBDD;

public class Benefices extends ObjetBDD {
    double valeurBrut;
    String service;
    double benefices;
    double marge;
    int idservices;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Benefices(double valeurBrut, double benefices, double marge, int idservices, String service) {
        this.valeurBrut = valeurBrut;
        this.benefices = benefices;
        this.marge = marge;
        this.idservices = idservices;
        setService(service);
    }

    public Benefices() {
    }

    public double getValeurBrut() {
        return valeurBrut;
    }

    public void setValeurBrut(double valeurBrut) {
        this.valeurBrut = valeurBrut;
    }

    public double getBenefices() {
        return benefices;
    }

    public void setBenefices(double benefices) {
        this.benefices = benefices;
    }

    public double getMarge() {
        return marge;
    }

    public void setMarge(double marge) {
        this.marge = marge;
    }

    public int getIdservices() {
        return idservices;
    }

    public void setIdservices(int idservices) {
        this.idservices = idservices;
    }
}
