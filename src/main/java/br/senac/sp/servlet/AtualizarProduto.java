
package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class AtualizarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_produto = Integer.parseInt(request.getParameter("id"));
        
        
        Produto produto = ProdutoDAO.getProduto(id_produto);
        
        request.setAttribute("produto", produto);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/atualizarProduto.jsp");
        rd.forward(request, response);
               
        
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_produto = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String familia = request.getParameter("familia");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");
                
        Produto produto = ProdutoDAO.getProduto(id_produto);
        produto.setNome(nome);
        produto.setFamilia(familia);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);
        produto.setDescricao(descricao);
        produto.setFilial(filial);
        
        try {
            ProdutoDAO.atualizaProduto(produto);
            response.sendRedirect("Success.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AtualizarProduto.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Erro.jsp");
        }
        
        
       
    }


}
