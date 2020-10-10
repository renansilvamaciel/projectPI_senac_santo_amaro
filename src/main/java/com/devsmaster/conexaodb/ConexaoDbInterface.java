/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsmaster.conexaodb;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Azazel
 */
public interface ConexaoDbInterface {

    public Connection openConnection() throws ClassNotFoundException, SQLException;

    public boolean closeConnection() throws ClassNotFoundException, SQLException;
}
