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
		<input type="text" name="nombre"/><br/>
		 <%
		 List<Company> company = (List<Company>)request.getAttribute("listAllCompanies");
		 pageContext.setAttribute("company", company);
		 %>
		 <span>Empresa:</span><br/>
		 <select name="selectCompany">
			<%
			if(null != company && !company.isEmpty()){
				for (Company user2 : company) {
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