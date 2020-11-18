/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.entidade.Cliente;
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
 * @author Azazel
 */
public class ClienteDeleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Cliente cliente = new Cliente();
            cliente.setCpf(request.getParameter("cpf"));
            ClientesDAO clienteDao = new ClientesDAO();
            clienteDao.deleteClient(cliente.getCpf());
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/protegido/ClienteServlet");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDeleta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDeleta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
