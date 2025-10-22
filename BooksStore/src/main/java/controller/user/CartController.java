package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GioHangBO;
import BO.LoaiBO;
import modal.GioHang;
import modal.User;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/giohang")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoaiBO loaiBO = new LoaiBO();
		request.setAttribute("dsl", loaiBO.getAllLoai());

		HttpSession session = request.getSession();
		User un = (User) session.getAttribute("userLogin");
		if (un == null) {
			response.sendRedirect("auth?action=login");
			return;
		}

		String action = request.getParameter("action");
		if (action == null) {
			GioHangBO gioHangBO = (GioHangBO) session.getAttribute("gh");
			if (gioHangBO == null) {
				request.setAttribute("ghnll", "Bạn chưa chọn sản phẩm nào để mua!");
				RequestDispatcher rd = request.getRequestDispatcher("user/giohang.jsp");
				rd.forward(request, response);
				return;
			}
			request.setAttribute("listGioHang", gioHangBO.ds);

			if (gioHangBO != null) {
				long tongTien = gioHangBO.tongTien();
				request.setAttribute("tongTien", tongTien);
			}
			RequestDispatcher rd = request.getRequestDispatcher("user/giohang.jsp");
			rd.forward(request, response);
			return;
		}

		if (action.equals("them")) {

			Long maSach = Long.parseLong(request.getParameter("ms"));
			String tenSach = request.getParameter("ts");
			String gia = request.getParameter("gia");
			String anh = request.getParameter("img");

			if (maSach != null && tenSach != null && gia != null) {

				GioHangBO gioHangBO;
				// neu mua hang lan dau
				if (session.getAttribute("gh") == null) {
					gioHangBO = new GioHangBO();
					session.setAttribute("gh", gioHangBO);
				}
				gioHangBO = (GioHangBO) session.getAttribute("gh");
				GioHang gh = new GioHang();
				gh.setAnh(anh);
				gh.setGia(Integer.parseInt(gia));
				gh.setMaSach(maSach);
				gh.setTenSach(tenSach);
				gh.setSoLuong(1);

				// them gio hang
				gioHangBO.them(gh);

				session.setAttribute("gh", gioHangBO);
				session.setAttribute("ds", gioHangBO.ds);

				response.sendRedirect("giohang");

			}
		} else if (action.equals("capnhat")) {
			String quantityStr = request.getParameter("quantity");
			Long id = Long.parseLong(request.getParameter("id"));
			GioHangBO ghb = (GioHangBO) session.getAttribute("gh");
			if (ghb != null) {

				if (id != null && quantityStr != null) {
					ghb.update(id, Integer.parseInt(quantityStr));
				}
				response.sendRedirect("giohang");
			}

		} else if (action.equals("xoa")) {
			GioHangBO ghb = (GioHangBO) session.getAttribute("gh");
			Long id = Long.parseLong(request.getParameter("id"));
			if (ghb != null) {

				if (id != null) {
					ghb.xoa(id);
				}
				response.sendRedirect("giohang");
			}
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
