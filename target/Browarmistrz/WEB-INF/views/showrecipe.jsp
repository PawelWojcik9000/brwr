<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Szczegóły przepisu</title>

</head>
<body>

	<section class="vertical-menu">
		<div class="logo"><img src="<c:url value="/images/logo_browarmistrz.png"/>"/></div>
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
		<table class="show-recipe-table">
			<tr>
				<th colspan="4">${recipe.brewName}</th>
			</tr>

			<tr>
				<th colspan="4">${recipe.beerStyle.styleName}</th>
			</tr>

			<tr>
				<th colspan="4">Słody:</th>
			</tr>
			<c:forEach items="${recipe.malts}" var="recipemalt">
				<tr>
					<td>${recipemalt.maltName}</td>
					<td colspan="3">${recipemalt.maltWeight}kg</td>
				</tr>
			</c:forEach>

			<c:if test="${not empty recipe.hops[0].hopName}">
				<tr>
					<th colspan="4">Chmiele:</th>
				</tr>
				<c:forEach items="${recipe.hops}" var="recipehop">
					<tr>
						<td>${recipehop.hopName}</td>
						<td>${recipehop.hopWeight}g</td>
						<td colspan="2">${recipehop.hopBoilTime}min</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${not empty recipe.additions[0].additionName}">
				<tr>
					<th colspan="4">Dodatki:</th>
				</tr>
				<c:forEach items="${recipe.additions}" var="recipeaddition">
					<tr>
						<td>${recipeaddition.additionName}</td>
						<td colspan="3">${recipeaddition.additionTime}<c:choose>
								<c:when test="${recipeaddition.additionUse eq 'additionBoiled'}">
										min. gotowania
									</c:when>
								<c:when
									test="${recipeaddition.additionUse eq 'additionEffervescentFermentation'}">
										dni burzliwej fermentacji
									</c:when>
								<c:when
									test="${recipeaddition.additionUse eq 'additionSecondFermentation'}">
										dni cichej fermentacji
									</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:if>

			<tr>
				<th colspan="4">Drożdże:</th>
			</tr>
			<tr>
				<td>${recipe.yeast.yeastName}</td>
				<td>${recipe.yeast.yeastLab}</td>
				<td>${recipe.yeast.yeastWeight}g</td>
				<td>${recipe.yeast.yeastForm}</td>
			</tr>

			<tr>
				<th>Czas zacierania:</th>
				<td colspan="3">${recipe.mashTime}min.</td>
			</tr>

			<tr>
				<th>Temperatura zacierania:</th>
				<td colspan="3">${recipe.mashTemp }&deg;C</td>
			</tr>

			<tr>
				<th>Czas gotowania:</th>
				<td colspan="3">${recipe.boilTime}min.</td>
			</tr>

			<tr>
				<th>Rozmiar warki:</th>
				<td colspan="3">${recipe.brewSize}L</td>
			</tr>

			<tr>
				<th>Dodano:</th>
				<td colspan="3"><fmt:formatDate value="${recipe.added.time}" type="date" dateStyle="short" /></td>
			</tr>
			<tr>
				<th>Przepis publiczny:</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${recipe.publicRecipe}">Tak</c:when>
						<c:otherwise>Nie</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<a href="<c:url		value="/recipe/brewrecipe/${recipe.id}"/>"><div class="button">Uwarz to piwo</div></a>
					<c:if test="${showeditdelete}">
						<a href="<c:url		value="/recipe/editrecipe/${recipe.id}"/>"><div class="button">Edytuj</div></a>
						<a href="<c:url		value="/recipe/deleterecipe/${recipe.id}"/>"><div class="button">Usuń</div></a>
					</c:if>
				</td>
			</tr>
		</table>
	</section>

</body>
</html>