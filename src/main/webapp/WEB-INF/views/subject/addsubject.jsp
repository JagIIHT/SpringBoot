<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please enter Subject details below</h3>
	<spring:url value="/springiiht/submitsubject" var="submitsubject"></spring:url>
	<form:form method="POST"
		action="${submitsubject}"
		modelAttribute="subject">
		<table>
			<tr>
				<td><form:label path="subjectId">ID (Numbers only)</form:label></td>
				<td><form:input path="subjectId" /></td>
			</tr>
			<tr>
				<td><form:label path="subtitle">Subject Title</form:label></td>
				<td><form:input path="subtitle" /></td>
			</tr>
			<tr>
				<td><form:label path="durationInHours">
                      Duration in Hours</form:label></td>
				<td><form:input path="durationInHours" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Subject" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
