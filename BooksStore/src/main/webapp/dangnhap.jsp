<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
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
<title>Trang đăng nhập</title>
</head>
<body>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a
				class="navbar-brand"
				href="#"
			>Cong ty sach ABC</a>
			<button
				class="navbar-toggler"
				type="button"
				data-bs-toggle="collapse"
				data-bs-target="#collapsibleNavbar"
			>
				<span class="navbar-toggler-icon"></span>
			</button>
			<div
				class="collapse navbar-collapse"
				id="collapsibleNavbar"
			>
				<ul class="navbar-nav">
					<li class="nav-item"><a
						class="nav-link"
						href="tc.jsp"
					>Trang chủ</a></li>
					<li class="nav-item"><a
						class="nav-link"
						href="#"
					>Giỏ hàng</a></li>
					<li class="nav-item"><a
						class="nav-link"
						href="#"
					>Thanh toán</a></li>
					<li class="nav-item"><a
						class="nav-link"
						href="#"
					>Lịch sử khách hàng</a></li>
					
					<%if(session.getAttribute("un")==null) {%>
						<li class="nav-item"><a
						class="nav-link"
						href="dangnhap.jsp"
					>Đăng nhập</a></li>
					<%} %>
					
					<%if (session.getAttribute("un")!=null){ %>
							<li class="nav-item"><a
						class="nav-link"
						href="#"
					>Đăng xuất</a></li>
					<%} %>
				
					
					<%if (session.getAttribute("un")!=null){ %>
						<li class="nav-item"><a
						class="nav-link"
						href="#"
					> Xin chào: <%=session.getAttribute("un")%>
					</a></li>
					<%} %>
					

				</ul>
			</div>
		</div>
	</nav>

	<form
		action="ktdangnhap.jsp"
		method="post"
	>
		<label for="username">Tên đăng nhập:</label><br /> <input
			type="text"
			name="txtun"
			required
		/><br /> <br /> <label for="password">Mật khẩu:</label><br /> <input
			type="password"
			id="password"
			name="txtpass"
			required
		/><br /> <br />
		<button type="submit">Đăng nhập</button>
	</form>
	<%=request.getParameter("tb")%>
</body>
</html>