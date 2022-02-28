<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>New Dojo</title>
		<!--BOOTSTRAP-->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<main class="container">
			<h1>New Dojo</h1>
			<form:form action="/dojos" method="post" modelAttribute="dojo">
				<form:errors path="name" class="alert alert-danger d-block"></form:errors>
				<div class="form-group mb-3">
					<form:label path="name">Name:</form:label>
					<form:input path="name" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-primary">Crear</button>
			</form:form>
		</main>
		
		<!--BOOTSTRAP-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>