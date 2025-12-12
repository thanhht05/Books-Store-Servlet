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
<title>Update order</title>
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
					<div class="form-container col-md-6 p-4 mx-auto">
						<h3 class="text-center mb-4">Cập Nhật Order</h3>
						<form
							method="post"
							action="/admin/UpdateOrder"
						>
							<input
								name="id"
								type="hidden"
								value="${order.getMaChiTietHD() }"
							>
							<div class="mb-3">
								<label
									for="tensach"
									class="form-label"
								>Tên sách</label>
								<input
									type="text"
									class="form-control"
									id="tensach"
									name="tensach"
									disabled="disabled"
									value="${order.getSach().getTenSach()}"
								>
							</div>
							<div class="mb-3">
								<input
									type="hidden"
									name="maSach"
									value="${order.getSach().getMaSach()}"
								>
							</div>
							<div class="mb-3">
								<label
									for="soluong"
									class="form-label"
								>Số lượng</label>
								<input
									type="text"
									class="form-control"
									id="soluong"
									name="soLuongMua"
									required
									value="${order.getSoLuongMua()}"
								>
							</div>
							<div class="mb-3">
								<label
									for="soluong"
									class="form-label"
								>Ngày mua</label>
								<input
									type="text"
									class="form-control"
									id="soluong"
									name="soLuongMua"
									disabled="disabled"
									required
									value="${order.getHoaDon().getNgayMua()}"
								>
							</div>
							<div class="mb-3">
								<label class="form-label">Xác nhận</label>
								<div>
									<div class="form-check form-check-inline">
										<input
											class="form-check-input"
											type="radio"
											name="daMua"
											id="thanhCong"
											value="1"
											checked
										>
										<label
											class="form-check-label"
											for="thanhCong"
										> Chấp nhận </label>
									</div>
									<div class="form-check form-check-inline">
										<input
											class="form-check-input"
											type="radio"
											name="daMua"
											id="thatBai"
											value="0"
										>
										<label
											class="form-check-label"
											for="thatBai"
										> Không chấp nhận </label>
									</div>
								</div>
							</div>
							<div class="d-grid">
								<button
									type="submit"
									class="btn btn-primary"
								>Update order</button>
							</div>
						</form>
					</div>
					<%
					String err = (String) request.getAttribute("error");
					if (err != null) {
					%>
					<div class="alert alert-danger mt-3"><%=err%></div>
					<%
					}
					%>
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
