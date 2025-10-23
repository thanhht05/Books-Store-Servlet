//package controller.user;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import BO.GioHangBO;
//import BO.HoaDonBO;
//import BO.LichSuMuaBO;
//import DAO.ChiTietHoaDonDAO;
//import modal.GioHang;
//import modal.HoaDon;
//import modal.LichSuMua;
//import modal.User;
//
///**
// * Servlet implementation class BuyController
// */
//@WebServlet("/buy")
//public class BuyController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	HoaDonBO hoaDonBO = new HoaDonBO();
//	ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
//	LichSuMuaBO lichSuMuaBO = new LichSuMuaBO();
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public BuyController() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		HttpSession session = request.getSession();
//		HoaDonBO hoaDonBO = new HoaDonBO();
//
////		request.setAttribute("ds", ds.get(0).getTenSach());
//
//		User user = (User) session.getAttribute("userLogin");
//		if (user != null) {
//			HoaDon hoaDon = new HoaDon();
//			hoaDon.setMaKH(user.getId());
//			hoaDon.setNgayMua(Date.valueOf(LocalDate.now()));
//			// luu hoa don
//			long hd = hoaDonBO.luuHoaDon(hoaDon);
//
//			// luu chi tiet hoa don
//			GioHangBO ghb = (GioHangBO) session.getAttribute("gh");
//			if (ghb != null) {
//				ArrayList<GioHang> ds = ghb.ds;
//				chiTietHoaDonDAO.luuChiTietHoaDon(ds, hd);
//			}
//
//			response.sendRedirect("/history");
//			session.removeAttribute("gh");
//			return;
//
//		}
//
//		response.sendRedirect("auth?action=login");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
