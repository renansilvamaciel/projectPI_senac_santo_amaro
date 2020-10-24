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
import java.io.PrintWriter;
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
public class VendaPlanoClienteFinalizar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VendaPlanos vendaPlanos = new VendaPlanos();

        System.out.println("TESTEEEEEEEEEE" + request.getParameter("cpf"));
        vendaPlanos.setCpf(request.getParameter("cpf"));
        vendaPlanos.setAssinatura(request.getParameter("assinaturaPlano"));
        vendaPlanos.setTipo_assinatura(request.getParameter("tipo_assinatura"));
        vendaPlanos.setValor_total(Double.parseDouble(request.getParameter("valor_total")));

        try {
            VendaPlanoDAO vendaPlanoDAO = new VendaPlanoDAO();
            vendaPlanoDAO.insertVenda(vendaPlanos);
            Utils.mostrarTelaSucesso(response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaPlanoClienteFinalizar.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VendaPlanoClienteFinalizar.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}
