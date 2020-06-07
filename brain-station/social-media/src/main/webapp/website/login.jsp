<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
</style>
</head>
<body>
	<div class="container">
		<h1>Arif's Social Media</h1>
		<ul class="list-group">
			<li class="list-group-item active">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<span class="navbar-brand">Hey There, Welcome to Arif's Social Media!</span>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto"></ul>
						<div class="form-inline my-2 my-lg-0">
							<a class="btn btn-outline-success my-2 mr-2 my-sm-0" href='<c:url value="/home.html"/>'>Home</a>
						</div>
					</div>
				</nav>
			</li>
			<li class="list-group-item"><c:url value="/website/login"
					var="loginUrl" /> <form:form action="${loginUrl}" method="post">

					<div class="form-group">
						<label>Username:</label> <input class="form-control" type="text" name="username"/>
					</div>

					<div class="form-group">
						<label>Password:</label> <input class="form-control" type="password" name="password"/>
					</div>
					<c:if test="${param.error != null}">
						<div class="text-danger">Bad username/password</div>
					</c:if>
					<input class="btn btn-outline-primary" type="submit" />
				</form:form></li>
		</ul>
	</div>
</body>
</html>








