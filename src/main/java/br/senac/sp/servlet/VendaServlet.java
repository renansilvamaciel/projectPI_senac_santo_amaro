
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.VendaSimplesDAO;
import br.senac.sp.entidade.Funcionario;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
        
        List<Produto> ListaProdutos = VendaSimplesDAO.getPodutoFilial(usuario.getFilial());
        request.setAttribute("listaProdutos", ListaProdutos);
        
        RequestDispatcher requesDispatcher = getServletContext().getRequestDispatcher("/protegido/VendaSimples.jsp");
        requesDispatcher.forward(request, response);
    }

}
