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
public class PlanoBusca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Plano plano = new Plano();
        PlanoDAO planoDAO = new PlanoDAO();
        try {
            plano.setNome(request.getParameter("valorBusca"));
            ArrayList<Plano> listarPlanos = planoDAO.getPlano(plano);
            request.setAttribute("listarPlanos", listarPlanos);

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/protegido/Plano.jsp");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PlanoBusca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
