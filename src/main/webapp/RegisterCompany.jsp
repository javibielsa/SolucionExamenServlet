<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Empresas</title>
</head>
<body>
<h2>REGISTRO DE EMPRESAS</h2>
<form action="registercompany" method="post">
		<span>Nombre:</span> 
		<input type="text" name="nombre"/><br/>
		
		<span>Fecha de creación:</span><br/>
		<input type="date" name="fechaCreacion"/><br/>
		
		<input type="submit" Value="Dar de alta"/>
</form>
</body>
</html>