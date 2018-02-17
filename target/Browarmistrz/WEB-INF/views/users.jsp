<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Panel administracyjny: użytkownicy</title>
</head>
<body>
	
	<section class="vertical-menu">
		<div class="logo">LĄGO</div>
		<a href="<c:url value="/#" />">Home</a> 
		<a href="<c:url value="/recipe/publicrecipes" />">Przepisy publiczne</a>
		<a href="<c:url value="/recipe/calculateABV" />">Kalkulator alkoholu</a>

		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/recipe/addrecipe" />">Dodaj warkę</a>
			<a href="<c:url value="/recipe/userrecipes" />">Moje przepisy</a>
			<a href="<c:url value="/recipe/brewedrecipes" />">Uwarzone piwa</a>
			<a href="<c:url value="/user/users" />" class="active">Użytkownicy</a>
			<a href="<c:url value="/recipe/recipes" />">Przepisy</a>
			<a href="<c:url value="/logout" />">Wyloguj: ${loggeduser}</a>
		</sec:authorize>

		<sec:authorize access="!isAuthenticated()">
			<a href="<c:url value="/user/adduser" />">Załóż konto</a>
			<a href="<c:url value="/login" />">Zaloguj</a>
		</sec:authorize>
	</section>
	
	<section class="main">
		<table class="show-recipe-table">
			<tr>
				<th>Id użytkownika</th>
				<th>Login użytkownika</th>
				<th>Email</th>
				<th>Aktywny</th>
				<th>Aktywuj/Dezaktywuj</th>
				<th>Usuń użytkownika</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.email}</td>
					<td>${user.enabled}</td>
					<td><a href="<c:url value="/user/activatedeactivate/${user.userId}" />"><div class="button">Przełącz</div></a></td>
					<td><a href="<c:url value="/user/deleteuser/${user.userId}" />"><div class="button">Usuń	</div></a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	
</body>
</html>