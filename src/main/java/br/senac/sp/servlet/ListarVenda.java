/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.RelatorioDAO;
import br.senac.sp.entidade.Relatorio;
import br.senac.sp.util.Utils;
import java.io.IOException;
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
 * @author Juliano
 */
public class ListarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        String query = "select detalhes.id_venda, venda.id_vendedor, detalhes.nome_produto, detalhes.quantidade, venda.valor_total, " 
                    + "venda.data_hoje, venda.id_filial from detalhes "
                    + "inner join venda on detalhes.id_venda = venda.id_venda";

        
            List<Relatorio> listarVenda = relatorioDAO.listVenda(query);
            request.setAttribute("listarVenda", listarVenda);

            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/relatorio.jsp");
            requestDispatcher.forward(request, response);

    }

}
