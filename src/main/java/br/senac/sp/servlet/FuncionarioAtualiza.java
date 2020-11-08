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
public class FuncionarioAtualiza extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(request.getParameter("cpf"));
            ArrayList<Funcionario> listarFuncionarios = funcionarioDAO.getFuncionario(funcionario);
            request.setAttribute("listarFuncionarios", listarFuncionarios);

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/FuncionarioServlet");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        funcionario.setFilial(Integer.parseInt(request.getParameter("filial")));
        funcionario.setSenha(request.getParameter("senha"));

        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.updateFuncionario(funcionario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteAtualiza.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}
