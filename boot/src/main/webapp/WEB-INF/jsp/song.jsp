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
<title>Boot Sample | Song</title>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-song">Manage song</a></li>
					<li><a href="all-songs">All song</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME' }">
			<div class="container">
				<div class="jumbotrom text-center" id="homeDiv">
					<h1>Welcome to Song Manager </h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_SONGS' }">
			<div class="container text-center" id="songsDiv">
				<h3>My Songs</h3>
				<hr/>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Duration</th>
								<th>Title</th>
								<th>Artist</th>
								<th>Creation Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="song" items="${songs}">
								<tr>
									<td>${song.id}</td>
									<td>${song.duration}</td>
									<td>${song.title}</td>
									<td>${song.artist}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy" value="${song.creationDate}" /></td>
									
									<td><a href="update-song?id=${song.id}">
									 <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-song?id=${song.id}"> <span
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
				<h3>Manage Song</h3>
				<hr />
				<form class="form-horizontal" method="post" action="save-song">
				<input type="hidden" name="id" value="${song.id }"/>
				
				
			<div class="form-group"> 
				<label class="control-label col-md-3">Artist: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="artist" value="${song.artist}"/>
				</div>
			</div>
			
			<div class="form-group"> 
				<label class="control-label col-md-3">Duration: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="duration" value="${song.duration}"/>
				</div>
			</div>
			
			<div class="form-group"> 
				<label class="control-label col-md-3">Title: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="title" value="${song.title }"/>
				</div>
			</div>
			<div class="form-group"> 
				<label class="control-label col-md-3">Creation Date: </label>
				<div class="col-md-7">
				<input type="text" class="form-control" name="creationDate" value="${song.creationDate}"/>
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