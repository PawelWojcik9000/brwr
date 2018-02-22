<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Login</title>
</head>
<body>

	<section class="vertical-menu">
		<div class="logo"><img src="<c:url value="/images/logo_browarmistrz.png"/>"/></div>
		<a href="<c:url value="/#" />" class="active">Home</a>
		<a href="<c:url value="/recipe/publicrecipes" />">Przepisy publiczne</a>
		<a href="<c:url value="/recipe/calculateABV" />">Kalkulator alkoholu</a>
	
		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/recipe/addrecipe" />">Dodaj warkę</a>
			<a href="<c:url value="/recipe/userrecipes" />">Moje przepisy</a>
			<a href="<c:url value="/recipe/brewedrecipes" />">Uwarzone piwa</a>
			<a href="<c:url value="/user/edituser" />">Ustawienia konta</a>
			<a href="<c:url value="/logout" />">Wyloguj: ${loggeduser}</a>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
			<a href="<c:url value="/user/adduser" />">Załóż konto</a>
			<a href="<c:url value="/login" />">Zaloguj</a>
		</sec:authorize>
	</section>
	
	<section class="main">
	
		<form:form action="${loginProcessingUrl}" method="post">
			<table class="public-recipe-table">
				<tr>
					<th colspan="2">Logowanie</th>
				</tr>
				<tr>
					<th><label for="username">Login: </label></th>
					<td><input type="text" id="username" name="username" /></td>
				<tr>
				<tr>
					<th><label for="password">Hasło: </label></th>
					<td><input type="password" id="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">Zaloguj</button></td>
				</tr>
			</table>
		</form:form>
	</section>
	
</body>
</html>