<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="styles/Style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search by Keyword</title>
</head>
<body>

	<h1>Welcome to the Film App</h1>
	<c:choose>
		<c:when test="${! empty list }">
				<table>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Description</th>
					<th>Release Year</th>
					<th>Rental Duration</th>
					<th>Rental Rate</th>
					<th>Replacement Cost</th>
					<th>Film Length</th>
					<th>Rating</th>
					<th>Special Features</th>
					<th>Category</th>
					<th>Actors</th>
					
				</tr>
			<c:forEach items="${films }" var="film">

				<tr>
					<td>${film.id }</td>				
					<td>${film.title }</td>				
					<td>${film.description }</td>				
					<td>${film.releaseYear }</td>				
					<td>${film.rentalDuration }</td>				
					<td>${film.rentalRate }</td>				
					<td>${film.replacementCost }</td>				
					<td>${film.length }</td>				
					<td>${film.rating }</td>				
					<td>${film.specialFeatures }</td>				
					<td>${film.category }</td>		
					<td>
					<c:forEach items="${film.actors }" var="actor">
						${actor.firstName }	&nbsp; ${actor.lastName }<br>			
					</c:forEach>
					</td>		
				</tr>

			</c:forEach>
				</table>
		</c:when>
		<c:otherwise>
		No results found
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