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
    <h1>Skrzynka pocztowa</h1>
    <table border="black">
        <tr>
            <td><a href="/message/received/${currentUser.id}"> Otrzymane </a></td>
            <td><a href="/message/send/${currentUser.id}"> Wysłane </a></td>
        </tr>
    </table>
</section>
<hr>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
