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
<title>Boot Sample | Cars</title>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					
					<li><a href="new-car">Manage Car</a></li>
					<li><a href="all-cars">All cars</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME' }">
			<div class="container">
				<div class="jumbotrom text-center" id="homeDiv">
					<h1>Welcome to Car Manager </h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_CARS' }">
			<div class="container text-center" id="carDiv">
				<h3>My Cars</h3>
				<hr/>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id car</th>
								<th>Model of car</th>
								<th>Type of car</th>
								<th>Description</th>
								<th>Existing</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="car" items="${cars}">
								<tr>
									<td>${car.id}</td>
									
									<td>${car.model }</td>
									<td>${car.type }</td>
									<td>${car.description }</td>
									<td>${car.existing ==true?'YES':'NO'}</td>
									
									<td><a href="update-car?id=${car.id}">
									 <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-car?id=${car.id}"> <span
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
				<h3>Manage Car</h3>
				<hr />
				<form class="form-horizontal" method="post" action="save-car">
				<input type="hidden" name="id" value="${car.id }"/>
				
			<div class="form-group"> 
				<label class="control-label col-md-3">Model of Car: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="model" value="${car.model}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">type of Car: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="type" value="${car.type}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Description: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="description" value="${car.description}"/>
				</div>
			</div>
			
			<div class="form-group"> 
				<label class="control-label col-md-3">Existing: </label>
				<div class="col-md-7">
				<input type="radio" class="col-sm-1" name="existing" value="true"/>
				<div class="col-sm-1">YES</div>
				<input type="radio" class="col-sm-1" name="existing" value="false" checked="checked"/>
				<div class="col-sm-1">NO</div>
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