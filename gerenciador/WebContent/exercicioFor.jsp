<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testando o For</title>
</head>
<body>
	
	
	<c:forEach var="i" begin="1" end="10" step="2">
		${i}<br />
		
	
	</c:forEach>
	
</body>
</html>