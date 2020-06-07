<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Status</title>
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
					<span class="navbar-brand">Welcome to Arif's Social Media! Here you can add your status.</span>				
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto"></ul>
						<div class="form-inline my-2 my-lg-0">
							<sec:authorize access="isAuthenticated()">
								<!-- a post form is required to prevent CSRF attacks. -->
								<c:url value="/logout" var="logoutUrl" />
								<div id="logout">
									<form:form method="post" action="${logoutUrl}">
										<input class="btn btn-outline-success my-2 mr-2 my-sm-0"
											type="submit" value="Logout" />
										<sec:csrfInput />
									</form:form>
								</div>
							</sec:authorize>
						</div>
					</div>
				</nav>
			</li>
			<li class="list-group-item">
				<div class="card border-success mt-3 mb-3">
					<div class="card-header">Status</div>
					<div class="card-body text-success">
						<form:form action="/addStatus" modelAttribute="status">
							<div class="form-group">
								<label for="description">Enter your current status</label>
								<form:input class="form-control" style="height:50px"
									path="description" />
								<form:errors class="text-danger" path="description" />
							</div>

							<div class="form-group">
								<label for="location">Check in location</label>
								<form:select class="form-control" path="location.location">
									<c:forEach var="location" items="${locations}">
										<form:option value="${location.location}"
											label="${location.location}" />
									</c:forEach>
								</form:select>
							</div>


							<div class="form-group">

								<label for="privacy">Choose privacy</label>

								<div>
									<form:radiobutton path="privacy" value="false" />
									<label class="custom-control-label" for="public">Public</label>
								</div>

								<div>
									<form:radiobutton path="privacy" value="true" />
									<label class="custom-control-label" for="private">Private</label>
								</div>

							</div>
							<div>
								<button class="btn btn-success my-2 mr-2 my-sm-0" type="submit">Post</button>
								<a class="btn btn-outline-success my-2 mr-2 my-sm-0"
									href='<c:url value="/home.html"/>'>Cancel</a>
							</div>
						</form:form>
					</div>
				</div>

			</li>
		</ul>
	</div>
</body>
</html>











