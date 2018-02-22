<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de empresas</title>
</head>
<body>
	<h2>LISTADO DE EMPRESAS</h2>
	<br>
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