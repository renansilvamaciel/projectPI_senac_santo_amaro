/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.conexaodb.ConexaoMysql;
import br.senac.sp.entidade.Cliente;
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
public class ClientesDAO {

    public boolean insertClient(Cliente cliente) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "insert into cliente (nome, sexo, data_nascimento, cpf, rua, cep, numero_casa, bairro, email, telefone) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, cliente.getNome());
        instructionSql.setString(2, cliente.getSexo());
        instructionSql.setString(3, cliente.getData_nascimento());
        instructionSql.setString(4, cliente.getCpf());
        instructionSql.setString(5, cliente.getRua());
        instructionSql.setString(6, cliente.getCep());
        instructionSql.setInt(7, cliente.getNumero_casa());
        instructionSql.setString(8, cliente.getBairro());
        instructionSql.setString(9, cliente.getEmail());
        instructionSql.setString(10, cliente.getTelefone());

        if (instructionSql.executeUpdate() >= 1) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();

        return success;
    }

    public ArrayList<Cliente> listClients() throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> listarClientes = new ArrayList<>();

        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "select * from cliente order by id_cliente";
        PreparedStatement instructionSql = connection.prepareCall(query);

        ResultSet result = instructionSql.executeQuery();

        while (result.next()) {
            Cliente cliente = new Cliente();
            cliente.setId_cliente(result.getInt("id_cliente"));
            cliente.setNome(result.getString("nome"));
            cliente.setSexo(result.getString("sexo"));
            cliente.setData_nascimento(result.getString("data_nascimento"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setRua(result.getString("rua"));
            cliente.setCep(result.getString("cep"));
            cliente.setNumero_casa(result.getInt("numero_casa"));
            cliente.setBairro(result.getString("bairro"));
            cliente.setEmail(result.getString("email"));
            cliente.setTelefone(result.getString("telefone"));
            cliente.setAssinatura(result.getString("assinatura"));
            cliente.setTipo_assinatura(result.getString("tipo_assinatura"));

            listarClientes.add(cliente);
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return listarClientes;
    }

    public ArrayList<Cliente> getClient(Cliente cliente) throws ClassNotFoundException, SQLException {
        ArrayList<Cliente> listarCliente = new ArrayList<>();
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = " SELECT * FROM CLIENTE WHERE cpf=? OR id_cliente=? OR nome LIKE ?";
        PreparedStatement instructionSql = connection.prepareCall(query);
        instructionSql.setString(1, cliente.getCpf());
        instructionSql.setInt(2, cliente.getId_cliente());
        instructionSql.setString(3, "%" + cliente.getNome() + '%');

        ResultSet result = instructionSql.executeQuery();
        if (result.next()) {
            cliente.setId_cliente(result.getInt("id_cliente"));
            cliente.setNome(result.getString("nome"));
            cliente.setSexo(result.getString("sexo"));
            cliente.setData_nascimento(result.getString("data_nascimento"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setRua(result.getString("rua"));
            cliente.setCep(result.getString("cep"));
            cliente.setNumero_casa(result.getInt("numero_casa"));
            cliente.setBairro(result.getString("bairro"));
            cliente.setEmail(result.getString("email"));
            cliente.setTelefone(result.getString("telefone"));
            cliente.setAssinatura(result.getString("assinatura"));
            cliente.setTipo_assinatura(result.getString("tipo_assinatura"));

            listarCliente.add(cliente);
        }
        closeStatementAndCloseConnection(instructionSql);

        connectionMysql.closeConnection();
        return listarCliente;
    }

    public boolean updateClient(Cliente cliente) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "update cliente set nome=?, sexo=?, data_nascimento=?, rua=?, cep=?, numero_casa=?, bairro=?, email=?, telefone=? where cpf=?";
        PreparedStatement instructionSql = connection.prepareCall(query);

        instructionSql.setString(1, cliente.getNome());
        instructionSql.setString(2, cliente.getSexo());
        instructionSql.setString(3, cliente.getData_nascimento());
        instructionSql.setString(4, cliente.getRua());
        instructionSql.setString(5, cliente.getCep());
        instructionSql.setInt(6, cliente.getNumero_casa());
        instructionSql.setString(7, cliente.getBairro());
        instructionSql.setString(8, cliente.getEmail());
        instructionSql.setString(9, cliente.getTelefone());
        instructionSql.setString(10, cliente.getCpf());

        if (instructionSql.execute()) {
            success = true;
        }

        closeStatementAndCloseConnection(instructionSql);
        connectionMysql.closeConnection();
        return success;
    }

    public boolean deleteClient(String cpf) throws ClassNotFoundException, SQLException {
        boolean success = false;
        ConexaoMysql connectionMysql = new ConexaoMysql();
        Connection connection = connectionMysql.openConnection();
        String query = "delete from cliente where cpf=?";
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
