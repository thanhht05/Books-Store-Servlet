<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous"
>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<style>
	 body {
      background-color: #f8f9fa;
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
				<h4 class="p-3 text-center border-bottom">ADMIN</h4>
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
			<!-- Main content -->
			<main class="col-md-10 p-4">
				<h2
					class="mb-4"
					id="section-title"
				>📚 Quản lý Sách</h2>
				<!-- Quản lý Sách -->
				<section
					id="books"
					class="content-section"
				>
					<button class="btn btn-success mb-3">+ Thêm Sách</button>
					<table class="table table-bordered table-hover">
						<thead class="table-dark">
							<tr>
								<th>Mã Sách</th>
								<th>Tên Sách</th>
								<th>Giá</th>
								<th>Thể loại</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>S001</td>
								<td>Bí quyết sống lâu</td>
								<td>120.000₫</td>
								<td>Sức khỏe</td>
								<td>
									<button class="btn btn-warning btn-sm">Sửa</button>
									<button class="btn btn-danger btn-sm">Xóa</button>
								</td>
							</tr>
						</tbody>
					</table>
				</section>
				<!-- Quản lý User -->
				<section
					id="users"
					class="content-section d-none"
				>
					<a href="create-user" class="btn btn-success mb-3">+ Thêm User</a>
					<table class="table table-bordered table-hover">
						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th>Tên User</th>
								<th>Email</th>
								<th>Vai trò</th>
								<th>Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>U001</td>
								<td>Nguyễn Văn A</td>
								<td>vana@gmail.com</td>
								<td>Admin</td>
								<td>
									<button class="btn btn-warning btn-sm">Sửa</button>
									<button class="btn btn-danger btn-sm">Xóa</button>
								</td>
							</tr>
						</tbody>
					</table>
				</section>
				<!-- Quản lý Đơn hàng -->
				<section
					id="orders"
					class="content-section d-none"
				>
					<button class="btn btn-success mb-3">+ Tạo đơn hàng</button>
					<table class="table table-bordered table-hover">
						<thead class="table-dark">
							<tr>
								<th>Mã ĐH</th>
								<th>Khách hàng</th>
								<th>Ngày đặt</th>
								<th>Tổng tiền</th>
								<th>Trạng thái</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>DH001</td>
								<td>Trần Thị B</td>
								<td>10/10/2025</td>
								<td>320.000₫</td>
								<td>Đã giao</td>
							</tr>
						</tbody>
					</table>
				</section>
			</main>
		</div>
	</div>
	<script>
  function showSection(id) {
    document.querySelectorAll('.content-section').forEach(sec => sec.classList.add('d-none'));
    document.getElementById(id).classList.remove('d-none');

    // Cập nhật tiêu đề
    const titles = {
      books: '📚 Quản lý Sách',
      users: '👤 Quản lý User',
      orders: '🧾 Quản lý Đơn hàng'
    };
    document.getElementById('section-title').innerText = titles[id];
  }
</script>
</body>
</html>