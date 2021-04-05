<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Login</title>
</head>
<body>

<div id="logo">
	<img src="logo.png" alt="logo" style='max-width:450px;'>
</div>
	
	<form action="logginn" method="post">
		<div id="tekst1">Logg inn for a spille yatzy</div>
		<div id="inputogknapp">
			<input type="text" name="username" placeholder="Brukernavn" />
			<input type="password" name="passord" placeholder="Passord" />
			<input type="submit" value="Logg inn" />
		</div>
	</form>
<form action="nybruker" method="get">
	<a href="nybruker">Har du ikke en bruker? Registrer deg her</a>
</form>
</div>
</body>
</html>