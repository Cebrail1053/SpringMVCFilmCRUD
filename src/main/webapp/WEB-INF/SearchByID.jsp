<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="styles/Style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search by ID</title>
</head>
<body>

	<h1>Search by ID Results:</h1>
	<c:choose>
		<c:when test="${! empty film }">

			<h2>Film Title: ${film.title}</h2>
			<br>
			<form action="deleteFilm.do" method="POST">
			
				<table>
					<tr>
						<td>Film ID:</td>
						<td>${film.id}</td>
					</tr>

					<tr>
						<td>Film Title:</td>
						<td>${film.title}</td>
					</tr>

					<tr>
						<td>Release Year:</td>
						<td>${film.releaseYear}</td>
					</tr>

					<tr>
						<td>Film Description:</td>
						<td>${film.description}</td>
					</tr>

					<tr>
						<td>Film Language:</td>
						<td>${film.language}</td>
					</tr>

					<tr>
						<td>Rental Duration:</td>
						<td>${film.rentalDuration}</td>
					</tr>

					<tr>
						<td>Rental Rate:</td>
						<td>${film.rentalRate}</td>
					</tr>

					<tr>
						<td>Replacement Cost:</td>
						<td>${film.replacementCost}</td>
					</tr>

					<tr>
						<td>Film Length:</td>
						<td>${film.length}</td>
					</tr>

					<tr>
						<td>Film Rating:</td>
						<td>${film.rating}</td>
					</tr>

					<tr>
						<td>Special Features</td>
						<td>${film.specialFeatures}</td>
					</tr>
					
					<tr>
					<td>Actors</td>
					<td><c:forEach items="${film.actors }" var="actor">
						${actor.firstName }	&nbsp; ${actor.lastName }	<br>
					</c:forEach></td>		
					</tr>
					
					<tr>
					<td>Category</td>
					<td>${film.category}</td>
					</tr>

				</table>


				<button type="submit" name="filmId" value="${film.id }">Delete</button>

				<!--   <input type="submit"> -->
			</form>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>

	<footer>
		<p>
			<small>Created by: <br> Gabriel Avila <br> and <br>
				Brian Ramirez <br>
			</small>

		</p>
	</footer>

</body>
</html>