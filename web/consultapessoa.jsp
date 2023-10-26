<%-- 
    Document   : consultapessoa
    Created on : 22 de ago de 2023, 22:14:35
    Author     : Caio Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultados da Consulta</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.6/jquery.inputmask.min.js"></script>
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
                margin-right: 50px;
                background-color: rgba(255, 255, 255, 0.8);
                padding: 20px;
                border-radius: 10px;
            }

            .result {
                display: flex;
                align-items: center;
                margin-bottom: 10px;
            }

            .result-label {
                font-weight: bold;
                width: 100px;
            }

            .result-input {
                width: 250px;
                padding: 5px;
            }

            .button {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                cursor: pointer;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="result">
                <label class="result-label" for="nome">Nome:</label>
                <input class="result-input" type="text" id="nome" name="nome" value="${nome}" required>
            </div>
            <div class="result">
                <label class="result-label" for="dtNascimento">Data Nascimento:</label>
                <input class="result-input" type="text" id="dtNascimento" name="dtNascimento" placeholder="dd/mm/aaaa" data-inputmask="'alias': 'dd/mm/yyyy'" value="${dtNascimento}" required>
            </div>
            <div class="result">
                <label class="result-label" for="cidade">Cidade:</label>
                <input class="result-input" type="text" id="cidade" name="cidade" value="${cidade}" required>
            </div>
            <button type="button" class="button" onclick="voltarParaIndex()">Voltar</button>
        </div>

        <script>
            function voltarParaIndex() {
                window.location.href = "index.jsp"; // Substitua com o caminho correto para sua página index
            }
            $(document).ready(function () {
                $('#data').inputmask();
            });
        </script>
    </body>
</html>

