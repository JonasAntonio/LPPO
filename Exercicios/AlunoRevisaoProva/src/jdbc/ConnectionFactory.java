/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class ConnectionFactory {
    public Connection conecta(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/testes_crud", "root", "");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
