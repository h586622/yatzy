<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<title>Historikk</title>
</head>
<body>
	
			<h2>Her kan du se dine tidligere spill</h2>	
			
			<fieldset>

				<c:forEach items="${spilldeltagelser}" var="s">
					<p>${s.spill.navn} <form action="historikk" method="post">
					<input type="hidden" name="spillid" value="${s.spill.id}">
					<input type="submit" value="Vis"/>
				</form>
					</p>
				</c:forEach>

				<!--
				HER KOMMER LISTE MED SPILLNAVN
				-->


			<p> statistikk </p>


			
			</fieldset>
    
<form action=startside method="get">
	<input type="submit" value="Tilbake til startsiden">
	</form>
	
	
</body>