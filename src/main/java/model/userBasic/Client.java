package model.userBasic;

import DAO.ClientDAO;
import manipDb.Connexion;
import manipDb.ObjetBDD;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;

public class Client extends ObjetBDD {
    int id;
    String nom;
    String prenom;
    String numero;
    Date dateDeNaissance;

    public Client(String nom, String prenom, String numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    public boolean isBirthday()
    {
        Date dateAnniversaire = this.dateDeNaissance;
        System.out.println(dateAnniversaire);
        Calendar calendar = Calendar.getInstance();
        int jourActuel = calendar.get(Calendar.DAY_OF_MONTH);
        int moisActuel = calendar.get(Calendar.MONTH) + 1; // ajoutez 1 car Calendar commence à 0 pour les mois

        Calendar anniversaire = Calendar.getInstance();
        anniversaire.setTime(dateAnniversaire);
        int jourAnniversaire = anniversaire.get(Calendar.DAY_OF_MONTH);
        int moisAnniversaire = anniversaire.get(Calendar.MONTH) + 1;

        return jourActuel == jourAnniversaire && moisActuel == moisAnniversaire;

    }


    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public Client(int id, String nom, String prenom, String numero, Date dateDeNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        System.out.println(dateDeNaissance);
        this.dateDeNaissance = dateDeNaissance;
    }

    public static void main(String[] args) throws Exception {
        Connection connection=new Connexion().getConnexion();
        Vector<Client> c=new Vector<>();

        c= (Vector<Client>)ClientDAO.listAllClient(connection,"");

        for (Client e : c) {
            System.out.println( e.getNom() + e.getDateDeNaissance() + e.isBirthday());
        }
//        c.setId(2);
//        c= (Client) c.find(connection);
//        System.out.println(c.nom +   c.isBirthday());
        }
}
