<%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 19/01/2023
  Time: 06:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String erreurs="";

    if(request.getAttribute("admin")!=null) {
        response.sendRedirect(request.getContextPath() + "/PrepaAccueil");
    }
    else if(request.getAttribute("erreur")!=null)
    {
        erreurs= request.getAttribute("erreur").toString();
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    else{
        response.sendRedirect("login.jsp");
    }
    out.print("cool");
%>
