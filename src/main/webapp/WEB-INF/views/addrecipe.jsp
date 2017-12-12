<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodawanie warki</title>
<script type="text/javascript" src="<c:url value="/js/script.js" />"></script>
</head>
<body>

	<form:form method="post" modelAttribute="recipe">
		<label>Nazwa warki: </label>
		<form:input path="brewName" />

		<label>Słody:</label>
		<table id="malts">
			<tr>
				<td><label>Nazwa: </label> <form:input type="text" path="malts[0].maltName" /></td>
				<td><label>Ilość(kg): </label> <form:input type="text" path="malts[0].maltWeight" /></td>
			</tr>
		</table>
		<input type="button" value="Kolejny słód" id="oneMoreMaltBtn">
		<input type="button" value="Usuń ostatni" id="deleteLastMaltBtn">
		<br> 

		<label>Czas zacierania słodów: </label>
		<form:input type="text" path="mashTime" />
		<br>
		<label>Temperatura zacierania słodów: </label>
		<form:input type="text" path="mashTemp" />
		<br>

		<label>Chmiele: </label>
		<table id="hops">
			<tr>
				<td><label>Nazwa: </label><form:input type="text" path="hops[0].hopName" /></td>
				<td><label>Ilość(g): </label><form:input type="text" path="hops[0].hopWeight" /></td>
				<td><label>Alfakwasy: </label><form:input type="text" path="hops[0].alphaAcids" /></td>
				<td><label>Rok uprawy: </label><form:input type="text" path="hops[0].hopYear" /></td>
				<td><label>Czas gotowania chmielu(min): </label><form:input type="text" path="hops[0].hopBoilTime" /></td>
			</tr>
		</table>
		<input type="button" value="Kolejny chmiel" id="oneMoreHopBtn">
		<input type="button" value="Usuń ostatni" id="deleteLastHopBtn">
		<br>

		<label>Czas gotowania brzeczki: </label>
			<form:input type="text" path="boilTime" /><br>
		<label>Drożdże: </label>
			<form:input type="text" path="yeast.yeastName" />
		<label>Forma drożdży: </label>
		<form:select path="yeast.yeastForm">
			<form:option value="dry" />Suche
			<form:option value="liquid" />Płynne
			<form:option value="slurry" />Gęstwa
		</form:select>
		<label>Laboratorium (marka): </label><form:input type="text" path="yeast.yeastLab" />
		<label>Ilość drożdży(g): </label><form:input type="text" path="yeast.yeastWeight" />
		
		<label>Dodatek: </label>
		<table id="additions">
			<tr>
				<td><label>Nazwa i ilość dodatku: </label><form:input type="text" path="additions[0].additionName" /></td>
				<td><label>Czas: </label><form:input type="text" path="additions[0].additionTime" />
					<form:select path="additions[0].additionUse">
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

<%--

		<label>Ilość dni fermentacji burzliwej: </label>
			<form:input type="text" path="effervescentFermentationDays" />
		<br>
		<label>Ilość dni fermentacji cichej: </label>
			<form:input type="text" path="secondFermentationDays" />
		<br>

--%>

		<input type="submit" value="Dodaj przepis">
				
	</form:form>

</body>
</html>