<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Classe</title>
    <link rel="stylesheet" type="text/css" href="styleClasse.css">
</head>
<body>
<h2>Editar Classe</h2>

<div class="page-container">
    <form action="ClasseController?action=atualizar" method="post" class="actor-form" id="meuFormulario">
        <input type="hidden" name="id" value="${classe.getId()}">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required pattern="[A-Za-z ]+" title="Por favor, insira apenas letras" value="${classe.getNome()}" style="width: 50%">
        <br>
        <label for="valor">Valor:</label>
        <input type="number" id="valor" name="valor" required min="0.1" step="0.1" title="Por favor, insira um número válido" value="${classe.getValor()}" style="width: 20%">
        <br>
        <label for="prazo">Prazo de devolução:</label>
        <input type="number" id="prazo" name="prazo" step="1" required min="1" value="${classe.getPrazoDevolucao()}" style="width: 20%">
        <input type="submit" value="Salvar" class="form-button" style="width: 40%">
    </form>

    <br>
    <br>
    <a href="classe.jsp" class="back-button">Voltar para o Gerenciamento de Classe</a>
</div>
</body>
</html>
