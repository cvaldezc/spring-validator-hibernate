<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suscripción al evento</title>
</head>
<body>
	<header>
		<h2>Subcripción a Evento</h2>
		<c:if test="${not empty message}"><div class="message green">${message}</div></c:if>
	</header>
	<section> <form:form action="/" modelAttribute="subcriptor">
		<label for="nameInput">Name: </label>
		<form:input path="name" id="nameInput" />
		<form:errors path="name" cssClass="error" />
		<br />

		<label for="ageInput">Age: </label>
		<form:input path="age" id="ageInput" />
		<form:errors path="age" cssClass="error" />
		<br />

		<label for="phoneInput">Phone: </label>
		<form:input path="phone" id="phoneInput" />
		<form:errors path="phone" cssClass="error" />
		<br />

		<label for="emailInput">Email: </label>
		<form:input path="email" id="emailInput" />
		<form:errors path="email" cssClass="error" />
		<br />

		<label for="birthdayInput">Birthday: </label>
		<form:input path="birthday" id="birthdayInput" placeholder="YYYY/MM/DD" />
		<form:errors path="birthday" cssClass="error" />
		<br />

		<label for="genderOptions">Gender: </label>
		<form:select path="gender" id="genderOptions">
			<form:option value="">Select Gender</form:option>
			<form:option value="MALE">Male</form:option>
			<form:option value="FEMALE">Female</form:option>
		</form:select>
		<form:errors path="gender" cssClass="error" />
		<br />

		<input type="submit" value="Submit" />
	</form:form> </section>
</body>
</html>