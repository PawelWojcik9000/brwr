<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodawanie warki</title>
<script type="text/javascript" src="<c:url value="/js/script.js" />"></script>
<style>
	.error {
		color: red;
	}
</style>
</head>
<body>

	<form:form method="post" modelAttribute="recipe">
		
		<label>Nazwa warki: </label>
		<form:input path="brewName" />
		<form:errors path="brewName" cssClass="error" />
		<br>
		
		<label>Rozmiar warki (litry): </label>
		<form:input path="brewSize" />
		<form:errors path="brewSize" cssClass="error" />
		<br>
		
		<label>Styl piwa: </label>
		<form:select itemValue="id" itemLabel="styleName" path="beerStyle.id" items="${beerstyles}"></form:select>
		<form:errors path="beerStyle" cssClass="error" />
		<br>
		<br>

		<label>Słody:</label>
		<table id="malts">
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
		<input type="button" value="Kolejny słód" id="oneMoreMaltBtn">
		<input type="button" value="Usuń ostatni" id="deleteLastMaltBtn">
		<br> 

		<label>Czas zacierania słodów: </label>
		<form:input type="text" path="mashTime" />
		<form:errors path="mashTime" cssClass="error" />
		<br>
		<label>Temperatura zacierania słodów: </label>
		<form:input type="text" path="mashTemp" />
		<form:errors path="mashTemp" cssClass="error" />
		<br>

		<label>Chmiele: </label>
		<table id="hops">
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
		<input type="button" value="Kolejny chmiel" id="oneMoreHopBtn">
		<input type="button" value="Usuń ostatni" id="deleteLastHopBtn">
		<br>

		<label>Czas gotowania brzeczki: </label>
			<form:input type="text" path="boilTime" /><br>
			<form:errors path="boilTime" cssClass="error" />
		<label>Drożdże: </label>
			<form:input type="text" path="yeast.yeastName" />
			<form:errors path="yeast.yeastName" cssClass="error" />
		<label>Forma drożdży: </label>
			<form:select path="yeast.yeastForm">
			<form:errors path="yeast.yeastForm" cssClass="error" />
				<form:option value="dry" />Suche
				<form:option value="liquid" />Płynne
				<form:option value="slurry" />Gęstwa
			</form:select>
		<label>Laboratorium (marka): </label>
			<form:input type="text" path="yeast.yeastLab" />
			<form:errors path="yeast.yeastLab" cssClass="error" />
		<label>Ilość drożdży(g): </label>
			<form:input type="text" path="yeast.yeastWeight" />
			<form:errors path="yeast.yeastWeight" cssClass="error" />
		
		<label>Dodatek: </label>
		<table id="additions">
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
					<form:errors path="additions[0].additionUse" cssClass="error" />
						<form:option value="additionBoiled" />Gotowanie (minuty)
						<form:option value="additionEffervescentFermentation" />Fermentacja burzliwa (dni)
						<form:option value="additionSecondFermentation" />Fermentacja cicha (dni)
					</form:select>
				</td>
			</tr>
		</table>
		<input type="button" value="Kolejny dodatek" id="oneMoreAdditionBtn">
		<input type="button" value="Usuń ostatni" id="deleteLastAdditionBtn">
		<br>

		<label>Przepis publiczny: </label>
		<form:checkbox	path="publicRecipe" />
		<form:errors path="publicRecipe" cssClass="error" />
		<br>

		<input type="submit" value="Dodaj przepis">
				
	</form:form>

</body>
</html>