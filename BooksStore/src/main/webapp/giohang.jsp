<%@page import="BO.GioHangBO"%>
<%@page import="modal.GioHang"%>
<%@page import="modal.Sach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous"
>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
	integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
	crossorigin="anonymous"
></script>
<title>Giỏ hàng</title>
<style>
	input:focus {
		outline:none;
	}
</style>
</head>
<body>
	<!-- begin nav -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a
				class="navbar-brand"
				href="#">
				<img src="logo.jpg" style="width:60px; height:60px;" />
			</a>
			<button
				class="navbar-toggler"
				type="button"
				data-bs-toggle="collapse"
				data-bs-target="#collapsibleNavbar"
			>
				<span class="navbar-toggler-icon"></span>
			</button>
			<div
				class="collapse navbar-collapse"
				id="collapsibleNavbar"
			>
				<ul class="navbar-nav">
					<li class="nav-item">
						<a
							class="nav-link"
							href="home.jsp">
							Trang chủ
						</a>
					</li>
					<li class="nav-item">
						<a
							class="nav-link"
							href="giohang.jsp">
							Giỏ hàng
						</a>
					</li>
					
					<li class="nav-item"><a
						class="nav-link"
						href="#"
					>Thanh toán</a></li>
					<li class="nav-item"><a
						class="nav-link"
						href="#"
					>Lịch sử khách hàng</a></li>

					<%
					if (session.getAttribute("un") == null) {
					%>
					<li class="nav-item"><a
						class="nav-link"
						href="dangnhap.jsp"
					> Đăng nhập </a></li>
					<%
					}
					%>

					<%
					if (session.getAttribute("un") != null) {
					%>

					<li class="nav-item"><a
						class="nav-link"
						href="dangxuat.jsp"
					>Đăng xuất</a></li>  
					<%
					}
					%>

					<% if(session.getAttribute("un")!=null){ %>
						<li class="nav-item"><a
						class="nav-link"
						href="#"
					> Xin chào: <%=session.getAttribute("un")%>
					</a></li>
					<%} %>
					

				</ul>
			
				<div class="col-sm-3 ms-auto">
				<form action="tc.jsp" method="post" class="d-flex" role="search">
   				   <input name="tenSach" class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
      				<button class="btn btn-outline-success" type="submit">Search</button>
    			</form>
			</div>
			</div>
		</div>
	</nav>

	<div class="container mt-4">
			<% 
			HttpSession ss=request.getSession();
			ss.setMaxInactiveInterval(6000); /* 100m */
		
		String maSach=request.getParameter("ms");
		String tenSach=request.getParameter("ts");
		String gia=request.getParameter("gia");
		
		String anh=request.getParameter("img");
		
		if(maSach!=null && tenSach!=null && gia!=null){
			
			GioHangBO gioHangBO ;
				// neu mua hang lan dau
				if(session.getAttribute("gh")==null){
					gioHangBO = new GioHangBO();
					session.setAttribute("gh", gioHangBO);
				}
				gioHangBO = (GioHangBO)session.getAttribute("gh");
				GioHang gh = new GioHang();
				gh.setAnh(anh);
				gh.setGia(Integer.parseInt(gia));
				gh.setMaSach(maSach);
				gh.setTenSach(tenSach);
				gh.setSoLuong(1);
	
				// them gio hang
				gioHangBO.them(gh);
				
				session.setAttribute("gh", gioHangBO);
				response.sendRedirect("giohang.jsp");
				return;
		}
		%>
		<%GioHangBO ghb = (GioHangBO)session.getAttribute("gh");%>
		<%if(ghb==null|| ghb.ds.isEmpty()){ %>
			   <h2>Giỏ hàng của bạn đang trống</h2>
		<%} %><%else{ %>
			<table class="table">
				<thead>
	    			<tr>
				      <th scope="col">Mã sách</th>
				      <th scope="col">Tên sách</th>
				      <th scope="col">Số lượng</th>
				      <th scope="col">Giá</th>
				      <th scope="col">Thành tiền</th>
				      <th scope="col">Action</th>
				       
				    </tr>
			  </thead>
				<tbody>
						<%for(int i=0; i<ghb.ds.size();i++){ %>
					<tr>
							<td><%=ghb.ds.get(i).getMaSach() %></td>
					    	<td><%=ghb.ds.get(i).getTenSach() %></td>
					     	<td>
					     		<form action="capnhat.jsp" method="post">
					     			<input type="hidden" name="id"  value="<%= ghb.ds.get(i).getMaSach() %>">
						     		<input name="quantity" style="border: 1px solid #ccc;width:50px; text-align: center;" value=<%=ghb.ds.get(i).getSoLuong() %>>
						     		<button  class="btn btn-danger">
					    				Sửa
					    			</button>
					     		</form>
					     	</td>
					     	<td><%=ghb.ds.get(i).getGia() %></td>
					    	<td><%=ghb.ds.get(i).getThanhTien() %></td>
					    	<td> 
					    		
					    		<a href="xoa.jsp?delete-id=<%=ghb.ds.get(i).getMaSach() %>" class="btn btn-primary">
					    			Xoá
					    		</a>
					    		
					    	</td>
					</tr>
						<%} %>
					
				</tbody>
				
				
			</table>
		<%} %>
	</div>
	
		
		
	
</body>
</html>