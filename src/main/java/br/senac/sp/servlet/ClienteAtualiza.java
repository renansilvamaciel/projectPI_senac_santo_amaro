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
import java.util.ArrayList;
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
public class ClienteAtualiza extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ClientesDAO clientesDAO = new ClientesDAO();
            Cliente cliente = new Cliente();
            cliente.setCpf(request.getParameter("cpf"));
            ArrayList<Cliente> listarClientes = clientesDAO.getClient(cliente);
            request.setAttribute("listarClientes", listarClientes);

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/protegido/ClienteServlet");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        

        try {
            ClientesDAO clienteDao = new ClientesDAO();
            clienteDao.updateClient(cliente);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
