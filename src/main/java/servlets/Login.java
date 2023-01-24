package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import manipDb.Connexion;
import model.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Connection connection =new Connexion().getConnexion();
        PrintWriter out=response.getWriter();
     try {
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         String erreurs="";
         out.print("eto");
         Admin admin=new Admin(email,password);
         if(admin.find(connection)==null)
         {
             erreurs="mot de passe ou email incorrect ";
             request.setAttribute("erreur",erreurs);
             out.println("admin: "+ admin);
             request.getRequestDispatcher("index.jsp").forward(request,response);
         }
         else {
             request.getSession().setAttribute("admin", admin);
             out.println("yayyyy: " + admin);
//             request.getRequestDispatcher("index.jsp").forward(request,response);
             response.sendRedirect(request.getContextPath()+"/PrepaAccueil");
                out.println("oups");
         }




         connection.close();
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
    }
}
