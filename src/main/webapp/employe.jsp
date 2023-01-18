<%@ page import="java.util.Vector" %>
<%@ page import="model.Genre" %>
<%@ page import="model.NiveauEtude" %>
<%@ page import="model.Specialite" %>
<%@ page import="DAO.EmployeDAO" %>
<%@ page import="views.EmployeDetail" %>
<%@ page import="model.SpecialiteEmploye" %>

<%
    Vector <NiveauEtude> niveauEtudes=(Vector<NiveauEtude>)request.getAttribute("niveauEtude");
    Vector <Specialite> specialites=(Vector<Specialite>)request.getAttribute("specialites");
    Vector<EmployeDetail> employeDetails=(Vector<EmployeDetail>) request.getAttribute("employedetail");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, , shrink-to-fit=no">
    <!-- <meta content="" name="description">
    <meta content="" name="keywords"> -->
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
    <!-- Icons font CSS-->
    <link href="assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="assets/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">


    <!-- Template Main CSS File -->
    <link href="assets/css/insertCss.css" rel="stylesheet" media="all">
    <title>Insertion</title>
</head>
<body>
    <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center">

      <div class="logo me-auto">
        <h1><a href="#">GARAGE</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="#">Accueil</a></li>
          <li><a class="nav-link scrollto" href="#">Employes</a></li>
          <li><a class="nav-link scrollto" href="#">Services</a></li>
          <li><a class="nav-link scrollto " href="#">Benefice</a></li>
          <li><a class="nav-link scrollto" href="#">Depense</a></li>
          <li><a class="nav-link scrollto" href="#">Log out</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

      <div class="header-social-links d-flex align-items-center">
        <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
        <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
        <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
        <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
      </div>

    </div>
  </header><!-- End Header -->


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
                    <td>
                 <%--       <%
                            Vector<SpecialiteEmploye> specialiteEmployes=EmployeDAO.listSpecialiteEmp(employeDetails.get(i).getId_employe());
                            for (int j = 0; j < specialiteEmployes.size(); j++) {
                                out.println(specialiteEmployes.get(i).getIdSpecialite());
                            }

                        %>--%>
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