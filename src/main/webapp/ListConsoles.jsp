
<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de consolas</title>
</head>
<body>
	<h2>LISTADO DE CONSOLAS</h2>
	<form action="listConsoles" method="post">
		<input type="submit" value="Ver listado">
	</form>
	<br/>
	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Empresa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="console" items="${listAllConsoles}">
				<tr>
					<td><c:out value="${console.name}" /></td>
					<td><c:out value="${console.company.name}" /></td>
					<td><a href="/delete?name=${console.name}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>