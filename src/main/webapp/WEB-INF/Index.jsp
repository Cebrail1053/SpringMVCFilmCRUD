<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="styles/Style.css">
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

	<form action="getFilm.do" method="GET">
		Enter film ID: <input type="text" name="filmId" size="12" /> <input
			type="submit" value="Search by ID" />
	</form>
	<br>

	<h3>Search for film by keyword</h3>
	<br>

	<form action="keywordSearch.do" method="GET">
		Enter a keyword: <input type="text" name="keyword" size="12" /> <input
			type="submit" value="Search By Keyword" /> <br>
	</form>
	<br>

	<h3>Add a film to datadase</h3>
	<br>

	<form action="newFilm.do" method="POST">
		Enter film title: <input type="text" name="title" size="12" />
		Enter film description: <input type="text" name="description" size="12" />
		Enter film release year: <input type="text" name="releaseYear" size="12" />
		Enter film rental rate: <input type="text" name="rentalRate" size="12" />
		Enter film rental duration: <input type="text" name="rentalDuration" size="12" />
		Enter film length: <input type="text" name="length" size="12" />
		Enter film replacement cost: <input type="text" name="replacementCost" size="12" />
		Enter film rating: 
		<input type="radio" id="G" name="rating" size="12" value="G"/>
		<label for="G">G</label>
		<input type="radio" id="PG" name="rating" size="12" value="PG"/>
		<label for="PG">PG</label>
		<input type="radio" id="PG-13" name="rating" size="12" value="PG-13"/>
		<label for="PG-13">PG-13</label>
		<input type="radio" id="R" name="rating" size="12" value="R"/>
		<label for="R">R</label>
		<input type="radio" id="NC17" name="rating" size="12" value="NC17"/>
		<label for="NC17">NC17</label><br><br>
		Enter film special features: 
		<input type="checkbox" id="trailers" name="specialFeatures" size="12" value="Trailers"/>
		<label for="trailers">Trailers</label>
		<input type="checkbox" id="commentaries" name="specialFeatures" size="12" value="Commentaries"/>
		<label for="commentaries">Commentaries</label>
		<input type="checkbox" id="deletedScenes" name="specialFeatures" size="12" value="Deleted Scenes"/>
		<label for="deletedScenes">Deleted Scenes</label>
		<input type="checkbox" id="BtS" name="specialFeatures" size="12" value="Behind the Scenes"/>
		<label for="BtS">Behind the Scenes</label><br><br>
		<input type="submit" value="submit updates" /> <br>
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