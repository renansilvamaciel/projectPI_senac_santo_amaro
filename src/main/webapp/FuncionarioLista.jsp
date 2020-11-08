<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <!--include do cabeçalho-->
    <%@include file="header.jsp" %>

    <body class="container">

        <!--include do menu lateral-->

        <style type="text/css">
            .msg-erro{color:red;}

        </style>

        <div div class="col-13"  style="height: 100%">

            <h1 class="text-center m-2 mb-3">Funcionario</h1>


            <form class="form" action="FuncionarioBusca" method="GET" id="formBusca">

                <div class="form-grup form-inline">
                    <label class="form-control-sm">Tipo de Busca</label>
                    <select class="form-control form-control-sm" id="tipoBusca" name="tipoBusca">
                        <option value="cpf">Cpf</option>
                        <option value="id">Id</option>
                        <option value="nome">Nome</option>
                    </select>
                    <label class="form-control-sm">Buscar</label>
                    <input class="form-control  form-control-sm m-1" type="search" id="valorBusca" name="valorBusca" placeholder="Buscar Funcionarios...">

                    <button type="submit" class="btn btn-primary">Buscar</button>
                    <button type="reset" class="btn btn-danger m-1" onclick="resetTabela()">Reset</button>
                    <button type="success" class="btn btn-success" onclick="voltarIndex()">Voltar Index</button>
                </div>
                <div class="form-grup form-inline m-2">
                    <span class="msg-erro msg-CampoBusca"></span>
                </div>

            </form>

            <br>


            <div class="col-13 table-responsive">

                <table class="table table-sm table-striped table-dark table-hover table-responsive text-center table-bordered" id='tabelaRolagem'>
                    <thead class="col-md-auto">
                    <th scope="col" >Id</th>
                    <th scope="col" >Nome</th>
                    <th scope="col" >Sexo</th>
                    <th scope="col" >Data Nascimento</th>
                    <th scope="col" >Cpf</th>
                    <th scope="col" >Rua</th>
                    <th scope="col" >Cep</th>
                    <th scope="col">N°Casa</th>
                    <th scope="col">Bairro</th>
                    <th scope="col">Email</th>
                    <th scope="col">Telefone</th>
                    <th scope="col" >Cargo</th>
                    <th scope="col" >Filial</th>
                    </thead>
                    <tbody>

                        <c:forEach var="funcionario" items="${listarFuncionarios}">
                            <tr class="col-md-auto">
                                <td>${funcionario.id_funcionario}</td>
                                <td>${funcionario.nome}</td>
                                <td>${funcionario.sexo}</td>
                                <td>${funcionario.data_nascimento}</td>
                                <td>${funcionario.cpf}</td>
                                <td>${funcionario.rua}</td>
                                <td>${funcionario.cep}</td>
                                <td>${funcionario.numero_casa}</td>
                                <td>${funcionario.bairro}</td>
                                <td>${funcionario.email}</td>
                                <td>${funcionario.telefone}</td>
                                <td>${funcionario.cargo}</td>
                                <td>${funcionario.filial}</td>

                         <!-- <td><a href="AtualizarFuncionario?id=${funcionario.cpf}"><img src="img/pencil.svg"></a></td> -->

                                <td>
                                    <img src="img/pencil.svg" onclick="mostrarModalAtualiza(
                                                    '${funcionario.id_funcionario}',
                                                    '${funcionario.nome}',
                                                    '${funcionario.sexo}',
                                                    '${funcionario.data_nascimento}',
                                                    '${funcionario.cpf}',
                                                    '${funcionario.rua}',
                                                    '${funcionario.cep}',
                                                    '${funcionario.numero_casa}',
                                                    '${funcionario.bairro}',
                                                    '${funcionario.email}',
                                                    '${funcionario.telefone}',
                                                    '${funcionario.cargo}',
                                                    '${funcionario.filial}',
                                                    '${funcionario.senha}',
                                                    )" class="imgBotao">
                                </td>    

                                <td>
                                    <img src="img/trashcan.svg" onclick="mostrarModalExclusao(
                                                    '${funcionario.cpf}',
                                                    '${funcionario.nome}')" class="imgBotao">
                                </td>                            
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>




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
                                Confirmar exclusão do Funcionario: <b><label id="nomeFuncionario" name="nomeFuncionario"></label></b> ?

                                <input id="cpfFuncionario" name="cpfFuncionario" hidden="true"/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="excluirFuncionario()">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!--atualiza Cliente-->
                <div class="modal fade" id="modalAtualiza" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Alteração de dados do Funcionario</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Deseja alterar os dados do Funcionario: <b><label id="nomeFuncionarioLabel"></label></b> ?

                                <form class="form-sm">

                                    <labe >Id</labe>
                                    <input id="idFuncionarioAtualiza" class="form-control" readonly="true"/>

                                    <labe>Nome</labe>
                                    <input id="nomeFuncionarioAtualiza" class="form-control" />

                                    <labe>Sexo</labe>
                                    <input id="sexoFuncionarioAtualiza" class="form-control"/>

                                    <labe>Data Nascimento</labe>
                                    <input type="date" id="dataNascimentoFuncionarioAtualiza"class="form-control" />

                                    <labe>Cpf</labe>
                                    <input id="cpfFuncionarioAtualiza"class="form-control" readonly="true"/>

                                    <labe>Rua</labe>
                                    <input id="ruaFuncionarioAtualiza"class="form-control" />

                                    <labe>Cep</labe>
                                    <input id="cepFuncionarioAtualiza"class="form-control" />

                                    <labe>N° Casa</labe>
                                    <input type="number" id="numeroCasaFuncionarioAtualiza"class="form-control" />

                                    <labe>Bairro</labe>
                                    <input id="bairroFuncionarioAtualiza"class="form-control" />

                                    <labe>Email</labe>
                                    <input type="email" id="emailFuncionarioAtualiza"class="form-control" />

                                    <labe>Telefone</labe>
                                    <input id="telefoneFuncionarioAtualiza"class="form-control" />

                                    <label>Cargo</label>
                                    <select class="form-control form-control" id="cargoFuncionarioAtualiza" name="cargo">
                                        <option value=""></option>
                                        <option value="cargo-1">Cargo-1</option>
                                        <option value="cargo-2">Cargo-2</option>
                                        <option value="cargo-3">Cargo-3</option>
                                    </select>

                                    <labe>Filial</labe>
                                    <input id="filialFuncionarioAtualiza"class="form-control" />

                                    <labe>Senha</labe>
                                    <input type="password" id="senhaFuncionarioAtualiza"class="form-control" />

                                    <labe>Confirmar Senha</labe>
                                    <input type="password" id="senhaConfirmarFuncionarioAtualiza"class="form-control" />
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="atualizarFuncionario()">Alterar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script src="js/Funcionario.js" type="text/javascript"></script>
        <script src="js/FuncionarioValidacaoBusca.js" type="text/javascript"></script>
    </body>

</html>

