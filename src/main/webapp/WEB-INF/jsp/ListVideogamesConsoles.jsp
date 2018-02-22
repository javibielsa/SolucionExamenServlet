<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de videojuegos segun la consola</title>
</head>
<body>
	<h2>LISTADO DE VIDEOJUEGOS</h2>
	<form:form action="listVideogamesByConsole" method="post">
		<form:select path="consoleName">
			<c:forEach var="console" items="${listAllConsoles}">
				<option value="<c:out value="${console.name}" />">
					<c:out value="${console.name}" />
				</option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Mostrar listado">
	</form:form>
	<br>
	
	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Edad recomendada</td>
				<td>Fecha de lanzamiento</td>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>

