<%-- 
    Document   : cadastropessoas
    Created on : 27 de ago de 2023, 19:45:33
    Author     : Caio Gustavo
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
                <form action="/WorkBook/SalvarPessoa" method="post">
                    <input type="text" id="nome" name="nome" class="form-field" placeholder="Nome" required>
                    <input type="date" id="dataNascimento" name="dtNascimento" class="form-field" required>
                    <input type="text" id="cidade" name="cidade" class="form-field" placeholder="Cidade" required>
                    <div class="button-container">
                        <div id="divBotaoNovo"></div>
                        <div id="divBotoes"></div>
                    </div>
                </form>
            </div>

            <h2>Registros de Pessoas</h2>

            <div class="table-container">
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>Cidade</th>
                        <th>Ações</th>
                    </tr>
                    <c:forEach var="pessoa" items="${listaPessoas}" varStatus="id">
                        <tr id="${pessoa.id}">
                            <td onclick="selecionar(${pessoa.id})">${pessoa.nome}</td>
                            <td>
                              
                            <fmt:formatDate value="${pessoa.dtNascimento}" pattern="dd/MM/yyyy" />
                            </td>
                            <td onclick="selecionar(${pessoa.id})" >${pessoa.cidade}</td>
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
