/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Vendedor;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author silva
 */
public class VendedorVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        //Obtêm a operação executada
        String operacao = request.getParameter("operacao");
        Vendedor vendedor = new Vendedor();
        switch (operacao) {
            case "SALVAR": {
                String nome = request.getParameter("nome");

                String email = request.getParameter("email");

                String stelefone = request.getParameter("telefone");
                int telefone = Integer.parseInt(stelefone);
                
                String cpf = request.getParameter("cpf");
                
                

                String senha = request.getParameter("senha");

                vendedor.setNome(nome);
                vendedor.setEmail(email);
                vendedor.setTelefone(telefone);
                vendedor.setSenha(senha);
                vendedor.setCpf(cpf);

                break;
            }
            case "VISUALIZAR": {
                String nome = request.getParameter("nome");
                vendedor.setNome(nome);
                break;
            }
            case "EXCLUIR": {
               
                String nome = request.getParameter("nome");
                vendedor.setNome(nome);
                break;
            }
            case "CONSULTAR": {
                
                String email = request.getParameter("email");
                vendedor.setEmail(email);
                
                String senha = request.getParameter("senha");
                vendedor.setSenha(senha);
                
                break;
            }
            default:
                break;
        }

        return vendedor;

    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("listaVendedor", resultado.getEntidades());

        request.getRequestDispatcher("AreaVendedor.jsp").forward(request, response);

    }

}

