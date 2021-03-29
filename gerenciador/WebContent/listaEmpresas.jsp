<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Stand Tag Library</title>
</head>
<body>

<html>
	<body>
			Lista de empresas: <br />
			
			
		<ul>
				<%-- Lista de Empresas: </br>
				<%
				
				List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
				for(Empresa empresa : lista) {
				%>
				
					 <li><%= empresa.getNome() %> </li> 
				<%
				}
				
				%>	 --%>		
		</ul>
		<ul>
			<c:forEach items="${empresas }" var="empresa">
				
				
				<li>${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/></li>
				<a href="<c:url value="entrada?acao=MostraEmpresa&id=${empresa.id }"/>">edita</a>
				<a href="<c:url value="entrada?acao=RemoveEmpresa&id=${empresa.id }"/>">remove</a>
			</c:forEach>
		
		
		</ul>
	</body>
</html>