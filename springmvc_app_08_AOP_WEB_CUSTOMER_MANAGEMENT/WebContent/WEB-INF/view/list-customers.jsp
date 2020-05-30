<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customers List</title>

	<!-- configure css -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Customer" onclick="window.location.href='showCustomerAddForm';return false;"
			class="add-button">
			
			<form:form action="searchCustomer" modelAttribute="customer" method="GET">
				Search Customer : <input type="text" name="searchName" placeholder="enter customer's first name or last name">
				<input type="submit" value="search" class="add-button">
			</form:form>
						
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<!-- loop over customer list from model attribute -->
					<c:forEach var="customer" items="${customerList}">
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<c:url var="updateLink" value="/customer/showCustomerUpdateForm">
								<c:param name="customerId" value="${customer.id}"></c:param>
							</c:url>
							
							<c:url var="deleteLink"  value="/customer/deleteCustomer">
								<c:param name="customerId" value="${customer.id}"></c:param>
							</c:url>
							<td>
								<a href="${updateLink}">Update</a>|
								<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>