package servlets;

import DAO.PiecesDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.Piece;
import model.AchatPiece;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "InsertionProduit", value = "/InsertionProduit")
public class InsertionProduit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**CONFIG */
        Connection connection=new Connexion().getConnexion();
        /**GET DATAS FROM FORM*/
        String description=request.getParameter("descriptionPiece");
        double prixAchat= Double.parseDouble(request.getParameter("prixAchat"));
        int idModele= Integer.parseInt(request.getParameter("modele"));
        int idUnite= Integer.parseInt(request.getParameter("unite"));
        double quantite= Double.parseDouble(request.getParameter("quantite"));
        /** ADD TO DBA */
        try {
            Piece inserted = new Piece(description, idUnite, idModele);
            int idPiece=-1;
            if (inserted.find(connection)==null)
            {
                idPiece=inserted.insertReturning(connection);
            }
            else{
                idPiece= PiecesDAO.getPieceId(inserted,connection);
            }
            AchatPiece stock=new AchatPiece(idPiece,quantite,prixAchat);
            stock.insert(connection);
            request.getRequestDispatcher("/PrepaInsertPiece").forward(request,response);


            /** end config */
        }catch (Exception e)
        {
            throw new RuntimeException();
        }
    }
}
