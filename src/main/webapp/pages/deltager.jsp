<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <title>Spill</title>
</head>
<body>

<p> Du er med i dette spillet: ${spill.navn} </p>
<p>Ikke din tur</p>

<div id="poeng">

    <table>
        <tr>
            <th> Runde</th>
            <c:forEach var="s" items="${spilldeltagelser}">
                <th>${s.bruker.brukernavn}</th>
            </c:forEach>
        </tr>
        <td>Enere</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.enere}</td>
        </c:forEach>
        <td>Toere</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.toere}</td>
        </c:forEach>
        <td>Treere</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.treere}</td>
        </c:forEach>
        <td>Firere</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.firere}</td>
        </c:forEach>
        <td>Femere</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.femere}</td>
        </c:forEach>
        <td>Seksere</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.seksere}</td>
        </c:forEach>
        <td>Sum</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.sumbonus}</td>
        </c:forEach>
        <td>Bonus</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.bonus}</td>
        </c:forEach>
        <td>Ett par</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.par}</td>
        </c:forEach>
        <td>To par</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.topar}</td>
        </c:forEach>
        <td>Tre like</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.trelike}</td>
        </c:forEach>
        <td>Fire like</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.firelike}</td>
        </c:forEach>
        <td>Liten straight</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.litenstraight}</td>
        </c:forEach>
        <td>Stor straight</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.storstraight}</td>
        </c:forEach>
        <td>Hus</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.hus}</td>
        </c:forEach>
        <td>Sjanse</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.sjanse}</td>
        </c:forEach>
        <td>Yatzy</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.yatzy}</td>
        </c:forEach>
        <td>Totalsum</td>
        <c:forEach var="s" items="${spilldeltagelser}">
            <td>${s.totalsum}</td>
        </c:forEach>

    </table>
</div>
<div id="runde">
    <!-- Bare for spillere som det er sin tur -->
    <fieldset>
        <p>Antallkast: ${spilldeltagelse.kast} </p>
        <p>${rundenavn}</p>
        <p> Siste kast: </p>
        <p>${spill.kopp.terning1}</p>
        <p>${spill.kopp.terning2}</p>
        <p>${spill.kopp.terning3}</p>
        <p>${spill.kopp.terning4}</p>
        <p>${spill.kopp.terning5}</p>
    </fieldset>

</div>
<div id="oppdaterknapp">
    <form action="spill" method="get">
        <input type="hidden" id="spill" name="spill" value="${spill.id}">
        <input type="submit" value="Oppdater"/>
    </form>
</div>
<form action=startside method="get">
    <input type="submit" value="Tilbake til startsiden">
</form>

</body>
</html>