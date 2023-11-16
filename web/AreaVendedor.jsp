<%-- 
    Document   : AreaVendedor
    Created on : 8 de nov. de 2023, 22:12:32
    Author     : silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Área do Vendedor - Livraria</title>
    <link rel="stylesheet" href="css/AreaVendedor.css">
    
    <script type="text/javascript" src="js/cadastropessoas.js"></script>
</head>
<body onload="consultar()" >
    <header>
        <c:forEach   var="vendedor" items="${listaVendedor}" varStatus="id">
                <p>Olá, ${vendedor.nome} seja bem-vindo </p>
                    </c:forEach>
    </header>

    <div class="container">
        <aside class="sidebar">
            <h2>Menu</h2>
            
            
            
            <ul>
                
                <button onclick="consultar()"  type="submit" id="operacao" name="operacao" value="CONSULTAR" class="button">MEUS lIVROS</button>
                <li><a href="Cadastrolivro.jsp">Adicionar Novo Livro</a></li>
                <li><a href="#">Estatísticas de Vendas</a></li>
                <!-- Adicione mais opções de menu conforme necessário -->
            </ul>
        </aside>

        <main class="main-content" onload="consultar()">
            <section class="my-books">
                
                <div class="table-container">
                
                    <form action="/WorkBook/VisualizarLivro" method="post">
                        <div class="input-container">
                     <label for="nome">Nome do Livro:</label>
                    <input type="text" id="nome" name="nome" class="input-field" required>
                    <button type="submit" id="operacao" name="operacao" value="VISUALIZAR" class="button">Pesquisar</button>
                    <output id="msg" for="nome" >${msg}</output>
                        </div>
                    </form>
                        
                        <div class="table-container" ">
                <table>
                    <tr>
                        <th></th>
                        <th>Nome</th>
                        <th>Autor</th>
                        <th>Editora</th>
                        <th>ano</th>
                    </tr>
                    <c:forEach   var="livro" items="${listaLivros}" varStatus="id">
                        <td><input type="checkbox" name="selecionar" onclick="selecionar(${livro.id})></td>
                        <tr id="${livro.id}">
                            
                            <td ">${livro.nome}</td>
                            
                            <td>${livro.autor}</td>
                             <td>${livro.editora}</td> 
                            
                            <td onclick="selecionar(${livro.id})">${livro.ano}</td>
                            <td class="action-buttons">
                                <button onclick="Vis_alterar(${livro.id})" class="save-button">Editar</button>
                                <button onclick="excluir(${livro.id})"  class="delete-button">Excluir</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <!-- Outras seções para adicionar novos livros, estatísticas, etc. -->
        </main>
    </div>
</body>
</html>