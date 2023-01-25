<%@ page import="java.util.Vector" %>
<%@ page import="model.Genre" %>
<%@ page import="model.NiveauEtude" %>
<%@ page import="model.Specialite" %>
<%@ page import="DAO.EmployeDAO" %>
<%@ page import="views.EmployeDetail" %>
<%@ page import="model.SpecialiteEmploye" %>
<%@ page import="views.SpecEmp" %>
<% String title="employes";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>

<%

    Vector <NiveauEtude> niveauEtudes=(Vector<NiveauEtude>)request.getAttribute("niveauEtude");
    Vector <Vector<SpecEmp>> specialites=(Vector<Vector<SpecEmp>>) request.getAttribute("specialites");
    Vector<EmployeDetail> employeDetails=(Vector<EmployeDetail>) request.getAttribute("employedetail");
    Vector<Specialite> spec=(Vector<Specialite>) request.getAttribute("listespecialite");
%>
<body>
    <!-- ======= Header ======= -->
    <%@include file="inc/header.jsp"%>
    <!-- End Header -->


    <!-- table liste -->
    <div class="tab mycontainer">
        <h2 class="text">Listes Employes</h2>
        <div class="table-responsive">
            <table class="table">
                <thead style="position: sticky; top: 0" class="thead-dark" >
                <tr class="tete">
                    <th class="header">Nom</th>
                    <th class="header">Prenom</th>
                    <th class="header">Numero de telephone</th>
                    <th class="header">Date de naissance</th>
                    <th class="header">Genre</th>
                    <th class="header">Niveau d'etude</th>
                    <th class="header">Listes specialites</th>
                    <th class="header">Salaire mensuel</th>
                    <th class="header">Salaire horaire</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < employeDetails.size(); i++) {

                %>
                <tr class="anatiny">
                    <td><%= employeDetails.get(i).getNom()%></td>
                    <td><%= employeDetails.get(i).getPrenom()%></td>
                    <td><%=employeDetails.get(i).getNumerotelephone()%></td>
                    <td><%= employeDetails.get(i).getDateNaissance()%></td>
                    <td><%= employeDetails.get(i).getGenre()%></td>
                    <td><%= employeDetails.get(i).getNiveauEtude()%></td>

                    <td>
                     <%

                            for (int k = 0; k < specialites.get(i).size(); k++) {
                                out.println(specialites.get(i).get(k).getSpecialite());
                            }


                    %>
                    </td>
                    <td><%= employeDetails.get(i).getSalaireMontant()%></td>
                    <td><%= employeDetails.get(i).getSalaireHoraire()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <!-- end table liste -->
    <!-- Formulaire insertion -->
  <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Insertion Employe</h2>
                </div>
                <div class="card-body">
<%--        FORM            --%>
                    <form method="POST" action="${pageContext.request.contextPath}/insertionEmp">
                        <div class="form-row m-b-5">
                            <div class="name">Nom</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-4">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="prenom">
                                            <label class="label--desc">Prenom</label>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="nom">
                                            <label class="label--desc">Nom</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="form-row">
                            <div class="name">Date de naissance</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="date" name="dateNaissance">
                                </div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="name">telephone</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="tel" name="telephone">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Genre</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="idgenre">
                                            <option value="1">homme</option>
                                            <option value="2">femme</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Niveau d'etudes</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="idNiveauEtude">
                                            <%
                                                for (int i = 0; i < niveauEtudes.size(); i++) {

                                                %>
                                            <option value="<%=niveauEtudes.get(i).getDescription()%>"><%=niveauEtudes.get(i).getDescription()%></option>
                                            <%}%>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>

<%--                        --%>
                        <div class="form-row">
                            <div class="name">Specialite</div>
                            <div class="value">

                                        <%
                                            for (int i = 0; i < spec.size(); i++) {
                                        %>

                                <div class="form-check">
                                    <input class="form-check-input" name="<%=spec.get(i).getSpecialite()%>" type="checkbox" value="" id="flexCheckDefault<%=i%>">
                                    <label class="form-check-label" for="flexCheckDefault<%=i%>">
                                        <%=spec.get(i).getSpecialite()%>
                                    </label>
                                </div>
                                        <%}%>
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
    
    
    <!-- end formulaire insertion -->
    <!-- Jquery JS-->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="assets/vendor/select2/select2.min.js"></script>
    <script src="assets/vendor/datepicker/moment.min.js"></script>
    <script src="assets/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="assets/js/global.js"></script>
</body>
</html>