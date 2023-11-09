<%-- 
    Document   : AreaVendedor
    Created on : 8 de nov. de 2023, 22:12:32
    Author     : silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Área do Vendedor - Livraria</title>
    <link rel="stylesheet" href="css/AreaVendedor.css">
</head>
<body>
    <header>
        <h1>Área do Vendedor</h1>
    </header>

    <div class="container">
        <aside class="sidebar">
            <h2>Menu</h2>
            <ul>
                <li><a href="#">Meus Livros</a></li>
                <li><a href="Cadastrolivro.jsp">Adicionar Novo Livro</a></li>
                <li><a href="#">Estatísticas de Vendas</a></li>
                <!-- Adicione mais opções de menu conforme necessário -->
            </ul>
        </aside>

        <main class="main-content">
            <section class="my-books">
                <h2>Meus Livros</h2>
                <!-- Aqui podem ser exibidos os livros do vendedor -->
            </section>

            <!-- Outras seções para adicionar novos livros, estatísticas, etc. -->
        </main>
    </div>
</body>
</html>