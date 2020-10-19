
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
public class DeleteProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_produto = Integer.parseInt(request.getParameter("id"));
        try {
            ProdutoDAO.deleteProduto(id_produto);
            response.getWriter().print(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DeleteProduto.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        }
        
    }

    

}
