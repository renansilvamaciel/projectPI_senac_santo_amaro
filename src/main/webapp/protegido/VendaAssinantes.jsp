<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <!--include do cabeçalho-->
    <%@include file="header.jsp" %>

    <body class="container">

        <!--include do menu lateral-->
        <%@include file="menuLateral.jsp" %>

        <style type="text/css">
            .msg-erro{color:red;}
        </style>


        <div class="col" style="height: 100%">

            <h1 class="text-center m-2 mb-3">Venda Assinantes</h1>

            <div class="col-12">
                <form class="form" action="<c:url value="..//VendaAssinantes"/>" method="GET" id="formBusca">

                    <div class="form-grup form-inline">
                        <label class="form-control-sm">Tipo de Busca</label>
                        <select class="form-control form-control-sm" id="tipoBusca" name="tipoBusca">
                            <option value="cpf">Cpf</option>
                        </select>
                        <label class="form-control-sm">Buscar</label>
                        <input class="form-control  form-control-sm m-1" type="search" id="valorBusca" name="valorBusca" placeholder="Buscar Clientes...">

                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </div>
                    <div class="form-grup form-inline m-2">
                        <span class="msg-erro msg-CampoBusca"></span>
                    </div>

                </form>

                <form action="VendaAssinantes" method="POST" id="formaVendaPlanos">


                    <div class="col-13 table-responsive">
                        <h3 class="text-center m-2 mb-3">Produtos</h3>
                        <table class="table table-sm table-striped table-dark table-hover table-responsive text-center table-bordered" id='tabelaRolagem'>
                            <thead class="col-md-auto">
                            <th scope="col" >Id</th>
                            <th scope="col" >Nome</th>
                            <th scope="col" >Quantidade</th>
                            <th scope="col" >Preço</th>
                            <th scope="col" >Descrição</th>
                            </thead>
                            <tbody>

                                <c:forEach var="produto" items="${listaProdutos}">
                                    <tr class="col-md-auto">
                                        <td>${produto.id_produto}</td>
                                        <td>${produto.nome}</td>
                                        <td>${produto.quantidade}</td>
                                        <td>${produto.preco}</td>
                                        <td>${produto.descricao}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <br>

                    <div class="col-13 table-responsive">
                        <h3 class="text-center m-2 mb-3">Carrinho</h3>
                        <table class="table table-sm table-striped table-dark table-hover table-responsive text-center table-bordered" id='tabelaRolagem'>
                            <thead class="col-md-auto">
                            <th scope="col" >Nome</th>
                            <th scope="col" >Quantidade</th>
                            <th scope="col" >Preço</th>
                            <th scope="col" >Descrição</th>
                            </thead>
                            <tbody>
                                <tr class="col-md-auto">
                                    <td name="produtoNome" id="produtoNome"></td>
                                    <td name="produtoQuantidade" id="produtoQuantidade"></td>
                                    <td name="produtoPreco" id="produtoPreco"></td>
                                    <td name="produtoDescricao" id="produtoDescricao"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <br><br>

                    <div class="input-group" >
                        <div class="input-group-prepend">
                            <span class="input-group-text" >Tipo De pagamento</span>
                        </div>
                        <input style="width: 20px; height: 20px; margin-top: 7px;" type="radio" id="cartao" name="pagamento" value="cartao" class="form-control">
                        <label for="cartao">Cartão</label><br>
                        <input style="width: 20px; height: 20px; margin-top: 7px;" type="radio" id="dinheiro" name="pagamento" value="dinheiro" class="form-control">
                        <label for="dinheiro">Dinheiro</label><br>
                    </div>

                    <br>

                    <c:forEach var="cliente" items="${listarClientes}">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Nome</label>
                                <input type="text" disabled="" value="${cliente.nome}" class="form-control" id="nome" name="nome">
                            </div>
                            <div class="form-group col-md-6">
                                <label>CPF</label>
                                <input type="text" value="${cliente.cpf}" name="cpfCliente" hidden="">
                                <input type="text" disabled="" value="${cliente.cpf}" class="form-control" id="cpf" name="cpf">
                            </div>
                        </div>
                    </c:forEach>

                    <div class="input-group-prepend">
                        <span class="input-group-text campoValorTotalPlano">Credito Assinante R$: </span>
                        <input type="number" disabled="" value="${creditoAssinante}" id="creditoAssinante" name="creditoAssinante">

                        <span class="input-group-text campoValorTotalPlano">Valor Final R$: </span>
                        <input type="number" disabled="" value="00.00" id="valorVenda" name="valorVenda">
                    </div>

                    <input type="text" value="" class="form-control" id="valorVendaFinal" name="valorVendaFinal" hidden="">

                    <br>
                    
                    <div class="form-grup form-inline">
                        <input class="btn btn-primary" type="submit" value="Finalizar">
                        <input class="btn btn-danger m-2" type="reset" onclick="voltarIndex()" value="Cancelar">
                    </div>
                </form>

            </div>
        </div>


        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script src="../js/VendaAssinantes.js" type="text/javascript"></script>
    </body>
</html>
