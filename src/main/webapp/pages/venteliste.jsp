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
    <title>Lobby</title>
</head>
<body>

<div id="logo">
    <a href="startside">
        <img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
    </a>
</div>


<div id=lobbyboks>
    <div id="vanligtekst">Du er med i følgende spill: ${spill.navn}</div>
    <div id="vanligtekst">Host: ${spill.brukerTur.brukernavn}</div>


    <div id="vanligtekst">Påmeldte spillere: </div>
    <c:forEach  var="d" items="${spilldeltagelser}" >
        <div id="vanligtekst">${d.bruker.brukernavn}</div>
    </c:forEach>


    <div id="vanligtekst">Venter på at host skal starte spillet </div>

<div id="oppdaterknapp">
    <form action="spill" method="get">
    <input type="hidden" id="spill" name="spill" value="${spill.id}">
    <input type="submit" value="Oppdater" />
    </form>
</div>

<form action="LoggUtServlet" method="get">
    <div id="loggutknapp">
        <input type="submit" value="Logg ut" />
    </div>
</form>

</body>
</html>
