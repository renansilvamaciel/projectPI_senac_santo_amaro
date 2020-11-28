/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.senac.sp.dao.RelatorioDAO;
import br.senac.sp.entidade.Funcionario;
import br.senac.sp.entidade.Produto;
import br.senac.sp.entidade.Relatorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juliano
 */
public class RelatorioVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        
        
        HttpSession sessao = request.getSession();
        Funcionario usuario = (Funcionario) sessao.getAttribute("usuario");
        int filial ;
        
        if(usuario.getFilial()==1){
            filial = Integer.parseInt(request.getParameter("filial")); 
        }
       
        else {
            filial = usuario.getFilial();
        }
        
        
       
        
        
        int filtro = Integer.parseInt(request.getParameter("filtro"));
        String date1 = (request.getParameter("date1"));
        String date2 = (request.getParameter("date2"));

        switch (filtro) {
            case 1:
                if (filial == 0) {
                    String query = "select * from venda where date(data_hoje) >=  '" + date1 + "'  and date(data_hoje) <= '" + date2 + "'";

                    List<Relatorio> listarVenda = relatorioDAO.listVenda(query);
                    request.setAttribute("listarVenda", listarVenda);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/relatorio.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String query = "select * from venda where id_filial = " + filial + " and date(data_hoje) >=  '" + date1 + "'  and date(data_hoje) <= '" + date2 + "'";

                    List<Relatorio> listarVenda = relatorioDAO.listVenda(query);
                    request.setAttribute("listarVenda", listarVenda);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/relatorio.jsp");
                    requestDispatcher.forward(request, response);

                }
            case 2:
                if (filial == 0) {
                    String query = "select produto.id_produto, produto.nome, produto.preco, sum(detalhes.quantidade) as quantidade, produto.id_filial from produto "
                            + "inner join detalhes on produto.nome = detalhes.nome_produto "
                            + "inner join venda on detalhes.id_venda = venda.id_venda where date(data_hoje) >= '" + date1 + "' and date(data_hoje) <= '" + date2
                            + "' group by produto.nome";

                    List<Produto> listarProduto = relatorioDAO.listProduto(query);
                    request.setAttribute("listarProduto", listarProduto);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/relatorioProduto.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String query = "select produto.id_produto, produto.nome, produto.preco, sum(detalhes.quantidade) as quantidade, produto.id_filial from produto "
                            + "inner join detalhes on produto.nome = detalhes.nome_produto "
                            + "inner join venda on detalhes.id_venda = venda.id_venda where venda.id_filial = " + filial + " and date(data_hoje) >= '" + date1 + "' and date(data_hoje) <= '" + date2
                            + "' group by produto.nome";

                    List<Produto> listarProduto = relatorioDAO.listProduto(query);
                    request.setAttribute("listarProduto", listarProduto);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/relatorioProduto.jsp");
                    requestDispatcher.forward(request, response);

                }

            case 3:
                if (filial == 0) {
                    String query = "select funcionario.id_funcionario, funcionario.nome, funcionario.cpf, count(venda.id_vendedor) as quantidade, funcionario.id_filial from funcionario "
                            + "inner join venda on funcionario.id_funcionario = venda.id_vendedor where date(data_hoje) >= '" + date1 + "' and date(data_hoje) <=  '" + date2
                            + "' group by venda.id_vendedor";

                    List<Funcionario> listarFuncionarios = relatorioDAO.listarFuncionarios(query);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/relatorioFuncionarios.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String query = "select funcionario.id_funcionario, funcionario.nome, funcionario.cpf, count(venda.id_vendedor) as quantidade, funcionario.id_filial from funcionario "
                            + "inner join venda on funcionario.id_funcionario = venda.id_vendedor where venda.id_filial = " + filial + " and date(data_hoje) >= '" + date1 + "' and date(data_hoje) <= '" + date2
                            + "' group by venda.id_vendedor";

                    List<Funcionario> listarFuncionarios = relatorioDAO.listarFuncionarios(query);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/protegido/relatorioFuncionarios.jsp");
                    requestDispatcher.forward(request, response);

                }

        }
    }
}
