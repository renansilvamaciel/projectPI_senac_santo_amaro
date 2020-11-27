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
public class PlanoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PlanoDAO planoDAO = new PlanoDAO();

        List<Plano> listarPlanos;
        try {
            listarPlanos = planoDAO.listPlanos();
            request.setAttribute("listarPlanos", listarPlanos);
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/protegido/Plano.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlanoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Plano plano = new Plano();

            plano.setNome(request.getParameter("nome"));
            plano.setDescricao(request.getParameter("descricao"));
            plano.setValor(Double.parseDouble(request.getParameter("valor")));

            PlanoDAO planoDAO = new PlanoDAO();
            planoDAO.insertPlanos(plano);
            response.sendRedirect(request.getContextPath()+"//PlanoServlet");
        } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
            Logger.getLogger(PlanoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
