<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>New Ninja</title>
		<!--BOOTSTRAP-->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container">
			<h1>New Ninja</h1>
			<form:form action="/ninjas" method="post" modelAttribute="ninja">
				<form:errors path="dojo" class="alert alert-danger d-block"></form:errors>
				<form:errors path="firstName" class="alert alert-danger d-block"></form:errors>
				<form:errors path="lastName" class="alert alert-danger d-block"></form:errors>
				<form:errors path="age" class="alert alert-danger d-block"></form:errors>
				<div class="form-group mb-3">
					<form:label path="dojo">Select Dojo:</form:label>
					<form:select path="dojo" class="form-control">
						<c:forEach var="dojoItem" items="${dojoList}">
							<form:option value="${dojoItem.getId()}">
								<c:out value="${dojoItem.getName()}"></c:out>
							</form:option>
						</c:forEach>		
					</form:select>
				</div>
				<div class="form-group mb-3">
					<form:label path="firstName">First Name:</form:label>
					<form:input path="firstName" class="form-control"/>
				</div>
				<div class="form-group mb-3">
					<form:label path="lastName">Last Name:</form:label>
					<form:input path="lastName" class="form-control"/>
				</div>
				<div class="form-group mb-3">
					<form:label path="age">Age:</form:label>
					<form:input path="age" class="form-control" type="number"/>
				</div>
				<button type="submit" class="btn btn-primary">Crear</button>
			</form:form>
		</div>
		
		<!--BOOTSTRAP-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>