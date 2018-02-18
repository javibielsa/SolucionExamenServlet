<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Videojuegos</title>
</head>
<body>
<h2>REGISTRO DE VIDEOJUEGOS</h2>
	<form action="openConsoles" method="post">
		<input type="submit" value="Mostrar consola"/><br/>
	</form>
	<form action="registervideogame" method="post">
		<span>Titulo:</span> 
		<input type="text" name="title"/><br/>
		
		<span>Edad recomendada:</span> 
		<select name="recommendedAge" id="recommendedAge">
			<option value="TP">TP</option>
            <option value="+7" selected>+7</option>
            <option value="+13">+13</option>
            <option value="+18">+18</option>
		</select><br/>
		
		<span>Fecha de lanzamiento:</span> 
		<input type="date" name="releaseDate"/><br/>
		
		<span>Consola:</span> 
		<select name="consoleName">
			<c:forEach var="console" items="${listAllConsoles}">
	
					<option value="<c:out value="${console.name}" />"><c:out value="${console.name}" /></option>
				
			</c:forEach>
		</select><br>
		<input type="submit" Value="Dar de alta"/>
	</form>
</body>
</html>