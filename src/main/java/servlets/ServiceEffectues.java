package servlets;

import DAO.ClientDAO;
import DAO.EmployeDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.ServiceEffectue;
import model.ServiceEmploye;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "ServiceEffectues", value = "/ServiceEffectues")
public class ServiceEffectues extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = new Connexion().getConnexion();
            /** ENREGISTRER SERVICE EFFECTUES */
            int nombreServices= Integer.parseInt(request.getParameter("nombreServices"));
            String immatriculation = (String) request.getParameter("vehicule");
            int duree= Integer.parseInt(request.getParameter("duree"));
            int iddemandeDevis= Integer.parseInt(request.getParameter("idDemandeDevis"));
            String libelle=request.getParameter("libelles");
            int idVehicule= ClientDAO.getVehicleId(immatriculation,connection);
            ServiceEffectue serviceEffectue=new ServiceEffectue(libelle,idVehicule,duree,iddemandeDevis);
            int idserviceEffectue=serviceEffectue.insertReturning(connection);

            for (int i = 0; i < nombreServices; i++) {
                int idEmploye= Integer.parseInt(request.getParameter("service"+i));
                ServiceEmploye serviceEmploye=new ServiceEmploye(idserviceEffectue,idEmploye);
                serviceEmploye.insert(connection);
            }

            connection.close();
            response.sendRedirect(request.getContextPath()+"/PrepaDemandeDevis");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
