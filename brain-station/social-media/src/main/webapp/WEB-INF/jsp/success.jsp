<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Success</title>
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
			<li style="min-height:100px;" class="list-group-item">Congratulations! Your profile has been created and you are now logged in and can post a statuses.</li>
		</ul>
	</div>
</body>
</html>


 