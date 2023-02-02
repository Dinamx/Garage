package display;

import manipDb.Connexion;
import model.userBasic.Client;
import model.userBasic.Employe;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection dbConnection=new Connexion().getConnexion();

        /** do tests right bellow this text   */

    /*    LocalDate local=LocalDate.now();
        Date date= Date.valueOf(LocalDate.now());
        Date test=Date.valueOf("2000-01-11");
        Employe emp=new Employe();
//        emp.createTable(dbConnection);
       *//* emp.setNom("Prisca");
        emp.setPrenom("Fehiarisoa");*//*
        emp.setDateNaissance(test);
        emp.setIdGenre(2);
        emp.setIdNiveauEtude(3);
        emp.valueControl();

        System.out.println("hello there it's prisca XD ");*/

        Client pridca=new Client("Dama","prenom","+261341872561");
        System.out.println(   pridca.insertReturning(dbConnection));


//        emp.insert(new Connexion().getConnexion());





        /** --------------------*/
//        dbConnection.commit();
        dbConnection.close();
    }
}
