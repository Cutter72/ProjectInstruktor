<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Skrzynka</title>
</head>
<body>
<section>
    <h1>Lista wiadomości</h1>
    <table border="black">
        <tr>
            <td>Do kogo</td>
            <td>Tytuł</td>
            <td>Data</td>
        </tr>
        <c:forEach items="${messageList}" var="message">
            <form>
                <tr>
                    <td>${message.recipientUser.firstName} ${message.recipientUser.lastName}</td>
                    <td>${message.title}</td>
                    <td>${message.created}</td>
                    <td><a href="/panel/message/view/${message.id}"> Wyświetl </a></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</section>
<hr>
<a href="<c:url value="/panel/message"/>">Powrót</a>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
