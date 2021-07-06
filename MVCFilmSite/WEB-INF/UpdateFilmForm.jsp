<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="styles/Style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Update Film Form</title>
</head>
	<body>
		<form:form action="updatefilm.do" method="POST" modelAttribute="film">
			Film ID: ${film.id}
			<br>
				<form:label path="title">Title:</form:label>
				<form:input path="title"/>
			<br>
				<form:label path="description">Description:</form:label>
				<form:input path="description"/>
			<br>
				<form:label path="releaseYear">Release Year:</form:label>
				<form:input path="releaseYear"/>
				
			<br>
				<form:label path="rentalDuration">Rental Duration:</form:label>
				<form:input path="rentalDuration"/>
						<br/>
				<form:label path="rentalRate">rentalRate:</form:label>
				<form:input path="rentalRate"/>
			<br>
			<br>
				<form:label path="length">Length:</form:label>
				<form:input path="length"/>
			<br>
				<form:label path="replacementCost">Replacement Cost:</form:label>
				<form:input path="replacementCost"/>
			<br>
				<form:label path="rating">Rating:</form:label>
					<form:select path="rating">
						<form:option value="${film.rating}">${film.rating}</form:option>
						<form:option value="G">G</form:option>
						<form:option value="PG">PG</form:option>
						<form:option value="PG13">PG-13</form:option>
						<form:option value="R">R</form:option>
						<form:option value="NC17">NC-17</form:option>
					</form:select>
			<br>
				<form:label path="special_features">Special Features (currently ${film.special_features}):</form:label>
			<br>
				<form:select multiple="true" path="special_features">
					<form:option value="Trailers">Trailers</form:option>
					<form:option value="Commentaries">Commentaries</form:option>
					<form:option value="Deleted Scenes">Deleted Scenes</form:option>
					<form:option value="Behind The Scenes">Behind the Scenes</form:option>
					<form:option value="n/a">n/a</form:option>
					</form:select>
			<br>
			<button  type="submit" name="id" value="${film.id}">Submit Update</button>
		</form:form>

  	  	<br>
	</body>
</html>
