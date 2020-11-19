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

            <h1 class="text-center m-2 mb-3">Cadastrar Plano</h1>

            <div class="col-12">

                <form action="<c:url value="..//PlanoServlet"/>" method="POST" id="form_cadastroPlano">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" >
                            <span class="msg-erro msg-CampoNome"></span>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Valor</label>
                            <input type="number" class="form-control" id="valor" name="valor" >
                            <span class="msg-erro msg-CampoValor"></span>
                        </div> 
                    </div>

                    <div class="form-group text-center">
                        <label for="exampleFormControlTextarea1">Descrição do Plano</label>
                        <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
                        <span class="msg-erro msg-CampoDescricao"></span>
                    </div>


                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                    <button type="reset" class="btn btn-danger">Cancelar</button>
                </form>

                <br><br>

                <form class="form" action="<c:url value="..//PlanoBusca"/>" method="GET" id="formBusca">

                    <div class="form-grup form-inline">
                        <label class="form-control-sm">Tipo de Busca</label>
                        <select class="form-control form-control-sm" id="tipoBusca" name="tipoBusca">
                            <option value="nome">Nome</option>
                        </select>
                        <label class="form-control-sm">Buscar</label>
                        <input class="form-control  form-control-sm m-1" type="search" id="valorBusca" name="valorBusca" placeholder="Buscar Filiais...">

                        <button type="submit" class="btn btn-primary">Buscar</button>
                        <button type="reset" class="btn btn-danger m-1" onclick="resetTabela()">Reset</button>
                    </div>
                    <div class="form-grup form-inline m-2">
                        <span class="msg-erro msg-CampoBusca"></span>
                    </div>

                </form>

                <br>

                <div class="col-13 table-responsive">
                    <h2 class="text-center m-2 mb-3">Lista Planos</h2>
                    <table class="table table-sm table-striped table-dark table-hover table-responsive text-center table-bordered" id='tabelaRolagem'>
                        <thead class="col-md-auto">
                        <th scope="col" >Nome</th>
                        <th scope="col" >Descrição</th>
                        <th scope="col" >Valor</th>

                        </thead>
                        <tbody>

                            <c:forEach var="plano" items="${listarPlanos}">
                                <tr class="col-md-auto">
                                    <td>${plano.nome}</td>
                                    <td>${plano.descricao}</td>
                                    <td>${plano.valor}</td>


<!-- <td><a href="AtualizarCliente?id=${plano.nome}"><img src="img/pencil.svg"></a></td> -->

                                    <td>
                                        <img src="img/pencil.svg" onclick="mostrarModalAtualiza(
                                                        '${plano.nome}',
                                                        '${plano.descricao}',
                                                        '${plano.valor}',
                                                        )" class="imgBotao">
                                    </td>    

                                    <td>
                                        <img src="img/trashcan.svg" onclick="mostrarModalExclusao(
                                                        '${plano.nome}',)" class="imgBotao">
                                    </td>


                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- Exclusao Plano-->
                <div class="modal fade" id="modalExclusao" name="modalExclusao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Confirmar exclusão</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Confirmar exclusão do Plano: <b><label id="nomePlano" name="nomePlano"></label></b> ?

                                <input id="nomePlano" name="nomePlano" hidden="true"/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="excluirPlano()">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!--atualiza Plano-->
                <div class="modal fade" id="modalAtualiza" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Alteração de dados do Plano</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Deseja alterar os dados do Plano: <b><label id="nomePlanoLabel"></label></b> ?

                                <form class="form-sm">


                                    <labe>Nome</labe>
                                    <input id="nomePlanoAtualiza"name="nome" class="form-control" readonly="true"/>
                                    <span class="msg-erro msg-CampoNome"></span>

                                    <labe>Valor</labe>
                                    <input id="valorPlanoAtualiza" name="valor" class="form-control"/>
                                    <span class="msg-erro msg-CampoValor"></span>

                                    <labe>Descrição</labe>
                                    <input id="descricaoPlanoAtualiza" name="descricao" class="form-control" />
                                    <span class="msg-erro msg-CampoDescricao"></span>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="atualizarPlano()">Alterar</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script src="js/Plano.js" type="text/javascript"></script>
        <script src="js/PlanoValidacaoCadastro.js" type="text/javascript"></script>
    </body>
</html>
