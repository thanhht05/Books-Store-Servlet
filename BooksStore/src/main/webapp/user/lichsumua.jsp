<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modal.Sach" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Lịch sử mua hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
    
</head>
<body>

    <!-- Thanh điều hướng -->
     <%@ include file="/user/layouts/navbar.jsp" %>
     

    <!-- Nội dung -->
    <div class="container mt-3">
        

            <!-- Danh sách sách -->
            <div class="col-md-10 mx-auto">
                <div class="row g-4">
                    <c:if test="${empty dsls}">
        <div class="alert alert-info text-center">
            Bạn chưa có đơn hàng nào.
        </div>
    </c:if>

    <c:if test="${not empty dsls}">
        <div class="table-responsive shadow-sm rounded">
            <table class="table table-bordered table-striped align-middle">
                <thead class="table-success text-center">
                    <tr>
                        <th>#</th>
                        <th>Tên sách</th>
                        <th>Số lượng mua</th>
                        <th>Giá (VNĐ)</th>
                        <th>Thành tiền (VNĐ)</th>
                        <th>Trạng thái</th>
                        <th>Ngày mua</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ls" items="${dsls}" varStatus="st">
                        <tr>
                            <td class="text-center">${st.index + 1}</td>
                            <td>${ls.tenSach}</td>
                            <td class="text-center">${ls.soLuongMua}</td>
                            <td class="text-end">${ls.gia}</td>
                            <td class="text-end fw-bold text-danger">${ls.thanhTien}</td>
                            <td class="text-center">
                                <c:choose>
                                    <c:when test="${ls.trangThaiMua == 'DA_THANH_TOAN'}">
                                        <span class="badge bg-success">Đã mua</span>
                                    </c:when>
                                    
                                    <c:otherwise>
                                        <span class="badge bg-secondary">Chưa thanh toán</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="text-center">${ls.ngayMua}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
                </div>

              
            </div>
        </div>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
