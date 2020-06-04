<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Movie Api Capstone</h1>
<form method="get" action="/t">
<label>Search by Title</label>
<input type="text" name="t" /><a href="/t?title=${ movie.title }"><button>Submit</button></a>
</form>
<form method="get" action="/searchYear">
<label>Search by Year</label>
<input type="text" value="year" /><button type="button">Submit</button>
</form>
<form method="get" action="/searchGenre">
<label>Search by Genre</label>
<input type="text" value="genre" /><button type="button">Submit</button>
</form>
</body>
</html>