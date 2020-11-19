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

            <h1 class="text-center m-2 mb-3">Cliente</h1>


            <form class="form" action="<c:url value="../projectPI_senac_santo_amaro/ClienteBusca"/>" method="GET" id="formBusca">

                <div class="form-grup form-inline">
                    <label class="form-control-sm">Tipo de Busca</label>
                    <select class="form-control form-control-sm" id="tipoBusca" name="tipoBusca">
                        <option value="cpf">Cpf</option>
                        <option value="id">Id</option>
                        <option value="nome">Nome</option>
                    </select>
                    <label class="form-control-sm">Buscar</label>
                    <input class="form-control  form-control-sm m-1" type="search" id="valorBusca" name="valorBusca" placeholder="Buscar Clientes...">

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
                    <th scope="col" >Assinatura</th>
                    <th scope="col" >Tipo Assinatura</th>
                    </thead>
                    <tbody>

                        <c:forEach var="cliente" items="${listarClientes}">
                            <tr class="col-md-auto">
                                <td>${cliente.id_cliente}</td>
                                <td>${cliente.nome}</td>
                                <td>${cliente.sexo}</td>
                                <td>${cliente.data_nascimento}</td>
                                <td>${cliente.cpf}</td>
                                <td>${cliente.rua}</td>
                                <td>${cliente.cep}</td>
                                <td>${cliente.numero_casa}</td>
                                <td>${cliente.bairro}</td>
                                <td>${cliente.email}</td>
                                <td>${cliente.telefone}</td>
                                <td>${cliente.assinatura}</td>
                                <td>${cliente.tipo_assinatura}</td>

                         <!-- <td><a href="AtualizarCliente?id=${cliente.cpf}"><img src="img/pencil.svg"></a></td> -->

                                <td>
                                    <img src="img/pencil.svg" onclick="mostrarModalAtualiza(
                                                    '${cliente.id_cliente}',
                                                    '${cliente.nome}',
                                                    '${cliente.sexo}',
                                                    '${cliente.data_nascimento}',
                                                    '${cliente.cpf}',
                                                    '${cliente.rua}',
                                                    '${cliente.cep}',
                                                    '${cliente.numero_casa}',
                                                    '${cliente.bairro}',
                                                    '${cliente.email}',
                                                    '${cliente.telefone}',
                                                    )" class="imgBotao">
                                </td>    

                                <td>
                                    <img src="img/trashcan.svg" onclick="mostrarModalExclusao(
                                                    '${cliente.cpf}',
                                                    '${cliente.nome}')" class="imgBotao">
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
                                Confirmar exclusão do Cliente: <b><label id="nomeCliente" name="nomeCliente"></label></b> ?

                                <input id="cpfCliente" name="cpfCliente" hidden="true"/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!--atualiza Cliente-->
                <div class="modal fade" id="modalAtualiza" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Alteração de dados do Cliente</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Deseja alterar os dados do Cliente: <b><label id="nomeClienteLabel"></label></b> ?

                                <form class="form-sm">


                                    <labe >Id</labe>
                                    <input id="idClienteAtualiza" name="idClienteAtualiza" class="form-control" readonly="true"/>

                                    <labe>Nome</labe>
                                    <input id="nomeClienteAtualiza"name="nome" class="form-control" />
                                    <span class="msg-erro msg-CampoNome"></span>

                                    <labe>Sexo</labe>
                                    <input id="sexoClienteAtualiza" name="sexo" class="form-control"/>
                                    <span class="msg-erro msg-CampoSexo"></span>

                                    <labe>Data Nascimento</labe>
                                    <input type="date" id="dataNascimentoClienteAtualiza" name="data_nascimento" class="form-control" />
                                    <span class="msg-erro msg-CampoDataNascimento"></span>

                                    <labe>Cpf</labe>
                                    <input id="cpfClienteAtualiza" name="cpf" class="form-control" readonly="true"/>
                                    <span class="msg-erro msg-CampoCpf"></span>

                                    <labe>Rua</labe>
                                    <input id="ruaClienteAtualiza" name="rua" class="form-control" />
                                    <span class="msg-erro msg-CampoRua"></span>

                                    <labe>Cep</labe>
                                    <input id="cepClienteAtualiza" name="cep" class="form-control" />
                                    <span class="msg-erro msg-CampoCep"></span>

                                    <labe>N° Casa</labe>
                                    <input type="number" id="numeroCasaClienteAtualiza" name="numero_casa" class="form-control" />
                                    <span class="msg-erro msg-CampoNumeroCasa"></span>

                                    <labe>Bairro</labe>
                                    <input id="bairroClienteAtualiza" name="bairro" class="form-control" />
                                    <span class="msg-erro msg-CampoBairro"></span>

                                    <labe>Email</labe>
                                    <input type="email" id="emailClienteAtualiza" name="email" class="form-control" />
                                    <span class="msg-erro msg-CampoEmail"></span>

                                    <labe>Telefone</labe>
                                    <input id="telefoneClienteAtualiza" name="telefone" class="form-control" />
                                    <span class="msg-erro msg-CampoTelefone"></span>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary" onclick="atualizarCliente()">Alterar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script src="js/Cliente.js" type="text/javascript"></script>
        <script src="js/ClienteValidacaoBusca.js" type="text/javascript"></script>

    </body>

</html>

