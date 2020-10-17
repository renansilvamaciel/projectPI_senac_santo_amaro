/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.util.Utils;
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

/**
 *
 * @author Azazel
 */
public class ListarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("cpf"));

        ClientesDAO clientesDAO = new ClientesDAO();

        try {
           
            List<Cliente> listarCliente = clientesDAO.getClient(cliente.getCpf());
            request.setAttribute("listarCliente", listarCliente);

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/ListCliente.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

}
