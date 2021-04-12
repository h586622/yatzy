<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<title>Startside</title>
</head>
<body>

<div id="logo">
	<img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
</div>

<div id="startsideboks">

	<form action="Lobby" method="post">
			<input type="text" name="nyttspill" placeholder="Navn på spill"/>
			<input type="submit" value="Opprett spill" />
	</form>

	<form action="aktivespill" method="get">
		<input type="submit" value="Dine aktive spill" />
	</form>

	<form action="delta" method="get">
			<input type="submit" value="Se tilgjengelige spill" />
	</form>

	<form action="spectate" method="get">
			<input type="submit" value="Finn spill å se på" />
	</form>

	<form action="historikk" method="get">
			<input type="submit" value="Se på dine tidligere spill" />
	</form>

</div>

	<form action="LoggUtServlet" method="get">
		<div id="loggutknapp">
			<input type="submit" value="Logg ut" />
		</div>
	</form>
</body>
</html>