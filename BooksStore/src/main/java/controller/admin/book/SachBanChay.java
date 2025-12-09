package controller.admin.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ThongKeDAO;
import DTO.ThongKeSachBanChay;

/**
 * Servlet implementation class SachBanChay
 */
@WebServlet("/admin/SachBanChay")
public class SachBanChay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThongKeDAO tkDao= new ThongKeDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachBanChay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ThongKeSachBanChay> sachBanChay=tkDao.getSachBanChay();
		request.setAttribute("ds", sachBanChay);
		
		RequestDispatcher rd=request.getRequestDispatcher("/admin/reports/HienThiSachBanChay.jsp");
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
