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
import br.senac.sp.util.Utils;
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
public class VendaPlanoClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VendaPlanos vendaPlanos = new VendaPlanos();
        vendaPlanos.setCpf(request.getParameter("cpfCliente"));
        vendaPlanos.setTipo_assinatura(request.getParameter("tipo_assinatura"));
        vendaPlanos.setAssinatura(request.getParameter("assinatura"));

        try {
            if (vendaPlanos.validationClient(vendaPlanos.getCpf())) {

                ClientesDAO clientesDAO = new ClientesDAO();
                List<Cliente> listarCliente = clientesDAO.getClient(vendaPlanos.getCpf());
                request.setAttribute("valorPlano", vendaPlanos.validarValorPlano(vendaPlanos.getAssinatura(), vendaPlanos.getTipo_assinatura()));
                request.setAttribute("assinaturaPlano", vendaPlanos.getAssinatura());
                request.setAttribute("tipoPlano", vendaPlanos.getTipo_assinatura());
                request.setAttribute("listarCliente", listarCliente);

                RequestDispatcher requestDispatcher = getServletContext()
                        .getRequestDispatcher("/VendaPlanosFinalizarVenda.jsp");
                requestDispatcher.forward(request, response);
            } else {
                Utils.mostrarTelaErroCpf(response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaPlanoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VendaPlanoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }

    }

}
