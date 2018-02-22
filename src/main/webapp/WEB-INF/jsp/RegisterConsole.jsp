<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de consolas</title>
</head>
<body>
	<h2>REGISTRO DE CONSOLAS</h2>

	<form:form action="registerconsole" method="post">
		<span>Nombre:</span>
		<form:input type="text" path="name" />
		<br />
		<span>Empresa:</span>
		<form:select path="companyName">
			<c:forEach var="company" items="${listAllCompanies}">
				<option value="<c:out value="${company.name}" />">
					<c:out value="${company.name}" />
				</option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Registrar consola">
	</form:form>
</body>
</html>