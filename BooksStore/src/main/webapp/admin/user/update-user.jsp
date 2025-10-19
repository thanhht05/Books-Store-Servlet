<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update user</title>
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
				>Update user</h2>
				
				
			</main>
		</div>
	</div>
	
	
</body>

</html>