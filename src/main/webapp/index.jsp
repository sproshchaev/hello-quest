<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Космический квест</title>
</head>
<body>
<h1>Добро пожаловать на борт!</h1>
<p>Вы стоите в космическом порту. Принять вызов НЛО?</p>

<% if (request.getAttribute("message") != null) { %>
<p style="color: red;"><%= request.getAttribute("message") %></p>
<% } %>

<form action="game" method="post">
    <input type="radio" name="answer" value="accept"> Принять вызов<br>
    <input type="radio" name="answer" value="decline"> Отклонить вызов<br>
    <input type="submit" value="Ответить">
</form>
</body>
</html>