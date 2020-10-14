<%-- 
    Document   : index
    Created on : 03/10/2020, 19:08:59
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <!--include do cabeçalho-->
    <%@include file="header.jsp" %>

    <body class="container">

        <!--include do menu lateral-->
        <%@include file="menuLateral.jsp" %>


        <div class="col 5"  style="height: 100%"> 

            <h1 class="text-right">Relatório</h1>
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

            <form class="form-inline center">
                <input id="date" type="date">
                <input id="date" type="date">
                <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
            </form>
            <br>

            <table class="table">
                <tr class="table-item">
                    <th >Nº Da venda</th>
                    <th >Funcionario</th>
                    <th >produto</th>
                    <th >Quantidade</th>
                    <th >Preço</th>
                    <th >Data</th>
                    <th >Filial</th>
                </tr>
                <tbody> 
                <c:forEach var="relatorio" items="${listaVenda}">
                    <tr>
                        <td>${relatorio.id_venda}</td>
                        <td>${relatorio.id_vendedor}</td>
                        <td>${relatorio.modelo}</td>
                        <td>${relatorio.quantidade}</td>
                        <td>${relatorio.valor}</td>
                        <td>${relatorio.data}</td>
                        <td>${relatorio.filial}</td>
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
