package servlets;

import DAO.PiecesDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.AchatPiece;
import model.Piece;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

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
            /*AchatPiece achat=new AchatPiece(id,quantite,prixTotal);
            achat.insert(connection);*/
//            request.getRequestDispatcher("/PrepaAccueil").forward(request,response);
            connection.close();
            response.sendRedirect(request.getContextPath()+"/PrepaAccueil");


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
