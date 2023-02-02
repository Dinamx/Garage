package servlets.facture;

import DAO.FactureDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import views.DetailFacturePromus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

@WebServlet(name = "ListeFacturePromotion", value = "/ListeFacturePromotion")
public class ListeFacturePromotion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        try {
            int idFacture = Integer.parseInt(request.getParameter("idFacture"));
            Vector<DetailFacturePromus> detailFacturePromus = FactureDAO.listeFactureEtPromotion(idFacture, connection);
            request.setAttribute("FacturePromotion", detailFacturePromus);
            System.out.println("Facture pron taille + "  + detailFacturePromus.size());
            connection.close();
            request.getRequestDispatcher("DetailFacture.jsp").forward(request,response);
        }catch (Exception e)
        {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
