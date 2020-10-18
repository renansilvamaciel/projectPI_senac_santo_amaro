/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;



import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
public class ProdutoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> ListaProdutos = ProdutoDAO.getProdutos();
        request.setAttribute("listaProdutos", ListaProdutos);
        
        RequestDispatcher requesDispatcher = getServletContext().getRequestDispatcher("/produto.jsp");
        requesDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String familia = request.getParameter("familia");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");
                
        Produto produto = new Produto(nome, familia,quantidade,preco,descricao,filial);
        
        try {
            ProdutoDAO.addProdutos(produto);
            response.sendRedirect("Success.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Erro.jsp");
        }
        
        
        
        
        
     
    }


}
