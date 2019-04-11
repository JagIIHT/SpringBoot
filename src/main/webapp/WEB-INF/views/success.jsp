<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
	<h2 class="center">Completed Successfully!!!</h2>
	<spring:url value="/springiiht/welcome" var="home"></spring:url>
	<div>
		<p>${ message }</p>
		<a href="${home}">Home</a>
	</div>
</body>
</html>
