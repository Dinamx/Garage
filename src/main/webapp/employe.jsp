<%@ page import="java.util.Vector" %>
<%@ page import="model.Genre" %>
<%@ page import="model.NiveauEtude" %>
<%@ page import="model.Specialite" %>
<%@ page import="DAO.EmployeDAO" %>
<%@ page import="views.EmployeDetail" %>
<%@ page import="model.SpecialiteEmploye" %>
<% String title="employes";%>
<%@include file="inc/head.jsp"%>

<%

    Vector <NiveauEtude> niveauEtudes=(Vector<NiveauEtude>)request.getAttribute("niveauEtude");
    Vector <Specialite> specialites=(Vector<Specialite>)request.getAttribute("specialites");
    Vector<EmployeDetail> employeDetails=(Vector<EmployeDetail>) request.getAttribute("employedetail");
%>
<body>
    <!-- ======= Header ======= -->
    <%@include file="inc/header.jsp"%>
    <!-- End Header -->


    <!-- table liste -->
    <div class="tab">
        <h2 class="text">Listes Employes</h2>
        <div class="table-responsive">
            <table class="table">
                <tr class="tete">
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Numero de telephone</th>
                    <th>Date de naissance</th>
                    <th>Genre</th>
                    <th>Niveau d'etude</th>
                    <th>Listes specialites</th>
                    <th>Salaire mensuel</th>
                    <th>Salaire horaire</th>
                </tr>
                <% for (int i = 0; i < employeDetails.size(); i++) {

                %>
                <tr class="anatiny">
                    <td><%= employeDetails.get(i).getNom()%></td>
                    <td><%= employeDetails.get(i).getPrenom()%></td>
                    <td></td>
                    <td><%= employeDetails.get(i).getDateNaissance()%></td>
                    <td><%= employeDetails.get(i).getGenre()%></td>
                    <td><%= employeDetails.get(i).getNiveauEtude()%></td>
                    <%
                        Vector<SpecialiteEmploye> specialiteEmployes= null;
                        try {
                            specialiteEmployes = EmployeDAO.listSpecialiteEmp(employeDetails.get(i).getId_employe());

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        StringBuilder strspecialites= new StringBuilder();
                       /* for (int j = 0; j < specialiteEmployes.size(); j++) {
                            strspecialites.append(specialiteEmployes.get(i).getIdSpecialite()).append("\t");
                        }*/

                    %>
                    <td>
                     <%=strspecialites.toString() %>
                    </td>
                    <td><%= employeDetails.get(i).getSalaireMontant()%></td>
                    <td><%= employeDetails.get(i).getSalaireHoraire()%></td>
                </tr>
                <%}%>
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
                        <div class="form-row m-b-55">
                            <div class="name">Nom</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="prenom">
                                            <label class="label--desc">Prenom</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
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
                            <div class="name">Genre</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="idgenre">
                                            <option value="homme">homme</option>
                                            <option value="femme">femme</option>
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
                                            for (int i = 0; i < specialites.size(); i++) {
                                        %>

                                <div class="form-check">
                                    <input class="form-check-input" name="<%=specialites.get(i).getSpecialite()%>" type="checkbox" value="" id="flexCheckDefault<%=i%>">
                                    <label class="form-check-label" for="flexCheckDefault<%=i%>">
                                        <%=specialites.get(i).getSpecialite()%>
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