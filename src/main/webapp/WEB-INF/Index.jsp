<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<link rel="stylesheet" type="text/css" href="/MVCFilmSite/Style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site App</title>
</head>
<body>
	<h1>Welcome to the Film App</h1>
	<h2>Please select an option:</h2>
	<br>
	<h3>Search for film by ID</h3>
	<br>

	<form action="getfilm.do" method="GET">
		Enter film ID: <input type="text" name="filmId" size="12" /> <input
			type="submit" value="Search by ID" />
	</form>
	<br>

	<h3>Search for film by keyword</h3>
	<br>

	<form action="keywordsearch.do" method="GET">
		Enter a keyword: <input type="text" name="keyword" size="12" /> <input
			type="submit" value="Search By Keyword" /> <br> 
			
			<a
			href="newfilm.do" class="btn"> Add a film to the
			database</a> <br>
	</form>
	<br>
	<footer>
		<p>
			<small>Created by: <br> Gabriel Avila <br> and <br>
				Brian Ramirez <br>
			</small>
		</p>
	</footer>

</body>
</html>