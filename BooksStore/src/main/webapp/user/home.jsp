<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modal.Sach" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            font-family: "Roboto", sans-serif;
            background-color: #f9f9f9;
            overflow-x: hidden;
        }
        .book-item {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            background: white;
            border-radius: 10px;
        }
        .book-item:hover {
            transform: scale(1.04);
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .book-item-img {
            width: 100%;
            height: 230px;
            object-fit: contain;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        .sidebar {
            min-height: 100vh;
            background-color: white;
            box-shadow: rgba(0,0,0,0.05) 0px 4px 10px;
        }
        .sidebar a {
            color: #333;
            text-decoration: none;
        }
        .sidebar a:hover {
            color: #0d6efd;
        }
        .nav-link.active {
            font-weight: bold;
        }
    </style>
</head>
<body>

    <!-- Thanh điều hướng -->
     <%@ include file="/user/layouts/navbar.jsp" %>
     

    <!-- Nội dung -->
    <div class="container-fluid mt-3">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-2 sidebar p-3">
                <h5 class="border-bottom pb-2">Loại Sách</h5>
                <ul class="nav flex-column mt-2">
                    <li class="nav-item"><a href="home" class="nav-link">Tất cả sách</a></li>
                    <c:forEach var="l" items="${dsl}">
                        <li class="nav-item">
                            <a href="home?ml=${l.getMaLoai()}" class="nav-link">${l.getTenLoai()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <!-- Danh sách sách -->
            <div class="col-md-10">
                <div class="row g-4">
                    <c:forEach var="s" items="${dss}">
                        <div class="col-sm-6 col-lg-3">
                            <div class="book-item p-2 text-center">
                                <img src="${s.getAnh()}" class="book-item-img" alt="${s.getTenSach()}">
                                <h6 class="mt-2">${s.getTenSach()}</h6>
                                <p class="text-danger fw-bold">${s.getGia()}đ</p>
                                <a href="/ThemSanPham?ms=${s.getMaSach()}"
                                   class="btn btn-outline-primary btn-sm">
                                   <i class="bi bi-cart-plus"></i> Mua ngay
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <!-- Phân trang -->
                <div class="d-flex justify-content-center align-items-center mt-4">
                    <ul class="pagination">
                        <li class="page-item ${curPage==1 ? 'disabled' : ''}">
                            <a class="page-link" href="?page=${curPage-1}${ml}">Trước</a>
                        </li>
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <li class="page-item ${i==curPage ? 'active':''}">
                                <a class="page-link" href="?page=${i}${ml}">${i}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item ${curPage==totalPages ? 'disabled' :''}">
                           <a class="page-link" href="?page=${curPage + 1}${ml}">Sau</a>
                           
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
