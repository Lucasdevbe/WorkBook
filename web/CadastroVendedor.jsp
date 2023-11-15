<%-- 
    Document   : CadastroVendedor
    Created on : 13 de nov. de 2023, 07:46:23
    Author     : silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
Copy code
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/CadastroVendedor.css"/>
  <style>
 
  </style>
  <title>Cadastro de Vendedor</title>
</head>
<body>
    
    <div><p>Olá, seja bem-vindo, comece sua jornada como leitor e vendedor aqui</p></div>
        

    <form action="/WorkBook/SalvarVendedor" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required>

    <label for="telefone">Telefone:</label>
    <input type="tel" id="telefone" name="telefone" required>
    
    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf" required>
    
    <label for="senha">senha:</label>
    <input type="password" id="senha" name="senha" required>
    
    <button type="submit" id="operacao"  name="operacao" value="SALVAR">Cadastrar</button>
  </form>

</body>
</html>
