
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de videojuegos por edad recomendada</title>

</head>
<body>
	<h2>LISTADO VIDEOJUEGOS SEGUN LA EDAD RECOMENDADA</h2>
	<form action="listByRecommendedAge" method="post">
		<span>Edad recomendada:</span> 
		<select name="edadRecomendada" id="edadRecomendada">
			<option name="TP" value="TP">TP</option>
            <option name="+7" value="+7">+7</option>
            <option name="+13" value="+13">+13</option>
            <option name="+18" value="+18">+18</option>
		</select><br/>
		<input type="submit" value="Ver listado" name="enviar" id="enviar" >
	</form>
<br/>
<%
 List<Videogame> videogames = (List<Videogame>)request.getAttribute("listVideogames");
 request.setAttribute("videogames", videogames);
 %>

<table border="1">
<thead>
	<tr>
		<td>
			<form action="orderByTitleAlphabetically" method="post">
				<input type="submit" value="Ordenar por titulo (alfabeticamente)">
			</form>
		</td>
		<td>
			<form action="orderByReleaseDateAlphabetically" method="post">
				<input type="submit" value="Ordenar por fecha de lanzamiento (alfabeticamente)">
			</form>
		</td>
	</tr>
	<tr>
		<td>Titulo</td>
		<td>Fecha de lanzamiento</td>
	</tr>
</thead>
<tbody>
<%
if(null != videogames && !videogames.isEmpty()){
	for (Videogame user2 : videogames) {
		out.println("<tr>");
		out.println("<td>");
		out.println(""+user2.getTitle()+"");
		out.println("</td>");
		out.println("<td>");
		out.println(""+user2.getReleaseDate()+"");
		out.println("</td>");
		out.println("<td>");
		out.println(""+user2.getConsoleName()+"");
		out.println("</td>");
		out.println("<td>");
		out.println(""+user2.getRecommendedAge()+"");
		out.println("</td>");
		out.println("</tr>");
	}
}
%>
</tbody>
</table>

</body>
</html>