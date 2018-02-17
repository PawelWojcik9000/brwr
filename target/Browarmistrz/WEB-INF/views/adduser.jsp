<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Nowy użytkownik</title>

</head>
<body>

	<section class="vertical-menu">
		<div class="logo">LĄGO</div>
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
		<form:form method="post" modelAttribute="user">
			<table class="public-recipe-table">
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
	</section>
	
</body>
</html>