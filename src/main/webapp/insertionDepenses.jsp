<%--=============================COMMENTS THAT MAY BE USEFULL=================================

 servlet antsoiny : /ListeService
 servlet miantso : /PrepaInsertionFacture
role : formulaire de creation d'une nouvelle facture
        rediririge vers liste service qui est un autre formulaire
        pour selectionner les services que le client veut effectuer
=============================END COMMENT=================================--%>
<%@ page import="java.util.Vector" %>
<%@ page import="model.userBasic.Client" %>
<%@ page import="model.depenses.TypeDepense" %>
<% String title="insertion de produits";%>
<%@include file="inc/head.jsp"%>
<body>
<!-- ======= Header ======= -->
<%@include file="inc/header.jsp"%>
<!-- End Header -->

<%--===========DATAS=========== --%>
<%
  Vector<TypeDepense> depenses= new Vector<>();
  if(request.getAttribute("typedepenses")!=null)
    depenses=(Vector<TypeDepense>) request.getAttribute("typedepenses");
%>


<!-- Formulaire insertion -->
<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
  <div class="wrapper wrapper--w790">
    <div class="card card-5">
      <div class="card-heading">
        <h2 class="title">Insertion depenses </h2>
      </div>
      <div class="card-body">
        <form method="POST" action="${pageContext.request.contextPath}/GestionDepenses">


          <div class="form-row">
            <div class="name">Depenses </div>
            <div class="value">
              <div class="input-group">
                <div class="rs-select2 js-select-simple select--no-search">
                  <select name="type">
                    <%
                      for (int i = 0; i < depenses.size(); i++) {
                    %>
                    <option value="<%=depenses.get(i).getId()%>"><%=depenses.get(i).getType()%></option>
                    <%}%>
                  </select>
                  <div class="select-dropdown"></div>
                </div>
              </div>
            </div>
          </div>

          <div class="form-row">
            <div class="name">prix</div>
            <div class="value">
              <div class="input-group">
                <input class="input--style-5" type="number" name="prix">
              </div>
            </div>
          </div>

          <div>
            <button class="btn btn--radius-2 btn--blue" type="submit">Valider</button>
          </div>
        </form>

        <a href="${pageContext.request.contextPath}/PrepaListeBudjet">detail budjet </a>
      </div>
    </div>
  </div>
</div>
<!-- end formulaire insertion -->

<!-- end table liste -->


<%@include file="inc/script.jsp"%>

</body>
</html>