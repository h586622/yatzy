<%--
  Created by IntelliJ IDEA.
  User: hakonoygard
  Date: 19/03/2021
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Demo</title>
</head>
<body>

<c:set var="count" value="0" scope="page" />
<c:forEach var="k" items="${kastliste}">
    <c:set var="count" value="${count + 1}" scope="page"/>
    <p>Kast nr. ${count}: verdi ${k.verdi}</p>
</c:forEach>

<form action="DemoServlet" method="post">
    <button type="submit">Trill</button>
</form>


</body>
</html>
