/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AlunoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import jdbc.ConnectionFactory;

/**
 *
 * @author Jonas
 */
public class AlunoDao {
    private PreparedStatement stmt;
    private final Connection conecta;
    
    public AlunoDao() {
        this.conecta = new ConnectionFactory().conecta();
    }
    public List<AlunoBean> listarAlunos(){
        try{
            List<AlunoBean> lista = new ArrayList<>();
            String sql = "SELECT * FROM aluno";
            stmt = conecta.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                AlunoBean a = new AlunoBean();
                a.setAltura(rs.getFloat("altura"));
                a.setDataMatricula(rs.getString("dataMatricula"));
                a.setDataNascimento(rs.getString("dataNascimento"));
                a.setEndereco(rs.getString("endereco"));
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setPeso(rs.getFloat("peso"));
                a.setTelefone(rs.getString("telefone"));
                
                lista.add(a);
            }
            return lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void cadastrarAluno(AlunoBean a){
        try{
            String sql = "INSERT INTO aluno(nome, dataMatricula, endereco, telefone, dataNascimento, altura, peso) VALUES(?,?,?,?,?,?,?)";
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getDataMatricula());
            stmt.setString(3, a.getEndereco());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getDataNascimento());
            stmt.setFloat(6, a.getAltura());
            stmt.setFloat(7, a.getPeso());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void atualizarAluno(AlunoBean a){
        try{
            String sql = "UPDATE aluno SET nome=?, dataMatricula=?, endereco=?, telefone=?, dataNascimento=?, altura=?, peso=? WHERE id=?";
            stmt = conecta.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getDataMatricula());
            stmt.setString(3, a.getEndereco());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getDataNascimento());
            stmt.setFloat(6, a.getAltura());
            stmt.setFloat(7, a.getPeso());
            stmt.setInt(8, a.getId());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void excluirAluno(AlunoBean a){
        try{
            String sql = "DELETE FROM aluno WHERE id=?";
            stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, a.getId());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
