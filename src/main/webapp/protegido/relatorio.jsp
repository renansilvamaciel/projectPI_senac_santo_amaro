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

            <br>

            <form class="form-inline center" action="<c:url value="..//RelatorioVenda"/>" method="GET">
                <label class="col-sm-1 col-form-label form-control-sm">Filial</label>
                <div class="">
                    <select class="form-control form-control-sm" name="filial">
                        <option value="0">Todas</option>
                        <option value="1">Matriz</option>
                        <option value="2">Filial 1</option>
                        <option value="3">Filial 2</option>
                        <option value="4">Filial 3</option>

                    </select>
                </div>


                <label class="col-sm-1 col-form-label form-control-sm">Tipo de Filtro</label>
                <div class="">
                    <select class="form-control form-control-sm" name="filtro">
                        <option value="1">Venda</option>
                        <option value="2">Produtos</option>
                        <option value="3">Vendedor</option>

                    </select>
                </div>


                <div class="col-4"  name = "date1">
                    <input type="date" id="date1" name="date1">
                    <input type="date" id="date2" name="date2">
                 </div>
                
                <button class="btn btn-outline-success pt-2" type="submit">Pesquisar</button>
            </form>
            <br>

            <table class="table table-sm table-striped table-bordered" id='tabelaRolagem'>
                <thead class="">
                <th scope="col">Nº Da venda</th>
                <th scope="col">ID Funcionario</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Preço</th>
                <th scope="col">Data</th>
                <th scope="col">Filial</th>
                </thead>
                <tbody> 
                    <c:forEach var="relatorio" items="${listarVenda}">
                        <tr class="col-md-auto">
                            <td>${relatorio.id_venda}</td>
                            <td>${relatorio.id_vendedor}</td>
                            <td>${relatorio.quantidade}</td>
                            <td>${relatorio.valor_total}</td>
                            <td>${relatorio.data_hoje}</td>
                            <td>${relatorio.nome}</td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>

            <br>

            <form class="form-inline center" style="margin-left: 90%;">
                <button onclick="window.print()" class="btn btn-success">Exportar</button>
            </form>

            <br>

        </div>





        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>

    </body>

</html>
