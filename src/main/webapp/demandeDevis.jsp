<%@ page import="java.util.Vector" %>
<%@ page import="model.service.TypeService" %>
<%@ page import="DAO.DevisDAO" %><%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 18/01/2023
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String title="demande de devis "; %>

<%@include file="inc/head.jsp"%>
<%--======DATAS======== --%>
<% Vector< TypeService> services=(Vector<TypeService>) request.getAttribute("services");
%>


<body>
<%@include file="inc/header.jsp"%>

<%--=====CONTENT======--%>

<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
    <div class="wrapper wrapper--w790">
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">demande de devis</h2>
            </div>
            <div class="card-body">
                <form method="POST" action="${pageContext.request.contextPath}/Demandedevis">

<%--                    CLIENT ID --%>
                    <div class="form-row">
                        <div class="name">numero client</div>
                        <div class="value">
                            <div class="input-group">
<%--                                todo fonction de verification si le client existe  --%>
                                <input class="input--style-5" type="number" name="ClientId">
                            </div>
                        </div>
                    </div>

<%--                    TYPE SERVICES --%>
                    <div class="form-row">
                        <div class="name">Services</div>
                        <div class="value">
                            <div class="input-group">
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="service">
                                        <%
                                            for (int i = 0; i < services.size(); i++) {

                                        %>
                                        <option value="<%=services.get(i).getId()%>"><%=services.get(i).getService()%></option>
                                        <%}%>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="name">Prix de services </div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="number" name="prixServices">
                            </div>
                        </div>
                    </div>

                    <div>
                        <button class="btn btn--radius-2 btn--blue" type="submit">Valider</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="inc/script.jsp"%>

</body>
