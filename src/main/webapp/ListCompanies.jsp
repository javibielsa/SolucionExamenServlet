<%@page import="es.salesianos.model.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>
	<h2>LISTADO DE EMPRESAS</h2>
	<br>
	<form action="listCompanies" method="post">
		<input type="submit">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Fecha de creacion</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="company" items="${listAllCompanies}">
				<tr>
					<td><c:out value="${company.name}" /></td>
					<td><c:out value="${company.creationDate}" /></td>
					<td><a href="/delete?name=${company.name}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>