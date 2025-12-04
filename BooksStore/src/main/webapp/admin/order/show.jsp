<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta
	http-equiv="X-UA-Compatible"
	content="IE=edge"
/>
<meta
	name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no"
/>
<meta
	name="description"
	content=""
/>
<meta
	name="author"
	content=""
/>
<title>Orders Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet"
/>
<link
	href="/assets/css/styles.css"
	rel="stylesheet"
/>
<script
	src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"
></script>
</head>
<body class="sb-nav-fixed">
	<c:import url="/admin/layouts/navbar.jsp" />
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav
				class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion"
			>
				<c:import url="/admin/layouts/sidebar.jsp" />
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<a
						style="float: right;"
						class="btn btn-danger my-2 "
						href="/admin/create-user"
					> Create user</a>
					<table class="table table-bordered table-hover mt-3">
						<thead class="table-dark">
							<tr>
								<td>ID</td>
								<th>User Id</th>
								<th>Tên Sách</th>
								<th>Giá</th>
								<th>Số lượng</th>
								<th>Đã mua</th>
								<th>Ngày mua</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach
								var="i"
								items="${ds}"
							>
								<tr>
									<td>${i.getMaChiTietHD()}</td>
									<td>${i.getHoaDon().getUser().getId()}</td>
									<td>${i.getSach().getTenSach()}</td>
									<td>${i.getSoLuongMua() * i.getSach().getGia() }</td>
									<td>${i.getSoLuongMua()}</td>
									<td>${i.getDaMua()}</td>
									<td>${i.getHoaDon().getNgayMua()}</td>
									<td>
										<a
											href="/admin/UpdateOrder?order_id=${i.getMaChiTietHD()}"
											class="btn btn-warning btn-sm"
										>Sửa</a>
										<a
											href="/admin/delete-user?delete-id=${i.getMaChiTietHD()}"
											class="btn btn-danger btn-sm"
										>Xoá</a>
										<a
											href="/admin/delete-user?delete-id=${i.getMaChiTietHD()}"
											class="btn btn-success btn-sm"
										>Chi tiết</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<%-- <!-- Phân trang -->
					<div class="d-flex justify-content-center align-items-center mt-4">
						<ul class="pagination">
							<li class="page-item ${curPage==1 ? 'disabled' : ''}">
								<a
									class="page-link"
									href="?page=${curPage-1}${ml}"
								>Trước</a>
							</li>
							<c:forEach
								var="i"
								begin="1"
								end="${totalPages}"
							>
								<li class="page-item ${i==curPage ? 'active':''}">
									<a
										class="page-link"
										href="?page=${i}${ml}"
									>${i}</a>
								</li>
							</c:forEach>
							<li class="page-item ${curPage==totalPages ? 'disabled' :''}">
								<a
									class="page-link"
									href="?page=${curPage + 1}${ml}"
								>Sau</a>
							</li>
						</ul>
					</div> --%>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2025</div>
						<div>
							<a href="#">Privacy Policy</a>
							&middot;
							<a href="#">Terms &amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"
	></script>
</body>
</html>
