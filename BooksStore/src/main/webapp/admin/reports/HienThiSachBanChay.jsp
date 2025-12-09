<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sách bán chạy</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="container mt-4">

    <h2 class="mb-4 text-center text-primary">
        📚 Top sách bán chạy
    </h2>

    <!-- Nếu KHÔNG có dữ liệu -->
    <c:if test="${empty ds}">
        <h1 class="text-center text-danger">
            Không có dữ liệu
        </h1>
    </c:if>

    <!-- Nếu CÓ dữ liệu -->
    <c:if test="${not empty ds}">
        <table class="table table-bordered table-hover text-center">
            <thead class="table-dark">
                <tr>
                    <th>TOP</th>
                    <th>Mã sách</th>
                    <th>Tên sách</th>
                    <th>Tổng số lượng bán</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="s" items="${ds}" varStatus="i">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>${s.maSach}</td>
                        <td class="text-start">${s.tenSach}</td>
                        <td>
                            <span class="badge bg-success fs-6">
                                ${s.tongSoLuongMua}
                            </span>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </c:if>

</div>

</body>
</html>
