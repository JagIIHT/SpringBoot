<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please enter book details below to delete</h3>
	<spring:url value="/springiiht/delbook" var="delbook"></spring:url>
	<form:form method="POST"
		action="${delbook}" modelAttribute="book">
		<table>
			<tr>
				<td><form:label path="title">Book Title</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete Book" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
