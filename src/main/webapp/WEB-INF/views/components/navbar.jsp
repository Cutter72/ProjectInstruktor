<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="<c:url value="/panel"/>"><span>Instruktor</span>Panel</a>
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