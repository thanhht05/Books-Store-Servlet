<%@page import="BO.GioHangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật</title>
</head>
<body>
	<%
   		String quantityStr=request.getParameter("quantity");
		Long id=Long.parseLong( request.getParameter("id"));
		GioHangBO ghb=  (GioHangBO) session.getAttribute("gh");
		if(ghb!=null){
			
			if(id!=null && quantityStr!=null){
				ghb.update(id, Integer.parseInt(quantityStr));
			}
			response.sendRedirect("giohang.jsp");
		}
	%>
</body>
</html>