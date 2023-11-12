<%-- 
    Document   : Cadastrolivro
    Created on : 8 de nov. de 2023, 22:17:42
    Author     : silva
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/cadastropessoas.css">
        <script type="text/javascript" src="js/cadastropessoas.js"></script>
        <title>Cadastro de Pessoas</title>
    </head>
    <body onload="iniciar()">
        <div class="container">
            <div class="form-container">
                <form action="/WorkBook/SalvarLivro" method="post">
                    <divi>
                    <label name="nome" >Nome Do Livro</label>
                    <input type="text" id="nome" name="nome" class="form-field"  required>
                    
                    <label name="Autor" >Autor</label>
                    <input type="text" id="Autor" name="autor" class="form-field" required>
                    </div>
                    <div>
                    <label name="nome" >Editora</label>
                    <input type="text" id="Editora" name="editora" class="form-field" required>
                    
                    <label name="nome" >Ano do livro</label>
                    <input type="number" id="ano" name="ano" class="form-field"  required>
                    </div>
            <input class="sa" type="submit" name="operacao" id="operacao" value="SALVAR" >
                </form>
            

            <h2>Registros de Pessoas</h2>

            <div class="table-container">
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>Autor</th>
                        <th>Editora</th>
                        <th>Ano</th>
                        <th>Descrição</th>
                    </tr>
                    <c:forEach var="livros" items="${listaLivros}" varStatus="id">
                        <tr id="${livros.id}">
                            <td onclick="selecionar(${livros.id})">${livros.nome}</td>
                            <td>${livros.autor}</td>
                            <td>${livros.editora} </td>
                            <td>${livros.ano}</td>
                            <td class="action-buttons">
                                <button class="save-button">Editar</button>
                                <button class="delete-button">Excluir</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            </div>
       
    </body>
</html>

