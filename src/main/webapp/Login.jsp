<%-- 
    Document   : Login
    Created on : 13/11/2020, 02:10:27
    Author     : Azazel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Login/Style.css" rel="stylesheet" type="text/css"/>
        <title>Document</title>
    </head>

    <body>

        <form class="box" action="FuncionarioLogin" method="POST">
            <h1 class="nomeLoja">CoffeShop</h1>
            <img src="Login/logo.svg" alt="avatar" class="avatar">
            <input type="text" name="cpf" id="cpf" placeholder="Cpf">
            <input type="password" name="senha" id="senha" placeholder="Password">
            <button type="submit">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Login Here
            </button>
        </form>

    </body>

</html>
