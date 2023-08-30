<%@ page import="aplicacao.ClasseDAO" %>
<%@ page import="dominio.Classe" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HTML Header -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Gerenciar Classe</title>
    <link rel="stylesheet" type="text/css" href="styleClasse.css">
</head>
<body>
<div class="page-container">
    <div class="tabbar">
        <a href="index.html">
            <img src="icone-porta.png" alt="Porta" class="tab-icon">
            <span class="tab-text">Voltar</span>
        </a>
    </div>
    <h2>Adicionar Classe</h2>
    <form action="ClasseController?action=add" method="post" class="actor-form">
        Nome: <input type="text" name="nome" required pattern="[A-Za-z ]+" title="Por favor, insira apenas letras" style="width: 50%">
        <br>
        Valor: <input type="number" name="valor" required min="0.1" step="0.1" title="Por favor, insira um número válido" style="width: 30%">
        <br>
        Prazo de devolução (em dias): <input type="number" name="prazoDevolucao" step="1" min="1" required style="width: 20%">
        <input type="submit" class="form-button" value="Adicionar" style="width: 30%">
    </form>
</div>
<br>
<div class="table-container">
    <h2>Lista de Classes</h2>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Valor</th>
            <th>Prazo de Devolução</th>
            <th>Editar</th>
            <th>Excluir</th>
        </tr>
        <% List<Classe> classes = ClasseDAO.getLista();
            if (classes != null) {
                for (Classe classe : classes) { %>
        <tr>
            <td><%= classe.getId() %>
            </td>
            <td><%= classe.getNome() %>
            </td>
            <td><%= classe.getValor() %>
            </td>
            <td><%= classe.getPrazoDevolucao() %>
            <td><a href="ClasseController?action=edit&id=<%= classe.getId() %>">Editar</a></td>
            <td><a href="ClasseController?action=delete&id=<%= classe.getId() %>">Excluir</a></td>
        </tr>
        <% }
        } %>
    </table>
</div>
</body>
</html>