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
            <c:forEach items="${spill.spilldeltagelser}" var="s">
                <th>${s.bruker.brukernavn}</th>
            </c:forEach>
        </tr>
        <td>Enere</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.enere}</td>
        </c:forEach>
        <td>Toere</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.toere}</td>
        </c:forEach>
        <td>Treere</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.treere}</td>
        </c:forEach>
        <td>Firere</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.firere}</td>
        </c:forEach>
        <td>Femere</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.femere}</td>
        </c:forEach>
        <td>Seksere</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.enere}</td>
        </c:forEach>
        <td>Sum</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.sumbonus}</td>
        </c:forEach>
        <td>Bonus</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.bonus}</td>
        </c:forEach>
        <td>Ett par</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.par}</td>
        </c:forEach>
        <td>To par</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.topar}</td>
        </c:forEach>
        <td>Tre like</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.trelike}</td>
        </c:forEach>
        <td>Fire like</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.firelike}</td>
        </c:forEach>
        <td>Liten straight</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.litenstraight}</td>
        </c:forEach>
        <td>Stor straight</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.storstraight}</td>
        </c:forEach>
        <td>Hus</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.hus}</td>
        </c:forEach>
        <td>Sjanse</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.sjanse}</td>
        </c:forEach>
        <td>Yatzy</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.yatzy}</td>
        </c:forEach>
        <td>Totalsum</td>
        <c:forEach items="${spill.spilldeltagelser}" var="s">
            <td>${s.totalsum}</td>
        </c:forEach>

    </table>
</div>
<div id="runde">
    <form action=spill method="post">
        <input type="hidden" id="spill" name="spill" value="${spill.id}">
        <input type="submit" value="Trill terninger">


    </form>
    <!-- Bare for spillere som det er sin tur -->
    <fieldset>
        <p> Resultat av kast: </p>
        <input type="checkbox" id="terning1" name="terninger" value="terning1">
        <label for="terning1"> ${kopp.Terning1}</label><br>
        <input type="checkbox" id="terning2" name="terninger" value="Car">
        <label for="terning2"> "${kopp.Terning2}</label><br>
        <input type="checkbox" id="terning3" name="terninger" value="Boat">
        <label for="terning3"> ${kopp.Terning3}</label><br><br>
        <input type="checkbox" id="terning4" name="terninger" value="Boat">
        <label for="terning4"> ${kopp.Terning4}</label><br><br>
        <input type="checkbox" id="terning5" name="terninger" value="Boat">
        <label for="terning5"> ${kopp.Terning5}</label><br><br>
    </fieldset>
</div>

<form action=startside method="get">
    <input type="submit" value="Tilbake til startsiden">
</form>

</body>
</html>