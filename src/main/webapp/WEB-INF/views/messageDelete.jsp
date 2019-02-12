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
<p>Czy napewno chcesz usunąć wiadomość ${messageToRemove.title}?</p>
<form method="post">
    <input type="submit" value="USUŃ" >
</form>
<hr>
<a href="<c:url value="/message/${currentUser.id}"/>">Powrót</a>
</body>
</html>
