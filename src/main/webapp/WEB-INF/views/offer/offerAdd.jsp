<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/navbar.jsp"/>
<jsp:include page="../components/sidebar.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">Dodaj ofertę</div>
                <div class="panel-body">
                    <form:form method="post"
                               modelAttribute="offer" role="form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Tytuł</label>
                                <form:input path="title" class="form-control"/>
                                <form:errors path="title" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Minuty</label>
                                <form:input path="minutes" class="form-control"/>
                                <form:errors path="minutes" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Cena</label>
                                <form:input path="price" class="form-control"/>
                                <form:errors path="price" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Kategorie</label>
                                <form:select path="category" class="form-control">
                                    <form:options items="${categories}" itemLabel="name"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Opis</label>
                                <form:textarea path="description" class="form-control" rows="5"/>
                                <form:errors path="description" class="form-group has-error"/>
                            </div>
                            <div class="col-md-6">
                                <button type="submit" class="btn btn-primary">Dodaj</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div><!-- /.panel-->
    </div><!-- /.col-->


<jsp:include page="../components/footer.jsp"/>