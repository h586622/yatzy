<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delta</title>
</head>

<body>
	<h2> Velg i listen under hvilket spill du ønsker å delta i </h2>	
    ${ledigeSpill}

<c:forEach  items="${ledigeSpill}" var="d">
 <p>
 <form action="delta" method="get">
  ${d} <input type = "submit" name ="${d}" value= "Delta">
	  <input type="hidden" id="spill" name="spill" value="${spill.id}">
 </form>
</p>
</c:forEach>
	<form action=startside method="get">
	<input type="submit" value="Tilbake til startsiden">
	</form>
	</body>
</html>