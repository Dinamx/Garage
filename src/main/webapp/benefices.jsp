<%@ page import="java.util.Vector" %>
<%@ page import="views.Benefices" %><%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 19/01/2023
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String title ="benefices";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>
<html>
<body>
<%--===header===--%>
<%@include file="inc/header.jsp"%>
<%--=====content --%>
<%--datas--%>
<% Vector< Benefices> benefice=(Vector<Benefices>) request.getAttribute("benefice");%>
<%--end datas--%>

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
