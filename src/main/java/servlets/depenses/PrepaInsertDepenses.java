package servlets.depenses;

import DAO.DepensesDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.depenses.TypeDepense;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

@WebServlet(name = "PrepaInsertDepenses", value = "/PrepaInsertDepenses")
public class PrepaInsertDepenses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection=new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
        try {
            Vector<TypeDepense> typedepenses = DepensesDAO.getListDepense(connection);
            request.setAttribute("typedepenses",typedepenses);
            connection.close();
            request.getRequestDispatcher("insertionDepenses.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
