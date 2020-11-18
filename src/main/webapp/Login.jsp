<%-- 
    Document   : Login
    Created on : 13/11/2020, 02:10:27
    Author     : Azazel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="Login/Style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <%@include file="protegido/header.jsp" %>
        <h1>Login</h1>
    <c:if test="${param.erro != null}">
        <div class="alert alert-danger" role="alert">
            Usuário/senha inválidos
        </div>
    </c:if>

    <style type="text/css">
        .msg-erro{color:red;}
    </style>

    <form class="box" action="LoginServlet" method="POST" id="formLoginFuncionario">
        <h1 class="nomeLoja">CoffeShop</h1>
        <img src="Login/logo.svg" alt="avatar" class="avatar">
        <input type="text" name="login" id="login" placeholder="Entre com seu Cpf">
        <span class="msg-erro msg-CampoCpf"></span>
        <input type="password" name="senha" id="senha" placeholder="Password">
        <span class="msg-erro msg-CampoSenha"></span>
        <button type="submit">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Login Here
        </button>
    </form>
    <script src="js/FuncionarioLogin.js" type="text/javascript"></script>
</body>

</html>
