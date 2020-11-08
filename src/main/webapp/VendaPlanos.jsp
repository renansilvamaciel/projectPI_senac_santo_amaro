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

            <h1 class="text-center m-2 mb-3">Venda de Planos</h1>

            <div class="col-12">
                <form class="form" action="VendaPlanoBusca" method="GET" id="formBusca">

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

                <form action="VendaPlanoBusca" method="POST" id="formaVendaPlanos">
                    <div>

                        <select class="form-control form-control-sm" id="assinatura" name="assinatura" onchange="valorTotalPlano()">
                            <option value="">Planos</option>
                            <option value="ouro">Ouro</option>
                            <option value="prata">Prata</option>
                            <option value="bronze">Bronze</option>
                        </select>

                        <select class="form-control form-control-sm" id="tipo_assinatura" name="tipo_assinatura" onchange="valorTotalPlano()">
                            <option value="">Tipo de Assinatura</option>
                            <option value="mensal">Mensal</option>
                            <option value="semestral">Semestral</option>
                            <option value="anual">Anual</option>
                        </select>

                    </div>

                    <br>

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

                    <div class="input-group-prepend">
                        <span class="input-group-text campoValorTotalPlano">R$: </span>
                        <input type="number" disabled="" value="00.00" id="valorPlanoEscolhido" name="valorPlanoEscolhido">
                    </div>

                    <input type="text" value="" class="form-control" id="valorFinalPlano" name="valorFinalPlano" hidden="">

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

                    <div class="form-grup form-inline">
                        <input class="btn btn-primary" type="submit" value="Finalizar">
                        <input class="btn btn-danger m-2" type="reset" onclick="voltarIndex()" value="Cancelar">
                    </div>
                </form>

            </div>
        </div>


        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>
        <script src="js/VendaPlanos.js" type="text/javascript"></script>
    </body>
</html>
