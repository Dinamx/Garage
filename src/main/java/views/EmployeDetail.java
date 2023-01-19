package views;

import manipDb.ObjetBDD;

import java.sql.Date;

public class EmployeDetail extends ObjetBDD {
    int id_employe;
    String nom;
    String prenom;
    Date dateNaissance;
    String niveauEtude;

    String genre;
    double salaireMontant;
    double salaireHoraire;

    public EmployeDetail(int idemploye,String nom, String prenom, Date dateNaissance, String genre, double salaireMontant, double salaireHoraire, String niveauEtude) {
        setId_employe(idemploye);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.salaireMontant = salaireMontant;
        this.salaireHoraire = salaireHoraire;
        setNiveauEtude(niveauEtude);
    }

    public EmployeDetail() {
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getSalaireMontant() {
        return salaireMontant;
    }

    public void setSalaireMontant(double salaireMontant) {
        this.salaireMontant = salaireMontant;
    }

    public double getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(double salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }
}
