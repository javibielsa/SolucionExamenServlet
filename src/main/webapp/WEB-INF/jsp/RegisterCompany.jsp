<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Empresas</title>
</head>
<body>
	<h2>REGISTRO DE EMPRESAS</h2>
	<form:form action="registercompany" method="post">
		<span>Nombre:</span>
		<form:input type="text" path="name" />
		<br/>
		<span>Fecha de creacion:</span>
		<form:input type="date" path="creationDate" />
		<br/>
		<input type="submit" value="Dar de alta">
	</form:form>
</body>
</html>