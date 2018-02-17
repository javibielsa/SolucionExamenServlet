
<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de videojuegos segun la consola</title>
</head>
<body>
	<h2>LISTADO DE VIDEOJUEGOS</h2>
	
	<form action="listVideogamesByConsole" method="post">
		<input type="submit" value="Mostrar lista"/><br/>
	 <%
		 List<Console> console = (List<Console>)request.getAttribute("listAllConsoles");
		 pageContext.setAttribute("console", console);
		 %>
		 <span>SELECCIONA LA EMPRESA:</span><br/>
			<%
			out.println("<select name='selectConsole'>");
			if(null != console && !console.isEmpty()){
				for (Console console1 : console) {
					out.println("<option value='"+console1.getName()+"'>"+console1.getName()+"</option>");
				}
			}
			out.println("</select>");
			%>
	</form>
		 <br>
	<%
	 List<Videogame> videogame = (List<Videogame>)request.getAttribute("listAllVideogames");
	 pageContext.setAttribute("videogame", videogame);
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
		if(null != videogame && !videogame.isEmpty()){
			for (Videogame videogame1 : videogame) {
				out.println("<tr>");
				out.println("<td>");
				out.println(""+videogame1.getTitle()+"");
				out.println("</td>");
				out.println("<td>");
				out.println(""+videogame1.getRecommendedAge()+"");
				out.println("</td>");
				out.println("<td>");
				out.println(""+videogame1.getReleaseDate()+"");
				out.println("</td>");
				out.println("<td>");
				out.println(""+videogame1.getConsoleName()+"");
				out.println("</td>");
				out.println("</tr>");
			}
		}
		%>
		</tbody>
	</table>

</body>
</html>

