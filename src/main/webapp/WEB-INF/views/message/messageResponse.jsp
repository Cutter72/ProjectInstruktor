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
    <h3>Wiadomość otrzymana od ${messageToResponse.senderUser.firstName}:</h3>
    <table>
        <tr>
            <td>${messageToResponse.title}</td>
            <td>${messageToResponse.created}</td>
        </tr>
        <tr>
            <td>${messageToResponse.messageText}</td>
        </tr>
    </table>
    <p>Twoja wiadomość:</p>
    <form:form method="post"
               modelAttribute="message">
    <p>Tytuł: </p>
        <form:input path="title"/>
        <form:errors path="title"/>
    <p>Treść wiadomości: </p>
        <form:hidden path="id"/>
        <form:textarea path="messageText"/>
        <form:errors path="messageText"/>
        <form:hidden path="recipientUser" value="${messageToResponse.senderUser.id}"/>
        <form:hidden path="senderUser" value="${currentUser.id}"/>
        <form:hidden path="parent" value="${messageToResponse.id}"/>
    <p><input type="submit" value="WYŚLIJ"></p>
    </form:form>
    <hr>
    <a href="<c:url value="/panel/message"/>">Powrót</a>
</body>
</html>
