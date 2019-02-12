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
    <h3>Wiadomość otrzymana od ${messageToView.senderUser.firstName}:</h3>
    <table>
        <tr>
            <td>${messageToView.title}</td>
            <td>${messageToView.created}</td>
        </tr>
        <tr>
            <td>${messageToView.messageText}</td>
        </tr>
    </table>
    <table>
        <td><a href="/message/response/${messageToView.id}"> Odpowiedz </a></td>
        <td><a href="/message/delete/${messageToView.id}"> Usuń </a></td>
    </table>
    <hr>
    <a href="<c:url value="/message/${currentUser.id}"/>">Powrót</a>
</body>
</html>
