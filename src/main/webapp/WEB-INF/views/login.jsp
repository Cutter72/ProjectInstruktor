<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="<c:url value="/"/>"><span>E-</span>Instruktor</a>
            <div class="navbar-nav nav-pills">
                <ul class="nav navbar-top-links ">
                    <li><a href="<c:url value="/"/>">
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
        <div class="login-panel panel panel-default">
            <div class="panel-heading">Log in</div>
            <div class="panel-body">
                <form role="form" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Username" name="username" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="remember me">Zapamiętaj mnie
                            </label>
                        </div>
                        <input type="submit" class="btn btn-primary"></fieldset>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->
<div class="panel-body col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
    Nie masz konta? <a href="<c:url value="/login/register"/>">
    <strong>Zarejestruj się!</strong>
</div>
<script src="../../resources/js/jquery-1.11.1.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>
