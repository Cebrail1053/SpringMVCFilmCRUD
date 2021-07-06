<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css" href="styles/Style.css">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Removed</title>
</head>
<body>

  <h3>The film has successfully been removed from the database.</h3>

<c:choose>
    	<c:when test="${deletedBool == true}">
  		Film was successfully deleted
    	</c:when>    

    	<c:otherwise> Film was not deleted.. try again? </c:otherwise>
		</c:choose>

</body>
</html>