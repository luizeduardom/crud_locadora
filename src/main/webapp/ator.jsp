<!-- HTML Header -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gerenciar Atores</title>
</head>
<body>
<!-- Display a form to add a new actor -->
<h2>Adicionar Ator</h2>
<form action="AtorController?action=add" method="post">
    Nome: <input type="text" name="nome">
    Classe: <!-- Dropdown to select class -->
    <input type="submit" value="Adicionar">
</form>

<!-- Display a list of actors -->
<h2>Lista de Atores</h2>
<table>
    <tr>
        <th>Nome</th>
        <th>Classe</th>
    </tr>
    <!-- Iterate through actors and display them -->
</table>
</body>
</html>