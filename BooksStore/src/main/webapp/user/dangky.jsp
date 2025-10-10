<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-5">
      <div class="card shadow p-4">
        <h3 class="text-center mb-3">Đăng ký</h3>

        <form method="post" action="auth?action=register">
        	<div class="mb-3">
            <label for="hoten" class="form-label">Họ Tên</label>
            <input type="text" name="hoten" id="hoten" class="form-control" required>
          </div>
        
          <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" name="email" id="email" class="form-control" required>
          </div>

          <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" name="password" id="password" class="form-control" required>
          </div>

          <div class="mb-3">
            <label for="confirm" class="form-label">Xác nhận mật khẩu</label>
            <input type="password" name="confirm" id="confirm" class="form-control" required>
          </div>

          <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
        </form>

       
		<% String err = (String) request.getAttribute("error");
  			 if (err != null) { %>
   				<div class="alert alert-danger mt-3"><%= err %></div>
		<% } %>
            
		
      </div>
    </div>
  </div>
</div>

</body>
</html>
