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
public class FilialServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FilialDAO filialDAO = new FilialDAO();

        List<Filial> listarFiliais;
        try {
            listarFiliais = filialDAO.listFiliais();
            request.setAttribute("listarFiliais", listarFiliais);
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/Filial.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Filial filial = new Filial();

            filial.setNome(request.getParameter("nome"));
            filial.setCnpj(request.getParameter("cnpj"));
            filial.setEstado(request.getParameter("estado"));
            filial.setRua(request.getParameter("rua"));
            filial.setCep(request.getParameter("cep"));
            filial.setNumero(Integer.parseInt(request.getParameter("numero")));
            filial.setBairro(request.getParameter("bairro"));
           

            FilialDAO filialDAO = new FilialDAO();
            filialDAO.insertFilial(filial);
            response.sendRedirect("FilialServlet");
        } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
