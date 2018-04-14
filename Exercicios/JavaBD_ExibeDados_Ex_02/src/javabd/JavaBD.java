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
            Connection con =  new ConnectionFactory().conecta();
            Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from aluno");//recebe todos os elementos que vão rodar no statement
                    System.out.println("| ID | NOME | DATA MATRICULA | DATA NASC. | TELEFONE | PESO | ALTURA | ENDERECO");
                    while(rs.next()){
                        int id = rs.getInt("id");//o banco não é case sensitive
                        String nome = rs.getString("nome");
                        String dataMatricula = rs.getString("dataMatricula");
                        String endereco = rs.getString("endereco");
                        String telefone = rs.getString("telefone");
                        String dataNascimento = rs.getString("dataNascimento");
                        float altura = rs.getFloat("altura");
                        float peso = rs.getFloat("peso");
                        String r = "|  " + id + " | " + nome + " | " + dataMatricula + " | " + 
                                    dataNascimento + " | " + telefone + " | " + 
                                    peso + " | " + altura + " | " + endereco;
                        System.out.println(r);
                    }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
    
}
