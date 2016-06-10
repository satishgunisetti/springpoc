<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up Form</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css">
<link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Offer</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/docreate" method="post" commandName="offer">

		<h1>Create Advert</h1>

		<fieldset>
			<legend>
				<span class="number">1</span>Enter info
			</legend>

			<label for="name">Name:</label>
			<form:input type="text" id="name" path="name" />
			<form:errors path="name" cssClass="error"></form:errors>

			<label for="mail">Email:</label>
			<form:input type="email" id="mail" path="email" />
			<form:errors path="email" cssClass="error"></form:errors>

			<legend>
				<span class="number">2</span>Your Offer
			</legend>
			<label for="bio">Offer:</label>
			<form:textarea id="bio" path="text"></form:textarea>
			<form:errors path="text" cssClass="error"></form:errors>
		</fieldset>

		<button type="submit">Submit Advert</button>
	</form:form>



</body>
</html>