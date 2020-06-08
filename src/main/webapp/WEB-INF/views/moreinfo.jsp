<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>More Information</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<style>
.alignLeft{
	text-align: left;
}
.alignRight{
	text-align: right;
}
</style>
</head>
<body>
<div class="container">
<h1>More Info on ${movie.title}</h1>
<p>${movie.info}</p>
<div class="alignLeft">
<h2>Back to Home</h2>
<a class="btn btn-secondary" href="/">Home</a>
</div>

<h2>Back to Watchlist</h2>
<a class="btn btn-secondary" href="/watchlist">Watchlist</a>

</div>

</body>
</html>