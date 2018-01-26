<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uwarz to</title>
</head>
<body>

	<table>
		<tr id="heatWater">
			<th>1. </th>
			<td>
				<c:set var="truncatedWaterAmount"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${waterAmount}" /></c:set>
				Zagrzej ${truncatedWaterAmount}L wody do temperatury ${recipe.mashTemp}&deg;C. 
			</td>
			<td>OK</td>
		</tr>
		
		<tr id="putMaltsIn">
			<th>2. </th>
			<td> 
				Wsyp słody (
				<c:forEach var="malt" items="${recipe.malts}">
					${malt.maltName}-${malt.maltWeight}kg
				</c:forEach>
				) do podgrzanej wody. 
			</td>
			<td>OK</td>
		</tr>
		
		<tr id="maltsMash">
			<th>3. </th>
			<td>Trwa zacieranie słodów: </td>
			<td id="mashTime">${recipe.mashTime }</td>
		</tr>
		
		<tr id="prepareWater">
			<th>4. </th>
			<td>W trakcie zacierania przygotuj ok. 15L wody o temp. 72&deg;C do wysładzania. 
		</tr>
		
		<tr id="mashOut">
			<th>5. </th>
			<td>Podgrzej zacier do 78&deg;C i poczekaj około 5 minut. </td>
			<td>OK</td>
		</tr>
		
		<tr>
			<th>6. </th>
			<td>Odfiltruj brzeczkę z zacieru. </td>
		</tr>
	</table>
	
</body>
</html>