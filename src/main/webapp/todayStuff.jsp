
<%@ page import="java.util.Vector" %>
<%@ page import="Alea.Produit" %>
<% String title="Accueil";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>

<body>
<!-- ======= Header ======= -->
<%@include file="inc/header.jsp"%>
<!-- End Header -->
<%--========DATAS======--%>
<%
//    Vector<Piece> pieces=(Vector<Piece>) request.getAttribute("pieces");
//        out.println(pieces.size());s
//    Vector<Modele> modele=(Vector<Modele>) request.getAttribute("modele");
//    Vector<AchatVente> stock=(Vector<AchatVente>) request.getAttribute("stock");
    Produit produit= (Produit) request.getAttribute("produit");
    Vector<Produit> listeProduit=(Vector<Produit>) request.getAttribute("listeproduit");
%>

<!-- table liste -->
<div class="tab mycontainer">
    <h2 class="text">prix conseille par produit </h2>
    <div class="table-responsive">
        <table class="table">
            <thead style="position: sticky; top: 0
" class="thead-dark" >
            <tr class="tete">

                <th>Description Piece</th>
                <th>Prix Achat</th>
                <th>Prix de vente conseille </th>
                <th>Benefice</th>
                <th>marge</th>
                <%--                    <th>Prix</th>--%>
            </tr>
            </thead>
            <tbody>
<%--            <% for (int i = 0; i < stock.size(); i++) {%>--%>
            <tr class="anatiny">

                <td><%= produit.getNom()%></td>
                <td><%= produit.getPrixAchat()%></td>
                <td><%=produit.getPrixConseille()%></td>
                <td><%=produit.getBenefice()%></td>
                <td><%=produit.getMarge()%></td>

                <%--                    <td><%=stock.get(i).getMontant()%> ariary </td>--%>
            </tr>
<%--            <%}%>--%>
            </tbody>
        </table>
    </div>

    <h2 class="text">anciens produits </h2>
    <div class="table-responsive">
        <table class="table">
            <thead style="position: sticky; top: 0
" class="thead-dark" >
            <tr class="tete">

                <th>Description Piece</th>
                <th>Prix Achat</th>
                <th>Prix de vente conseille </th>
                <th>Benefice</th>
                <th>marge</th>
                <%--                    <th>Prix</th>--%>
            </tr>
            </thead>
            <tbody>
                        <% for (int i = 0; i < listeProduit.size(); i++) {%>
            <tr class="anatiny">

                <td><%= listeProduit.get(i).getNom()%></td>
                <td><%= listeProduit.get(i).getPrixAchat()%></td>
                <td><%=listeProduit.get(i).getPrixConseille()%></td>
                <td><%=listeProduit.get(i).getBenefice()%></td>
                <td><%=listeProduit.get(i).getMarge()%></td>

                <%--                    <td><%=stock.get(i).getMontant()%> ariary </td>--%>
            </tr>
                        <%}%>
            </tbody>
        </table>
    </div>
</div>
<!-- end table liste -->
<%--
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
&lt;%&ndash;                                        <% try{&ndash;%&gt;
&lt;%&ndash;                                            for (int i = 0; i < pieces.size(); i++) {&ndash;%&gt;
&lt;%&ndash;                                        %>&ndash;%&gt;
&lt;%&ndash;                                        <option value="<%=PiecesDAO.getPieceId(pieces.get(i))%>"><%=pieces.get(i).getPiece()%></option>&ndash;%&gt;
&lt;%&ndash;                                        <%}&ndash;%&gt;
&lt;%&ndash;                                        }catch(Exception e){e.printStackTrace();}%>&ndash;%&gt;
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
&lt;%&ndash;                                        &lt;%&ndash;dash;%&gt;
&lt;%&ndash;                                            for (int i = 0; i < modele.size() ; i++) {%>&ndash;%&gt;
&lt;%&ndash;                                        <option value="<%=modele.get(i).getModele()%>"><%=modele.get(i).getModele()%></option>&ndash;%&gt;
&lt;%&ndash;                                        <%}%>&ndash;%&gt;
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
</div>--%>
<!-- end formulaire insertion -->



<%@include file="inc/script.jsp"%>

</body>
</html>