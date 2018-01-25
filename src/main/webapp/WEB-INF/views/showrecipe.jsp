<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Szczegóły przepisu</title>
<style>
	table, th, td {
    	border-bottom: 1px solid #153cd8;
    	border-collapse: collapse;
    	padding: 5px 15px 5px 15px;
	}
</style>
</head>
<body>

	<div class="recipedetailview">
		<table>
			<tr>
				<th colspan="4">${recipe.brewName}</th>
			</tr>
			
			<tr>
				<th colspan="4">${recipe.beerStyle.styleName}</th>
			</tr>
			
			<tr>
				<th colspan="4">Słody: </th>
			</tr>
			<c:forEach items="${recipe.malts}" var="recipemalt">
				<tr>
					<td>${recipemalt.maltName}</td>
					<td colspan="3">${recipemalt.maltWeight}kg</td>
				</tr>
			</c:forEach>
			
			<tr>
				<th colspan="4">Chmiele: </th>
			</tr>
			<c:forEach items="${recipe.hops}" var="recipehop">
				<tr>
					<td>${recipehop.hopName}</td>
					<td>${recipehop.hopWeight}g</td>
					<td colspan="2">${recipehop.hopBoilTime}min</td>
				</tr>
			</c:forEach>
				
			<c:if test="${not empty recipe.additions[0].additionName}">
				<tr>
					<th colspan="4">Dodatki: </th>
				</tr>
				<c:forEach items="${recipe.additions}" var="recipeaddition">
					<tr>
						<td>${recipeaddition.additionName}</td>
						<td colspan="3">${recipeaddition.additionTime}
							<c:choose>
								<c:when test="${recipeaddition.additionUse eq 'additionBoiled'}">
									min. gotowania
								</c:when>
								<c:when test="${recipeaddition.additionUse eq 'additionEffervescentFermentation'}">
									dni burzliwej fermentacji
								</c:when>
								<c:when test="${recipeaddition.additionUse eq 'additionSecondFermentation'}">
									dni cichej fermentacji
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:if>
				
			<tr>
				<th colspan="4">Drożdże: </th>
			</tr>
			<tr>
				<td>${recipe.yeast.yeastName}</td>
				<td>${recipe.yeast.yeastLab}</td>
				<td>${recipe.yeast.yeastWeight}g</td>
				<td>${recipe.yeast.yeastForm}</td>
			</tr>
			
			<tr>
				<th>Czas zacierania: </th>
				<td colspan="3">${recipe.mashTime}min.</td>
			</tr>
				
			<tr>
				<th>Temperatura zacierania: </th>
				<td colspan="3">${recipe.mashTemp }&deg;C</td>
			</tr>
			
			<tr>
				<th>Czas gotowania: </th>
				<td colspan="3">${recipe.boilTime}min.</td>
			</tr>
			
			<tr>
				<th>Rozmiar warki: </th>
				<td colspan="3">${recipe.brewSize}L</td>
			</tr>
				
			<tr>
				<th>Dodano: </th>
				<td colspan="3"><fmt:formatDate value="${recipe.added.time}" type="date" dateStyle="short" /></td>
			</tr>
		</table>
	</div>

</body>
</html>