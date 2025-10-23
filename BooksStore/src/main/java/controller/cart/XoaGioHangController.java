package controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.ChiTietGioHangBO;
import BO.GioHangBO;
import modal.GioHang;
import modal.User;

/**
 * Servlet implementation class XoaGioHangController
 */
@WebServlet("/XoaGioHang")
public class XoaGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChiTietGioHangBO chiTietGioHangBO = new ChiTietGioHangBO();
    GioHangBO gioHangBO = new GioHangBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaGioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		User user= (User) session.getAttribute("userLogin");
		if(user!=null) {
			GioHang gh = gioHangBO.timGioHangByUserId(user.getId());
			if(gh!=null) {
				chiTietGioHangBO.delete(gh.getId(), id);
			}
		}
		response.sendRedirect("/GioHang");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
