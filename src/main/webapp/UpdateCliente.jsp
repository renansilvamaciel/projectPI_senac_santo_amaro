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
                            <a class="nav-link active text-white" href="venda.jsp">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9"
                                     cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle>
                                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                Venda
                            </a>
                        </li>
                        <li class="nav-item">
                            <div class="btn-group dropright" >
                                <a class="nav-link text-white" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                         stroke-linejoin="round" class="feather feather-file">
                                    <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                    <b><i>Cliente</b></i><span class="sr-only">(atual)</span>
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
            <!--FIM -- Menu/navBar-->




            <div class="col 5">
                <h1 class="text-center"><b>Cadastrar Cliente</b></h1><br>
                <br>
                <c:forEach var="cliente" items="${listarCliente}">
                    <form action="AtualizaClienteServlet" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Nome</label>
                                <input type="text" value="${cliente.nome}" class="form-control" name="nome" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Sexo</label>
                                <input type="text" value="${cliente.sexo}" class="form-control" name="sexo" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Data De Nascimento</label>
                                <input type="text" value="${cliente.data_nascimento}" class="form-control" name="data_nascimento" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label>CPF</label>
                                <input type="hidden" value="${cliente.cpf}" name="cpf">
                                <input type="text" value="${cliente.cpf}" class="form-control" name="cpf" disabled="" required>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Rua</label>
                                <input type="text" value="${cliente.rua}" class="form-control" name="rua" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label>CEP</label>
                                <input type="text" value="${cliente.cep}" class="form-control" name="cep" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Numero Casa</label>
                                <input type="number" value="${cliente.numero_casa}" class="form-control" name="numero_casa" required>
                            </div>
                            <div class="form-group col-md-6">
                                <labe>Bairro</label>
                                    <input type="text" value="${cliente.bairro}" class="form-control" name="bairro" required>
                                    </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label>Email</label>
                                            <input type="email" value="${cliente.email}" class="form-control" name="email" required>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label>Telefone</label>
                                            <input type="text" value="${cliente.telefone}" class="form-control" name="telefone" required>
                                        </div>
                                    </div>
                                </c:forEach>

                                <div>
                                    <select class="form-control form-control-sm" name="assinatura" required>
                                        <option value="" name="assinatura">Planos</option>
                                        <option value="ouro" name="assinatura">Ouro</option>
                                        <option value="prata" name="assinatura">Prata</option>
                                        <option value="bronze" name="assinatura">Bronze</option>
                                    </select>
                                </div>

                                <div style="margin: 5%;">
                                    <button type="submit" class="btn btn-primary" style="width: 100%;">Cadastrar</button>
                                </div>

                                </form>
                        </div>



                        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
                        <%@include file="rodape.jsp" %>

                        </body>

                        </html>