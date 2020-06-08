<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search by Title</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-light">
		<ul class="nav">
			<li class="nav-item">
			<a class="nav-link" href="/watchlist">My Watchlist</a>
			</li>
			<li class="nav-item">
			<a class="nav-link" href="/">Login</a>
			</li>
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
					<th>Type</th>
				</tr>
			</thead>
			<tbody>	
				<c:forEach items = "${ movies }" var = "movie">
					
					<tr>
					 	<td><c:out value="${ movie.title }"/></td>
					 	<td><c:out value="${ movie.year }"/></td>
					 	<td><c:out value="${ movie.type }"/></td>
					 	<td>
					 		<form action = "movie-add">
					 			<input type="hidden" name = "title" value = "${movie.title}"/>
					 			<input type="hidden" name = "year" value = "${movie.year}"/>
					 			<input type="hidden" name = "type" value = "${movie.type}"/>
					 			<button class="btn btn-secondary" onclick="myMovieAlert()">Add to Watch List</button>		
					 		</form>
						</td>
					 	<td><a class="btn btn-secondary" href="/moreinfo?title=${movie.title}">More Info</a>
					 </tr>
					 	
				</c:forEach>
			</tbody>
			
		</table>
		<h2>Back to Home</h2>
		<a class="btn btn-secondary" href="/">Go</a>
</div>
<script>
function myMovieAlert(){
		alert("Movie Successfully Added!");
}
</script>
</body>
</html>