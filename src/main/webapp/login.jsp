<%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 23/01/2023
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String title="login";%>
<%@include file="inc/head.jsp"%>
<%
    if(request.getAttribute("erreur")!=null)
    {
        out.print(request.getAttribute("erreur"));
    }
    else{
        out.print("tsisy olana");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="py-5"></section>
<section></section>
<section></section>
<section class="py-5">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-8 col-xl-6 text-center mx-auto">
                <p class="fw-bold text-success mb-2"></p>
                <h2 class="fw-bold">Admin login</h2>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-md-6 col-xl-4">
                <div>
                    <form class="p-3 p-xl-4" method="post" action="${pageContext.request.contextPath}/Login">
                        <div class="mb-3">
                            <input class="form-control" value="admin1@gmail.com" type="email" id="email-1" name="email" placeholder="Email" required>
                        </div>
                        <div class="mb-3">
                            <input class="form-control" type="password" value="admin1" name="password" placeholder="mot de passe" required>
                        </div>
                        <div><button class="btn btn-dark shadow d-block w-100" type="submit" style="--bs-primary: #3763f4;--bs-primary-rgb: 55,99,244;--bs-body-bg: #fff;">Send </button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="inc/script.jsp"%>


</body>
</html>
