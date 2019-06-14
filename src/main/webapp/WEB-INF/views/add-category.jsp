<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add category</title>
</head>
<body>
	<h2>Create new Category</h2>

	<spring:form modelAttribute="category" action="/add-category" method="POST">
		<table>
			<tr>
				<td>Name:</td>
				<td><spring:input path="name" id="name"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><spring:input path="description" id="description"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</spring:form>
</body>
</html>