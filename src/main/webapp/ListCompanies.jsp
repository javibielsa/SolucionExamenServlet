
<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de empresas</title>
</head>
<body>
	<h2>LISTADO DE EMPRESAS</h2>
	<form action="listCompanies" method="post">
		<input type="submit" value="Ver listado">
	</form>
	<br/>
	<%
	 List<Company> company = (List<Company>)request.getAttribute("listAllCompanies");
	 pageContext.setAttribute("company", company);
	 %>
	
	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Fecha de creacion</td>
			</tr>
		</thead>
		<tbody>
		<%
		if(null != company && !company.isEmpty()){
			for (Company user2 : company) {
				out.println("<form action='deleteCompany' method='post'>");
				out.println("<tr>");
				out.println("<td>");
				out.println("<input type='text' name='nombre' value="+user2.getName()+" style='display:none' disabled>"+user2.getName()+"");
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='text' name='creationDate' value="+user2.getCreationDate()+" style='display:none' disabled>"+user2.getCreationDate()+"");
				out.println("</td>");
				out.println("<td>");
				out.println(""+ user2.toString()+"");
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