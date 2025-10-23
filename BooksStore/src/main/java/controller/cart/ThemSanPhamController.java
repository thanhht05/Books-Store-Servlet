package controller.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GioHangBO;
import modal.ChiTietGioHang;
import modal.GioHang;
import modal.User;

/**
 * Servlet implementation class ThemSanPhamController
 */
@WebServlet("/ThemSanPham")
public class ThemSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GioHangBO gioHangBO = new GioHangBO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemSanPhamController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long maSach = Long.parseLong(request.getParameter("ms"));
//		String tenSach = request.getParameter("ts");
//		String gia = request.getParameter("gia");
//		String anh = request.getParameter("img");

		
		if (maSach !=null) {
			gioHangBO.themSanPhamVaoGio(maSach, session);
		}
		
		response.sendRedirect("/GioHang");
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
