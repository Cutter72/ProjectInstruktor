<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lumino - Login</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/datepicker3.css" rel="stylesheet">
    <link href="../../resources/css/styles.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="../../resources/js/html5shiv.js"></script>
    <script src="../../resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">Dodaj Usera</div>
                <div class="panel-body">
                    <form:form method="post"
                               modelAttribute="user" role="form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Imię</label>
                                <form:input path="firstName" class="form-control"/>
                                <form:errors path="firstName" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Nazwisko</label>
                                <form:input path="lastName" class="form-control"/>
                                <form:errors path="lastName" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Username</label>
                                <form:input path="username" class="form-control"/>
                                <form:errors path="username" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <form:input path="password" class="form-control"/>
                                <form:errors path="password" class="form-group has-error"/>
                            </div>
                            <div class="form-group">
                                <label>email</label>
                                <form:input path="email" class="form-control"/>
                                <form:errors path="email" class="form-group has-error"/>
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
</div>
<script src="../../resources/js/jquery-1.11.1.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>