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
<form method="get" action="/s">
<h2>Search by title</h2>
<label>Title:</label>
<input type="text" name="s" required/>
<label>Year:</label>
<input type="text" name="year" />
<label>Type:</label>
<input type="text" name="type">
<button>Submit</button>
</form>
</body>
</html>