<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film</title>
</head>
<body>
	<h2>Update Film</h2>
<form action="updateFilm.do" method="POST">
		Enter film title: <input type="text" name="title" size="12" value="${film.title}" />
		Enter film description: <input type="text" name="description" size="12" value="${film.description}"/>
		Enter film release year: <input type="text" name="releaseYear" size="12" value="${film.releaseYear}"/>
		Enter film rental rate: <input type="text" name="rentalRate" size="12" value="${film.rentalRate}"/>
		Enter film rental duration: <input type="text" name="rentalDuration" size="12" value="${film.rentalDuration}"/>
		Enter film length: <input type="text" name="length" size="12" value="${film.length}"/>
		Enter film replacement cost: <input type="text" name="replacementCost" size="12" value="${film.replacementCost}"/>
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
</body>
</html>