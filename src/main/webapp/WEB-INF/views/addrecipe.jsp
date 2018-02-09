<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
<title>Dodawanie warki</title>
<script type="text/javascript" src="<c:url value="/js/script.js" />"></script>
<style>
	
</style>
</head>
<body>

	<section class="vertical-menu">
		<div class="logo">LĄGO</div>
		<a href="<c:url value="/#" />">Home</a>
		<a href="<c:url value="/recipe/publicrecipes" />">Przepisy publiczne</a>
	
		<sec:authorize access="isAuthenticated()">
			<a href="<c:url value="/recipe/addrecipe" />" class="active">Dodaj warkę</a>
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
		<form:form method="post" modelAttribute="recipe">
			<table class="addrecipe-table">
				<tr>
					<td><label>Nazwa warki: </label></td>
					<td><form:input path="brewName" /></td>
					<td><form:errors path="brewName" cssClass="error" /></td>	
				</tr>
				<tr>
					<td><label>Rozmiar warki (litry): </label></td>
					<td><form:input path="brewSize" /></td>
					<td><form:errors path="brewSize" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Styl piwa: </label></td>
					<td><form:select itemValue="id" itemLabel="styleName" path="beerStyle.id" items="${beerstyles}"></form:select></td>
					<td><form:errors path="beerStyle" cssClass="error" /></td>
				</tr>
			</table>
	
			<div class="phase1">Słody:
				<table id="malts" class="addrecipe-table">
					<tr>
						<td>
							<label>Nazwa: </label> 
							<form:input type="text" path="malts[0].maltName" />
							<form:errors path="malts[0].maltName" cssClass="error" />
						</td>
						<td>
							<label>Ilość(kg): </label> 
							<form:input type="text" path="malts[0].maltWeight" />
							<form:errors path="malts[0].maltWeight" cssClass="error" />
						</td>
					</tr>
				</table>
				<span class="button" id="oneMoreMaltBtn">Kolejny słód</span>
				<span class="button" id="deleteLastMaltBtn">Usuń ostatni</span>
				<br>
			
				<table class="addrecipe-table">
					<tr>
						<td><label>Czas zacierania słodów: </label></td>
						<td><form:input type="text" path="mashTime" /></td>
						<td><form:errors path="mashTime" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Temperatura zacierania słodów: </label></td>
						<td><form:input type="text" path="mashTemp" /></td>
						<td><form:errors path="mashTemp" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Czas gotowania brzeczki: </label></td>
						<td><form:input type="text" path="boilTime" /></td>
						<td><form:errors path="boilTime" cssClass="error" /></td>
					</tr>
				</table>
			</div>
	
			<div class="phase2">Chmiele: 
				<table id="hops" class="addrecipe-table">
					<tr>
						<td>
							<label>Nazwa: </label>
							<form:input type="text" path="hops[0].hopName" />
							<form:errors path="hops[0].hopName" cssClass="error" />
						</td>
						<td>
							<label>Ilość(g): </label>
							<form:input type="text" path="hops[0].hopWeight" />
							<form:errors path="hops[0].hopWeight" cssClass="error" />
						</td>
						<td>
							<label>Czas gotowania chmielu(min): </label>
							<form:input type="text" path="hops[0].hopBoilTime" />
							<form:errors path="hops[0].hopBoilTime" cssClass="error" />
						</td>
					</tr>
				</table>
				<span class="button" id="oneMoreHopBtn"> Kolejny chmiel</span>
				<span class="button" id="deleteLastHopBtn">Usuń ostatni</span>
			</div>
			
			<div class="phase3" class="addrecipe-table">
				<table>
					<tr>
						<td><label>Drożdże: </label></td>
						<td><form:input type="text" path="yeast.yeastName" /></td>
						<td><form:errors path="yeast.yeastName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Forma drożdży: </label></td>
						<td>
							<form:select path="yeast.yeastForm">
								<form:option value="dry">Suche</form:option>
								<form:option value="liquid">Płynne</form:option>
								<form:option value="slurry">Gęstwa</form:option>
							</form:select>
						</td>
						<td><form:errors path="yeast.yeastForm" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Laboratorium (marka): </label></td>
						<td><form:input type="text" path="yeast.yeastLab" /></td>
						<td><form:errors path="yeast.yeastLab" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Ilość drożdży(g): </label></td>
						<td><form:input type="text" path="yeast.yeastWeight" /></td>
						<td><form:errors path="yeast.yeastWeight" cssClass="error" /></td>
					</tr>
				</table>
			</div>
				
			<label>Dodatek: </label>
			<table id="additions" class="addrecipe-table">
				<tr>
					<td>
						<label>Nazwa i ilość dodatku: </label>
						<form:input type="text" path="additions[0].additionName" />
						<form:errors path="additions[0].additionName" cssClass="error" />
					</td>
					<td>
						<label>Czas: </label>
						<form:input type="text" path="additions[0].additionTime" />
						<form:errors path="additions[0].additionTime" cssClass="error" />
					</td>
					<td>
						<form:select path="additions[0].additionUse">
							<form:option value="additionBoiled">Gotowanie (minuty)</form:option>
							<form:option value="additionEffervescentFermentation">Fermentacja burzliwa (dni)</form:option>
							<form:option value="additionSecondFermentation">Fermentacja cicha (dni)</form:option>
						</form:select>
					</td>
					<td><form:errors path="additions[0].additionUse" cssClass="error" /></td>
				</tr>
			</table>
			<span class="button" id="oneMoreAdditionBtn">Kolejny dodatek</span>
			<span class="button" id="deleteLastAdditionBtn">Usuń ostatni</span>
			<br><br>
	
			<label>Przepis publiczny: </label>
			<form:checkbox	path="publicRecipe" />
			<form:errors path="publicRecipe" cssClass="error" />
			<br>
	
			<input type="submit" value="Dodaj przepis">
					
		</form:form>
	</section>

</body>
</html>