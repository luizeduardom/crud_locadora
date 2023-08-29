<%@ page import="DAO.AtorDAO" %>
<%@ page import="dominio.Ator" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HTML Header -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Gerenciar Ator</title>
    <link rel="stylesheet" type="text/css" href="styleAtor.css">
</head>
<body>
<div class="page-container">
    <div class="tabbar">
        <a href="index.html">
            <img src="icone-porta.png" alt="Porta" class="tab-icon">
            <span class="tab-text">Voltar</span>
        </a>
    </div>
    <h2>Adicionar Ator</h2>
    <form action="AtorController?action=add" method="post" class="actor-form">
        Nome: <input type="text" name="nome" required pattern="[A-Za-z ]+" title="Por favor, insira apenas letras" style="width: 50%" >
        <input type="submit" class="form-button" value="Adicionar" style="width: 30%">
    </form>
</div>
<br>
<div class="table-container">
    <h2>Lista de Atores</h2>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Editar</th>
            <th>Excluir</th>
        </tr>
        <% List<Ator> atores = AtorDAO.getLista();
            if (atores != null) {
                for (Ator ator : atores) { %>
        <tr>
            <td><%= ator.getId() %>
            </td>
            <td><%= ator.getNome() %>
            </td>
            <td><a href="AtorController?action=edit&id=<%= ator.getId() %>">Editar</a></td>
            <td><a href="AtorController?action=delete&id=<%= ator.getId() %>">Excluir</a></td>
        </tr>
        <% }
        } %>
    </table>
</div>
</body>
</html>