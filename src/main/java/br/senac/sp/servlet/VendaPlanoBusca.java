/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClientesDAO;
import br.senac.sp.dao.VendaPlanoDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.VendaPlanos;
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
public class VendaPlanoBusca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Cliente cliente = new Cliente();
            ClientesDAO clientesDAO = new ClientesDAO();
            cliente.setCpf(request.getParameter("valorBusca"));
            ArrayList<Cliente> listarClientes = clientesDAO.getClient(cliente);
            request.setAttribute("listarClientes", listarClientes);

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/protegido/VendaPlanos.jsp");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VendaPlanoDAO vendaPlanoDAO = new VendaPlanoDAO();
        VendaPlanos vendaPlanos = new VendaPlanos();
        vendaPlanos.setCpf(request.getParameter("cpfCliente"));
        vendaPlanos.setTipo_assinatura(request.getParameter("tipo_assinatura"));
        vendaPlanos.setAssinatura(request.getParameter("assinatura"));

        try {

            vendaPlanos.setValor_total(Double.parseDouble(request.getParameter("valorFinalPlano")));
            vendaPlanoDAO.insertVenda(vendaPlanos);
            response.sendRedirect("VendaPlanoBusca");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaPlanoBusca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VendaPlanoBusca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
