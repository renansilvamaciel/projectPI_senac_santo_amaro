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
public class FuncionarioBusca extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        String busca = request.getParameter("tipoBusca");

        switch (busca) {
            case "cpf":

                try {
                    funcionario.setCpf(request.getParameter("valorBusca"));
                    ArrayList<Funcionario> listarFuncionarios = funcionarioDAO.getFuncionario(funcionario);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/FuncionarioLista.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "id":

                try {
                    funcionario.setId_funcionario(Integer.parseInt(request.getParameter("valorBusca")));
                    ArrayList<Funcionario> listarFuncionarios = funcionarioDAO.getFuncionario(funcionario);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/FuncionarioLista.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "nome":

                try {
                    funcionario.setNome(request.getParameter("valorBusca"));
                    ArrayList<Funcionario> listarFuncionarios = funcionarioDAO.getFuncionario(funcionario);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/FuncionarioLista.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            default:
                System.out.println("Error na busca por Funcionario");
                break;
        }

    }

}
