<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sách sắp hết</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <a style="font-size:20px " href="/admin/book?SachSapHet" class="mb-4 text-danger"> Danh sách sách sắp hết hàng</a> <br>
     <a style="font-size:20px " href="" class="mb-4 text-warning"> Danh sách sách  hết hàng</a>

    <table class="table table-bordered table-hover align-middle text-center mt-2">
        <thead class="table-dark">
        <tr>
            <th>Ảnh</th>
            <th>Mã sách</th>
            <th>Tên sách</th>
            <th>Tác giả</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Mã loại</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="s" items="${sachSHet}">
            <tr class="table-danger">
                <td>
                    <img src="/${s.anh}" width="60" height="80">
                </td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.tacGia}</td>
                <td>
                    <p>${s.gia } đ</p>
                </td>
                <td>
                    <span class="badge bg-danger">${s.soLuong}</span>
                </td>
                <td>${s.maLoai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty sachSHet}">
        <div class="alert alert-success">
            ✅ Không có sách nào sắp hết hàng
        </div>
    </c:if>
    <div class="d-flex justify-content-center align-items-center mt-4">
                    <ul class="pagination">
                        <li class="page-item ${curPage==1 ? 'disabled' : ''}">
                            <a class="page-link" href="book?SachSapHet&page=${curPage-1}${ml}">Trước</a>
                        </li>
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <li class="page-item ${i==curPage ? 'active':''}">
                                <a class="page-link" href="book?SachSapHet&page=${i}${ml}">${i}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item ${curPage==totalPages ? 'disabled' :''}">
                           <a class="page-link" href="book?SachSapHet&page=${curPage + 1}${ml}">Sau</a>
                           
                        </li>
                    </ul>
                </div>
</div>

</body>
</html>
