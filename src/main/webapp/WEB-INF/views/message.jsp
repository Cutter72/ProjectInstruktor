<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<jsp:include page="components/header.jsp"/>
<jsp:include page="components/navbar.jsp"/>
<jsp:include page="components/sidebar.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/panel"/>">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Wiadomości</li>
        </ol>
    </div><!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Wiadomości</h1>
        </div>
    </div><!--/.row-->
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-body tabs">
                <ul class="nav nav-pills">
                    <li class="active"><a href="#pilltab1" data-toggle="tab">Odebrane</a></li>
                    <li><a href="#pilltab2" data-toggle="tab">Wysłane</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="pilltab1">
                        <section>
                            <table border="black">
                                <tr>
                                    <td>Od kogo</td>
                                    <td>Tytuł</td>
                                    <td>Data</td>
                                </tr>
                                <c:forEach items="${messageReceived}" var="message">
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
                    </div>
                    <div class="tab-pane fade" id="pilltab2">
                        <section>
                            <table border="black">
                                <tr>
                                    <td>Do kogo</td>
                                    <td>Tytuł</td>
                                    <td>Data</td>
                                </tr>
                                <c:forEach items="${messageSend}" var="message">
                                    <form>
                                        <tr>
                                            <td>${message.recipientUser.firstName} ${message.recipientUser.lastName}</td>
                                            <td>${message.title}</td>
                                            <td>${message.created}</td>
                                            <td><a href="/message/view/${message.id}"> Wyświetl </a></td>
                                        </tr>
                                    </form>
                                </c:forEach>
                            </table>
                        </section>
                    </div>
                </div>
            </div>
        </div><!--/.panel-->
    </div><!-- /.col-->
</div>
<!-- /.col-->


<jsp:include page="components/footer.jsp"/>