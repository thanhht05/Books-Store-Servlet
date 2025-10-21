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

import BO.GioHangBO;
import BO.HoaDonBO;
import modal.GioHang;
import modal.User;

/**
 * Servlet implementation class BuyController
 */
@WebServlet("/buy")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      HoaDonBO hoaDonBO = new  HoaDonBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		HoaDonBO hoaDonBO = new HoaDonBO();
//		GioHangBO ghb = (GioHangBO) session.getAttribute("gh");
//		ArrayList<GioHang> ds = ghb.ds;
//		
//		request.setAttribute("ds", ds.get(0).getTenSach());
		
		User user = (User) session.getAttribute("userLogin");
		if(user!=null) {
			
			hoaDonBO.luuHoaDon(user.getId(), Date.valueOf(LocalDate.now()));
		}
		
	
		RequestDispatcher rd = request.getRequestDispatcher("/user/lichsumua.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
