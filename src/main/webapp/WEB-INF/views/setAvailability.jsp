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
    <label>Start hour:
        <select name="startHour">
            <c:forEach begin="0" end="23" var="hour">
                <option value="${hour}">${hour}</option>
            </c:forEach>
        </select>
        <label>End hour:
            <select name="endHour">

                <c:forEach begin="0" end="23" var="hour">
                    <option value="${hour}">${hour}</option>
                </c:forEach>
            </select>
        </label>
        <label>Day of week:
                <c:forEach items="${dayList}" var="day">
                    <label>(${day.shortName}:
                    <input type="checkbox" name="${day.shortName}" value="${day.id}"/>
                        )
                    </label>
                </c:forEach>
        </label>
        <button type="submit">Dodaj</button>
</form>
</body>
</html>
