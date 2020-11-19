/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.PlanoDAO;
import br.senac.sp.entidade.Plano;
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
public class PlanoDeleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Plano plano = new Plano();
            plano.setNome(request.getParameter("nome"));
            PlanoDAO planoDAO = new PlanoDAO();
            planoDAO.deletePlano(plano.getNome());
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/PlanoServlet");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PlanoDeleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
