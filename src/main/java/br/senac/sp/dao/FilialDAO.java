/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Filial;
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
public class FilialDAO {

    public boolean insertFilial(Filial filial) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "insert into filial (nome, cnpj, estado, rua, cep, numero, bairro) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, filial.getNome());
        instructionSql.setString(2, filial.getCnpj());
        instructionSql.setString(3, filial.getEstado());
        instructionSql.setString(4, filial.getRua());
        instructionSql.setString(5, filial.getCep());
        instructionSql.setInt(6, filial.getNumero());
        instructionSql.setString(7, filial.getBairro());

        if (instructionSql.executeUpdate() >= 1) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();

        return success;
    }

    public ArrayList<Filial> listFiliais() throws SQLException, ClassNotFoundException {
        ArrayList<Filial> listarFiliais = new ArrayList<>();

        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "select * from filial order by id_filial";
        PreparedStatement instructionSql = connection.prepareCall(query);

        ResultSet result = instructionSql.executeQuery();

        while (result.next()) {
            Filial filial = new Filial();
            filial.setId_filial(result.getInt("id_filial"));
            filial.setNome(result.getString("nome"));
            filial.setCnpj(result.getString("cnpj"));
            filial.setEstado(result.getString("estado"));
            filial.setRua(result.getString("rua"));
            filial.setCep(result.getString("cep"));
            filial.setNumero(result.getInt("numero"));
            filial.setBairro(result.getString("bairro"));

            listarFiliais.add(filial);
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return listarFiliais;
    }

    public ArrayList<Filial> getFilial(Filial filial) throws ClassNotFoundException, SQLException {
        ArrayList<Filial> listarFiliais = new ArrayList<>();
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = " SELECT * FROM filial WHERE cnpj=? OR id_filial=? OR estado=? OR nome LIKE ?";
        PreparedStatement instructionSql = connection.prepareCall(query);
        instructionSql.setString(1, filial.getCnpj());
        instructionSql.setInt(2, filial.getId_filial());
        instructionSql.setString(3, filial.getEstado());
        instructionSql.setString(4, "%" + filial.getNome() + '%');

        ResultSet result = instructionSql.executeQuery();

        while (result.next()) {

            filial.setId_filial(result.getInt("id_filial"));
            filial.setNome(result.getString("nome"));
            filial.setCnpj(result.getString("cnpj"));
            filial.setEstado(result.getString("estado"));
            filial.setRua(result.getString("rua"));
            filial.setCep(result.getString("cep"));
            filial.setNumero(result.getInt("numero"));
            filial.setBairro(result.getString("bairro"));

            listarFiliais.add(filial);
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return listarFiliais;
    }

    public boolean updateFilial(Filial filial) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "update filial set nome=?, estado=?, rua=?, cep=?, numero=?, bairro=? where cnpj=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, filial.getNome());
        instructionSql.setString(2, filial.getEstado());
        instructionSql.setString(3, filial.getRua());
        instructionSql.setString(4, filial.getCep());
        instructionSql.setInt(5, filial.getNumero());
        instructionSql.setString(6, filial.getBairro());
        instructionSql.setString(7, filial.getCnpj());

        if (instructionSql.execute()) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return success;
    }

    public boolean deleteFilial(String cnpj) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "delete from filial where cnpj=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, cnpj);
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
                Logger.getLogger(FilialDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
