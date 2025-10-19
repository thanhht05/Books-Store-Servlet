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
   						<a style="float: right;" class="btn btn-danger my-2 " href="/admin/create-user"> Create user</a>
                       <table class="table table-bordered table-hover mt-3">
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
							<c:forEach var="i" items="${ds}">
								<tr>
									<td>${i.getId()}</td>
									<td>${i.getHoTen()}</td>
									<td> ${i.getEmail()} </td>
									<td>Admin</td>
									<td>
										<a href="admin/update-user" class="btn btn-warning btn-sm">Sửa</a>
										<button class="btn btn-danger btn-sm">Xóa</button>
									</td>
								</tr>
							
							</c:forEach>
						</tbody>
					</table>
           
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
