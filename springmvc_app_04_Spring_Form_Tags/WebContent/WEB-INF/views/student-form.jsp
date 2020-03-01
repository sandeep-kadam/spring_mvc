<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Student Registration</title>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body onload="onLoad();">

<h1>Student Registration Form</h1>

<form:form action="processForm" method="post" modelAttribute="student">

First Name : <form:input path="firstName"></form:input> <br><br>
Last Name : <form:input path="lastName"></form:input> <br><br>
Country : 
	<%-- <form:select path="country">
		<form:option value="india" label="india"/>
		<form:option value="us" label="us"/>
		<form:option value="china" label="china"/>
		<form:option value="aus" label="aus"/>
	</form:select> --%>
	
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>
	</form:select>
	<br><br>
Favorite Programming Language :
	<%-- <form:radiobutton path="favLanguage" value="Java" />Java
	<form:radiobutton path="favLanguage" value="Pearl" />Pearl
	<form:radiobutton path="favLanguage" value="Python" />Python
	<form:radiobutton path="favLanguage" value="Javacript" />	Javascript --%>
	
	<form:radiobuttons path="favLanguage" items="${student.favLanguageOptions}"/>
	<br><br>
Select Job Profile : 	<form:radiobutton path="jobProfile" value="0" onclick="displayRoleOptions();" />Developer
						<form:radiobutton path="jobProfile" value="1" onclick="displayRoleOptions();" />Tester
	<br><br>
	<h4 id="jobRoleLabel"></h4>
	<div id="devOptionsId">
		<form:checkbox path="devOptions"  value="Front-End Developer" />Front-End Developer
		<form:checkbox path="devOptions"  value="Back-End Developer" />Back-End Developer
		<form:checkbox path="devOptions"  value="Full Stack Developer" />Full Stack Developer
	</div>					
	
	<div id="testerOptionsId">
		<form:checkbox path="testerOptions"  value="Mannual Tester" />Mannual Tester
		<form:checkbox path="testerOptions"  value="Automation Tester" />Automation Tester
	</div>
				
	<br><br>
	<input type="submit" value="Submit">
</form:form>
</body>
</html>