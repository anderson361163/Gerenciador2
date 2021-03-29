<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   

<c:url value="/entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	<form action="/gerenciador/novaEmpresa" method="post">
		
		
		Nome: <input type="text" name="nome" />
		<input type="submit">
		
	</form>
	 -->
	
	 
	<%-- <form action="<c:url value="/novaEmpresa"/></c:url>" method="post">
		
		
		Nome: <input type="text" name="nome" />
		<input type="submit">
		
	</form> --%>
	
	<form action="${linkServletNovaEmpresa }" method="post">
		
		
		Nome: <input type="text" name="nome"/><br />
		Data Abertura: <input type="text" name="data" />
		<input type="hidden" name="acao" value="NovaEmpresa"/>
		
		<input type="submit">
		
	</form> 
	
	
</body>
</html>