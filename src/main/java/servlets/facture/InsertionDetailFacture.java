package servlets.facture;

import DAO.ServiceDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.facture.Facture_service;
import model.service.TypeService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "InsertionDetailFacture", value = "/InsertionDetailFacture")
public class InsertionDetailFacture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        try
        {
            int idFacture= Integer.parseInt(request.getParameter("idFacture"));
            out.println("id facture "+idFacture);
            out.println("id service  "+request.getParameter("service"));
            out.println(idFacture);
            int idService= Integer.parseInt(request.getParameter("service").trim());
            int nombre= Integer.parseInt(request.getParameter("nombre").trim());
            boolean isBirthday= true;
            System.out.println(request.getParameter("isbirthday"));
                    if (request.getParameter("isbirthday").equalsIgnoreCase("true")) {
                        isBirthday = true;
                    }
                    else
                        isBirthday = false;
            double remise= Double.parseDouble(request.getParameter("remise").trim());

            Facture_service facture=new Facture_service(idFacture, idService,nombre);
            facture.setPromotion(remise);
            facture.insert(connection);
            Vector<TypeService> listeservice= ServiceDAO.listeTypeService(connection);
            request.setAttribute("idFacture",idFacture);
            request.setAttribute("listeservice",listeservice);
            request.setAttribute("isBirthday",isBirthday);
            connection.close();
            out.println("lol");
            request.getRequestDispatcher("ListeServiceFacture.jsp").forward(request,response);
        }
        catch (Exception e)
        {
            out.println(e);
            e.printStackTrace();
        }
    }
}