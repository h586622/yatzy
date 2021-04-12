<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bernt
  Date: 26.03.2021
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <p>Alle spillere</p>
    <fieldset>
        <form method="post" action="admin">
            <c:forEach items="${brukere}" var="bruker">
                <input type="hidden" name="slettDette" value="${bruker.brukernavn}">
                <p><input type="submit" name="slett" value="Slett">${bruker.brukernavn}</p>
            </c:forEach>
        </form>
    </fieldset>

    <form action="LoggUtServlet" method="get">
        <input type="submit" value="Logg ut"/>
    </form>
</body>
</html>
