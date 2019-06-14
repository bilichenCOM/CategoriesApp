<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All categories</title>
</head>
<body>
	<h2>Categories table:</h2>
	<table>
		<tr>
			<th>Category ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach var="cat" items="${categories}">
			<tr>
				<td>${cat.id}</td>
				<td>${cat.name}</td>
				<td>${cat.description}</td>
				<td>
					<a href="/edit-category?c_id=${cat.id}">
						<input type="button" value="Edit"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>