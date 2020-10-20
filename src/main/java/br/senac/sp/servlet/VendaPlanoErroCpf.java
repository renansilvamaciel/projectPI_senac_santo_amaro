/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.entidade.VendaPlanos;
import br.senac.sp.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azazel
 */
public class VendaPlanoErroCpf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {

        VendaPlanos vendaPlanos = new VendaPlanos();
        vendaPlanos.setCpf(request.getParameter("cpfClient"));

        if (!vendaPlanos.validationClient(vendaPlanos.getCpf())) {
            Utils.mostrarTelaErroCpf(response);
        } 
    }
}
