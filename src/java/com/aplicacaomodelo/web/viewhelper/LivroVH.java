/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.web.servlet.Servlet;
import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.core.util.Conexao;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Livro;
import java.sql.Connection;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author silva
 */
public class LivroVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        //Obtêm a operação executada
        String operacao = request.getParameter("operacao");
        Livro livro = new Livro();
        switch (operacao) {
            case "SALVAR": {
                String nome = request.getParameter("nome");
                String autor = request.getParameter("autor");
                String editora = request.getParameter("editora");
                String sano = request.getParameter("ano");
                String descricao = request.getParameter("descricao");

                livro.setNome(nome);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setDescricao(descricao);

                int ano = Integer.parseInt(sano);
                livro.setAno(ano);

                break;
            }

            case "VISUALIZAR": {
                String nome = request.getParameter("nome");
                livro.setNome(nome);

                break;
            }
            case "EXCLUIR": {

                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
                livro.setId(id);
                break;
            }
            case "CONSULTAR": {
                String nome = request.getParameter("nome");
                livro.setNome(nome);
                break;
            }
            case "ALTERAR": {
                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
                livro.setId(id);
                
                String nome = request.getParameter("nome");
                String autor = request.getParameter("autor");
                String editora = request.getParameter("editora");
                String sano = request.getParameter("ano");
                String categoria = request.getParameter("categoria");
                String descricao = request.getParameter("descricao");

                livro.setNome(nome);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setDescricao(descricao);
                livro.setCategoria(categoria);

                int ano = Integer.parseInt(sano);
                livro.setAno(ano);
                
                break;
            }
            default:
                break;
        }

        return livro;

    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("listaLivros", resultado.getEntidades());

        String operacao = request.getParameter("operacao");
        
        String uri = request.getRequestURI();
        
        
        
        if (null != operacao) switch (operacao) {
            case "SALVAR":
                request.getRequestDispatcher("Cadastrolivro.jsp").forward(request, response);
                break;
            case "CONSULTAR":
                request.getRequestDispatcher("AreaVendedor.jsp").forward(request, response);
                break;
            case "EXCLUIR":
                response.sendRedirect("AreaVendedor.jsp");
                break;
            case "VISUALIZAR":
                if(uri.equals("com.aplicacaomodelo.web.servlet.Servlet/Visualizar_alterar"))
                request.getRequestDispatcher("AterarLivro.jsp").forward(request, response);
               
                else{
                    request.getRequestDispatcher("AreaVendedor.jsp").forward(request, response);
                        
                        }
            case "ALTERAR":
                request.getRequestDispatcher("AlterarLivro.jsp").forward(request, response);
                break;
            default:
                break;
        }
}
}
        

    


    
    


        
    


