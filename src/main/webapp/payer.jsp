<%--=============================COMMENTS THAT MAY BE USEFULL=================================

servlet miantso : null (lien avy ao @ liste ana factures )
servlet antsoiny : /PayerFacture
role : formulaire de payement de facture

=============================END COMMENT=================================--%>
<% String title="Payement de facture ";%>
<%@include file="inc/head.jsp"%>
<%@include file="inc/head_add.jsp"%>
<%
//    details de la facture
String idFacture="";
if(request.getParameter("idFacture")!=null)
    idFacture= request.getParameter("idFacture");

String idClient="";
    if(request.getParameter("idClient")!=null)
        idClient=request.getParameter("idClient");

String reste="";
    if(request.getParameter("reste")!=null)
        reste=request.getParameter("reste");

String date="";
    if(request.getParameter("date")!=null)
        date=request.getParameter("date");

    String messageErreur="";
    if(request.getAttribute("MessageErreur")!=null)
        messageErreur=request.getAttribute("MessageErreur").toString();

    String messageSucces="";
    if(request.getAttribute("messageSucces")!=null)
        messageSucces=request.getAttribute("messageSucces").toString();


%>

<%@include file="inc/header.jsp"%>


<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
    <div class="wrapper wrapper--w790">

<%--============= ERREURS =============--%>
        <% if(!messageErreur.equals("")){%>
        <div class="alert alert-danger" role="alert">
            <%=messageErreur%>
        </div>
    <%} else if (!messageSucces.equals("")) {%>
    <div class="alert alert-success" role="alert">
        <%=messageSucces%>
    </div>
    <%
    }
    %>
<%--    ===========================   --%>
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">Facture numero:<%=idFacture%></h2>
            </div>
            <div class="card-body">
                <div class="form-row">
                    <div class="name">client numero: </div>
                    <div class="value"><%=idClient%></div>
                </div>
                <div class="form-row">
                    <div class="name">Montant a payer: </div>
                    <div class="value"><%=reste%></div>
                </div>
                <div class="form-row">
                    <div class="name">Date de la facture:</div>
                    <div class="value"> <%=date%> </div>
                </div>
            </div>
        </div>
<%--        ---------------------------------------%>
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">Payer votre facture : </h2>
            </div>
            <div class="card-body">
                <form method="POST" action="${pageContext.request.contextPath}/PayerFacture">

                    <div class="form-row">
                        <div class="name">montant</div>
                        <div class="value">
                            <div class="input-group">
                                <input class="input--style-5"  value="1" type="number" name="montant">
                            </div>
                        </div>
                    </div>

                    <%--============== HIDDEN INPUTS =================--%>
                    <input type="hidden" name="idFacture" value="<%=idFacture%>">

                    <div>
                        <button class="btn btn--radius-2 btn--blue" type="submit">Valider</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>