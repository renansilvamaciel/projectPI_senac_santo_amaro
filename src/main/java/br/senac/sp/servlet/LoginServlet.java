/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.UsuarioDAO;
import br.senac.sp.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juliano
 */
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Funcionario funcionario = UsuarioDAO.getUsuario(login, senha);
        
        if (funcionario != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", funcionario);
            response.sendRedirect(request.getContextPath()+"/protegido/index.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/login2.jsp?erro=userNotFound");
        }
        

    }


}
