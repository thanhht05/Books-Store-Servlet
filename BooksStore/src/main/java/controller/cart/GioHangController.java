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

import BO.ChiTietGioHangBO;
import BO.GioHangBO;
import BO.LoaiBO;
import modal.ChiTietGioHang;
import modal.GioHang;
import modal.User;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/GioHang")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GioHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	GioHangBO gioHangBO = new GioHangBO();
	LoaiBO loaiBO = new LoaiBO();
	ChiTietGioHangBO chiTietGioHangBO = new ChiTietGioHangBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("dsl", loaiBO.getAllLoai());

		HttpSession session = request.getSession();
		User un = (User) session.getAttribute("userLogin");
		if (un == null) {
			response.sendRedirect("auth?action=login");
			return;
		}
		
		User user = (User) session.getAttribute("userLogin");
		if(user!=null) {
			ArrayList<ChiTietGioHang> dsctgh= chiTietGioHangBO.getAllByUser(user.getId());
			long tongTien = 0;
			for(ChiTietGioHang ctgh:dsctgh) {
				tongTien+= ctgh.getGia() * ctgh.getSoLuong();
			}
			request.setAttribute("tongTien", tongTien);
			request.setAttribute("ghnll",dsctgh );
			
			RequestDispatcher rd = request.getRequestDispatcher("user/giohang.jsp");
			rd.forward(request, response);
		}
		
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
