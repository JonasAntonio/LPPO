/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabd;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

//ADICIONAR BIBLIOTECA DO DRIVER JDBC DO MYSQL
//NO PHPMYADMIN CRIAR UM BANCO DE DADOS cesjf

/**
 *
 * @author alunoces
 */
public class JavaBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //JOptionPane.showMessageDialog(null, "Testando a conexão");
            Connection con =  new ConnectionFactory().conecta();
            //JOptionPane.showMessageDialog(null,"Conexão realizada com sucesso");
            Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from uf");//recebe todos os elementos que vão rodar no statement
                    while(rs.next()){
                        int id = rs.getInt("id_uf");//o banco não é case sensitive
                        String nome = rs.getString("sigla_UF");
                        String r = "ID:" + id + "-" + "UF:" + nome;
                        System.out.println(r);
                    }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
    
}
