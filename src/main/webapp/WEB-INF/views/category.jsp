<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>
<section>
    <h1>Lista kategorii</h1>
    <table border="black">
        <c:forEach items="${allCategories}" var="category">
            <form>
                <tr>
                    <td>${category.name}</td>
                    <td><a href="/category/edit/${category.id}"> Edytuj </a></td>
                    <td><a href="/category/delete/${category.id}"> Usuń </a></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</section>
<hr>
<a href="<c:url value="/category/add"/>">Dodaj kategorię</a>
<a href="<c:url value="/"/>">Do Strony głównej</a>
</body>
</html>
