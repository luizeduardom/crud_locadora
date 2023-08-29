<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Ator</title>
    <link rel="stylesheet" type="text/css" href="styleAtor.css">
</head>
<body>
<h2>Editar Ator</h2>

<div class="page-container">
    <form action="AtorController?action=atualizar" method="post" class="actor-form">
        <input type="hidden" name="id" value="${ator.getId()}" >
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required pattern="[A-Za-z ]+" title="Por favor, insira apenas letras" value="${ator.getNome()}" style="width: 50%" >
        <input type="submit" value="Salvar" class="form-button" style="width: 40%">
    </form>
    <br>
    <br>
    <a href="ator.jsp" class="back-button">Voltar para o Gerenciamento de Ator</a>
</div>
</body>
</html>
