<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Tạo Người Dùng</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
>
<style>
body {
	background-color: #f8f9fa;
}

.form-container {
	max-width: 500px;
	margin: 50px auto;
	padding: 30px;
	background: #fff;
	border-radius: 12px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.sidebar {
	min-height: 100vh;
	background-color: #343a40;
	color: white;
}

.sidebar a {
	color: #ddd;
	text-decoration: none;
	display: block;
	padding: 10px 15px;
}

.sidebar a:hover {
	background-color: #495057;
	color: white;
}
</style>
</head>
<body>
	<div class="container-fluid">
		
		<div class="row">
			<!-- Sidebar -->
			<nav class="col-md-2 sidebar">
				<h4 class="p-3 text-center border-bottom">
					<a href="admin">ADMIN</a>
				</h4>
				<a
					href="#"
					onclick="showSection('books')"
				>📚 Quản lý Sách</a>
				<a
					href="#"
					onclick="showSection('users')"
				>👤 Quản lý User</a>
				<a
					href="#"
					onclick="showSection('orders')"
				>🧾 Quản lý Đơn hàng</a>
			</nav>
			<div class="form-container col-md-10 p-4">
				<h3 class="text-center mb-4">Tạo Người Dùng</h3>
				<form
					method="post"
					action="create-user"
				>
					<div class="mb-3">
						<label
							for="hoTen"
							class="form-label"
						>Họ và tên</label>
						<input
							type="text"
							class="form-control"
							id="hoTen"
							name="hoten"
							placeholder="Nhập họ tên"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="email"
							class="form-label"
						>Email</label>
						<input
							type="email"
							class="form-control"
							id="email"
							name="email"
							placeholder="Nhập email"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="pass"
							class="form-label"
						>Mật khẩu</label>
						<input
							type="password"
							class="form-control"
							id="pass"
							name="pass"
							placeholder="Nhập mật khẩu"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="phone"
							class="form-label"
						>Số điện thoại</label>
						<input
							type="tel"
							class="form-control"
							id="phone"
							name="phone"
							placeholder="Nhập số điện thoại"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="diaChi"
							class="form-label"
						>Địa chỉ</label>
						<textarea
							class="form-control"
							id="diaChi"
							name="diachi"
							rows="2"
							placeholder="Nhập địa chỉ"
							required
						></textarea>
					</div>
					<div class="mb-3">
						<label class="form-label">Giới tính</label>
						<div>
							<div class="form-check form-check-inline">
								<input
									class="form-check-input"
									type="radio"
									name="giotinh"
									id="nam"
									value="1"
									checked
								>
								<label
									class="form-check-label"
									for="nam"
								>Nam</label>
							</div>
							<div class="form-check form-check-inline">
								<input
									class="form-check-input"
									type="radio"
									name="giotinh"
									id="nu"
									value="0"
								>
								<label
									class="form-check-label"
									for="nu"
								>Nữ</label>
							</div>
						</div>
					</div>
					<div class="d-grid">
						<button
							type="submit"
							class="btn btn-primary"
						>Tạo người dùng</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
