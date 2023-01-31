package servlets;

import DAO.DevisDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.service.TypeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaDemandeDevis", value = "/PrepaDemandeDevis")
public class PrepaDemandeDevis extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        try {
            Vector<TypeService> services = DevisDAO.listeServices(connection);
            request.setAttribute("services",services);
            connection.close();
            request.getRequestDispatcher("demandeDevis.jsp").forward(request,response);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
