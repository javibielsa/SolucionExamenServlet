
<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de consolas</title>
</head>
<body>
	<h2>LISTADO DE CONSOLAS</h2>
	<form action="listConsoles" method="post">
		<input type="submit" value="Ver listado">
	</form>
	<br/>
	<%
	 List<Console> consola = (List<Console>)request.getAttribute("listAllConsoles");
	 pageContext.setAttribute("consola", consola);
	 %>
	
	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Empresa</td>
			</tr>
		</thead>
		<tbody>
		<%
		if(null != consola && !consola.isEmpty()){
			for (Console user2 : consola) {
				out.println("<form action='deleteCompany' method='post'>");
				out.println("<tr>");
				out.println("<td>");
				out.println("<input type='text' name='nombre' value="+user2.getName()+" style='display:none' disabled>"+user2.getName()+"");
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='text' name='empresa' value="+user2.getCompany().getName()+" style='display:none' disabled>"+user2.getCompany().getName()+"");
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='submit' value='Eliminar'></form>");
				out.println("</td>");
				out.println("</tr>");
			}
		}
		%>
		</tbody>
	</table>

</body>
</html>