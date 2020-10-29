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

 
        <script lang="text/javascript">
           
           var valor = 0;
           
            
            function adicionarProduto(id_produto,nome,preco,descricao, quantidade, id_filial ) {
                $("#tabelaRolagem").find('tbody')
                .append($('<tr>')
                    .append($('<td>').text(id_produto))
                    .append($('<td>').text(nome))
                    .append($('<td>').text(preco))
                    .append($('<td>').text(descricao))
                    );
            
             carrinhoCompra(id_produto,nome,preco,descricao, quantidade, id_filial);
             
              valor = valor + preco;
             
             valorTotal(valor);
               
            }
            
            
            
            
            function carrinhoCompra (id_produto,nome,valorFinal,descricao, quantidade, id_filial)
                
                {
                   var sacola = [];

                        sacola.push(id_produto,nome,valorFinal,descricao, quantidade, id_filial);
                        
                        for (var i = 0; i < sacola.length; i++) {
                           
                                    console.log(sacola[i]);
                           
                         }

                             
                             $.post('CarrinhoProduto', {sacola}, function () {

                   }); )

//                          $.post('CarrinhoProduto', {id_vendedor: 1, quantidade: quantidade,
//                        preco: valorFinal, filial: id_filial, nome: nome}, function () {
//
//                    });
                }
                
              function valorTotal (valor) {
                  
                     document.querySelector("[name='valorCaixa']").value = valor.toFixed(2);
                  
              }
              
              
              
              //funcão para resetar a tabela de produto e reexibir todos os produtos cadastrados
            function resetTabela() {
                console.log("teste");
                window.location.href = "ListaProdutoVenda";
            }
            
        </script>
        
         
 
                
        <script type="text/javascript">//
                        function deleteRow(i){
                            
                          document.getElementById('tabelaRolagem').deleteRow(i);
                                
                        }
          </script>

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
                                        <a class="dropdown-item" href="ListaProdutoVenda">Venda Simples</a>
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

                <h1 class="text-center"><b>Venda Simples</b></h1><br>

                
<!--                <form class="form" action="BuscaProduto" method="GET" id="formBusca">
                
                    BuscaProduto

                <div class="form-grup form-inline">
                    <label class="form-control-sm">Tipo Busca</label>
                    <select class="form-control form-control-sm" id="tipoBusca" name="tipoBusca">
                        <option value="1">Nome</option>
                        <option value="2">Id</option>
                        <option value="3">Família</option>
                        <option value="4">Filial</option>
                    </select>
                    <label class="form-control-sm">Buscar</label>
                    <input class="form-control  form-control-sm m-1" type="search" id="buscaProduto" name="buscaProduto" placeholder="buscar Produtos...">
                    
                    <button type="submit" class="btn btn-primary">Buscar</button>
                    <button type="reset" class="btn btn-danger m-1" onclick="resetTabela()">Reset</button>
                </div>
                <div class="form-grup form-inline m-2">
                    <span class="msg-erro msg-CampoBusca"></span>
                </div>
                    
            </form>
                -->
                <form class="form-inline center" action="BuscaProdutoVenda" method="GET">
                    
                    <input class="form-control " type="search" placeholder="Pesquisar Produto" name="nome_produto" aria-label="Pesquisar">
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
                   <tbody>

                    <c:forEach var="produto" items="${listaProdutos}">
                        <tr>
                            <td>${produto.id_produto}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.quantidade}</td>
                            <td>${produto.preco}</td>
                            <td>${produto.descricao}</td>
                        
                            
                            <!--botão exluir item-->
                            <!--<td><img src="img/trashcan.svg" class="imgBotao" onclick="deleteRow(this.parentNode.parentNode.rowIndex)"> </td>-->
                            
                            <!--botão adcionar produto--> 
                            <td><button type="button" class="btn btn-primary" onclick="adicionarProduto(${produto.id_produto}, '${produto.nome}', ${produto.preco}, '${produto.descricao}', ${produto.quantidade}, ${produto.filial} )" >Adicionar</button></td>
                        </tr>
                        
                    </c:forEach>
                </tbody>

                </table>


                <h4 class="text-center">Carrinho</h4>
                
             <table class="table table-striped table-bordered" id='tabelaRolagem'>
                    <tr class="table-item" >
                        <th scope="col" >Id</th>
                        <th scope="col" >Nome</th>
                        <th scope="col" >Preço</th>
                        <th scope="col" >Descricao</th>  
                    </tr>
                    
                </table>
                

                <div class="col-7">
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
                    <Lable>Valor final:</Lable>
                    <input type="text" name="valorCaixa" style="margin-left: 7%" readonly="true"><br><br>


                    <input class="btn btn-primary" type="submit" value="Finalizar">
                    <input class="btn btn-danger m-2" type="reset" value="Cancelar">
                    <button type="reset" class="btn btn-danger m-1" onclick="resetTabela()">Limpar Carrinho</button>

                </div>


            </div><!-- fim tabelas e pesquisa -->

            <br>
        </div>
        <!--  FIM -----  corpo que deve ser alterardo de acordo com a pagina -->
        <%@include file="rodape.jsp" %>

    </body>

</html>
