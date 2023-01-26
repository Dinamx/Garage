<%@ page import="java.util.Vector" %>
<%@ page import="model.Piece" %>
<%@ page import="model.Modele" %>
<%@ page import="model.AchatPiece" %>
<%@ page import="views.AchatVente" %>
<%@ page import="DAO.PiecesDAO" %>
<% String title="Accueil";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>

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

    <!-- table liste -->
    <div class="tab mycontainer">
        <h2 class="text">Listes stock</h2>
        <div class="table-responsive">
            <table class="table">
                <thead style="position: sticky; top: 0" class="thead-dark" >
                <tr class="tete">

                    <th>Description Piece</th>
                    <th>Quantite Disponible</th>
                    <th>Modele</th>
<%--                    <th>Prix</th>--%>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < stock.size(); i++) {%>
                <tr class="anatiny">

                    <td><%=stock.get(i).getDescriptionpiece()%></td>
                    <td><%=stock.get(i).getPiecesAchetes()-stock.get(i).getNombreVendue()%></td>
                    <td><%=stock.get(i).getModele()%></td>
<%--                    <td><%=stock.get(i).getMontant()%> ariary </td>--%>
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
                    <h2 class="title">Achat de piece</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="${pageContext.request.contextPath}/AchatProduit">
                        <div class="form-row">
                            <div class="name">Piece</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="idpiece" required onchange="fill()" id="piece">
                                            <option disabled="disabled" selected="selected">Selelctionner</option>
                                            <% try{
                                                for (int i = 0; i < pieces.size(); i++) {
                                            %>
                                            <option value="<%=PiecesDAO.getPieceId(pieces.get(i))%>"><%=pieces.get(i).getPiece()%></option>
                                            <%}
                                            }catch(Exception e){e.printStackTrace();}%>
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
                                    <input class="input--style-5" type="number" name="quantite">
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



    <%@include file="inc/script.jsp"%>

</body>
</html>