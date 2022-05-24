<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../templates/header.jsp'>
	<jsp:param name='title' value='Login:' />
</jsp:include>

<body>

	<jsp:include page='../templates/navbar1.jsp'>
		<jsp:param name='title' value='Sistema IMDb' />
	</jsp:include>

	<br>
	<br>

	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg" id="card" >
						<div class="card-body p-5">
							<h1 class="fs-4 card-title mb-4">Login</h1>

							<c:if test="${msgError !=null}">
								<div class="alert alert-danger" role="alert">
									<c:out value="${msgError}"></c:out>
								</div>
							</c:if>

							<c:if test="${msgOk !=null}">
								<div class="alert alert-success" role="alert">
									<c:out value="${msgOk}"></c:out>
								</div>
							</c:if>

							<form method="POST" action="login" autocomplete="off">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">Email address</label> <input
										id="email" type="email" class="form-control" name="username"
										value="" placeholder="enter your email" required
										autofocus>
									<div class="invalid-feedback">Invalid email</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="password">Password</label>
									<input id="password" type="password" class="form-control"
										name="password" placeholder="enter your password" required>
									<div class="invalid-feedback">The password is necessary</div>
								</div>
								
								<div class="align-items-center d-flex">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<button type="submit" class="btn btn-primary ms-auto" id="botonColor">
										Login</button>
								</div>
							
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<br>
	<br>

	<jsp:include page='../templates/footer.jsp'>
		<jsp:param name='title' value='Sistema IMDb' />
	</jsp:include>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js ">
	</script>

</body>
</html>