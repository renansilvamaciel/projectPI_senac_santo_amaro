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
public class ClienteBusca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();
        ClientesDAO clientesDAO = new ClientesDAO();
        String busca = request.getParameter("tipoBusca");

        switch (busca) {
            case "cpf":

                try {
                    cliente.setCpf(request.getParameter("valorBusca"));
                    ArrayList<Cliente> listarClientes = clientesDAO.getClient(cliente);
                    request.setAttribute("listarClientes", listarClientes);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/ClienteLista.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "id":

                try {
                    cliente.setId_cliente(Integer.parseInt(request.getParameter("valorBusca")));
                    ArrayList<Cliente> listarClientes = clientesDAO.getClient(cliente);
                    request.setAttribute("listarClientes", listarClientes);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/ClienteLista.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "nome":

                try {
                    cliente.setNome(request.getParameter("valorBusca"));
                    ArrayList<Cliente> listarClientes = clientesDAO.getClient(cliente);
                    request.setAttribute("listarClientes", listarClientes);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/ClienteLista.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            default:
                System.out.println("Error na busca por Cliente");
                break;
        }

    }
}
