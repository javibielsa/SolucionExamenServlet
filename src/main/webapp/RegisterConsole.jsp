<%@page import="es.salesianos.model.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de consolas</title>
</head>
<body>
	<h2>REGISTRO DE CONSOLAS</h2>
	<form action="openCompanies" method="post">
		<input type="submit" value="Mostrar empresa"/><br/>
	</form>
	<form action="registerconsole" method="post">
		<span>Nombre:</span> 
		<input type="text" name="name"/><br/>
		<span>Empresa:</span>
		<select name="selectCompany">
			<c:forEach var="company" items="${listAllCompanies}">
	
					<option value="<c:out value="${company.name}" />"><c:out value="${company.name}" /></option>
				
			</c:forEach>
		</select>
		<br/>
		<br/>
			
		<input type="submit" Value="Dar de alta"/>
	</form>
</body>
</html>