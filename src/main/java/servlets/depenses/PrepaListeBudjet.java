package servlets.depenses;

import DAO.DepensesDAO;
import DAO.ReportDAO;
import database.core.Config;
import database.core.DBConnection;
import database.core.Database;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.Report;
import views.DetailBudjet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Vector;

@WebServlet(name = "PrepaListeBudjet", value = "/PrepaListeBudjet")
public class PrepaListeBudjet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        Database data=Config.getPgDb();

        try{
            DBConnection dbConnection=data.createConnection();
            Vector<DetailBudjet> detailbudjet= DepensesDAO.listDetailBudjet(connection);

            Report r= ReportDAO.getLastReport(Timestamp.from(Instant.now()),dbConnection );

            double TotalRecette=ReportDAO.getRecette(r,connection);
            double TotalDepenses=ReportDAO.getDepense(r,connection);
            double Caisse=TotalRecette-TotalDepenses;
            request.setAttribute("detailbudjet" , detailbudjet);
            request.setAttribute("TotalDepenses" , TotalDepenses);
            request.setAttribute("TotalRecette" , TotalRecette);
            request.setAttribute("Caisse" , Caisse);
            request.setAttribute("report", r);
            /*connection.close();
            dbConnection.close();
            dbConnection.commit();*/
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
