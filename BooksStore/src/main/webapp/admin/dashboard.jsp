<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/fmt"
	prefix="fmt"
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
<title>Dashboard - SB Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet"
/>
<link
	href="assets/css/styles.css"
	rel="stylesheet"
/>
<script
	src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"
></script>
<style type="text/css">
	.h-100{
		height: 100%;
		margin-bottom: 10px;
	}
</style>
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
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Dashboard</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Dashboard</li>
					</ol>
					<div class="row">
						<div class="col-xl-3 col-md-6">
							<div class="card bg-primary text-white mb-4 h-100">
								<div style="display: flex; align-items: center; padding: 12px; gap: 10px">
									<div class="">Doanh thu hôm nay:</div>
									<div style="font-size: 16px; font-weight: bold;">
										<fmt:formatDate
											value="${tkd.ngay}"
											pattern="dd/MM/yyyy"
										/>
									</div>
								</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									<p>${tkd.doanhThu }đ</p>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-warning text-white mb-4 h-100">
								<div style="display: flex; align-items: center; padding: 12px; gap: 8px">
									<div class="card-body">Đơn hàng chưa xử lý:</div>
									<div style="font-size: 16px; font-weight: bold;">
										<p style="margin: 0; padding: 0">${slOrder } đơn</p>
									</div>
								</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									<a
										class="small text-white stretched-link"
										href="/admin/orders"
									>View Details</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-success text-white mb-4 h-100">
								<div class="card-body">Sách bán chạy</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									<a
										class="small text-white stretched-link"
										href="/admin/SachBanChay"
									>View Details</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-danger text-white mb-4 h-100">
								<div class="card-body">Tổng số sách:  <strong> ${sum}</strong></div>
								<div class="card-body">Sách sắp hết hàng: <strong>${ssh }</strong></div>
								<div class="card-body">Sách đã hết hàng: <strong>${slhs }</strong></div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									<a
										class="small text-white stretched-link"
										href="/admin/book?SachSapHet"
									>View Details</a>
									<div class="small text-white">
										<i class="fas fa-angle-right"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row mt-5">
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-area me-1"></i> Area Chart Example
								</div>
								<div class="card-body">
									<canvas
										id="myAreaChart"
										width="100%"
										height="40"
									></canvas>
								</div>
							</div>
						</div>
						<div class="col-xl-6">
							<div class="card mb-4">
								<div class="card-header">
									<i class="fas fa-chart-bar me-1"></i> Bar Chart Example
								</div>
								<div class="card-body">
									<canvas
										id="myBarChart"
										width="100%"
										height="40"
									></canvas>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2023</div>
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
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"
	></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"
	></script>
</body>
</html>
