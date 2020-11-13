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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azazel
 */
public class FuncionarioLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        try {
            funcionario.setCpf(request.getParameter("cpf"));
            funcionario.setSenha(request.getParameter("senha"));
            boolean userLogin = funcionarioDAO.login(funcionario.getCep(), funcionario.getSenha());
            System.out.println(userLogin);
            if (userLogin) {
                response.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
