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
                ResultSet rs = stmt.executeQuery("select * from cidade");//recebe todos os elementos que vão rodar no statement
                    while(rs.next()){
                        int id = rs.getInt("id_cid");//o banco não é case sensitive
                        String nome = rs.getString("nome_cid");
                        String ufCidade = rs.getString("uf_cid");
                        String r = "ID:" + id + "-" + "UF:" + ufCidade + "-" + "Cidade:" + nome;
                        System.out.println(r);
                    }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
    
}
