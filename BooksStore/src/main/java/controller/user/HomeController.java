package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.LoaiBO;
import BO.SachBO;
import modal.Loai;
import modal.Sach;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
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
		SachBO sachBO = new SachBO();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String mlPrg = request.getParameter("ml");
		String tenSachPrg = request.getParameter("tenSach");
		String pagePrg = request.getParameter("page");
		int rowsPerPage = 10;
		int page = 1;

		if (pagePrg != null) {
			page = Integer.parseInt(pagePrg);
		}
		ArrayList<Sach> ds = null;
		int totalSach = 0;

		if (mlPrg != null) {

			ds = sachBO.getSachByLoai(mlPrg);
			totalSach = ds.size();
		} else if (tenSachPrg != null) {
			ds = sachBO.findByTenSach(tenSachPrg);
			totalSach = ds.size();
		} else {
			ds = sachBO.getSachByPage(page, rowsPerPage);
			totalSach = sachBO.countSach();
		}

	    int totalPages = (int) Math.ceil((double) totalSach / rowsPerPage);

		request.setAttribute("totalPages", totalPages);
		request.setAttribute("curPage", page);
		request.setAttribute("dsl", loaiBO.getAllLoai());

		request.setAttribute("dss", ds);

		RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");

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
