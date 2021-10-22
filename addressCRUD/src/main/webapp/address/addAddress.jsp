<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="address" method="post">
					<input type="hidden" name="action" value="save" />
					<caption>
						<h2>
							<c:if test="${address != null}">
            			Edit Address
            		</c:if>
							<c:if test="${address == null}">
            			Add New Address
            		</c:if>
						</h2>
					</caption>

					<c:if test="${address != null}">
						<input type="hidden" name="id"
							value="<c:out value='${address.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Name</label> <input type="text"
							value="<c:out value='${address.name}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Email</label> <input type="text"
							value="<c:out value='${address.email}' />" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>Country</label> <input type="text"
							value="<c:out value='${address.country}' />" class="form-control"
							name="country">
					</fieldset>

					<fieldset class="form-group">
						<label>Streetline1</label> <input type="text"
							value="<c:out value='${address.streetline1}' />"
							class="form-control" name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>Streetline2</label> <input type="text"
							value="<c:out value='${address.streetline2}' />"
							class="form-control" name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>City</label> <input type="text"
							value="<c:out value='${address.city}' />" class="form-control"
							name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>Pin</label> <input type="text"
							value="<c:out value='${address.pin}' />" class="form-control"
							name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>State</label> <input type="text"
							value="<c:out value='${address.state}' />" class="form-control"
							name="country">
					</fieldset>



					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>