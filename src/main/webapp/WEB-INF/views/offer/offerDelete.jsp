<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/navbar.jsp"/>
<jsp:include page="../components/sidebar.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="<c:url value="/"/>">
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
                <div class="panel-heading">Twoja oferta</div>
                <div class="panel-body">
                    <form:form method="post"
                               modelAttribute="offerToDelete" role="form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>title</label>
                                    ${offerToDelete.title}
                            </div>
                            <div class="form-group">
                                <label>minutes</label>
                                    ${offerToDelete.minutes}
                            </div>
                            <div class="form-group">
                                <label>price</label>
                                    ${offerToDelete.price}

                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Usuń</button>
                    </form:form>
                </div>
            </div>
        </div><!-- /.panel-->
    </div><!-- /.col-->


<jsp:include page="../components/footer.jsp"/>