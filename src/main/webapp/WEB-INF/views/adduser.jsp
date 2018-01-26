<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nowy użytkownik</title>
<style type="text/css">
	.error {
		color: red;
	}
	
	table, tr, th, td {
		border: 1px solid black;
    	border-collapse: collapse;
    	padding: 5px 15px 5px 15px;
	}
</style>
</head>
<body>
	
	<form:form method="post" modelAttribute="user">
		<table>
			<tr>
				<th colspan="2"> Nowy użytkownik</th>
			</tr>
			<tr>
				<th>Nazwa użytkownika: </th>
				<td>
					<form:input path="userName" />
					<form:errors path="userName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<th>Adres e-mail: </th>
				<td>
					<form:input path="email" />
					<form:errors path="email" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<th>Hasło: </th>
				<td>
					<form:password path="password" />
					<form:errors path="password" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Dodaj użytkownika">
				</td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>