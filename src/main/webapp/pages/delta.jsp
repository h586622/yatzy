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
<title>Delta</title>
</head>

<body>

<div id="logo">
	<a href="startside">
	<img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
	</a>
</div>

<div id="overskrift">Velg hvilket spill du ønsker å delta i</div>

<c:forEach  var="d" items="${ledigeSpill}">
 <form action="delta" method="post">
	 <div id="listeknapp">
	<input type="hidden" id="spill" name="spill" value="${d.id}">
	<input type = "submit" name ="" value= "${d.navn}">
	 </div>
 </form>
</c:forEach>

<form action="LoggUtServlet" method="get">
	<div id="loggutknapp">
		<input type="submit" value="Logg ut" />
	</div>
</form>

	</body>
</html>