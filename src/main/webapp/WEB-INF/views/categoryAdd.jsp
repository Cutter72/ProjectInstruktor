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
<p>Dodaj Kategorię</p>
<form:form method="post"
           modelAttribute="category">
    <p>Nazwa kategorii: </p>
    <form:input path="name"/>
    <form:errors path="name"/>
    <p>Główna kategoria: </p>
    <form:select path="parent.id">
        <form:options items="${mainCategories}" itemLabel="name" itemValue="id"/>
    </form:select>
    <input type="submit" value="DODAJ">
</form:form>
<hr>
<button><a href="<c:url value="/category"/>">Powrót</a></button>
</body>
</html>
