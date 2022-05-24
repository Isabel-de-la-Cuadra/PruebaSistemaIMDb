<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../templates/header.jsp'>
	<jsp:param name='title' value='Home:' />
</jsp:include>

<body>

	<jsp:include page='../templates/navbar2.jsp'>
		<jsp:param name='title' value='Sistema IMDb' />
	</jsp:include>
	<br>
	<div class="ms-5">
	<h1>
		Welcome, ${userIMDbEmail}
	</h1>	
	<br>
	<h3>TV Shows</h3>
	<h3>Choose in the navbar if you want to add a show or choose an
		existing one</h3>

	<br>
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