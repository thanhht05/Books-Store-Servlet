<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="/assets/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <c:import url="/admin/layouts/navbar.jsp" />
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <c:import url="/admin/layouts/sidebar.jsp" />
                   
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
   						<div class="form-container col-md-6 p-4 mx-auto">
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
							<select name="role" class="form-select" aria-label="Default select example">
								  <option selected>Role</option>
								  <option value="2">ADMIN</option>
								  <option value="1">USER</option>
								  
							</select>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        
        
       
    </body>
</html>
