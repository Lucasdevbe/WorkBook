/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.postgresql.util.PGTime;

/**
 *
 * @author Caio Gustavo
 */
public class PessoaDAO extends AbstractJdbcDAO{

    public PessoaDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
     public PessoaDAO(String table, String idTable) {
        super("TB_PESSOA", "ID_PESSOA");
    }
    public PessoaDAO(Connection cx){
        super(cx, "TB_PESSOA", "ID_PESSOA");
    }
    public PessoaDAO(){
        super("TB_PESSOA", "ID_PESSOA");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        Pessoa p = (Pessoa) entidade;
        
        try{
            connection.setAutoCommit(false);
                        
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_pessoa (nome, dt_nascimento, cidade) VALUES (?,?,?)");
            
            
            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
           
            pst.setString(1, p.getNome());            
           
            
            Date time = new Date(p.getDtNascimento().getTime());
            pst.setDate(2,  time);

          
            
            pst.setString(3, p.getCidade());
           
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            int idPessoa=0;
            if(rs.next())
                idPessoa = rs.getInt(1);
            
            p.setId(idPessoa);            
      
            
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }       
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        if(connection == null){
            openConnection();
        }
        PreparedStatement ps = null;
        
        List<EntidadeDominio> pessoas = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM tb_pessoa";
            
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pessoa p = new Pessoa();
                
                Calendar cal = GregorianCalendar.getInstance();
                cal.setTime(rs.getDate("dtNascimento"));
                   
                p.setDtNascimento(cal.getTime());
                
                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                p.setCidade(rs.getString("cidade"));
                
                pessoas.add(p);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                if(ctrlTransaction){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return pessoas;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {
        
        if(connection == null){
            openConnection();
        }
        Pessoa pessoa = (Pessoa) entidade;
        pessoa.setId(0);
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_pessoa WHERE nome=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pessoa.setId(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCidade(rs.getString("cidade"));
                
                                
                pessoa.setDtNascimento(rs.getDate("dt_nascimento"));
                
             
            }
                       
            ps.close();
            rs.close();
            if(ctrlTransaction){
                connection.close();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pessoa;
    } 

    private Time getTime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
