<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="TestServlet" method="post">
    <input type="text" name="navn">
    <input type="text" name="mobil">
    <button type="submit">Send inn</button>
</form>
</body>
</html>