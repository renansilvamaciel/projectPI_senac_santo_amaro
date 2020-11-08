/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Funcionario;
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
public class FuncionarioDAO {

    public boolean insertFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "insert into funcionario (nome, sexo, data_nascimento, cpf, rua, cep, numero_casa, bairro, email, telefone, senha, id_filial, cargo) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement instructionSql = connection.prepareCall(query);
        
        funcionario.setFilial(1);

        instructionSql.setString(1, funcionario.getNome());
        instructionSql.setString(2, funcionario.getSexo());
        instructionSql.setString(3, funcionario.getData_nascimento());
        instructionSql.setString(4, funcionario.getCpf());
        instructionSql.setString(5, funcionario.getRua());
        instructionSql.setString(6, funcionario.getCep());
        instructionSql.setInt(7, funcionario.getNumero_casa());
        instructionSql.setString(8, funcionario.getBairro());
        instructionSql.setString(9, funcionario.getEmail());
        instructionSql.setString(10, funcionario.getTelefone());
        instructionSql.setString(11, funcionario.getSenha());
        instructionSql.setInt(12, funcionario.getFilial());
        instructionSql.setString(13, funcionario.getCargo());

        if (instructionSql.executeUpdate() >= 1) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();

        return success;
    }

    public ArrayList<Funcionario> listFuncionarios() throws SQLException, ClassNotFoundException {
        ArrayList<Funcionario> listarFuncionarios = new ArrayList<>();

        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "select * from funcionario order by id_funcionario";
        PreparedStatement instructionSql = connection.prepareCall(query);

        ResultSet result = instructionSql.executeQuery();

        while (result.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId_funcionario(result.getInt("id_funcionario"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setSexo(result.getString("sexo"));
            funcionario.setData_nascimento(result.getString("data_nascimento"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setRua(result.getString("rua"));
            funcionario.setCep(result.getString("cep"));
            funcionario.setNumero_casa(result.getInt("numero_casa"));
            funcionario.setBairro(result.getString("bairro"));
            funcionario.setEmail(result.getString("email"));
            funcionario.setTelefone(result.getString("telefone"));
            funcionario.setFilial(result.getInt("id_filial"));
            funcionario.setCargo(result.getString("cargo"));

            listarFuncionarios.add(funcionario);
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return listarFuncionarios;
    }

    public ArrayList<Funcionario> getFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        ArrayList<Funcionario> listarFuncionario = new ArrayList<>();
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = " SELECT * FROM funcionario WHERE cpf=? OR id_funcionario=? OR nome LIKE ?";
        PreparedStatement instructionSql = connection.prepareCall(query);
        instructionSql.setString(1, funcionario.getCpf());
        instructionSql.setInt(2, funcionario.getId_funcionario());
        instructionSql.setString(3, "%" + funcionario.getNome() + '%');

        ResultSet result = instructionSql.executeQuery();
        if (result.next()) {
            funcionario.setId_funcionario(result.getInt("id_funcionario"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setSexo(result.getString("sexo"));
            funcionario.setData_nascimento(result.getString("data_nascimento"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setRua(result.getString("rua"));
            funcionario.setCep(result.getString("cep"));
            funcionario.setNumero_casa(result.getInt("numero_casa"));
            funcionario.setBairro(result.getString("bairro"));
            funcionario.setEmail(result.getString("email"));
            funcionario.setTelefone(result.getString("telefone"));
            funcionario.setFilial(result.getInt("id_filial"));
            funcionario.setCargo(result.getString("cargo"));

            listarFuncionario.add(funcionario);
        }
        closeStatementAndCloseConnection(instructionSql);

        connectionMysql.closeConnection();
        return listarFuncionario;
    }

    public boolean updateFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "update funcionario set nome=?, sexo=?, data_nascimento=?, rua=?, cep=?, numero_casa=?, bairro=?, email=?, telefone=?, senha=?, id_filial=?, cargo=? where cpf=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, funcionario.getNome());
        instructionSql.setString(2, funcionario.getSexo());
        instructionSql.setString(3, funcionario.getData_nascimento());
        instructionSql.setString(4, funcionario.getRua());
        instructionSql.setString(5, funcionario.getCep());
        instructionSql.setInt(6, funcionario.getNumero_casa());
        instructionSql.setString(7, funcionario.getBairro());
        instructionSql.setString(8, funcionario.getEmail());
        instructionSql.setString(9, funcionario.getTelefone());
        instructionSql.setString(10, funcionario.getSenha());
        instructionSql.setInt(11, funcionario.getFilial());
        instructionSql.setString(12, funcionario.getCargo());
        instructionSql.setString(13, funcionario.getCpf());

        if (instructionSql.execute()) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return success;
    }

    public boolean deleteFuncionario(String cpf) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "delete from funcionario where cpf=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, cpf);
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
                Logger.getLogger(ClientesDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
