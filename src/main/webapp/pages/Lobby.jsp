<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lobby</title>
</head>
<body>

    <h2>${spill.navn}</h2>

<p>Host: ${spill.brukerTur}</p>

<c:forEach  var="d" items="${spill.spilldeltagelseList}" >
<p>
    Spiller: ${d.bruker.brukernavn}
</p>
</c:forEach>

<form action="start" method="post">

    <input type="hidden" id="spillid" name="spillid" value="${spill.id}">
    <input type="submit" value="Start spill">

</form>

</body>
</html>
