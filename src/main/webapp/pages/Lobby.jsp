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
    <img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
</div>


<div id=lobbyboks>
    <div id="vanligtekst">Du er med i følgende spill: ${spill.navn}</div>
    <div id="vanligtekst">Host: ${spill.brukerTur.brukernavn}</div>


<div id="vanligtekst">Påmeldte spillere: </div>
<c:forEach  var="d" items="${spilldeltagelser}" >
    <div id="vanligtekst">${d.bruker.brukernavn}</div>
</c:forEach>


<form action="start" method="post">
    <div id="inputogknapp">
    <input type="hidden" id="spillid" name="spillid" value="${spill.id}">
    <input type="submit" value="Start spill">
    </div>
</form>
</div>

    <div id="oppdaterknapp">
        <form action="Lobby" method="get">
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
