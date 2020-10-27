/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.entidade.Relatorio;
import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Funcionario;
import br.senac.sp.entidade.Produto;
import br.senac.sp.servlet.ProdutoServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliano
 */
public class RelatorioDAO {

    public ArrayList<Relatorio> listVenda(String query) {
        ArrayList<Relatorio> listarVenda = new ArrayList();

        try {
            ConexaoMysql conexao = new ConexaoMysql();
            Connection connection = conexao.openConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Relatorio relatorio = new Relatorio();

                relatorio.setId_venda(rs.getInt("id_venda"));
                relatorio.setId_vendedor(rs.getInt("id_vendedor"));
                relatorio.setQuantidade(rs.getInt("quantidade"));
                relatorio.setValor_total(rs.getDouble("valor_total"));
                relatorio.setData_hoje(rs.getString("data_hoje"));
                relatorio.setNome(rs.getString("id_filial"));
                listarVenda.add(relatorio);

            }
            rs.close();
            conexao.closeConnection();
            System.out.println(listarVenda);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listarVenda;

    }
    
    public ArrayList<Produto> listProduto(String query) {
        ArrayList<Produto> listarProduto = new ArrayList();

        try {
            ConexaoMysql conexao = new ConexaoMysql();
            Connection connection = conexao.openConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setFilial(rs.getString("id_filial"));
  
                listarProduto.add(produto);

            }
            rs.close();
            conexao.closeConnection();
            System.out.println(listarProduto);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listarProduto;

        
    }
        
        
        public ArrayList<Funcionario> listarFuncionarios(String query) {
        ArrayList<Funcionario> listarFuncionarios = new ArrayList();

        try {
            ConexaoMysql conexao = new ConexaoMysql();
            Connection connection = conexao.openConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setQuantidade(rs.getInt("quantidade"));
                funcionario.setFilial(rs.getInt("id_filial"));
                
                listarFuncionarios.add(funcionario);

            }
            rs.close();
            conexao.closeConnection();
            System.out.println(listarFuncionarios);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listarFuncionarios; 
        
    }

}
