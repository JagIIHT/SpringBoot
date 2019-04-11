<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please enter subject details below to delete</h3>
	<spring:url value="/springiiht/delsubject" var="delsubject"></spring:url>
	<form:form method="POST"
		action="${delsubject}" modelAttribute="subject">
		<table>
			<tr>
				<td><form:label path="subtitle">Subject Title</form:label></td>
				<td><form:input path="subtitle" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete Subject" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
