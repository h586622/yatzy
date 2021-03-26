<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Startside</title>
</head>
<body>
	
 <p> Her kan du se en oversikt over ledige spill samt opprette spill</p>
 
 <fieldset>
 
 		<form action="Lobby" method="post">
			
			<input type="submit" value="Opprett Spill" />
			Navn på spill:<input type="text" name="nyttspill"/>
			</form>
			
 <form action="delta" method="get">
		
			<input type="submit" value="Delta i spill" />
			</form>
			
<form action="spectate" method="get">
		
			<input type="submit" value="Se på spill" />
			</form>

<form action="historikk" method="get">
		
			<input type="submit" value="Se din historikk" />
			</form>
			
</fieldset>	

<form action="LoggUtServlet" method="get">
<input type="submit" value="Logg ut"/>

</form>
	
</body>