<%@ page import="java.util.Vector" %>
<%@ page import="model.Piece" %>
<%@ page import="model.Modele" %>
<%@ page import="model.AchatPiece" %>
<%@ page import="views.AchatVente" %>
<% String title="Accueil";%>
<%@include file="inc/head.jsp"%>
<body>
    <!-- ======= Header ======= -->
    <%@include file="inc/header.jsp"%>
    <!-- End Header -->
    <%--========DATAS======--%>
    <%
        Vector<Piece> pieces=(Vector<Piece>) request.getAttribute("pieces");
//        out.println(pieces.size());
        Vector<Modele> modele=(Vector<Modele>) request.getAttribute("modele");
        Vector<AchatVente> stock=(Vector<AchatVente>) request.getAttribute("stock");
    %>

  <!-- Formulaire insertion -->
  <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Achat de piece</h2>
                </div>
                <div class="card-body">
                    <form method="POST">
                        <div class="form-row">
                            <div class="name">Piece</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="" required onchange="fill()" id="piece">
                                            <option disabled="disabled" selected="selected">Selelctionner</option>
                                            <% for (int i = 0; i < pieces.size(); i++) {%>
                                            <option value=" <%=pieces.get(i).getPiece()%>"><%=pieces.get(i).getPiece()%></option>
                                            <%}%>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Modele de la piece </div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="">
                                            <option disabled="disabled" selected="selected">choisir un modele</option>
                                            <%
                                                for (int i = 0; i < modele.size() ; i++) {%>
                                            <option value="<%=modele.get(i).getModele()%>"><%=modele.get(i).getModele()%></option>
                                            <%}%>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Quantite</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="descriptionPiece">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Prix Total</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="prixAchat">
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
    <!-- end formulaire insertion -->

    <!-- table liste -->
  <div class="table-responsive">
    <table class="table">
      <tr class="tete"> 
        <th>Description Piece</th>
        <th>Quantite Disponible</th>
        <th>Modele</th>
        <th>Prix</th>
      </tr>
        <% for (int i = 0; i < stock.size(); i++) {%>
      <tr class="anatiny">

        <td><%=stock.get(i).getDescriptionpiece()%></td>
        <td><%=stock.get(i).getPiecesAchetes()-stock.get(i).getNombreVendue()%></td>
        <td><%=stock.get(i).getModele()%></td>
        <td><%=stock.get(i).getMontant()%> ariary </td>
      </tr>
        <%}%>
    </table>
  </div>
  <!-- end table liste -->

  
    <!-- Jquery JS-->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="assets/vendor/select2/select2.min.js"></script>
    <script src="assets/vendor/datepicker/moment.min.js"></script>
    <script src="assets/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="assets/js/global.js"></script>
    <script>
        function fill()
        {

        }
    </script>
</body>
</html>