<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
	<div>
		<c:if test="${not empty msg}">
			<h2>${msg}</h2>
		</c:if>
	</div>
	<div>
		Click on <strong><a href="addAircraftForm">Add</a></strong> to EnQueue
		Aircraft.
	</div>
	<div>
		Click on <strong><a href="deleteAircraftForm">Delete</a></strong> to
		DeQueue Aircraft.
	</div>
	<div>
		Click on <strong><a href="showAircrafts">DisplayAircrafts</a></strong>
		to Display List Of Aircrafts.
	</div>
</body>
</html>