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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

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

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        try {
            Funcionario funcionario = funcionarioDAO.login(cpf);
            System.out.println("");
            if (funcionario != null) {
                if (funcionario.getCpf().equals(cpf) && funcionario.getSenha().equals(DigestUtils.md5Hex(senha))) { //DESCRIPTOGRAFANDO MD5
                    response.sendRedirect("/protegido/index.jsp");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
