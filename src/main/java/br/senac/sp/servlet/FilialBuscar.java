/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.FilialDAO;
import br.senac.sp.entidade.Filial;
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
public class FilialBuscar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Filial filial = new Filial();
        FilialDAO filialDAO = new FilialDAO();
        String busca = request.getParameter("tipoBusca");

        switch (busca) {
            case "cnpj":

                try {
                    filial.setCnpj(request.getParameter("valorBusca"));
                    ArrayList<Filial> listarFiliais = filialDAO.getFilial(filial);
                    request.setAttribute("listarFiliais", listarFiliais);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/Filial.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "id":

                try {
                    filial.setId_filial(Integer.parseInt(request.getParameter("valorBusca")));
                    ArrayList<Filial> listarFiliais = filialDAO.getFilial(filial);
                    request.setAttribute("listarFiliais", listarFiliais);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/Filial.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "estado":

                try {
                    filial.setEstado(request.getParameter("valorBusca"));
                    ArrayList<Filial> listarFiliais = filialDAO.getFilial(filial);
                    request.setAttribute("listarFiliais", listarFiliais);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/Filial.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "nome":

                try {
                    filial.setNome(request.getParameter("valorBusca"));
                    ArrayList<Filial> listarFiliais = filialDAO.getFilial(filial);
                    request.setAttribute("listarFiliais", listarFiliais);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/Filial.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ClienteBusca.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            default:
                System.out.println("Error na busca por Filial");
                break;
        }

    }

}
