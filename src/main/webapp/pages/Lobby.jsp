<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lobby</title>
</head>
<body>

    <h2>${spill.spillnavn}</h2>

<p>Host: ${spill.spilltur}</p>

<c:forEach  items="${spill.spilldeltagelseList}" var="d">
<p>
    Spiller: ${d.bruker.brukernavn}
</p>
</c:forEach>

<form action=spill method="post">

    <input type="submit" value="Start spill">

</form>

</body>
</html>
