<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please find subject details below</h3>
	<spring:url value="/springiiht/welcome" var="home"></spring:url>
	<form:form>
		<table>
			<tr>
				<td>ID</td>
				<td>${ subject.subjectId }</td>
			</tr>
			<tr>
				<td>Title</td>
				<td>${ subject.subtitle }</td>
			</tr>
			<tr>
				<td>Duration in hours</td>
				<td>${ subject.durationInHours }</td>
			</tr>
		</table>
		<a href="${home}">Home</a>
	</form:form>
</body>
</html>
