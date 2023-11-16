<%-- 
    Document   : Login
    Created on : 13 de nov. de 2023, 07:37:10
    Author     : silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/login.css"/>
  <link rel="stylesheet" href="css/footer.css"/>
  <title>Login Form</title>
</head>
<body>

    <form action="/WorkBook/ConsultarVendedor" method="post">
    <label for="email">Username:</label>
    <input type="email" id="email" name="email" required>

    <label for="senha  ">Password:</label>
    <input type="password" id="senha" name="senha" required>

    <button type="submit" id="operacao" name="operacao" value="CONSULTAR">Login</button>
    
    <a href="CadastroVendedor.jsp ">cadastrar-se</a>
    
    <a href="#">esqueci a senha</a>
  </form>
    

</body>
</html>
