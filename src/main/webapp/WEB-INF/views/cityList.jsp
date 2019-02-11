<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>City List</title>
</head>
<body>
<h1>City List</h1>
<c:forEach items="${cityList}" var="city">
    ${city.name} - ${city.province.name}<br>
</c:forEach>
</body>
</html>
