<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Spring MVC course registration form:</h1>

	<form action="processFormVersiontwo" method="post">
		<input type="text" name="userName" placeholder="What's your name?"><br> 
		<input type="submit" value="Click Me">
	</form>
</body>
</html>
