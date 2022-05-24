<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../templates/header.jsp'>
	<jsp:param name='title' value='Register:' />
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
					<div class="card shadow-lg" id="card">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title mb-4">Register</h1>

							<c:if test="${msgError !=null}">
								<div class="alert alert-danger" role="alert">
									<c:out value="${msgError}"></c:out>
								</div>

							</c:if>

							<form:form  method="POST" action="/register" modelAttribute="userIMDb">
							
								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="username">Username: </form:label> 
									<form:input type="text" class="form-control" path="username"
										value="" placeholder="myusername" />
									<form:errors path="username" class="text-danger"/>
								</div>
	    			
								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="email">Email: </form:label> 
									<form:input type="email" class="form-control" path="email"
										value="" placeholder="email2@email2.com" />
									<form:errors path="email" class="text-danger"/>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="password">Password:</form:label>
									<form:input type="password" class="form-control"
										path="password" placeholder="Enter your password" />
									<form:errors path="password" class="text-danger"/>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="passwordConfirmation">Password Confirmation:</form:label>
									<form:input type="password" class="form-control"
										path="passwordConfirmation" placeholder="Re-enter your password" />
									<form:errors path="passwordConfirmation" class="text-danger"/>
								</div>
								
								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-primary ms-auto">
										Register</button>
								</div>
							</form:form>
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