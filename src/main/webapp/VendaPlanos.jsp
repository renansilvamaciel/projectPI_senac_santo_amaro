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

        <div class="row mt-2 border border-dark" style=" height: 100%">


            <!--Inicio -- Menu/navBar-->
            <div class="col-3 bg-dark  border border-primary text-white ">

                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <div class="btn-group dropright" >
                                <a class="nav-link text-white" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                         stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9"
                                         cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle>
                                    <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                    <b><i>Venda</b></i><span class="sr-only">(atual)</span>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="VendaSimples.jsp">Venda Simples</a>
                                        <a class="dropdown-item" href="VendaPlanos.jsp">Venda De Planos</a>
                                        <a class="dropdown-item" href=VendaAssinantes.jsp#">Venda Para Assinantes</a>
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="btn-group dropright" >
                                <a class="nav-link text-white" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                         stroke-linejoin="round" class="feather feather-file">
                                    <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                    Cliente<span class="sr-only">(atual)</span>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="InsertCliente.jsp">Cadastrar Cliente</a>
                                        <a class="dropdown-item" href="ListarClientesServlet">Listar Clientes</a>
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9"
                                     cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle>
                                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                Funcionário
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2">
                                </path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87">
                                </path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                                Produto
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-bar-chart-2"><line x1="18" y1="20" x2="18" y2="10">

                                </line><line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line></svg>
                                Relatório
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2">
                                </polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                Planos / Assinatura
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-home">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                                Filial
                            </a>
                        </li>

                    </ul>



                </div> 


            </div>







            <div class="col-9" style="height: 100%"> 

                <br>
                <h1 class="text-center"><b>Venda de Planos</b></h1><br>

                <div class="col-7"> 

                    <form class="form-inline center" action="VendaPlanoPesquisarClienteServlet" method="GET">
                        <input class="form-control" name="cpf" type="search" placeholder="Pesquisar cliente" aria-label="Pesquisar">
                        <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
                    </form>

                    <br>


                    <h4 class="text-center">Assinaturas</h4>


                    <form action="VendaPlanoErroCpf" method="POST">
                        <div>

                            <select class="form-control form-control-sm" name="assinatura">
                                <option value="">Planos</option>
                                <option value="ouro">Ouro</option>
                                <option value="prata">Prata</option>
                                <option value="bronze">Bronze</option>
                            </select>

                            <select class="form-control form-control-sm" name="tipo_assinatura">
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
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Nome</label>
                                <input hidden="" type="text" name="nome" value="">
                                <input type="text" disabled="" value="" class="form-control" name="nome" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label>CPF</label>
                                <input hidden="" type="text" name="cpfClient" value="">
                                <input type="text" disabled="" value="" class="form-control" name="cpfClient" required>
                            </div>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Finalizar">
                        <input class="btn btn-danger m-2" type="reset" value="Cancelar">
                    </form>


                </div>

            </div>
            <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
            <%@include file="rodape.jsp" %>

    </body>

</html>
