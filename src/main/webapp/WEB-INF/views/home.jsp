<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form:form>
	<h2>Please choose options from below appropriately</h2>
	<spring:url value='/springiiht/searchbook' var="searchbook"></spring:url>
	<spring:url value='/springiiht/addbook' var="addbook"></spring:url>
	<spring:url value='/springiiht/deletebook' var="deletebook"></spring:url>
	<spring:url value='/springiiht/searchsubject' var="searchsubject"></spring:url>
	<spring:url value='/springiiht/deletesubject' var="deletesubject"></spring:url>
	<spring:url value='/springiiht/addsubject' var="addsubject"></spring:url>
	<table>
		<tr>
			<td>1</td>
			<td><a href="${addsubject}">Add Subject</a></td>
		</tr>
		<tr>
			<td>2</td>
			<td><a href="${addbook}">Add Book</a></td>
		</tr>
		<tr>
			<td>3</td>
			<td><a href="${deletesubject}">Delete Subject</a></td>
		</tr>
		<tr>
			<td>4</td>
			<td><a href="${deletebook}">Delete Book</a></td>
		</tr>
		<tr>
			<td>5</td>
			<td><a href="${searchbook}">Search Book</a></td>
		</tr>
		<tr>
			<td>6</td>
			<td><a href="${searchsubject}">Search Subject</a></td>
		</tr>
	</table>
</form:form>
