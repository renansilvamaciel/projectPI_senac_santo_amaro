/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Funcionario;
import br.senac.sp.entidade.Relatorio;
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
public class UsuarioDAO {

    public static Funcionario getUsuario(String login, String senha) {
        Funcionario funcionario = null;

        try {
            ConexaoMysql conexao = new ConexaoMysql();

            Connection connection = conexao.openConnection();
            String query = "select * from funcionario where cpf = ? and senha = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                int id_filial = rs.getInt("id_filial");
                
             funcionario = new Funcionario();
             funcionario.setNome(nome);
             funcionario.setCargo(cargo);
             funcionario.setFilial(id_filial);
             funcionario.setCpf(login);


            }
            rs.close();
            conexao.closeConnection();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionario;

    }
}
