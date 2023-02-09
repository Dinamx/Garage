package servlets.facture;

import DAO.FactureDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.facture.Facture_service;
import views.FactureDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

@WebServlet(name = "DetailListeFacture", value = "/DetailListeFacture")
public class DetailListeFacture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        try{


            Vector<FactureDetails> listeFacture= FactureDAO.ListeDetailFactureA(connection);
            request.setAttribute("FactureDetail", listeFacture);
            connection.close();
            request.getRequestDispatcher("ListeFactureDetails.jsp").forward(request,response);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        try{
            System.out.println("detail liste facture tokoe");


//            Vector<FactureDetails> listeFacture= FactureDAO.ListeDetailFactureA(connection);
            Vector<FactureDetails> listeFacture= new Vector<>();

            request.setAttribute("listeFacture", listeFacture);
            connection.close();
            request.getRequestDispatcher("ListeFactureDetails.jsp").forward(request,response);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


}
