<%-- 
    Document   : atualizarProduto
    Created on : 18/10/2020, 14:16:16
    Author     : Nailson Nascimento <nailsonbr@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--include do cabeçalho-->
    <%@include file="header.jsp" %>
    
    <body>
        <h1>AtualizarProduto ${produto.nome}</h1>
         <form class="form" action="AtualizarProduto" method="POST">


                <div class="form-row m-2">
                    <label class="col-sm-1 col-form-label">Id</label>
                    <div class="col-4">
                        <input class="form-control" type="text" value="${produto.id_produto}" readonly="true" name="id" placeholder="Código Produto...">
                    </div>
                    <label class="col-sm-1 col-form-label">Nome</label>
                    <div class="col-5">
                        <input class="form-control" type="text" value="${produto.nome}" name="nome" placeholder="Nome do Produto...">
                    </div>
                </div>

                <div class="form-row m-2">
                    <label class="col-sm-1 col-form-label">Família</label>
                    <div class="col-4">
                        <input class="form-control" type="text" value="${produto.familia}" name="familia" placeholder="Família do Produto...">
                    </div>
                    <label class="col-sm-1 col-form-label">Filial</label>
                    <div class="col-5">
                        <input class="form-control" type="text" value="${produto.filial}" name="filial" placeholder="Filial de Venda...">
                    </div>
                </div>
                <div class="form-row m-2">
                    <label class="col-sm-1 col-form-label">Preço</label>
                    <div class="col-4">
                        <input class="form-control" type="text" value="${produto.preco}" name="preco" placeholder="Preço de Venda R$...">
                    </div>
                    <label class="col-sm-1 col-form-label">Qtd.</label>
                    <div class="col-5">
                        <input class="form-control" type="text" value="${produto.quantidade}" name="quantidade" placeholder="Quantidade...">
                    </div>

                </div>
                <div    class="form-row m-2 mb-5">
                    <label class="col-sm-2 col-form-label">Descrição</label>
                    <div class="col-9">
                        <textarea class="form-control ml-1"  name="descricao" placeholder="Breve descrição...">${produto.descricao}</textarea>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
                <button type="reset" class="btn btn-danger">Cancelar</button>
            </form><br>
        
    </body>
</html>
