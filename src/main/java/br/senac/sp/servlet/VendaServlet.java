
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.VendaSimplesDAO;
import br.senac.sp.entidade.Funcionario;
import br.senac.sp.entidade.Produto;
import br.senac.sp.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
public class VendaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        Funcionario usuario = (Funcionario) sessao.getAttribute("usuario");
        System.out.println("teste: " + usuario.getNome()+" = " + usuario.getFilial());
        System.out.println("teste: " + usuario.getId_funcionario() +  " = " + usuario.getFilial());
        
        List<Produto> ListaProdutos = VendaSimplesDAO.getPodutoFilial(usuario.getFilial());
        request.setAttribute("listaProdutos", ListaProdutos);
        
        RequestDispatcher requesDispatcher = getServletContext().getRequestDispatcher("/protegido/VendaSimples.jsp");
        requesDispatcher.forward(request, response);
    }
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //correção de acentuação
        request.setCharacterEncoding("UTF-8");
        
        int id_funcionario = Integer.parseInt(request.getParameter("id_funcionario"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double valorFinalLimpo = Double.parseDouble(request.getParameter("valorFinalLimpo"));
        int id_filial = Integer.parseInt(request.getParameter("id_filial"));
       
        
        Venda venda = new Venda(id_funcionario, quantidade, valorFinalLimpo, id_filial);
        
        try {
            VendaSimplesDAO.addVenda(venda);
            response.sendRedirect(request.getContextPath()+"//Produto");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("Erro.jsp");
        }
        
        
        
        
        
     
    }
    

}
