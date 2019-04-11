<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please enter book details below to search</h3>
	<spring:url value="/springiiht/bookdetail" var="bookdetail"></spring:url>
	<form:form method="POST"
		action="${bookdetail}" modelAttribute="book">
		<table>
			<tr>
				<td><form:label path="title">Book Title</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search Book" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
