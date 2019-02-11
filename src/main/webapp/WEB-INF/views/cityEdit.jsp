<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Miasta</title>
</head>
<body>
<p>Edytuj Miasto</p>
<form:form method="post"
           modelAttribute="city">
    <p>Nazwa miasta: </p>
    <form:input path="name"/>
    <form:errors path="name"/>
    <form:select path="province" items="${provinceList}" itemLabel="name" itemValue="id"/>
    <p><input type="submit" value="EDYTUJ"></p>
</form:form>
<hr>
<button><a href="<c:url value="/city"/>">Powrót</a></button>
</body>
</html>
