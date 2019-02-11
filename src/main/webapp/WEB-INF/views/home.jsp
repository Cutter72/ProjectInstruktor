<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Home</title>
</head>
<body>
<h1>Witaj!</h1>

<a href="<c:url value="/category"/>">Do kategorii</a>
<a href="<c:url value="/city"/>">Do miast</a>
</body>
</html>
