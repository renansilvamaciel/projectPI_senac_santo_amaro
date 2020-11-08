/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.entidade.Cliente;
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
 * @author Azazel
 */
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClientesDAO clientesDAO = new ClientesDAO();

        List<Cliente> listarClientes;
        try {
            listarClientes = clientesDAO.listClients();
            request.setAttribute("listarClientes", listarClientes);
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/ClienteLista.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Cliente cliente = new Cliente();

            cliente.setNome(request.getParameter("nome"));
            cliente.setSexo(request.getParameter("sexo"));
            cliente.setData_nascimento(request.getParameter("data_nascimento"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setRua(request.getParameter("rua"));
            cliente.setCep(request.getParameter("cep"));
            cliente.setNumero_casa(Integer.parseInt(request.getParameter("numero_casa")));
            cliente.setBairro(request.getParameter("bairro"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setTelefone(request.getParameter("telefone"));

            ClientesDAO clienteDao = new ClientesDAO();
            clienteDao.insertClient(cliente);
            response.sendRedirect("ClienteServlet");
        } catch (ClassNotFoundException | NumberFormatException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
