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

            <h1 class="text-center m-2 mb-3">Cadastrar Filial</h1>

            <div class="col-12">

                <form action="<c:url value="..//FilialServlet"/>" method="POST" id="form_cadastroFilial">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" >
                            <span class="msg-erro msg-CampoNome"></span>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Cnpj</label>
                            <input type="text" class="form-control" id="cnpj" name="cnpj" >
                            <span class="msg-erro msg-CampoCnpj"></span>
                        </div> 
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Estado</label>
                            <input type="text" class="form-control" id="estado" name="estado" >
                            <span class="msg-erro msg-CampoEstado"></span>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Rua</label>
                            <input type="text" class="form-control" id="rua" name="rua" >
                            <span class="msg-erro msg-CampoRua"></span>
                        </div> 
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>Cep</label>
                            <input type="text" class="form-control" id="cep" name="cep" >
                            <span class="msg-erro msg-CampoCep"></span>
                        </div>
                        <div class="form-group col-md-2">
                            <label>Numero</label>
                            <input type="number" class="form-control" id="numero" name="numero" >
                            <span class="msg-erro msg-CampoNumero"></span>
                        </div> 
                        <div class="form-group col-md-6">
                            <label>Bairro</label>
                            <input type="text" class="form-control" id="bairro" name="bairro" >
                            <span class="msg-erro msg-CampoBairro"></span>
                        </div> 
                    </div>

                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                    <button type="reset" class="btn btn-danger">Cancelar</button>
                </form>

                <br><br>

                <form class="form" action="<c:url value="..//FilialBuscar"/>" method="GET" id="formBusca">

                    <div class="form-grup form-inline">
                        <label class="form-control-sm">Tipo de Busca</label>
                        <select class="form-control form-control-sm" id="tipoBusca" name="tipoBusca">
                            <option value="cnpj">Cnpj</option>
                            <option value="id">Id</option>
                            <option value="estado">Estado</option>
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
                    <h2 class="text-center m-2 mb-3">Lista Filiais</h2>
                    <table class="table table-sm table-striped table-dark table-hover table-responsive text-center table-bordered" id='tabelaRolagem'>
                        <thead class="col-md-auto">
                        <th scope="col" >Id</th>
                        <th scope="col" >Nome</th>
                        <th scope="col" >Cnpj</th>
                        <th scope="col" >Estado</th>
                        <th scope="col" >Rua</th>
                        <th scope="col" >Cep</th>
                        <th scope="col" >Numero</th>
                        <th scope="col" >Bairro</th>
                        </thead>
                        <tbody>

                            <c:forEach var="filial" items="${listarFiliais}">
                                <tr class="col-md-auto">
                                    <td>${filial.id_filial}</td>
                                    <td>${filial.nome}</td>
                                    <td>${filial.cnpj}</td>
                                    <td>${filial.estado}</td>
                                    <td>${filial.rua}</td>
                                    <td>${filial.cep}</td>
                                    <td>${filial.numero}</td>
                                    <td>${filial.bairro}</td>

<!-- <td><a href="AtualizarCliente?id=${filial.cnpj}"><img src="img/pencil.svg"></a></td> -->

                                    <td>
                                        <img src="img/pencil.svg" onclick="mostrarModalAtualiza(
                                                        '${filial.id_filial}',
                                                        '${filial.nome}',
                                                        '${filial.cnpj}',
                                                        '${filial.estado}',
                                                        '${filial.rua}',
                                                        '${filial.cep}',
                                                        '${filial.numero}',
                                                        '${filial.bairro}',
                                                        )" class="imgBotao">
                                    </td>    

                                    <td>
                                        <img src="img/trashcan.svg" onclick="mostrarModalExclusao(
                                                        '${filial.cnpj}',
                                                        '${filial.nome}')" class="imgBotao">
                                    </td>


                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- Exclusao Cliente-->
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
                                Confirmar exclusão da Filial: <b><label id="nomeFilial" name="nomeFilial"></label></b> ?

                                <input id="cnpjFilial" name="cnpjFilial" hidden="true"/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="excluirFilial()">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!--atualiza Cliente-->
                <div class="modal fade" id="modalAtualiza" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Alteração de dados da Filial</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Deseja alterar os dados da Filial: <b><label id="nomeFilialLabel"></label></b> ?

                                <form class="form-sm">


                                    <labe >Id</labe>
                                    <input id="idFilialAtualiza" name="idFilialAtualiza" class="form-control" readonly="true"/>

                                    <labe>Nome</labe>
                                    <input id="nomeFilialAtualiza"name="nome" class="form-control" />
                                    <span class="msg-erro msg-CampoNome"></span>

                                    <labe>Cnpj</labe>
                                    <input id="cnpjFilialAtualiza" name="cnpj" class="form-control" readonly="true"/>
                                    <span class="msg-erro msg-CampoCnpj"></span>

                                    <labe>Estado</labe>
                                    <input id="estadoFilialAtualiza" name="estado" class="form-control" />
                                    <span class="msg-erro msg-CampoEstado"></span>

                                    <labe>Rua</labe>
                                    <input id="ruaFilialAtualiza" name="rua" class="form-control" />
                                    <span class="msg-erro msg-CampoRua"></span>

                                    <labe>Cep</labe>
                                    <input id="cepFilialAtualiza" name="cep" class="form-control" />
                                    <span class="msg-erro msg-CampoCep"></span>

                                    <labe>N° Casa</labe>
                                    <input type="number" id="numeroFilialAtualiza" name="numero_casa" class="form-control" />
                                    <span class="msg-erro msg-CampoNumeroCasa"></span>

                                    <labe>Bairro</labe>
                                    <input id="bairroFilialAtualiza" name="bairro" class="form-control" />
                                    <span class="msg-erro msg-CampoBairro"></span>

                                    
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="atualizarFilial()">Alterar</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script src="js/Filial.js" type="text/javascript"></script>
        <script src="js/FilialValidacaoCadastro.js" type="text/javascript"></script>
    </body>
</html>
