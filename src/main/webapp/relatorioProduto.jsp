<%-- 
    Document   : relatorioProduto
    Created on : 26/10/2020, 16:41:49
    Author     : diego
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

            <h1><center>Relatório</center></h1>

            <br>

            <form class="form-inline center" action="RelatorioVenda" method="GET">
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
                
                
                <!--
                <div class="col-4">
                    <input id="date" type="date">
                    <input id="date" type="date">
                </div>
                -->
                <button class="btn btn-outline-success pt-2" type="submit">Pesquisar</button>
            </form>
            <br>

            <table class="table table-sm table-striped table-bordered" id='tabelaRolagem'>
                <thead class="">
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Preço</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Filial</th>
                </thead>
                <tbody> 
                    <c:forEach var="relatorio" items="${listarProduto}">
                        <tr class="col-md-auto">
                            <<td>${produto.id_produto}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.preco}</td>
                            <td>${produto.quantidade}</td>
                            <td>${produto.id_filial}</td>
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
