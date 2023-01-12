package servlets;

import model.Employe;
import database.core.Config;
import database.core.DBConnection;
import database.core.Database;
import manipDb.Connexion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "insertion", value = "/insertionEmp")
public class InsertionEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/** connexion base */
        Database database= Config.getPgDb();
        DBConnection dbConnection=null;
        try {
            dbConnection=database.createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /**----*/

        String nom=request.getParameter("Nom");
        String prenom=request.getParameter("prenom");
        String dateNaissance=request.getParameter("dateNaissance");
        int id_genre=Integer.valueOf(request.getParameter("genre"));
        int id_niveau=Integer.valueOf(request.getParameter("niveauEtude"));

        try {
            Employe insertedEmp=new Employe(nom,prenom,Date.valueOf(dateNaissance),id_niveau,id_genre);
            insertedEmp.insert(new Connexion().getConnexion());




        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /** close connexion*/
        try {
            dbConnection.commit();
            dbConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
