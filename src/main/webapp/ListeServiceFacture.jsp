<%--=============================COMMENTS THAT MAY BE USEFULL=================================

servlet miantso : /ListeService
servlet antsoiny : insertionDetailFacture ou detailListeFacture
role : formulairre d'insertion des services que le client veut effectuer

=============================END COMMENT=================================--%>
<%@ page import="model.pieces.Marque" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.pieces.Unite" %>
<%@ page import="model.pieces.Modele" %>
<%@ page import="model.service.TypeService" %>
<% String title="insertion de produits";%>
<%@include file="inc/head.jsp"%>
<body>
<!-- ======= Header ======= -->
<%@include file="inc/header.jsp"%>
<!-- End Header -->

<%--===========DATAS=========== --%>
<%
    Vector<TypeService> services= new Vector<>();
    if(request.getAttribute("listeservice")!=null)
        services=(Vector<TypeService>) request.getAttribute("listeservice");

    int idfacture=0;
    if(request.getAttribute("idFacture")!=null)
           idfacture= Integer.parseInt(request.getAttribute("idFacture").toString());

%>


<!-- Formulaire insertion -->
<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
    <div class="wrapper wrapper--w790">
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">selectionner un service</h2>
            </div>
            <div class="card-body">
                <%
                    out.print("id Facture "+idfacture);
                    for (int i = 0; i < services.size(); i++) {
                %>
                <form method="POST" action="${pageContext.request.contextPath}/InsertionDetailFacture">
                    <div class="form-row">
                        <div class="value">
                            <div class="form-check">
                                <input class="form-check-input" name="service" type="checkbox" value="<%=services.get(i).getId()%>" id="flexCheckDefault<%=i%>">
                                <label class="form-check-label" for="flexCheckDefault<%=i%>">
                                    <%=services.get(i).getService()%>
                                </label>
                            </div>

                            <div class="form-row">
                                <div class="name">nombre</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="number" name="nombre" value>
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="name">remise</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="number" name="remise" value>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div>
                        <input type="hidden" name="idFacture" value="<%=idfacture%>">
                        <button class="btn btn--radius-2 btn--blue" type="submit">Valider</button>
                    </div>
                </form>
                <%}%>
                <a href="${pageContext.request.contextPath}/DetailListeFacture">voir les factures</a>
            </div>
        </div>

    </div>
</div>
<!-- end formulaire insertion -->

<!-- end table liste -->


<%@include file="inc/script.jsp"%>

</body>
</html>