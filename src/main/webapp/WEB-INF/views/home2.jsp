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
	<h1> Welcome, <jsp:param name='userIMDbEmail' value='${userIMDbEmail}' /></h1>
	<br>
	<h3> TV Shows</h3>
	<br>
	
	<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Show</th>
						<th scope="col">Network</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="show" items="${listShows}">
						<tr>
							<th scope="row"><c:out value="${show.id}"></c:out></th>
							<td><c:out value="${show.showTitte}"></c:out></td>
							<td><c:out value="${show.showNetwork}"></c:out></td>
							<td><a class="btn btn-primary"
								href="/show/${show.id}" role="button"> Select
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="row">
				<div class="col-md-2"></div>
				<h4 class="fs-6 fst-italic">(Exist ${totalElements} shows)</h4>
				<h4 class="fs-6 fst-italic">(I will show them from ${size}
					shows)</h4>
				<div class="col-md-8">
					<nav aria-label="Pagination">
						<ul class="pagination pagination-lg justify-content-center">
							<c:forEach begin="1" end="${totalPages}" var="page">
								<li class="page-item"><a class="page-link"
									href="list?page=${page}&size=${size}">${page}</a></li>
							</c:forEach>
						</ul>
					</nav>
				</div>
				<div class="col-md-2"></div>
			</div>
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