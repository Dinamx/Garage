package display;

import manipDb.Connexion;
import model.Employe;
import database.core.Config;
import database.core.DBConnection;
import database.core.Database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection dbConnection=new Connexion().getConnexion();

        /** do tests right bellow this text   */

        LocalDate local=LocalDate.now();
        Date date= Date.valueOf(LocalDate.now());
        Date test=Date.valueOf("2000-01-11");
        Employe emp=new Employe();
//        emp.createTable(dbConnection);
       /* emp.setNom("Prisca");
        emp.setPrenom("Fehiarisoa");*/
        emp.setDateNaissance(test);
        emp.setIdGenre(2);
        emp.setIdNiveauEtude(3);
        emp.valueControl();

        System.out.println("hello there it's prisca XD ");


        emp.insert(new Connexion().getConnexion());





        /** --------------------*/
//        dbConnection.commit();
        dbConnection.close();
    }
}
