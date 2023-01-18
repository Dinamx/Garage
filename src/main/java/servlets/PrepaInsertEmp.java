package servlets;

import DAO.EmployeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manipDb.Connexion;
import model.Genre;
import model.NiveauEtude;
import model.Specialite;
import views.EmployeDetail;

/*import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;*/
import java.io.IOException;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaInsertEmp", value = "/PrepaInsertEmp")
public class PrepaInsertEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*zvt ilaiko : liste genre
        * liste niveau d'etudes
        * liste specialites */
        Connection connection=new Connexion().getConnexion();
//
        try {
            Vector<NiveauEtude> niveauEtudes = EmployeDAO.listeNiveauEtude(connection, "");
            Vector<Specialite> specialites = EmployeDAO.listeSpecialites(connection, "");
            Vector<EmployeDetail> employeDetails=EmployeDAO.listeEmployeDetail(connection,"");
            request.setAttribute("niveauEtude", niveauEtudes);
            request.setAttribute("specialites", specialites);
            request.setAttribute("employedetail", employeDetails);

            request.getRequestDispatcher("employe.jsp").forward(request,response);
        } catch(Exception e)

        {
            throw new RuntimeException();
        }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}