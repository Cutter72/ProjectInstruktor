<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Kategorie</title>
</head>
<body>
<p>Czy napewno chcesz usunąć kategorię ${categoryToRemove.name}?</p>
<form method="post">
    <input type="submit" value="USUŃ" >
</form>
<hr>
<button><a href="<c:url value="/category"/>">Powrót</a></button>
</body>
</html>
