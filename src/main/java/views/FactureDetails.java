package views;

import manipDb.ObjetBDD;

import java.sql.Date;

public class FactureDetails extends ObjetBDD {
    int id_facture;
    int idclient;
    double total=0;
    double payee=0;
    double reste=0;
    Date dateFacture;



    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int id_client) {
        this.idclient = id_client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPayee() {
        return payee;
    }

    public void setPayee(double payee) {
        this.payee = payee;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }


    public FactureDetails(int id_facture, int id_client, double total, double payee, double reste, Date dateFacture) {
        this.id_facture = id_facture;
        this.idclient = id_client;
        this.total = total;
        this.payee = payee;
        this.reste = reste;
        setDateFacture(dateFacture);

    }

    public FactureDetails() {
    }
}
