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
    <title>Instruktor - Rejestracja</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/datepicker3.css" rel="stylesheet">
    <link href="../../resources/css/styles.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="../../resources/js/html5shiv.js"></script>
    <script src="../../resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="<c:url value="/home"/>"><span>E-</span>Instruktor</a>
            <div class="navbar-nav nav-pills">
                <ul class="nav navbar-top-links ">
                    <li><a href="<c:url value="/home"/>">
                        <span><strong>Strona główna</strong></span>
                    </a>
                    </li>
                </ul>
            </div>
            <div class="navbar-nav nav-pills">
                <ul class="nav navbar-top-links ">
                    <li><a href="<c:url value="/login"/>">
                        <span><strong>Zaloguj</strong></span>
                    </a>
                    </li>
                </ul>
            </div>
            <div class="navbar-nav navbar-right nav-pills">
                <ul class="nav navbar-top-links ">
                    <li><a href="<c:url value="/panel"/>">
                        <span><strong>Panel Instruktora</strong></span>
                    </a>
                    </li>
                </ul>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</nav><!--/.navbar-->
<li class="divider"></li>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Rejestracja</div>
                    <div class="panel-body">
                        <form:form method="post"
                                   modelAttribute="user" role="form">
                            <div class="col-md-12">
                                <div>
                                    <label>Imię</label>
                                    <form:input path="firstName" class="form-control"/>
                                    <form:errors path="firstName" class="form-group has-error"/>
                                </div>
                                <div>
                                    <label>Nazwisko</label>
                                    <form:input path="lastName" class="form-control"/>
                                    <form:errors path="lastName" class="form-group has-error"/>
                                </div>
                                <div>
                                    <label>Username</label>
                                    <form:input path="username" class="form-control"/>
                                    <form:errors path="username" class="form-group has-error"/>
                                </div>
                                <div>
                                    <label>Password</label>
                                    <form:input path="password" class="form-control" type="password"/>
                                    <form:errors path="password" class="form-group has-error"/>
                                </div>
                                <div class="form-group">
                                    <label>E-mail</label>
                                    <form:input path="email" class="form-control"/>
                                    <form:errors path="email" class="form-group has-error"/>
                                </div>
                                <div>
                                    <button type="submit" class="btn btn-primary">Zarejestruj!</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div><!-- /.panel-->
        </div><!-- /.col-->
    </div>
</div>
<script src="../../resources/js/jquery-1.11.1.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>