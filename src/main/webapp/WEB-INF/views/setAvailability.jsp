<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8"/>
    <title>Set Availability By Day</title>
</head>
<body>
<h1>Set Availability By Day</h1>
<form action="" method="post">


    <label>Day of week:<br/>
        <c:forEach items="${dayList}" var="day">
            <label>(${day.shortName}:<input type="checkbox" name="${day.shortName}" value="${day.id}"/>)</label>
            <label>Start hour:
                <select name="${day.shortName}StartHour">
                    <c:forEach begin="6" end="22" var="hour">
                        <option value="${hour}">${hour}:00</option>
                    </c:forEach>
                </select>
            </label>
            <label>End hour:
                <select name="${day.shortName}EndHour">
                    <c:forEach begin="6" end="22" var="hour">
                        <option value="${hour}">${hour}:00</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
        </c:forEach>
    </label>

    <label>Expiration in weeks:
        <input type="number" min="1" max="51" step="1" name="expiration"/>
        weeks, max 51.
    </label>
    <button type="submit">Dodaj*</button><br/>
    <p>* - UWAGA! dodanie grafiku usunie wczesniejsze ustawienia</p>
</form>
</body>
</html>
