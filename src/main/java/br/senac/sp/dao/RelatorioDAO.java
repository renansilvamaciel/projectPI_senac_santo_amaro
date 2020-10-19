/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.entidade.Relatorio;
import br.senac.sp.conexaodb.ConexaoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juliano
 */
public class RelatorioDAO {

    public ArrayList<Relatorio> listVenda() throws ClassNotFoundException, SQLException {
        ArrayList<Relatorio> listarVenda = new ArrayList();
        
            ConexaoMysql conexao = new ConexaoMysql();
            Connection connection = conexao.openConnection();

            String query = "select detalhes.id_venda, venda.id_vendedor, detalhes.nome_produto, detalhes.quantidade, venda.valor_total, "
                    + "venda.data_hoje, venda.id_filial from detalhes "
                    + "inner join venda on detalhes.id_venda = venda.id_venda";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Relatorio relatorio = new Relatorio();

                relatorio.setId_venda(rs.getInt("id_venda"));
                relatorio.setId_vendedor(rs.getInt("id_vendedor"));
                relatorio.setNome_produto(rs.getString("nome_produto"));
                relatorio.setQuantidade(rs.getInt("quantidade"));

                relatorio.setValor_total(rs.getDouble("valor_total"));
                relatorio.setData_hoje(rs.getString("data_hoje"));
                relatorio.setId_filial(rs.getInt("id_filial"));
                listarVenda.add(relatorio);

            }
            rs.close();
            conexao.closeConnection();
            System.out.println(listarVenda);
            return listarVenda;

    }

}
