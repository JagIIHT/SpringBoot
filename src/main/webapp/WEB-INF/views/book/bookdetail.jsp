<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
</head>
<body>
	<h3>Please find book details below</h3>
	<spring:url value="/springiiht/welcome" var="home"></spring:url>
	<form:form>
		<table>
			<tr>
				<td>ID</td>
				<td>${ book.bookId }</td>
			</tr>
			<tr>
				<td>Title</td>
				<td>${ book.title }</td>
			</tr>
			<tr>
				<td>Price</td>
				<td>${ book.price }</td>
			</tr>
			<tr>
				<td>Volume</td>
				<td>${ book.volume }</td>
			</tr>
			<tr>
				<td>Publish Date</td>
				<td>${ book.publishDate }</td>
			</tr>
		</table>
		<a href="${home}">Home</a>
	</form:form>
</body>
</html>
