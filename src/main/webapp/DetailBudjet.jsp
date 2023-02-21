<%--=============================COMMENTS THAT MAY BE USEFULL=================================
Servlet miantso : ListeFacturePromotion
servlet Antsoiny :

ROLE : PAYER (link)-> REDIRECTION VERS LA PAGE payer.jsp(formulaire de payement )
=============================END COMMENT=================================--%>

<%@ page import="java.util.Vector" %>
<%@ page import="views.Benefices" %>
<%@ page import="views.FactureDetails" %>
<%@ page import="views.DetailFacturePromus" %>
<%@ page import="views.DetailBudjet" %>
<%@ page import="model.Report" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String title ="benefices";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>
<html>
<body>
<%--===header===--%>
<%@include file="inc/header.jsp"%>
<%--==============================CONTENT============================================ --%>
<%--datas--%>
<% Vector<DetailBudjet> detailbudjet=new Vector<>();
    if(request.getAttribute("detailbudjet")!=null)
        detailbudjet=(Vector<DetailBudjet>) request.getAttribute("detailbudjet");
double TotalRecette=0;
    if(request.getAttribute("TotalRecette")!=null)
        TotalRecette= (double) request.getAttribute("TotalRecette");

    double TotalDepenses=0;
    if(request.getAttribute("TotalDepenses")!=null)
        TotalDepenses= (double) request.getAttribute("TotalDepenses");

    double Caisse=0;
    if(request.getAttribute("Caisse")!=null)
        Caisse= (double) request.getAttribute("Caisse");
    Report rep = new Report();
    if(request.getAttribute("report")!=null)
        rep= (Report) request.getAttribute("report");



%>


<%--end datas--%>

<!-- table liste -->

<div class="tab mycontainer">
    <h2 class="text">Detail Budjet  </h2>
    <div class="table-responsive">
        <table class="table">
            <thead style="position: sticky; top: 0" class="thead-dark" >
            <tr class="tete">

                <th></th>
                <th>recette</th>
                <th>depenses</th>
                <th>caisse </th>
                <th>mois</th>
                <th>annee </th>


            </tr>
            </thead>
            <tbody>
<%--            <% for (int i = 0; i < detailbudjet.size(); i++) {%>
            <tr class="anatiny">

                <td></td>
                <td><%=detailbudjet.get(i).getRecette()%></td>
                <td><%=detailbudjet.get(i).getTotaldepense()%></td>
                <td><%=detailbudjet.get(i).getCaisse()%></td>
                <td><%=detailbudjet.get(i).getMonth()%></td>
                <td><%=detailbudjet.get(i).getYear()%></td>



            </tr>
            <%}%>--%>

            <tr class="anatiny">

                <td>TOTAL</td>
                <td><%=TotalRecette%></td>
                <td><%=TotalDepenses%></td>
                <td><%=Caisse%></td>
                <td></td>
                <td></td>



            </tr>
            </tbody>
        </table>

        <p>date report : <%=rep.getDateReport()%> </p>
        <p>montant  : <%=rep.getMontantReport()%></p>
    </div>
</div>


<%@include file="inc/script.jsp"%>

</body>
</html>
