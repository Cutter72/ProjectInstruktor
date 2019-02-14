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
            <li class="active">Home</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Profil</h1>
        </div>
    </div><!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">Twoje dane</div>
                <div class="panel-body">
                    <form:form method="post"
                               modelAttribute="currentUser" role="form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Imie</label>
                                <form:input path="firstName" class="form-control"/>
                                <form:errors path="firstName" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Nazwisko</label>
                                <form:input path="lastName" class="form-control"/>
                                <form:errors path="lastName" class="form-group has-error"/>

                            </div>
                            <div class="form-group">
                                <label>E-mail</label>
                                <form:input path="email" class="form-control"/>
                                <form:errors path="email" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Username</label>
                                <form:input path="username" class="form-control"/>
                                <form:errors path="username" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <form:input path="password" type="password" class="form-control"/>
                                <form:errors path="password" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Telefon</label>
                                <form:input path="phoneNumber" class="form-control"/>
                                <form:errors path="phoneNumber" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Video Link</label>
                                <form:input path="videoLink" class="form-control"/>
                                <form:errors path="videoLink" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Facebook Link</label>
                                <form:input path="facebookLink" class="form-control"/>
                                <form:errors path="facebookLink" class="form-group has-error"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Opis</label>
                                <form:textarea path="description" class="form-control" rows="27"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                        <button type="submit" class="btn btn-primary">Edytuj</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div><!-- /.panel-->
    </div><!-- /.col-->


<jsp:include page="../components/footer.jsp"/>