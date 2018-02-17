
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de videojuegos</title>
</head>
<body>
	<h2>LISTADO DE VIDEOJUEGOS</h2>
	<form action="listVideogames" method="post">
		<input type="submit" value="ver listado">
	</form>
	<br/>
	<%
	 List<Videogame> videojuego = (List<Videogame>)request.getAttribute("listAllVideogames");
	 pageContext.setAttribute("videojuego", videojuego);
	 %>

	<table border="1">
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Edad Recomendada</td>
				<td>Fecha de lanzamiento</td>
				<td>Consola</td>
			</tr>
		</thead>
		<tbody>
		<%
		if(null != videojuego && !videojuego.isEmpty()){
			for (Videogame user2 : videojuego) {
				out.println("<form action='deleteVideogame' method='post'>");
				out.println("<tr>");
				out.println("<td>");
				out.println("<input type='text' name='titulo' value="+user2.getTitle()+" style='display:none' disabled>"+user2.getTitle()+"");
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='text' name='edadRecomendada' value="+user2.getRecommendedAge()+" style='display:none' disabled>"+user2.getRecommendedAge()+"");
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='text' name='fechaLanzamiento' value="+user2.getReleaseDate()+" style='display:none' disabled>"+user2.getReleaseDate()+"");
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='text' name='nombreConsola' value="+user2.getConsoleName()+" style='display:none' disabled>"+user2.getConsoleName()+"");
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