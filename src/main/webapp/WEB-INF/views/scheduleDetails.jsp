<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<jsp:include page="components/header.jsp"/>
<jsp:include page="components/navbar.jsp"/>
<jsp:include page="components/sidebar.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/"/>">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Home</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Grafik</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">


            <div class="panel panel-default">
                <div class="panel-heading">
                    Calendar
                    <span class="pull-right clickable panel-toggle panel-button-tab-left"><em
                            class="fa fa-toggle-up"></em></span></div>
                <div class="panel-body">
                    <div id="calendar"></div>
                </div>
            </div>


            <div class="panel panel-default">
                <div class="panel-heading">
                    Mój grafik:
                    <span class="pull-right clickable panel-toggle panel-button-tab-left"><em
                            class="fa fa-toggle-up"></em></span></div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <th class="week-number-cell">Poniedziałek<br/>${pnDate}</th>
                            <th class="week-number-cell">Wtorek<br/>${wtDate}</th>
                            <th class="week-number-cell">Środa<br/>${srDate}</th>
                            <th class="week-number-cell">Czwartek<br/>${czDate}</th>
                            <th class="week-number-cell">Piątek<br/>${ptDate}</th>
                            <th class="week-number-cell">Sobota<br/>${soDate}</th>
                            <th class="week-number-cell">Niedziela<br/>${ndDate}</th>
                        </tr>
                        <tr>
                            <td>
                                <c:forEach items="${pnLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${wtLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${srLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${czLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${ptLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${soLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${ndLessonList}" var="lesson">
                                    <button type="button" class="btn btn-default"
                                            style="width: 72px; margin-bottom: 5px">${lesson.startTime.hour}:00
                                    </button>
                                    <br/>
                                </c:forEach>
                            </td>
                        </tr>

                    </table>
                </div>
            </div>


            <div class="panel panel-default">
                <div class="panel-heading">
                    Ustal swój grafik
                    <span class="pull-right clickable panel-toggle panel-button-tab-left"><em
                            class="fa fa-toggle-up"></em></span></div>
                <div class="panel-body">
                    <fieldset>
                        <form:form method="post" action="/panel/availability/byday/add">
                            <table class="table-condensed">
                                <c:if test="${not empty message}">
                                    <div class="alert">
                                        <h1>${message}</h1>
                                    </div>
                                </c:if>
                                <c:forEach items="${dayList}" var="day">
                                    <tr>
                                        <td><input type="checkbox" name="${day.shortName}" value="${day.id}"/></td>
                                        <td>${day.name}:</td>
                                        <td>
                                            &nbsp;&nbsp;Prowadzę zajęcia od godz.:&nbsp;
                                            <select name="${day.shortName}StartHour">
                                                <c:forEach begin="6" end="22" var="hour">
                                                    <option value="${hour}">${hour}:00</option>
                                                </c:forEach>
                                            </select>

                                            &nbsp;do godz.:&nbsp;
                                            <select name="${day.shortName}EndHour">
                                                <c:forEach begin="6" end="22" var="hour">
                                                    <option value="${hour}">${hour}:00</option>
                                                </c:forEach>
                                            </select>
                                            &nbsp;włącznie.
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <br/>
                            Ważność grafiku w tygodniach:
                            <input type="number" min="1" max="52" step="1" name="expiration"/>
                            &nbsp;&nbsp;&nbsp;
                            <button class="btn btn-primary" type="submit">Ustal*</button>
                            <br/>
                            <p>* UWAGA! Ustalenie grafiku usunie wcześniejsze ustawienia!</p>
                        </form:form>
                    </fieldset>
                </div>
            </div>


        </div><!-- /.panel-->
    </div><!-- /.col-->
</div>

<jsp:include page="components/footer.jsp"/>