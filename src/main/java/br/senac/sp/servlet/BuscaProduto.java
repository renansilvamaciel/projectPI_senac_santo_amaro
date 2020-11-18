/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.BuscaProdutoDAO;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
public class BuscaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //cria uma lista de produtos
        List<Produto> ListaProdutos = new ArrayList();

        //passa a variavel recebida pelo get no caso 'buscaProduto'
        //para a classe BuscaProdutoDAO chamando a função getProduto
        String ProdutoBuscado = (request.getParameter("buscaProduto"));
        int tipoBusca = Integer.parseInt(request.getParameter("tipoBusca"));

        if (tipoBusca == 1) {
            //cria um produto com o retorno da função getProduto
            Produto produto = BuscaProdutoDAO.getProduto(ProdutoBuscado);

            //adiciona o retorno a lista criada a cima
            ListaProdutos.add(produto);

            //devolve uma lista de produtos para a pagina produto.jsp
            request.setAttribute("listaProdutos", ListaProdutos);

            //chama a função request e envia para a pagina produto.jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/produto.jsp");
            rd.forward(request, response);

        }else if(tipoBusca == 2){
            
            int idProduto = Integer.parseInt(ProdutoBuscado);
            
            //cria um produto com o retorno da função getProduto
            Produto produto = BuscaProdutoDAO.getPodutoID(idProduto);

            //adiciona o retorno a lista criada a cima
            ListaProdutos.add(produto);

            //devolve uma lista de produtos para a pagina produto.jsp
            request.setAttribute("listaProdutos", ListaProdutos);

            //chama a função request e envia para a pagina produto.jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/produto.jsp");
            rd.forward(request, response);

        }else if(tipoBusca == 3){
            
            int idFamilia = Integer.parseInt(ProdutoBuscado);
            
            //cria um produto com o retorno da função getProduto
            List<Produto> ListaProdutoFamilia = BuscaProdutoDAO.getPodutoFamilia(idFamilia);

            //devolve uma lista de produtos para a pagina produto.jsp
            request.setAttribute("listaProdutos", ListaProdutoFamilia);

            //chama a função request e envia para a pagina produto.jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/produto.jsp");
            rd.forward(request, response);

        }else if(tipoBusca == 4){
            
            int idFilial = Integer.parseInt(ProdutoBuscado);
            
            //cria um produto com o retorno da função getProduto
           List<Produto> ListaProduto = BuscaProdutoDAO.getPodutoFilial(idFilial);

            //devolve uma lista de produtos para a pagina produto.jsp
            request.setAttribute("listaProdutos", ListaProduto);

            //chama a função request e envia para a pagina produto.jsp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/produto.jsp");
            rd.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
