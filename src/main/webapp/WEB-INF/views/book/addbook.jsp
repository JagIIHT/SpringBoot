<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please enter book details below</h3>
	<spring:url value="/springiiht/submitbook" var="submitbook"/>
	<form:form method="POST"
		action="${submitbook}" modelAttribute="book">
		<table>
			<tr>
				<td><form:label path="bookId">ID (Numbers only)</form:label></td>
				<td><form:input path="bookId" /></td>
			</tr>
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
                      Price</form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="volume">
                      Volume (Numbers only)</form:label></td>
				<td><form:input path="volume" /></td>
			</tr>
			<tr>
				<td><form:label path="publishDate">
                      Publish Date</form:label></td>
				<td><form:input type="date" path="publishDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Book" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
