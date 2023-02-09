package servlets.depenses;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.depenses.Depense;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "GestionDepenses", value = "/GestionDepenses")
public class GestionDepenses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        try{
            int idDepenses= Integer.parseInt(request.getParameter("type"));
            double prix= Double.parseDouble(request.getParameter("prix"));
            Depense d=new Depense(idDepenses, prix);
            int id=d.insertReturning(connection);
            System.out.println("ok");
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
