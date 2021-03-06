<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<!-- Watchlist view, starts with nothing and populates with user selections. Nav bar only contains logout option. -->
<meta charset="ISO-8859-1">
<title>Watch List</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-light">
		<ul class="nav">
						
			<li class="nav-item">
			<a class="nav-link" href="/logout">Logout</a>
			</li>
		</ul>
	</nav>
	
	<div class="container">
	<h1>Movie List</h1>
		<table class = "table">
		<thead>
			<tr>
				<th>Title</th>
				<th>Year</th>
				<th >Type</th>
				<th>Remove</th>
				<th>More Info</th>
			
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${ movieList }" var = "movie">
				<tr>
				 	<td><c:out value="${ movie.title }"/></td>
				 	<td><c:out value="${ movie.year }"/></td>
				 	<td><c:out value="${ movie.type }"/></td>
				 	<td><a class="btn btn-danger" onclick="myRemoveAlert()" href = "/watchlist/remove/${ movie.id }">Remove</a>
				 	<td><a class="btn btn-secondary" href="/moreinfo?title=${movie.title}">More Info</a>
			    </tr>	
			</c:forEach>
		</tbody>
		</table>
		<h2>Back to Home</h2>
		<a class="btn btn-secondary" href="/">Go</a>
	</div>
<!-- Alerts user that they are removing a movie from their watchlist -->	
<script>
function myRemoveAlert(){
	alert ("You are removing this movie from your watchlist");
}
</script>
</body>
</html>