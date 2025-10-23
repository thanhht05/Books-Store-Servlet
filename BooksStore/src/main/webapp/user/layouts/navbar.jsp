<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark px-3">
         <a class="navbar-brand d-flex align-items-center" href="home">
            <img src="img/logo.jpg" style="width:50px; height:50px;" class="rounded-circle me-2">
            <span class="fw-bold">BookStore</span>
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link active" href="home">Trang chủ</a></li>
                <li class="nav-item"><a class="nav-link" href="/GioHang">Giỏ hàng</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Thanh toán</a></li>
                <li class="nav-item"><a class="nav-link" href="/history">Lịch sử mua</a></li>
            </ul>

            <!-- Form tìm kiếm -->
            <form class="d-flex" action="home" method="get">
                <input name="tenSach" class="form-control me-2" type="search" placeholder="Tìm sách...">
                <button class="btn btn-outline-success">Tìm</button>
            </form>

            <!-- Đăng nhập / chào người dùng -->
            <ul class="navbar-nav ms-3">
                <c:choose>
                    <c:when test="${empty sessionScope.userLogin}">
                        <li class="nav-item"><a class="nav-link" href="auth?action=login">Đăng nhập</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="auth?action=logout">Đăng xuất</a></li>
                        <li class="nav-item"><span class="nav-link text-info">Xin chào: ${sessionScope.userLogin.getHoTen()}</span></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>