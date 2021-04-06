<%--
  Created by IntelliJ IDEA.
  User: HVL
  Date: 06/04/2021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spillhistorikk</title>
</head>
<body>

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


</body>
</html>
