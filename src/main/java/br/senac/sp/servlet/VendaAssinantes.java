/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class VendaAssinantes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();
        ClientesDAO clientesDAO = new ClientesDAO();
        cliente.setCpf(request.getParameter("valorBusca"));
        ArrayList<Cliente> listarClientes;
        try {
            listarClientes = clientesDAO.getClient(cliente);
            request.setAttribute("listarClientes", listarClientes);
            if (!listarClientes.isEmpty()) {
                request.setAttribute("creditoAssinante", "10.00");
            } else {
                request.setAttribute("creditoAssinante", "00.00");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaAssinantes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VendaAssinantes.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Produto> ListaProdutos = ProdutoDAO.getProdutos();
        request.setAttribute("listaProdutos", ListaProdutos);

        RequestDispatcher requesDispatcher = getServletContext().getRequestDispatcher("/VendaAssinantes.jsp");
        requesDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
