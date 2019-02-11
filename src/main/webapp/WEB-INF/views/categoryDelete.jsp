<%--
  Created by IntelliJ IDEA.
  User: krystian
  Date: 05.02.19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
