<%-- 
    Document   : produto
    Created on : 17/10/2020, 13:36:07
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>
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

        <script lang="text/javascript">


            //função para exibir a modal excluirProduto
            function mostrarModalExclusao(id, nome) {
                //console.log("produto:", id + " - " + nome);
                $("#nomeProduto").html(nome);
                $("#idProduto").val(id);
                $('#modalExclusao').modal('show');
            }

            //função para realizar a chmada ao servlet=>DeleteProduto
            function excluirProduto() {
                var idProduto = $("#idProduto").val();

                console.log("Deletar produto cujo id é: ", idProduto);
                $.get("DeleteProduto?id=" + idProduto, function (resposta) {
                    $('#modalExclusao').modal('hide');
                    if (resposta === 'true') {
                        console.log("funcionou!");
                    } else {
                        console.log("falha!");
                    }

                    window.location.reload();

                });

            }


            //função para exibir a modal
            function mostrarModalAtualiza(id, nome, familia, quantidade, preco, descricao, filial) {
                console.log("produto:", id + " - " + nome + " - " + familia + " - " + quantidade + " - " + preco + " - " + descricao + " - " + filial);

                $("#nomeProdutolabel").html(nome);
                $("#idProdutoAtualiza").val(id);
                $("#nomeProdutoAtualiza").val(nome);
                $("#familiaProdutoAtualiza").val(familia);
                $("#quantidadeProdutoAtualiza").val(quantidade);
                $("#precoProdutoAtualiza").val(preco);
                $("#descricaoProdutoAtualiza").val(descricao);
                $("#filialProdutoAtualiza").val(filial);

                $('#modalAtualiza').modal('show');
            }
            //função para realizar a chmada ao servlet=>DeleteProduto
            function atualizarProduto() {
                var idProduto = $("#idProdutoAtualiza").val();
                console.log("atualizar produto cujo id é: ", idProduto);
                console.log("#idProdutoAtualiza");

                var id = $("#idProdutoAtualiza").val();
                var nome = $("#nomeProdutoAtualiza").val();
                var familia = $("#familiaProdutoAtualiza").val();
                var quantidade = $("#quantidadeProdutoAtualiza").val();
                var preco = $("#precoProdutoAtualiza").val();
                var descricao = $("#descricaoProdutoAtualiza").val();
                var filial = $("#filialProdutoAtualiza").val();






                $.post('AtualizarProduto', {id: id, nome: nome, familia: familia, quantidade: quantidade,
                    preco: preco, descricao: descricao, filial: filial}, function () {

                    $('#modalExclusao').modal('hide');
                    window.location.reload();

                });


            }






        </script>


        <div div class="col 4"  style="height: 100%">

            <h1 class="text-center m-2 mb-3">Produto</h1>



            <div class="form-grup form-inline m-2">
                <label class="form-control-sm" >Buscar</label>
                <input class="form-control  form-control-sm m-4" type="search" name="buscaProduto" placeholder="buscar Produtos...">
                <button type="submit" class="btn btn-primary">Buscar</button>
            </div>


            <form class="form" action="Produto" method="POST" id="form_cadastroProduto" >


                <div class="form-row m-1">
                    <label class="col-sm-1 col-form-label form-control-sm">Id</label>
                    <div class="col-4">
                        <input class="form-control form-control-sm" type="text" name="id"  readonly="true" placeholder="Código Produto...">
                        
                    </div>
                    <label class="col-sm-1 col-form-label form-control-sm">Nome</label>
                    <div class="col-4">
                        
                        <input class="form-control form-control-sm" type="text"  id="nome" name="nome" placeholder="Nome do Produto...">
                        <span class="msg-erro msg-nome"></span>
                    </div>
                </div>

                <div class="form-row m-1">
                    
                    <label class="col-sm-1 col-form-label form-control-sm">Família</label>
                    <div class="col-4">
                        <select class="form-control form-control-sm" id="familia" name="familia">
                                <option value="0">Selecione...</option>
                                <option value="1">Cafés</option>
                                <option value="2">Acessórios</option>
                                <option value="3">Acompanhamentos</option>
                            </select>
                        <span class="msg-erro msg-familia"></span>
                    </div>
                    
                    <label class="col-sm-1 col-form-label form-control-sm">Filial</label>
                    <div class="col-4">
                        <select class="form-control form-control-sm"  id="filial" name="filial">
                                <option value="0">Selecione...</option>
                                <option value="1">Matriz</option>
                                <option value="2">Filial 1</option>
                                <option value="3">Filial 2</option>
                                <option value="4">Filial 3</option>
                            </select>
                        <span class="msg-erro msg-filial"></span>
                    </div>
                </div>
                <div class="form-row m-1">
                    <label class="col-sm-1 col-form-label form-control-sm">Preço</label>
                    <div class="col-4">
                        <input class="form-control form-control-sm" type="text" id="preco" name="preco" placeholder="Preço de Venda R$...">
                        <span class="msg-erro msg-preco"></span>
                    </div>
                    <label class="col-sm-1 col-form-label form-control-sm">Qtd.</label>
                    <div class="col-4">
                        <input class="form-control form-control-sm" type="text"  id="quantidade" name="quantidade" placeholder="Quantidade...">
                        <span class="msg-erro msg-quantidade"></span>
                    </div>

                </div>
                <div    class="form-row m-1 mb-5">
                    <label class="col-sm-2 col-form-label form-control-sm">Descrição</label>
                    <div class="col-8">
                        <textarea class="form-control  form-control-sm ml-1" id="descricao" name="descricao" placeholder="Breve descrição..."></textarea>
                        <span class="msg-erro msg-descricao"></span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
                <button type="reset" class="btn btn-danger">Cancelar</button>
            </form><br>



            <table class="table table-sm table-striped table-bordered " id='tabelaRolagem'>
                <thead class="">
                <th scope="col" >Id</th>
                <th scope="col" >Nome</th>
                <th scope="col" >Família</th>
                <th scope="col" >Quantidade</th>
                <th scope="col" >Preço</th>
                <th scope="col" >Descricao</th>
                <th scope="col">filial</th>
                <th scope="col" ></th>
                <th scope="col" ></th>
                </thead>
                <tbody>

                    <c:forEach var="produto" items="${listaProdutos}">
                        <tr>
                            <td>${produto.id_produto}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.familia}</td>
                            <td>${produto.quantidade}</td>
                            <td>${produto.preco}</td>
                            <td>${produto.descricao}</td>
                            <td>${produto.filial}</td>

                            <!-- <td><a href="AtualizarProduto?id=${produto.id_produto}"><img src="img/pencil.svg"></a></td> -->

                            <td><img src="img/pencil.svg" onclick="mostrarModalAtualiza(
                                     ${produto.id_produto},
                                            '${produto.nome}',
                                            '${produto.familia}',
                                     ${produto.quantidade},
                                     ${produto.preco},
                                            '${produto.descricao}',
                                            '${produto.filial}')" class="imgBotao"></td>    

                            <td><img src="img/trashcan.svg" onclick="mostrarModalExclusao(
                                     ${produto.id_produto},
                                            '${produto.nome}')" class="imgBotao"></td>                            


                        </tr>
                    </c:forEach>
                </tbody>
            </table>




            <!-- Exclusao Produto-->
            <div class="modal fade" id="modalExclusao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Confirmar exclusão</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Confirmar exclusão do Produto: <label id="nomeProduto"></label> ?

                            <input id="idProduto" hidden="true"/>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal atualizaProduto-->
            <div class="modal fade" id="modalAtualiza" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Alteração de Produto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Deseja alterar o produto: <b><label id="nomeProdutolabel"></label></b> ?

                            <form class="form-sm">

                                <labe >id:</labe>
                                <input id="idProdutoAtualiza" class="form-control" readonly="true"/>

                                <labe>Nome:</labe>
                                <input id="nomeProdutoAtualiza" class="form-control" />

                                <labe>Familia:</labe>
                                <input id="familiaProdutoAtualiza" class="form-control"/>

                                <labe>Filial:</labe>
                                <input id="filialProdutoAtualiza"class="form-control" />

                                <labe>Preco:</labe>
                                <input id="precoProdutoAtualiza"class="form-control" />
                                <labe>Qtd.:</labe>
                                <input id="quantidadeProdutoAtualiza" class="form-control"/>
                                <labe>Descrição.:</labe>
                                <textarea id="descricaoProdutoAtualiza" class="form-control" ></textarea>


                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" onclick="atualizarProduto()">Alterar</button>
                        </div>
                    </div>
                </div>
            </div>






        </div>

        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script type="text/javascript" src="js/validacaoProduto.js"></script>
    </body>

</html>

