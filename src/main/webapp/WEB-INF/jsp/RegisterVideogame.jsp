<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Videojuegos</title>
</head>
<body>

	<h2>REGISTRO DE VIDEOJUEGOS</h2>
	<form:form action="registervideogame" method="post">
		<span>Titulo:</span>
		<form:input type="text" path="title" />
		<br />
		<span>Edad recomendada:</span>
		<form:select path="recommendedAge">
			<option value="TP">TP</option>
			<option value="+7" selected>+7</option>
			<option value="+13">+13</option>
			<option value="+18">+18</option>
		</form:select>
		<br />
		<span>Fecha de lanzamiento:</span>
		<form:input type="date" path="releaseDate" />
		<br />
		<span>Consola:</span>
		<form:select path="consoleName">
			<c:forEach var="console" items="${listAllConsoles}">
				<option value="<c:out value="${console.name}" />">
					<c:out value="${console.name}" />
				</option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Registrar videojuego">
	</form:form>

</body>
</html>