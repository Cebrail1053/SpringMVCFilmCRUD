<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css" href="styles/Style.css">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Film from Database</title>
</head>

<body>
<h1>Remove Film from Database</h1>

<c:choose>
    	<c:when test="${deleteFilm == true}">
  		The film has been removed from the database.
    	</c:when>    

    	<c:otherwise> The film could not be removed from the database. </c:otherwise>
		</c:choose>

</body>
</html>