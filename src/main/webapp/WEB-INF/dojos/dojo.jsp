<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Dojo Page</title>
		<!--BOOTSTRAP-->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<main class="container">
			<h1><c:out value="${dojo.getName()}"></c:out></h1>
			<div class="table-container">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Apellido</th>
							<th scope="col">Age</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ninja" items="${dojo.getNinjas()}">
							<tr>
								<td><c:out value="${ninja.getFirstName()}"></c:out></td>
								<td><c:out value="${ninja.getLastName()}"></c:out></td>
								<td><c:out value="${ninja.getAge()}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
		
		<!--BOOTSTRAP-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>