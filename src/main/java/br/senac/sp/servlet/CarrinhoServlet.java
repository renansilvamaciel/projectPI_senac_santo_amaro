/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;

import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        //String idString = request.getParameter("id");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean operacao = Boolean.parseBoolean(request.getParameter("operacao"));

        Produto produto = ProdutoDAO.getProduto(id);

        List<Produto> listaProduto = null;

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("listaProduto") == null) {
            listaProduto = new ArrayList<>();
            
        } else {
            listaProduto = (List<Produto>) sessao.getAttribute("listaProduto");
        }

        double valorTotalProdutos;

        if (operacao == true) {

            if (!listaProduto.contains(produto)) {
                produto.setQuantidade(1);
                listaProduto.add(produto);

            } else {

                for (Produto produto1 : listaProduto) {
                    if (produto1.equals(produto)) {
                        produto1.addProduto();

                    }
                }
            }

        } else {
            for (Produto produto1 : listaProduto) {
                if (produto1.equals(produto)) {

                    if (produto1.getQuantidade() > 1) {
                        produto1.removeProduto();
                    } else {
                        listaProduto.remove(produto);
                        break;
                    }

                }

            }
        }
        
        
        
             
         sessao.setAttribute("listaProduto", listaProduto);


    }

}
