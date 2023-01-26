package servlets;

import DAO.EmployeDAO;
import exeptions.AgeExceptions;
import exeptions.EmptyFieldException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employe;
import database.core.Config;
import database.core.DBConnection;
import database.core.Database;
import manipDb.Connexion;
import model.Specialite;
import model.SpecialiteEmploye;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

@WebServlet(name = "insertion", value = "/insertionEmp")
public class InsertionEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
/** connexion base */
        Connection connection = new Connexion().getConnexion();
        PrintWriter out = response.getWriter();

        /**----*/

/** GET DATAS FROM FORM*/
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissance = request.getParameter("dateNaissance");
        String numeroTelephone = request.getParameter("telephone");

        String genres = request.getParameter("genre");
        int id_genre = Objects.equals(genres, "homme") ? 1 : 2;

        int id_niveau = 0;
        try {
            id_niveau = EmployeDAO.getNiveauEtudeID(request.getParameter("idNiveauEtude"), connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
/** CREATE AN EMPLOYE */
        Employe insertedEmp = null;
        String erreur="";
        try {
            insertedEmp = new Employe(nom, prenom, Date.valueOf(dateNaissance), id_genre, id_niveau, numeroTelephone);

        }// TODO: 21/01/2023  redirection d'erreurs
        catch (AgeExceptions e) {
            erreur+="\t"+e.getMessage();
        }
        catch (EmptyFieldException empty)
        {
            erreur+="\t"+empty.getMessage();
        }
        if(erreur!="") {

/** INSERT EMP TO DBA */
            int id = -1;
            try {
                id = insertedEmp.insertReturning(new Connexion().getConnexion());

/** INSERT DATA ABOUT SPECIALITIES */
                // GET DATAS ABOUT SPECIALITIES

                Vector<Specialite> specialites = EmployeDAO.listeSpecialites(connection, "");
                for (int i = 0; i < specialites.size(); i++) {
                    if (request.getParameter(specialites.get(i).getSpecialite()) != null) {
                        SpecialiteEmploye specialiteEmploye = new SpecialiteEmploye(EmployeDAO.getSpecialiteId(connection, specialites.get(i).getSpecialite()), id);
                        specialiteEmploye.insert(connection);
                    }
                }

//        response.sendRedirect("employe.jsp");
                /** close connexion*/

            connection.close();
            response.sendRedirect(request.getContextPath() + "/PrepaInsertEmp");
            } catch (Exception e) {
                e.printStackTrace();
            }
            }

        else{
            out.println("champs vides");
        }
//        request.getRequestDispatcher("/PrepaInsertEmp").forward(request,response);

    }
}
