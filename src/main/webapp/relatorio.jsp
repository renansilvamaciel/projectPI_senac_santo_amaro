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

        <!--include do menu lateral-->
        <%@include file="menuLateral.jsp" %>

        <div class="col 5"  style="height: 100%"> 

            <h1><center>Relatório</center></h1>
            <div>
                <label>Filial</label>
                <select class="form-control form-control-sm">
                    <option>Todas</option>
                    <option>Matriz</option>
                    <option>Filial 1</option>
                    <option>Filial 2</option>
                </select>
            </div>

            <br>

            <form class="form-inline center" action="ListarVenda" method="GET">
                <input id="date" type="date">
                <input id="date" type="date">
                <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
            </form>
            <br>

            <table class="table table-hover">
                <thead class="col-md-auto">
                    <th >Nº Da venda</th>
                    <th >Funcionario</th>
                    <th >produto</th>
                    <th >Quantidade</th>
                    <th >Preço</th>
                    <th >Data</th>
                    <th >Filial</th>
                </thead>
                <tbody> 
                <c:forEach var="relatorio" items="${listarVenda}">
                     <tr class="col-md-auto">
                        <td>${relatorio.id_venda}</td>
                        <td>${relatorio.id_vendedor}</td>
                        <td>${relatorio.nome_produto}</td>
                        <td>${relatorio.quantidade}</td>
                        <td>${relatorio.valor_total}</td>
                        <td>${relatorio.data_hoje}</td>
                        <td>${relatorio.id_filial}</td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>

            <br>

            <form class="form-inline center" style="margin-left: 90%;">
                <button type="button" class="btn btn-success">Exportar</button>
            </form>

            <br>

        </div>





        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>

    </body>

</html>
