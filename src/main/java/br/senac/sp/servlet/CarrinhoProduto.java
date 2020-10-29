/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renan Silva Maciel
 */
public class CarrinhoProduto extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //correção de acentuação
        request.setCharacterEncoding("UTF-8");
        
       
        String [] sacola = request.getParameterValues("sacola");
        
        
        
        
        int id_vendedor = Integer.parseInt(request.getParameter("id_vendedor"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        int filial = Integer.parseInt(request.getParameter("filial"));
        String nomeProduto = request.getParameter("nome");
        
        
        
//        Produto produto = new Produto(nome, familia,quantidade,preco,descricao,filial);
//        
//        try {
//            ProdutoDAO.addProdutos(produto);
//            response.sendRedirect("Produto");
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
//            response.sendRedirect("Erro.jsp");
//        }
        
        
    }

}
