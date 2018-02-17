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
<title>Uwarz to</title>
<script type="text/javascript" src="<c:url value="/js/brewit.js" />"></script>

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
			<a href="<c:url value="/logout" />">Wyloguj: ${loggeduser}</a>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
			<a href="<c:url value="/user/adduser" />">Załóż konto</a>
			<a href="<c:url value="/login" />">Zaloguj</a>
		</sec:authorize>
	</section>
	
	<section class="main">
		<div class="show-recipe-table">
			<table>
				<tr>
					<th>1. </th>
					<td>
						<c:set var="truncatedWaterAmount"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${waterAmount}" /></c:set>
						Zagrzej ${truncatedWaterAmount}L wody do temperatury ${recipe.mashTemp}&deg;C. 
					</td>
					<td><button class="okbtn" id="ok">OK</button></td>
				</tr>
				
				<tr>
					<th>2. </th>
					<td> 
						Wsyp słody (
						<c:forEach var="malt" items="${recipe.malts}">
							${malt.maltName}-${malt.maltWeight}kg
						</c:forEach>
						) do podgrzanej wody. 
					</td>
					<td><button class="okbtn" id="ok">OK</button></td>
				</tr>
				
				<tr>
					<th>3. </th>
					<td>W trakcie zacierania przygotuj ok. 15L wody o temp. 72&deg;C do wysładzania. 
					<td><button class="okbtn" id="ok">OK</button></td>
				</tr>
		
				<tr>
					<th>4. </th>
					<td>Trwa zacieranie słodów: </td>
					<td><button class="okbtn" id="countdown">${recipe.mashTime}</button></td>
				</tr>
				
				<tr>
					<th>5. </th>
					<td>Podgrzej zacier do 78&deg;C i poczekaj około 5 minut. </td>
					<td><button class="okbtn">OK</button></td>
				</tr>
				
				<tr>
					<th>6. </th>
					<td>Odfiltruj brzeczkę z zacieru do gara i postaw na ogniu. Poczekaj aż zacznie się gotować. </td>
					<td><button class="okbtn">OK</button></td>
				</tr>
				
				<tr>
					<th>7. </th>
					<td>Trwa warzenie: 
		
						<c:if test="${not empty recipe.hops[0].hopName}">
							<c:forEach var="hop" items="${recipe.hops}">
								<c:choose>
									<c:when test="${recipe.boilTime - hop.hopBoilTime <= 0 or empty hop.hopBoilTime}">
										<ul class="hop">
											<li>
												${hop.hopWeight}g chmielu ${hop.hopName} dodaj od razu na początku gotowania. 
											</li>
										</ul>
									</c:when>
									<c:otherwise>
										<ul class="hop">
											<li>
												${hop.hopWeight}g chmielu ${hop.hopName} dodaj za: <span class="hopAddTime">${recipe.boilTime - hop.hopBoilTime}</span>
											</li>
										</ul>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
						<c:if test="${not empty recipe.additions[0].additionName}">
							<c:forEach var="addition" items="${recipe.additions}">
								<c:if test="${addition.additionUse eq 'additionBoiled'}">
									<c:choose>
										<c:when test="${recipe.boilTime - addition.additionTime <= 0}">
											<ul class="addition">
												<li>
													${addition.additionName} dodaj od razu na początku gotowania.
												</li>
											</ul>
										</c:when>
										<c:otherwise>
											<ul class="addition">
												<li>
													${addition.additionName} dodaj za: <span class="additionAddTime">${recipe.boilTime-addition.additionTime}</span>
												</li>
											</ul>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
						</c:if>
		
					</td>
					<td><button class="okbtn" id="countdown">${recipe.boilTime}</button></td>
					
				</tr>
				
				<tr>
					<th>8. </th>
					<td>Schłódź brzeczkę do temperatury zadania drożdży i przelej do fermentora<br> pozostawiając osad chmielowy na dnie. </td>
					<td><button class="okbtn">OK</button></td>
				</tr>
				
				<tr>
					<th>9. </th>
					<td>Dodaj do brzeczki drożdże i pozostaw piwo na ok. 2 tygodnie fermentacji<br> w temperaturze pracy drożdży zalecanej przez producenta.</td>
					<td><button class="okbtn">OK</button></td>
				</tr>
		
				<tr>
						<th>10. </th>
						<td>Zakończono proces warzenia piwa. </td>
						<td><button class="okbtn" id="finishbrewing">OK</button></td>
				</tr>
				
			</table>
			
			
				<div id="finished-brewing">
					<a href="<c:url		value="/recipe/brewedrecipe/${recipe.id} "/>"><div class="button">Dodaj do zakończonych warek</div></a>
				</div>
			
		</div>	
	</section>
</body>
</html>