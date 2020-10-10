<%-- 
    Document   : index
    Created on : 03/10/2020, 19:08:59
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>

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



                                <b><i>Venda</i></b>   <span class="sr-only">(atual)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                                     stroke-linejoin="round" class="feather feather-file">
                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                Cliente
                            </a>
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







            <div class="col 5" style="height: 100%"> 

                <h1 class="text-right"><b>Venda</b></h1><br>

                <form class="form-inline center">
                    <input class="form-control " type="search" placeholder="Pesquisar Produto" aria-label="Pesquisar">
                    <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
                </form>

                <br>

                <h4 class="text-center">Produtos</h4>
                <table class="table">
                    <tr class="table-item">
                        <th >Id</th>
                        <th >Nome</th>
                        <th >Quantidade</th>
                        <th >Preço</th>
                        <th >Descrição</th>
                    </tr>
                    <tr class="table-item">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>


                    </tr>
                    <tr class="table-item">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>

                    </tr>

                </table>


                <h4 class="text-center">Carrinho</h4>
                <table class="table">
                    <tr class="table-item" >
                        <th >Id</th>
                        <th >Nome</th>
                        <th >Quantidade</th>
                        <th >Preço</th>
                    </tr>
                    <tr class="table-item">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr class="table-item">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>

                    </tr>

                </table>


            </div><!-- fim tabelas e pesquisa -->


            <div class="col 5"> 


                <form class="form-inline center" style="margin-top: 21%;">
                    <input class="form-control " type="search" placeholder="Pesquisar cliente" aria-label="Pesquisar">
                    <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
                </form>

                <br>

                <div style="text-align: center;">
                    <h4>Planos</h4>
                    <select class="form-control form-control-sm">
                        <option>Selecionar Plano</option>
                        <option>Ouro</option>
                        <option>Prata</option>
                        <option>Bronze</option>
                    </select>
                </div>

                <div class="form-check">
                    <input class="form-check-input position-static" disabled="" type="checkbox" id="blankCheckbox" value="opcao1" aria-label="...">
                    <label><b>Recorrência</b></label>
                </div> 

                <div>
                    <select class="form-control form-control-sm">
                        <option>Ouro</option>
                        <option>Prata</option>
                        <option>Bronze</option>
                    </select>

                    <select class="form-control form-control-sm">
                        <option>Mensal</option>
                        <option>Trimestral</option>
                        <option>Semestral</option>
                        <option>Anual</option>
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
                <Lable>Crédito diário: </Lable>
                <input type="text" name="creditoDiario"><br>
                <br>
                <Lable>Valor final:</Lable>
                <input type="text" name="valorCaixa" style="margin-left: 7%"><br><br>


                <input class="btn btn-primary" type="submit" value="Finalizar">
                <input class="btn btn-danger m-2" type="reset" value="Cancelar">


            </div>

        </div>
        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <div class="row bg-dark mt-2 text-white " style=" height: 20%;">


            <ul style="list-style-type: none">
                <li>Coffee Shop © 2020. Todos os direitos reservados.</li>
                <li>Desenvolvido por -= DevsMaster =-</li>

            </ul>

        </div> 

    </body>

</html>
