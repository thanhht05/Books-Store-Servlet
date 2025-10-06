<%@page import="java.util.ArrayList"%>
<%@page import="modal.Sach"%>
<%@page import="BO.SachBO"%>
<%@page import="modal.Loai"%>
<%@page import="BO.LoaiBO"%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
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

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Manrope:wght@200..800&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<title>Trang tinh chi</title>
<style>
	body{
		overflow-x:hidden;
		font-family: "Roboto", sans-serif;
	  	font-optical-sizing: auto;
	  	font-weight: <weight>;
	  	font-style: normal;
	 	 font-variation-settings:
	    "wdth" 100;
	}
	*{
		margin:0;
		padding:0;
		
	}
	p{
		margin: 0
	}
	a{
		display:block;
	}
	
	h1{
		color:green;
		font-size:20px
	}
	ul, li{
		list-style:none;
	}
	li{
		padding:10px 0;
	}
	.book-item-img{
		width:220px;height:230px;
		object-fit:contain;
		transition: transform 0.5s ease; /* hiệu ứng mượt trong 0.5 giây */
		
	}
	.book-item-img:hover{
		cursor:pointer;
		transform: scale(1.1);
		
		
	}
</style>
</head>
<body>
<%
LoaiBO loaiBO = new LoaiBO(); 
SachBO sachBO = new SachBO();
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
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
	
	<!-- end nav -->
	
	<div  class="row">
		<div class="col-sm-3" style="box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px;">
			<!-- start sidebar -->
			<div class="flex-shrink-0 p-3 bg-white" style="width: 280px; ">
			    <a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
			      <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
			      <span class="fs-5 fw-semibold">
			      	<img style="width:100%" src="logo.jpg"/>
			      </span>
			    </a>
			   <div class="dropdown">
				  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="true">
				   	Loại Sách
				  </a>
				
				  <ul class="dropdown-menu">
				  	<li class="dropdown-item fs-5">
				  		<a class="nav-link link-dark" href="tc.jsp">Tất cả sách</a>
				  	</li>
				   		 <%for(Loai l: loaiBO.getAllLoai()){ %>
				     	 <li class="dropdown-item fs-5">
					        <a  href="home.jsp?ml=<%=l.getMaLoai()%>" class="nav-link link-dark">
					          <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
					         	<%=l.getMaLoai() %>
					        </a>
					     </li>
					    <%} %>
				  </ul>
				</div>
			 </div>
			
			<!-- end sidebar -->
			
		
		</div>
		<!-- start list book -->
		<div class="col-sm-9 mt-3">
			<div class="row g-4">
				<% 
					ArrayList<Sach> ds=null;
					String mlPrg=request.getParameter("ml");
					String tenSachPrg=request.getParameter("tenSach");
					
					if(mlPrg!=null){
						
						ds=sachBO.getSachByLoai(mlPrg);
					}else if(tenSachPrg!=null){
						ds=sachBO.findByTenSach(tenSachPrg);
					}else{
						ds=sachBO.getAllSach();
					}
					
					
				%>
				<%for(Sach s:ds){ %>
					<div  style="box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;" class="col-sm-3 p-3 text-center ">
						<img class="book-item-img" src="<%=s.getAnh() %>"/>
						<div class="mt-2 text-center fs-5">
							<a href="giohang.jsp?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>&img=<%=s.getAnh()%>">
								<img  style="width: 95px; height: 24px" src="<%="buynow.jpg" %>"/>
								<img  style="width: 35px; height: 35px" src="<%="discount.png" %>"/>
								
							</a>
							<h1 class="my-2"><%=s.getTenSach() %></h1>
							<p> 
								Giá bán:
								<span style="color:orange; font-weight: bold"><%=s.getGia() %>đ</span>
							</p>
							
						</div>
						
					
					</div>
					
				<%} %>
			</div>
		</div>
		<!-- end list book -->
		
	</div>
	
	
	
			
				
		
			
	
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"
></script>
</body>
</html>