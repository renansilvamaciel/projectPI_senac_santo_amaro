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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliano
 */
public class RelatorioDAO {

    public static List<Relatorio> getRelatorio() throws SQLException {
        List<Relatorio> listaVenda = new ArrayList();
        try {
            ConexaoMysql conexao = new ConexaoMysql();
            Connection connection = conexao.openConnection();
            
            String query = "select detalhes.id_venda, venda.id_vendedor, detalhes.modelo_codigo, detalhes.quantidade, venda.valor_total, "
                    + "venda.data_hoje, venda.id_filial from detalhes"
                    + "inner join venda on detalhes.id_venda = venda.id_venda";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                int id_vendedor = rs.getInt("id_vendedor");
                String modelo = rs.getString("modelo");
                int quantidade = rs.getInt("quantidade");
                double valor = rs.getDouble("valor");
                String data = rs.getString("data");
                int filial = rs.getInt("filial");
                listaVenda.add(new Relatorio(id_venda, id_vendedor, modelo, quantidade, valor, data, filial));
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaVenda;
    }

}
