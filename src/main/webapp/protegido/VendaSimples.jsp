<%-- 
    Document   : index
    Created on : 03/10/2020, 19:08:59
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <!--include do cabeçalho--> 
    <%@include file="header.jsp" %>

    <body class="container">

        <!--include do menu lateral-->
        <%@include file="menuLateral.jsp" %>

        <style>
            .quantidadeCarrinho{
                width: 40px;
                margin-left: 40px;
            }

            .imgBotao{
                width: 20px;
            }

        </style>


        <script lang="text/javascript">

            function adicionarProduto(id_produto) {


                $.get("CarrinhoServlet?id=" + id_produto + "&operacao=" + true, function () {
                    console.log("ok");

                    window.location.reload();


                });

            }


            function removerProduto(id_produto) {

                $.get("CarrinhoServlet?id=" + id_produto + "&operacao=" + false, function () {
                    console.log("ok");
                    window.location.reload();
                });

            }

            //obtem a quantidade de produtos na venda
            function contaItensVenda() {
                let vetorItens = document.querySelectorAll(".itens");
                let soma = 0;

                for (let posicao = 0; posicao < vetorItens.length; posicao++) {
                    soma = soma + parseInt(vetorItens[posicao].innerHTML);
                }
                //console.log(soma);
                return soma;
            }

            function limpaCarrinho() {

                $.get("CarrinhoRemoveServlet?remove=" + false, function () {
                    console.log("ok");

                    window.location.reload();
                    
                    
                    

                });
                
            }

            //funcao finaliza venda
            function finalizaVenda() {


                let vetorItens = document.querySelectorAll(".itens");
                if (vetorItens.length === 0) {

                    //valida filial validações (Seleção)
                    var caixa_filial = document.querySelector('.msg-descricao');
                    alert("O carrinho está Vazio!!");

                    //caixa_filial.innerHTML = 'Carrinho vazio';
                    caixa_filial.style.display = 'block';


                } else {


                    let idFuncionario = ${sessionScope.usuario.id_funcionario};
                    let quantidade = contaItensVenda();
                    let valorFinalLimpo = moedaParaFloat(document.querySelector("#total").innerHTML);
                    let id_filial = ${sessionScope.usuario.filial}
                    console.log(id_filial);

                    $.post('Venda', {id_funcionario: idFuncionario, quantidade: quantidade,
                        valorFinalLimpo: valorFinalLimpo, id_filial: id_filial
                    }, function () {
                        
                        msgVendaRealizada();
                        limpaCarrinho();
                        

                    });

                }
            }


            function msgVendaRealizada() {
                //exibe a mensagem de venda realizada com sucesso
                var caixa_filial = document.querySelector('.msg-descricao');

                //caixa_filial.innerHTML = 'Venda Realizada !';
                caixa_filial.style.display = 'block';
                
              alert("Venda realizada com sucesso! ");
            }








        </script>



        <div class="col-9" style="height: 100%"> 

            <h1 class="text-center"><b>Venda Simples</b></h1><br>

          <!--
            <form class="form-inline center" action="<c:url value="..//BuscaProdutoVenda"/>" method="GET">

                <input class="form-control " type="search" placeholder="Pesquisar Produto" name="nome_produto" aria-label="Pesquisar">
                <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
            </form> -->

            <br>

            <h4 class="text-center">Produtos</h4>



            <table class="table">
                <tr class="table-item">
                    <th >Id</th>
                    <th >Nome</th>
                    <th >Qtd. Estoque</th>
                    <th >Preço</th>
                    <th >Descrição</th>

                </tr>
                <tbody>

                    <c:forEach var="produto" items="${listaProdutos}">
                        <tr>
                            <td>${produto.id_produto}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.quantidade}</td>
                            <td>${produto.preco}</td>
                            <td>${produto.descricao}</td>



                            <td><img src="./img/plus-solid.svg" onclick="adicionarProduto(
                                     ${produto.id_produto},
                                            '${produto.nome}',
                                     ${produto.preco},
                                            '${produto.descricao}',
                                     ${produto.quantidade},
                                     ${produto.filial}
                                    )" class="imgBotao">
                            </td> 



                        </tr>

                    </c:forEach>
                </tbody>

            </table>

            <hr class="border-dark">

            <h4 class="text-center">Carrinho</h4>

            <table class="table table-striped " id='tabelaRolagem'>
                <tr class="table-item" >
                    <th scope="col" >Id</th>
                    <th scope="col" >Nome</th>
                    <th scope="col" >Preço</th>
                    <th scope="col" >Descricao</th> 
                    <th scope="col" >Qtd.</th>
                    <th scope="col" >Total item</th>
                    <th scope="col" ></th>

                </tr>
                <tbody>

                    <c:forEach var="produto" items="${listaProduto}">
                        <tr>
                            <td>${produto.id_produto}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.preco}</td>
                            <td>${produto.descricao}</td>
                            <td class="itens">${produto.quantidade}</td>
                            <c:set var = "balance" value = "${produto.preco * produto.quantidade}"/>

                            <td class="totalItem"><fmt:formatNumber value = "${balance}" type = "currency"/></td>

                            <td><img src="./img/minus-solid.svg" onclick="removerProduto(
                                     ${produto.id_produto},
                                            '${produto.nome}',
                                     ${produto.preco},
                                            '${produto.descricao}',
                                     ${produto.quantidade},
                                     ${produto.filial}
                                    )" class="imgBotao">
                            </td> 


                            <%
                                System.out.println("Tudo foi executado!");

                            %>


                        </tr>



                    </c:forEach>
                </tbody>

            </table>


            <hr class="border-dark">
            <div class="col-7">
                <div class="input-group" >
                    <div class="input-group-prepend">
                        <span class="" >Tipo De pagamento</span>
                    </div>
                    <input style="width: 20px; height: 20px; margin-top: 7px;" type="radio" id="cartao" name="pagamento" value="cartao" class="form-control">
                    <label for="cartao">Cartão</label><br>
                    <input style="width: 20px; height: 20px; margin-top: 7px;" type="radio" id="dinheiro" name="pagamento" value="dinheiro" class="form-control">
                    <label for="dinheiro">Dinheiro</label><br>

                </div>


                <br>
                <h4> <lable>Valor final:</lable>
                    <span id="total"></span></h4></br>

                <h1><span class="msg-erro msg-descricao"></span></h1>
                <input class="btn btn-primary" type="submit" onclick="finalizaVenda()" value="Finalizar">
                <button type="reset" class="btn btn-danger m-1" onclick="limpaCarrinho()">Limpar Carrinho</button>

            </div>






        </div><!-- fim tabelas e pesquisa -->

        <br>
    </div>

    <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
    <%@include file="rodape.jsp" %>
    <script type="text/javascript" src="js/carrinho.js"></script>

</body>

</html>
