<%-- 
    Document   : index
    Created on : 7 de nov. de 2023, 17:50:24
    Author     : silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<script src="js/index.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

    <head>
        <link rel="stylesheet" href="css/index.css"/>
        <link rel="stylesheet" href="css/footer.css"/>
    <header>
        <h1>WorkBook</h1>
        <nav>
            <div class="menu-icon">&#9776;</div>
            <ul class="nav-links">
                <li><a href="AreaVendedor.jsp">Página Inicial</a></li>
                <li><a href="#">Livros</a></li>
                <li><a href="#">Categorias</a></li>
                <li><a href="#">Contato</a></li>
                <li><a href="Login.jsp">vendedor</a></li>

            </ul>
        </nav>
    </header>
</head>
<body onload="ListarLivros()">
    <main>
        <c:forEach var="livros" items="${listaLivros}" varStatus="id">
            <div id="livros">
                <section class="book">
                    <img src="livro1.jpg" alt="Livro 1">
                    <h2>${livros.nome}</h2>
                    <p>Autor do Livro 1</p>
                    <p class="price">R$ 25,00</p>
                    <button>Adicionar ao Carrinho</button>
                </section>
            </div>

            </div><!-- Adicione mais sections para mais livros -->
    </c:forEach>
    </main>

    <footer>
        <p>&copy; 2023 Livraria Online</p>
    </footer>
</body>

