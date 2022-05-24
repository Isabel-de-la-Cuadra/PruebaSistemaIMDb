<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../templates/header.jsp'>
	<jsp:param name='title' value='Rating:' />
</jsp:include>

<body>

	<jsp:include page='../templates/navbar2.jsp'>
		<jsp:param name='title' value='Sistema IMDb' />
	</jsp:include>
	<br>
	
	<div class="container">
		<h1>${userIMDbEmail} do you want to rating this show?</h1>
		<br>
		<h3>TV Shows</h3>
		<h3>Title: ${ShowId.showTittle}</h3>
		<h3>Network: ${ShowId.showNetwork}</h3>
		<br>
		<div class="mb-3">
			<form:label class="form-label" path="rating">Select the level of your rating</form:label>
			<form:select class="form-select" path="rating">
				<form:options path="rating" items="${rating}" />
			</form:select>
		</div>
	
		<div class="contenedor-icono">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<a class="btn btn-primary ms-auto">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-check2" viewBox="0 0 16 16">
  										<path
						d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
									</svg>
				Rating
			</a>
		</div>
</div>
	<br>

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