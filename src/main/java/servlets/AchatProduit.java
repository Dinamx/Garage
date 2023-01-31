package servlets;

import Alea.Produit;
import DAO.ServiceDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.actions.AchatPiece;
import model.service.MargeService;
import model.pieces.Piece;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "AchatProduit", value = "/AchatProduit")
public class AchatProduit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        /**GET DATA*/
        try {
//            Piece piece = PiecesDAO.getPiece(Integer.parseInt(request.getParameter("idpiece")), connection);
            double quantite= Double.parseDouble(request.getParameter("quantite"));
            double prixTotal= Double.parseDouble(request.getParameter("prixAchat"));
            int id =Integer.parseInt(request.getParameter("idpiece"));
//            todo : vente no tokony ho ataokoo eto  fa tsy achattt
//            todo : de tokony ampiana champ client koa zany
            AchatPiece achat=new AchatPiece(id,quantite,prixTotal);
            achat.insert(connection);

            Piece piece= (Piece) new Piece().find(connection," where id="+id);
//            request.getRequestDispatcher("/PrepaAccueil").forward(request,response);


            double marge  = new MargeService().getMarge(prixTotal,connection);
            double prixConseille = prixTotal + (prixTotal *( marge/100));
            Produit produit=new Produit(piece.getPiece(), prixTotal, prixConseille );
            produit.setMarge(marge);
            request.setAttribute("produit", produit);
            Vector<Produit> produits= ServiceDAO.listeProduit(connection);
            request.setAttribute("listeproduit",produits);
            connection.close();

            request.getRequestDispatcher("todayStuff.jsp").forward(request,response);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
