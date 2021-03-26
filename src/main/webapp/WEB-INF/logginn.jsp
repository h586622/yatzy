<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<form action="logginn" method="post">
		<fieldset>
			<legend>Logg inn for å spille yatzy</legend>
			<p>
				Brukernavn: <input type="text" name="brukernavn" />
				</p>
				<p>
				Passord: <input type="password" name="passord" />
				</p>
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
			
			
		</fieldset>
	</form>
	
	<form action="nybruker" method="get">
	<input type="submit" value="Registrere ny bruker?"/>
	</form>
</body>
</html>