<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please enter subject details below to search</h3>
	<spring:url value="/springiiht/subjectdetail" var="subjectdetail"></spring:url>
	<form:form method="POST"
		action="${subjectdetail}" modelAttribute="subject">
		<table>
			<tr>
				<td><form:label path="subtitle">Subject Title</form:label></td>
				<td><form:input path="subtitle" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search Subject" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
