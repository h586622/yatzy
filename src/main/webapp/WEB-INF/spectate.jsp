<head>
<meta charset="ISO-8859-1">
<title>Spectate</title>
</head>
<legend>Velg i listen under hvilket spill du �nsker � se p� </legend>	
<body>
	
    ${aktiveSpill}
    
    <table><tr>
<th>Spill</th>
<th>Velg �nsket</th>

</tr>
<c:forEach var="d" items="${aktiveSpill}">
 <tr>
<td>${d}</td>
<td><form action="spill" method="post">
 <input type="hidden" name="spill" value="${d}" />
 <input type="submit" value="Se p� spill" />
 </form></td> 
 </tr>
</c:forEach>
</table>

<form action=startside method="get">
	<input type="submit" value="Tilbake til startsiden">
	</form>
	
</body>
