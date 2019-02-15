<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <div class="profile-sidebar">
        <div class="profile-userpic">
            <img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
        </div>
        <div class="profile-usertitle">
            <div class="profile-usertitle-name">${currentUser.username}</div>
            <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="divider"></div>
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
        </div>
    </form>
    <ul class="nav menu">
        <li><a href="<c:url value="/panel"/>"><em class="fa fa-home">&nbsp;</em>Panel</a></li>
        <li><a href="<c:url value="/panel/message"/>"><em class="fa fa-envelope">&nbsp;</em> Wiadomośći</a></li>
        <li><a href="<c:url value="/panel/user"/>"><em class="fa fa-user">&nbsp;</em> Profil</a></li>
        <li><a href="<c:url value="/panel/offer"/>"><em class="fa fa-product-hunt">&nbsp;</em> Oferty</a></li>
        <li><a href="<c:url value="/panel/calendar"/>"><em class="fa fa-calendar">&nbsp;</em> Kalendarz</a></li>
        <li><form action="/logout" method="post">
            <input class="fa fa-id-badge" type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form></li>
    </ul>
</div><!--/.sidebar-->