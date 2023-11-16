<%-- 
    Document   : AlterarLivro
    Created on : 15 de nov. de 2023, 13:58:10
    Author     : silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css"/>
        
        <title>JSP Page</title>
    </head>
    <body>
        <header >
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
        <main> 
            <div class="container">
            <c:forEach   var="livro" items="${listaLivros}" varStatus="id">
                <form action="/WorkBook/AlterarLivro" method="post">
                   

                    <div class="formulario" " >
                            <label name="nome" >Nome Do Livro</label>
                            <input type="text" id="nome" name="nome" class="form-field"placeholder="${livro.nome}" value="${livro.nome}" >

                            <label name="Autor" >Autor</label>
                            <input type="text" id="Autor" name="autor" class="form-field" placeholder="${livro.autor}"  value="${livro.autor}">
                        </div>
                        <div class="formulario">
                            <label name="editora" >${livro.editora}</label>
                            <input type="text" id="Editora" name="editora" class="form-field" placeholder="${livro.editora}" value="${livro.editora}" >

                            <label name="ano" >Ano do livro</label>
                            <input type="number" id="ano" name="ano" class="form-field" placeholder="${livro.ano}" value="${livro.ano}"  >

                        </div >
                        <div class="formulario">
                            <label name="descricao" >Descrição</label>
                            <input type="text" id="descricao" name="descricao" class="form-field_input"  value="${livro.descricao}" >
                        </div>
                    
                        <button type="submit"  onclick="alterar(livro.id) class="alterar_buttom" nome="operacao" id="operacacao" value="ALTERAR" >Alterar</button>
            </div>
                </c:forEach>
            </form>
            <div class="table-container" ">
                <table class="table">
                    <tr>
                       
                        <th>Nome</th>
                        <th>Autor</th>
                        <th>Editora</th>
                        <th>Ano</th>
                        <th>Descricao</th>
                    </tr>
                    <c:forEach   var="livro" items="${listaLivros}" varStatus="id">
                    <tr id="${livro.id}">   
                        
                        <td ">${livro.nome}</td>
                        <td>${livro.autor}</td>
                        <td>${livro.editora}</td> 
                        <td onclick="selecionar(${livro.id})">${livro.ano}</td>
                        <td>${livro.descricao}</td>

                    </tr>
                    </c:forEach>
                </table>
            </div>

        </main>
    </body>
</html>
