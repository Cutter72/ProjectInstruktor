<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<jsp:include page="components/header.jsp"/>
<jsp:include page="components/navbar.jsp"/>
<jsp:include page="components/sidebar.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/"/>">
                <em class="fa fa-home"></em>
            </a></li>
            <li class="active">Profil</li>
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
                <div class="panel-heading">Twoje dane <button type="button" class="btn btn-md btn-primary" value="Edytuj"><a class="btn btn-md btn-primary" href="<c:url value="/panel/user/edit"/>">Edytuj</a></button></div>
                <div class="panel-body">
                    <div class="form-group">
                        <label style="display: inline-block">Imię:</label> ${currentUser.firstName}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">Nazwisko:</label> ${currentUser.lastName}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">Numer telefonu:</label> ${currentUser.phoneNumber}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">E-mail:</label> ${currentUser.email}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">Wideo:</label> ${currentUser.videoLink}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">Facebook:</label> ${currentUser.facebookLink}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">Twój Opis:</label> ${currentUser.description}
                    </div>
                </div>
                <div class="panel-heading">Twoje dane do logowania</div>
                <div class="panel-body">
                    <div class="form-group">
                        <label style="display: inline-block">Username:</label> ${currentUser.username}
                    </div>
                    <div class="form-group">
                        <label style="display: inline-block">Password:</label> *********
                    </div>
                </div>
            </div>
        </div><!-- /.panel-->
    </div><!-- /.col-->


<jsp:include page="components/footer.jsp"/>