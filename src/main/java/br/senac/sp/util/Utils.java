/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.util;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azazel
 */
public class Utils {
    
     public static void mostrarTelaErro(Exception ex, 
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msgErro = ex.getMessage();
        request.setAttribute("msgErro", msgErro);
        RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/Erro.jsp");
        requestDispatcher.forward(request, response);
    }
    
    public static void mostrarTelaSucesso(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Success.jsp");
    }
    
    public static void mostrarTelaErroIdade(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("IdadeInvalida.jsp");
    }
    
    public static void mostrarTelaErroCpf(HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ErroClienteCpf.jsp");
    }
}
