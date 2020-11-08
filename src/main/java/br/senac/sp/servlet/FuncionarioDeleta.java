/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.FuncionarioDAO;
import br.senac.sp.entidade.Funcionario;
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
public class FuncionarioDeleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(request.getParameter("cpf"));
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.deleteFuncionario(funcionario.getCpf());
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/FuncionarioServlet");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDeleta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDeleta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
