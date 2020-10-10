<%-- 
    Document   : corpoPrincipal
    Created on : 03/10/2020, 19:44:17
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
        
         <div class="col 5"> 

                <h1 class="text-right" >Cliente</h1><br>

                <form class="form-inline center">
                    <input class="form-control " type="search" placeholder="Pesquisar" aria-label="Pesquisar">
                    <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
                </form>
                <h4 class="text-center">Produtos</h4>
                <table class="table">
                    <tr class="table-item">
                        <th >Nome</th>
                        <th >Preço</th>
                    </tr>
                    <tr class="table-item">
                        <td>Cell</td>
                        <td>Cell</td>
                        <td>+</td>
                        <td>-</td>


                    </tr>
                    <tr class="table-item">
                        <td>Cell</td>
                        <td>Cell</td>
                        <td>+</td>
                        <td>-</td>

                    </tr>

                </table>


                <h4 class="text-center">Carrinho</h4>
                <table class="table">
                    <tr class="table-item" >
                        <th >Nome</th>
                        <th >Preço</th>
                    </tr>
                    <tr class="table-item">
                        <td>Cell</td>
                        <td>Cell</td>
                        <td>+</td>
                        <td>-</td>
                    </tr>
                    <tr class="table-item">
                        <td>Cell</td>
                        <td>Cell</td>
                        <td>+</td>
                        <td>-</td>

                    </tr>

                </table>


            </div><!-- fim tabelas e pesquisa -->


            <div class="col 4"> 
                <br><br><br>

                <form class="form-inline center">
                    <input class="form-control " type="search" placeholder="Pesquisar cliente" aria-label="Pesquisar">
                    <button class="btn btn-outline-success pt-2 " type="submit">Pesquisar</button>
                </form>

                <div>
                    <label>Planos</label>
                    <select class="form-control form-control-sm">
                        <option>Select pequeno</option>
                        <option>Ouro</option>
                        <option>Prata</option>
                        <option>Bronze</option>
                    </select>
                </div>

                <div class="form-check">
                    <input class="form-check-input position-static" type="checkbox" id="blankCheckbox" value="opcao1" aria-label="...">
                    <label>Recorrência</label>
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
                <Lable>Crédito diário</Lable>
                <input type="text" name="creditoDiario"><br>
                <Lable>Valor final</Lable>
                <input type="text" name="valorCaixa"><br><br>


                <input class="btn btn-danger m-2" type="reset" value="Cancelar">
                <input class="btn btn-primary" type="submit" value="Finalizar">


            </div>

            
            

    </body>
</html>
