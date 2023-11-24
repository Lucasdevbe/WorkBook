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
                String categoria = request.getParameter("categoria");
                                
                String sestoque = request.getParameter("estoque");
                int estoque = Integer.parseInt(sestoque);
                                
                String spreco_custo = request.getParameter("preco_custo");
                double preco_custo = Double.parseDouble(spreco_custo);
                
                String spreco_final = request.getParameter("e");
                double preco_final = Double.parseDouble(spreco_final);
                
                livro.setNome(nome);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setDescricao(descricao);

                int ano = Integer.parseInt(sano);
                livro.setAno(ano);
                
                livro.setCategoria(categoria);
                livro.setEstoque(estoque);
                
                

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

                if (request.getParameter("nome") != null) {
                    String nome = request.getParameter("nome");
                    livro.setNome(nome);
                }
                if (request.getParameter("autor") != null) {
                    String autor = request.getParameter("autor");
                    livro.setAutor(autor);
                }
                if (request.getParameter("editora") != null) {
                    String editora = request.getParameter("editora");
                    livro.setEditora(editora);
                }
                if (!"".equals(request.getParameter("ano"))) {
                    String sano = request.getParameter("ano");
                    int ano = Integer.parseInt(sano);
                    livro.setAno(ano);
                } else {
                }
                if (request.getParameter("categoria") != null) {
                    String categoria = request.getParameter("categoria");
                    livro.setCategoria(categoria);
                }
                if (request.getParameter("descricao") != null) {
                String descricao = request.getParameter("descricao");
                livro.setDescricao(descricao);
                }

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

        if (null != operacao) {
            switch (operacao) {
                case "SALVAR":
                    request.getRequestDispatcher(".jsp").forward(request, response);
                    break;
                case "CONSULTAR":
                    request.getRequestDispatcher("AreaVendedor.jsp").forward(request, response);
                    break;
                case "EXCLUIR":
                    response.sendRedirect("AreaVendedor.jsp");
                    break;
                case "VISUALIZAR":
                    request.getRequestDispatcher("AreaVendedor.jsp").forward(request, response);

                    break;
                case "ALTERAR":
                    request.getRequestDispatcher("AlterarLivro.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }
    }
}
