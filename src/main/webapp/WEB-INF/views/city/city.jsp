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
<section>
    <h1>Lista miast</h1>
    <table border="black">
        <c:forEach items="${cityList}" var="city">
            <form>
                <tr>
                    <td>${city.name}</td>
                    <td>${city.province.name}</td>
                    <td><a href="/city/edit/${city.id}"> Edytuj </a></td>
                    <td><a href="/city/delete/${city.id}"> Usuń </a></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</section>
<hr>
<a href="<c:url value="/city/add"/>">Dodaj miasto</a>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
