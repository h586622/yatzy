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
            background-color: #FF8C00;
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
<div id="overskrift"> Du er med i dette spillet: ${spill.navn} </div>
<div id="overskrift">${spill.brukerTur.brukernavn} sin tur</div>

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
        <div id="vanligtekst">Antallkast: ${spilldeltagelse.kast}</div>
        <div id="vanligtekst">${rundenavn}</div>
        <div id="vanligtekst">Resultat av kast:</div>
        <p>${spill.kopp.terning1}</p>
        <p>${spill.kopp.terning2}</p>
        <p>${spill.kopp.terning3}</p>
        <p>${spill.kopp.terning4}</p>
        <p>${spill.kopp.terning5}</p>
    </div>
    </div>
<div id="oppdaterknapp">
    <form action="spill" method="get">
        <input type="hidden" id="spill" name="spill" value="${spill.id}">
        <input type="submit" value="Oppdater"/>
    </form>
</div>
<div id="purreknapp">
<form action="mail" method="post">
    <input type="hidden" id="spill" name="spill" value="${spill.id}">
    <input type="submit" value="Purr">
</form>
</div>

</body>
</html>