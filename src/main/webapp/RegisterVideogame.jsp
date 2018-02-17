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
	<%
		List<Console> console = (List<Console>)request.getAttribute("listAllConsoles");
		pageContext.setAttribute("console", console);
	%>
	<form action="registervideogame" method="post">
		<span>Titulo:</span> 
		<input type="text" name="titulo"/><br/>
		
		<span>Edad recomendada:</span> 
		<select name="edadRecomendada" id="edadRecomendada">
			<option value="TP">TP</option>
            <option value="+7" selected>+7</option>
            <option value="+13">+13</option>
            <option value="+18">+18</option>
		</select><br/>
		
		<span>Fecha de lanzamiento:</span> 
		<input type="date" name="fechaLanzamiento"/><br/>
		<span>Consola:</span> 
		<select name="nombreConsola">
		<%
		if(null != console && !console.isEmpty()){
			for (Console user2 : console) {
				out.println("<option value='"+user2.getName()+"'>"+user2.getName()+"</option>");
			}
		}
		%>
		</select>
		<br/>
		
		<input type="submit" Value="Dar de alta"/>
	</form>
</body>
</html>