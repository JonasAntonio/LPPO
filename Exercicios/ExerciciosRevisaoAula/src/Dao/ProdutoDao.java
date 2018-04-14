/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Javabeans.ProdutoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;

/**
 *
 * @author Jonas
 */
public class ProdutoDao {
    private Connection conecta;
    private PreparedStatement stmt;
    
    public ProdutoDao(){
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public List<ProdutoBean> listarProduto(){
        try{
           List<ProdutoBean> lista = new ArrayList<ProdutoBean>();
           String sql = "SELECT * FROM produto";
           stmt = conecta.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               ProdutoBean p = new ProdutoBean();
               p.setCodigo(rs.getInt("pro_codigo"));
               p.setDescricao(rs.getString("pro_descricao"));
               p.setNome(rs.getString("pro_nome"));
               p.setPreco(rs.getFloat("pro_preco"));
               
               lista.add(p);
           }
           
           return lista;
           
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void cadastrarProduto(ProdutoBean p){
        try{
            String sql = "INSERT INTO produto(pro_nome, pro_descricao, pro_preco) VALUES(?,?,?)";
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void atualizarProduto(ProdutoBean p){
        try{
            String sql = "UPDATE produto set pro_nome=?, pro_descricao=?, pro_preco=? WHERE pro_codigo=?";
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());
            stmt.setInt(4, p.getCodigo());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void removerProduto(ProdutoBean p){
        try{
            String sql = "DELETE FROM produto WHERE pro_codigo=?";
            stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, p.getCodigo());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
