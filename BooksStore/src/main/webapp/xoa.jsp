<%@page import="BO.GioHangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xoá sách</title>
</head>
<body>
	<%
   		GioHangBO ghb = (GioHangBO) session.getAttribute("gh");
		String id=request.getParameter("delete-id");
		if(ghb!=null){
			
			if(id!=null){
				ghb.xoa(id);
				response.sendRedirect("giohang.jsp");
			}
		}
	%>
</body>
</html>