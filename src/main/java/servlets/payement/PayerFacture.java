package servlets.payement;

import DAO.FactureDAO;
import exeptions.MontantInvalide;
import exeptions.RestePayementException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.facture.Payement_facture;
import views.FactureDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "PayerFacture", value = "/PayerFacture")
public class PayerFacture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
//        get datas
        try {
            double famerimBola=0;
            String messageDerreur="";
            String messageSucces="";
            double montant = Double.parseDouble(request.getParameter("montant"));
            int idFacture = Integer.parseInt(request.getParameter("idFacture"));
            try {
                FactureDAO.checkMontantPayementFacture(idFacture, montant, connection);

            }catch(RestePayementException restes)
            {
                famerimBola=restes.getResteMontant();
                request.setAttribute("fameriny",famerimBola);
            }
            catch (MontantInvalide montantInvalide)
            {
                messageDerreur="le montant que vous avez insere n'est pas valide ";
                connection.close();
                request.setAttribute("MessageErreur", messageDerreur);
                request.getRequestDispatcher("payer.jsp").forward(request,response);
            }
            Payement_facture payer=new Payement_facture(idFacture,montant);
            payer.insert(connection);
            messageSucces="payement effectue avec succes ";
            request.setAttribute("messageSucces", messageSucces);
            connection.close();
            request.getRequestDispatcher("payer.jsp").forward(request,response);

        } catch (Exception e)
        {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();

        }
    }
}
