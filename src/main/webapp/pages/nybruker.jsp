<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link rel="stylesheet" href="css/style.css" />
<title>Login</title>
</head>
<body>

<div id="logo">
	<img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
</div>

<div id=registrerboks>
	<form action="nybruker" method="post">
		<div id="tekst1">Du er bare et par steg unna et slag yatzy</div>
		<div id="inputogknapp">
			<input type="text" name="fornavn" placeholder="Fornavn" />
			<input type="text" name="etternavn" placeholder="Etternavn" />
			<input type="text" name="brukernavn" placeholder="Brukernavn" />
			<input type="text" name="epost" placeholder="E-post" />
			<input type="password" name="passord" placeholder="Passord" />
			<input type="password" name="passordRepetert" placeholder="Gjenta passord" />
			<input type="submit" value="Registrer" />
		</div>
	</form>
</div>
</body>
</html>