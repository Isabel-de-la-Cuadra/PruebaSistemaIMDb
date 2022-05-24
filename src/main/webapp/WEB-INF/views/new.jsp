<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../templates/header.jsp'>
	<jsp:param name='title' value='New:' />
</jsp:include>

<body>

	<jsp:include page='../templates/navbar2.jsp'>
		<jsp:param name='title' value='Sistema IMDb' />
	</jsp:include>
	<br>
	<div class="ms-5">
		<h3>Create a new Show</h3>
	</div>
	<br>

	<div class="row justify-content-sm-center h-150">
		<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
			<div class="card shadow-lg" id="card">
				<div class="card-body p-5">

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

					<form:form method="POST" action="/show/add" modelAttribute="show">

						<div class="mb-3">
							<form:input type="text" class="form-control" path="showTittle"
								placeholder="Show Title" />
							<form:errors path="showTittle" class="text-danger" />
						</div>

						<div class="mb-3">
							<form:input type="text" class="form-control" path="showNetwork"
								placeholder="Network" />
							<form:errors path="showNetwork" class="text-danger" />
						</div>

						<div class="contenedor-icono">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button type="submit" class="btn btn-primary ms-auto">
								Create</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="ms-5">
		<a href="/" class="btn btn-success"> Go Back </a>
	</div>
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