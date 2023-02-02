<%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 18/01/2023
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header id="header" class="fixed-top d-flex align-items-center">
  <div class="container d-flex align-items-center">

    <div class="logo me-auto">
      <h1><a href="#">GARAGE</a></h1>
    </div>

    <nav id="navbar" class="navbar order-last order-lg-0">
      <ul>
        <li><a class="nav-link scrollto active" href="${pageContext.request.contextPath}/PrepaAccueil">Accueil</a></li>
        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/PrepaInsertEmp">Employes</a></li>
        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/PrepaInsertPiece">Pieces</a></li>
        <li><a class="nav-link scrollto" href="${pageContext.request.contextPath}/PrepaDemandeDevis">Services</a></li>
        <li><a class="nav-link scrollto " href="${pageContext.request.contextPath}/Prepabenefices">Benefice</a></li>
        <li><a class="nav-link scrollto dropdown-toggle" id="dropdownMenuLink" data-toggle="dropdown"  aria-expanded="false">Factures</a>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                  <a class="dropdown-item" href="${pageContext.request.contextPath}/PrepaInsertionFacture">Nouvelle facture         .</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/DetailListeFacture">Liste Factures         .</a>
                  <a class="dropdown-item" href="#"></a>

          </div>
        </li>
<%--        <li><a class="nav-link scrollto " href="${pageContext.request.contextPath}/TodayStuff">TodayStuff</a></li>--%>

<%--        <li><a class="nav-link scrollto" href="#">Depense</a></li>--%>
        <li title="log out"><a class="nav-link scrollto" href="#" ><i class="fa fa-sign-out"  size="100"></i></a></li>
      </ul>
      <i class="bi bi-list mobile-nav-toggle">
      </i>
    </nav><!-- .navbar -->

   <%-- <div class="header-social-links d-flex align-items-center">
      <a href="twitter.com" class="twitter"><i class="bi bi-twitter"></i></a>
      <a href="facebook.com" class="facebook"><i class="bi bi-facebook"></i></a>
      <a href="instagram.com" class="instagram"><i class="bi bi-instagram"></i></a>
      <a href="linkedin.com" class="linkedin"><i class="bi bi-linkedin"></i></a>
    </div>--%>

  </div>
</header>
