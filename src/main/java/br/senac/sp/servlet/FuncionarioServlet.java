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
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        List<Funcionario> listarFuncionarios;
        try {
            listarFuncionarios = funcionarioDAO.listFuncionarios();
            request.setAttribute("listarFuncionarios", listarFuncionarios);
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/FuncionarioLista.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Funcionario funcionario = new Funcionario();

            funcionario.setNome(request.getParameter("nome"));
            funcionario.setSexo(request.getParameter("sexo"));
            funcionario.setData_nascimento(request.getParameter("data_nascimento"));
            funcionario.setCpf(request.getParameter("cpf"));
            funcionario.setRua(request.getParameter("rua"));
            funcionario.setCep(request.getParameter("cep"));
            funcionario.setNumero_casa(Integer.parseInt(request.getParameter("numero_casa")));
            funcionario.setBairro(request.getParameter("bairro"));
            funcionario.setEmail(request.getParameter("email"));
            funcionario.setTelefone(request.getParameter("telefone"));
            funcionario.setCargo(request.getParameter("cargo"));
            funcionario.setSenha(request.getParameter("senha"));

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.insertFuncionario(funcionario);
            response.sendRedirect("FuncionarioServlet");
        } catch (ClassNotFoundException | NumberFormatException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
