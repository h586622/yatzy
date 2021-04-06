<%--
  Created by IntelliJ IDEA.
  User: HVL
  Date: 06/04/2021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spillhistorikk</title>
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
<TABLE ID="ScoreCard">
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


</body>
</html>
