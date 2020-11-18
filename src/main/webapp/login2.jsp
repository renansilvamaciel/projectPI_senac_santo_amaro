<%-- 
    Document   : login2
    Created on : 16/11/2020, 23:35:42
    Author     : Juliano
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body class="container">
        <%@include file="protegido/header.jsp" %>
        <h1>Login</h1>
    <c:if test="${param.erro != null}">
        <div class="alert alert-danger" role="alert">
            Usuário/senha inválidos
        </div>
    </c:if>


    <form action="LoginServlet" method="POST">
        <div class="form-group">
            <label>Login</label>
            <input name="login" class="form-control" required/>
        </div>

        <div class="form-group">
            <label>Senha</label>
            <input type="password" name="senha" class="form-control" required/>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>

</body>
</html>
