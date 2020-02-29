<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!-- used by method 2 -->
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- method 1 -->
    <%-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.4.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script> --%>
    
    <!-- method 2 -->
	<%-- <spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/js/jquery-3.4.1.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />  
	
	<link href="${mainCss}" rel="stylesheet">
	<script type="text/javascript" src="${jqueryJs}" ></script>
	<script type="text/javascript" src="${mainJs}" ></script>   --%>
    
    <!-- method 3 -->
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    
</head>
<body >

<div align="center">
<h1> Welcome to Student Registration</h1>

<form id="submitBtn" >
	If moving text appears it means javascript is loaded successfully.
	<marquee id="msg" scrollamount="30s"></marquee><br><br>
	
	<!-- method 3 -->
	<%-- <img alt="springLogo" src="${pageContext.request.contextPath}/resources/images/spring-logo.png" > --%>
	<!-- method 1 -->
	<%-- <img alt="springLogo" src="<c:url value="/resources/images/spring-logo.png" />" height="150px" width="350px"><br> --%>
	<!-- method 2 -->
	<%-- <img alt="springLogo" src="<spring:url value="/resources/images/spring-logo.png"  />" height="200px" width="500px"><br> --%>
	<img alt="springLogo" src="${pageContext.request.contextPath}/resources/images/spring-logo.png" height="100px" width="300px"><br>
	<input type="button" value="registration" id="submitBtnTest" onclick="submitForm();">
</form>
</div>
</body>
</html>