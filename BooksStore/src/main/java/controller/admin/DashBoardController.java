package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.SachBO;
import BO.UserBO;
import DAO.SachDAO;
import DAO.ThongKeDAO;
import DTO.ThongKeNgay;
import DTO.ThongKeSachBanChay;
import modal.User;

/**
 * Servlet implementation class DashBoardController
 */
@WebServlet("/admin") 
public class DashBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThongKeDAO tkDao=new ThongKeDAO();
	
	SachBO sachBO = new SachBO();
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("userLogin")==null) {
			response.sendRedirect("auth?action=login");
			return;
		}else {
			User user=(User)session.getAttribute("userLogin");
			if(user.getRole().getId()==1) {
				response.sendRedirect("/user/accessDenied.jsp");
				return;
			}
		}
		int tongSach=sachBO.getAllSach().size();
		request.setAttribute("sum", tongSach);
		
		int soLuongsachSapHet=sachBO.countSachSapHet();
		request.setAttribute("ssh", soLuongsachSapHet);
		
		
//		long soLuongSahDaHet=sachBO.getSachSapHetHang().stream().filter(s->s.getSoLuong()==0).count();
		request.setAttribute("slhs", 11);
		
		ThongKeNgay tkd= tkDao.getThongKeTheoNgay();
		
		int donHangChuXyLy=tkDao.getSoLuongDonHangChuaXuLy();
		request.setAttribute("tkd", tkd);
		request.setAttribute("slOrder", donHangChuXyLy);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/dashboard.jsp");
		System.err.println("Hello");
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
