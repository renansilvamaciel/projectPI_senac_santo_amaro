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

/**
 *
 * @author Juliano
 */
public class RelatorioVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        int filial = Integer.parseInt(request.getParameter("filial"));
        int filtro = Integer.parseInt(request.getParameter("filtro"));

        switch (filtro) {
            case 1:
                if (filial == 0) {
                    String query = "select * from venda";

                    List<Relatorio> listarVenda = relatorioDAO.listVenda(query);
                    request.setAttribute("listarVenda", listarVenda);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/relatorio.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String query = "select * from venda where id_filial = " + filial;

                    List<Relatorio> listarVenda = relatorioDAO.listVenda(query);
                    request.setAttribute("listarVenda", listarVenda);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/relatorio.jsp");
                    requestDispatcher.forward(request, response);

                }
              case 2:
                if (filial == 0) {
                    String query = "select produto.id_produto, produto.nome, produto.preco, sum(detalhes.quantidade) as quantidade, produto.id_filial from produto "
                            + "inner join detalhes on produto.nome = detalhes.nome_produto";

                    List<Produto> listarProduto = relatorioDAO.listProduto(query);
                    request.setAttribute("listarProduto", listarProduto);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/relatorioProduto.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String query = "select produto.id_produto, produto.nome, produto.preco, sum(detalhes.quantidade) as quantidade, produto.id_filial from produto "
                            + "inner join detalhes on produto.nome = detalhes.nome_produto = " + filial;

                    List<Produto> listarProduto = relatorioDAO.listProduto(query);
                    request.setAttribute("listarProduto", listarProduto);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/relatorioProduto.jsp");
                    requestDispatcher.forward(request, response);

                }

            case 3:
                if (filial == 0) {
                    String query = "select funcionario.id_funcionario, funcionario.nome, funcionario.cpf, count(venda.id_vendedor) as quantidade, funcionario.id_filial from funcionario" +
            " inner join venda on funcionario.id_funcionario = venda.id_vendedor group by venda.id_vendedor";
                    Funcionario funcionario = new Funcionario();
                    
                    List<Funcionario> listarFuncionarios= relatorioDAO.listarFuncionarios(query);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/relatorioFuncionarios.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    String query = "select funcionario.id_funcionario, funcionario.nome, funcionario.cpf, count(venda.id_vendedor) as quantidade, funcionario.id_filial from funcionario\n" +
"              inner join venda on funcionario.id_funcionario = venda.id_vendedor where funcionario.id_filial= " + filial;

                    List<Funcionario> listarFuncionarios =relatorioDAO.listarFuncionarios(query);
                    request.setAttribute("listarFuncionarios", listarFuncionarios);

                    RequestDispatcher requestDispatcher = getServletContext()
                            .getRequestDispatcher("/relatorioFuncionarios.jsp");
                    requestDispatcher.forward(request, response);

                }

        }
    }
}
