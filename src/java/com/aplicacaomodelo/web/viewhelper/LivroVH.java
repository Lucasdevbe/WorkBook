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

                livro.setNome(nome);
                livro.setAutor(autor);
                livro.setEditora(editora);

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
        
        if ("salvar".equals(operacao)) {
            
            request.getRequestDispatcher("CadastroLivro.jsp").forward(request, response);
            
        } else if ("CONSULTAR".equals(operacao)) {
            request.getRequestDispatcher("AreaVendedor.jsp").forward(request, response);
        }
{
            
        }

    }
}

    
    


        
    


