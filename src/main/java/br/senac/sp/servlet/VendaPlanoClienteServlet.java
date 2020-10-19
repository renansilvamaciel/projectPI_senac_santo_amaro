/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.VendaPlanoDAO;
import br.senac.sp.entidade.VendaPlanos;
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
public class VendaPlanoClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {

        VendaPlanos vendaPlanos = new VendaPlanos();
        vendaPlanos.setCpf(request.getParameter("cpfCliente"));
        vendaPlanos.setTipo_assinatura(request.getParameter("tipo_assinatura"));
        vendaPlanos.setAssinatura(request.getParameter("assinatura"));

        try {
            if (vendaPlanos.validationClient(vendaPlanos.getCpf())) {
                VendaPlanoDAO VendaPlanosDao = new VendaPlanoDAO();
                VendaPlanosDao.insertClient(vendaPlanos);
                Utils.mostrarTelaSucesso(response);
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
