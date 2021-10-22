<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Trisys Training CRUD Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand"> Training App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/address"
					class="nav-link">Address</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">


		<div class="container">
			<h3 class="text-center">List of Addresses</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/address?action=new"
					class="btn btn-success">Add New Address</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Country</th>
						<th>Streetline1</th>
						<th>Streetline2</th>
						<th>City</th>
						<th>Pin</th>
						<th>State</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="address" items="${listAddress}">

						<tr>
							<td><c:out value="${address.id}" /></td>
							<td><c:out value="${address.name}" /></td>
							<td><c:out value="${address.email}" /></td>
							<td><c:out value="${address.country}" /></td>
							<td><c:out value="${address.streetline1}" /></td>
							<td><c:out value="${address.streetline2}" /></td>
							<td><c:out value="${address.city}" /></td>
							<td><c:out value="${address.pin}" /></td>
							<td><c:out value="${address.state}" /></td>

							<td><a
								href="<%=request.getContextPath()%>/address?action=edit&&id=<c:out value='${address.id}' />">Edit</a>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>