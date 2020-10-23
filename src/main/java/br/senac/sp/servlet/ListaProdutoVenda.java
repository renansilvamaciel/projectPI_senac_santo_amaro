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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renan Silva Maciel
 */
public class ListaProdutoVenda extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> ListaProdutos = ProdutoDAO.getProdutos();
        request.setAttribute("listaProdutos", ListaProdutos);
        
        RequestDispatcher requesDispatcher = getServletContext().getRequestDispatcher("/VendaSimples.jsp");
        requesDispatcher.forward(request, response);
    }

}