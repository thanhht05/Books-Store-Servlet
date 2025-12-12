package controller.user;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.ChiTietGioHangBO;
import BO.ChiTietHDBO;
import BO.GioHangBO;
import BO.HoaDonBO;
import BO.LichSuMuaBO;
import BO.SachBO;
import DAO.ChiTietHoaDonDAO;
import modal.ChiTietGioHang;
import modal.GioHang;
import modal.HoaDon;
import modal.LichSuMua;
import modal.User;

/**
 * Servlet implementation class BuyController
 */
@WebServlet("/buy")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HoaDonBO hoaDonBO = new HoaDonBO();
	ChiTietHDBO chiTietHDBO = new ChiTietHDBO();
	LichSuMuaBO lichSuMuaBO = new LichSuMuaBO();
	ChiTietGioHangBO ctghbo= new ChiTietGioHangBO();
	GioHangBO gioHangBO = new GioHangBO();
	SachBO sachBO = new SachBO(); 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyController() {
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
		HoaDonBO hoaDonBO = new HoaDonBO();

//		request.setAttribute("ds", ds.get(0).getTenSach());

		User user = (User) session.getAttribute("userLogin");
		if (user != null) {
			HoaDon hoaDon = new HoaDon();
			hoaDon.setUser(user);
			hoaDon.setNgayMua(Date.valueOf(LocalDate.now()));
			// luu hoa don
			long maHoaDon = hoaDonBO.luuHoaDon(hoaDon); // trả về mã hoá đơn vừa lưu

			ArrayList<ChiTietGioHang> ctgh = ctghbo.getAllByUser(user.getId());
			if (ctgh != null) {
				
				chiTietHDBO.luuChiTietHoaDon(ctgh, maHoaDon);
			}
			
			
			
			// sau khi mua thì xoá sản phẩm đã mua ( chưa xử lý trường hợp user tích vào sản phẩm muốn mua)
			GioHang gh = gioHangBO.timGioHangByUserId(user.getId());
			if(gh!=null) {
				
				ctghbo.deleteAll(ctgh, gh.getId());
			}
			
			
			response.sendRedirect("/history");
			return;

		}

		response.sendRedirect("auth?action=login");
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
