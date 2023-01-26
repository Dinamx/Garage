package servlets;

import DAO.PiecesDAO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.Marque;
import model.Modele;
import model.Unite;

import java.io.IOException;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaInsertPiece", value = "/PrepaInsertPiece")
public class PrepaInsertPiece extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*unites
        * marque
        * */
        Connection connection=new Connexion().getConnexion();
//        ----------
        try {
            Vector<Unite> unite = PiecesDAO.listeUnite(connection);
            Vector <Modele>modele=PiecesDAO.listeModele(connection);
            request.setAttribute("unite", unite);
            request.setAttribute("modele", modele);
            connection.close();
            request.getRequestDispatcher("insertionProduit.jsp").forward(request,response);


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
