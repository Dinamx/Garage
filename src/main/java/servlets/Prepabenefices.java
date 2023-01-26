package servlets;

import DAO.DevisDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import views.Benefices;
import views.Devis;

import java.io.IOException;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "Prepabenefices", value = "/Prepabenefices")
public class Prepabenefices extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        try {
            Vector<Benefices> benefices= DevisDAO.listebenefices(connection);

            request.setAttribute("benefice",benefices);
            connection.close();
            request.getRequestDispatcher("benefices.jsp").forward(request,response);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
