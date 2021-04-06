<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Lobby</title>
</head>
<body>

    <h2>${spill.navn}</h2>

<p>Host: ${spill.brukerTur.brukernavn}</p>
    <p>${spill.id}</p>

<c:forEach  var="d" items="${spill.spilldeltagelser}" >
<p>
    Spiller: ${d.bruker.brukernavn}
</p>
</c:forEach>

<form action="start" method="post">

    <input type="hidden" id="spillid" name="spillid" value="${spill.id}">
    <input type="submit" value="Start spill">

</form>

</body>
</html>
