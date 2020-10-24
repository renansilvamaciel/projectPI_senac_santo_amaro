/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.VendaPlanos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azazel
 */
public class VendaPlanoDAO {

    public boolean insertVenda(VendaPlanos vendaPlanos) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "insert into venda_plano (cpf, id_vendedor, assinatura, tipo_assinatura, valor_total, id_filial) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, vendaPlanos.getCpf());
        instructionSql.setInt(2, vendaPlanos.getId_vendedor());
        instructionSql.setString(3, vendaPlanos.getAssinatura());
        instructionSql.setString(4, vendaPlanos.getTipo_assinatura());
        instructionSql.setDouble(5, vendaPlanos.getValor_total());
        instructionSql.setInt(6, vendaPlanos.getId_filial());

        if (instructionSql.executeUpdate() >= 1) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();

        return success;
    }

    private void closeStatementAndCloseConnection(PreparedStatement preparedStatement) throws ClassNotFoundException {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
