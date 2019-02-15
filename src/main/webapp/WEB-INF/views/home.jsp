<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="components/header.jsp"/>
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
                <ul class="nav navbar-top-links navbar-right">
                    <li><a href="<c:url value="/panel"/>">
                        <span><strong>Panel Instruktora</strong></span>
                    </a>
                    </li>
                </ul>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</nav><!--/.navbar-->

<div class="col-lg-12">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/home"/>">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Strona główna</li>
        </ol>
    </div><!--/.row-->

    <div class="col-md-12 col-lg-offset-4">
        <picture>
            <img src="https://img.hopaj.pl/images/d/e/de63b0cc8f63b1c9ed856026133700e8.jpg" class="img-fluid"
                 alt="Responsive image"/>
        </picture>
    </div>
    <div class="panel panel-container">
        <div class="row">
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-teal panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
                        <div class="large">${offersize}</div>
                        <div class="text-muted">Oferty</div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-blue panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-comments color-orange"></em>
                        <div class="large">${userssize}</div>
                        <div class="text-muted">Instruktorzy</div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-orange panel-widget border-right">
                    <div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
                        <div class="large">15</div>
                        <div class="text-muted">Uczniowie</div>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-md-3 col-lg-3 no-padding">
                <div class="panel panel-red panel-widget ">
                    <div class="row no-padding"><em class="fa fa-xl fa-calendar color-red"></em>
                        <div class="large">37</div>
                        <div class="text-muted">Lekcje</div>
                    </div>
                </div>
            </div>
        </div><!--/.row-->
    </div>
</div>
<div class="divider">
</div>
<div class="col-lg-12">
    <div class="panel panel-container">
        <div class="row">
            <div class="panel-heading col-lg-offset-5"><strong>Ostatnie Oferty</strong></div>

            <c:forEach items="${offers}" var="offer">
                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">${offer.title}</div>
                        Dodano: <javatime:format value="${offer.created}" style="MM"/>
                        <div class="panel-body">
                            <p>${offer.description}</p>
                        </div>
                        <form method="post">
                            <div class="form-group">
                                <div class="col-md-3 widget-right">
                                    <a class="btn btn-md btn-primary" href="<c:url value="/home/offer/${offer.id}"/>">Szczegóły</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>


<jsp:include page="components/footer.jsp"/>