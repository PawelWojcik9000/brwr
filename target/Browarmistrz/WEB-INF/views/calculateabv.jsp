<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Zawartość alkoholu</title>
</head>
<body>

	<section class="vertical-menu">
		<div class="logo">LĄGO</div>
		<a href="<c:url value="/#" />">Home</a> 
		<a href="<c:url value="/recipe/publicrecipes" />">Przepisy publiczne</a>
		<a href="<c:url value="/recipe/calculateABV" />" class="active">Kalkulator alkoholu</a>

		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/recipe/addrecipe" />">Dodaj warkę</a>
			<a href="<c:url value="/recipe/userrecipes" />">Moje przepisy</a>
			<a href="<c:url value="/recipe/brewedrecipes" />">Uwarzone piwa</a>
			<a href="<c:url value="/logout" />">Wyloguj: ${loggeduser}</a>
		</sec:authorize>

		<sec:authorize access="!isAuthenticated()">
			<a href="<c:url value="/user/adduser" />">Załóż konto</a>
			<a href="<c:url value="/login" />">Zaloguj</a>
		</sec:authorize>
	</section>

	<section class="main">
		<form action="/Browarmistrz/recipe/calculateABV" method="POST">
			<input type="text" name="param1" />
			<input type="submit" value="dupa" />
		</form>
		<%--<form:form method="post" modelAttribute="calculator">
			<table class="public-recipe-table">
				<tr>
					<th colspan="2"> Oblicz zawartość alkoholu</th>
				</tr>
				<tr>
					<th>Początkowe BLG: </th>
					<td>
						<form:input path="og" />
						<form:errors path="og" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th>Końcowe BLG: </th>
					<td>
						<form:input path="fg" />
						<form:errors path="fg" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Oblicz">
					</td>
				</tr>
				<c:if test="${not empty abv}">
					<tr>
						<th>ABV: </th>
						<td>${abv}</td>
					</tr>
				</c:if>
			</table>
		</form:form> --%>
	</section>
</body>
</html>