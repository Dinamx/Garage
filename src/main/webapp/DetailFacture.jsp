<%--=============================COMMENTS THAT MAY BE USEFULL=================================
Servlet miantso : ListeFacturePromotion
servlet Antsoiny :

ROLE : PAYER (link)-> REDIRECTION VERS LA PAGE payer.jsp(formulaire de payement )
=============================END COMMENT=================================--%>

<%@ page import="java.util.Vector" %>
<%@ page import="views.Benefices" %>
<%@ page import="views.FactureDetails" %>
<%@ page import="views.DetailFacturePromus" %>
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
<% Vector<DetailFacturePromus> factureDetail=new Vector<>();
    if(request.getAttribute("FacturePromotion")!=null)
        factureDetail=(Vector<DetailFacturePromus>) request.getAttribute("FacturePromotion");%>
<%--end datas--%>

<!-- table liste -->

<div class="tab mycontainer">
    <h2 class="text">Factures </h2>
    <div class="table-responsive">
        <table class="table">
            <thead style="position: sticky; top: 0" class="thead-dark" >
            <tr class="tete">

                <th>Id facture</th>
                <th>service</th>
                <th>prix Unitaire</th>
                <th>nombre</th>
                <th>promotion </th>
                <th>prix Total</th>

            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < factureDetail.size(); i++) {%>
            <tr class="anatiny">

                <td><%=factureDetail.get(i).getId_facture()%></td>
                <td><%=factureDetail.get(i).getService()%></td>
                <td><%=factureDetail.get(i).getPrixUnitaire()%></td>
                <td><%=factureDetail.get(i).getNombre()%></td>
                <td><%=factureDetail.get(i).getPromotion()%></td>
                <td><%=factureDetail.get(i).getPrixTotal()%></td>


            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>


<%@include file="inc/script.jsp"%>

</body>
</html>
