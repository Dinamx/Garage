package servlets.facture;

import DAO.ClientDAO;
import DAO.FactureDAO;
import DAO.ServiceDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.facture.Facture;
import model.service.TypeService;
import model.userBasic.Client;
import views.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "ListeService", value = "/ListeService")
public class ListeService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        /** todo enregistrement de la facture
         * lister tous les services */
        try{
            int idClient= Integer.parseInt(request.getParameter("client"));
            Vector<Client> client= ClientDAO.listAllClient(connection," where id="+idClient);
            Client c = client.get(0);
            Boolean isBirthday=c.isBirthday();

            String libelle=request.getParameter("libelle");

            Facture facture=new Facture(idClient, libelle);
            boolean remise100= FactureDAO.factureAnnuelle(connection,c.getId());

            int idFacture=facture.insertReturning(connection);
            out.println(idFacture);
            Vector<TypeService> listeservice= ServiceDAO.listeTypeService(connection);
            request.setAttribute("idFacture",idFacture);
            request.setAttribute("listeservice",listeservice);
            request.setAttribute("isBirthday",isBirthday);
            request.setAttribute("remise100",remise100);
            connection.close();
            request.getRequestDispatcher("ListeServiceFacture.jsp").forward(request,response);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}