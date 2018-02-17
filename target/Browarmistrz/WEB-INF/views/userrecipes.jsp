<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Moje przepisy</title>

</head>
<body>

	<section class="vertical-menu">
		<div class="logo">LĄGO</div>
		<a href="<c:url value="/#" />">Home</a>
		<a href="<c:url value="/recipe/publicrecipes" />">Przepisy publiczne</a>
		<a href="<c:url value="/recipe/calculateABV" />">Kalkulator alkoholu</a>
	
		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/recipe/addrecipe" />">Dodaj warkę</a>
			<a href="<c:url value="/recipe/userrecipes" />" class="active">Moje przepisy</a>
			<a href="<c:url value="/recipe/brewedrecipes" />">Uwarzone piwa</a>
			<a href="<c:url value="/logout" />">Wyloguj: ${loggeduser}</a>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
			<a href="<c:url value="/user/adduser" />">Załóż konto</a>
			<a href="<c:url value="/login" />">Zaloguj</a>
		</sec:authorize>
	</section>
	
	<section class="main">
		<c:forEach items="${userrecipes}" var="recipe">
			<table class="public-recipe-table">
				<tr>
					<th colspan="2">${recipe.brewName}</th>
				</tr>
				<tr>
					<td>Styl:</td>
					<td>${recipe.beerStyle.styleName}</td>
				</tr>
				<tr>
					<td>Rozmiar:</td>
					<td>${recipe.brewSize}L</td>
				</tr>
				<tr>
					<td>ABV:</td>
					<td>${recipe.beerStyle.ABV}</td>
				</tr>
				<tr>
					<td>Dodano:</td>
					<td><fmt:formatDate value="${recipe.added.time}" type="date" dateStyle="short" /></td>
				</tr>
				<tr>
					<td colspan="2"><a class="button" href="<c:url   value="/recipe/showrecipe/${recipe.id}"/>">Pokaż przepis</a></td>
				</tr>
			</table>
		</c:forEach>
	</section>

</body>
</html>