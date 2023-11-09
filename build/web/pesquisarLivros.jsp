<%-- 
    Document   : index
    Created on : 22 de ago de 2023, 21:21:05
    Author     : Caio Gustavo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Consulta</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            background-image: url("imagens/imgindex.png");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }

        .container {
           margin-top: 200px;
           margin-right: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Cor de fundo semi-transparente */
            padding: 20px;
            border-radius: 10px;
        }

        .input-container {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }

        .input-field {
            width: 250px;
            padding: 5px;
            margin-top: 5px; /* Espaçamento entre label e input */
        }

        .button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form">
            <form action="/WorkBook/VisualizarPessoa" method="post">
                <div class="input-container">
                    <label for="nome">Nome da Pessoa:</label>
                    <input type="text" id="nome" name="nome" class="input-field" required>
                    <button type="submit" id="operacao" name="operacao" value="VISUALIZAR" class="button">Pesquisar</button>
                    <output id="msg" for="nome" >${msg}</output>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
