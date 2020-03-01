<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

String jobProfile = "";

if(null != request.getAttribute("jobProfile")){
	jobProfile = (String)request.getAttribute("jobProfile");
}


%>
<head>
<title>Student Confirmation Report</title>
</head>
<body>

<h2><i>Student Confirmation Details are given below :</i></h2>

<ul>
	<li>First Name 	: ${student.firstName}</li>
	<li>Last Name 	: ${student.lastName}</li>
	<li>Country 	: ${student.country}</li>
	<li>Favourite Programming Language : ${student.favLanguage}</li>
</ul>
<br><br>
Technical Skills:
<br><br>
Job Profile : <% if("0".equalsIgnoreCase(jobProfile)){%>
				Software Developer
			<%} else if("1".equalsIgnoreCase(jobProfile)){ %>
				Software Tester
			<%}%>
<br><br>

Job Role :  

	<% if("0".equalsIgnoreCase(jobProfile)){%>
	<ul>
		<c:forEach var="current" items="${student.devOptions}">
			<li>${current}</li>
		</c:forEach>
	</ul>	
	<%} else if("1".equalsIgnoreCase(jobProfile)){ %>
		<ul>
		<c:forEach var="current" items="${student.testerOptions}">
			<li>${current}</li>
		</c:forEach>
	</ul>
	<%}%>

</body>
</html>