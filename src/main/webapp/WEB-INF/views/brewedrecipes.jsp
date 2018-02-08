<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zakończone warki</title>
<style>

	table, th, td {
		border-bottom: 1px solid #153cd8;
		border-collapse: collapse;
		padding: 5px 15px 5px 15px;
	}
	
	.recipepreview {
		display: inline-block; 
		height : 200px;
		width: 400px;
		background-color: #e5e5e5;
		margin: 20px;
		height: 200px;
	}
	
	.recipepreview > table{
		margin-left:auto; 
    	margin-right:auto;
	}
	
</style>
</head>
<body>

	<c:forEach items="${brewedrecipes}" var="recipe">
		<div class="recipepreview">
			<table>
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
					<td>Data warzenia:</td>
					<td><fmt:formatDate value="${recipe.brewed.time}" type="date" dateStyle="short" /></td>
				</tr>
				<c:choose>
					<c:when test="${empty recipe.notes}">
						<tr>
							<td colspan="2"><a href="<c:url   value="/recipe/addnotes/${recipe.id}"/>">Dodaj notatki</a></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>Notatki:</td> 
						</tr>
						<tr>
							<td><div style="width: 300px;	height: 200px;">${recipe.notes}</div></td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="2"><a href="<c:url   value="/recipe/showrecipe/${recipe.id}"/>">Pokaż przepis</a></td>
				</tr>
			</table>
		</div>
	</c:forEach>
	

</body>
</html>