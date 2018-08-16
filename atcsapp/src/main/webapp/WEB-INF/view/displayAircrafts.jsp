<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Registration Page</title>
</head>
<body>

	<div>
		<a href="/">Home</a>
	</div>
	<c:choose>
		<c:when test="${not empty airCraftsList}">
			<table>
				<tr>
					<th>AirCraft Id:</th>
					<th>AirCraft Type:</th>
					<th>AirCraft Size:</th>
				</tr>
				<c:forEach var="airCraft" items="${airCraftsList}">
					<tr>
						<td>${airCraft.id}</td>
						<td>${airCraft.type}</td>
						<td>${airCraft.size}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h2>${msg}</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>