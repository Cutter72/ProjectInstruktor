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
<p>Edytuj Kategorię</p>
<form:form method="post"
           modelAttribute="category">
    <p>Nazwa kategorii: </p>
    <form:input path="name"/>
    <form:errors path="name"/>
    <p>Główna kategoria: </p>
    <form:select path="parent.id">
        <form:options items="${mainCategories}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:errors path="parent"/>
    <p><input type="submit" value="EDYTUJ"></p>
</form:form>
<hr>
<button><a href="<c:url value="/category"/>">Powrót</a></button>
</body>
</html>
