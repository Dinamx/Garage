<%--=============================COMMENTS THAT MAY BE USEFULL=================================

servlet miantso : PrepaInsertPiece
servlet antsoiny : /InsertionProduit

=============================END COMMENT=================================--%>
<%@ page import="model.pieces.Marque" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.pieces.Unite" %>
<%@ page import="model.pieces.Modele" %>
<% String title="insertion de produits";%>
<%@include file="inc/head.jsp"%>
<body>
    <!-- ======= Header ======= -->
    <%@include file="inc/header.jsp"%>
    <!-- End Header -->

    <%--===========DATAS=========== --%>
    <%
        Vector<Modele> modele=(Vector<Modele>) request.getAttribute("modele");
        Vector<Unite> unites=(Vector<Unite>) request.getAttribute("unite");
    %>


  <!-- Formulaire insertion -->
  <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Insertion de nouvelle piece </h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="${pageContext.request.contextPath}/InsertionProduit">
                        <div class="form-row">
                            <div class="name">Description Piece</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="descriptionPiece">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Prix d'achat</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="prixAchat">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">quantite</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="quantite">
                                </div>
                            </div>
                        </div>



                        <div class="form-row">
                            <div class="name">Modele</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="modele">
                                            <%
                                                for (int i = 0; i < modele.size(); i++) {

                                            %>
                                            <option value="<%=modele.get(i).getId()%>"><%=modele.get(i).getModele()%></option>
                                            <%}%>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="name">Unite</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="unite">
                                            <%
                                                for (int i = 0; i < unites.size(); i++) {

                                            %>
                                            <option value="<%=unites.get(i).getId()%>"><%=unites.get(i).getUnite()%></option>
                                            <%}%>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
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

  <!-- end table liste -->


    <%@include file="inc/script.jsp"%>

</body>
</html>