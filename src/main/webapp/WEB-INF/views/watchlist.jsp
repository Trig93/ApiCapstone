<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Watch List</title>
</head>
<body>
<h1>Type test</h1>
<table>
	<tr>
		<th>Title</th>
		<th>Year</th>
		<th>Type</th>
	
	
	</tr>
	<c:forEach items = "${ movieList }" var = "movie">
		<tr>
		 	<td><c:out value="${ movie.title }"/></td>
		 	<td><c:out value="${ movie.year }"/></td>
		 	<td><c:out value="${ movie.type }"/></td>
		 	<td><a href = "/watchlist/remove/${ movie.id }">Remove</a>
	    </tr>	
	</c:forEach>
</table>
<h2>Back to Home</h2>
<a href="/">Go</a>

</body>
</html>