package model;

import exeptions.AgeExceptions;

import tools.Tools;

import manipDb.ObjetBDD;

import java.sql.Date;

public class Employe extends ObjetBDD {
    String nom;
    String prenom;
    Date dateNaissance;
    int idGenre;
    int idNiveauEtude;



    /** SETTERS - GETTERS*/
    public String getNom() {
        return nom;
    }


    public int getIdGenre() {
        return idGenre;
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

    public void setDateNaissance(Date dateNaissance) throws AgeExceptions {
        long year_difference= Tools.YearDifference(dateNaissance);
        if(year_difference>=18)
        {
            this.dateNaissance = dateNaissance;
        }
        else {
            throw new AgeExceptions();
        }
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public int getIdNiveauEtude() {
        return idNiveauEtude;
    }

    public void setIdNiveauEtude(int idNiveauEtude) {
        this.idNiveauEtude = idNiveauEtude;
    }

    /** CONSTRUCTOR*/
    public Employe() {

    }

    public Employe(String nom, String prenom, Date dateNaissance, int idGenre, int idNiveauEtude) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.idGenre = idGenre;
        this.idNiveauEtude = idNiveauEtude;
    }
/** METHODS*/


}
