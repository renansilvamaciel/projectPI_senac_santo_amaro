<%-- 
    Document   : index
    Created on : 03/10/2020, 19:08:59
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <!--include do cabeçalho-->
    <%@include file="header.jsp" %>

    <body class="container">

        <br>
        <form class="form-inline" action="ListarClienteServlet" method="GET">
            <input class="form-control " type="search" name="cpf" placeholder="Pesquisar Cliente" aria-label="Pesquisar" required="true">
            <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
            <button class="btn btn-outline-success pt-2 "><a href="index.jsp" type="button">Voltar</a></button> 
        </form>
        <br>
        <h1><center>Lista de Clientes</center></h1>

        <table class="table table-hover">
            <thead class="col-md-auto">
            <th>ID</th>
            <th>Nome</th>
            <th>Sexo</th>
            <th>Data de Nascimento</th>
            <th>CPF</th>
            <th>Rua</th>
            <th>CEP</th>
            <th>Numero Casa</th>
            <th>Bairro</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Assinatura</th>
            <th>Tipo</th>
        </thead>
        <tbody> 
            <c:forEach var="cliente" items="${listarClientes}">
                <tr class="col-md-auto">
                    <td>${cliente.id_cliente}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.sexo}</td>
                    <td>${cliente.data_nascimento}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.rua}</td>
                    <td>${cliente.cep}</td>
                    <td>${cliente.numero_casa}</td>
                    <td>${cliente.bairro}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.assinatura}</td>
                    <td>${cliente.tipo_assinatura}</td>
                </tr>
            </c:forEach>

        </tbody>

    </table>


    <br/>

    <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
    <%@include file="rodape.jsp" %>

</body>

</html>
