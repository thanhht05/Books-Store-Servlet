package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.ChiTietHDBO;
import modal.ChiTietHoaDon;

@WebServlet("/admin/orders")
public class OrderController extends HttpServlet {
	ChiTietHDBO chiTietHDBO = new ChiTietHDBO();
	public OrderController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ChiTietHoaDon> ds = chiTietHDBO.getAllChiTietHoaDon();
		
		request.setAttribute("ds",ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/order/show.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
