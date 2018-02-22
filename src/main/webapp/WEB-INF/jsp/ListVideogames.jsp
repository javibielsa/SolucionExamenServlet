<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de videojuegos</title>
</head>
<body>
	<h2>LISTADO DE VIDEOJUEGOS</h2>
	<br>
	<br/>
	<table border="1">
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Fecha de creacion</td>
				<td>Edad recomendada</td>
				<td>Consola</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videogame" items="${listAllVideogames}">
				<tr>
					<td><c:out value="${videogame.title}" /></td>
					<td><c:out value="${videogame.recommendedAge}" /></td>
					<td><c:out value="${videogame.releaseDate}" /></td>
					<td><c:out value="${videogame.consoleName}" /></td>
					<td><a href="/delete?name=${videogame.title}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>