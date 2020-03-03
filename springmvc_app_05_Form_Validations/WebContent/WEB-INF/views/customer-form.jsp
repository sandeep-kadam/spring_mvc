<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Student Registration</title>

	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
<h1>Customer Registration Form</h1>

<br><br>

<i>Fields marked with Asterisk (<span class="star">*</span>) are mandatory.</i>

<br><br>

<form:form action="processForm" method="post" modelAttribute="customer">

First Name 	: <form:input path="firstName"/> 

<br><br>

Last Name(<span class="star">*</span>) 	: <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>

<br><br>

Age(<span class="star">*</span>) : <form:input path="age"/> 
	<form:errors path="age" cssClass="error"></form:errors>	
<br><br>

Postal Code(<span class="star">*</span>) : <form:input path="postalCode"/> 
	<form:errors path="postalCode" cssClass="error"></form:errors>				

<br><br>			
	<input type="submit" value="Submit">
</form:form>
</body>
</html>