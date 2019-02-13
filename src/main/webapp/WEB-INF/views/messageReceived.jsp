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
            <td>Od kogo</td>
            <td>Tytuł</td>
            <td>Data</td>
        </tr>
        <c:forEach items="${messageList}" var="message">
            <form>
                <tr>
                    <td>${message.senderUser.firstName} ${message.senderUser.lastName} </td>
                    <td>${message.title}</td>
                    <td>${message.created}</td>
                    <td><a href="/message/view/${message.id}"> Wyświetl </a></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</section>
<hr>
<a href="<c:url value="/message/${currentUser.id}"/>">Powrót</a>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
