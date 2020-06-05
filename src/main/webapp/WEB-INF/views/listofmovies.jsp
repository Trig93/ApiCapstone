<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search by Title</title>
</head>
<body>
<h1>Test</h1>
<table>
	<tr> 
		<th>Title</th>
		<th>Year</th>
		<th>Type</th>
	</tr>
		
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
		 			<button>Add to Watch List</button>		
		 		</form>
			</td>
		 	<td><a href="/moreinfo?t=${movie.title}">More Info</a>
		 </tr>	
	</c:forEach>
	
</table>
</body>
</html>