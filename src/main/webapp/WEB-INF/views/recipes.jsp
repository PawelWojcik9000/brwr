<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Insert title here</title>
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
			<a href="<c:url value="/user/users" />">Użytkownicy</a>
			<a href="<c:url value="/recipe/recipes" />" class="active">Przepisy</a>
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
				<th>Id przepisu</th>
				<th>Nazwa</th>
				<th>Dodano</th>
				<th>Czy publiczny</th>
				<th>Id autora</th>
				<th>Usuń przepis</th>
			</tr>
			<c:forEach items="${recipes}" var="recipe">
				<tr>
					<td>${recipe.id}</td>
					<td>${recipe.brewName}</td>
					<td><fmt:formatDate value="${recipe.added.time}" type="date" dateStyle="short" /></td>
					<td>${recipe.publicRecipe}</td>
					<td>${recipe.user.userId}</td>
					<td><a href="<c:url value="/recipe/admin/deleterecipe/${recipe.id}" />"><div class="button">Usuń</div></a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	
</body>
</html>