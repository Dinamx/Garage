/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipDb;

import java.sql.*;

/**
 *
 * @author dina
 */
public class Connexion {
    Connection cnt;
    Statement stm;
    ResultSet res;
    String user = "priscafehiarisoadama";
    String password = "";
    String base = "garage";

    public Connexion() {
        try {
            Class.forName("org.postgresql.Driver");

            this.cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + base, user, password);
            this.stm = this.cnt.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nope");
        }
    }

    public Connexion(String req) throws Exception {
        try {

            Class.forName("org.postgresql.Driver");
            this.cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + base, user, password);
            this.stm = this.cnt.prepareStatement(req);
            this.stm = this.cnt.createStatement();
            System.out.println(req);
            this.res = stm.executeQuery(req);
        } catch (Exception e) {
            e.getMessage();
        } finally {

        }

    }

    public ResultSet getResultset() {
        return this.res;
    }

    public Connection getConnexion() {
        return this.cnt;
    }

    public Statement getStatement() {
        return this.stm;
    }
}
