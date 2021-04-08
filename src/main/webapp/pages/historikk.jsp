<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Historikk</title>
</head>
<body>

<div id="logo">
	<img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
</div>

<div id="overskrift">Her kan du se dine tidligere spill</div>

				<c:forEach items="${spilldeltagelser}" var="s">
					 <form action="enkelHistorikk" method="get">
						 <div id="listeknapp">
					<input type="hidden" name="spillid" value="${s.spill.id}">
					<input type="submit" value="${s.spill.navn}"/>
						 </div>
				</form>
				</c:forEach>

				<!--
				HER KOMMER LISTE MED SPILLNAVN
				-->

<form action="LoggUtServlet" method="get">
	<div id="loggutknapp">
		<input type="submit" value="Logg ut" />
	</div>
</form>

<form action="startside" method="get">
	<div id="startsideknapp">
		<input type="submit" value="Startside" />
	</div>
</form>
	
</body>