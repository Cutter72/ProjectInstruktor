<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Lekcja</title>
</head>
<body>
<section>
    <h1>Lista lekcji</h1>
    <table border="black">
        <c:forEach items="${lessonList}" var="lesson">
            <form>
                <tr>
                    <td>${lesson.dayOfWeek}</td>
                    <td>${lesson.date}</td>
                    <td><a href="/lesson/delete/${lesson.id}"> Usuń </a></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</section>
<hr>
<a href="<c:url value="/lesson/add"/>">Dodaj lekcję</a>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
