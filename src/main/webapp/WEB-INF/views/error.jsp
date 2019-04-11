<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
	<h2 class="center">Unfortunate Error</h2>
	<spring:url value="/springiiht/welcome" var="home"></spring:url>
	<div>
		<p>Operation failed due to unfortunate error. Please try again
			later</p>
		<a href="${home}">Home</a>
	</div>
</body>
</html>
