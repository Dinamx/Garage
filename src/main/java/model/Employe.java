package model;

import exeptions.AgeExceptions;

import exeptions.EmptyFieldException;
import tools.Tools;

import manipDb.ObjetBDD;

import java.sql.Date;
import java.util.Objects;

public class Employe extends ObjetBDD {
    String nom;
    String prenom;
    Date dateNaissance;
    int idGenre;
    int idNiveauEtude;
    String numerotelephone;


    public String getNumerotelephone() {
        return numerotelephone;
    }

    public void setNumerotelephone(String numerotelephone) {
        this.numerotelephone = numerotelephone;
    }

    /** SETTERS - GETTERS*/

    public String getNom() {
        return nom;
    }


    public int getIdGenre() {
        return idGenre;
    }

    public void setNom(String nom) {

        this.nom = nom.trim();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom.trim();
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

    public Employe(String nom, String prenom, Date dateNaissance, int idGenre, int idNiveauEtude, String numerotelephone) throws AgeExceptions {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
        setIdGenre(idGenre);
        setIdNiveauEtude(idNiveauEtude);
        setNumerotelephone(numerotelephone);
    }
/** METHODS*/
    public boolean valueControl () throws EmptyFieldException {
        if(getDateNaissance()==null || getNom().equals("") || getPrenom().equals(""))
        {
            throw new EmptyFieldException();
        }
        return true;
    }

}
