<%@page import="java.util.ArrayList"%>
<%@page import="BO.GioHangBO"%>
<%@page import="modal.GioHang"%>
<%@page import="modal.Sach"%>
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
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous"
>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
	integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
	crossorigin="anonymous"
></script>
<title>Giỏ hàng</title>
<style>
input:focus {
	outline: none;
}

body {
	overflow-x: hidden;
	f
}
</style>
</head>
<body>
	<!-- begin nav -->
	<%@ include file="/user/layouts/navbar.jsp"%>
	<div class="row g-5">
		<div class="col-sm-2">
			<!-- start sidebar -->
			<div
				class="flex-shrink-0 p-3 bg-white"
				style="width: 280px;"
			>
				<a
					href="/"
					class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom"
				>
					<svg
						class="bi me-2"
						width="30"
						height="24"
					>
						<use xlink:href="#bootstrap"></use></svg>
					<span class="fs-5 fw-semibold">
						<img
							style="width: 62%"
							src="img/logo.jpg"
						/>
					</span>
				</a>
				<div class="dropdown">
					<a
						class="btn btn-secondary dropdown-toggle"
						href="#"
						role="button"
						data-bs-toggle="dropdown"
						aria-expanded="true"
					> Loại Sách </a>
					<ul class="dropdown-menu">
						<li class="dropdown-item fs-5">
							<a
								class="nav-link link-dark"
								href="home.jsp"
							>Tất cả sách</a>
						</li>
						<%

						%>
						<c:forEach
							var="l"
							items="${dsl}"
						>
							<li class="dropdown-item fs-5">
								<a
									href="home?ml=${l.getMaLoai()}"
									class="nav-link link-dark"
								>
									<svg
										class="bi me-2"
										width="16"
										height="16"
									>
							                    <use xlink:href="#speedometer2"></use>
							                </svg>
									${l.getMaLoai()}
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!-- end sidebar -->
		</div>
		<div class="col-sm-10">
			<c:choose>
				<c:when test="${not empty ghnll}">
					<div style="color: red; margin-top: 50px; font-size: 30px; font-weight: bold; text-align: center;">${ghnll}</div>
				</c:when>
				<c:otherwise>
					<table class="table">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Sách</th>
								<th scope="col">Mã sách</th>
								<th scope="col">Tên sách</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Giá</th>
								<th scope="col">Thành tiền</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach
								var="item"
								items="${ds}"
							>
								<tr>
									<td>
										<input
											name="${item.getMaSach()}"
											type="checkbox"
										/>
									</td>
									<td>
										<img
											style="width: 72px"
											src="${item.getAnh()}"
										/>
									</td>
									<td>${item.getMaSach()}</td>
									<td>${ item.getTenSach() }</td>
									<td>
										<form
											action="giohang?action=capnhat"
											method="post"
										>
											<input
												type="hidden"
												name="id"
												value="${item.getMaSach()}"
											>
											<input
												name="quantity"
												style="border: 1px solid #ccc; width: 50px; text-align: center;"
												value=${ item.getSoLuong() }
											>
											<button class="btn btn-danger">Sửa</button>
										</form>
									</td>
									<td>${ item.getGia() }</td>
									<td>${ item.getThanhTien() }</td>
									<td>
										<a
											href="giohang?action=xoa&id=${item.getMaSach()}"
											class="btn btn-primary"
										> Xoá </a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="text-end me-4">
						<h4>
							Thành tiền: <b>${tongTien}đ</b>
						</h4>
					</div>
					<div class="text-end me-4">
						<a
							href="/buy"
							class="btn btn-success mt-2"
						>Xác nhận mua hàng</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"
	></script>
</body>
</html>