<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="styles/Style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Film Result</title>
</head>
<body>
	<h1>Film Added</h1>

	<h2>Film Title: ${createdFilm.title}</h2>

	<table>
		<tr>
			<td>Film ID:</td>
			<td>${createdFilm.id}</td>
		</tr>

		<tr>
			<td>Film Title:</td>
			<td>${createdFilm.title}</td>
		</tr>

		<tr>
			<td>Release Year:</td>
			<td>${createdFilm.releaseYear}</td>
		</tr>

		<tr>
			<td>Film Description:</td>
			<td>${createdFilm.description}</td>
		</tr>

		<tr>
			<td>Film Language:</td>
			<td>${createdFilm.language}</td>
		</tr>

		<tr>
			<td>Rental Duration:</td>
			<td>${createdFilm.rentalDuration}</td>
		</tr>

		<tr>
			<td>Rental Rate:</td>
			<td>${createdFilm.rentalRate}</td>
		</tr>

		<tr>
			<td>Replacement Cost:</td>
			<td>${createdFilm.replacementCost}</td>
		</tr>

		<tr>
			<td>Film Length:</td>
			<td>${createdFilm.length}</td>
		</tr>

		<tr>
			<td>Film Rating:</td>
			<td>${createdFilm.rating}</td>
		</tr>

		<tr>
			<td>Special Features</td>
			<td>${createdFilm.specialFeatures}</td>
		</tr>


	</table>

	<footer>
		<p>
			<small>Created by: <br> Gabriel Avila <br> and <br>
				Brian Ramirez <br>
			</small>

		</p>
	</footer>
</body>
</html>