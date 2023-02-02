<%--=============================COMMENTS THAT MAY BE USEFULL=================================
Servlet miantso : DetailListeFacture
servlet Antsoiny :

ROLE : PAYER (link)-> REDIRECTION VERS LA PAGE payer.jsp(formulaire de payement )
=============================END COMMENT=================================--%>

<%@ page import="java.util.Vector" %>
<%@ page import="views.Benefices" %>
<%@ page import="views.FactureDetails" %>
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
<% Vector<FactureDetails> factureDetail=new Vector<>();
    if(request.getAttribute("FactureDetail")!=null)
        factureDetail=(Vector<FactureDetails>) request.getAttribute("FactureDetail");%>
<%--end datas--%>

<!-- table liste -->

<div class="tab mycontainer">
    <h2 class="text">Factures </h2>
    <div class="table-responsive">
        <table class="table">
            <thead style="position: sticky; top: 0" class="thead-dark" >
            <tr class="tete">

                <th>Id facture</th>
                <th>Client</th>
                <th>Date</th>
                <th>Montant Total</th>
                <th>montant paye </th>
                <th>reste A payer</th>
                <th>payement </th>
                <th>detail facture </th>
            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < factureDetail.size(); i++) {%>
            <tr class="anatiny">

                <td><%=factureDetail.get(i).getId_facture()%></td>
                <td><%=factureDetail.get(i).getIdclient()%></td>
                <td><%=factureDetail.get(i).getDateFacture()%></td>
                <td><%=factureDetail.get(i).getTotal()%></td>
                <td><%=factureDetail.get(i).getPayee()%></td>
                <td><%=factureDetail.get(i).getReste()%></td>
                <td><a href="payer.jsp?idFacture=<%=factureDetail.get(i).getId_facture()%>&idClient=<%=factureDetail.get(i).getIdclient()%>&reste=<%=factureDetail.get(i).getReste()%>&date=<%=factureDetail.get(i).getDateFacture()%>">payer</a></td>
                <td><a href="">details</a></td>

            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>


<%@include file="inc/script.jsp"%>

</body>
</html>
