<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer Confirmation</title>
</head>
<body>

<h2><i>Customer Confirmation Details are given below :</i></h2>

<ul>
	<li>First Name 	: ${customer.firstName}</li>
	<li>Last Name 	: ${customer.lastName}</li>
	<li>Customer Age : ${customer.age}</li>
	<li>Postal Code : ${customer.postalCode}</li>
</ul>

</body>
</html>