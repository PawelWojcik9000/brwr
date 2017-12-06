<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodawanie warki</title>
<script type="text/javascript" src="<c:url value="/js/script.js" />"></script>
</head>
<body>

	<form:form method="post" modelAttribute="recipe">
		<label>Nazwa warki: </label><form:input path="brewName" />
		
		<label>Słody:</label> 
		<table id="malts">
			<tr>
				<td><label>Nazwa: </label><form:input type="text" path="maltName" /></td>
				<td><label>Ilość(kg): </label><form:input type="text" path="maltWeight" /></td>
			</tr>
		</table>
		<input type="button" value="Kolejny słód" id="oneMoreMaltBtn">
		<input type="button" value="Usuń ostatni" id="deleteLastMaltBtn"><br>
		
		<input type="submit" value="Dodaj przepis">
	</form:form>
	
</body>
</html>