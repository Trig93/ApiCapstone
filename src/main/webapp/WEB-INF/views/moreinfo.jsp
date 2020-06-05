<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>More Information</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<h1>More Info on ${movie.title}</h1>
<p>${movie.info}</p>
<h2>Back to Home</h2>
<a href="/">Home</a>
<h2>Back to Watchlist</h2>
<a href="/watchlist">Watchlist</a>
</body>
</html>