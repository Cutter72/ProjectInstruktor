<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Grafik</title>
</head>
<body>
<section>
    <h1>Grafik</h1>
    <table border="black">
        <c:forEach begin="8" end="16" var="n">
            <tr>
                <td>${n}:00</td>
                <c:forEach begin="1" end="7" var="n2">
                    <td>${n2*n}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</section>
<hr>
<a href="<c:url value="/lesson/add"/>">Dodaj lekcję</a>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
