package servlets;

import DAO.ClientDAO;
import DAO.EmployeDAO;
import DAO.ServiceDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.actions.DemandeDevis;
import model.pieces.Vehicule;
import views.Service;
import views.SpecEmp;

import java.io.IOException;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "Demandedevis", value = "/Demandedevis")
public class Demandedevis extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        try {
            int idClient= Integer.parseInt(request.getParameter("ClientId"));
            int idServices= Integer.parseInt(request.getParameter("service"));
            double prixServices= Double.parseDouble(request.getParameter("prixServices"));

            if(ClientDAO.checkClient(idClient,connection))
            {
                // enregistrement de  la demande
                DemandeDevis devis=new DemandeDevis(idClient,idServices,prixServices);
                int idDevis=devis.insertReturning(connection);
//                preparation du service effectuee
                /** 1-> service effectue : libelle -> type de service / liste vehicule/ liste des specialites necessaires */

                Vector<Vehicule> listevehicule=ClientDAO.listeVehicule(connection);
                // maka ny specialites ao amle service :
                Vector<Service> listeService= ServiceDAO.listeservice(connection,idServices);
                /** 2-> liste employes en fonction an'ny specialites ilaina @ le service */
                Vector<Vector<SpecEmp>> specialitesEmp= EmployeDAO.listSpecialiteEmp(connection, listeService);

            request.setAttribute("idDevis",idDevis);
            request.setAttribute("listevehicule",listevehicule);
            request.setAttribute("listeService",listeService);
            request.setAttribute("specialitesEmp",specialitesEmp);


            }


            connection.close();
            /**redirection down here */

            request.getRequestDispatcher("serviceEffectue.jsp").forward(request,response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
