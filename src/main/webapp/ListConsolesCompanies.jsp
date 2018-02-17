
<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de consolas segun la empresa</title>
</head>
<body>
	<h2>LISTADO DE CONSOLAS</h2>
	
	<form action="listConsolesByCompany" method="post">
		<input type="submit" value="Mostrar lista"/><br/>
	 <%
		 List<Company> company = (List<Company>)request.getAttribute("listAllCompanies");
		 pageContext.setAttribute("company", company);
		 %>
		 <span>SELECCIONA LA EMPRESA:</span><br/>
			<%
			out.println("<select name='selectCompany'>");
			if(null != company && !company.isEmpty()){
				for (Company company1 : company) {
					out.println("<option value='"+company1.getName()+"'>"+company1.getName()+"</option>");
				}
			}
			out.println("</select>");
			%>
	</form>
		 <br>
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
			for (Console consola1 : consola) {
				out.println("<tr>");
				out.println("<td>");
				out.println(""+consola1.getName()+"");
				out.println("</td>");
				out.println("<td>");
				out.println(""+consola1.getCompany().getName()+"");
				out.println("</td>");
				out.println("</tr>");
			}
		}
		%>
		</tbody>
	</table>

</body>
</html>

