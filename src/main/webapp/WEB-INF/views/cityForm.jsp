<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>City Form</title>
</head>
<body>
<h1>City Form</h1>
<form:form modelAttribute="city">
    <form:input path="name"/>
    <form:errors path="name"/>
    <form:select path="province" items="${provinceList}" itemLabel="name" itemValue="id"/>
    <input type="submit" value="Dodaj miasto">
</form:form>
</body>
</html>
