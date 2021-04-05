<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<form action="nybruker" method="post">
		<fieldset>
			<legend>Du er bare et par steg unna et slag yatzy</legend>
			<p>
				Fornavn: <input type="text" name="fornavn" />
				</p>
				<p>
				Etternavn: <input type="text" name="etternavn" />
				</p>
				<p>
				Brukernavn: <input type="text" name="brukernavn" />
				</p>
				<p>
				Epostadresse: <input type="text" name="epost" />
				</p>
				<p>
				Passord: <input type="password" name="passord" />
				</p>
				<p>
				Gjenta passord: <input type="password" name="passordRepetert" />
				</p>
			
			<p>
				<input type="submit" value="Registrer" />
			</p>
			
			
		</fieldset>
	</form>
</body>
</html>