<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Home Page view, contains search bar as well as navigation links to watchlist and logout -->
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-light">
		<ul class="nav">
			<li class="nav-item">
			<a class="nav-link" href="/watchlist">My Watchlist</a>
			</li>
			
			<li class="nav-item">
			<a class="nav-link" href="/logout">Logout</a>
			</li>
		</ul>
	</nav>

	<div class="container" align="center">
		<h1>Movie Api Capstone</h1>
		<form method="get" action="/listofmovies">
		<h2>Search by Title</h2>
		
		<label>Title:</label>
		<input type="text" name="s" required/>
		<label>Year:</label>
		<input type="text" name="year" />
		<label>Type:</label>
		<select name="type">
			<option>Movie</option>
			<option>Series</option>
			<option>Episode</option>
		</select>
		<button class="btn btn-secondary">Submit</button>
		</form>
		
		
	</div>

</body>

</html>