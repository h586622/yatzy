<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spill</title>
</head>
<body>

<p> Du er med i dette spillet: ${spill.navn} </p>

<div id="poeng">

    <table>
        <tr>
            <th> Runde</th>
            <c:forEach var="s" items="${spilldeltagelser}" >
                <th>${s.bruker.brukernavn}</th>
            </c:forEach>
        </tr>
        <td>Enere</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.enere}</td>
        </c:forEach>
        <td>Toere</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.toere}</td>
        </c:forEach>
        <td>Treere</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.treere}</td>
        </c:forEach>
        <td>Firere</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.firere}</td>
        </c:forEach>
        <td>Femere</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.femere}</td>
        </c:forEach>
        <td>Seksere</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.seksere}</td>
        </c:forEach>
        <td>Sum</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.sumbonus}</td>
        </c:forEach>
        <td>Bonus</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.bonus}</td>
        </c:forEach>
        <td>Ett par</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.par}</td>
        </c:forEach>
        <td>To par</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.topar}</td>
        </c:forEach>
        <td>Tre like</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.trelike}</td>
        </c:forEach>
        <td>Fire like</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.firelike}</td>
        </c:forEach>
        <td>Liten straight</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.litenstraight}</td>
        </c:forEach>
        <td>Stor straight</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.storstraight}</td>
        </c:forEach>
        <td>Hus</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.hus}</td>
        </c:forEach>
        <td>Sjanse</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.sjanse}</td>
        </c:forEach>
        <td>Yatzy</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.yatzy}</td>
        </c:forEach>
        <td>Totalsum</td>
        <c:forEach var="s" items="${spilldeltagelser}" >
            <td>${s.totalsum}</td>
        </c:forEach>

    </table>
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