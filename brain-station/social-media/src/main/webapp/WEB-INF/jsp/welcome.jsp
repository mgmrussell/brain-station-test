<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
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

					<sec:authorize access="isAuthenticated()">
						<span class="navbar-brand">Hello ${firstName}, Welcome to Arif's Social Media! Here are some current statuses:</span>
					</sec:authorize>

					<sec:authorize access="isAnonymous()">
						<span class="navbar-brand">Hey There, Welcome to Arif's Social Media! Here are some public statuses:</span>
					</sec:authorize>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto"></ul>
						<div class="form-inline my-2 my-lg-0">
							<sec:authorize access="isAnonymous()">
								<a class="btn btn-outline-success my-2 mr-2 my-sm-0"
									href='<c:url value="website/login.jsp"/>'>Login</a>
								<a class="btn btn-outline-success my-2 mr-2 my-sm-0"
									href='<c:url value="/newUser.html"/>'>Register</a>
							</sec:authorize>

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
			
			<c:forEach items="${statuses}" var="status">
				<%-- Display only public statuses and private for logged in users --%>
				<c:if
					test="${status.privacy == false || authenticated && status.user.username == username}">

					<li class="list-group-item">
						<div class="container row">
							<div class="col">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 12 16"
									width="12" height="16">
									<path fill-rule="evenodd"
										d="M12 14.002a.998.998 0 01-.998.998H1.001A1 1 0 010 13.999V13c0-2.633 4-4 4-4s.229-.409 0-1c-.841-.62-.944-1.59-1-4 .173-2.413 1.867-3 3-3s2.827.586 3 3c-.056 2.41-.159 3.38-1 4-.229.59 0 1 0 1s4 1.367 4 4v1.002z"></path></svg>
								${status.user.title} ${status.user.lastName}
							</div>
							<div class="w-100"></div>
							<div class="col">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"
									width="16" height="16">
									<path fill-rule="evenodd"
										d="M16 8.5l-6 6-3-3L8.5 10l1.5 1.5L14.5 7 16 8.5zM5.7 12.2l.8.8H2c-.55 0-1-.45-1-1V3c0-.55.45-1 1-1h7c.55 0 1 .45 1 1v6.5l-.8-.8c-.39-.39-1.03-.39-1.42 0L5.7 10.8a.996.996 0 000 1.41v-.01zM4 4h5V3H4v1zm0 2h5V5H4v1zm0 2h3V7H4v1zM3 9H2v1h1V9zm0-2H2v1h1V7zm0-2H2v1h1V5zm0-2H2v1h1V3z"></path></svg>
								${status.description}
							</div>

							<div class="w-100"></div>
							<div class="col">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 12 16"
									width="12" height="16">
									<path fill-rule="evenodd"
										d="M6 0C2.69 0 0 2.5 0 5.5 0 10.02 6 16 6 16s6-5.98 6-10.5C12 2.5 9.31 0 6 0zm0 14.55C4.14 12.52 1 8.44 1 5.5 1 3.02 3.25 1 6 1c1.34 0 2.61.48 3.56 1.36.92.86 1.44 1.97 1.44 3.14 0 2.94-3.14 7.02-5 9.05zM8 5.5c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"></path></svg>
								${status.location.location}
							</div>

							<%--Display only if user is logged in --%>
							<c:if test="${authenticated && status.user.username == username}">
								<div class="w-100"></div>
								<div class="col">
									<a class="btn btn-outline-success my-2 mr-2 my-sm-0" href="<c:url value="/editStatus?id=${status.id}"/>">Edit</a>
								</div>
							</c:if>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</ul>

		<sec:authorize access="isAuthenticated()">
			<a class="btn btn-outline-success my-2 mr-2 my-sm-0" href="<c:url value="/newStatus.html"/>">Post a new Status</a>
		</sec:authorize>
	</div>
</body>
</html>



