/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azazel
 */
public class PlanoDAO {

    public boolean insertPlanos(Plano plano) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "insert into planos (nome, descricao, valor) values (?, ?, ?)";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, plano.getNome());
        instructionSql.setString(2, plano.getDescricao());
        instructionSql.setDouble(3, plano.getValor());
        

        if (instructionSql.executeUpdate() >= 1) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();

        return success;
    }

    public ArrayList<Plano> listPlanos() throws SQLException, ClassNotFoundException {
        ArrayList<Plano> listarPlanos = new ArrayList<>();

        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "select * from planos";
        PreparedStatement instructionSql = connection.prepareCall(query);

        ResultSet result = instructionSql.executeQuery();

        while (result.next()) {
            Plano plano = new Plano();
            plano.setNome(result.getString("nome"));
            plano.setDescricao(result.getString("descricao"));
            plano.setValor(result.getDouble("valor"));

            listarPlanos.add(plano);
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return listarPlanos;
    }

    public ArrayList<Plano> getPlano(Plano plano) throws ClassNotFoundException, SQLException {
        ArrayList<Plano> listarPlano = new ArrayList<>();
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = " SELECT * FROM planos WHERE nome=?";
        PreparedStatement instructionSql = connection.prepareCall(query);
        instructionSql.setString(1, plano.getNome());

        ResultSet result = instructionSql.executeQuery();

        while (result.next()) {

            plano.setNome(result.getString("nome"));
            plano.setDescricao(result.getString("descricao"));
            plano.setValor(Double.parseDouble(result.getString("valor")));
            
            listarPlano.add(plano);
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return listarPlano;
    }

    public boolean updatePlano(Plano plano) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "update planos set descricao=?, valor=? where nome=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, plano.getDescricao());
        instructionSql.setDouble(2, plano.getValor());
        instructionSql.setString(3, plano.getNome());

        if (instructionSql.execute()) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return success;
    }

    public boolean deletePlano(String nome) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "delete from planos where nome=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, nome);
        int linhasAfetadas = instructionSql.executeUpdate();

        if (linhasAfetadas > 0) {
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
                Logger.getLogger(PlanoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
