<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search by Type</title>
</head>
<body>
<h1>Type test</h1>

	<c:forEach items = "${ movies }" var = "movie">
		<c:out value="${ movie.title }"/>
	</c:forEach>


</body>
</html>