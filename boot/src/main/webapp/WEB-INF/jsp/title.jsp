<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-canche">
<meta http-equiv="Cahe-Control" content="no-canche">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
<title>Boot Sample | Title</title>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-title">Manage tile</a></li>
					<li><a href="all-titles">All titles</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME' }">
			<div class="container">
				<div class="jumbotrom text-center" id="homeDiv">
					<h1>Welcome to Title Manager </h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TITLES' }">
			<div class="container text-center" id="titlesDiv">
				<h3>My Titles</h3>
				<hr/>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Number Employee</th>
								<th>Title</th>
								<th>From Date</th>
								<th>To Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="title" items="${titles}">
								<tr>
									<td>${title.idTitle}</td>
									<td>${title.empNo}</td>
									<td>${title.name }</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy" value="${title.fromDate}" /></td>
									<td><fmt:formatDate pattern="dd-MM-yyyy" value="${title.toDate}" /></td>
									<td><a href="update-title?idTitle=${title.idTitle}">
									 <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-title?idTitle=${title.idTitle}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Manage Task</h3>
				<hr />
				<form class="form-horizontal" method="post" action="save-title">
				<input type="hidden" name="idTitle" value="${title.idTitle}"/>
				
				<div class="form-group"> 
				<label class="control-label col-md-3">Employee: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="empNo" value="${title.empNo }"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Title: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="name" value="${title.name}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">From Date: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="fromDate" value="${title.fromDate}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">To Date: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="toDate" value="${title.toDate}"/>
				</div>
			</div>
			<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Save"/>
			</div>
				</form>
			</div>
		</c:when>


	</c:choose>

	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
</body>

</html>