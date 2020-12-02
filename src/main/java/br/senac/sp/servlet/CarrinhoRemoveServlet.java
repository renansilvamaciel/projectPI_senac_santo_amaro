/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.Produto;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CarrinhoRemoveServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        boolean remove= Boolean.parseBoolean(request.getParameter("remove"));

        //Produto produto = ProdutoDAO.getProduto(id);

        List<Produto> listaProduto = null;
        

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("listaProduto") == null) {
            System.out.println("Remove");
            
        }else{
            
            listaProduto = (List<Produto>) sessao.getAttribute("listaProduto");
            
            
            //limpa carrinho
            for(int cont =0; cont < listaProduto.size() ; cont++){
                listaProduto.clear();
            }
        }
        
    }
}
