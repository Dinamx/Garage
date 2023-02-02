package servlets.facture;

import DAO.ClientDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.userBasic.Client;

import java.io.IOException;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaInsertionFacture", value = "/PrepaInsertionFacture")
public class PrepaInsertionFacture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        try {
            Vector<Client> client= ClientDAO.listeClient(connection);
            request.setAttribute("client",client);

            connection.close();
            request.getRequestDispatcher("insertionFacture.jsp").forward(request,response);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
