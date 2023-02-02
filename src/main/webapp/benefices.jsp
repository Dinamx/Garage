<%--=============================COMMENTS THAT MAY BE USEFULL=================================
servlet miantso : /PrepaBenefices
servlet antsoiny : null
role : page misy ny benefices rehetra azon'le entreprise -> total vola azo + marge beneficiaire + benefices obtenues

=============================END COMMENT=================================--%>
<%@ page import="java.util.Vector" %>
<%@ page import="views.Benefices" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String title ="benefices";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>
<html>
<body>
<%--===header===--%>
<%@include file="inc/header.jsp"%>
<%--=========================CONTENT===================================== --%>

<% Vector< Benefices> benefice=(Vector<Benefices>) request.getAttribute("benefice");%>

<!-- table liste -->

<div class="tab mycontainer">
    <h2 class="text">Benefices</h2>
    <div class="table-responsive">
        <table class="table">
            <thead style="position: sticky; top: 0" class="thead-dark" >
            <tr class="tete">

                <th>service</th>
                <th>valeur brut</th>
                <th>marge beneficiaire</th>
                <th>benefices</th>
            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < benefice.size(); i++) {%>
            <tr class="anatiny">

                <td><%=benefice.get(i).getService()%></td>
                <td><%=benefice.get(i).getValeurBrut()%> ariary</td>
                <td><%=benefice.get(i).getMarge()*100%></td>
                <td><%=benefice.get(i).getBenefices()%> ariary </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>


<%@include file="inc/script.jsp"%>

</body>
</html>
