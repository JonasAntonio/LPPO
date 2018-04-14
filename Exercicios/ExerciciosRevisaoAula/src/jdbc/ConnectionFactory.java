/*****--ADICIONAR O DRIVER DO JDBC--*****/
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alunoces
 */
public class ConnectionFactory {
    public Connection conecta(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/testes_crud","root","");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
