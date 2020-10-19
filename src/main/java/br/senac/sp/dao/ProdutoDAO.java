/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Produto;

import br.senac.sp.servlet.ProdutoServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
public class ProdutoDAO {

    public static List<Produto> getProdutos() {

        
        List<Produto> listaProdutos = new ArrayList();
        ConexaoMysql conexao = new ConexaoMysql();
               
        try {
            Connection con = conexao.openConnection();
            String query = "Select * from produto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                
                int id_produto = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                String familia = rs.getString("id_familia");
                int quantidade = rs.getInt("quantidade");
                Double preco = rs.getDouble("preco");
                String descricao = rs.getString("descricao");
                String filial = rs.getString("id_filial");
                
                listaProdutos.add(new Produto(id_produto,nome, familia, quantidade, preco, descricao, filial));

                               
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProdutos;
    }
    
    public static void addProdutos(Produto produto) throws SQLException, ClassNotFoundException{
            ConexaoMysql conexao = new ConexaoMysql();
            Connection con = conexao.openConnection();
            
            String query = "insert into produto (nome, id_familia, quantidade, preco, descricao, id_filial)" +
                            "values (?, ?, ?, ?, ?, ?) ";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getFamilia());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getPreco());
            ps.setString(5, produto.getDescricao());
            ps.setString(6, produto.getFilial());
            
            ps.execute();
        
    }
    
    public static Produto getProduto(int id_produto) {

        Produto produto = null;
               
        try {
            ConexaoMysql conexao = new ConexaoMysql();
            Connection con = conexao.openConnection();
            String query = "Select * from produto where id_produto=?";
            PreparedStatement ps = con.prepareStatement(query);
            
           ps.setInt(1, id_produto);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String familia = rs.getString("id_familia");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                String descricao = rs.getString("descricao");
                String filial = rs.getString("id_filial");
                produto = new Produto(id_produto, nome, familia, quantidade, preco, descricao, filial);       
            }
   

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
        
    }
    
    public static void atualizaProduto(Produto produto) throws SQLException, ClassNotFoundException{
            ConexaoMysql conexao = new ConexaoMysql();
            Connection con = conexao.openConnection();
            
            String query = "update produto set nome=?, id_familia=?, quantidade=?, preco=?, descricao=?, id_filial=? where id_produto=?";
            

            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getFamilia());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getPreco());
            ps.setString(5, produto.getDescricao());
            ps.setString(6, produto.getFilial());
            ps.setInt(7, produto.getId_produto());
            
            ps.execute();
        
    }
    
    
    public static void deleteProduto(int id_produto) throws SQLException, ClassNotFoundException{
            ConexaoMysql conexao = new ConexaoMysql();
            Connection con = conexao.openConnection();
            
            String query = "delete from produto where id_produto=?";
                        
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_produto);
                    
            ps.execute();
        
    }
    
    
}
