<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit category</title>
</head>
<body>
	<h2>Edit chosen category:</h2>
	<spring:form modelAttribute="category" action="/edit-category" method="POST">
		<table>
			<tr>
				<td>Name:</td>
				<td><spring:input path="name" id="name"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><spring:input path="description" id="name"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Confirm changes"></td>
			</tr>
		</table>
	</spring:form>
</body>
</html>