package servlets;

import DAO.PiecesDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.pieces.Modele;
import model.pieces.Piece;
import views.AchatVente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaAccueil", value = "/PrepaAccueil")
public class PrepaAccueil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out = response.getWriter();


        try {
            Vector<Piece> pieces = PiecesDAO.listePiece(connection, "");
            Vector<Modele> modele=PiecesDAO.listeModele(connection);
            Vector<AchatVente> stock=PiecesDAO.listeAchatVente(connection);
            out.println(pieces.size());
            out.println(modele.size());
            request.setAttribute("pieces",pieces);
            request.setAttribute("modele",modele);
            request.setAttribute("stock",stock);
            connection.close();
            request.getRequestDispatcher("accueil.jsp").forward(request,response);

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
