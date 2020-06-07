<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Register</title>
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
					<span class="navbar-brand">Hey There, Welcome to Arif's
						Social Media!</span>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto"></ul>
						<div class="form-inline my-2 my-lg-0">
							<a class="btn btn-outline-success my-2 mr-2 my-sm-0"
								href='<c:url value="/home.html"/>'>Home</a>
						</div>
					</div>
				</nav>
			</li>
			<li class="list-group-item">

				<div class="card border-success mt-3 mb-3">
					<div class="card-header">New User Registration</div>
					<div class="card-body text-success">


						<form:form action="/addUser" modelAttribute="user">


							<div class="form-group">
								<label for="title">Title</label>
								<form:select class="form-control" path="title">
									<form:option value="Mr." label="Mr." />
									<form:option value="Ms." label="Ms." />
									<form:option value="Miss." label="Miss." />
									<form:option value="Dr." label="Dr." />
								</form:select>
							</div>


							<div class="form-group">
								<label for="firstName">First Name</label>
								<form:input class="form-control" path="firstName" />
								<form:errors class="text-danger" path="firstName" />
							</div>

							<div class="form-group">
								<label for="lastName">Last Name</label>
								<form:input class="form-control" path="lastName" />
								<form:errors class="text-danger" path="lastName" />
							</div>

							<div class="form-group">
								<label for="username">Create a username</label>
								<form:input class="form-control" path="username" />
								<form:errors class="text-danger" path="username" />
							</div>


							<div class="form-group">
								<label for="password">Create a password</label>
								<form:input class="form-control" path="password" />
								<form:errors class="text-danger" path="password" />
							</div>
							<div>
								<button class="btn btn-success my-2 mr-2 my-sm-0" type="submit">Create
									Profile</button>
							</div>
						</form:form>
					</div>
				</div>

			</li>
		</ul>
	</div>
</body>
</html>















