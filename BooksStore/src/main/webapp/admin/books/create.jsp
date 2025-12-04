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
        <title>Create Book</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="/assets/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
       
    </head>
    <body class="sb-nav-fixed">
        <c:import url="/admin/layouts/navbar.jsp" />
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenv-dark" id="sidenavAccordion">
                    <c:import url="/admin/layouts/sidebar.jsp" />
                   
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
   						<div class="form-container col-md-6 p-4 mx-auto">
				<h3 class="text-center mb-4">Tạo mới sách</h3>
				<form
					method="post"
					action="create-book"
					enctype="multipart/form-data"
				>
					<div class="mb-3">
						<label
							for="hoTen"
							class="form-label"
						>Tên sách</label>
						<input
							type="text"
							class="form-control"
							id="tenSach"
							name="tenSach"
							placeholder="Nhập tên sách"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="soLuong"
							class="form-label"
						>Số lượng</label>
						<input
							type="number"
							class="form-control"
							id="soLuong"
							name="soLuong"
							placeholder="Nhập số lượng"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="gia"
							class="form-label"
						>Giá</label>
						<input
							type="number"
							class="form-control"
							id="gia"
							name="gia"
							placeholder="Nhập giá sách"
							required
						>
					</div>
					<div class="mb-3">
						<label
							for="tacGia"
							class="form-label"
						>Tác giả</label>
						<input
							type="text"
							class="form-control"
							id="tacGia"
							name="tacGia"
							placeholder="Nhập tác giả"
							required
						>
					</div>
					
					<label class="form-label">Chọn mã loại sách </label>
					<select name="maLoai" class="form-select">
					    <option selected>Loại sách</option>
					    <c:forEach var="l" items="${ dsLoai}">
					         <option value="${l.maLoai}">${l.tenLoai}</option>
					    </c:forEach>
					</select>
					
					
					<div class="mb-3">
						<label class="form-label" for="customFile">Upload ảnh </label>
						<input name="anh"  type="file" accept="image/" class="form-control" id="customFile" onchange="loadImg()" />
						<br/>
						<img style="object-fit:cover;" id="frame" width="250px" height="200px" />
						
						
					</div>
					
					<div class="d-grid">
						<button
							type="submit"
							class="btn btn-primary"
						>Tạo sách</button>
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
        
        <script type="text/javascript">
	        function loadImg() {
	            const fileInput = document.getElementById("customFile");
	            const frame = document.getElementById("frame");
	
	            const file = fileInput.files[0];
	            if (file) {
	                frame.src = URL.createObjectURL(file); // tạo URL tạm cho file
	            }
	        }


        </script>
       
    </body>
</html>
