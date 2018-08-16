<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aircraft Add Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>

	<div>
		<a href="/">Home</a>
	</div>

	<springForm:form method="POST" modelAttribute="aircraftRequest"
		action="addAircraft">
		<c:if test="${not empty msg}">
			<div class="error">
				<h2>${msg}</h2>
			</div>
		</c:if>
		<table>
			<tr>
				<td>AirCraft ID:</td>
				<td><springForm:input path="id" /></td>
				<td><springForm:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<td>AirCraft Type:</td>
				<td><springForm:select path="type" items="${airCraftTypes}" /></td>
				<td><springForm:errors path="type" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Aircraft Size:</td>
				<td><springForm:select path="size" items="${airCraftSizes}" /></td>
				<td><springForm:errors path="size" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="EnQueue Aircraft"></td>
			</tr>
		</table>

	</springForm:form>

</body>
</html>
