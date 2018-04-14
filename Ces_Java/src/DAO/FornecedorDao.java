/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JAVABEANS.Fornecedores;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class FornecedorDao {
    
    private final Connection conecta;
    private PreparedStatement stmt;
    
    public FornecedorDao() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void cadastrarFornecedor(Fornecedores f){
        try{
            String cmdsql = "INSERT INTO fornecedor(for_nome, for_rua, for_numero, for_bairro, for_cidade, for_uf, for_telefone) VALUES(?,?,?,?,?,?,?)";
            stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getRua());
            stmt.setInt(3, f.getNumero());
            stmt.setString(4, f.getBairro());
            stmt.setString(5, f.getCidade());
            stmt.setString(6, f.getUf());
            stmt.setString(7, f.getTelefone());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public List<Fornecedores> listarFornecedores(){
        try{
            List<Fornecedores> lista = new ArrayList<Fornecedores>();
            String sql = "SELECT * FROM fornecedor";
            stmt = conecta.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedores f = new Fornecedores();
                f.setCodigo(rs.getInt("for_id"));
                f.setNome(rs.getString("for_nome"));
                f.setRua(rs.getString("for_rua"));
                f.setNumero(rs.getInt("for_numero"));
                f.setBairro(rs.getString("for_bairro"));
                f.setCidade(rs.getString("for_cidade"));
                f.setUf(rs.getString("for_uf"));
                f.setTelefone(rs.getString("for_telefone"));
                
                lista.add(f);
            }
            
            return lista;
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void alterarFornecedor(Fornecedores f){
        try{
            String sql = "UPDATE fornecedor SET for_nome=?, for_rua=?, for_numero=?, for_bairro=?, for_cidade=?, for_uf=?, for_telefone=? WHERE for_id=?";
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getRua());
            stmt.setInt(3, f.getNumero());
            stmt.setString(4, f.getBairro());
            stmt.setString(5, f.getCidade());
            stmt.setString(6, f.getUf());
            stmt.setString(7, f.getTelefone());
            stmt.setInt(8, f.getCodigo());
            
            stmt.execute();
            stmt.close();
        } catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public void excluirFornecedor(Fornecedores f){
        try{
            String sql = "DELETE FROM fornecedor WHERE for_id=?";
            stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, f.getCodigo());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}
