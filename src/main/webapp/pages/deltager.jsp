<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <title>Spill</title>
    <style>
        table {
            font-family: Roboto Condensed;
            color: #ffffff;
            border-collapse: collapse;
            width: 30%;
            float: right;
            margin-right: 10%;
        }

        td, th {
            border: 1px solid #FFFFFF;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #0E819B;
        }
        tr:nth-child(odd) {
            background-color: #51AFC5;
        }
    </style>
</head>

<body>

<div id="logo">
    <a href="startside">
        <img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
    </a>
</div>
<div id="overskriftspill"> Du er med i dette spillet: ${spill.navn}<br>${spill.brukerTur.brukernavn} sin tur</div>

<div id="poeng">
    <TABLE ID="spillbrett">
        <TR>
            <TH>Deltakere</TH>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TH>${s.bruker.brukernavn}</TH> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Enere</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.enere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Toere</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.toere}</TD>
            </c:forEach>
        </TR>
        <TR>
            <TD>Treere</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.treere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Firere</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.firere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Femmere</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.femere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Seksere</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.seksere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Sum</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.sumbonus}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Bonus</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.bonus}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Ett par</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.par}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>To par</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.topar}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Tre like</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.trelike}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Fire like</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.firelike}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Liten straight</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.litenstraight}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Stor straight</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.storstraight}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Hus</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.hus}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Sjanse</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.sjanse}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Yatzy</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.yatzy}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Total</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.totalsum}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
    </TABLE>
</div>
<div id="runde">
    <div id="spillboks">
        <!-- Bare for spillere som det er sin tur -->
        <div id="vanligtekst">Antallkast: ${spilldeltagelse.kast}<br>${rundenavn}<br>Resultat av kast:<br></div>
        <div id="terningresultattekst">${spill.kopp.terning1}<br>${spill.kopp.terning2}<br>
            ${spill.kopp.terning3}<br>${spill.kopp.terning4}<br>${spill.kopp.terning5}<br></div>
        <form action="mail" method="get">
            <input type="hidden" id="spill" name="spill" value="${spill.id}">
            <input type="submit" value="Purr">
        </form>

    </div>
</div>
<div id="oppdaterknapp">
    <form action="spill" method="get">
        <input type="hidden" id="spill" name="spill" value="${spill.id}">
        <input type="submit" value="Oppdater"/>
    </form>
</div>

<form action="LoggUtServlet" method="get">
    <div id="loggutknapp">
        <input type="submit" value="Logg ut" />
    </div>
</form>



</body>
</html>