/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Livro;
import com.aplicacaomodelo.domain.Pessoa;
import com.aplicacaomodelo.domain.Vendedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author silva
 */
public class LivroDAO extends AbstractJdbcDAO {

    public LivroDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }

    public LivroDAO(String table, String idTable) {
        super("TB_LIVRO", "ID_LIVRO");
    }

    public LivroDAO(Connection cx) {
        super(cx, "TB_LIVRO", "ID_LIVRO");
    }

    public LivroDAO() {
        super("TB_LIVRO", "ID_LIVRO");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        if (connection == null) {
            openConnection();
        }
        PreparedStatement pst = null;
        Livro p = (Livro) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO tb_Livros (nome, autor, editora, ano, descricao, categoria ) VALUES (?,?,?,?,?,?)");

            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, p.getNome());
            pst.setString(2, p.getAutor());
            pst.setString(3, p.getEditora());

            pst.setInt(4, p.getAno());
            pst.setString(6, p.getCategoria());
            pst.setString(5, p.getDescricao());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idLivro = 0;
            if (rs.next()) {
                idLivro = rs.getInt(1);
            }

            p.setId(idLivro);

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
         if (connection == null) {
            openConnection();
        }
        PreparedStatement pst = null;
        Livro p = (Livro) entidade;

        try {
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("update tb_livros set nome = ?, autor = ?,editora= ?,ano = ?,descricao = ?  where id_pessoa = ?; ");

            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            pst.setInt(6, p.getId());
            pst.setString(1, p.getNome());
            pst.setString(2, p.getAutor());
            pst.setString(3, p.getEditora());

            pst.setInt(4, p.getAno());
            pst.setString(5, p.getDescricao());
            

            pst.executeUpdate();

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
    public void excluir(EntidadeDominio entidade) {
        openConnection();

        Livro livro = (Livro) entidade;

        PreparedStatement pst = null;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append("tb_Livros");
        sb.append(" WHERE ");
        sb.append("id_pessoa");
        sb.append("=");
        sb.append("?");
        try {

            connection.setAutoCommit(false);
            pst = connection.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, livro.getId());

            pst.executeUpdate();
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
                if (ctrlTransaction) {
                    connection.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        if (connection == null) {
            openConnection();
        }
        PreparedStatement ps = null;

        List<EntidadeDominio> Livro = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tb_Livros ";

            ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Livro p = new Livro();
                Vendedor v = new Vendedor();

                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                p.setAutor(rs.getString("autor"));
                p.setEditora(rs.getString("editora"));

                int ano = p.getAno();
                p.setAno(rs.getInt("ano"));

                Livro.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                if (ctrlTransaction) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Livro;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {

         if(connection == null){
            openConnection();
        }
        Livro livro = (Livro) entidade;
        
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_livros WHERE nome=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, livro.getNome());
            
             try (ResultSet rs = ps.executeQuery()) {
                 if(rs.next()){
                     
                     livro.setId(rs.getInt("id_pessoa"));
                     livro.setNome(rs.getString("nome"));
                     livro.setEditora(rs.getString("editora"));
                     livro.setAutor(rs.getString("autor"));
                     livro.setDescricao(rs.getString("descricao"));
                     
                     livro.setAno(rs.getInt("ano"));
                     
                     
                     
                     
                     
                 }
                 
                 ps.close();
             }
            if(ctrlTransaction){
                connection.close();
            }
            
            
        } catch (SQLException e) {
        }
        
        return livro;
    } 
    private Time getTime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
