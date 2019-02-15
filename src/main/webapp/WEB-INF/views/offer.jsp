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
            <li class="active">Oferty</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Oferty</h1>
        </div>
    </div><!--/.row-->
    <button type="button" class="btn btn-md btn-primary"><a class="btn btn-md btn-primary"
                                                            href="<c:url value="/panel/offer/add"/>">Dodaj nową
        ofertę</a></button>
    <c:forEach items="${offers}" var="offer">
        <div class="panel panel-default">
            <div class="panel-heading">
                Dodano: <javatime:format value="${offer.created}" style="MM" />
                <span class="pull-right clickable panel-toggle panel-button-tab-left"><em class="fa fa-toggle-up"></em></span>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="" method="post">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Tytuł</label>
                            <div class="col-md-9">
                                    ${offer.title}
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">Minuty</label>
                            <div class="col-md-9">
                                    ${offer.minutes}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Cena</label>
                            <div class="col-md-9">
                                    ${offer.price}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Kategoria</label>
                            <div class="col-md-9">
                                    ${offer.category.name}
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">Opis</label>
                            <div class="col-md-9">
                                ${offer.description}
                            </div>
                        </div>

                        <!-- Form actions -->
                        <div class="form-group">
                            <div class="col-md-3 widget-right">
                                <a class="btn btn-md btn-primary" href="<c:url value="/panel/offer/edit/${offer.id}"/>">Edytuj</a>
                            </div>
                            <div class="col-md-3 widget-right">
                                <a class="btn btn-md btn-primary" href="<c:url value="/panel/offer/delete/${offer.id}"/>">Usuń</a>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<!-- /.col-->


<jsp:include page="components/footer.jsp"/>