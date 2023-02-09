package servlets.depenses;

import DAO.DepensesDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import views.DetailBudjet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaListeBudjet", value = "/PrepaListeBudjet")
public class PrepaListeBudjet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        try{
            Vector<DetailBudjet> detailbudjet= DepensesDAO.listDetailBudjet(connection);
            double TotalRecette=DepensesDAO.TotalRecette(detailbudjet);
            double TotalDepenses=DepensesDAO.depensesTotal(detailbudjet);
            double Caisse=DepensesDAO.Caisse(detailbudjet);
            request.setAttribute("detailbudjet" , detailbudjet);
            request.setAttribute("TotalDepenses" , TotalDepenses);
            request.setAttribute("TotalRecette" , TotalRecette);
            request.setAttribute("Caisse" , Caisse);
            connection.close();
            request.getRequestDispatcher("DetailBudjet.jsp").forward(request,response);
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
