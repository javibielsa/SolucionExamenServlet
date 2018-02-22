<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de videojuegos por edad recomendada</title>

</head>
<body>
	<h2>LISTADO VIDEOJUEGOS SEGUN LA EDAD RECOMENDADA</h2>
	<form:form action="listByRecommendedAge" method="post">
		<form:select path="recommendedAge">
			<option value="TP">TP</option>
			<option value="+7" selected>+7</option>
			<option value="+13">+13</option>
			<option value="+18">+18</option>
		</form:select>
		<input type="submit" value="Mostrar listado">
	</form:form>
	<br />
	<table border="1">
		<thead>
			<tr>
				<form:form action="orderVideogames" method="post">
					<form:input type="text" path="recommendedAge" style="display:none"/>
					<form:select path="order">
						<option value="orderByTitle">Ordenar por alfabeticamente por su titulo</option>
						<option value="orderByReleaseDate">Ordenar segun la fecha</option>
					</form:select>
					<input type="submit" value="Ordenar">
				</form:form>
			</tr>
			<tr>
				<td>Titulo</td>
				<td>Fecha de lanzamiento</td>
				<td>Consola</td>
				<td>Edad recomendada</td>
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