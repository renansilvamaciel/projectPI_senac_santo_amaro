<%-- 
    Document   : menuLateral
    Created on : 03/10/2020, 19:40:59
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        <!--Inicio -- Corpo central-->
        <div class="row mt-2 border border-dark" style=" height: 100%">


            <!--Inicio -- Menu/navBar-->
            <div class="col-3 bg-dark  border border-primary text-white ">

                <div class="sidebar-sticky">
                    <ul class="nav flex-column">


                        <c:if test="${sessionScope.usuario.cargo =='Vendedor'}">
                            <li class="nav-item">
                                <div class="btn-group dropright" >
                                    <a class="nav-link text-white" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                             fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                             stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9"
                                             cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle>
                                        <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                        Venda<span class="sr-only">(atual)</span>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="<c:url value="/Venda"/>">Venda Simples</a>
                                            <a class="dropdown-item" href="<c:url value="/protegido/VendaPlanos.jsp"/>">Venda De Planos</a>
                                        </div>
                                    </a>
                                </div>
                            </li>
                        </c:if>


                        <c:if test="${sessionScope.usuario.cargo =='Vendedor'}">
                            <li class="nav-item">
                                <div class="btn-group dropright" >
                                    <a class="nav-link text-white" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                             fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                             stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2">
                                        </path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87">
                                        </path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                                        Cliente<span class="sr-only">(atual)</span>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="<c:url value="/protegido/Cliente.jsp"/>">Cadastrar Cliente</a>
                                            <a class="dropdown-item" href="<c:url value="/ClienteServlet"/>">Listar Clientes</a>
                                        </div>
                                    </a>
                                </div>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.usuario.cargo =='Backoffice'}"> 
                            <li class="nav-item">
                                <div class="btn-group dropright" >
                                    <a class="nav-link text-white" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                             fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                             stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2">
                                        </path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87">
                                        </path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                                        Funcionario<span class="sr-only">(atual)</span>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="<c:url value="/protegido/Funcionario.jsp"/>">Cadastrar Funcionario</a>
                                            <a class="dropdown-item" href="<c:url value="/FuncionarioServlet"/>">Listar Funcionarios</a>
                                        </div>
                                    </a>
                                </div>
                            </li>
                        </c:if>   

                        <c:if test="${sessionScope.usuario.cargo =='Backoffice'}">
                            <li class="nav-item">
                                <a class="nav-link text-white" href="<c:url value="..//Produto"/>">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                         stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 
                                         2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline>
                                    <line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                                    Produto<span class="sr-only">(atual)</span>
                                </a>
                            </li>
                        </c:if>


                        <c:if test="${sessionScope.usuario.cargo =='Gerente'}">
                            <li class="nav-item">
                                <a class="nav-link text-white"  href="<c:url value="/protegido/relatorio.jsp"/>"> 
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                         stroke-linejoin="round" class="feather feather-bar-chart-2"><line x1="18" y1="20" x2="18" y2="10">

                                    </line><line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line></svg>
                                    Relatório<span class="sr-only">(atual)</span>
                                </a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.usuario.cargo =='Backoffice'}">
                            <li class="nav-item">
                                <a class="nav-link text-white" href="<c:url value="..//PlanoServlet"/>">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                         stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2">
                                    </polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                    Planos / Assinatura<span class="sr-only">(atual)</span>
                                </a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.usuario.cargo =='Backoffice'}">
                            <li class="nav-item">
                                <a class="nav-link text-white" href="<c:url value="..//FilialServlet"/>">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                         stroke-linejoin="round" class="feather feather-home">
                                    <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                                    Filial<span class="sr-only">(atual)</span>
                                </a>
                            </li>
                        </c:if>

                        <a href="<c:url value="/LogoutServlet"/>">Sair</a>

                    </ul>
                </div> 
            </div>
    </body>
</html>
