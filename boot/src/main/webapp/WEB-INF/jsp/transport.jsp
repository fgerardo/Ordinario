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
<title>Boot Sample | Transport</title>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-transport">Manage Transport</a></li>
					<li><a href="all-transports">All transports</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME' }">
			<div class="container">
				<div class="jumbotrom text-center" id="homeDiv">
					<h1>Welcome to Transport Manager </h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TRANSPORTS' }">
			<div class="container text-center" id="transportsDiv">
				<h3>My Transports</h3>
				<hr/>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Number People</th>
								<th>Destination</th>
								<th>Price</th>
								<th>existing Quota</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="transport" items="${transports}">
								<tr>
									<td>${transport.idTransport}</td>
									<td>${transport.peopleNu }</td>
									<td>${transport.destination }</td>
									<td>${transport.price}</td>
									
									<td>${transport.existingQuota ==true?'YES':'NO'}</td>
									<td><a href="update-transport?idTransport=${transport.idTransport}">
									 <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-transport?idTransport=${transport.idTransport}"> <span
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
				<h3>Manage Transport</h3>
				<hr />
				<form class="form-horizontal" method="post" action="save-transport">
				<input type="hidden" name="idTransport" value="${transport.idTransport }"/>
				
				<div class="form-group"> 
				<label class="control-label col-md-3">Number People: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="peopleNu" value="${transport.peopleNu }"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Destination: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="destination" value="${transport.destination}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Price: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="price" value="${transport.price}"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Existing Quota: </label>
				<div class="col-md-7">
				<input type="radio" class="col-sm-1" name="existingQuota" value="true"/>
				<div class="col-sm-1">YES</div>
				<input type="radio" class="col-sm-1" name="existingQuota" value="false" checked="checked"/>
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