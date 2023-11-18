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
    <title>Área do Vendedor - WookBook</title>
    <link rel="stylesheet" href="css/AreaVendedor.css">
    
    
    <script type="text/javascript" src="js/cadastropessoas.js"></script>
</head>
<body onload="consultar()" >
    <header>
        <c:forEach   var="vendedor" items="${listaVendedor}" varStatus="id">
                <p>Olá, ${vendedor.nome} seja bem-vindo </p>
                
                    </c:forEach>
                <h1>WorkBook</h1>
            <nav>
                <div class="menu-icon">&#9776;</div>
                <ul class="nav-links">
                    <li><a href="/WorkBook/ConsultarLivro">Página Inicial</a></li>
                    <li><a href="#">Livros</a></li>
                    <li><a href="#">Categorias</a></li>
                    <li><a href="#">Contato</a></li>


                </ul>
            </nav>
    </header>

    <div class="container">
        <aside class="sidebar">
            <h2>Menu</h2>
            
            
            
            <ul>
                <li><div class="Furos"></div><button onclick="consultar()"  type="submit" id="operacao" name="operacao" value="CONSULTAR" class="sidebar_menu">Meus Livros</button></li>
                <li><div class="Furos"></div><button class="sidebar_menu"><a href="Cadastrolivro.jsp">Adicionar Novo Livro</a></button></li>
                <li><div class="Furos"></div><button class="sidebar_menu"><a href="#">Estatísticas de Vendas</a></button></li>
                <!-- Adicione mais opções de menu conforme necessário -->
            </ul>
        </aside>

        <main class="main-content" ">
            <section class="my-books">
                
                <div class="table-container">
                
                    <form action="/WorkBook/VisualizarLivro" method="post">
                        <div class="input-container" >
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
                        <th>categoria</th>
                        <th>ano</th>
                    </tr>
                    <c:forEach   var="livro" items="${listaLivros}" varStatus="id">
                        <td><input type="checkbox" name="selecionar" onclick="selecionar(${livro.id})></td>
                        <tr id="${livro.id}">
                            
                            <td ">${livro.nome}</td>
                            
                            <td>${livro.autor}</td>
                             <td>${livro.editora}</td> 
                             <td>${livro.categoria}</td>
                            
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