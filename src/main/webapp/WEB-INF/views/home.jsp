<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Browarmistrz Homepage</title>
</head>
<body>
	
	<a href="<c:url value="/user/adduser" />">zaloz konto</a>
	<a href="<c:url value="/recipe/publicrecipes" />">przepisy publiczne</a>

	<sec:authorize access="isAuthenticated()">
		<a href="<c:url value="/recipe/addrecipe" />">dodaj warke</a>
		<a href="<c:url value="/recipe/userrecipes" />">moje przepisy</a>
		<a href="<c:url value="/logout" />">wyloguj: ${loggeduser}</a>
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="<c:url value="/login" />">zaloguj</a>
	</sec:authorize>
	
</body>
</html>