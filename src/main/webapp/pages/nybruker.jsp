<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/formcontroller2.css" type="text/css"/>
	<script src="JavaScript/validator.js" defer ></script>
<title>Login</title>
</head>

<body>
<div id="root">

<div id="logo">
	<img src="pictures/logo.png" alt="logo" style='max-width:450px;'>
</div>

<div id=registrerboks>
	<form action="nybruker" method="post">
		<div id="tekst1">Du er bare et par steg unna et slag yatzy</div>
		<div id="inputogknapp">
			<input type="text" name="fornavn" placeholder="Fornavn" id="fornavn"/>
			<input type="text" name="etternavn" placeholder="Etternavn" id="etternavn"/>
			<input type="text" name="brukernavn" placeholder="Brukernavn" id="brukernavn"/>
			<input type="text" name="epost" placeholder="E-post" id="epost"/>
			<input type="password" name="passord" placeholder="Passord" id="passord"/>
			<input type="password" name="passordRepetert" placeholder="Gjenta passord" id="passordRepetert"/>
			<input type="submit" value="Registrer" onClick="sjekkSkjema()" id="knapp"/>
			<div id="feilmeldingboks" data-info="submit" class="formcontroller_hidden" ></div>
			<div id="passordInfo" data-info="passord" class="formcontroller_hidden" ></div>
		</div>

	</form>

</div>
</div>
</body>
</html>