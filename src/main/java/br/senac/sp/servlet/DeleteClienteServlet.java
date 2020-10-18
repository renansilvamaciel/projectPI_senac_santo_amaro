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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azazel
 */
public class DeleteClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("cpf"));
        
        String cpf = request.getParameter("cpf");
        
        
        try {
            ClientesDAO clienteDao = new ClientesDAO();
            clienteDao.deleteClient(cliente.getCpf());
            response.sendRedirect("Success.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsereClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsereClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

}
