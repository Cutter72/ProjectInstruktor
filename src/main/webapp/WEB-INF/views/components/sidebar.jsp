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
            <div class="profile-usertitle-name">Username</div>
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
        <li class="active"><a href="<c:url value="/panel"/>"><em class="fa fa-home">&nbsp;</em> Dashboard</a></li>
        <li><a href="<c:url value="/panel/user/edit/1"/>"><em class="fa fa-user">&nbsp;</em> Profil</a></li>
        <li><a href="#"><em class="fa fa-calendar">&nbsp;</em> Kalendarz</a></li>
        <li><a href="#"><em class="fa fa-product-hunt">&nbsp;</em> Oferty</a></li>
        <li><a href="<c:url value="/panel/message/1"/>"><em class="fa fa-envelope">&nbsp;</em> Wiadomośći</a></li>
        <li><a href="<c:url value="/panel/city"/>"<em class="fa fa-building">&nbsp;</em> City</a></li>
        <li><a href="<c:url value="/panel/category"/>"<em class="fa fa-id-badge">&nbsp;</em> Category</a></li>
        <%--<li><a href="../../login"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>--%>
        <%--<input type="submit" class="btn btn-primary fa fa-power-off" value="Logout" formmethod="post">--%>
        <form action="/logout" method="post">
            <input type="submit" value="Wyloguj"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </ul>
</div><!--/.sidebar-->