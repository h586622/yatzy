<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spill</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<p> Du er med i dette spillet: ${spill.navn} </p>

<div id="poeng">

    <TABLE ID="spillbrett">
        <TR>
            <TH>Deltakere</TH>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TH>${s.bruker.brukernavn}</TH> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Ones</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.enere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Twos</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.toere}</TD>
            </c:forEach>
        </TR>
        <TR>
            <TD>Threes</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.treere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Fours</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.firere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Fives</TD>
            <c:forEach items="${spilldeltagelser}" var="s">
                <TD>${s.femere}</TD> <!-- Spillere -->
            </c:forEach>
        </TR>
        <TR>
            <TD>Sixes</TD>
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
    <form action=spill method="post">
        <input type="hidden" id="spill" name="spill" value="${spill.id}">
        <input type="submit" value="Trill terninger">



    <!-- Bare for spillere som det er sin tur -->
    <fieldset>
        <p>Antallkast: ${spilldeltagelse.kast} </p>
        <p>${rundenavn}</p>
        <p> Resultat av kast: </p>
        <input type="checkbox" id="terning1" name="terninger" value="0">
        <label for="terning1"> ${spill.kopp.terning1}</label><br>
        <input type="checkbox" id="terning2" name="terninger" value="1">
        <label for="terning2"> ${spill.kopp.terning2}</label><br>
        <input type="checkbox" id="terning3" name="terninger" value="2">
        <label for="terning3"> ${spill.kopp.terning3}</label><br><br>
        <input type="checkbox" id="terning4" name="terninger" value="3">
        <label for="terning4"> ${spill.kopp.terning4}</label><br><br>
        <input type="checkbox" id="terning5" name="terninger" value="4">
        <label for="terning5"> ${spill.kopp.terning5}</label><br><br>
    </fieldset>
    </form>
</div>

<form action=startside method="get">
    <input type="submit" value="Tilbake til startsiden">
</form>

</body>
</html>