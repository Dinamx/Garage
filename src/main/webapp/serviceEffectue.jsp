<%@ page import="model.Vehicule" %>
<%@ page import="java.util.Vector" %>
<%@ page import="views.SpecEmp" %>
<%@ page import="views.Service" %><%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 26/01/2023
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String title="services";%>
<%@include file="inc/head.jsp"%>
<body>
<%@include file="inc/header.jsp"%>
<%--datas --%>
<%
    String idDemandeDevis= request.getAttribute("idDevis").toString();
    Vector<Vehicule> listeVehicule= (Vector<Vehicule>) request.getAttribute("listevehicule");
    Vector<Service> listeService= (Vector<Service>) request.getAttribute("listeService");
    Vector<Vector<SpecEmp>> listeEmployes= (Vector<Vector<SpecEmp>>) request.getAttribute("specialitesEmp");
%>


<!-- Formulaire insertion -->
<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
    <div class="wrapper wrapper--w790">
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">Service effectues </h2>
            </div>
            <div class="card-body">
                <form method="POST" action="${pageContext.request.contextPath}/ServiceEffectues">

<%--                    DETAIL SERVICE --%>
                    <h2>
                        Detail Service
                    </h2>
                    <div class="form-row">
                        <div class="name">Service</div>
                        <div class="value">
                            <%=listeService.get(0).getService()%>
                        </div>
                    </div>
<%--    ---------------------LISTE VEHICULE ------------------------%>
    <div class="form-row">
        <div class="name">Vehicule</div>
        <div class="value">
            <div class="input-group">
                <div class="rs-select2 js-select-simple select--no-search">
                    <select name="vehicule">
                        <%
                            for (int i = 0; i < listeVehicule.size(); i++) {

                        %>
                        <option value="<%=listeVehicule.get(i).getImmatriculation()%>"><%=listeVehicule.get(i).getImmatriculation()%></option>
                        <%}%>
                    </select>
                    <div class="select-dropdown"></div>
                </div>
            </div>
        </div>
    </div>
<%--    -------------------------DUREE DE SERVICE---------------------%>
                    <div class="form-row">
                        <div class="name">duree de service (minutes )</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5" type="number" name="duree">
                            </div>
                        </div>
                    </div>
<%--    ---------------------------------------------------------%>
    <div>
        <h2>
            Service employes
        </h2>
    </div>

<%-------------------------SPECIALITE EMPLOYES -------------------------------%>
<%
    for (int i = 0; i < listeService.size(); i++) {

%>
                    <div class="form-row">
                        <div class="name"><%=listeService.get(i).getSpecialite()%></div>
                        <div class="value">
                            <div class="input-group">
                                <div class="rs-select2 js-select-simple select--no-search">
                                    <select name="service<%=i%>">
                                        <%
                                            for (int j = 0; j < listeEmployes.size(); j++) {

                                        %>
                                        <option value="<%=listeEmployes.get(i).get(j).getIdemploye()%>"><%=listeEmployes.get(i).get(j).getNom()%></option>
                                        <%}%>
                                    </select>
                                    <div class="select-dropdown"></div>
                                </div>
                            </div>
                        </div>
                    </div>
    <%}%>
<%--    -----------------HiDDEN INPUTS --------------%>
    <input type="hidden" name="idDemandeDevis" value="<%=idDemandeDevis%>">
    <input type="hidden" name="libelles" value="<%=listeService.get(0).getService()%>">
    <input type="hidden" name="nombreServices" value="<%=listeService.size()%>">
<%-------------------------------------------------------------------------%>

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

