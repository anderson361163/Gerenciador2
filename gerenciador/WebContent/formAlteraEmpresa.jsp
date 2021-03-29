<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   

<c:url value="/entrada" var="linkAlteraServlet"/>
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
	
	<form action="${linkAlteraServlet }" method="post">
		
		
		Nome: <input type="text" name="nome" value="${empresa.nome }"/><br />
		Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${empresa.id }">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<input type="submit" value="Alterar">
		
	</form> 
	
	
</body>
</html>