<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<title>Aktive spill</title>
</head>
<body>

<div id="logo">
	<img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
</div>

<div id="tekst1">Her kan du se dine aktive spill</div>
<c:forEach var="s" items="${spilliste}">
	<p>
	<form action="spill" method="get">
		<input type="hidden" id="spill" name="spill" value="${d.id}">
			${d.navn}
		<input type = "submit" name ="" value= "Gå inn">
	</form>
	</p>
</c:forEach>

</body>
</html>