/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsmaster.conexaodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos Vinicius Santos Souza
 */
public class ConexaoMysql implements ConexaoDbInterface {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String SERVER = "localhost";
    private static String DATABASE = "coffe_shop";

    private static String LOGIN = "root";
    private static String SENHA = "";

    private static String URL = "";

    private static Connection CONEXAO = null;

    @Override
    public Connection openConnection() throws ClassNotFoundException, SQLException {
        URL = "jdbc:mysql://" + SERVER + ":3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

        Class.forName(DRIVER);
        CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

        return CONEXAO;
    }

    @Override
    public boolean closeConnection() throws ClassNotFoundException, SQLException {
        boolean retorno = false;

        if (CONEXAO != null) {
            if (!CONEXAO.isClosed()) {
                CONEXAO.close();
                retorno = true;
            }
        }

        return retorno;
    }
}
